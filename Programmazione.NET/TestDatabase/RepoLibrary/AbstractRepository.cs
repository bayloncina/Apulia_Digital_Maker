using System.Data;
using System.Data.SqlClient;

namespace RepoLibrary;

public abstract class AbstractRepository<T> where T : BaseEntity
{
    string connString = "Server=.\\SQLEXPRESS;Database=Protocollo;Trusted_Connection=True;";
    protected abstract string NomeTabella { get; }
    protected abstract string InsertQuery { get; }
    protected abstract string UpdateQuery { get; }
    protected abstract string GetByIdQuery { get; }
    protected abstract void LoadParams(T entity, IDbCommand cmd);
    protected abstract T Materialize(Dictionary<string, object> reader, IDbConnection connection);
    
    #region MetodiProtetti
        protected IDataReader ExecuteQuery(string query, IDbConnection connection, IDbDataParameter[] patameters)
    {
        using IDbCommand cmd = CreaComando(query, connection);
        foreach (var patameter in patameters)
        {
            cmd.Parameters.Add(patameter);
        }
        return cmd.ExecuteReader();
    }
    
    protected void ExecuteNonQuery(string query, 
        IDbConnection connection, 
        IDbDataParameter[] parameters)
    {
        using IDbCommand cmd = CreaComando(query, connection);
        foreach (var patameter in parameters)
        {
            cmd.Parameters.Add(patameter);
        }
        cmd.ExecuteNonQuery();
    }

    protected  IDbCommand CreaComando(string query, IDbConnection conn)
    {
        return new SqlCommand(query, (SqlConnection)conn);
    }

    protected SqlConnection CreaConnessioneEAprila()
    {
        var a =  new SqlConnection(connString);
        OpenConnection(a);
        return a;
    }

    protected void MaterializeList(List<Dictionary<string, object>> readers, IDbConnection connection, out List<T> result)
    {
        result = new List<T>();

        foreach (var reader in readers)
        {
            var baseEntity = Materialize(reader, connection);
            result.Add(baseEntity);
        }
           
        
    }

    protected  void OpenConnection(IDbConnection conn)
    {
        conn.Open();
    }


   

    protected void MaterializeSingle(Dictionary<string, object> reader, IDbConnection connection, out T? baseEntity)
    {
        baseEntity = null;
        if (reader.Count>0)
            baseEntity = Materialize(reader, connection); 
        
    }


    protected SqlParameter CreateParamter(string desc, object entityDescrizione)
    {
        SqlParameter param2 = new SqlParameter();
        param2.ParameterName = desc;
        param2.Value = entityDescrizione;
        return param2;
    }
    
   
    
   
    
    
    protected object ExecuteScalar(string query, IDbConnection connection, T entity)
    {
        using IDbCommand cmd = CreaComando(query, connection);
        LoadParams(entity, cmd);
        return cmd.ExecuteScalar();
    }
    
    
   

    protected void ExecuteNonQueryForUpdate(string query, IDbConnection connection, T entity)
    {
        using IDbCommand cmd = CreaComando(query, connection);
        LoadParams(entity,cmd);
        cmd.Parameters.Add(CreateParamter( "@id", entity.Id));
        cmd.ExecuteNonQuery();
    }
    
    protected void ReleaseResources(IDbConnection conn, IDataReader reader)
    {
        reader?.Close();
        conn?.Close();
    }
    
    #endregion
    
    #region MetodiPubblici
    
    public T GetById(long id)
    { 
        using IDbConnection conn = CreaConnessioneEAprila();

        var entity = EseguiQueryEMaterializzaSingoloOggetto(id, conn);

        ReleaseResources(conn, null);
        
        return entity;
    }

    public T EseguiQueryEMaterializzaSingoloOggetto(long id, IDbConnection conn)
    {
         IDataReader? reader = null;
        try
        {
            reader = ExecuteQuery(GetByIdQuery, conn,
                new IDbDataParameter[] { CreateParamter("@id", id) });

            Dictionary<string, object> data = new Dictionary<string, object>();
            if (reader.Read())
            {
                data = ReaderToDictionary(reader);
            }
            reader.Close();
            MaterializeSingle(data, conn, out var baseEntity);
            
            return baseEntity;
        }
        finally
        {
            reader.Dispose();
        }
    }

    public void Update(T entity)
    {
        using IDbConnection conn = CreaConnessioneEAprila();
        
        ExecuteNonQueryForUpdate(UpdateQuery, conn, entity);
        
        ReleaseResources(conn, null);
        
    }
    
    public long Insert(T entity)
    {
        using IDbConnection conn = CreaConnessioneEAprila();
        
        object id = ExecuteScalar(InsertQuery, conn, entity);
        
        entity.Id = Convert.ToInt64(id.ToString());
        
        PostInsertActions(conn, entity);
        
        ReleaseResources(conn, null);
        return entity.Id;
    }

    protected virtual void PostInsertActions(IDbConnection conn, T entity)
    {
        
    }

    public void Delete(T entity)
    {
        if (entity != null)
            Delete(entity.Id);
    }
    
    public void Delete(long id)
    {
        using IDbConnection conn = CreaConnessioneEAprila();
        
        ExecuteNonQuery(@$"delete from {NomeTabella} where id = @id", conn, 
            new IDbDataParameter[]
            {
                CreateParamter( "@id", id)
            });
        
        ReleaseResources(conn, null);
    }
    
    public List<T> FindAll()
    {
        using IDbConnection conn = CreaConnessioneEAprila();

        var result = ExecuteQueryAndMaterialize(conn, $"SELECT * FROM {NomeTabella}", new IDbDataParameter[0]);
        
        ReleaseResources(conn, null);
        
        return result;
    }
    #endregion


    public List<T> ExecuteQueryAndMaterialize(IDbConnection connection, string query, IDbDataParameter[] parameters)
    {
        using IDataReader reader = ExecuteQuery(query, connection, parameters);
        
        List<Dictionary<string, object>> data = new List<Dictionary<string, object>>();
        while (reader.Read())
        {
            data.Add(ReaderToDictionary(reader));
        }
        
        reader.Close();
       
        
        MaterializeList(data, connection, out var result);
        
        return result;
    }

    private Dictionary<string,object> ReaderToDictionary(IDataReader reader)
    {
        Dictionary<string, object> result = new Dictionary<string, object>();
        for (int i = 0; i < reader.FieldCount; i++)
        {
            result.Add(reader.GetName(i), reader.GetValue(i));
        }

        return result;
    }
}
using System.Data;
using System.Data.SqlClient;
using Domain.Domain;
using RepoLibrary;

namespace Domain.Repositories;

public class DocumentoRepository:AbstractRepository<Documento>
{
    private readonly CausaliRepository _repoCausali;
    private readonly RepositoryOperatore _repoOperatore;
    private readonly ContestoDocumentoRepository _repoContesto;
    private readonly ContattiRepository _repoContatti;
    protected override string NomeTabella { get; } = "Documenti";

    protected override string InsertQuery { get; } =
        $@"INSERT INTO Documenti (Oggetto, IdCausale, IdOperatore, IdContestoDocumento)
            VALUES (@oggetto, @idCausale, @idOperatore, @idContestoDocumento)";

    protected override string UpdateQuery { get; } = @"UPDATE Documenti
                                                        SET Oggetto = @oggetto,
                                                            IdCausale = @idCausale,
                                                            IdOperatore = @idOperatore,
                                                            IdContestoDocumento = @idContestoDocumento
                                                         WHERE Id = @id";

    protected override string GetByIdQuery { get; } = @"SELECT *
                                                        FROM Documenti
                                                        WHERE Id = @id";


    public DocumentoRepository(CausaliRepository repoCausali,
        RepositoryOperatore repoOperatore,
        ContestoDocumentoRepository repoContesto,
        ContattiRepository repoContatti)
    {
        _repoCausali = repoCausali;
        _repoOperatore = repoOperatore;
        _repoContesto = repoContesto;
        _repoContatti = repoContatti;
    }
    
    
    protected override void LoadParams(Documento entity, IDbCommand cmd)
    {
        cmd.Parameters.Add(CreateParamter("@oggetto", entity.Oggetto));
        cmd.Parameters.Add(CreateParamter("@idCausale", entity.Causale.Id));
        cmd.Parameters.Add(CreateParamter("@idOperatore", entity.Operatore.Id));
        cmd.Parameters.Add(CreateParamter("@idContestoDocumento", entity.ContestoDocumento.Id));
    }

    protected override Documento Materialize(Dictionary<string, object> dictonary, IDbConnection connection)
    {
        Documento p = new Documento()
        {
            Id = (long) dictonary["Id"],
            Oggetto = (string) dictonary["Oggetto"],
            Causale = _repoCausali.EseguiQueryEMaterializzaSingoloOggetto((long) dictonary["IdCausale"], connection),
            Operatore = _repoOperatore.EseguiQueryEMaterializzaSingoloOggetto((long) dictonary["IdOperatore"], connection),
            ContestoDocumento = _repoContesto.EseguiQueryEMaterializzaSingoloOggetto((long) dictonary["IdContestoDocumento"], connection),
            Contatti = MaterializzaContatti((long) dictonary["Id"], connection)
        };
        return p;
    }

    private List<Contatto> MaterializzaContatti(long idDocumento, IDbConnection connection)
    {
        return _repoContatti.ExecuteQueryAndMaterialize(connection, $@"SELECT Contatti.*
                                                FROM Contatti JOIN DocumentiPerContatto ON Contatti.Id = DocumentiPerContatto.IdContatto
                                                WHERE IdDocumento = {idDocumento}", new IDbDataParameter[0]);
    }


    protected override void PostInsertActions(IDbConnection connection, Documento entity)
    {
        string insertIniziale = @"INSERT INTO DocumentiPerContatto (IdDocumento, IdContatto)
                                    VALUES";

        foreach (var contatto in entity.Contatti)
        {
            var query = insertIniziale + $" ({entity.Id}, {contatto.Id})";
            var cmd = CreaComando(query, connection);
            cmd.ExecuteNonQuery();
            cmd.Dispose();
            cmd = null;
        }
    }

    public void AssociaDocumentoEContatto(long idDocumento, long idContatto)
    {
        string insertIniziale = @"INSERT INTO DocumentiPerContatto (IdDocumento, IdContatto)
                                    VALUES (@idDocumento, @idContatto)";

        using (SqlConnection conn = new SqlConnection())
        {
            conn.Open();

            var cmd = conn.CreateCommand();

            cmd.Parameters.Add(CreateParamter("@idDocumento", idDocumento));
            cmd.Parameters.Add(CreateParamter("@idContatto", idContatto));

            cmd.ExecuteNonQuery();
            cmd.Dispose();
            cmd = null;
        }
    }
}
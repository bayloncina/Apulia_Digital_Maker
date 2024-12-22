using System.Data;
using Domain.Domain;
using RepoLibrary;

namespace Domain.Repositories;

public class ContatoreRepository: AbstractRepository<Contatore>
{
    protected override string GetByIdQuery { get; } =  @"select Id, Valore from Contatore   where Id = 1";
    protected override string NomeTabella { get; } = "Contatore";
    protected override string InsertQuery { get; } = @"INSERT INTO Contatore
           (Valore) VALUES (@val); SELECT SCOPE_IDENTITY()";

    protected override string UpdateQuery { get; } = @"update Contatore set Valore = @val where Id = 1";

    protected override void LoadParams(Contatore entity, IDbCommand cmd)
    {
        cmd.Parameters.Add(CreateParamter("@val", entity.Valore));
       
    }

    

    protected override Contatore Materialize(Dictionary<string, object> dictonary, IDbConnection connection)
    {
        Contatore p = new Contatore()
        {
            Id = (long) dictonary["Id"],
            Valore = (int) dictonary["Valore"],
           
        };
        return p;
    }
}
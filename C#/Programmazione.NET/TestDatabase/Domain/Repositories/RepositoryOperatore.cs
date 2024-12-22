using System.Data;
using Domain.Domain;
using RepoLibrary;

namespace Domain.Repositories;

public class RepositoryOperatore: AbstractRepository<Operatore>
{
    protected override string GetByIdQuery { get; }= @"select Id, Descrizione, CodiceProtocollo from Operatori   where Id = @id";
    
    protected override string NomeTabella { get; } = "Operatori";

    protected override string InsertQuery { get; } = @"INSERT INTO Operatori
           (Descrizione,CodiceProtocollo)
                                     VALUES
                                           (@desc
                                           ,@cod); SELECT SCOPE_IDENTITY()";

    protected override string UpdateQuery { get; } = @"update Operatori set Descrizione = @desc, CodiceProtocollo = @cod where Id = @id";

    protected override void LoadParams(Operatore entity, IDbCommand cmd)
    {
        Operatore operatore = (Operatore) entity;
        cmd.Parameters.Add(CreateParamter("@desc", operatore.Descrizione));
        cmd.Parameters.Add(CreateParamter("@cod", operatore.CodiceProtocollo));
    }
    
    protected override Operatore Materialize(Dictionary<string, object> dictonary, IDbConnection connection)
    {
        Operatore p = new Operatore()
        {
            Id = (long) dictonary["Id"],
            Descrizione = (string) dictonary["Descrizione"],
            CodiceProtocollo = (string) dictonary["CodiceProtocollo"]
        };
        return p;
    }
}
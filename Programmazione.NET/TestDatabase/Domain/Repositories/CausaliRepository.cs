using System.Data;
using Domain.Domain;
using RepoLibrary;

namespace Domain.Repositories;

public class CausaliRepository: AbstractRepository<Causale>
{
    protected override string GetByIdQuery { get; } =  @"select Id, Descrizione, CodiceProtocollo from Causali   where Id = @id";
    protected override string NomeTabella { get; } = "Causali";
    protected override string InsertQuery { get; } = @"INSERT INTO Causali
           (Descrizione,CodiceProtocollo)
                                     VALUES
                                           (@desc
                                           ,@cod); SELECT SCOPE_IDENTITY()";

    protected override string UpdateQuery { get; } = @"update Causali set Descrizione = @desc, CodiceProtocollo = @cod where Id = @id";

    protected override void LoadParams(Causale entity, IDbCommand cmd)
    {
        cmd.Parameters.Add(CreateParamter("@desc", entity.Descrizione));
        cmd.Parameters.Add(CreateParamter("@cod", entity.CodiceProtocollo));
    }

    

    protected override Causale Materialize(Dictionary<string, object> dictonary, IDbConnection connection)
    {
        Causale p = new Causale()
        {
            Id = (long) dictonary["Id"],
            Descrizione = (string) dictonary["Descrizione"], 
            CodiceProtocollo = (string) dictonary["CodiceProtocollo"]
        };
        return p;
    }
    
}
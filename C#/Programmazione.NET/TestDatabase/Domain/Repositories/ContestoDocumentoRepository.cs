using System.Data;
using Domain.Domain;
using RepoLibrary;

namespace Domain.Repositories;

public class ContestoDocumentoRepository: AbstractRepository<ContestoDocumento>
{
    protected override string GetByIdQuery { get; } = @"select Id, Descrizione, CodiceProtocollo, Responsabile, CodiceProtocolloResponsabile from ContestoDocumento where Id = @id";

    protected override string NomeTabella { get; } = "ContestoDocumento";

    protected override string InsertQuery { get; } = @"INSERT INTO ContestoDocumento
           (Descrizione, CodiceProtocollo, Responsabile, CodiceProtocolloResponsabile)
           VALUES (@desc, @cod, @responsabile, @codiceProtocolloResponsabile); 
           SELECT SCOPE_IDENTITY()";

    protected override string UpdateQuery { get; } =
        @"UPDATE ContestoDocumento 
           SET Descrizione = @desc, 
               CodiceProtocollo = @cod, 
               Responsabile = @responsabile, 
               CodiceProtocolloResponsabile = @codiceProtocolloResponsabile 
           WHERE Id = @id";

    
    protected override ContestoDocumento Materialize(Dictionary<string, object> dictonary, IDbConnection connection)
    {
        ContestoDocumento p = new ContestoDocumento()
        {
            Id = (long) dictonary["Id"],
            Descrizione = (string) dictonary["Descrizione"],
            CodiceProtocollo = (string) dictonary["CodiceProtocollo"],
            Responsabile = (string) dictonary["Responsabile"],
            CodiceProtocolloResponsabile = (string) dictonary["CodiceProtocolloResponsabile"]
        };
        return p;
    }

  
    protected override void LoadParams(ContestoDocumento entity, IDbCommand cmd)
    {
        ContestoDocumento contestoDocumento = (ContestoDocumento) entity;
        cmd.Parameters.Add(CreateParamter("@desc", contestoDocumento.Descrizione));
        cmd.Parameters.Add(CreateParamter("@cod", contestoDocumento.CodiceProtocollo));
        cmd.Parameters.Add(CreateParamter("@responsabile", contestoDocumento.Responsabile));
        cmd.Parameters.Add(CreateParamter("@codiceProtocolloResponsabile", contestoDocumento.CodiceProtocolloResponsabile));
    }
}
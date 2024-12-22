using System.Data;
using Domain.Domain;
using RepoLibrary;

namespace Domain.Repositories;

public class ContattiRepository: AbstractRepository<Contatto>
{
    protected override string NomeTabella { get; } = "Contatti";

    protected override string InsertQuery { get; } = @"INSERT INTO Contatti (Nome, Cognome, NumeroDiTelefono)
                                                        VALUES (@nome, @cognome, @numeroDiTelefono); SELECT SCOPE_IDENTITY()";

    protected override string UpdateQuery { get; } = @"UPDATE Contatti
                                                        SET Nome = @nome,
                                                            Cognome = @cognome,
                                                            NumeroDiTelefono = @numeroDiTelefono";

    protected override string GetByIdQuery { get; } = @"SELECT *
                                                        FROM Contatti
                                                        WHERE Id = @id";
    protected override void LoadParams(Contatto entity, IDbCommand cmd)
    {
        cmd.Parameters.Add(CreateParamter("@nome", entity.Nome));
        cmd.Parameters.Add(CreateParamter("@cognome", entity.Cognome));
        cmd.Parameters.Add(CreateParamter("@numeroDiTelefono", entity.NumeroDiTelefono));
    }

    protected override Contatto Materialize(Dictionary<string, object> dictonary, IDbConnection connection)
    {
        var result = new Contatto()
        {
            Id = (long) dictonary["Id"],
            Nome = (string) dictonary["Nome"],
            Cognome = (string) dictonary["Cognome"],
            NumeroDiTelefono = (string) dictonary["NumeroDiTelefono"]
        };

        return result;
    }
}
using RepoLibrary;

namespace Domain.Domain;

public class Contatto: BaseEntity
{
    public string Nome { get; set; }
    public string Cognome { get; set; }
    public string NumeroDiTelefono { get; set; }
}
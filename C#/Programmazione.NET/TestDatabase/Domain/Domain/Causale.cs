using RepoLibrary;

namespace Domain.Domain;


public class Causale:BaseEntity
{
   
    public string Descrizione { get; set; }
    public string CodiceProtocollo { get; set; }
}
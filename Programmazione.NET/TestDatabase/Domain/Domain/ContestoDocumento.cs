using RepoLibrary;

namespace Domain.Domain;

public class ContestoDocumento:BaseEntity
{
   
    public string Descrizione { get; set; }
    public string CodiceProtocollo { get; set; }
    public string Responsabile { get; set; }
    public string CodiceProtocolloResponsabile { get; set; }
}
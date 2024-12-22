namespace Domain.Services;

public class DocumentoRequest
{
    public string Oggetto { get; set; }
    public long CausaleId { get; set; }
    public long ContestoDocumentoId { get; set; }
    public long OperatoreId { get; set; }
    public List<long> ContattiIds { get; set; }
}
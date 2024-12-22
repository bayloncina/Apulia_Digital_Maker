namespace DocumentiWebApi.Dtos;

public class DocumentoInsertDto
{
    public string Oggetto { get; set; }
    public long IdCausale { get; set; }
    public long IdContestoDocumento { get; set; }
    public long IdOperatore { get; set; }
    public List<long> IdContatti { get; set; }
}
namespace DocumentiWebApi.Dtos;

public class DocumentoDto
{
    public string Oggetto { get; set; }
    public CausaleDto Causale { get; set; }
    public ContestoDocumentoDto ContestoDocumento { get; set; }
    public OperatoreDto Operatore { get; set; }
    public List<ContattoDto> Contatti { get; set; }
}
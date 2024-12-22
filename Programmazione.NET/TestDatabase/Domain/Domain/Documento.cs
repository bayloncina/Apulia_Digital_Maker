using RepoLibrary;

namespace Domain.Domain;

public class Documento: BaseEntity
{
    public string Oggetto { get; set; }
    public Causale Causale { get; set; }
    public ContestoDocumento ContestoDocumento { get; set; }
    public Operatore Operatore { get; set; }
    public List<Contatto> Contatti { get; set; }

    public string Protocollo => _protocollo;

    private string _protocollo;
    
    internal void ApponiProtocollo(int numeroProgressivo)
    {
        if (!string.IsNullOrEmpty(_protocollo))
        {
            throw new InvalidOperationException("Documento già protocollato");
            
        }

        CalcolaProtocollo(numeroProgressivo);
    }

    private void CalcolaProtocollo(int numeroProgressivo)
    {
        _protocollo = $"{Causale.CodiceProtocollo}/{numeroProgressivo}/{ContestoDocumento.CodiceProtocollo}/{ContestoDocumento.CodiceProtocolloResponsabile}/{Operatore.CodiceProtocollo}";
    }
}
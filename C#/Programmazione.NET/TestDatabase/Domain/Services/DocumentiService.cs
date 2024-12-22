using System.Data.SqlClient;
using Domain.Domain;
using Domain.Repositories;

namespace Domain.Services;

public class DocumentiService
{
    private readonly DocumentoRepository _documentoRepository;
    private readonly ContatoreRepository _contatoreRepository;
    private readonly ContatoreService _contatoreService;
    private readonly CausaliRepository _causaliRepository;
    private readonly RepositoryOperatore _operatoreRepository;
    private readonly ContestoDocumentoRepository _contestoDocumentoRepository;
    private readonly ContattiRepository _contattiRepository;
    private object _locker = new object();

    public DocumentiService(DocumentoRepository documentoRepository,
        ContatoreRepository contatoreRepository,
        ContatoreService contatoreService,
        CausaliRepository causaliRepository,
        RepositoryOperatore operatoreRepository,
        ContestoDocumentoRepository contestoDocumentoRepository,
        ContattiRepository contattiRepository
        )
    {
        _documentoRepository = documentoRepository;
        _contatoreRepository = contatoreRepository;
        _contatoreService = contatoreService;
        _causaliRepository = causaliRepository;
        _operatoreRepository = operatoreRepository;
        _contestoDocumentoRepository = contestoDocumentoRepository;
        _contattiRepository = contattiRepository;
    }


    public string RichiediProtocollazione(long idDocumento)
    {
        Documento d = _documentoRepository.GetById(idDocumento);
        int numProgr = _contatoreService.CalcolaProgressivoSuccessivo(_contatoreRepository);
        d.ApponiProtocollo(numProgr);
        _documentoRepository.Update(d);
        
        return d.Protocollo;
    }

    

    public Documento InserisciDocumento(DocumentoRequest dto)
    {
        Causale c = _causaliRepository.GetById(dto.CausaleId);
        Operatore o = _operatoreRepository.GetById(dto.OperatoreId);
        ContestoDocumento cd = _contestoDocumentoRepository.GetById(dto.ContestoDocumentoId);
        
        List<Contatto> listaContatti = new List<Contatto>();
        foreach (var idContatto in dto.ContattiIds)
        {
            listaContatti.Add(_contattiRepository.GetById(idContatto));
        }


        Documento nuovo = new Documento()
        {
            Oggetto = dto.Oggetto,
            Causale = c,
            Operatore = o,
            ContestoDocumento = cd,
            Contatti = listaContatti
        };


        var id =_documentoRepository.Insert(nuovo);
        nuovo.Id = id;
        return nuovo;
    }


    public Documento? AggiornaDocumento(long idDocumento, DocumentoRequest doc)
    {
        try
        {
            Causale c = _causaliRepository.GetById(doc.CausaleId);
            ContestoDocumento cd = _contestoDocumentoRepository.GetById(doc.ContestoDocumentoId);
            Operatore o = _operatoreRepository.GetById(doc.OperatoreId);
            List<Contatto> listaContatti = new List<Contatto>();

            foreach (var idContatto in doc.ContattiIds)
            {
                listaContatti.Add(_contattiRepository.GetById(idContatto));
            }

            Documento aggiornato = new Documento()
            {
                Id = idDocumento,
                Oggetto = doc.Oggetto,
                Causale = c,
                ContestoDocumento = cd,
                Operatore = o,
                Contatti = listaContatti
            };
            
            _documentoRepository.Update(aggiornato);

            return aggiornato;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
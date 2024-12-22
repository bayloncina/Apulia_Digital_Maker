using Domain.Domain;
using Domain.Repositories;

namespace Domain.Services;

public class ContattiService
{
    private readonly ContattiRepository _contattiRepository;
    private readonly DocumentoRepository _documentoRepository;


    public ContattiService(ContattiRepository contattiRepository, DocumentoRepository documentoRepository)
    {
        _contattiRepository = contattiRepository;
        _documentoRepository = documentoRepository;
    }


    public void AggiungiContattoADocumento(long idDocumento, Contatto contatto)
    {
        long idContatto = _contattiRepository.Insert(contatto);
        _documentoRepository.AssociaDocumentoEContatto(idDocumento, idContatto);
    }

    public void CancellaContatto(long idContatto)
    {
        _contattiRepository.Delete(idContatto);
    }
}
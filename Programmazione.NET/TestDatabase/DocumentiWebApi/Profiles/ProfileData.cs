using AutoMapper;
using DocumentiWebApi.Dtos;
using Domain.Domain;

namespace DocumentiWebApi.Profiles;

public class ProfileData:Profile
{
    public ProfileData()
    {
        CreateMap<Causale, CausaleDto>();
        CreateMap<CausaleDto, Causale>();

        CreateMap<Contatto, ContattoDto>();
        CreateMap<ContattoDto, Contatto>();
        
        CreateMap<ContestoDocumento, ContestoDocumentoDto>();
        CreateMap<ContestoDocumentoDto, ContestoDocumento>();
        
        CreateMap<Documento, DocumentoDto>();
        
        
        CreateMap<Operatore, OperatoreDto>();
        CreateMap<OperatoreDto, Operatore>();
    }
}
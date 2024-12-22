using AutoMapper;
using DocumentiWebApi.Dtos;
using Domain.Domain;
using Domain.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace DocumentiWebApi.Endpoints;

public class ContestiDocumentiEndpoints
{
    public static void AggiungiEndpoints(WebApplication app)
    {
        app.MapGet("/contestodocumento", ([FromServices]ContestoDocumentoRepository repo,
                [FromServices] IMapper mapper) =>
            {
                return mapper.Map<List<ContestoDocumentoDto>>(repo.FindAll() as List<ContestoDocumento>);
            })
            .WithOpenApi();
        
        app.MapGet("/contestodocumento/{id}", ([FromServices]ContestoDocumentoRepository repo,
                [FromServices] IMapper mapper, [FromRoute] long id) =>
            {
                return mapper.Map<ContestoDocumentoDto>(repo.GetById(id));
            })
            .WithOpenApi();

        app.MapPost("/contestodocumento", ([FromBody] ContestoDocumentoDto dto,
                [FromServices] ContestoDocumentoRepository repo,
                [FromServices] IMapper mapper) =>
            {
                ContestoDocumento c = mapper.Map<ContestoDocumento>(dto);
                repo.Insert(c);
                return mapper.Map<ContestoDocumentoDto>(c);
            })
            .WithOpenApi();  
        
        app.MapDelete("/contestodocumento/{id}", ([FromServices] ContestoDocumentoRepository repo,
                [FromRoute] long id) =>
            {
                var contestodocumento = repo.GetById(id);
                if (contestodocumento == null)
                {
                    return Results.NotFound();
                }

                repo.Delete(contestodocumento);
                return Results.NoContent();
            })
            .WithOpenApi();
        
        app.MapPut("/contestodocumento/{id}", ([FromBody] ContestoDocumentoDto dto,
                [FromServices] ContestoDocumentoRepository repo,
                [FromRoute] long id,
                [FromServices] IMapper mapper) =>
            {
                ContestoDocumento c = mapper.Map<ContestoDocumento>(dto);
                repo.Update(c);
                return mapper.Map<ContestoDocumentoDto>(c);
            })
            .WithOpenApi();
      
    }
}
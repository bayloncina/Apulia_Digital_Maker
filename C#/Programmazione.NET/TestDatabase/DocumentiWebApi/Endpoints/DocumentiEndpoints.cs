using AutoMapper;
using DocumentiWebApi.Dtos;
using Domain.Domain;
using Domain.Repositories;
using Domain.Services;
using Microsoft.AspNetCore.Mvc;

namespace DocumentiWebApi.Endpoints;

public class DocumentiEndpoints
{
    public static void AggiungiEndpoints(WebApplication app)
    {
        app.MapGet("/documenti", ([FromServices]DocumentoRepository repo,
                [FromServices] IMapper mapper) =>
            {
                return mapper.Map<List<DocumentoDto>>(repo.FindAll() as List<Documento>);
            })
            .WithOpenApi();
        
        app.MapGet("/documenti/{id}", ([FromServices]DocumentoRepository repo,
                [FromServices] IMapper mapper, [FromRoute] long id) =>
            {
                return mapper.Map<DocumentoDto>(repo.GetById(id));
            })
            .WithOpenApi();

        app.MapPost("/documenti", ([FromBody] DocumentoRequest dto,
                [FromServices] DocumentoRepository repo,
                [FromServices] IMapper mapper, [FromServices]DocumentiService doc) =>
            {
                var result = doc.InserisciDocumento(dto);
                return Results.Ok(result);
            })
            .WithOpenApi(); 
        
        
        app.MapDelete("/documenti/{id}", ([FromServices] DocumentoRepository repo,
                [FromRoute] long id) =>
            {
                var documento = repo.GetById(id);
                if (documento == null)
                {
                    return Results.NotFound();
                }

                repo.Delete(documento);
                return Results.NoContent();
            })
            .WithOpenApi();
        
        app.MapPut("/documenti/{id}", ([FromBody] DocumentoRequest dto,
                [FromServices] DocumentoRepository repo,
                [FromServices] DocumentiService doc,
                [FromRoute] long id,
                [FromServices] IMapper mapper) =>
            {
                var result = doc.AggiornaDocumento(id, dto);
                if (result == null)
                {
                    return Results.NotFound();
                }

                return Results.Ok(result);
            })
            .WithOpenApi();

        app.MapPost("/documenti/{id}/protocollo", ([FromServices] DocumentiService doc,
                [FromRoute] long id) =>
            {
                var result = doc.RichiediProtocollazione(id);
                return Results.Ok(result);
            });
            
        }
      
    
}
using AutoMapper;
using DocumentiWebApi.Dtos;
using Domain.Domain;
using Domain.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace DocumentiWebApi.Endpoints;

public class ContattiEndpoints
{
    public static void AggiungiEndpoints(WebApplication app)
    {
        app.MapGet("/contatti", ([FromServices]ContattiRepository repo,
                [FromServices] IMapper mapper) =>
            {
                return mapper.Map<List<ContattoDto>>(repo.FindAll() as List<Contatto>);
            })
            .WithOpenApi();
        
        app.MapGet("/contatti/{id}", ([FromServices]ContattiRepository repo,
                [FromServices] IMapper mapper, [FromRoute] long id) =>
            {
                return mapper.Map<ContattoDto>(repo.GetById(id));
            })
            .WithOpenApi();

        app.MapPost("/contatti", ([FromBody] ContattoDto dto,
                [FromServices] ContattiRepository repo,
                [FromServices] IMapper mapper) =>
            {
                Contatto c = mapper.Map<Contatto>(dto);
                repo.Insert(c);
                return mapper.Map<ContattoDto>(c);
            })
            .WithOpenApi();  
        
        
        app.MapDelete("/contatti/{id}", ([FromServices] ContattiRepository repo,
                [FromRoute] long id) =>
            {
                var contatto = repo.GetById(id);
                if (contatto == null)
                {
                    return Results.NotFound();
                }

                repo.Delete(contatto);
                return Results.NoContent();
            })
            .WithOpenApi();
        
        app.MapPut("/contatti/{id}", ([FromBody] ContattoDto dto,
                [FromServices] ContattiRepository repo,
                [FromRoute] long id,
                [FromServices] IMapper mapper) =>
            {
                Contatto c = mapper.Map<Contatto>(dto);
                repo.Update(c);
                return mapper.Map<CausaleDto>(c);
            })
            .WithOpenApi();
      
    }
}
using AutoMapper;
using DocumentiWebApi.Dtos;
using Domain.Domain;
using Domain.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace DocumentiWebApi;

public class CausaliEndpoints
{
    public static void AggiungiEndpoints(WebApplication app)
    {
        app.MapGet("/causali", ([FromServices]CausaliRepository repo,
            [FromServices] IMapper mapper) =>
            {
                return mapper.Map<List<CausaleDto>>(repo.FindAll() as List<Causale>);
            })
            .WithOpenApi();
        
        app.MapGet("/causali/{id}", ([FromServices]CausaliRepository repo,
                [FromServices] IMapper mapper, [FromRoute] long id) =>
            {
                return mapper.Map<CausaleDto>(repo.GetById(id));
            })
            .WithOpenApi();

        app.MapPost("/causali", ([FromBody] CausaleDto dto,
            [FromServices] CausaliRepository repo,
            [FromServices] IMapper mapper) =>
        {
              Causale c = mapper.Map<Causale>(dto);
              repo.Insert(c);
             return mapper.Map<CausaleDto>(c);
        })
            .WithOpenApi();  
        
        app.MapDelete("/causali/{id}", ([FromServices] CausaliRepository repo,
                [FromRoute] long id) =>
            {
                var causale = repo.GetById(id);
                if (causale == null)
                {
                    return Results.NotFound();
                }

                repo.Delete(causale);
                return Results.NoContent();
            })
            .WithOpenApi();
        
        app.MapPut("/causali/{id}", ([FromBody] CausaleDto dto,
                [FromServices] CausaliRepository repo,
                [FromRoute] long id,
                [FromServices] IMapper mapper) =>
            {
                Causale c = mapper.Map<Causale>(dto);
                repo.Update(c);
                return mapper.Map<CausaleDto>(c);
            })
            .WithOpenApi();
        
        
      
    }
}
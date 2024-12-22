using AutoMapper;
using DocumentiWebApi.Dtos;
using Domain.Domain;
using Domain.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace DocumentiWebApi.Endpoints;

public class OperatoriEndpoints
{
    public static void AggiungiEndpoints(WebApplication app)
    {
        app.MapGet("/operatore", ([FromServices]RepositoryOperatore repo,
                [FromServices] IMapper mapper) =>
            {
                return mapper.Map<List<OperatoreDto>>(repo.FindAll() as List<Operatore>);
            })
            .WithOpenApi();
        
        app.MapGet("/operatore/{id}", ([FromServices]RepositoryOperatore repo,
                [FromServices] IMapper mapper, [FromRoute] long id) =>
            {
                return mapper.Map<OperatoreDto>(repo.GetById(id));
            })
            .WithOpenApi();

        app.MapPost("/operatore", ([FromBody] OperatoreDto dto,
                [FromServices] RepositoryOperatore repo,
                [FromServices] IMapper mapper) =>
            {
                Operatore c = mapper.Map<Operatore>(dto);
                repo.Insert(c);
                return mapper.Map<OperatoreDto>(c);
            })
            .WithOpenApi(); 
        
        app.MapDelete("/operatore/{id}", ([FromServices] RepositoryOperatore repo,
                [FromRoute] long id) =>
            {
                var operatore = repo.GetById(id);
                if (operatore == null)
                {
                    return Results.NotFound();
                }

                repo.Delete(operatore);
                return Results.NoContent();
            })
            .WithOpenApi();
        
        app.MapPut("/operatore/{id}", ([FromBody] OperatoreDto dto,
                [FromServices] RepositoryOperatore repo,
                [FromRoute] long id,
                [FromServices] IMapper mapper) =>
            {
                Operatore c = mapper.Map<Operatore>(dto);
                repo.Update(c);
                return mapper.Map<OperatoreDto>(c);
            })
            .WithOpenApi();
      
    }
}
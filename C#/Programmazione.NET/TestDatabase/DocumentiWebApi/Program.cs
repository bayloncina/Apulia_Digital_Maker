using DocumentiWebApi;
using DocumentiWebApi.Endpoints;
using Domain.Repositories;
using Domain.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddScoped<ContattiRepository>();
builder.Services.AddScoped<DocumentoRepository>();
builder.Services.AddScoped<ContestoDocumentoRepository>();
builder.Services.AddScoped<RepositoryOperatore>();
builder.Services.AddScoped<CausaliRepository>();
builder.Services.AddScoped<DocumentiService>();
builder.Services.AddScoped<ContatoreRepository>();
builder.Services.AddSingleton<ContatoreService>();


builder.Services.AddAutoMapper(typeof(Program).Assembly);

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();



CausaliEndpoints.AggiungiEndpoints(app);
//ARCANO QUI
ContattiEndpoints.AggiungiEndpoints(app);
ContestiDocumentiEndpoints.AggiungiEndpoints(app);
OperatoriEndpoints.AggiungiEndpoints(app);
DocumentiEndpoints.AggiungiEndpoints(app);

app.Run();


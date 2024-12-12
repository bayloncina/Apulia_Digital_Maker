// See https://aka.ms/new-console-template for more information

using ConsoleApp1;

Console.WriteLine("Hello, World!");

Biblioteca biblioteca = new Biblioteca();
biblioteca.LibriPresenti.Add(new Libro()

{
    ID = 1,
    Titolo = "La vita è bella",
    Autore = "Benigni",
    InPrestito = false
});
biblioteca.LibriPresenti.Add(new Libro()
{
    ID = 2 ,
    Titolo = "Il signore degli anelli",
    Autore = "Tolkien",
    InPrestito = false
});

biblioteca.LibriPresenti.Add(new Libro()
{
    ID = 3 ,
    Titolo = "Guerra e Pace",
    Autore = "Tolstoj",
    InPrestito = false
});

biblioteca.LibriPresenti.Add(new Libro()
{
    ID = 4 ,
    Titolo = "Le armi della Persuasione",
    Autore = "Roberto Cialdini",
    InPrestito = false
});
do
{
    Console.WriteLine(@"Che operazione vuoi effetture?
1. Per Registra nuovo libro
2. ");
    
}
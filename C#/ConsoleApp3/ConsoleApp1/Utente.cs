namespace ConsoleApp1;

public class Utente
{
    public string Nome { get; set;}

    public string Cognome { get; set; }
    public int ID { get; set; }
    public List<Libro> libriInPrestito { get; set; }
}
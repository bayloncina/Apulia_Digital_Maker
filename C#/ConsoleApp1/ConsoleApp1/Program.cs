// See https://aka.ms/new-console-template for more information

List<int> intlist = new List<int>();

intlist.Add(1);

bool contiene = intlist.Contains(1);
Console.WriteLine(contiene);

List<Persona> ll = new List<Persona>()
{
    new Persona()
    {
        Cognome = "Randazzo",
        Nome = "Francesco"
    }
};

ll.Add(new Persona());

List<Persona> ll1 = new List<Persona>()
    ;

public class Persona
{
    public string Cognome { get; set; }
    public string Nome { get; set; }
    
}



   
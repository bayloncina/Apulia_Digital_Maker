// See https://aka.ms/new-console-template for more information

//Ho una lista di persone con attributi: nome, cognome e anno di nascita.
//devo ordinare la lista dal più piccolo al più grande


//Ho una lista di numeri interi dividerla in tre segmenti:
//Segmento Positivi: Contiene tutti i numeri positivi.
//Segmento Negativi: Contiene tutti i numeri negativi.
//Segmento Zero: Contiene tutti gli zeri.

Console.WriteLine("Hello, World!");


List<int> intlist = new List<int>();
intlist.Add(1);
intlist.Add(5);
intlist.Add(23);
intlist.Add(4);
intlist.Add(67);

//restituisce il valore maggiore della lista
int valoreMaggiore = intlist.Max();

//Slice vuole l'indice da cui partire e quanti elementi deve prendere
List<int> primiTre = intlist.Slice( 0,  3);

//il forEach vuole il primo valore Action e successivamente quello che deve fare
primiTre.ForEach(a => Console.WriteLine(primiTre));



List<Persona> persone = new List<Persona>();
persone.Add(new Persona(){Nome = "Miriam", Eta = 31});
persone.Add(new Persona(){Nome = "Giorgio", Eta = 17});
persone.Add(new Persona(){Nome = "Zoe", Eta = 15});
persone.Add(new Persona(){Nome = "fabio", Eta = 21});


persone.Where(a => a.Eta <= 25);


public class Persona
{
  public string Nome { get; set; }
  public string Eta { get; set; }
}

var groups = intlist.GroupBy(a => a <= 2);
foreach (var group in groups)
{
  Console.WriteLine(group.Key);
  foreach (var elem in group)
  {
    Console.WriteLine(elem);
  }
}

//List<Persona> persone = new Persona();

//persone.Add("Francesco", );
//public class Persona
//{
  //public string Nome { get; set; }
  //public string Cognome { get; set; }
//}
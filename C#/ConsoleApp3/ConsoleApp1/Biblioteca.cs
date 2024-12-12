namespace ConsoleApp1;

public class Biblioteca
{
    public List<Libro> LibriPresenti = new List<Libro>();
    public List<Utente> Utentiregistrati = new List<Utente>();
    
    
    //registrare prestito

    void RegistraPrestito(int idUtente, int idLibro)
    {
        Utente  utenteTrovato = Utentiregistrati
            .FirstOrDefault(utente => utente.ID == idUtente);
        Libro libroTrovato = LibriPresenti
            .FirstOrDefault(libro => libro.ID == idLibro);

        if (utenteTrovato == null || libroTrovato == null)
        {
            throw new ArgumentException();
        }

        if (libroTrovato.InPrestito == true)
        {
            throw new Exception("Libro già in prestito");

        }
        utenteTrovato.libriInPrestito.Add(libroTrovato);
        libroTrovato.InPrestito = true;

    }

    void RegistraRestituzione(int idUtente, int idLibro)

    {
        Utente  utenteTrovato = Utentiregistrati
            .FirstOrDefault(utente => utente.ID == idUtente);
        Libro libroTrovato = LibriPresenti
            .FirstOrDefault(libro => libro.ID == idLibro);

        if (utenteTrovato == null || libroTrovato == null)
        {
            throw new ArgumentException();
        }

        if (libroTrovato.InPrestito && utenteTrovato.libriInPrestito.Contains(libroTrovato))
        {
            utenteTrovato.libriInPrestito.Remove(libroTrovato);
            libroTrovato.InPrestito = false;

        }
        else
        {
            throw new Exception("aaaa");
        }
       

        
        
    }

    void RegistraNuovoLibro(Libro libro )
    {
        if (LibriPresenti.Contains(libro))
        {
            throw new ArgumentException();
        } LibriPresenti.Add(libro);
            

    }
    
    List<Libro> RicercaLibroPerLibroEautore (string testoDiRicerca)
    {
        return LibriPresenti
            .Where(libr => libr.Titolo.Contains(testoDiRicerca)
                           || libr.Autore.Contains(testoDiRicerca)).ToList();
    }
    

    void RegistraNuovoUtente(Utente utente)
    {
        if (Utentiregistrati.Contains(utente))
        {
            throw new ArgumentException();
        } Utentiregistrati.Add(utente);
        
    }
    
}
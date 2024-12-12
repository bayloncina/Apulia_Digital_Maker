import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable {
    private String username, password;
    private ArrayList<Articolo> listaPrestito = new ArrayList<Articolo>();
//COSTRUTTORE UTENTE
    public Utente(String username, String password){
        this.username = username;
        this.password = password;
    }

//METODI AGGIUNGI PRESTITO - RIMUOVI PRESTITO - GET USERNAME E PASSWORD - VISUALIZZA ARTICOLI IN PRESTITO
    public void aggiungiPrestito(Articolo articolo){
        this.listaPrestito.add(articolo);
    }

    public void rimuoviPrestito(Articolo articolo){
        this.listaPrestito.remove(articolo);
    }

    public void stampaPrestiti(){
        for(Articolo articolo : listaPrestito){
            System.out.println("Titolo: " + articolo.getTitolo() + "|" + "Autore: " + articolo.getAutore() + "\n");
        }
    }

    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
//IMPLEMENTS SERIALIZABLE SERVE PER POTER TRASFORMARE L'INTERO OGGETTO IN UN FILE
public class Biblioteca implements Serializable {

    private Integer contPosizioneLibri = 1, contPosizioneFilm = 1, contPosizioneAtlanti = 1;
    private ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();


    public Biblioteca(){}

    public void registraUtente(String username, String password) {
        Utente utente = new Utente(username, password);
        this.listaUtenti.add(utente);
    }

    public void ricercaArticolo(String titolo, String autore) {

        for (int i = 0; i < listaArticoli.size(); i++) {
            if (titolo.equals(listaArticoli.get(i).getTitolo())) {
                System.out.println("È stato individuato un risultato");
                System.out.println("Titolo:");
                System.out.println(this.listaArticoli.get(i).getTitolo());
                System.out.println("Autore:");
                System.out.println(this.listaArticoli.get(i).getAutore());
                System.out.println("Casa Editrice:");
                System.out.println(this.listaArticoli.get(i).getCasaEditrice());
                System.out.println("Codice:");
                System.out.println(this.listaArticoli.get(i).getCodice());
                System.out.println("Anno:");
                System.out.println(this.listaArticoli.get(i).getAnno());
                System.out.println("Posizione in Biblioteca:");
                System.out.println(this.listaArticoli.get(i).getPosizione());
                System.out.println("Disponibilità");
                if (this.listaArticoli.get(i).getDisponibile()) {
                    System.out.println("Disponibile");
                } else {
                    System.out.println("Non disponibile");
                }
            }
        }
    }


    public Articolo cerca(String posizione){
        for(int i = 0; i<this.listaArticoli.size(); i++){
            if(this.listaArticoli.get(i).getPosizione().equals(posizione)){
                return this.listaArticoli.get(i);
            }
        }
        return null;
    }


// data di registrazione prestito
    public void registrazionePrestito(String username, String password, String posizione) {

        Utente utente = accesso(username, password);

        if(utente != null){

            Articolo articolo = cerca(posizione);

            switch (articolo){

                case Libro libro:
                    libro.setDataPrestito(Calendar.getInstance());
                    libro.setDisponibile(false);
                    utente.aggiungiPrestito(libro);
                    break;

                case Film film:
                    film.setDataPrestito(Calendar.getInstance());
                    film.setDisponibile(false);
                    utente.aggiungiPrestito(film);
                    break;

                case Atlante atlante:
                    System.out.println("Gli atlanti non possono essere prestati");
                default:

            }

        }else{
            System.out.println("Accesso non eseguito, controllare username e password");
        }

    }


    public void registrazioneRestituzione(String username, String password, String posizione) {
        Utente utente = accesso(username, password);

        if(utente != null){

            Articolo articolo = cerca(posizione);
            if (posizione.equals(articolo.getPosizione())) {
                articolo.setDisponibile(true);
                utente.rimuoviPrestito(articolo);

                switch (articolo){
                    case Libro libro:
                        libro.setDataPrestito(null);
                        break;
                    case Film film:
                        film.setDataPrestito(null);
                        break;
                    default:
                }
            }

        }else{
            System.out.println("Accesso non eseguito, controllare username e password");
        }
    }


    public void consultazione(String posizione){
        Articolo articolo = cerca(posizione);
        if (articolo instanceof Atlante) {
            articolo.setDisponibile(false);
        }else{
            System.out.println("Si possono consultare solo gli atlanti");
        }
    }


    public void visualizzazioneArticoliPrestati(){
        ArrayList<Articolo> articoliPrestati = new ArrayList<Articolo>();

        for(Articolo articolo : this.listaArticoli){
            if(!articolo.getDisponibile()){
                articoliPrestati.add(articolo);
            }
        }

        //stampa a video
        System.out.println(articoliPrestati);
    }


    public void stampaPrestitiUtente(String username, String password){
        Utente utente = accesso(username, password);
        if(utente != null){
            utente.stampaPrestiti();
        }else{
            System.out.println("Accesso non eseguito, controllare username e password");
        }
    }


    public void registrazioneUtente(String username, String password){
        this.listaUtenti.add(new Utente(username, password));
    }

    public void esempio(){
        this.listaArticoli.add(new Libro("Cecità", "Saramago", "Einaudi", "ISBN88-06-14161-9", 1996));
        this.listaArticoli.add(new Film("Pulp Fiction", "Tarantino", "Miramax Film", "ISBN58654793322", 1994, "John Travolta", "Thriller", 154));
        this.listaArticoli.add(new Atlante ( "Atlante geografico del mondo", "Rossi", "Crescere", "ISBN8883377044", 2000, 96 ));
        this.listaArticoli.add(new Libro ("Psiche e Amore", "McNamara", "Garzanti", "ISBN88110088840", 2024 ));
        this.listaArticoli.add(new Atlante("Atlante Storico di base per la scuola", "PincoPallo","Libreria Geografica", "ISB8869855201", 2022, 104 ));
        this.listaArticoli.add(new Film("Matrix", "Andy e Larry Wachoski", "Warner Bros", "ISBN88954753212", 1999, "Keanu Reeves", "Fantascienza, Azione", 136));
        this.listaArticoli.add(new Libro ("Succede sempre qualcosa di meraviglioso", "Gianluca Gotto", "Libreria Pienogiorno", "ISBN885689523615", 2024 ));
        this.listaArticoli.add(new Libro ("L'ombra del vento ", "Carlos Ruiz Zafón", "Mondadori", "ISBN 88-04-52733-1", 2016));
        this.listaArticoli.add(new Libro ("Anna Karenina", "Lev Tolstoj", "Rizzoli", "ISBN 978-88-17-06705-8", 2018));
        this.listaArticoli.add(new Film ("Il silenzio degli innocenti", "Jonathan Demme", "Orion Pictures", "ISBN 88-04-52733-1", 1991, "Anthony Hopkins", "Thriller", 118));
        this.listaArticoli.add(new Libro ("Il conte di Montecristo", "Alexandre Dumas", "Einaudi", "ISBN 978-8806225186", 2015));
        this.listaArticoli.add(new Libro("Io non ho paura", "Nicolò Ammaniti","Einaudi", "ISBN88-56-5689-265", 2011));
        this.listaArticoli.add(new Atlante("Atlante Illustrato", "Giorgio Sticavoli","Libreria Usborne", "ISB8859687412", 2010, 14 ));
        this.listaArticoli.add(new Film ("Dunkirk", "Nolan", "Warner Bros. Pictures","ISBN 88-04-52656-5", 2017,"Tom Hardy","Storico", 106));
        this.listaArticoli.add(new Libro ("Tao Te Ching", "Lao Tzu", "Feltrinelli", "ISBN 978-88-07-88275-3", 2011));
    }

    public Integer getContPosizioneLibri(){return contPosizioneLibri;}
    public Integer getContPosizioneFilm(){return contPosizioneFilm;}
    public Integer getContPosizioneAtlanti(){return contPosizioneAtlanti;}




    public void incrementaContPosizioneLibri(){this.contPosizioneLibri++;}
    public void incrementaContPosizioneFilm(){this.contPosizioneFilm++;}
    public void incrementaContPosizioneAtlanti(){this.contPosizioneAtlanti++;}

    private Utente accesso(String username, String password){
        for(Utente utente : this.listaUtenti){
            if(username.equals(utente.getUsername()) && password.equals(utente.getPassword())){
                return utente;
            }
        }

        return null;
    }
}

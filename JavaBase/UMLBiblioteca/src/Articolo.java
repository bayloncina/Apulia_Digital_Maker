import java.io.Serializable;

public abstract class Articolo implements Serializable {
    //campi
    protected String titolo, autore, casaEditrice, posizione, codice;
    protected int anno;
    protected boolean disponibile;

    //Costruttori
    public Articolo(String titolo, String autore, String casaEditrice, String codice, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.casaEditrice = casaEditrice;
        this.codice = codice;
        this.anno = anno;
        this.disponibile = true;
        generaPosizione();
    }

    //metodi
    public abstract void generaPosizione();

    public String getTitolo(){return this.titolo;}


    public String getAutore(){
        return this.autore;
    }

    public String getCasaEditrice()
    {
        return this.casaEditrice;
    }


    public String getPosizione()
    {
        return this.posizione;
    }


    public String getCodice()
    {
        return this.codice;
    }



    public int getAnno(){return this.anno;}

    public boolean getDisponibile(){return this.disponibile;}

    public void setDisponibile(boolean disponibile){this.disponibile = disponibile;}

    @Override
    public String toString() {
        return  "Titolo: " + this.titolo + "\n" +
                "Autore: " + this.autore + "\n" +
                "Casa Editrice: " + this.casaEditrice + "\n" +
                "Posizione: " + this.posizione + "\n" +
                "Codice: " + this.codice + "\n" +
                "Anno: " + this.anno + "\n" +
                "Disponibilità: " + (this.disponibile? "Disponibile" : "Non disponibile") + "\n";
    }
}

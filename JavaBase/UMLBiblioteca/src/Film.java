import java.util.Calendar;

public class Film extends Articolo{
    //campi
    private String attore, genere;
    private float durata;
    private Calendar dataPrestito;


    //Costruttori
    public Film(String titolo, String autore, String casaEditrice, String codice, int anno, String attore, String genere, float durata) {
        super(titolo, autore, casaEditrice, codice, anno);
        this.attore = attore;
        this.genere = genere;
        this.durata = durata;
    }


    //metodi
    public void setDataPrestito(Calendar dataPrestito){
        this.dataPrestito = dataPrestito;
    }

    @Override
    public void generaPosizione() {
        this.posizione = "DVD" + Main.biblioteca.getContPosizioneFilm().toString();
        Main.biblioteca.incrementaContPosizioneFilm();
    }

    @Override
    public String toString() {
        return   super.toString() +
                "Attore: " + this.attore + "\n" +
                "Genere: " + this.genere + "\n" +
                "Durata: " + this.durata + "minuti" + "\n" +
                (this.dataPrestito == null? "" :"Data Prestito: " + this.dataPrestito.get(Calendar.DAY_OF_MONTH) + "/" + this.dataPrestito.get(Calendar.MONTH) + "/" + this.dataPrestito.get(Calendar.YEAR) + "\n");
    }
}

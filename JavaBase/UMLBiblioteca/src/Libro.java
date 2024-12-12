import java.util.Calendar;

public class Libro extends Articolo{
    //campi
    private Calendar dataPrestito;

    //Costruttori
    public Libro(String titolo, String autore, String casaEditrice, String codice, int anno)
    {
        super(titolo, autore, casaEditrice, codice, anno);
    }

    //metodi
    //  metodo per registrare la data del prestito e cosa ha in prestito

    public void setDataPrestito(Calendar dataPrestito)
    {
        this.dataPrestito = dataPrestito;
    }

    //METODO PER GENERARE POSIZIONE DELL'OGGETTO LIBRO
    @Override
    public void generaPosizione() {
        this.posizione = "LBR" +  Main.biblioteca.getContPosizioneLibri().toString();
        Main.biblioteca.incrementaContPosizioneLibri();
    }

    @Override
    public String toString() {
        return   super.toString() +
                (this.dataPrestito == null? "" :"Data Prestito: " + this.dataPrestito.get(Calendar.DAY_OF_MONTH) + "/" + this.dataPrestito.get(Calendar.MONTH) + "/" + this.dataPrestito.get(Calendar.YEAR) + "\n");
    }
}

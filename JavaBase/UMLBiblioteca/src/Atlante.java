public class Atlante extends Articolo{
    //campi
    private int numeroCarte;

    //Costruttori
    public Atlante(String titolo, String autore, String casaEditrice, String codice, int anno, int numeroCarte) {
        super(titolo, autore, casaEditrice, codice, anno);
        this.numeroCarte = numeroCarte;
    }


    //metodi

    @Override
    public void generaPosizione() {
        this.posizione = "ATL" + Main.biblioteca.getContPosizioneAtlanti().toString();
        Main.biblioteca.incrementaContPosizioneAtlanti();
    }

    @Override
    public String toString() {
        return super.toString() +
                "Numero Carte: " + this.numeroCarte + "\n";
    }
}

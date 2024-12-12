public class Azienda
{
    private String nome;
    private String via;
    private String citta;
    public Azienda()
    {
    //attributi dell'azienda
    Titolare titolare;
    Dipendente dip1;
   Dipendente dip2;
   Dipendente dip3;


    {
        this.nome = "Bianconi Scarpe e Borse";
        this.via = "Via Sparano, 56";
        this.citta = "Bari";

        titolare = new Titolare("Rossi", "Fabiola","19/01/2000",3000);
        dip1 = new Dipendente("Verdi", "Maria", "08/04/1998", 1000.00f, 10,2);
        dip2 = new Dipendente("Gialli", "Francesco", "05/10/1956", 800.00f, 15,1);
        dip3 = new Dipendente("Bianchi", "Roberta", "13/10/1988", 1500.00f, 7,0);

    }

    public void CalcolaStipendi()
        {
            Mese gennaio = new Mese("gennaio", 31, 6);
        }



    }

}

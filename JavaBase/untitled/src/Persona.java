public class Persona {

    //gliattributi per essere accessibili al figlio nel padre devono essere protected
    protected String Cognome;
    protected String Nome;
    protected String DataDiNascita;

    public Persona(java.lang.String baylon, java.lang.String maria)

    {
        System.out.println("Ciao Sono il costruttore di default");
    }

    public Persona(String xCognome, String xNome, String xDataDiNascita)

    {

        //l'operatore this fa riferimento a una variabile di istanza

        this.Cognome = xCognome;
        this.Nome = xNome;
        this.DataDiNascita= xDataDiNascita;

    }

    public void stampaPersona()


    {
        System.out.println("Cognome: " + this.Cognome);
        System.out.println("Nome: " + this.Nome);
        System.out.println("Data di Nascita: " + this.DataDiNascita);
    }
}

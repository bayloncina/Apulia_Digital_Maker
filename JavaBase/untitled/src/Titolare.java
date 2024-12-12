public class Titolare extends Persona

{
    float Stipendio;
    public Titolare (String xCognome, String xNome, String xDataDiNascita, float xStipendio)

    {

      this.Cognome = xCognome;
      this.Nome = xNome;
      this.DataDiNascita = xDataDiNascita;
      this.Stipendio = xStipendio;

    }

    //metodo

    public float getStipendio()

    {
        return Stipendio;
    }

}

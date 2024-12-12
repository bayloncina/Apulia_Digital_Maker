public class Dipendente extends Persona


{
float fissoMensile;
float retribuzioneOraria = 10.00f;
int numeroOreGiornaliere = 8;
float retribuzioneOrariaStraordinaria = 12.00f;

int numeroOreStraordinario;

float lavoroDomenicale =20.00f;
int numeroDomeniche =0;
public Dipendente (String xCognome, String xNome, String xDataDiNascita, float xFissoMensile, int xnumeroOreStraordinario, int xNumeroDomeniche)
{
    this.Cognome = xCognome;
    this.Nome = xNome;
    this.DataDiNascita = xDataDiNascita;
    this.fissoMensile = xFissoMensile;
    this.numeroDomeniche = xNumeroDomeniche;
    this.numeroOreStraordinario =xnumeroOreStraordinario;

}
}


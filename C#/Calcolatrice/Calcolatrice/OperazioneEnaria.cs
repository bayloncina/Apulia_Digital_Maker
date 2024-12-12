namespace Calcolatrice;
public class OperazioneEnaria : Operazione
{
    public override double Calcola(double[] numeri)
    {
        if (numeri.Length < 1) throw new ArgumentException("Servono almeno un numero per un'operazione en-aria.");
        
        double risultato = numeri[0];
        for (int i = 1; i < numeri.Length; i++)
        {
            risultato = Math.Pow(risultato, numeri[i]);
        }

        return risultato;
    }
}

namespace Calcolatrice;
public class OperazioneBinaria : Operazione
{
    public enum TipoOperazione { Addizione, Sottrazione, Moltiplicazione, Divisione }

    private TipoOperazione _tipo;

    public OperazioneBinaria(TipoOperazione tipo)
    {
        _tipo = tipo;
    }

    public override double Calcola(double[] numeri)
    {
        if (numeri.Length < 2) throw new ArgumentException("Servono almeno due numeri per un'operazione binaria.");

        double risultato = numeri[0];

        for (int i = 1; i < numeri.Length; i++)
        {
            switch (_tipo)
            {
                case TipoOperazione.Addizione:
                    risultato += numeri[i];
                    break;
                case TipoOperazione.Sottrazione:
                    risultato -= numeri[i];
                    break;
                case TipoOperazione.Moltiplicazione:
                    risultato *= numeri[i];
                    break;
                case TipoOperazione.Divisione:
                    risultato /= numeri[i];
                    break;
            }
        }

        return risultato;
    }
}

namespace Calcolatrice;

public class OperazioneUnaria : Operazione
{
    public enum TipoOperazione { RadiceQuadrata }

    private TipoOperazione _tipo;

    public OperazioneUnaria(TipoOperazione tipo)
    {
        _tipo = tipo;
    }

    public override double Calcola(double[] numeri)
    {
        if (numeri.Length != 1) throw new ArgumentException("Serve un solo numero per un'operazione unaria.");

        double risultato = 0;

        switch (_tipo)
        {
            case TipoOperazione.RadiceQuadrata:
                risultato = Math.Sqrt(numeri[0]);
                break;
        }

        return risultato;
    }
}

namespace Calcolatrice;
using System;

class Calcolatrice
{
    static void Main(string[] args)
    {
        while (true)
        {
            InterfacciaUtente.MostraOperazioniDisponibili();
            string operazione = InterfacciaUtente.RichiediOperazione();

            if (operazione.ToLower() == "esci")
                break;

            double[] numeri = InterfacciaUtente.RichiediInserimentoNumeri(operazione);
            double risultato = ElaboraCalcolo(operazione, numeri);
            InterfacciaUtente.MostraRisultato(risultato);
        }
    }

    static double ElaboraCalcolo(string operazione, double[] numeri)
    {
        Operazione op = null;

        switch (operazione)
        {
            case "1": // Addizione
                op = new OperazioneBinaria(OperazioneBinaria.TipoOperazione.Addizione);
                break;
            case "2": // Sottrazione
                op = new OperazioneBinaria(OperazioneBinaria.TipoOperazione.Sottrazione);
                break;
            case "3": // Moltiplicazione
                op = new OperazioneBinaria(OperazioneBinaria.TipoOperazione.Moltiplicazione);
                break;
            case "4": // Divisione
                op = new OperazioneBinaria(OperazioneBinaria.TipoOperazione.Divisione);
                break;
            case "5": // Elevazione alla potenza
                op = new OperazioneEnaria();
                break;
            case "6": // Radice quadrata
                op = new OperazioneUnaria(OperazioneUnaria.TipoOperazione.RadiceQuadrata);
                break;
            default:
                Console.WriteLine("Operazione non valida.");
                return 0;
        }

        return op.Calcola(numeri);
    }
}

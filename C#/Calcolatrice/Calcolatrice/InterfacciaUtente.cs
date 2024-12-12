namespace Calcolatrice;
using System;

public static class InterfacciaUtente
{
    public static void MostraOperazioniDisponibili()
    {
        Console.WriteLine("Scegli l'operazione da eseguire:");
        Console.WriteLine("1. Addizione");
        Console.WriteLine("2. Sottrazione");
        Console.WriteLine("3. Moltiplicazione");
        Console.WriteLine("4. Divisione");
        Console.WriteLine("5. Elevazione alla potenza");
        Console.WriteLine("6. Radice quadrata");
        Console.WriteLine("Digita 'esci' per uscire.");
    }

    public static string RichiediOperazione()
    {
        return Console.ReadLine();
    }

    public static double[] RichiediInserimentoNumeri(string operazione)
    {
        switch (operazione)
        {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                Console.WriteLine("Quanti numeri vuoi inserire?");
                int count = int.Parse(Console.ReadLine());
                double[] numeri = new double[count];
                for (int i = 0; i < count; i++)
                {
                    Console.WriteLine($"Inserisci il numero {i + 1}:");
                    numeri[i] = double.Parse(Console.ReadLine());
                }
                return numeri;
            case "6":
                Console.WriteLine("Inserisci il numero per il quale vuoi calcolare la radice quadrata:");
                double numero = double.Parse(Console.ReadLine());
                return new double[] { numero };
            default:
                Console.WriteLine("Operazione non valida.");
                return new double[0];
        }
    }

    public static void MostraRisultato(double risultato)
    {
        Console.WriteLine($"Il risultato è: {risultato}");
    }
}

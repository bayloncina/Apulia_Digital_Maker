//il caso d'uso ha come finalità di permettere all'attore 
//di conoscere il risultato dell'operzione matematica scelta
//tra due numeri

//

Console.WriteLine("CALCOLATRICE");
//Per la stampa a schermo
public void ScegliOperazione {
    Console.WriteLine("""
                      Operazioni disponibili:
                      1. Addizione
                      2. Sottrazione
                      3. Moltiplicazione
                      4. Divisione
                      5. Eleva alla Potenza
                      6. Radice Quadrata

                      """
    );
}

ScegliOperazione();
public void InserisciNumeri {

    Console.WriteLine("Inserire il primo numero");
    var num1 = float.Parse(Console.ReadLine());
    Console.WriteLine("Inserire il secondo numero");
    var num2 = float.Parse(Console.ReadLine());

}
string operazione (int) = Console.ReadLine();
InserisciNumeri();

do
{
    switch (operazione)

    {
        case "1":
            Console.WriteLine ();
            break;
        
        case "2":
            Console.WriteLine();
            break;
        
        case "3":
            Console.WriteLine();
            break;
        
        case "4":
            try
            {
                Console.WriteLine();
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
            break;
    }
} while ((operazione =! 0));
   

    
}



}



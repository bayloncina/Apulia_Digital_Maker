
import java.util.Scanner;

public class GarageMain
{

    public static void main (String args[])
    {
        Garage g = new Garage();

        // Precarica dati di test
        g.caricaDatiTest();

        Scanner in = new Scanner(System.in);
        int scelta;
        do {
            System.out.println("Garage ITS");

            System.out.println("1. Parcheggiare veicolo");
            System.out.println("2. Consegnare veicolo");
            System.out.println("3. Visualizzare i posti del garage");
            System.out.println("4. Visualizzare posti liberi");
            System.out.println("5. Visualizzare veicoli parcheggiati");
            System.out.println("6. Visualizzare incasso");
            System.out.println("0. Esci");

            System.out.println("Inserisci la tua scelta ->");
            scelta = in.nextInt();
            switch (scelta) {
                case 1:
                    if (g.parcheggiareVeicolo()) {
                        System.out.println("Veicolo parcheggiato");
                    } else {
                        System.out.println("Veicolo non parcheggiato");
                    }
                    break;

                case 2:
                    g.consegnareVeicolo();
                    break;
                case 3:
                    g.visualizzareGarage();
                    break;
                case 4:
                    g.visualizzarePostiLiberi();
                    break;
                case 5:
                    g.visualizzareVeicoliParcheggiati();
                    break;
                case 6:
                    g.visualizzareIncasso();
                    break;

                default:
                    break;

            }
        } while (scelta != 0);
    }
}

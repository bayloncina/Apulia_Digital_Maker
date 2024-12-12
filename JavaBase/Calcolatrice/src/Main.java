import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int scelta;
        float  num1, num2;


        System.out.println("Inserisci numero ");
        num1 = sc.nextInt();
        System.out.println("Inserisci numero ");
        num2 = sc.nextInt();

        Calcolatrice c = new Calcolatrice( num1, num2);

        //c.Inserimento();


         do {
             System.out.println("Digita 1 per addizione");
             System.out.println("Digita 2 per sottrazione");
             System.out.println("Digita 3 per Prodotto");
             System.out.println("Digita 4 per Divisione");
             System.out.println("Digita 0 per Esci");
             scelta = sc.nextInt();


//eseguo operazione selezionata


             switch (scelta) {

                 case 1:
                     c.Addizione();
                     System.out.println("La somma è: " + c.somma);
                     break;
                 case 2:
                     c.Sottrazione();
                     System.out.println("La differenza è: " + c.sottrazione);
                     break;
                 case 3:
                     c.Prodotto();
                     System.out.println("Il prodotto è: " + c.prodotto);
                     break;
                 case 4:
                     c.Divisione();
                     System.out.println("Il quoziente: " + c.divisione);
                     break;
                 case 0:
                     break;
                 default: System.out.println("Inserire un carattere tra 0 e 4");
                 break;

             }
         }

             while (scelta !=0);

        }


        }

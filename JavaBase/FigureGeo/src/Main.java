import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
    Scanner sc = new Scanner(System.in);
        /*float base;
        float altezza;

        System.out.println("Inserisci base Rettangolo");
        base = sc.nextFloat();
        System.out.println("Inserisci altezza Rettangolo");
        altezza = sc.nextFloat();


        Rettangolo r = new Rettangolo(base, altezza);
        r.CalcolaArea();
        r.CalcolaPerimetro();
        r.Stampa();*/

        float lato;
        System.out.println("Inserisci lato Quadrato");
        lato = sc.nextFloat();

        //Costruttore
        Quadrato q = new Quadrato (lato);
        q.CalcolaAreaQ();
        q.CalcolaPerimetroQ();
        q.StampaQ();




    }

}
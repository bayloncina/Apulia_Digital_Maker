import java.util.Scanner;
public class contoCorrente extends ContoBancario
{
    double importoPrelievo;
    int interesse;

Scanner sc = new Scanner(System.in);
public contoCorrente(int numeroConto, String titolare, double saldo)
{
    super(numeroConto, titolare, saldo);
}

public void preleva()
{

    System.out.println("Inserire l'importo da prelevare ");
    importoPrelievo = sc.nextDouble();


}

    public double CalcolaInteresse(int interesse)
    {
        this.interesse = interesse;
       importoPrelievo = importoPrelievo-interesse

        return 0;
    }
}

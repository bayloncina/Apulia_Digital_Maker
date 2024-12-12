import java.util.Scanner;

public class Calcolatrice
{

    float num1, num2;
float somma, sottrazione, prodotto, divisione;

    //costruttore

    public Calcolatrice (float xnum1, float xnum2)
    {
        num1 = xnum1;
        num2 = xnum2;
    }
/*public void Inserimento()

{
    num1 = sc.nextFloat;
    System.out.println("Inserisci secondo numero");
    num2 = sc.nextFloat();

}*/


    public void Addizione()
    {
         somma = num1+num2;

    }
    public void Sottrazione()
    {
        sottrazione = num1-num2;

    }
    public void Prodotto()
    {
        prodotto = num1*num2;

    }
    public void Divisione()
    {


        if(num2!=0)
        {
            divisione = num1/num2;
                   }
        else
        {
            System.out.println("L'operazione non è possibile");
        }

          }

}

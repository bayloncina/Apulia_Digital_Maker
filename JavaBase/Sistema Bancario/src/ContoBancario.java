public abstract class  ContoBancario
{
    private int numeroConto;
    private String titolare;
    private double saldo;

    public ContoBancario (int xnumeroConto, String xtitolare, double xsaldo)
    {
        this.numeroConto=xnumeroConto;
        this.titolare=xtitolare;
        this.saldo=xsaldo;

    }


    public abstract double CalcolaInteresse();

}

import java.util.Scanner;
public class Gatto extends Mammifero

{
    private String razza;
    private String taglia;
    public Gatto (String xNome, int xEtaMedia, String xTaglia, String xRazza)
    {
        //anche se è private richiamo la classe padre per
        super(xNome,xEtaMedia);
this.razza = xRazza;
this.taglia = xTaglia;
    }

    @Override //sovrascrive e richiama il metodo della superclasse
    public void emetteVerso() {
        System.out.println("Il gatto miagola");
    }

    public void StampaGatto()
    {
        System.out.println("Nome: "+ this.getNome());
        System.out.println("Età media: "+ this.getEtaMedia());
        System.out.println("Razza " + this.razza);
        System.out.println("Taglia: " + this.taglia);

    }

    public void CambiaNome(String xNome)
    {
super.setNome(xNome);
    }
}

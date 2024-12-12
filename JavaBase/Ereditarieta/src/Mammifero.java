import java.util.Scanner;

public abstract class Mammifero
{
    private String nome;
    private int EtaMedia;

    public void EmettiVerso();
    public Mammifero (String xNome, int xEtaMedia)
    {
        this.nome = xNome;
        this.EtaMedia = xEtaMedia;
    }


public String getNome()
{
    return this.nome;
}
    public int getEtaMedia()
    {
        return this.EtaMedia;
    }
    public void setNome(String xNome)
    {
        this.nome = xNome;
    }
}

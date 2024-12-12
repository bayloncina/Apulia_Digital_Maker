public class Mese {

    private int numGiorni;
    private String nomeMese;
    private int numFestivi;
public Mese (String xNome, int xNumGiorni, int xNumFestivi)
{
    this.nomeMese =xNome;
    this.numGiorni = xNumGiorni;
    this.numFestivi = xNumFestivi;
}
    public void setNomeMese(String xNome)
    {
        this.nomeMese = xNome;

    }
    public void setNumGiorni(String xNumGiorni)
    {
        this.numGiorni = xNumGiorni;

    }
    public void setNumFestivi(String xNumFestivi)
    {
        this.numFestivi = xNumFestivi;

    }

    public String getNomeMese()
    {
        return this.nomeMese;
    }

    public int getNumGiorni()
    {
        return this.numGiorni;
    }
}

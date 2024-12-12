

public class Veicolo
{
    protected int id;
    protected String targa;
    protected String marca;
    protected String modello;
    protected int oraIngresso;
    protected int oraUscita = 0;
    protected int anno;
    protected int cyl;

    public int getId()
    {
        return id;
    }
    public String getTarga()
    {
        return targa;
    }
    public int getOraIngresso()
    {
        return oraIngresso;
    }
    public void resetVeicolo()
    {
        id = 0;
        targa = "";
        marca = "";
        modello = "";
        oraIngresso = 0;
        oraUscita = 0;
        anno = 0;
        cyl = 0;
    }

    Veicolo(int j, String targa, int oraIngresso, String m, String mod, int a, int c)
    {
        this.id=j;
        this.targa = targa;
        this.oraIngresso = oraIngresso;
        this.marca=m;
        this.modello = mod;
        this.anno=a;
        this.cyl=c;
    }
}

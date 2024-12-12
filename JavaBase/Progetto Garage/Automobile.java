
public class Automobile extends Veicolo
{
    private int porte;
    private char alimentazione;
    Automobile(int j,String targa,int ora, String s, String mod, int a, int c,int p, char d)
    {
        super(j,targa,ora,s,mod,a,c);
        porte=p;
        alimentazione=d;
    }
    public int getid() {return id;}
    public int getOraIngresso() {return oraIngresso;}
    public String getm() {return marca;}
    public String getmod() {return modello;}
    public String getTarga() {return targa;}
    public int geta() {return anno;}
    public int getc() {return cyl;}
    public int getp() {return porte;}
    public char getd() {return alimentazione;}

    // metodi setter
    public void setid(int id) {this.id=id;}
    public void setOraIngresso(int ora) {this.oraIngresso=ora;}
    public void setm(String m) {this.marca=m;}
    public void setmod(String mod) {this.modello=mod;}
    public void setAnno(int anno) {this.anno=anno;}
    public void setCilindrata(int cyl) {this.cyl = cyl;}
    public void setPorte(int porte) {this.porte = porte;}
    public void setAlimentazione(char alim) {alimentazione = alim;}
    @Override public String toString()
    {
        String st=getid()+"] "+" "+getTarga()+" "+getOraIngresso()+" "+getm()+" "+" "+getmod()+" "+geta()+" "+getc()+" "+getp()+" "+getd();
        return st;
    }
}



public class Furgone extends Veicolo
{
    private int carico;
    Furgone (int j,String targa,int ora,String s, String mod, int a, int c,int ca)
    {
        super(j,targa,ora,s,mod,a,c);
        carico=ca;
    }
    public int getid() {return id;}
    public int getOraIngresso() {return oraIngresso;}
    public String getm() {return marca;}
    public String getModello() {return modello;}
    public int geta() {return anno;}
    public int getc() {return cyl;}
    public int getCarico() {return carico;}
    public String getTarga() {return targa;}

    // metodi setter
    public void setid(int id) {this.id=id;}
    public void setOraIngresso(int ora) {this.oraIngresso=ora;}
    public void setm(String m) {this.marca=m;}
    public void setmod(String mod) {this.modello=mod;}
    public void setAnno(int anno) {this.anno=anno;}
    public void setCilindrata(int cyl) {this.cyl = cyl;}
    public void setCarico(int carico) {this.carico = carico;}

    @Override public String toString()
    {
        String st=getid()+"] "+" "+getTarga()+" "+getOraIngresso()+" "+getm()+" "+" "+getModello()+" "+geta()+" "+getc()+" "+getCarico();
        return st;
    }
}

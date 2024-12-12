

public class Motocicletta extends Veicolo
{
    private int tempi;
    
    Motocicletta(int j, String targa, int ora, String s, String mod, int a, int c,int t)
    {
        super(j,targa,ora,s,mod,a,c);
        tempi=t;
    }

    // metodi getter
    public int getid() {return id;}
    public int getOraIngresso() {return oraIngresso;}
    public String getm() {return marca;}
    public String getmod() {return modello;}
    public int geta() {return anno;}
    public int getc() {return cyl;}
    public int gett() {return tempi;}
    public String getTarga() {return targa;}

    // metodi setter
    public void setid(int id) {this.id=id;}
    public void setOraIngresso(int ora) {this.oraIngresso=ora;}
    public void setm(String m) {this.marca=m;}
    public void setmod(String mod) {this.modello=mod;}
    public void setAnno(int anno) {this.anno=anno;}
    public void setCilindrata(int cyl) {this.cyl = cyl;}
    public void setTempi(int tempi) {this.tempi = tempi;}

    @Override public String toString()
    {
        String st=getid()+"] "+" "+getTarga()+" "+getOraIngresso()+" "+getm()+" "+" "+getmod()+" "+geta()+" "+getc()+" "+gett();
        return st;
    }
}

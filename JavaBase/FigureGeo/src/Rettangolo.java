public class Rettangolo {

    //attributi

    float area;
    float perimetro;
    float base;
    float altezza;

    //costruttore

    public Rettangolo (float xBase, float xAltezza)
    {
        base = xBase;
        altezza = xAltezza;
    }

    public void Stampa ()
    {
        System.out.println("Il perimetro del rettangolo è " + perimetro);
        System.out.println("L'area del rettangolo è " + area);
    }
    public void CalcolaArea()
    {
        area = base*altezza;
    }
    public void CalcolaPerimetro()
    {
        perimetro = (base+altezza)*2;
    }
}

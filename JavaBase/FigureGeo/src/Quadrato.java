public class Quadrato {
    //stampa area e perimetro quadrato

    float area;
    float perimetro;
    float lato;

    //costruttore
    public Quadrato(float xlato)
    {
        lato = xlato;
    }

    public void CalcolaAreaQ()
    {
        area = lato*lato;
    }

    public void CalcolaPerimetroQ()
    {
        perimetro = (lato+lato)*2;
    }

    public void StampaQ()
    {
        System.out.println("L'area del quadrato è " + area);
        System.out.println("Il perimetro del quadrato è " + perimetro);

    }
}

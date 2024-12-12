
import java.util.Scanner;
public class Garage {
    final static int MAX = 15;
    final static int COSTO_ORARIO = 2;
    private Veicolo posti[] = new Veicolo[MAX]; //istanziazione del vettore
    private double incasso = 0;


    public Garage()
    {
        for (int i = 0; i < MAX; ++i) {
            posti[i] = new Veicolo(0, "", 0, "", "", 0, 0);
        }
    }

    public void visualizzareIncasso()
    {
        System.out.println("L'incasso è di "+this.incasso+" Euro");
    }

    public void visualizzarePostiLiberi()
    {
        for (int i = 0; i<MAX; ++i)
        {
            if (posti[i].getId() == 0)
            {
                System.out.println((i+1)+"] LIBERO");
            }
        }
    }
    public void visualizzareGarage()
    {
        for (int i = 0; i<MAX; ++i)
        {
            if (posti[i].getId() != 0)
            {
                String s = posti[i].toString();
                System.out.println(s);
            }
            else
            {
                System.out.println((i+1)+"] LIBERO");
            }
        }
    }
    public void visualizzareVeicoliParcheggiati()
    {
        for (int i = 0; i<MAX; ++i)
        {
            if (posti[i].getId() != 0)
            {
                String s = posti[i].toString();
                System.out.println(s);
            }
        }
    }

    // Questo metodo viene usato per precaricare i dati in fase di testing
    // per evitare di dover fare ogni volta data entry
    public void caricaDatiTest()
    {
        Automobile a1 = new Automobile(1,"DL876ST",16, "Ford","Kuga",2022, 2000, 5,'d');
        posti[0] = a1;
        Motocicletta m1 = new Motocicletta(2,"CX123AL",15, "Yamaha","XS",2021, 1100, 5);
        posti[1] = m1;
        Furgone f1 = new Furgone(3,"BL456TO",11,"Ford","Transit",1999,2500,200);
        posti[2] = f1;
        Automobile a2 = new Automobile(4,"AA111BB",15, "Alfa Romeo","Giulia",2021, 2000, 5,'b');
        posti[3] = a2;
    }
    private boolean checkPin(int pin)
    {
        boolean esito = false;

        if (pin == 1234)
        {
          esito = true;
        }
        return esito;
    }
    public void consegnareVeicolo()
    {
        int oraUscita,numeroOre;
        double importo, resto, contante;
        int scelta;
        boolean ritirato = false;

        Scanner in=new Scanner(System.in);
        System.out.print("Inserire la targa del veicolo ");
        String targa = in.next();


        //Ricerca il veicolo nel parcheggio
        for (int i=0; i<MAX && ritirato==false; ++i)
        {
            if (targa.equalsIgnoreCase(posti[i].getTarga()))
            {
                do
                {
                    System.out.print("Inserire l'ora di uscita ");
                    oraUscita = in.nextInt();
                } while (oraUscita<posti[i].getOraIngresso());

                if (oraUscita==posti[i].getOraIngresso())
                {
                    numeroOre = 1;
                }
                else
                {
                    numeroOre = oraUscita - posti[i].getOraIngresso()+1;
                }
                importo = numeroOre*COSTO_ORARIO;
                incasso = incasso + importo;
                System.out.println("Ora di ingresso        :" + posti[i].getOraIngresso());
                System.out.println("Ora di uscita          :" + oraUscita);
                System.out.println("N.ro ore di permanenza :" + numeroOre);

                System.out.println ("L'importo da pagare è di "+importo+" Euro");

                do {
                    System.out.println("Vuoi pagare in contanti (1) o in Carta di Credito (2)? ");
                    scelta = in.nextInt();
                } while (scelta != 1 && scelta != 2);

                if (scelta == 1)  //pagamento in contanti
                {
                    do
                    {
                        System.out.println("Inserire il contante");
                        contante = in.nextDouble();
                        resto = contante - importo;
                        if (resto < 0) System.out.println("Importo inserito non sufficiente");
                    } while (resto < 0);
                    System.out.print ("Pagamento effettuato");
                    if (resto > 0) System.out.println (". Si procede a restituire il resto di "+resto+" Euro");
                    ritirato = true;
                }
                else
                {
                    int nTentativi = 0;
                    ritirato = false;
                    do {
                        System.out.println("Inserire il pin");
                        int pin = in.nextInt();
                        if (checkPin(pin)) {
                            System.out.println("Pagamento effettuato con Carta di Credito");
                            ritirato = true;
                        } else {
                            System.out.println("Pin Errato.");
                        }
                        nTentativi++;
                    } while(nTentativi < 3 && ritirato==false);
                }
                if (ritirato == true) posti[i].resetVeicolo();
                else System.out.println("Se non paghi non puoi ritirare l'auto");
            }
        }
    }
    public boolean parcheggiareVeicolo()
    {
        boolean parcheggiato = false;
        String mar,mod;//marca
        char db;//diesel o benzina o elettrico
        int cil,year,par4, ora;
        char ch,scelta;
        int i;
        String targa;

        Scanner in=new Scanner(System.in);
        System.out.print("Il veicolo è diesel, benzina o elettrico?(d/b/e):");
        db = in.next().charAt(0);
        if (db == 'd' || db == 'b' || db == 'e')
        {
            for (i = 0; i < MAX && parcheggiato == false; ++i)
            {
                System.out.println("Id " + posti[i].getId());
                if (posti[i].getId() == 0)
                {
                    parcheggiato = true;
                    int id = i + 1;
                    System.out.print("Inserire la targa: ");
                    targa = in.next();
                    System.out.print("Inserire l'ora di arrivo: ");
                    ora = in.nextInt();
                    System.out.print("Che veicolo stai parcheggiando (m-motocicletta,a-auto,f-furgone?:");
                    ch = in.next().charAt(0);
                    System.out.print("Marca: ");
                    mar = in.next();
                    System.out.print("Modello: ");
                    mod = in.next();
                    System.out.print("Anno:");
                    year = in.nextInt();
                    System.out.print("Cilindrata:");
                    cil = in.nextInt();
                    switch (ch) {
                        case 'a':
                            System.out.print("porte:");
                            par4 = in.nextInt();
                            Automobile a = new Automobile(id, targa, ora, mar, mod, year, cil, par4, db);
                            posti[i] = a;
                            System.out.println(posti[i].toString());
                            break;
                        case 'f':
                            System.out.print("carico:");
                            par4 = in.nextInt();
                            Furgone f = new Furgone(id, targa, ora, mar, mod, year, cil, par4);
                            posti[i] = f;

                            break;
                        case 'm':
                            System.out.print("tempi:");
                            par4 = in.nextInt();
                            Motocicletta m = new Motocicletta(id, targa, ora, mar, mod, year, cil, par4);
                            posti[i] = m;
                            break;
                        default:
                            System.out.println("scelta non valida");
                    }//fine switch
                }
            }
        }
        return parcheggiato;
    }

}

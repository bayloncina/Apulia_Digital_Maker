import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    static Biblioteca biblioteca = new Biblioteca();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean bibliotecario;
        int tipoUtente, sceltaUtente, sceltaBibliotecario;

        String thisPath = System.getProperty("user.dir");
        //apertura per lettura del file all'inizio non stampa a video per favore
        //
        //mao
        try(InputStream is = new FileInputStream(thisPath + "Bibli.mao")) {

                ObjectInputStream ois = new ObjectInputStream(is);



                biblioteca = (Biblioteca) ois.readObject();




        } catch(FileNotFoundException | InvalidClassException e){
            try(FileOutputStream fos = new FileOutputStream("Bibli.mao")){
                fos.flush();
            }

        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }


        biblioteca.esempio();


        do{
            System.out.println("""
                    1. Bibliotecario
                    2. Utente Biblioteca
                    """);
            tipoUtente = sc.nextInt();
        }while(tipoUtente != 1 && tipoUtente != 2);


        bibliotecario = (tipoUtente == 1);

        sceltaBibliotecario = 0;
        sceltaUtente = 0;

        do {
            if (bibliotecario) {

                do {
                    System.out.println("""
                            Digitare il numero dell'elemento, poi premere Invio:
                            1. Ricerca Articolo
                            2. Registrazione Prestito
                            3. Registrazione Restituzione
                            4. Registrazione Consultazione
                            5. Visualizzazione articoli prestati
                            0. Esci
                            """);
                    sceltaBibliotecario = sc.nextInt();
                } while (sceltaBibliotecario != 1 && sceltaBibliotecario != 2 && sceltaBibliotecario != 3 && sceltaBibliotecario != 4 && sceltaBibliotecario != 5 && sceltaBibliotecario != 0);

            } else {
                do {
                    System.out.println("""
                            Digitare il numero dell'elemento, poi premere Invio:
                            1. Registrazione Utente
                            2. Ricerca Articolo
                            3. Articoli in tuo possesso
                            0. Esci
                            """);
                    sceltaUtente = sc.nextInt();
                } while (sceltaUtente != 1 && sceltaUtente != 2 && sceltaUtente != 3 && sceltaUtente != 0);
            }

            if(sceltaBibliotecario == 1 || sceltaUtente == 2){

                String titolo = null;
                String autore = null;
                System.out.println("Digitare Titolo: ");
                titolo = sc.next();

                System.out.println("Digitare Autore: ");
                autore = sc.next();

                biblioteca.ricercaArticolo(titolo, autore);
            }

            String username, password, posizione;

            switch (sceltaBibliotecario){
                case 2:
                    System.out.println("Inserire username: ");
                    username = sc.next();
                    System.out.println("Inserire password: ");
                    password = sc.next();
                    System.out.println("Inserire codice posizione articolo:");
                    posizione = sc.next();
                    biblioteca.registrazionePrestito(username, password, posizione);
                    break;
                case 3:
                    System.out.println("Inserire username: ");
                    username = sc.next();
                    System.out.println("Inserire password: ");
                    password = sc.next();
                    System.out.println("Inserire codice posizione articolo:");
                    posizione = sc.next();
                    biblioteca.registrazioneRestituzione(username, password, posizione);
                    break;
                case 4:
                    System.out.println("Inserire il codice posizione dell'atlante da consultare: ");
                    posizione = sc.next();
                    biblioteca.consultazione(posizione);
                    break;
                case 5:
                    biblioteca.visualizzazioneArticoliPrestati();
                    break;
                default:
            }

            switch (sceltaUtente){
                case 1:
                    System.out.println("Inserire username: ");
                    username = sc.next();
                    System.out.println("Inserire password: ");
                    password = sc.next();
                    biblioteca.registraUtente(username, password);
                    break;
                case 3:
                    System.out.println("Inserire username: ");
                    username = sc.next();
                    System.out.println("Inserire password: ");
                    password = sc.next();
                    biblioteca.stampaPrestitiUtente(username, password);
                    break;
                default:
            }
        }while(sceltaBibliotecario != 0 || sceltaUtente != 0);



        //scrittura sul file prima dell'uscita
        try {
            FileOutputStream fos = new FileOutputStream("Bibli.mao");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(biblioteca);


            fos.flush();
            fos.close();
            oos.flush();
            oos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
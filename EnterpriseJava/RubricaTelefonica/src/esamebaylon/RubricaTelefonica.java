package esamebaylon;

import java.util.Scanner;

public class RubricaTelefonica {

	public static void main(String[] args) {
		
		
		Rubrica rubrica = new Rubrica();
	
	    Scanner sc = new Scanner(System.in);
        int scelta;
        do {
            System.out.println("Rubrica Miriam Baylon");
            System.out.println("1. Aggiungi Contatto Rubrica");
            System.out.println("2. Rimuovi Contatto in Rubrica");
            System.out.println("3. Cerca Numero in Rubrica");
            System.out.println("4. Stampa la Rubrica");
            System.out.println("0. Esci");
            System.out.println("Inserisci la tua scelta ->");
            scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                	
                	System.out.println("Inserisci nome");
                	String nome = sc.next();
                	System.out.println("Inserisci cognome");
                	String cognome = sc.next();
                	System.out.println("Inserisci numero di telefono");
                	String numero = sc.next();
                	Contatto contatto = new Contatto (nome, cognome, numero);
                    rubrica.aggiungiContatto(contatto);
                    break;

                case 2:
      
                	System.out.println("Inserisci nome da rimuovere");
                	String nomeDaRimuovere = sc.next();
                	System.out.println("Inserisci cognome da rimuovere");
                	String cognomeDaRimuovere = sc.next();
                    rubrica.rimuoviContatto(nomeDaRimuovere, cognomeDaRimuovere );
                    
                    break;
                case 3:
                	System.out.println("Inserisci nome da cercare");
                	String nomeDaCercare = sc.next();
                	System.out.println("Inserisci cognome da cercare");
                	String cognomeDacercare = sc.next();
                    rubrica.cercaNumero(nomeDaCercare, cognomeDacercare );
                    break;
                case 4:
                   System.out.println(rubrica);
                    break;
                default:
                    break;

            }
        } while (scelta != 0);
    }

}

package ApuliaDigitalBank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BancaMain {

	public static void main(String[] args) {
		// TODO APULIA DIGITAL BANK
		Scanner sc = new Scanner(System.in);
		ArrayList<Correntista> aCorrentisti = new ArrayList<Correntista>();
		ArrayList<Correntista> correntistaFido = new ArrayList<Correntista>();

		ContoCorrente c1 = new ContoCorrente("IT 000001", 1000);
		ContoCorrente c2 = new ContoCorrente("IT 005555", 20000);
		ContoCorrente c3 = new ContoCorrente("IT 006985", 35000);
		ContoCorrente c4 = new ContoCorrente("IT 025693", 25300);
		ContoCorrente c5 = new ContoCorrente("IT 002569", 25896);
		ContoCorrente c6 = new ContoCorrente("IT 002598", 60058);

		ContoScoperto cS1 = new ContoScoperto("IT 000000012", 500, 500);
		ContoScoperto cS2 = new ContoScoperto("IT 000000012", 2500, 500);
		ContoScoperto cS3 = new ContoScoperto("IT 000000012", 2500, 500);
		ContoScoperto cS4 = new ContoScoperto("IT 000000012", 2500, 500);

		Correntista miriam = new Correntista("Miriam", "Baylon", "13/10/1988", "BYLMRA", "Via D'aragina", c1);
		aCorrentisti.add(miriam);
		Correntista fabio = new Correntista("Fabio", "Ciafardini", "28/05/1995", "FBOCFR", "Via Tal dei Tali", c2);
		aCorrentisti.add(fabio);
		Correntista giovanni = new Correntista("Giovanni", "Filannino", "25/12/1969", "GNNFLN", "Via Girolamo", c3);
		aCorrentisti.add(giovanni);
		Correntista verbena = new Correntista("Verbena", "Filannino", "25/12/1969", "GNNFLN", "Via Girolamo", c4);
		aCorrentisti.add(verbena);
		Correntista zoe = new Correntista("Zoe", "Filannino", "25/12/1969", "GNNFLN", "Via Girolamo", c5);
		aCorrentisti.add(zoe);
		Correntista pasquale = new Correntista("Pasquale", "Ciaoooo", "25/05/1995", "GNNFLN", "Via Girolamo", c6);
		aCorrentisti.add(pasquale);

		Correntista miriamS = new Correntista("Miriam", "Baylon", "13/10/1988", "BYLMRA", "Via D'aragina", cS1);
		correntistaFido.add(miriamS);
		Correntista fabioS = new Correntista("Fabio", "Ciafardini", "28/05/1995", "FBOCFR", "Via D'aragina", cS2);
		correntistaFido.add(fabioS);
		Correntista zoeS = new Correntista("Zoe", "Lombardi", "25/12/1995", "BYLMRA", "Via D'aragina", cS3);
		correntistaFido.add(zoeS);
		Correntista verbenaS = new Correntista("Verbena", "Siliberti", "13/10/1988", "BYLMRA", "Via D'aragina", cS4);
		correntistaFido.add(verbenaS);
		
		
		int scelta;
		do {
			System.out.println("APULIA DIGITAL BANK");
			System.out.println("1. Digita 1 per prelevare");
			System.out.println("2. Digita 2 per versare");
			System.out.println("3. Digita 3 per stampare il saldo");
			System.out.println("4. Digita 4 per stampare dati Correntisti");
			System.out.println("5. Digita 5 per effettuare un bonifico");
			System.out.println("6. Digita 6 per effettuare un prelievo con Fido");
			System.out.println("0. Esci");

			System.out.println("Inserisci la tua scelta ->");
			scelta = sc.nextInt();
			switch (scelta) {
			case 1:
				int indiceStampa1 = 0;
				boolean controllo1 = true;
				do {

					for (int i = 0; i < aCorrentisti.size(); i++) {

						System.out.println(
								i + " " + aCorrentisti.get(i).getNome() + " " + aCorrentisti.get(i).getCognome());

					}

					controllo1 = true;

					try {

						System.out.println("inserisci il numero del conto da cui prelevare ");

						indiceStampa1 = sc.nextInt();

						if (indiceStampa1 < 0 || indiceStampa1 > aCorrentisti.size()) {

							throw new EccezioneControlloIndiceArrayList(
									"hai inserito un numero di conto corrente non valido");

						} else {

							aCorrentisti.get(indiceStampa1).getContoCorrente().prelievo();

						}
					} catch (EccezioneControlloIndiceArrayList messaggio) {

						System.out.println("Errore: " + messaggio.getMessage());

						controllo1 = false;

					} catch (InputMismatchException e) {

						System.out.println("Errore: input non valido assicurarsi di inserire un valore numerico");

						controllo1 = false;

					}

					sc.nextLine();

				} while (indiceStampa1 < 0 || indiceStampa1 > aCorrentisti.size() || controllo1 == false);
				break;
			case 2:
				for (int i = 0; i < aCorrentisti.size(); i++) {
					System.out.println("Digita " + i + " per " + aCorrentisti.get(i).getNome() + " "
							+ aCorrentisti.get(i).getCognome());
				}
				System.out.println("Inserisci indice conto Versare");
				int indiceA = sc.nextInt();
				aCorrentisti.get(indiceA).getContoCorrente().accredito();
				break;
			case 3:
				boolean controllo3 = true;
				int indiceStampa3 = 0;
				do {
					for (int i = 0; i < aCorrentisti.size(); i++) {

						System.out.println("Digita " + i + " per " + aCorrentisti.get(i).getNome() + " "
								+ aCorrentisti.get(i).getCognome());
					}
					controllo3 = true;
					try {

						System.out.println("inserisci il numero del conto che vuoi stampare ");
						indiceStampa3 = sc.nextInt();
						if (indiceStampa3 < 0 || indiceStampa3 > aCorrentisti.size()) {

							throw new EccezioneControlloIndiceArrayList(
									"hai inserito un numero di conto corrente non valido");
						} else {
							aCorrentisti.get(indiceStampa3).getContoCorrente().stampaSaldo();
						}
					} catch (EccezioneControlloIndiceArrayList messaggio) {
						System.out.println("Errore: " + messaggio.getMessage());
						controllo3 = false;
					}

					catch (InputMismatchException e) {

						System.out.println("Errore: input non valido assicurarsi di inserire un valore numerico");

						controllo3 = false;

					}
					sc.nextLine();

				} while (indiceStampa3 < 0 || indiceStampa3 > aCorrentisti.size() - 1 || controllo3 == false);
				break;
			case 4:
				// richiamo il toString per stampare l'oggetto
				for (int i = 0; i < aCorrentisti.size(); i++) {
					System.out.println(aCorrentisti.get(i).toString());
				}
				for (int i = 0; i < correntistaFido.size(); i++) {
					System.out.println(correntistaFido.get(i).toString());
				}
				break;
			case 5: {
				for (int i = 0; i < aCorrentisti.size(); i++) {
					System.out.println("Digita " + i + " per " + aCorrentisti.get(i).getNome() + " "
							+ aCorrentisti.get(i).getCognome());
				}
				System.out.println("Inserisci indice mittente");
				int indiceMittente = sc.nextInt();

				for (int i = 0; i < aCorrentisti.size(); i++) {
					System.out.println("Digita " + i + " per " + aCorrentisti.get(i).getNome() + " "
							+ aCorrentisti.get(i).getCognome());
				}
				System.out.println("Inserisci indice destinatario");
				int indiceDestinatario = sc.nextInt();
				aCorrentisti.get(indiceMittente).getContoCorrente().effettuaBonifico(aCorrentisti, indiceMittente,
						indiceDestinatario);
			}
				break;
			case 6:
				int indiceStampa2 = 0;
				boolean controllo6 = true;
				do {
					for (int i = 0; i < correntistaFido.size(); i++) {
						System.out.println(
								i + " " + correntistaFido.get(i).getNome() + " " + correntistaFido.get(i).getCognome());
					}
					controllo6 = true;
					try {
						System.out.println("inserisci il numero del conto da cui prelevare ");
						indiceStampa2 = sc.nextInt();
						if (indiceStampa2 < 0 || indiceStampa2 > correntistaFido.size()) {
							throw new EccezioneControlloIndiceArrayList(
									"hai inserito un numero di conto corrente non valido");
						} else {
							correntistaFido.get(indiceStampa2).getContoCorrente().prelievo();
						}
					} catch (EccezioneControlloIndiceArrayList messaggio) {
						System.out.println("Errore: " + messaggio.getMessage());
						controllo6 = false;
					} catch (InputMismatchException e) {
						System.out.println("Errore: input non valido assicurarsi di inserire un valore numerico");
						controllo6 = false;
					}
					sc.nextLine();
				} while (indiceStampa2 < 0 || indiceStampa2 > correntistaFido.size() || controllo6 == false);
				break;
			default:
				System.out.println("Inserisci un numero valido");
				break;
			}
		} while (scelta != 0);
	}
}

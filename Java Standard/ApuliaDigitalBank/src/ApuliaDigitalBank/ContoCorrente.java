package ApuliaDigitalBank;

import java.util.ArrayList;
import java.util.Scanner;

public class ContoCorrente {
Scanner sc = new Scanner(System.in);

//ATTRIBBUTI
	private String iban;
	private double saldo;

	protected double importo;

//COSTRUTTORE
	public ContoCorrente(String iban, double saldo) {
		this.iban = iban;
		this.saldo = saldo;

	}

//GET E SET
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;

	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

//METODI
	public void prelievo() {
		boolean controllo = true;
		do {
			controllo = true;
			try {
				System.out.println("Inserisci l'importo del prelievo");
				this.importo = sc.nextDouble();
				if (this.importo < 0) {
					throw new EccezioniPrelievo("L'importo non può essere negativo");
				}
				if (this.saldo <= this.importo) {
					throw new EccezioniPrelievo("Importo non disponibile");
				} else
					this.saldo = this.saldo - this.importo;
				System.out.println("Prelievo eseguito correttamente");
			} catch (EccezioniPrelievo messaggio) {
				System.out.println("Errore: " + messaggio.getMessage());
				controllo = false;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Errore: input non valido. Assicurati di inserire un valore numerico.");
				controllo = false;
				sc.nextLine();
			}

		} while (this.importo < 0 || this.saldo <= this.importo || controllo == false);
	}

	public void accredito() {
		boolean controllo = true;
		do {
			controllo = true;
			try {
				System.out.println("Inserisci l'accredito");
				this.importo = sc.nextDouble();
				if (this.importo <= 0) {
					throw new EccezioniAccredito("ERRORE: Importo Inferiore o Uguale a zero");
				}
				if (this.importo % 10 != 0) {
					throw new EccezioniAccredito("ERRORE: Importo non depositabile");
				} else
					this.saldo = this.saldo + importo;
				System.out.println("L'accredito è stato eseguito");
			} catch (EccezioniAccredito messaggio) {
				System.out.println(messaggio.getMessage());
				controllo = false;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Errore: input non valido. Assicurati di inserire un valore numerico.");
				controllo = false;
				sc.nextLine();
			}

		} while (this.importo < 0 || this.saldo <= this.importo || this.importo % 10 != 0 || controllo == false);
	}

	public void stampaSaldo() {
		System.out.println("Il saldo disponibile è " + this.saldo);

	}

	public void effettuaBonifico(ArrayList<Correntista> aCorrentisti, int mittente, int beneficiario) {
		System.out.println("Inserisci l'importo del bonifico");
		this.importo = sc.nextDouble();
		double saldoMittente = aCorrentisti.get(mittente).getContoCorrente().getSaldo() - this.importo;
		double saldoBeneficiario = aCorrentisti.get(beneficiario).getContoCorrente().getSaldo() + this.importo;
		aCorrentisti.get(mittente).getContoCorrente().setSaldo(saldoMittente);
		aCorrentisti.get(beneficiario).getContoCorrente().setSaldo(saldoBeneficiario);
		System.out.println("Il saldo di " + aCorrentisti.get(mittente).getNome() + " " + " è: " + saldoMittente
				+ System.lineSeparator() + "Il saldo di " + aCorrentisti.get(beneficiario).getNome() + " " + " è: "
				+ saldoBeneficiario);

	}

	@Override

	public String toString() {
		return "iban: " + this.iban + System.lineSeparator() + "Saldo: " + this.saldo;
	}

}

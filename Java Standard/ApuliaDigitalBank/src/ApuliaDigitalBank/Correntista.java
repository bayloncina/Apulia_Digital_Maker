package ApuliaDigitalBank;

import java.util.Scanner;

public class Correntista {
	Scanner sc = new Scanner(System.in);

	private String nome, cognome, codiceFiscale, indirizzo, dataDiNascita;

	ContoCorrente contoCorrente;

	public ContoCorrente getContoCorrente() {
		return contoCorrente;
	}

	public void setContoCorrente(ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
	}

//COSTRUTTORE
	public Correntista(String nome, String cognome, String dataDiNascita, String codiceFiscale, String indirizzo,
			ContoCorrente contoCorrente) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.contoCorrente = contoCorrente;
	}

//GET E SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + System.lineSeparator() + "Cognome: " + this.cognome + System.lineSeparator()
				+ "Data di Nascita: " + this.dataDiNascita + System.lineSeparator() + this.contoCorrente;

	}

	public ContoCorrente getContoScoperto() {
		// TODO Auto-generated method stub
		return null;
	}
}

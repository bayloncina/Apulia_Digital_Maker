package testdbdvdrental2;

public class Utente {
	private int idUtente;
	private String nome;
	private String cognome;
	

public Utente(int idUtente, String nome, String cognome) {
	this.idUtente = idUtente;
	this.nome = nome;
	this.cognome = cognome;
}


public int getIdUtente() {
	return idUtente;
}


public void setIdUtente(int idUtente) {
	this.idUtente = idUtente;
}


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


@Override
public String toString() {
	return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + "]";
}

}

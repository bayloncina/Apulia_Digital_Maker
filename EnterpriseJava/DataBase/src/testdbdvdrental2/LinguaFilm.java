package testdbdvdrental2;

import java.sql.Timestamp;

public class LinguaFilm {

	private int idLinguaFilm;
	private String linguaFilm;
	private Timestamp dataAggiornamento;

	public LinguaFilm() {}

	public LinguaFilm(String linguaFilm, Timestamp dataAggiornamento) {
		this.linguaFilm=linguaFilm;
		this.dataAggiornamento=dataAggiornamento;
	}

	public int getIdLinguaFilm() {
		return idLinguaFilm;
	}

	public void setIdLinguaFilm(int idLinguaFilm) {
		this.idLinguaFilm = idLinguaFilm;
	}

	public String getLinguaFilm() {
		return linguaFilm;
	}

	public void setLinguaFilm(String linguaFilm) {
		this.linguaFilm = linguaFilm;
	}

	public Timestamp getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(Timestamp dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public String toString() {
		return "LinguaFilm [idLinguaFilm=" + idLinguaFilm + ", linguaFilm=" + linguaFilm + ", dataAggiornamento="
				+ dataAggiornamento + "]";
	}



}


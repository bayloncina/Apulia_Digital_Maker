package testdbdvdrental2;
import java.sql.Timestamp;

public class Film {
	
	private int film_id;
	private String titolo;
	private String trama;
	private int linguaFilm;
	private int anno_uscita;
	private int giorni_noleggio;
	private double tariffa;
	private double caparra;
	private Timestamp dataAggiornamento;
	
	public Film(int film_id, String titolo, String trama, int linguaFilm,int anno_uscita, int giorni_noleggio, double tariffa, Timestamp dataAggiornamento) {
		this.film_id=film_id;
		this.titolo=titolo;
		this.trama=trama;
		this.linguaFilm=linguaFilm;
		this.anno_uscita=anno_uscita;
		this.giorni_noleggio=giorni_noleggio;
		this.tariffa=tariffa;
		this.dataAggiornamento=dataAggiornamento;
	}
	
	public Timestamp getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(Timestamp dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public double getTariffa() {
		return tariffa;
	}

	public void setTariffa(double tariffa) {
		this.tariffa = tariffa;
	}

	public int getLinguaFilm() {
		return linguaFilm;
	}

	public void setLinguaFilm(int linguaFilm) {
		this.linguaFilm = linguaFilm;
	}

	public Film() {}

	public double getCaparra() {
		return caparra;
	}

	public void setCaparra(double caparra) {
		this.caparra = caparra;
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public int getAnno_uscita() {
		return anno_uscita;
	}

	public void setAnno_uscita(int anno_uscita) {
		this.anno_uscita = anno_uscita;
	}

	public int getGiorni_noleggio() {
		return giorni_noleggio;
	}

	public void setGiorni_noleggio(int giorni_noleggio) {
		this.giorni_noleggio = giorni_noleggio;
	}

	public String toString() {
		return "Film [film_id=" + film_id + ", titolo=" + titolo + ", trama=" + trama + ", linguaFilm=" + linguaFilm
				+ ", anno_uscita=" + anno_uscita + ", giorni_noleggio=" + giorni_noleggio + ", tariffa=" + tariffa
				+ ", caparra=" + caparra + ", dataAggiornamento=" + dataAggiornamento + "]";
	}

}

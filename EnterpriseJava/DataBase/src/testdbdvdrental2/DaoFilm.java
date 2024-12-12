package testdbdvdrental2;

import java.sql.*;
import java.util.*;
import java.util.Date;


public class DaoFilm extends AbstractDAORental {
	
	private static final DaoFilm istance = new DaoFilm();
	
	private DaoFilm() {};
	
	public static DaoFilm getInstance() {
		return istance;
	}
	
	public Film inserisciFilm(Film film) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, replacement_cost) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	
		preparedStatement.setString(1, film.getTitolo() );
		preparedStatement.setString(2, film.getTrama());
		preparedStatement.setInt(3, film.getAnno_uscita());
		preparedStatement.setInt(4, film.getLinguaFilm());
		preparedStatement.setInt(5, film.getGiorni_noleggio());
		preparedStatement.setDouble(6, film.getTariffa());
		preparedStatement.setDouble(7, film.getCaparra());
		
		int row = preparedStatement.executeUpdate();
	
		ResultSet res = preparedStatement.getGeneratedKeys();
		if (res.next()) {
			film.setFilm_id(res.getInt(1));
		}
		res.close();
		preparedStatement.close();
		conn.close();
		return film;
	}
	
	public Vector<Film> getFilms() throws SQLException{
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		ResultSet res = state.executeQuery("SELECT * FROM film INNER JOIN language ON film.language_id = language.language_id ");
		Vector <Film> allFilm = new Vector<Film>();
		
		while(res.next()) {
			
			LinguaFilm linguaggio = new LinguaFilm();
			linguaggio.setIdLinguaFilm(res.getInt("language_id"));
			linguaggio.setLinguaFilm(res.getString("name"));
			linguaggio.setDataAggiornamento(res.getTimestamp("last_update"));
			
			Film film = new Film();
			film.setFilm_id(res.getInt("film_id"));
			film.setTitolo(res.getString("title"));
			film.setTrama(res.getString("description"));
			film.setLinguaFilm(res.getInt("language_id"));
			film.setAnno_uscita(res.getInt("release_year"));
			film.setGiorni_noleggio(res.getInt("rental_duration"));
			film.setTariffa(res.getDouble("rental_rate"));
			film.setDataAggiornamento(res.getTimestamp("last_update"));
			allFilm.add(film);
		}
		
		res.close();
		state.close();
		conn.close();
		
		return allFilm;
	}
	
	public Film cercaIdFilm(Film film) throws SQLException {
		
		Connection conn = getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM film WHERE film.film_id=?");
		ResultSet res = preparedStatement.executeQuery();
		preparedStatement.setInt(1, film.getFilm_id());
		
		while (res.next()) {
			film.setFilm_id(res.getInt("film_id"));
			film.setTitolo(res.getString("title"));
			film.setTrama(res.getString("description"));
			film.setLinguaFilm(res.getInt("language_id"));
			film.setAnno_uscita(res.getInt("release_year"));
			film.setGiorni_noleggio(res.getInt("rental_duration"));
			film.setTariffa(res.getDouble("rental_rate"));
			film.setDataAggiornamento(res.getTimestamp("last_update"));
		}
		
		res.close();
		preparedStatement.close();
		conn.close();
		return film;
	
	}
	
	public Vector<Film> cercaPerTitotlo(String titolo) throws SQLException {
		
		Vector<Film> films = new Vector<Film>();
		Film film = null;
		Connection conn = getConnection();
		Statement state= conn.createStatement();
		ResultSet res = state.executeQuery("SELECT * FROM film WHERE title LIKE '%"+titolo+"%'");
		while(res.next()) {
			
			film = new Film();
			film.setFilm_id(res.getInt("film_id"));
			film.setTitolo(res.getString("title"));			
			film.setTrama(res.getString("description"));
			film.setAnno_uscita(res.getInt("release_year"));
			film.setLinguaFilm(res.getInt("language_id"));
			film.setGiorni_noleggio(res.getInt("rental_duration"));
			film.setTariffa(res.getDouble("rental_rate"));
			film.setCaparra(res.getDouble("replacement_cost"));
			film.setDataAggiornamento(res.getTimestamp("last_update"));
			films.add(film);
		}
		res.close();
		state.close();
		conn.close();
		return films;
	} 
	
	public Film cercaPerUd(Film film) throws SQLException {
		
		
		Connection conn = getConnection();
		PreparedStatement prepar = conn.prepareStatement("SELECT * FROM film WHERE title LIKE '%"+film.getFilm_id()+"%'");
		ResultSet res = prepar.executeQuery();
		while(res.next()) {
			
			film.setFilm_id(res.getInt("film_id"));
			film.setTitolo(res.getString("title"));			
			film.setTrama(res.getString("description"));
			film.setAnno_uscita(res.getInt("release_year"));
			film.setLinguaFilm(res.getInt("language_id"));
			film.setGiorni_noleggio(res.getInt("rental_duration"));
			film.setTariffa(res.getDouble("rental_rate"));
			film.setCaparra(res.getDouble("replacement_cost"));
			film.setDataAggiornamento(res.getTimestamp("last_update"));
		}
		res.close();
		prepar.close();
		conn.close();
		return film;
	} 

	
	public Film getFilm() throws SQLException {
		
		Film film = new Film();
		Connection conn = getConnection();
		PreparedStatement prepar = conn.prepareStatement("SELECT * FROM film WHERE title LIKE '%"+film.getTitolo()+"%'");
		ResultSet res = prepar.executeQuery();
		while(res.next()) {
			
			film.setFilm_id(res.getInt("film_id"));
			film.setTitolo(res.getString("title"));			
			film.setTrama(res.getString("description"));
			film.setAnno_uscita(res.getInt("release_year"));
			film.setLinguaFilm(res.getInt("language_id"));
			film.setGiorni_noleggio(res.getInt("rental_duration"));
			film.setTariffa(res.getDouble("rental_rate"));
			film.setCaparra(res.getDouble("replacement_cost"));
			film.setDataAggiornamento(res.getTimestamp("last_update"));
		}
		res.close();
		prepar.close();
		conn.close();
		return film;
	}
} 


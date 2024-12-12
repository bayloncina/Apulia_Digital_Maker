package testdbdvdrental2;
import java.sql.*;

public class DaoNoleggio extends AbstractDAORental {
	private static final DaoNoleggio istance = new DaoNoleggio();

//singleton costruttore
	private DaoNoleggio() {
	};

	// connessione al database
	public static DaoNoleggio getInstance() {
		return istance;
	}
	
	public void noleggiaFilm(int idFilm, int idUtente) {
        String query = "INSERT INTO noleggi (id_film, id_utente, data_noleggio) VALUES (?, ?, NOW())";
        
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idFilm);
            stmt.setInt(2, idUtente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

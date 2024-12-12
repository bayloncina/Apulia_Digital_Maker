package dataBase;
import java.sql.*;

public class TestDataBase {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:postgresql://localhost:5432/dvdrental";
		String username = "postgres";
		String password = "admin";

		// Prova a connetterti al database
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connessione riuscita");
			// Puoi utilizzare la connessione qui per eseguire le query
			// Ricorda di chiudere la connessione quando hai finito con essa
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
	}

}

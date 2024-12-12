package testdbdvdrental2;
import java.sql.*;

public abstract class AbstractDAORental {
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://127.0.0.1:5432/dvdrental";
	private static String user = "postgres";
	private static String password = "admin";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	protected static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conn;

	}
}
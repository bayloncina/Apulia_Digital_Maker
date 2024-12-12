package dbEsame;

import java.sql.*;

public class AbstractDAOProduct {
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://127.0.0.1:5432/dbesame";
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

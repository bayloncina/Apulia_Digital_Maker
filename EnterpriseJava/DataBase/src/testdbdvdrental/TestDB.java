package testdbdvdrental;

import java.sql.*;
import java.util.Vector;

/**
 * @author Administrator
 *
 */
public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// Carica in memoria l'implementazione del driver JDBC
			String driver = "org.postgresql.Driver"; // Nome completo driver JDBC
			Class.forName(driver);

			String url = "jdbc:postgresql://localhost:5432/dvdrental";
			// Connection con = DriverManager.getConnection(url,"myUserName","myPassword");
			Connection con = DriverManager.getConnection(url, "postgres", "admin");

			Statement cmd = con.createStatement();
			// chiede al database qualcosa nella tabella richiesta
			String qry = "SELECT * FROM actor";
			ResultSet res = cmd.executeQuery(qry);

			ResultSetMetaData rsmd = res.getMetaData();
			System.out.println("@@@@ " + rsmd.getColumnCount());
			System.out.println("#########################");
			Vector actor = new Vector<Actor>();
			// Vector films = new Vector<Film>();

			while (res.next()) {
				// System.out.printf("%s : %s (%s)\n", res.getString("film_id"),
				// res.getString("title"), res.getString("release_year"));
				// System.out.println(res.getInt("film_id") + " " + res.getString("title") + " "
				// + res.getString("release_year"));

				
				Actor a = new Actor();
       //Film f = new Film();
//				f.setFilmId(res.getInt("film_id"));
//				f.setTitle(res.getString("title"));
//				f.setReleaseYear(res.getString("release_year"));
                 a.setActorId(res.getInt("actor_id"));
                 a.setFirstName(res.getString("first_name"));
                 a.setLastName(res.getString("last_name"));
				// System.out.println("Film aggiunto al Vector "+f);

				//films.add(f);
                 actor.add(a);

			}

//			System.out.println(films);
//
//			System.out.println(films.size());
//
//			System.out.println(films.get(0));
			System.out.println(actor);
			System.out.println(actor.size());
			System.out.println(actor.get(0));
			res.close();
			cmd.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
package testdbdvdrental2;

import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		DaoFilm daoFilm = DaoFilm.getInstance();
		
		try {
			Vector<Film> listaFilm = daoFilm.cercaPerTitotlo("Potter");
			System.out.println(listaFilm);
			if (listaFilm != null) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package testdbdvdrental2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtente extends AbstractDAORental {
	private static final DaoUtente istance = new DaoUtente();
	private DaoUtente() {};
	
	public static DaoUtente getIstance() {
		return istance;
	};
public Utente cercaIdUtente(Utente utente) throws SQLException {
	
		
		Connection conn = getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM customer_id WHERE customer.customer_id=?");
		ResultSet res = preparedStatement.executeQuery();
		preparedStatement.setInt(1, utente.getIdUtente());
		
		while (res.next()) {
			utente.setIdUtente(res.getInt("customer_id"));
			utente.setNome(res.getString("first_name"));
			utente.setCognome(res.getString("last_name"));
		}
		
		
		res.close();
		preparedStatement.close();
		conn.close();
		return utente;
}
}

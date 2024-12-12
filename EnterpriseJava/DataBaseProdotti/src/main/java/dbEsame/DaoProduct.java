package dbEsame;

import java.sql.*;
import java.util.*;

public class DaoProduct extends AbstractDAOProduct {
	// Costruttore privato che impedisce l'istanziazione
	// di nuovi oggetti DaoProduct dall'esterno della classe.
	private static final DaoProduct istance = new DaoProduct();

	private DaoProduct() {
	};

	// Metodo statico che restituisce l'istanza unica di DaoProduct (implementazione
	// del pattern Singleton).
	public static DaoProduct getInstance() {
		return istance;
	}

    //Inserisce un nuovo prodotto nel database utilizzando i dati forniti come parametro. Utilizza una PreparedStatement per 
	// prevenire le SQL Injection. Dopo l'inserimento, ottiene l'ID generato
	// automaticamente dal database per il nuovo prodotto.
	public Product inserisciProdotto(Product product) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(
				"INSERT INTO product ( name, brand, madein, price) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, product.getName());
		preparedStatement.setString(2, product.getBrand());
		preparedStatement.setString(3, product.getMadein());
		preparedStatement.setDouble(4, product.getPrice());

		int row = preparedStatement.executeUpdate();

		ResultSet res = preparedStatement.getGeneratedKeys();
		if (res.next()) {
			product.setId(res.getInt(1));
		}
		res.close();
		preparedStatement.close();
		conn.close();
		return product;
	}
    //recupera tutti i prodotti presenti nel database e li restituisce come un vettore di oggetti Product.
	public Vector<Product> getProduct() throws SQLException {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		ResultSet res = state.executeQuery("SELECT * FROM product");
		Vector<Product> allProduct = new Vector<Product>();

		while (res.next()) {

			Product product = new Product(0, null, null, null, 0);

			product.setId(res.getInt("id"));
			product.setName(res.getString("name"));
			product.setBrand(res.getString("brand"));
			product.setMadein(res.getString("madein"));
			product.setPrice(res.getDouble("price"));

			allProduct.add(product);

		}

		res.close();
		state.close();
		conn.close();

		return allProduct;
	}
	
//elimina un prodotto dal database utilizzando l'ID del prodotto fornito come parametro.
	public void eliminaProdotto(int productId) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM product WHERE id = ?");
		preparedStatement.setInt(1, productId);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		conn.close();
	}

}

package dbEsame;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Questa annotazione mappa la servlet a un URL specifico.
@WebServlet("/DbEsameServlet")

//Definizione della classe DbEsameServlet che estende HttpServlet, rendendola una servlet
public class DbEsameServlet extends HttpServlet {

	// Identificatore della versione della classe per scopi di serializzazione.
	private static final long serialVersionUID = 1L;

	// Dichiarazione dell'oggetto daoProduct della classe DaoProduct per interagire
	// con il database.
	private DaoProduct daoProduct;

	public DbEsameServlet() {
		super();
		daoProduct = DaoProduct.getInstance();
	}

	// Il metodo doGet() gestisce le richieste HTTP GET. Invoca il metodo
	// visualizzaProdotti() per visualizzare i prodotti.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			visualizzaProdotti(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Il metodo doPost() esegue un azione specifica in base a quello richiesto
	// dall'utente
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "inserisciProdotto":
			inserisciProdotto(request, response);
			break;
		case "eliminaProdotto":
			eliminaProdotto(request, response);
			break;

		default:
			response.getWriter().println("Azione non supportata.");
		}
	}

	// recupera i parametri della richiesta per creare un nuovo oggetto Product,
	// quindi chiama il metodo
	// inserisciProdotto() di daoProduct per inserire il prodotto nel database.
	private void inserisciProdotto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String madein = request.getParameter("madein");
		double price = Double.parseDouble(request.getParameter("price"));

		Product product = new Product(0, name, brand, madein, price);

		try {
			daoProduct.inserisciProdotto(product);
			// reindirizza alla pagina principale dopo l'inserimento
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

    //recupera l'ID del prodotto dalla richiesta e chiama il metodo eliminaProdotto() 
	// di daoProduct per eliminare il prodotto dal database.
	private void eliminaProdotto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));

		try {
			daoProduct.eliminaProdotto(productId);

			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	// recupera tutti i prodotti dal database utilizzando daoProduct
	// e li passa alla pagina JSP visualizzaProdotti.jsp per la visualizzazione.
	private void visualizzaProdotti(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		DaoProduct daoProduct = DaoProduct.getInstance();
		Vector<Product> products = daoProduct.getProduct();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/visualizzaProdotti.jsp").forward(request, response);

	}

}

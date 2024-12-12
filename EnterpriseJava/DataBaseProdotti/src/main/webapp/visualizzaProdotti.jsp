<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector"%>
<%@ page import="dbEsame.DaoProduct"%>
<%@ page import="dbEsame.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prodotti in Magazzino</title>
<!-- Includi i file CSS di Bootstrap -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
 body {
        background-color: #f8f9fa; 
        color: #343a40; 
    }
    h1 {
        color: #28a745; /* Verde */
    }

.container {
        background-color: #ffffff; 
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        margin-top: 50px;
    }

.btn-primary {
        background-color: #bb2d3b; 
        border-color: #bb2d3b; 
    }
    .btn-primary:hover {
        background-color: #0056b3; 
        border-color: #0056b3; 
    }
    .btn-secondary {
        background-color: #6c757d; 
        border-color: #6c757d; 
    }
    .btn-secondary:hover {
        background-color: #ffc107; 
        border-color: #ffc107; 
    }
    .form-control {
        border-color: #ced4da; 
    }
.table {
	background-color: #ffffff; /* Bianco */
}

.table th, .table td {
	border-color: #dee2e6; /* Grigio chiaro */
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center mb-4">Prodotti in Magazzino</h1>

		<%
		// Otteniamo tutti i prodotti dal database utilizzando DaoProduct
		DaoProduct daoProduct = DaoProduct.getInstance();
		Vector<Product> products = null;
		try {
			products = daoProduct.getProduct();
		} catch (Exception e) {
			out.println("Errore durante il recupero dei prodotti: " + e.getMessage());
		}
		%>

		<%
		if (products != null && !products.isEmpty()) {
		%>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Brand</th>
						<th>Madein</th>
						<th>Prezzo</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Product product : products) {
					%>
					<tr>
						<td><%=product.getId()%></td>
						<td><%=product.getName()%></td>
						<td><%=product.getBrand()%></td>
						<td><%=product.getMadein()%></td>
						<td><%=product.getPrice()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<%
		} else {
		%>
		<p class="text-center">Nessun prodotto presente.</p>
		<%
		}
		%>

		<div class="text-center mt-4">
			<a href="Index.jsp" class="btn btn-success">Torna alla Home</a>
		</div>
	</div>
	<!-- Includi i file JavaScript di Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

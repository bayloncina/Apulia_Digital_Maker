<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prodotti</title>
<!-- Includi i file CSS di Bootstrap -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa; /* Grigio chiaro */
        color: #343a40; /* Nero */
    }
    .container {
        background-color: #ffffff; /* Bianco */
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .navbar-brand {
        color: #17a2b8 !important; /* Azzurro */
        font-weight: bold;
        font-size: 20px;
        margin-right: 10px;
    }
    .navbar-brand:hover {
        color: #138496 !important; /* Azzurro più scuro */
        text-decoration: none;
    }
    h1 {
        color: #28a745; /* Verde */
    }
</style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1 class="text-center">Il Magazzino di Miriam</h1>
        </div>
    </div>
</div>
<div class="card text-center">
  <div class="card-body">
    <h5 class="card-title">Vuoi Aggiungere un prodotto?</h5>
    <a href="inserisciProdotto.jsp" class="btn btn-success">Clicca qui</a>
  </div>
</div>
<div class="card text-center">
  <div class="card-body">
    <h5 class="card-title">Vuoi Eliminare un prodotto?</h5>
    <a href="eliminaProdotto.jsp" class="btn btn-success">Clicca qui</a>
  </div>
</div>
<div class="card text-center">
  <div class="card-body">
    <h5 class="card-title">Vuoi Visualizzare i prodotti presenti in magazzino?</h5>
    <a href="visualizzaProdotti.jsp" class="btn btn-success">Clicca qui</a>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

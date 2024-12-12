<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elimina Prodotto</title>
<!-- Includi i file CSS di Bootstrap -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
</style>
</head>
<body>
    <div class="container">
        <h1 class="text-center mb-4">Elimina Prodotto</h1>
        <form action="DbEsameServlet" method="post">
            <input type="hidden" name="action" value="eliminaProdotto">
            <div class="form-group">
                <label for="productId">ID del Prodotto da Eliminare:</label>
                <input type="text" class="form-control" id="productId" name="productId">
            </div>
            <button type="submit" class="btn btn-success">Elimina Prodotto</button>
        </form>
        <div class="mt-4">
            <a href="Index.jsp" class="btn btn-warning">Torna alla Home</a>
        </div>
    </div>
<!-- Includi i file JavaScript di Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

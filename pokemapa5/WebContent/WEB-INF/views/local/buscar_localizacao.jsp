<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buscar Localização</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="../menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Buscar Localização</h3>
		<!-- Formulario para inclusao de locais -->
		<form action="google_jackson" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-12">
					<label for="logradouro">Logradouro</label> 
					<input type="text" class="form-control" name="logradouro" 
					id="logradouro" required maxlength="256" 
					placeholder="nome da rua, número e bairro; não coloque cidade, estado e país">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="cidade">Cidade: </label>
					<select id="cidade" name="cidade" class="form-control">
						<option value="São Paulo">São Paulo</option> 
						<option value="Rio de Janeiro">Rio de Janeiro</option> 
						<option value="Brasília">Brasília</option> 
						<option value="Santo André">Santo André</option> 
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="estado">Estado: </label>
					<select id="estado" name="estado" class="form-control">
						<option value="São Paulo">São Paulo</option> 
						<option value="Rio de Janeiro">Rio de Janeiro</option> 
						<option value="Distrito Federal">Distrito Federal</option> 
					</select>
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Buscar</button>
					<a href="index" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/Intestazione.css" rel="stylesheet" type="text/css">
	<title>Easy Travel</title>
</head>
<body>
	<div class="intestazione">
		<div class="logo">
			<a href="index.jsp">
				<img src="Immagini/logo.png" alt="Home">
			</a>
		</div>
		<div class="boxRicerca">
			<form>
			<div class="ricerca">
				<input type="search" class="barraRic" placeholder="Cerca Il Tuo Pacchetto" list="suggerimenti">
					<button type="submit" class="pulsanteRic">
						<img src="Immagini/cerca.png" alt="Cerca">
					</button>
				</div>
			</form>
		</div>
		<div class="profilo">
			<a href="profilo.jsp">
				<img src="Immagini/profilo.png">
			</a>
		</div>
		<div class="carrello">
			<a href="carrello.jsp">
				<img src="Immagini/carrello.png">
			</a>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
	<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.*"%>
<head>
	<meta charset="UTF-8">
	<title>Easy Travel</title>
	<jsp:include page="Intestazione.jsp" flush="true"/>
</head>
<body>
	<table border="1">
		<caption></caption>
		<tr><td><a href="datiUtente.jsp">Dati Utente</a></td></tr>
		<tr><td><a href="ordiniUtente.jsp">I Miei Ordini</a></td></tr>
		<tr><td><a href="index.jsp">Logout</a></td></tr>
		
	</table>
</body>
</html>
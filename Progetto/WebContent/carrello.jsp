<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  	PacchettoBean product = (PacchettoBean) request.getAttribute("product");
  	immaginiBean img = (immaginiBean) request.getAttribute("img");
  %>
<!DOCTYPE html>
<html lang="it">
	<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.*"%>
<head>
	<meta charset="UTF-8">
	<title>Easy Travel	</title>
	<jsp:include page="Intestazione.jsp" flush="true"/> 
</head>
<body>
	<h2>Products</h2>
	<table border="1">
		<tr>
			<th>Copertina</th>
			<th>Code </th>
			<th>Name </th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<tr>
			<td><img src="Immagini/<%=img.getNome() %>"></td>
			<td><%=product.getCodSeriale()%></td>
			<td><%=product.getNome()%></td>
			<td><%=product.getDescrizioneRidotta()%></td>
		</tr>
	</table>
	

</body>
</html>
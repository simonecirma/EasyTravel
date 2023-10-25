<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
 	 carrelloBean immaginiCarrello = new carrelloBean();
	immaginiCarrello=(carrelloBean)session.getAttribute("immaginiCarrello");
	carrelloBean carrello = new carrelloBean();
	carrello=(carrelloBean)session.getAttribute("carrello");
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
	<h2>Carrello</h2>
		<%
			if ((carrello != null && carrello.getPacchetti().size() != 0) && (immaginiCarrello != null && immaginiCarrello.getImmagini().size() != 0)){
		%>
		<table border="1">
		<tr>
			<th>Copertina</th>
			<th>Code </th>
			<th>Name </th>
			<th>Description</th> 
		</tr>
		<tr>
		<% 
				List <PacchettoBean> prodotti = carrello.getPacchetti();
				for (PacchettoBean pacc : prodotti) {
					List <immaginiBean> immagini = immaginiCarrello.getImmagini();
					for (immaginiBean img : immagini) {
						if(pacc.getCodSeriale().contains(img.getCodice())){
		%>	
							<td><img src="Immagini/<%=img.getNome() %>"></td>
							<td><%=pacc.getCodSeriale()%></td>
							<td><%=pacc.getNome()%></td>
							<td><%=pacc.getDescrizioneRidotta()%></td>
		</tr>
		<%
						}
					}
				}
			} else {
		%>
		<tr>
			<td colspan="6">Nessun prodotto nel carrello</td>
		</tr>
		<%
			}
		%>
	</table>
	

</body>
</html>
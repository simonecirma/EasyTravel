<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
 	carrelloBean immaginiCarrello = null;
	immaginiCarrello=(carrelloBean)session.getAttribute("immaginiCarrello");
	carrelloBean carrello = null;
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
			<th>Nome </th>
			<th>Descrizione</th>
			<th>Prezzo</th> 
			<th></th>
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
							<td><%=pacc.getNome()%></td>
							<td><%=pacc.getDescrizioneRidotta()%></td>
							<td><%=pacc.getPrezzo()%></td>
							<td>
								<a href = "pacchettoControl?action=Rimuovi&id=<%=pacc.getCodSeriale()%>">
									<img src = "Immagini/cestino.png">
								</a>
							</td>
		</tr>
		<%
							break;
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
	<%
		List <PacchettoBean> prodotti = carrello.getPacchetti();
		float tot = 0;
		for (PacchettoBean pacc : prodotti) {
			tot=tot+pacc.getPrezzo();
		}
	%>
	<div>
		Totale:<%=tot%>
	</div>
</body>
</html>
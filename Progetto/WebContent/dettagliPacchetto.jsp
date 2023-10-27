<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PacchettoBean product = (PacchettoBean) request.getAttribute("product");
	Collection<?> img = (Collection<?>) request.getAttribute("img");
	if(img == null) {
		response.sendRedirect("./pacchettoControl");	
		return;
	}
%>
<!DOCTYPE html>
<html lang="it">
	<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.*"%>
<head>
	<meta charset="UTF-8">
	<title>Easy Travel</title>
	<jsp:include page="Intestazione.jsp" flush="true"/>
</head>
<body>
	<%
			if (img != null && img.size() != 0) {
				Iterator<?> it = img.iterator();
				while (it.hasNext()) {
					immaginiBean bean = (immaginiBean) it.next();
		%>
				<img src="Immagini/<%=bean.getNome()%>" alt="Errore caricamento immagini">
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="6">No products available</td>
		</tr>
		<%
			}
		%>
	<%
		if(product != null){
	%>
			<h1> <%=product.getNome() %> <%=product.getPrezzo() %></h1>
			<h2><%=product.getDescrizioneRidotta() %></h2>	
			<h3><%=product.getDescrizione() %></h3>
	<%
		}
	%>
		<a href="pacchettoControl?action=AggiungiAlCarrello&id=<%=product.getCodSeriale()%>">
			<input class="submit" type="submit" value="Aggiungi al Carrello"> 
		</a>
</body>
</html>
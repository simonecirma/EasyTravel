<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	if(products == null) {
		response.sendRedirect("./pacchettoControl");	
		return;
	}
	Collection<?> copertine = (Collection<?>) request.getAttribute("copertine");
	if(copertine == null) {
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
	<h2>Products</h2>
	<table border="1">
		<caption></caption>
		<tr>
			<th>Copertina</th>
			<th>Nome </th>
			<th>Descrizione</th> 
			<th>Prezzo</th>
			<th>Action</th>
		</tr>
		<tr>
		<%
			if ((products != null && products.size() != 0) && (copertine != null && copertine.size() != 0)){
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					PacchettoBean bean = (PacchettoBean) it.next();
					Iterator<?> it2 = copertine.iterator();
					while(it2.hasNext()){
						immaginiBean bean2 = (immaginiBean) it2.next();
						if(bean.getCodSeriale().contains(bean2.getCodice())){
		%>
							<td><img src="Immagini/<%=bean2.getNome() %>" alt="Errore caricamento immagini"></td>
		<%
						}
					}
					
		%>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getDescrizioneRidotta()%></td>
			<td><%=bean.getPrezzo()%></td>
			<td><a href="pacchettoControl?action=delete&id=<%=bean.getCodSeriale()%>">Delete</a><br>
				<a href="pacchettoControl?action=read&id=<%=bean.getCodSeriale()%>">Details</a></td>
		</tr>
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
	</table>
</body>
</html>
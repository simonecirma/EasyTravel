<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	if(products == null) {
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
		<tr>
			<th>Code <a href="product?sort=code">Sort</a></th>
			<th>Name <a href="product?sort=name">Sort</a></th>
			<th>Description <a href="product?sort=description">Sort</a></th>
			<th>Action</th>
		</tr>
		<%
			if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					PacchettoBean bean = (PacchettoBean) it.next();
		%>
		<tr>
			<td><%=bean.getCodSeriale()%></td>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getDescrizioneRidotta()%></td>
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
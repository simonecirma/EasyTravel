<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PacchettoBean product = (PacchettoBean) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
	<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.PacchettoBean"%>
<head>
	<meta charset="UTF-8">
	<title>Easy Travel</title>
	<jsp:include page="Intestazione.jsp" flush="true"/>
</head>
<body>

	<%
		if(product != null){
	%>
	<h1> <%=product.getNome() %> <%=product.getPrezzo() %></h1>
	<h2><%=product.getDescrizione() %></h2>
	<h3><%=product.getDescrizioneRidotta() %></h3>	
	<%
		}
	%>

</body>
</html>
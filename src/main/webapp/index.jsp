<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form name="stuform" action="addAlien">
			<table border="1">
			<thead>
			<tr>
				<th>Name</th>
				<th>Id</th>
			</tr>
			</thead>
			<c:forEach var="item" items="${alien}">
			<tbody>
			<tr>
				<td>${item.aname}</td>
				<td>${item.aid}
			</td>
			</tr>
			</tbody>
			</c:forEach>
			</table>
		
	</form>

</body>
</html>

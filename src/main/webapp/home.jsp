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
	
	<form name="stuform" action="addAlien" onsubmit="return validation()">
		<input type="text" name="aname" id="aname">
		<input type="text" name="aid" >
		<input type="submit" value="submit">
		<a href="userparam?val=500">Click me</a>
	</form>

	<script type="text/javascript">
		function validation()
		{
			var aname=document.getElementById('aname').value;
			if(aname == "" || aname == null)
				{
					alert("Enter Name");
					return false;
				}
			else
				{
				
				}
		}
	
	</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2px">
		<tr>
			<th>Name</th>
			<th>User name</th>
			<th>Password</th>
			<th>Edit</th>
		</tr>

		
			<tr>
				<td>${application.name }</td>
				<td>${application.username }</td>
				<td>${application.password }</td>
				<td><a href="edit?id=${application.id}">Edit</a></td>
			</tr>
		
	</table>

</body>
</html>
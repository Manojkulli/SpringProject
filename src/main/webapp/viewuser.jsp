<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>HI ${name}</h3>
	<table border="2px">
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Action</th>
	</tr>
	<c:forEach items="${ulist}" var="user">
	<tr>
	<td>${user.id}</td>
	<td>${user.name}</td>
	<td><a href="viewapps?id=${user.id}">Open Vault</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>
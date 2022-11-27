<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
			<th>View</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
<c:forEach items="${list}" var="application">
			<tr>
				<td>${application.name }</td>
				<td><a href="view?id=${application.id}">View</a></td>
				<td><a href="delete?id=${application.id}">Delete</a></td>
				<td><a href="edit?id=${application.id}">Edit</a></td>
			</tr>
			</c:forEach>
	</table>

</body>
</html>
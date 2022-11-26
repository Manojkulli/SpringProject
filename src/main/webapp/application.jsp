<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveapplication" modelAttribute="application">

		<form:label path="name">Application Name:</form:label>
		<form:input path="name" />
		<br>

		<form:label path="username">User Name:</form:label>
		<form:input path="username" />
		<br>

		<form:label path="password">Password:</form:label>
		<form:input path="password" />
		<br>

		<input type="submit" name="submit">
		<input type="reset" name="reset">

	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Edit Page</title>
</head>
<body>
	<h1>Welcome to Employee Management Portal</h1>

	<form action="edit" method="post">
		Enter Id:<br>
		<input type="text" name="Id"><br>
		Enter First Name:<br>
		<input type="text" name="Fname"><br>
		Enter Last Name:<br>
		<input type="text" name="Lname"><br>
		Enter Email:<br>
		<input type="text" name="Email"><br> 
		<input type="submit" value="Edit">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Welcome to Employee Management Portal</h1>

	<form action="user" method="post">
		<input type="radio" name="action" value="add" checked>Add an Employee<br>
		<input type="radio" name="action" value="edit">Edit an Employee<br>
		<input type="radio" name="action" value="delete">Delete an Employee<br>
		<input type="radio" name="action" value="list">List all Employee<br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
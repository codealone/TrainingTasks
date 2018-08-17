<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dbconnect.MdbConnections"%>
<%@page import="details.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Employee e = new Employee();
MdbConnections mdb = new MdbConnections();
e.setId(request.getParameter("Id"));
e.setFname(request.getParameter("Fname"));
e.setLname(request.getParameter("Lname"));
e.setEmail(request.getParameter("Email"));
System.out.println("Input Received for edition");
if(mdb.EditEmployee(e)) {
	response.sendRedirect("result.jsp");
}else {
	System.out.println("Nothing edited");
	response.sendRedirect("wresult.jsp");
} %>
</body>
</html>
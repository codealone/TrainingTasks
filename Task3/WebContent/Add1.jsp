<%@page import="details.Employee"%>
<%@page import="dbconnect.MdbConnections"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Employee e = new Employee();
try {
	e.setId(request.getParameter("Id"));
	e.setFname(request.getParameter("Fname"));
	e.setLname(request.getParameter("Lname"));
	e.setEmail(request.getParameter("Email"));
	System.out.println("Input Received");
	MdbConnections mdb = new MdbConnections();
	if(mdb.AddEmployee(e)) {
		response.sendRedirect("result.jsp");
	}else {
		System.out.println("Nothing inserted");
		response.sendRedirect("wresult.jsp");
	}
} catch (Exception e1) {
	// TODO Auto-generated catch block
	System.out.println(e1.getMessage());
	response.sendRedirect("wresult.jsp");
}
  %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconnect.MdbConnections" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String id=request.getParameter("Id");
   System.out.println("Input Received for deletion");
   MdbConnections mdb = new MdbConnections();
if(mdb.DeleteEmployee(id)) {
	response.sendRedirect("result.jsp");
}else {
	System.out.println("Nothing deleted");
	response.sendRedirect("wresult.jsp");
} %>
</body>
</html>
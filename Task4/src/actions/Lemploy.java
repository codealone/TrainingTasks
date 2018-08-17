package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.MdbConnections;
import details.Employee;

/**
 * Servlet implementation class Lemploy
 */
@WebServlet("/Lemploy")
public class Lemploy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lemploy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");
		  MdbConnections mdb = new MdbConnections(); 
 		   List<Employee> ls = mdb.ListEmployee(); 
	      PrintWriter out = response.getWriter();
	      String title = "Listing Current Employees";
	      String docType ="<!doctype html public \"-//w3c//dtd html 4.0 " + 
	      "transitional//en\">\n";
	      String res= docType +  "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n" + 
	      		"    pageEncoding=\"UTF-8\"%>\n" + 
	      		"<%@page import=\"details.Employee\"%>\n" + 
	      		"<%@page import=\"dbconnect.MdbConnections\"%>\n" + 
	      		"<%@page import=\"java.util.List\" %>\n" + 
	      		"<!DOCTYPE html>\n" + 
	      		"<html>\n" + 
	      		"<title>Employee Management Portal</title>\n" + 
	      		"<meta charset=\"UTF-8\">\n" + 
	      		"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
	      		"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" + 
	      		"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n" + 
	      		"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\n" + 
	      		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" + 
	      		"<style>\n" + 
	      		"body,h1,h2,h3,h4,h5,h6 {font-family: \"Lato\", sans-serif}\n" + 
	      		".w3-bar,h1,button {font-family: \"Montserrat\", sans-serif}\n" + 
	      		".fa-anchor,.fa-coffee {font-size:200px}\n" + 
	      		"</style>\n" + 
	      		"<body>\n" + 
	      		"\n" + 
	      		"<!-- Navbar -->\n" + 
	      		"<div class=\"w3-top\">\n" + 
	      		"  <div class=\"w3-bar w3-red w3-card w3-left-align w3-large\">\n" + 
	      		"    <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red\" href=\"javascript:void(0);\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n" + 
	      		"    <a href=\"start\" class=\"w3-bar-item w3-button w3-padding-large w3-white\">Home</a>\n" + 
	      		"  </div>\n" + 
	      		"\n" + 
	      		"  <!-- Navbar on small screens -->\n" + 
	      		"  <div id=\"navDemo\" class=\"w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large\">\n" + 
	      		"    <a href=\"start\" class=\"w3-bar-item w3-button w3-padding-large\">Go to Home</a>\n" + 
	      		"  </div>\n" + 
	      		"</div>\n" + 
	      		"\n" + 
	      		"<!-- Header -->\n" + 
	      		"<header class=\"w3-container w3-red w3-center\" style=\"padding:128px 16px\">\n" + 
	      		"  <h1 class=\"w3-margin w3-jumbo\">Welcome to Employee Management Portal</h1>\n" + 
	      		"  <p class=\"w3-xlarge\">List of all Employees</p>\n" + 
	      		"</header>\n" + 
	      		"\n" + 
	      		"<div class=\"w3-row-padding w3-light-grey w3-padding-64 w3-container\">\n" + 
	      		"  <div class=\"w3-content\">\n" + 
	      		"    <div class=\"w3-third w3-center\">\n" + 
	      		"      <i class=\"fa fa-coffee w3-padding-64 w3-text-red w3-margin-right\"></i>\n" + 
	      		"</div>\n" + 
	      		"<div class=\"w3-twothird\">\n" + 
	      		"      <h1>List of Current Employees</h1>\n" + 
	      		"\n" + 
	      		"      <p class=\"w3-text-grey\">View the details of all the employees of the company.</p>\n" + 
	      		"      <br><br><br>\n"+ 
	      		"<table>\n" + 
	      		"	<tr>\n" + 
	      		"		<th>ID</th>\n" + 
	      		"		<th>Fname</th>\n" + 
	      		"		<th>Lname</th>\n" + 
	      		"		<th>Email</th>\n" + 
	      		"	</tr>\n"; 
	      		for(int i=0;i<ls.size();i++){  
	      		res+="	<tr>\n" + 
	      		"		<td>"+ls.get(i).getId()+"</td>\n" + 
	      		"		<td>"+ls.get(i).getFname()+"</td>\n" + 
	      		"		<td>"+ls.get(i).getLname()+" </td>\n" + 
	      		"		<td>"+ls.get(i).getEmail()+"</td>\n" + 
	      		"	</tr>\n"; 
	      		}  
	      		res+="</table>\n" + 
	      		"\n" + 
	      		"<br><br>\n" + 
	      		"<form action=\"start\"> \n" + 
	      		"<input type=\"submit\" value=\"Home Page\">\n" + 
	      		"</form>\n" + 
	      		"    </div>\n" + 
	      		"  </div>\n" + 
	      		"</div>\n" + 
	      		"\n" + 
	      		"\n" + 
	      		"<div class=\"w3-container w3-black w3-center w3-opacity w3-padding-64\">\n" + 
	      		"    <h1 class=\"w3-margin w3-xlarge\">Quote of the day: Success is the Best Revenge.</h1>\n" + 
	      		"</div>\n" + 
	      		"\n" + 
	      		"<!-- Footer -->\n" + 
	      		"<footer class=\"w3-container w3-padding-64 w3-center w3-opacity\">  \n" + 
	      		"  <div class=\"w3-xlarge w3-padding-32\">\n" + 
	      		"    <i class=\"fa fa-facebook-official w3-hover-opacity\"></i>\n" + 
	      		"    <i class=\"fa fa-instagram w3-hover-opacity\"></i>\n" + 
	      		"    <i class=\"fa fa-snapchat w3-hover-opacity\"></i>\n" + 
	      		"    <i class=\"fa fa-pinterest-p w3-hover-opacity\"></i>\n" + 
	      		"    <i class=\"fa fa-twitter w3-hover-opacity\"></i>\n" + 
	      		"    <i class=\"fa fa-linkedin w3-hover-opacity\"></i>\n" + 
	      		" </div>\n" + 
	      		" <p>Powered by <a href=\"https://www.w3schools.com/w3css/default.asp\" target=\"_blank\">Cut , Copy and Paste</a></p>\n" + 
	      		"</footer>\n" + 
	      		"\n" + 
	      		"<script>\n" + 
	      		"// Used to toggle the menu on small screens when clicking on the menu button\n" + 
	      		"function myFunction() {\n" + 
	      		"    var x = document.getElementById(\"navDemo\");\n" + 
	      		"    if (x.className.indexOf(\"w3-show\") == -1) {\n" + 
	      		"        x.className += \" w3-show\";\n" + 
	      		"    } else { \n" + 
	      		"        x.className = x.className.replace(\" w3-show\", \"\");\n" + 
	      		"    }\n" + 
	      		"}\n" + 
	      		"</script>\n" + 
	      		"\n" + 
	      		"</body>\n" + 
	      		"</html>";
	      out.print(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

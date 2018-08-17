package actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.MdbConnections;
import details.Employee;

/**
 * Servlet implementation class Add
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Employee e = new Employee();
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
	}
}

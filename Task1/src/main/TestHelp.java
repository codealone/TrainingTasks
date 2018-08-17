package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dbconnect.MySqlConnect;
import details.Employee;

public class TestHelp {
	MySqlConnect msql = MySqlConnect.getDbCon();
	Scanner sc = new Scanner(System.in);
	public boolean Add() {
		Employee e = new Employee();
		try {
			System.out.print("Enter Employee id");
			e.setId(sc.nextLine());
			System.out.print("Enter Employee First name");
			e.setFname(sc.nextLine());
			System.out.print("Enter Employee Last name");
			e.setLname(sc.nextLine());
			System.out.print("Enter Employee Email Id");
			e.setEmail(sc.nextLine());
			return msql.AddEmployee(e);
		} catch(Exception es){
			System.out.println(es.getMessage()+" Try Again");
			return false;
		}
	}
	
	public boolean Edit() {
		Employee e = new Employee();
		try {
			System.out.print("Enter Employee id");
			e.setId(sc.nextLine());
			System.out.print("Enter Employee First name");
			e.setFname(sc.nextLine());
			System.out.print("Enter Employee Last name");
			e.setLname(sc.nextLine());
			System.out.print("Enter Employee Email Id");
			e.setEmail(sc.nextLine());
			return msql.EditEmployee(e);
		} catch(Exception es){
			System.out.println(es.getMessage()+" Try Again");
			return false;
		}
	}
	
	public boolean Delete() {
		System.out.println("Enter Employee id");
		String temp = sc.nextLine();
	    try {
	    	boolean b = msql.DeleteEmployee(temp);
			System.out.println(b!=true?"Id does not exist":"Employee removed successfully");
			return b;
		} catch (SQLException es) {
			// TODO Auto-generated catch block
			System.out.println(es.getMessage()+" Try Again");
			return false;
		}
	}
	
	public boolean List() {
		List<Employee> ls = new ArrayList<Employee>();
		try {
			ls = msql.ListEmployee();
			for(int i=0;i<ls.size();i++)
				System.out.println(ls.get(i).getdetails());
		    return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+" Try Again");
			return false;
		} 
	    
	}
}
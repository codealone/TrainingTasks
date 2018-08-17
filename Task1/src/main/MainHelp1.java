package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dbconnect.Connections;
import details.Employee;

public class MainHelp1 {
	Connections s = new Connections();
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
			return s.AddEmployee(e);
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
			return s.EditEmployee(e);
		} catch(Exception es){
			System.out.println(es.getMessage()+" Try Again");
			return false;
		}
	}
	
	public boolean Delete() {
		System.out.println("Enter Employee id");
		String temp = sc.nextLine();
	    System.out.println(s.DeleteEmployee(temp)!=true?
	    "Id does not exist":"Employee removed successfully");
	    return s.DeleteEmployee(temp);
	}
	
	public boolean List() {
		List<Employee> ls = new ArrayList<Employee>();
		ls = s.ListEmployee(); 
	    for(int i=0;i<ls.size();i++)
			System.out.println(ls.get(i).getdetails());
	    return true;
	}
	
}
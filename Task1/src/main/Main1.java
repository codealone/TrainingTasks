package main;

import java.util.Scanner;

import dbconnect.Connections;
//Using H2 in-memory database
public class Main1 {
	static MainHelp1 h = new MainHelp1();
	private static enum Action{
		Add(1){
			@Override
			public boolean does() {
				return h.Add();
			}
		},
		Edit(2){
			@Override
			public boolean does() {
				return h.Edit();
			}
		},
		Delete(3){
			@Override
			public boolean does() {
				return h.Delete();
			}
		},
		List(4){
			@Override
			public boolean does() {
				return h.List();
			}
		};
		private int prop;
		private Action(int prop) {
		    this.prop = prop;
		}
		
		public int getPropName() {
		    return prop;
		 }
		public abstract boolean does();
	}
	public static void main(String args[]) {
		Connections co = new Connections();
		co.createTable();
		while(true) {
			int c;
			System.out.println("Welcome to the Employee Management Portal "
			+ "\n 1.Add Employee \n 2.Edit Employee \n 3.Delete Employee"
			+ " \n 4.List all Employees \n 5.Exit \n");
			Scanner sc = new Scanner(System.in);
			c = sc.nextInt();
			sc.nextLine();
			c--;
			if(c<Action.values().length)
				Action.values()[c].does();
			else
				System.exit(0);
		}
	}
}
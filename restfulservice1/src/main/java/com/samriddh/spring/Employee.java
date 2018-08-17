package com.samriddh.spring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	private String firstname, id, lastname, email;
	private static final String pname = "([a-zA-Z])+";
	private static final String pmail = "\\w+(@)\\w+(.)\\w+";

	private boolean validateName(String n) throws NameException {
		if (n != null) {
			if (n.length() != 0) {
				/* Pattern p = Pattern.compile("^[\\p{L} .'-]+$"); */
				Pattern p = Pattern.compile(pname);
				Matcher m = p.matcher(n);
				if (m.matches())
					return true;
			}
		}
		throw new NameException("");
	}

	private boolean validateEmail(String n) throws EmailException {
		if (n != null) {
			if (n.length() != 0) {
				/*
				 * Pattern p = Pattern.compile("^((?>[a-zA-Z\\d!#$%&'*+\\-/=?^" +
				 * "_`{|}~]+\\x20*|\"((?=[\\x01-\\x7f])[^\"\\\\]|\\\\[\\x01-\\x7f])*\"\\x20*)" +
				 * "*(?<angle><))?((?!\\.)(?>\\.?[a-zA-Z\\d!#$%&'*+\\-/=?^_`{|}~]+)+|\"((?=[\" +
				 * "\x01-\\x7f])[^\"\\\\]|\\\\[\\x01-\\x7f])*\")@(((?!-)[a-zA-Z\\d\\-]+(?<!-)" +
				 * "\\.)+[a-zA-Z]{2,}|\\[(((?(?<!\\[)\\.)(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)){4}" +
				 * "|[a-zA-Z\\d\\-]*[a-zA-Z\\d]:((?=[\\x01-\\x7f])[^\\\\\\[\\]]|\\\\[\\x01-\\" +
				 * "x7f])+)\\])(?(angle)>)$");
				 */
				Pattern p = Pattern.compile(pmail);
				Matcher m = p.matcher(n);
				if (m.matches())
					return true;
			}
		}
		throw new EmailException("");
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String fname) throws Exception {
		try {
			validateName(fname);
			this.firstname = fname;
		} catch (NameException e) {
			// TODO Auto-generated catch block
			throw new Exception("Not a Valid First Name");
		}
	}

	public String getid() {
		return id;
	}

	public void setid(String id) throws Exception {
		if (id != null) {
			if (id.length() != 0)
				this.id = id;
			else
				throw new Exception("Not a Valid ID");
		} else {
			throw new Exception("Not a Valid ID");
		}
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lname) throws Exception {
		try {
			validateName(lname);
			this.lastname = lname;
		} catch (NameException e) {
			// TODO Auto-generated catch block
			throw new Exception("Not a Valid Last Name");
		}
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) throws Exception {
		try {
			validateEmail(email);
			this.email = email;
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			throw new Exception("Not a Valid Email ID");
		}
	}

	public String getdetails() {
		String res = "Id = " + this.id + " , First Name = " + this.firstname + " , Last Name = " + this.lastname
				+ " , Email = " + this.email + " ";
		return res;
	}

}

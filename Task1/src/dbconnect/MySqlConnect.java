package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import details.Employee;

public final class MySqlConnect {
	public Connection conn;
	private PreparedStatement pstmt;
	public static MySqlConnect db;

	private MySqlConnect() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "test";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "1234";
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	public static MySqlConnect getDbCon() {
		if (db != null) {
			return db;
		}
		synchronized (db) {
			if (db == null) {
				db = new MySqlConnect();
			}
			return db;
		}
	}

	public boolean createTable() throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS EMPLOYEE(Id varchar(100) primary key,Fname varchar(100),Lname varchar(100),Email "
				+ "varchar(100)) ";
		pstmt = conn.prepareStatement(query);
		pstmt.executeUpdate();
		System.out.println("Table EMPLOYEE created");
		return true;
	}

	public boolean search(String id) throws SQLException {
		String query = "SELECT * FROM EMPLOYEE WHERE Id=" + id;
		pstmt = db.conn.prepareStatement(query);
		ResultSet res = pstmt.executeQuery();
		return res.next();
	}

	public boolean AddEmployee(Employee e) throws SQLException {
		if (!search(e.getId())) {
			String Query = "INSERT INTO EMPLOYEE" + "(Id,Fname,Lname,Email)values(?,?,?,?)";
			pstmt = db.conn.prepareStatement(Query);
			pstmt.setString(1, e.getId());
			pstmt.setString(2, e.getFname());
			pstmt.setString(3, e.getLname());
			pstmt.setString(4, e.getEmail());
			pstmt.executeUpdate();
			System.out.println("Entry done");
			return true;
		} else {
			System.out.println("Id already exists");
			return false;
		}
	}

	public boolean EditEmployee(Employee e) throws SQLException {
		if (search(e.getId())) {
			String query = "UPDATE EMPLOYEE SET Fname=?, Lname=?, Email=? WHERE Id=?";
			pstmt = db.conn.prepareStatement(query);
			pstmt.setString(1, e.getFname());
			pstmt.setString(2, e.getLname());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getId());
			pstmt.executeUpdate();
			System.out.println("Edition done");
			return true;
		} else {
			System.out.println("Id does not exists");
			return false;
		}
	}

	public boolean DeleteEmployee(String id) throws SQLException {
		if (search(id)) {
			String query = "DELETE FROM EMPLOYEE WHERE Id=" + id;
			pstmt = db.conn.prepareStatement(query);
			pstmt.executeUpdate();
			// System.out.println("Deletion Done");
			return true;
		} 
		return false;
	}

	public List<Employee> ListEmployee() throws SQLException {
		List<Employee> ls = new ArrayList<Employee>();
		String query = "SELECT * FROM EMPLOYEE";
		pstmt = db.conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Listing");
		while (rs.next()) {
			Employee e = new Employee();
			/*
			 * System.out.println("Id= "+rs.getString("Id")+" First Name= "+rs.getString(
			 * "Fname")
			 * +" Last Name= "+rs.getString("Lname")+" Email ID= "+rs.getString("Email"));
			 */
			try {
				e.setId(rs.getString("Id"));
				e.setFname(rs.getString("Fname"));
				e.setLname(rs.getString("Lname"));
				e.setEmail(rs.getString("Email"));
				ls.add(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		pstmt.close();
		return ls;
	}

}
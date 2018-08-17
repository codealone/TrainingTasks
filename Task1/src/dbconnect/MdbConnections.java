package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import details.Employee;

public class MdbConnections {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION="jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    private Connection dbConnection = null;
    public Connection getconnection() throws Exception {
          try {
              Class.forName(DB_DRIVER);
          } catch (ClassNotFoundException e) {
              System.out.println(e.getMessage() + "here");
          }
          try {
              dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
              System.out.println("Connection is successfull");
              return dbConnection;
          } catch (SQLException e) {
        	  
              System.out.println(e.getMessage());
          }
          return dbConnection;
      }
    public void closeconnection() {
    	try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public boolean createTable() {
    String query="CREATE TABLE IF NOT EXISTS EMPLOYEE(Id varchar(100) primary key,Fname varchar(100),Lname varchar(100),Email "
			+ "varchar(100)) ";
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = getconnection();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.executeUpdate();
	    System.out.println("Table EMPLOYEE created");
	    pstmt.close();
	    return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		closeconnection();
	}
	return false;
    }
    
    public boolean AddEmployee(Employee e) {
    	String query = "INSERT INTO EMPLOYEE"+"(Id,Fname,Lname,Email)values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
    	if(!search(e.getId())) {
    		try {
    			conn = getconnection();
    		} catch (Exception es) {
    			// TODO Auto-generated catch block
    			es.printStackTrace();
    		}
    		try {
    			pstmt = conn.prepareStatement(query);
    			pstmt.setString(1, e.getId());
    			pstmt.setString(2, e.getFname());
    			pstmt.setString(3, e.getLname());
    			pstmt.setString(4, e.getEmail());
    			pstmt.executeUpdate();
    		    System.out.println("Entry done");
    		    pstmt.close();
    		    return true;
    		} catch (Exception es) {
    			// TODO Auto-generated catch block
    			System.out.println("Catch");
    			es.printStackTrace();
    		}finally {
    			closeconnection();
    		}
    	}else {
    		System.out.println("Id already exists");
    	}
		return false;
    }
    
    public boolean search(String id) {
		String query = "SELECT * FROM EMPLOYEE WHERE Id="+id;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getconnection();
		} catch (Exception es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("Searching");
			if(rs.next()) {
				System.out.println("Id found");
				pstmt.close();
				return true;
			}else {
				pstmt.close();
				return false;
			}
		} catch (Exception es) {
			// TODO Auto-generated catch block
			System.out.println("Catch search");
			es.printStackTrace();
		}finally {
			closeconnection();
		}
		return false;
    }
    
    public List<Employee> ListEmployee() {
    	List<Employee> ls = new ArrayList<Employee>();
		String query = "SELECT * FROM EMPLOYEE";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getconnection();
		} catch (Exception es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("Listing");
			while(rs.next()) {
				Employee e = new Employee();
				/*System.out.println("Id= "+rs.getString("Id")+" First Name= "+rs.getString("Fname")
				+" Last Name= "+rs.getString("Lname")+" Email ID= "+rs.getString("Email"));*/
				e.setId(rs.getString("Id"));
				e.setFname(rs.getString("Fname"));
				e.setLname(rs.getString("Lname"));
				e.setEmail(rs.getString("Email"));
				ls.add(e);
			}
			pstmt.close();
		} catch (Exception es) {
			// TODO Auto-generated catch block
			System.out.println("List Not Available");
			es.printStackTrace();
		}finally {
			closeconnection();
		}
		return ls;
    }
    
    public boolean DeleteEmployee(String id) {
    	String query = "DELETE FROM EMPLOYEE WHERE Id="+id;
		Connection conn = null;
		PreparedStatement pstmt = null;
    	if(search(id)) {
    		try {
    			conn = getconnection();
    		} catch (Exception es) {
    			// TODO Auto-generated catch block
    			es.printStackTrace();
    		}
    		try {
    			pstmt = conn.prepareStatement(query);
    			pstmt.executeUpdate();
    		    System.out.println("Deletion done");
    		    pstmt.close();
    		    return true;
    		} catch (Exception es) {
    			// TODO Auto-generated catch block
    			System.out.println("Deletion Catch");
    			es.printStackTrace();
    		}finally {
    			closeconnection();
    		}
    	}else {
    		System.out.println("Id does not exists");
    	}
		return false;
    }
    
    public boolean EditEmployee(Employee r) {
    	String query = "UPDATE EMPLOYEE SET Fname=?, Lname=?, Email=? "
    			+ "WHERE Id="+r.getId();
		Connection conn = null;
		PreparedStatement pstmt = null;
    	if(search(r.getId())) {
    		try {
    			conn = getconnection();
    		} catch (Exception es) {
    			// TODO Auto-generated catch block
    			es.printStackTrace();
    		}
    		try {
    			pstmt = conn.prepareStatement(query);
    			pstmt.setString(1, r.getFname());
    			pstmt.setString(2, r.getLname());
    			pstmt.setString(3, r.getEmail());
    			pstmt.executeUpdate();
    		    System.out.println("Edition done");
    		    pstmt.close();
    		    return true;
    		} catch (Exception es) {
    			// TODO Auto-generated catch block
    			System.out.println("Edition Catch");
    			es.printStackTrace();
    		}finally {
    			closeconnection();
    		}
    	}else {
    		System.out.println("Id does not exists");
    	}
		return false;
    }
    
    public Employee GetEmployee(String id) {
		String query = "SELECT * FROM EMPLOYEE WHERE Id="+id;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee e = new Employee();
		try {
			conn = getconnection();
		} catch (Exception es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("Searching");
			while(rs.next()) {
				System.out.println("Id found");
				e.setId(id);
				e.setFname(rs.getString("Fname"));
				e.setLname(rs.getString("Lname"));
				e.setEmail(rs.getString("Email"));
				pstmt.close();
				return e;
			}
		} catch (Exception es) {
			// TODO Auto-generated catch block
			System.out.println("Catch search");
			es.printStackTrace();
		}finally {
			closeconnection();
		}
		return e;
    }
}  
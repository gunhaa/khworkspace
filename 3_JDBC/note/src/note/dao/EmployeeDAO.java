package note.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import note.vo.Employee;

public class EmployeeDAO {

	private Connection conn = null;
	
	private Statement stmt = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	
	public List<Employee> selectAll() {
		
		List<Employee> empList = new ArrayList<>();
		

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDrive");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hgh" , "hgh1234");
			
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEE2 ORDER BY EMP_ID");
			
			while(rs.next()) {
				
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return empList;
	}

}

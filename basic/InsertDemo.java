package com.lcpan;

import java.sql.*;

// Insert one employee
public class InsertDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");
			pstmt.setString(3, "2008/10/10");
			pstmt.setDouble(4, 55000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "senior engineer");
			
			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);
			
			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class InsertDemo

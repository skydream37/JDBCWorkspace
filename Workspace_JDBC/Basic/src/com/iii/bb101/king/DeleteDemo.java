package com.iii.bb101.king;

import java.sql.*;

// delete a employee data
public class DeleteDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "ji394su3");
			
			String delStmt = "DELETE FROM employee WHERE empno=?";
			PreparedStatement pstmt = conn.prepareStatement(delStmt);
			pstmt.setInt(1, 1009);
			int num = pstmt.executeUpdate();
			System.out.println("delete count = " + num);
			
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
}// end of class DeleteDemo

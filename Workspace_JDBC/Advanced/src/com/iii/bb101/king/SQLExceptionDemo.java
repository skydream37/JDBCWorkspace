package com.iii.bb101.king;

import java.sql.*;

public class SQLExceptionDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "ji394su3");

			String qryStmt = "SELECT * FROM employe"; // error here
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("name = " + rs.getString("ename"));
				System.out.printf("salary =" + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			System.out.println("Message : " + e.getMessage());
			System.out.println("Vendor code : " + e.getErrorCode());
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class SQLExceptionDemo

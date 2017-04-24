package com.iii.bb101.king;

import java.sql.*;


public class QueryDemo4 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "ji394su3");

			String qryStmt = "SELECT ename, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);//p.27 可產生動態SQL指令
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class QueryDemo4

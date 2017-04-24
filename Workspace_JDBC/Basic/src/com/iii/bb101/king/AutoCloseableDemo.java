package com.iii.bb101.king;

import java.sql.*;

public class AutoCloseableDemo {

	public static void main(String[] args) {

		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";//p.24
		try (Connection conn = DriverManager.getConnection(connUrl, "root", "ji394su3")) {//p.40

			String qryStmt = "SELECT ename, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);//p.27
			ResultSet rs = pstmt.executeQuery();//p.29
			while (rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");//p.30
				System.out.println("salary = " + rs.getDouble("salary"));//p.33
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}// end of main()
}// end of class QueryDemo4

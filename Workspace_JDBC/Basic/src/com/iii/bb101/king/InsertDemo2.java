package com.iii.bb101.king;

import java.sql.*;


// Insert one employee
public class InsertDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "ji394su3");
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			/*
			 * Date date = new Date(); SimpleDateFormat sdf = new
			 * SimpleDateFormat("yyyy/MM/dd hh:mm:ss"); String dateString =
			 * sdf.format(date); System.out.println(dateString);
			 * 
			 * 
			 * pstmt.setInt(1, 1010); pstmt.setString(2, "Jean Tsao");
			 * pstmt.setString(3, dateString); pstmt.setDouble(4, 55000);
			 * pstmt.setInt(5, 100); pstmt.setString(6, "senior engineer");
			 */

			pstmt.setInt(1, 1010);
			pstmt.setString(2, "Jean Tsao");
			pstmt.setString(3, "now()");
			pstmt.setDouble(4, 55000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "senior engineer");

			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);

			pstmt = conn.prepareStatement("SELECT * FROM employee");
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


}// end of class InsertDemo

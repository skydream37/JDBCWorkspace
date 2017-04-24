package com.iii.bb101.king;

import java.sql.*;

// Query all employees using Statement
// ��JDBC4.0�}�l �A�L����ʦa(explictly)�ϥ�Class.forName()�Ӹ��JJDBC Driver
public class QueryDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "ji394su3");
			
			String qryStmt = "SELECT ename, salary FROM employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(qryStmt);

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
}// end of class QueryDemo2

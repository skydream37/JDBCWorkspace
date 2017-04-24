package com.lcpan;

import java.sql.*;

// Query all employees using Statement
// �ĥ�Class Loader�覡����Driver����A�õ��U��Driver Manager���X�ʵ{�����U��椤
public class QueryDemo1 {
	public static void main(String[] args) {
		try {     
			Class.forName("com.mysql.jdbc.Driver");
			String connUrl = "jdbc:mysql://localhost:3306/jdbc";
			Connection conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
		
			String qryStmt = "SELECT ename, salary FROM employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(qryStmt);
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
				
			//	System.out.print("name = " + rs.getString(1) + ", ");
			//	System.out.println("salary = " + rs.getDouble(2));
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of main()
}// end of class QueryDemo1

package com.iii.bb101.king;

import java.sql.*;

// Query all employees using Statement
// 採用Class Loader方式產生Driver實體，並註冊到Driver Manager的驅動程式註冊表單中
public class QueryDemo1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");//p18 載入驅動程式名稱
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";//資料庫串接路徑
			Connection conn = DriverManager.getConnection(connUrl, "root", "ji394su3");//p.26  建立Connection物件

			String qryStmt = "SELECT ename, salary FROM employee";
			Statement stmt = conn.createStatement(); //p.27 用來執行靜態的SQL指令
			ResultSet rs = stmt.executeQuery(qryStmt);//p.30 p.29取得資料庫後所傳回的資料列
			while (rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));

				// System.out.print("name = " + rs.getString(1) + ", ");
				// System.out.println("salary = " + rs.getDouble(2));
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

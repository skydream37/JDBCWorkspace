package com.iii.bb101.king;

import java.sql.*;

// Query all employees using Statement
// �ĥ�Class Loader�覡����Driver����A�õ��U��Driver Manager���X�ʵ{�����U���椤
public class QueryDemo1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");//p18 ���J�X�ʵ{���W��
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";//��Ʈw�걵���|
			Connection conn = DriverManager.getConnection(connUrl, "root", "ji394su3");//p.26  �إ�Connection����

			String qryStmt = "SELECT ename, salary FROM employee";
			Statement stmt = conn.createStatement(); //p.27 �ΨӰ����R�A��SQL���O
			ResultSet rs = stmt.executeQuery(qryStmt);//p.30 p.29���o��Ʈw��ҶǦ^����ƦC
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
package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlTest {
	public static void main(String[] args) {
		// �]�wjdbc�s���r��A�Ш̧A��SQL Server�]�w�ȭק�
		String conUrl = "jdbc:mysql://localhost:3306/jdbc;databaseName=skydream;user=root;password=ji394su3;"; // for
																												// jdbc
																												// 2.0
		Connection con = null;
		try {
			// ���UJODBC��
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(conUrl);
			// SQL�y�y
			String SQL = "SELECT ename,empno from emp";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			// �`���j�M���G�A�Ш̧A����Ʈw�ӧ@����������A�H�N�U�����������M�A��������
			while (rs.next()) {
				System.out.println(rs.getString("ename") + ", " + rs.getString("empno"));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
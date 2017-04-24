package HW;

import java.io.*;
import java.sql.*;

public class First {
	public static void main(String[] args) throws Exception {
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		try {
			Connection conn = DriverManager.getConnection(connUrl, "root", "ji394su3");
			String qryStmt = "SELECT * FROM employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(qryStmt);

			File file = new File("res/tttwww.txt");
			FileWriter fop = new FileWriter(file,true);
			BufferedWriter br = new BufferedWriter(fop);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= count; i++) {
					br.write(rs.getString(i)+",");
					System.out.print(rs.getString(i)+",");
				}
				System.out.println();
				br.write("\r\n");

			}
			br.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

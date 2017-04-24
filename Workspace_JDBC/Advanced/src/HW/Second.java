package HW;

import java.io.*;
import java.sql.*;

public class Second {
	public static void main(String[] args) throws Exception {
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		try {
			Connection conn = DriverManager.getConnection(connUrl, "root", "ji394su3");
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);

			FileReader fr = new FileReader("res/tttwww.txt");
			BufferedReader br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
				String str2[] = str.split(",");

				pstmt.setInt(1, new Integer(str2[0]));
				pstmt.setString(2, str2[1]);
				pstmt.setString(3, str2[2]);
				pstmt.setString(4, str2[3]);
				pstmt.setString(5, str2[4]);
				pstmt.setString(6, str2[5]);
				pstmt.addBatch();
				pstmt.executeBatch();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package HW;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class BatchUpdateDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		String outFile = "res/empGet.txt";
		try {
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "ji394su3");

			String qryStmt = "SELECT * FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);
			
			
			FileOutputStream fos = new FileOutputStream(outFile);
			
		} catch (Exception e) {
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
}// end of class BatchUpdateDemo

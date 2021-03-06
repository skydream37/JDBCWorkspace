package com.iii.bb101.king;

import java.sql.*;
import java.io.*;

public class BLOBDemo {
	public static void main(String[] args) {
		Connection conn = null;
		String inFile = args[0];
		String outFile = args[1];
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "ji394su3");
			
			String qryStmt = "SELECT photo FROM blobtest WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, inFile);
			ResultSet rs = stmt.executeQuery();//拿到資料內容，丟給下面做刪除的動作
			
			
			if (rs.next()) {
				String deleteStmt = "DELETE FROM blobtest WHERE name = ?"; 
				stmt = conn.prepareStatement(deleteStmt);
				stmt.setString(1, inFile);
				stmt.executeUpdate();
				System.out.println("Delete blob is successful!");
			}
			
			
			File f = new File(inFile);
			FileInputStream fis = new FileInputStream(f);
			String insertStmt = "INSERT INTO blobtest VALUES(?,?)";		
			stmt = conn.prepareStatement(insertStmt);
			stmt.setString(1, inFile);//第一個值
			stmt.setBinaryStream(2, fis, f.length());//第二個值
			stmt.executeUpdate();//寫入
			System.out.println("Insert blob is successful!");


			stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, args[0]);
			rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				FileOutputStream fos = new FileOutputStream(outFile);
				Blob b = rs.getBlob("photo");//表格名稱
				byte[] data = b.getBytes(1, (int)b.length());//一次讀取出來
				fos.write(data, 0, (int)b.length());
				fos.close();
				System.out.println("File output is successful!");
			} // end of if (rs.next()) 
		} catch (Exception e) {
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
}// end of class BLOBDemo 

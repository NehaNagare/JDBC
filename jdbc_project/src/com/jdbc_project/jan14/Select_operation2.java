package com.jdbc_project.jan14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_operation2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/myntra_db";
		String username = "root";
		String password = "root";
		String selectQuery = "SELECT * FROM myntra_db.student;";

		Class.forName(driver);
		System.out.println("driver load successfully...");

		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("cpnnection create successfully..");

		// prepare statement is secure so use prepare statement. 
		// statement is not secure.
		PreparedStatement pst =conn.prepareStatement(selectQuery);
		System.out.println("prepare statement object created successfully..");

		ResultSet rs = pst.executeQuery(selectQuery);
		while (rs.next()) {
			int n = rs.getInt(1);
			String m = rs.getString(2);
			int o = rs.getInt(3);

			System.out.println(n + " | " + m + " | " + o);

		}
		pst.close();
		rs.close();
		conn.close();

	}
}

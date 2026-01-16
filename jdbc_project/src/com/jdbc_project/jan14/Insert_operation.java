package com.jdbc_project.jan14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_operation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myntra_db";
		String username="root";
		String password="root";
        String insertQuery="INSERT INTO myntra_db.student VALUES(?,?,?);";
		
		//step 2: load the JDBC 
		Class.forName(driver);
		System.out.println("Driver loaded successfully");
		
		//step 3: establish the connection
		Connection conn=DriverManager.getConnection(url,username,password);
		System.out.println("connection establish successfully");
		
		//step 4: create statement object
		PreparedStatement pst =conn.prepareStatement(insertQuery);
		System.out.println("prepare statement object created successfully..");
		
		pst.setInt(1, 12);
		pst.setString(2, "John");
		pst.setInt(3, 90);
		
		
		// step 5: Execute the query
		int ack=pst.executeUpdate();
		System.out.println("Query executed successfully");
		
		//step 6: process the resultset object
		
		System.out.println("Number of rows inserted:"+ack);
		if(ack>0) {
			System.out.println("insert successfully");
		}
		else {
			System.out.println("insert fail");
		}
		//step 7: close the resources
        pst.close();
		conn.close();
		
	}
}

package com.jdbc_project.jan14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_operation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myntra_db";
		String username="root";
		String password="root";
        String insertQuery="UPDATE  myntra_db.student SET marks=? where roll=?";
		
		//step 2: load the JDBC 
		Class.forName(driver);
		System.out.println("Driver loaded successfully");
		
		//step 3: establish the connection
		Connection conn=DriverManager.getConnection(url,username,password);
		System.out.println("connection establish successfully");
		
		//step 4: create statement object
		PreparedStatement pst =conn.prepareStatement(insertQuery);
		System.out.println("prepare statement object created successfully..");
		
		pst.setInt(1, 66);
		pst.setInt(2, 23);
		
		
		// step 5: Execute the query
		int ack=pst.executeUpdate();
		System.out.println("Query executed successfully");
		
		//step 6: process the resultset object
		
		System.out.println("Number of rows inserted:"+ack);
		if(ack>0) {
			System.out.println("update successfully");
		}
		else {
			System.out.println("update fail");
		}
		//step 7: close the resources
        pst.close();
		conn.close();
		
	}
}

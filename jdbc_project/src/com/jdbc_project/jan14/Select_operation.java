package com.jdbc_project.jan14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_operation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/myntra_db";
		String username="root";
		String password="root";
        String selectQuery="SELECT * FROM myntra_db.student;";
		
		//step 2: load the JDBC 
		Class.forName(driver);
		System.out.println("Driver loaded successfully");
		
		//step 3: establish the connection
		Connection conn=DriverManager.getConnection(url,username,password);
		System.out.println("connection establish successfully");
		
		//step 4: create statement object
		Statement st=conn.createStatement();
		System.out.println("statement object created successfully..");
		
		// step 5: Execute the query
		ResultSet rs=st.executeQuery(selectQuery);
		System.out.println("Query executed successfully");
		
		//step 6: process the resultset object
		
		while(rs.next()) {
			int r=rs.getInt(1);
			String n=rs.getString(2);
			int m=rs.getInt(3);
			System.out.println(r+"|"+n+"|"+m);
			
		}
		//step 7: close the resources
		rs.close();
		st.close();
		conn.close();
		
	}
}

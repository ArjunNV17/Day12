package com.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	 String url="jdbc:mysql://localhost:3306/jdbc";
	 String userName="root";
	 String password="nam1234";
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(url,userName,password);
    
	 Statement st=con.createStatement();
	 
	 String insertQuery1="INSERT INTO students(id,name,email) VALUES(103,'Arju','arju@123gmail.com')";
	 String insertQuery2="INSERT INTO students(id,name,email) VALUES(105,'Asru','orte@123gmail.com')";
	 String insertQuery3="INSERT INTO students(id,name,email) VALUES(104,'beju','sikju@123gmail.com')";
	
	 st.executeUpdate(insertQuery1);
	 st.executeUpdate(insertQuery3);
	 st.executeUpdate(insertQuery2) ;
	 
	 System.out.println("Data Inserted successfully");
	 st.close();
	 con.close();
	}

}

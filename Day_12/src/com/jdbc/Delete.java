package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "nam1234";
		String delete = "delete from studentdata where id=1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(delete);

			int rs = ps.executeUpdate();
			System.out.println(rs);

			con.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
}

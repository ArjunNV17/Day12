package com.jdbc;

import java.sql.Timestamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class InsertdataInBooking {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=nam1234";
		String insert = "insert into ticketbooking(user_id,show_id,booking_datetime,totalcost)values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, 101);
			ps.setInt(2, 1001);
			LocalDateTime now = LocalDateTime.now();
			Timestamp timestamp = Timestamp.valueOf(now);
			ps.setTimestamp(3, timestamp);
			ps.setDouble(4, 250.00);
			int result = ps.executeUpdate();
			System.out.println(result);
			System.out.println("data inserted");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
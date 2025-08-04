package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo3 {
    public static void main(String[] args) {
        // Database URL with credentials
        String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=nam1234";

        // SQL Queries
        String create = "CREATE TABLE IF NOT EXISTS user ("
                      + "userid INT AUTO_INCREMENT PRIMARY KEY, "
                      + "name VARCHAR(100), "
                      + "email VARCHAR(100), "
                      + "mobileno BIGINT(10))";

        String insert = "INSERT INTO user(name, email, mobileno) VALUES (?, ?, ?)";
        String select = "SELECT * FROM user";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 1: Create the table if not exists
            try (Connection con = DriverManager.getConnection(url);
                 PreparedStatement ps = con.prepareStatement(create)) {

                ps.execute();
                System.out.println("✅ Table checked/created.");
            }

            // Step 2: Insert a new record
            try (Connection con = DriverManager.getConnection(url);
                 PreparedStatement ps = con.prepareStatement(insert)) {

                ps.setString(1, "Arju");
                ps.setString(2, "arjun@gmail.com");
                ps.setLong(3, 7356787806L);

                int result = ps.executeUpdate();
                System.out.println("✅ Rows inserted: " + result);
            }

            // Step 3: Retrieve and print all records
            try (Connection con = DriverManager.getConnection(url);
                 PreparedStatement ps = con.prepareStatement(select);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("\n📋 All Users:");
                while (rs.next()) {
                    int id = rs.getInt("userid");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    long mobileno = rs.getLong("mobileno");

                    System.out.println("ID       : " + id);
                    System.out.println("Name     : " + name);
                    System.out.println("Email    : " + email);
                    System.out.println("Mobile # : " + mobileno);
                    System.out.println("----------------------------");
                }
            }

        } catch (SQLException e) {
            System.err.println("⚠️ SQL Exception occurred:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("⚠️ JDBC Driver not found:");
            e.printStackTrace();
        }
    }
}

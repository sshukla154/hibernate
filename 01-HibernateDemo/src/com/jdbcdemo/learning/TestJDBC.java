package com.jdbcdemo.learning;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
			String user= "root";
			String password = "mysql";
			System.out.println("--- Connecting to DB ---");
			
			Connection connection = DriverManager.getConnection(jdbcURL, user, password );
			System.out.println("--- Connection successful to DB ---");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

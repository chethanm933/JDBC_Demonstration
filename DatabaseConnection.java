package com.mavenemployeedb.EmployeeManagment;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DatabaseConnection {

	private static Connection connection;
	
	private DatabaseConnection() {
		
	}
	
	static Connection getConnection() {
		if (connection == null) {
			String jdbcurl = "jdbc:mysql://localhost:3306/employee_db";
			String userName = "root";
			String password = "24681012";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("JDBC Connector is loaded");
			} catch (ClassNotFoundException e) {
				System.out.println("Mysql Connector is  not loaded");
				e.printStackTrace();
			}
			
			listDbDrivers();
			
			try {
				connection = DriverManager.getConnection(jdbcurl, userName, password);
				System.out.println("Connectin Established Successfully");
			} catch (SQLException e) {
				System.out.println("Connectin Establishement failed");
				e.printStackTrace();
			}
		}
			return connection;
	}

	public static void listDbDrivers() {
		Enumeration<Driver> listDrivers = DriverManager.getDrivers();
		
			while(listDrivers.hasMoreElements()) {
				Driver driver = listDrivers.nextElement();
				System.out.println(driver.getClass().getName());
			
		}
	}
	
	
}

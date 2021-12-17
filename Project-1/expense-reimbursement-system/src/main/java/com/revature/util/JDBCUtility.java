package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class JDBCUtility {

	public static Connection getConnection() throws SQLException {

		//We will retrieve our credentials from our environment variables
		String url = System.getenv("db_url");
		String username = System.getenv("db_username");
		String password = System.getenv("db_password");

		Driver postgresDriver = new Driver();		
		DriverManager.registerDriver(postgresDriver);

		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		return con;
	}
	
}
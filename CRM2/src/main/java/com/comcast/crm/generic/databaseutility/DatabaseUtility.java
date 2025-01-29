package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection conn; // Since we will be using the conn into multiple methods, we can't declare it into any local space
	public void getDBConnection(String url, String un, String pw) throws SQLException {

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, un, pw);
		} catch (Exception e) {
			System.out.println("Connection to DB not estabilished, check the credentials");
		}
	}

	// Since we usually have only one DB, we use this method to directly go to that DB without specifying the url, un and pw
	public void getDBConnection() throws SQLException {  // 

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		} catch (Exception e) {
			System.out.println("Connection to DB not estabilished, check the credentials");
		}
	}


	public void closeDBConnection () {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("Unexpected error occured while closing the DB connection");
		}
	}


	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet res= null;
		try {
			Statement stat = conn.createStatement();
			res = stat.executeQuery(query);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int executeNonSelectQuery(String query) throws SQLException {
		int res = 0;
		try {
			Statement stat = conn.createStatement();
			res = stat.executeUpdate(query);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
}

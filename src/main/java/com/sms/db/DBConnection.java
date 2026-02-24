package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
  private static final String URL = "jdbc:postgresql://localhost:5433/sms_db";
  private static final String USER = "postgres";
  private static final String PASSWORD = "123";
  
  public static Connection getConnection() {
	  Connection con = null;
	  
	  try {
		Class.forName("org.postgresql.Driver");
		
		con= DriverManager.getConnection(URL, USER, PASSWORD);
		
		System.out.println("Database Connected");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return con;
  }

  public static Connection getConnection1() {
	
	return null;
  }



}

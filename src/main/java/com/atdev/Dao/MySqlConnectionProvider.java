package com.atdev.Dao;

import static com.atdev.Dao.MySqlProvider.DRIVER;
import static com.atdev.Dao.MySqlProvider.CONNECTION_URL;
import static com.atdev.Dao.MySqlProvider.USERNAME;
import static com.atdev.Dao.MySqlProvider.PASSWORD;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionProvider {
private static Connection con=null;  
	
	static{  
		try{  
			Class.forName(DRIVER);  
			con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
		}catch(Exception e){ System.out.println(e); }  
	}  
	  
	public static Connection getConnection(){  
	    return con;  
	} 
}

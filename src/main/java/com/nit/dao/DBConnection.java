package com.nit.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection connection = null;
	
	private DBConnection() {};

	public static Connection getConnection() 
	{
		if (connection == null) 
		{
			try 
			{
				Class.forName(DBInfo.DRIVER);

				connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USERNAME, DBInfo.PASSWORD);

			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return connection;
	}

}

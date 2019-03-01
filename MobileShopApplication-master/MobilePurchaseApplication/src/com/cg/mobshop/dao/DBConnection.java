package com.cg.mobshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.mobshop.exception.PurchaseException;

public class DBConnection {
	
	public static Connection con;
	
	public static Connection getConnection() throws PurchaseException
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "rishabh";
		String pwd = "rishabh";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("class loaded ... ");
			con = DriverManager.getConnection(url,username,pwd);
			System.out.println("connected to db ... ");
		}
		catch(SQLException e)
		{
			throw new PurchaseException(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new PurchaseException(e.getMessage());
		}
		return con;
	}
}

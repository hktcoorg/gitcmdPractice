package com.holidaygurutravel.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class includes Database connection methods for fetch the data
 * @author THRINESH
 *
 */
public class DatabaseUtility {
	Connection connection;

	/**
	 * This method is used to open the data base and login to database
	 * @param dbUrl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */
	public void openDatabase(String dbUrl, String dbUserName, String dbPassword) throws SQLException
	{
		Driver db=new Driver();
		DriverManager.registerDriver(db);
		connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
	}

	
	/**
	 * This method is used to get data from db by passing query and column Name
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDataFromDatabase(String query, String columnName) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list=new ArrayList<String>();
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}

/**
 * This method is used to verify the data
 * @param query
 * @param columnName
 * @param expectedData
 * @return
 * @throws SQLException
 */
	public boolean verifyDataInDatabase(String query, String columnName, String expectedData) throws SQLException
	{
		List<String> list=getDataFromDatabase(query, columnName);
		boolean flag=false;
		//		for(String actualData:list)
		//		{
		//			if(actualData.equalsIgnoreCase(expectedData))
		//			{
		//			flag=true;
		//			break;
		//			}
		//		}

		if(list.contains(expectedData))
		{
			flag=true;
			return flag;
		}
		return flag;

	}
	/**
	 * This method is used modify the data
	 * @param query
	 * @throws SQLException
	 */
	public void modifyDataInDatabase(String query) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
	}
	

	public void closeDatabase() throws SQLException
	{
		connection.close();
	}






}

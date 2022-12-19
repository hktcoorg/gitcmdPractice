package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class FetchdataSql{
	public static void main(String[] args) throws SQLException {



		String USER_NAME = "thrinesh@gmail.com";
		String PASSWORD = "thrinesh";
		String MODULE_NAME = "user";

		Driver dbdriver=new Driver();  //Create object from CJ 
		DriverManager.registerDriver(dbdriver);     //register driver
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hkt","root", "root"); //Get/ Establish database connection

		try {

			Statement statement = connection.createStatement(); //create statement


			/*	ResultSet result = statement.executeQuery("select* from credentials"); //execute the Query

			while(result.next())  //utilization/fetch particular column data
			{

				System.out.println(result.getString("USER_NAME")+"\t"+result.getString("PASSWORD")+"\t"+result.getString("MODULE_NAME"));	
			}

			//insert data out put is integer(Created 1 row like that)
			int insert = statement.executeUpdate("insert into credentials(USER_NAME,PASSWORD,MODULE_NAME) values('"+USER_NAME+"','"+PASSWORD+"','"+MODULE_NAME+"');"); 

			//delete data
			//int delete = statement.executeUpdate("delete from credentials where PASSWORD='thrinesh'");

			if(insert==1) //if(insert==1 && delete==1)
			{
				System.out.println("Data updated Successfully");
			}


			
			 */
			//how to validate duplicate data
			ResultSet result1 = statement.executeQuery("select* from credentials");
			List<String> list=new ArrayList<String>();
			while(result1.next())
			{
				list.add(result1.getString("USER_NAME")+" || "+result1.getString("PASSWORD")+" || "+result1.getString("MODULE_NAME"));
			}
			if(list.contains(USER_NAME+" || "+PASSWORD+" || "+MODULE_NAME))
			{
				System.out.println("Data already exist");
			}
			else
			{
				statement.executeUpdate("insert into credentials(USER_NAME,PASSWORD,MODULE_NAME) values('"+USER_NAME+"','"+PASSWORD+"','"+MODULE_NAME+"');");
				System.out.println("Next data updated successfully");
			}
			
			
			//			int delete = statement.executeUpdate("delete from credentials");
			//			System.out.println("DELETED");
			
			ResultSet result2 = statement.executeQuery("select* from credentials");
			while(result2.next())
			{
			System.out.println(result2.getString("USER_NAME")+"\t"+result2.getString("PASSWORD")+"\t"+result2.getString("MODULE_NAME"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();						
		}
		finally
		{
			//close connection //is mandatory

			connection.close();
		}
	}
}
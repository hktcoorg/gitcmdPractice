package com.testNGpractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgPractice1 {
	
	/**
	 * This annotation used to initialize the data from excel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@DataProvider
	public String[][] getDataGenricDaPro() throws EncryptedDocumentException, IOException
	{
		DataProviderPractice dp=new DataProviderPractice();
		String[][] arr=dp.getDataFromExcel("dataprovider");
		return arr;
	}
	
	/**
	 * This annotation used to utilization of data from dataProvider
	 * @param username
	 * @param password
	 */
	@Test(dataProvider="getDataGenricDaPro", priority = 6, dependsOnGroups = "sanity", enabled = true )
	public void dataProGeneric(String username, String password) 
	{
		System.out.println("username->"+username+"--password-->"+password);
	}
	
	@Parameters("browser")
	@Test(groups="Regresion", priority =1)
	public void T1(String browser) 
	{
		System.out.println(browser+" with regresion");
	}

	@Parameters(value={"browser", "username"})
	@Test(groups="sanity", priority = 2)
	public void T2(String browser, String username) 
	{
		System.out.println("sanity---"+"browserName->"+browser+"--username-->"+username);
		
	}
	
	@Test(groups={"sanity", "firefox"}, priority = 3)
	public void T3() 
	{
		System.out.println("sanity");
		//Assert.fail();
		
	}
	
	@Test(groups="Regresion", priority = 4)
	public void T4() 
	{
		System.out.println("regresion");
		
	}
}

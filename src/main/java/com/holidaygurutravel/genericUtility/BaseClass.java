package com.holidaygurutravel.genericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass extends BaseClassVeriables
{
	
	//git for cmd

	/**
	 * Browser launch and setter of thread safe of webdriverUtility take Sshot
	 * EventfireWebdriver listenerDriver
	 * @param browser
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeTest(@Optional ("chrome") String browser) throws NumberFormatException, IOException
	{
		excelUtility=new ExcelUtility();
		fileUtility=new FileUtility();

		System.out.println("Thread ID is"+Thread.currentThread().getId());

		webDriverUtility=new WebDriverUtility();

		ThreadSafe.setWebDriverUtility(webDriverUtility); //this used in xml file call listeners and take screenshot used for TC1 and failure
		
		driver = webDriverUtility.lunchAppication(browser);

		//lisetenerDriver=driver;  //for listeners only eventFiringWebDriver Screenshot in skip and call it above of @Test
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws EncryptedDocumentException, IOException
	{
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		//Write login action
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws IOException
	{
		//Write logOut statement.
	}

	@AfterClass(alwaysRun = true)
	public void  afterClass() throws IOException
	{	
		webDriverUtility.quit();
		fileUtility.closePropertyFile();
		excelUtility.closeExcel();
	}

}

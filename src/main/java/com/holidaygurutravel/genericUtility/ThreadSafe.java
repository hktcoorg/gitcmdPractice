package com.holidaygurutravel.genericUtility;

import com.aventstack.extentreports.ExtentTest;

/**
 * To create multiple copies of Thread this method will help 
 * Make non static as a static 
 * @author THRINESH
 *
 */

public class ThreadSafe {
	
	private static ThreadLocal<WebDriverUtility> webDriverUtility=new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	
	
	//to Take scrrenshot for initialize driver 
	public static WebDriverUtility getWebDriverUtilityDriver()
	{
		return webDriverUtility.get();
	}
	public static void setWebDriverUtility(WebDriverUtility swebdriverUtility)
	{
		webDriverUtility.set(swebdriverUtility);
	}
	
	
//for Extent report. instead of reporter.log we use this and call report.info for print statement
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	public static void setExtentTest(ExtentTest setExtentTest)
	{
		extentTest.set(setExtentTest);
	}
	


}

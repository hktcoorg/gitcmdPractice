package com.testNGpractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNgclass {
	
	@BeforeSuite(groups="abc")
	public void bs()
	{
		System.out.println("Before Suite");
	}

	@BeforeTest(groups="abc")
	public void bt()
	{
		System.out.println("Before Test");
	}
	
	@BeforeClass(groups="baseclass")
	public void bc()
	{
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void bm()
	{
		System.out.println("Before method");
	}
	@AfterMethod
	public void am()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("After class");
	}
	
	@AfterTest(alwaysRun = true)
	public void at()
	{
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void as()
	{
		System.out.println("After Siute");
	}

}

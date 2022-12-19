package com.testNGpractice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPractice {
	
	@Test
	public void ExtentReport()
	{
		//wrap inside onStart ItestContext of listener @Before test because one time only require
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/practiceReport.html"); //store in Iconstant
		spark.config().setDocumentTitle("Doc title: Test case Report");
		spark.config().setReportName("ReportName: Demo report");      
		spark.config().setTheme(Theme.DARK);			//Theame
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10"); //Additional info to report
		report.setSystemInfo("Brow Name", "chrome");
		report.setSystemInfo("Brow version", "107");
		report.setSystemInfo("Reprter Name", "Thrinesh");
		
		//wrap to onTestResult onStartTest 
		ExtentTest test1 = report.createTest("Test 1 concanate with test case name .Is  passed");      //add test to report
		
		//wrapwith respect listener Pass fail skip
		test1.info("This is information comming from script");  //information level
		test1.pass("Test case passs");
		test1.warning("Test case warning");
		test1.fail("Test case Fail");
		
		ExtentTest test2 = report.createTest("Test 2");      //add test to report
		test2.info("This is information comming from script");  //information level
		test2.pass("Test case passs");
		test2.warning("Test case warning");
		test2.fail("Test case Fail");
		
		ExtentTest test3 = report.createTest("Test 3");      //add test to report
		test3.info("This is information comming from script");  //information level
		test3.pass("Test case passs");
		test3.warning("Test case warning");
		test3.fail("Test case Fail");
		
		
		//add screenshot
		
		
		report.flush(); //mandatory	
	}

}

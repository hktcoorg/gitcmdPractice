package com.holidaygurutravel.genericUtility;
import java.io.IOException;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * 
 *
 * @author THRINESH
 *
 */
public class ListenerImplimentation implements ITestListener { //IClassListener, ISuiteListener

	private ExtentReports report;
	private ExtentTest testscript;


	@Override
	public void onFinish(ITestContext context)
	{
		report.flush();
	}


	@Override
	public void onStart(ITestContext context)          //parallel with test
	{
		ExtentSparkReporter spark=new ExtentSparkReporter(IConstantPath.EXTENTREPORTPATH); //store in Iconstant
		spark.config().setDocumentTitle("Doc Title: Thrinesh Report");
		spark.config().setReportName("ReportName: holidaygurutravel report");      
		spark.config().setTheme(Theme.DARK);			//Theame
		report=new ExtentReports();

		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10"); //Additional info to report
		report.setSystemInfo("Brow Name", "chrome");
		report.setSystemInfo("Brow version", "107");
		report.setSystemInfo("Reprter Name", "Thrinesh");	
	}


	@Override
	public void onTestStart(ITestResult result) 
	{
		
		testscript = report.createTest(result.getMethod().getMethodName());

		ThreadSafe.setExtentTest(testscript); //set the Ref variable and make it static
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{

		ThreadSafe.getExtentTest().pass(result.getMethod().getMethodName()+" Is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{

		try {
			String screenshot = ThreadSafe.getWebDriverUtilityDriver().takeSShotExtentReport();
			ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());

		} catch (IOException e) {

			e.printStackTrace();
		}

		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName()+" Is Failed");
		ThreadSafe.getExtentTest().fail(result.getThrowable());  //to get Exception information
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		ThreadSafe.getExtentTest().skip(result.getMethod().getMethodName()+" Is Skipped");
		ThreadSafe.getExtentTest().skip(result.getThrowable());


		/*		//This is used before
		 * 		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.lisetenerDriver);
		String testCasename_Skip=result.getMethod().getMethodName();
		String store=IConstantPath.SCREENSHOT_PATH;
		Date d=new Date();
		String d1=d.toString();
		String d2=d1.replaceAll(":","-");
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File(store+testCasename_Skip+d2+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {

			e.printStackTrace();
		}
		 */
		/*
		 * //if we need in local file use this
		String screenshot = ThreadSafe.getWebDriverUtilityDriver().takeScreenShot(result.getMethod().getMethodName());
		ThreadSafe.getExtentTest().addScreenCaptureFromPath(screenshot);
		 */

		try {
			String screenshot = ThreadSafe.getWebDriverUtilityDriver().takeSShotExtentReport();
			ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}

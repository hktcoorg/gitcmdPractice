package com.holidaygurutravel.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class used to call WebDriver utilize methods
 * @author THRINESH
 *
 */
public class WebDriverUtility {
	private WebDriver driver;
	FileUtility fileUtility;
	WebDriverWait wait;


	/**
	 * This method is used below actions Store in driver Ref variable Return Type is WebDriver(to avoid nullpointerException
	 * Lunch the browser 
	 * get the url
	 * maximize
	 * ImplictlyWait
	 * @param browser
	 * @param driver
	 * @param timeout
	 * @return
	 */
	public WebDriver lunchAppication() throws NumberFormatException, IOException
	{
		fileUtility=new FileUtility();
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		String browser =fileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.converttoString());
		String url = fileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.converttoString());
		long timeout =Long.parseLong(fileUtility.getDataFromPropertyFile("timeout"));
		//	 Long time = (Long) javaUtility.stringToAnyDataType(PropertyFileKeys.TIMEOUT.converttoString(), "int");


		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;	
	}
	
	public WebDriver lunchAppication(String browser) throws NumberFormatException, IOException
	{
		fileUtility=new FileUtility();
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
//		String browser =fileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.converttoString());
		String url = fileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.converttoString());
		long timeout =Long.parseLong(fileUtility.getDataFromPropertyFile("timeout"));
		//	 Long time = (Long) javaUtility.stringToAnyDataType(PropertyFileKeys.TIMEOUT.converttoString(), "int");

		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;	
	}
	
	public WebDriver lunchAppication(String browser, String url) throws NumberFormatException, IOException
	{
		long timeout =Long.parseLong(fileUtility.getDataFromPropertyFile("timeout"));
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;	
	}

	/**
	 * This method is used to Scroll bar operation
	 * @param element
	 */
	public void windowScrollBy(WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
/**
 * This method is used to wait in seconds
 * @param timeout
 * @param element
 */
	public void waitVesibilityOfElemement(long timeout, WebElement element)
	{

		/**
		 * webdriverWait is sub class of FluentWait
		 */
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	/**
	 * if both wait is not able to perform then use this method
	 * @param duration
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException 
	 */
	public void customWait(int duration, WebElement element, long pollingTime) throws InterruptedException
	{
		int count=0;
		while(count<duration)   //10sec
		{					
			try
			{
				element.click();   
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(pollingTime);   //500ms
				count++;
			}
		}
	}
	
	/**
	 * This method is used to get Screenshot with extent report local folder
	 * @return
	 * @throws IOException
	 */

	public String takeScreenShot(String testCaseName) throws IOException
	{
		String store=IConstantPath.SCREENSHOT_PATH;
		String fileName=testCaseName+"_"+new JavaUtility().getDateTime();
		
//		String d1=d.toString();
//		String d2=d1.replaceAll(":","-");
		
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File(store+fileName+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();

	}
/**
 * This method is used to get current date with time
 * @return
 */
	public String getDate()
	{
		Date d=new Date();
		String d1 = d.toString();
		return d1;
	}
	
	/**
	 * This method will return the temprovery Sshot path and it will not store in local system and pass to direct Extent report
	 * By using threadSafe.addSshotBASE64 method 
	 * @return
	 * @throws IOException
	 */
	public String takeSShotExtentReport() throws IOException
	{
		TakesScreenshot tss=(TakesScreenshot)driver;
		 String src = tss.getScreenshotAs(OutputType.BASE64);
		 return src;
	}
	
	public void waittoallElements(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	/**
	 * This method is used to quit from browser 
	 */

	public void quit()
	{
		driver.quit();
	}


}

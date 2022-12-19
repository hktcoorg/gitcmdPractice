package com.testNGpractice;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgPractice2
{

	@Test(groups="sanity", priority = 5)
	public void p2T2()
	{
		System.out.println("sanity");
	}

	@Test
	public void lunchBrowser() throws InterruptedException
	{
		WebDriver driver = null;

//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enterbrowser");
//		String browser = sc.next();
		String browser="chrome";

		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://www.youtube.com");
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.get("https://www.youtube.com");
		}
		else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.youtube.com");
		}
		else
		{
			
			{
				System.out.println("Please enter Proper browser name");
				lunchBrowser();
				System.out.println("You have exieded the limit");
			}
		}
		Thread.sleep(2000);
		driver.close();
	}
}

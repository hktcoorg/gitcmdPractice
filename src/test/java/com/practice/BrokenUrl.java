package com.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenUrl {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {


		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		String url="https://www.facebook.com";
		driver.get(url);

		List<WebElement> listoflink = driver.findElements(By.xpath("//a"));
		for(int i=0; i<listoflink.size(); i++)
		{
			String links =listoflink.get(i).getAttribute("href");
			
			try
			{
				URL u=new URL(url);  //malfoundException if wrong
				URLConnection urlConnection=u.openConnection();
				HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;
				int stausCode = httpConnection.getResponseCode();

				System.out.println("BrokenLinks----->"+links+"------>"+stausCode);
			}
			catch (Exception e) {
				
				System.out.println("Something wrong in this URL---------->"+url);
			}
		}
	}
}


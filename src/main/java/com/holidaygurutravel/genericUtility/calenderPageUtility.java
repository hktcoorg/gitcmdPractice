package com.holidaygurutravel.genericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class calenderPageUtility {
	static WebDriver driver;
	
	String reqMonth;
	String reqYear;
	public void calenderHandle(String reqMon, String reqYer, String reqDay)
	{
		
		
		 reqMonth=reqMonth.toUpperCase();
//		 reqYear = reqYear;
//		 reqDay = reqDay;

		//		String currentMonthYear=xpath if both are singleElement
		//		String currentMonth = currentMonthYear.split(" ")[1];
		//		String currentYear = currentMonthYear.split(" ")[1];


		String currentMonth=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']")).getText();
		String currentYear=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']")).getText();
		
		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)))
		{
			driver.findElement(By.xpath("//div/a[@title='Next']")).click();
			currentMonth=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']")).getText();
			currentYear=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']")).getText();
		}
		
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[.='"+reqDay+"']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	
		String reqMonth="March".toUpperCase();
		String reqYear = "2023";
		String reqDay = "24";

		//		String currentMonthYear=xpath if both are singleElement
		//		String currentMonth = currentMonthYear.split(" ")[1];
		//		String currentYear = currentMonthYear.split(" ")[1];


		String currentMonth=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']")).getText();
		String currentYear=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']")).getText();
		
		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)))
		{
			driver.findElement(By.xpath("//div/a[@title='Next']")).click();
			currentMonth=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']")).getText();
			currentYear=driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']")).getText();
		}
		
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[.='"+reqDay+"']")).click();
	*/	
	}

}

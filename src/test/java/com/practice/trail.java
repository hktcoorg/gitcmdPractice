package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class trail {

/*	@Test
	public void openUrl()
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[.='Organizations']")).click();

		String page = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();
		System.out.println(page);
		int pageNo = Integer.parseInt(page.split(" ")[1]);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		int count=0;
		String expecOrgName = "tcs40";
		for (int i = 0; i < pageNo; i++)
		{
			//	driver.findElement(By.xpath("//a[text()='"+orgName+"']/parent::td/preceding::td/input")).click();
			List<WebElement> orgNames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
			for (int j = 0; j<orgNames.size() ; j++)
			{
				String actualorgName=orgNames.get(i).getText();
				System.out.println(actualorgName);
				if(actualorgName.equals(expecOrgName))
				{
					driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(j + 1)+"]td/input")).click();
					count++;
					break;

				}
			}
			if(count!=0) break;
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			WebElement statusbar = driver.findElement(By.xpath("//div[@id='status']"));
			wait.until(ExpectedConditions.invisibilityOf(statusbar));
		}
		driver.close();
	}


*/
	@Test()
	public void flipkartTip() throws InterruptedException
	{

		String Mobilename = "Realme 4gb and 64 gb";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Mobilename);
		driver.findElement(By.xpath("//button[@type='submit' or @class='L0Z3Pu']")).click();

		List<WebElement> iphones = driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../../div/following-sibling::div/div/div/div/a/div[2]/div[1]/div[1]"));
		List<WebElement> cost = driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../../div/following-sibling::div/div/div/div/a/div[2]/div[2]/div[1]/div[1]/div[1]"));

		for(int i=0; i<iphones.size(); i++)
		{
			String Phonename = iphones.get(i).getText();
			String Cost = cost.get(i).getText();
			System.out.println(Phonename+"==>"+Cost);
		}
		driver.close();
	}
}
	







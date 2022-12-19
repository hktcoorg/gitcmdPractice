package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.holidaygurutravel.genericUtility.FileUtility;
import com.holidaygurutravel.genericUtility.IConstantPath;
import com.holidaygurutravel.genericUtility.PropertyFileKeys;
import com.holidaygurutravel.genericUtility.WebDriverUtility;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.UserTMSPage;

public class AdmincreatedpackageverifyTest
{
	static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{

		FileUtility fileUtility=new FileUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();

		driver = webDriverUtility.lunchAppication();
		
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		UserTMSPage userTMSpage=new UserTMSPage(driver);
		CommonPage common=new CommonPage(driver);
		
		
		businessLibrary.userSignIn(driver);
	
		WebElement welcome=userTMSpage.getuserWelcomeText();
		
		webDriverUtility.windowScrollBy(welcome);
		if(welcome.isDisplayed())
		{
			System.out.println("User is Successfully logged in");
		}
		String packageName = fileUtility.getDataFromPropertyFile(PropertyFileKeys.PACKAGENAME.converttoString());
		WebElement pname=userTMSpage.getActualPackageName(packageName);
		
		webDriverUtility.windowScrollBy(pname);
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), pname);
		
		if(pname.isDisplayed())
		{
			System.out.println("Admin created Package is Displayed in user module");
			System.out.println("Test case2 is Pass");
			common.getUserLogoutLink();
			fileUtility.closePropertyFile();
			webDriverUtility.quit();
		}
		else
		{
			webDriverUtility.takeScreenShot("imgFromMainTestclass");
		}
	}

}

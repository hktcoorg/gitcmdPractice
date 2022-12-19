package com.newTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.holidaygurutravel.genericUtility.BaseClass;
import com.holidaygurutravel.genericUtility.PropertyFileKeys;
import com.holidaygurutravel.genericUtility.ThreadSafe;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.UserTMSPage;


@Listeners(com.holidaygurutravel.genericUtility.ListenerImplimentation.class)

public class UserChangemobileNumTest extends BaseClass{
	
	
	@Test
	public void testcase5() throws IOException
	
	{
		
		CommonPage common=new CommonPage(driver);
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		
		businessLibrary.userSignIn(driver);
		UserTMSPage userTMSpage=new UserTMSPage(driver);
		WebElement welcome=userTMSpage.getuserWelcomeText();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.converttoString())), welcome);
		webDriverUtility.windowScrollBy(welcome);
		Assert.assertTrue(welcome.isDisplayed());

		ThreadSafe.getExtentTest().info("User is Successfully logged in");
		//ThreadSafe.getExtentTest().log(, null) ("User is Successfully logged in"); //For extent report
		Reporter.log("User is Successfully logged in");
		
	}

}

package com.TestNgTestScript;
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



public class AdmincreatedpackageverifyTest extends BaseClass{

	@Test(groups="integration")
	public void testCase2() throws NumberFormatException, IOException
	{	
		CommonPage common=new CommonPage(driver);
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		businessLibrary.userSignIn(driver);

		UserTMSPage userTMSpage=new UserTMSPage(driver);
		WebElement welcome=userTMSpage.getuserWelcomeText();

		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.converttoString())), welcome);
		webDriverUtility.windowScrollBy(welcome);
		Assert.assertTrue(welcome.isDisplayed());

		ThreadSafe.getExtentTest().info("User is Successfully logged in"); //For extent report
		Reporter.log("User is Successfully logged in");

		String packageName = fileUtility.getDataFromPropertyFile(PropertyFileKeys.PACKAGENAME.converttoString());
		WebElement pname=userTMSpage.getActualPackageName(packageName);

		webDriverUtility.windowScrollBy(pname);
		webDriverUtility.waittoallElements(pname);
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), pname);
		Assert.assertTrue(pname.isDisplayed());
		
		ThreadSafe.getExtentTest().info("Admin created Package is Displayed in user module");
		ThreadSafe.getExtentTest().info("integration Test case2 is Pass");

		Reporter.log("Admin created Package is Displayed in user module");
		Reporter.log("integration Test case2 is Pass", true);
		common.getUserLogoutLink();

	}

}

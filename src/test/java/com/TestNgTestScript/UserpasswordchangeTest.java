package com.TestNgTestScript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.holidaygurutravel.genericUtility.BaseClass;
import com.holidaygurutravel.genericUtility.PropertyFileKeys;
import com.holidaygurutravel.genericUtility.SheetName;
import com.holidaygurutravel.genericUtility.ThreadSafe;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.HomePage;
import com.objectRepository.UserChangePasswordPage;
import com.objectRepository.UserSignInPage;
import com.objectRepository.UserTMSPage;


@Listeners(com.holidaygurutravel.genericUtility.ListenerImplimentation.class)
public class UserpasswordchangeTest extends BaseClass{
	@Test(groups="integration")
	public void testCase4() throws NumberFormatException, IOException
	{
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		UserChangePasswordPage userChangePassword=new UserChangePasswordPage(driver);
		CommonPage common=new CommonPage(driver);
		UserTMSPage userTMSpage=new UserTMSPage(driver);
		UserSignInPage userSignIn=new UserSignInPage(driver);
		HomePage homePage=new HomePage(driver);

		businessLibrary.userSignIn(driver);


		WebElement welcome = userTMSpage.getuserWelcomeText();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), welcome);
		if(welcome.isDisplayed())
		{
			ThreadSafe.getExtentTest().info("User is Successfully logged in");
			Reporter.log("User is Successfully logged in");
		}

		userTMSpage.getchangeaPasswordLink();

		String currentPassword =excelUtility.ifCurrentPassword(excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 25, 0));
		String newPassword = excelUtility.ifNewPassword(excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 26, 0));
		String confirmPassword =excelUtility.ifConfirmPassword(excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 27, 0));	

		userChangePassword.getCuurertPasswordTF(currentPassword);
		userChangePassword.getNewPasswordTF(newPassword);
		userChangePassword.getConfirmPasswordTF(confirmPassword);
		userChangePassword.getchangeBtn();


		WebElement success =userChangePassword.getSuccessStatus();
		Assert.assertTrue(success.isDisplayed());
		try
		{
			ThreadSafe.getExtentTest().info("Password is changed successfully");
			Reporter.log("Password is changed successfully");
		}
		catch(Exception e)
		{
			ThreadSafe.getExtentTest().info("Password is not updated");
			Reporter.log("Password is not updated", true);
		}

		WebElement logout=userChangePassword.getUserLogoutElement();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), logout);
		logout.click();


		homePage.getUserSignInLink().click();
		userSignIn.enterYourEmail(fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.converttoString()));
		userSignIn.enterUserPassword(newPassword);
		userSignIn.getSignInButton();

		WebElement welcome1=userTMSpage.getuserWelcomeText();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), welcome1);
		Assert.assertTrue(welcome1.isDisplayed());

		ThreadSafe.getExtentTest().info("Logged in With NewPasword is Succes");
		ThreadSafe.getExtentTest().info("integration Test case4 is Passed");

		Reporter.log("Logged in With NewPasword is Succes");
		Reporter.log("integration Test case4 is Passed", true);

		userTMSpage.getHomeBtn();
		common.getUserLogoutLink();
	}
}

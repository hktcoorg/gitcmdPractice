package com.TestNgTestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import com.objectRepository.UserTMSDetailsPage;
import com.objectRepository.UserTMSPage;



public class UserbookpackageTest extends BaseClass{

	@Test(groups = "regression")
	public void testCase3() throws IOException, NumberFormatException, EncryptedDocumentException
	{
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		UserTMSPage userTMSpage=new UserTMSPage(driver);
		UserTMSDetailsPage userTMSdetails=new UserTMSDetailsPage(driver);
		CommonPage common=new CommonPage(driver);

		businessLibrary.userSignIn(driver);

		WebElement welcome = userTMSpage.getuserWelcomeText();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), welcome);
		Assert.assertTrue(welcome.isDisplayed());
		
ThreadSafe.getExtentTest().info("User is Successfully logged in");
		Reporter.log("User is Successfully logged in");


		String packageName =fileUtility.getDataFromPropertyFile(PropertyFileKeys.PACKAGENAME.converttoString());
		String fromDate =excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 18, 2);
		String toDate = excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 19, 2);

		WebElement pname=userTMSpage.getActualPackageName(packageName);


		webDriverUtility.windowScrollBy(pname);
		userTMSpage.getActualDetailsButton(packageName).click();

		userTMSdetails.getfromDateInput();
		userTMSdetails.getActualFromDate(fromDate).click();

		userTMSdetails.getToDateInput();

		userTMSdetails.getActualToDate(toDate).click();

		WebElement book = userTMSdetails.getBookBtn();
		webDriverUtility.windowScrollBy(book);

		String comment = excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 20, 2);;

		userTMSdetails.getCommentTF(comment);
		book.click();
		WebElement success=userTMSdetails.getSuccessStatus();
		Assert.assertTrue(success.isDisplayed());
		
		ThreadSafe.getExtentTest().info("regrasion Test case3 is pass");
		Reporter.log("regrasion Test case3 is pass", true);
		userTMSpage.getHomeBtn();
		common.getUserLogoutLink();
	}
}

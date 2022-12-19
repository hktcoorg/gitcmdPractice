package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.holidaygurutravel.genericUtility.ExcelUtility;
import com.holidaygurutravel.genericUtility.FileUtility;
import com.holidaygurutravel.genericUtility.IConstantPath;
import com.holidaygurutravel.genericUtility.PropertyFileKeys;
import com.holidaygurutravel.genericUtility.SheetName;
import com.holidaygurutravel.genericUtility.WebDriverUtility;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.UserTMSDetailsPage;
import com.objectRepository.UserTMSPage;

public class UserbookpackageTest
{
	static WebDriver driver;
	public static void main(String[] args) throws IOException {

		ExcelUtility excelUtility=new ExcelUtility();
		FileUtility fileUtility=new FileUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
	

		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		
		driver = webDriverUtility.lunchAppication();
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		UserTMSPage userTMSpage=new UserTMSPage(driver);
		UserTMSDetailsPage userTMSdetails=new UserTMSDetailsPage(driver);
		CommonPage common=new CommonPage(driver);

	
		businessLibrary.userSignIn(driver);
		
		WebElement welcome = userTMSpage.getuserWelcomeText();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), welcome);
		if(welcome.isDisplayed())
		{
			System.out.println("User is Successfully logged in");
		}

		
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
		if(success.isDisplayed())
		{
			System.out.println("Test case3 is pass");
			userTMSpage.getHomeBtn();
			common.getUserLogoutLink();
			excelUtility.closeExcel();
			fileUtility.closePropertyFile();
			webDriverUtility.quit();
		}
		
	}


}

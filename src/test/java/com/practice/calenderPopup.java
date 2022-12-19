package com.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.holidaygurutravel.genericUtility.ExcelUtility;
import com.holidaygurutravel.genericUtility.FileUtility;
import com.holidaygurutravel.genericUtility.IConstantPath;
import com.holidaygurutravel.genericUtility.WebDriverUtility;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.UserTMSPage;

public class calenderPopup {

	static WebDriver driver;
	public static void main(String[] args) throws NumberFormatException, IOException {


		ExcelUtility excelUtility=new ExcelUtility();
		FileUtility fileUtility=new FileUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		


		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);


		driver = webDriverUtility.lunchAppication();

		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		UserTMSPage userTMSpage=new UserTMSPage(driver);
//		UserTMSDetailsPage userTMSdetails=new UserTMSDetailsPage(driver);


		businessLibrary.userSignIn(driver);

		WebElement welcome = userTMSpage.getuserWelcomeText();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), welcome);
		if(welcome.isDisplayed())
		{
			System.out.println("User is Successfully logged in");
		}

		/*	
		String packageName =fileUtility.getDataFromPropertyFile(PropertyFileKeys.PACKAGENAME.converttoString());
		String fromDate =excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 18, 2);
		String toDate = excelUtility.getDataFromExcel(SheetName.USER_TESTDATA.convertToString(), 19, 2);


		WebElement pname=userTMSpage.getActualPackageName(packageName);


		webDriverUtility.windowScrollBy(pname);
		userTMSpage.getActualDetailsButton(packageName).click();




		userTMSdetails.getfromDateInput();
		//from date selection for future dates

		String reqMonth="March".toUpperCase();	//		String currentMonthYear=xpath if both are singleElement
		String reqYear = "2023";        	 	//		String currentMonth = currentMonthYear.split(" ")[1];
		String reqDay = "24";					//		String currentYear  = currentMonthYear.split(" ")[1];

		
	
		String[] AllMonths= {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY","AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		
		String currentMonth=userTMSdetails.getCalcurrentMonth().getText();
		String currentYear=userTMSdetails.getCalcurrentYear().getText();
		
		
		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)))
		{
			
				userTMSdetails.getCalnextButton().click();
				//if required webDriverUtility.wait(timeout)
				currentMonth=userTMSdetails.getCalcurrentMonth().getText();
				currentYear=userTMSdetails.getCalcurrentYear().getText();
			}
			
		}
		userTMSdetails.getCalDate(reqDay).click();
		driver.quit();
*/
		
/*
		 //from date selection for before and future dates	

				int reqMonth = ju.getMonthInMMFormat("January");  //1->MM  jan-> MMM      January->MMM        
				int reqYear = (Integer) ju.stringToAnyDataType("2023", "int");  		//Conversion if(Integer.parseInt(reqYear)<Integer.parseInt(currentYear))
				int reqDay = (Integer) ju.stringToAnyDataType("24", "int");;

		//Conversion of formatter Sting to integer- month
					String cM = userTMSdetails.getCalcurrentMonth().getText();
					String cY = userTMSdetails.getCalcurrentYear().getText(); //getting all caps so this method will not work
				int currentMonth = ju.getMonthInMMFormat(cM);
				int currentYear = (Integer) ju.stringToAnyDataType(cY,"int");

				while(reqMonth>currentMonth || reqYear>currentYear)
				{
					userTMSdetails.getCalnextButton().click();
					currentMonth = ju.getMonthInMMFormat(userTMSdetails.getCalcurrentMonth().getText());
					currentYear = (Integer) ju.stringToAnyDataType(userTMSdetails.getCalcurrentYear().getText(),"int");
				}
				while(reqMonth<currentMonth || reqYear<currentYear)
				{
					userTMSdetails.getcalPreviousButton().click();
					currentMonth = ju.getMonthInMMFormat(userTMSdetails.getCalcurrentMonth().getText());
					currentYear = (Integer) ju.stringToAnyDataType(userTMSdetails.getCalcurrentYear().getText(),"int");
				}
				userTMSdetails.getCalDateIntForm(reqDay);
		*/ 
	}
}

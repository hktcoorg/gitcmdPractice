package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.holidaygurutravel.genericUtility.ExcelUtility;
import com.holidaygurutravel.genericUtility.FileUtility;
import com.holidaygurutravel.genericUtility.IConstantPath;
import com.holidaygurutravel.genericUtility.SheetName;
import com.holidaygurutravel.genericUtility.WebDriverUtility;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.CreatePackagePage;

public class AdmincreatepackageTest

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
		CommonPage common=new CommonPage(driver);
		CreatePackagePage createPackage=new CreatePackagePage(driver);
			
		businessLibrary.adminSignIn(driver);
		
		common.getTourPackagesLHN();
		common.getTourPackagesCreateLHN();

		String createPackageName = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 28, 2);
		String packageType = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 29, 2);
		String packageLocation = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 30, 2);
		String packagePrice = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 31, 2);
		String packageFeatures = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 32, 2);
		String packageDetails = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 33, 2);
		String packageImage = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 34, 2);

		String resetPackageDetails = excelUtility.getDataFromExcel(SheetName.ADMIN_TESTDATA.convertToString(), 37, 2);

		String date = webDriverUtility.getDate();

		createPackage.createPackageTF(""+createPackageName+""+date+"");
		createPackage.packagetypeTF(packageType);
		createPackage.packagelocationTF(packageLocation);
		createPackage.packagepriceTF(packagePrice);
		createPackage.packagefeaturesTF(packageFeatures);
		createPackage.packagedetailsTAreaF(packageDetails);
		createPackage.packageimageUpload(packageImage);

		WebElement rstBtn = createPackage.getResetButton();
		webDriverUtility.windowScrollBy(rstBtn);
		rstBtn.click();	
		
		createPackage.createPackageTF(""+createPackageName+""+date+"");
		createPackage.packagetypeTF(packageType);
		createPackage.packagelocationTF(packageLocation);
		createPackage.packagepriceTF(packagePrice);
		createPackage.packagefeaturesTF(packageFeatures);
		createPackage.packagedetailsTAreaF(resetPackageDetails);
		createPackage.packageimageUpload(packageImage);
		
		
		createPackage.getCreateButton();
		WebElement success=createPackage.getSuccessStatus();
		
		if(success.isDisplayed())
		{
			System.out.println("Test case1 is pass");
			common.getAdministratorDropdwn();
			common.getadminLogout();
			common.getadminBackToHome();

			excelUtility.closeExcel();
			fileUtility.closePropertyFile();
			webDriverUtility.quit();
		}
		

	}

}

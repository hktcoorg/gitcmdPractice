package com.TestNgTestScript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.holidaygurutravel.genericUtility.BaseClass;
import com.holidaygurutravel.genericUtility.SheetName;
import com.holidaygurutravel.genericUtility.ThreadSafe;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.CreatePackagePage;


public class AdmincreatepackageTest extends BaseClass{

	@Test(groups="system")
	public void testCase1() throws NumberFormatException, IOException
	{	
		CommonPage common=new CommonPage(driver);
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
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

		Assert.assertTrue(success.isDisplayed());
		
		ThreadSafe.getExtentTest().info("system Test case1 is pass");
		Reporter.log("system Test case1 is pass", true);
		
		common.getAdministratorDropdwn();
		common.getadminLogout();
		common.getadminBackToHome();
	}

}

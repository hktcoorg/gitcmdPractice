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
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.CreatePackagePage;
import com.objectRepository.HomePage;
import com.objectRepository.UserChangePasswordPage;
import com.objectRepository.UserSignInPage;
import com.objectRepository.UserTMSDetailsPage;
import com.objectRepository.UserTMSPage;


@Listeners(com.holidaygurutravel.genericUtility.ListenerImplimentation.class)
public class Testcasses extends BaseClass{

	@Test(groups="end to end", priority = 2)
	public void AdmincreatedpackageverifyTest() throws NumberFormatException, IOException
	{	
		CommonPage common=new CommonPage(driver);
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();

		businessLibrary.userSignIn(driver);

		UserTMSPage userTMSpage=new UserTMSPage(driver);

		WebElement welcome=userTMSpage.getuserWelcomeText();

		webDriverUtility.windowScrollBy(welcome);
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.converttoString())), welcome);
		Assert.assertTrue(welcome.isDisplayed());
		Reporter.log("User is Successfully logged in");

		String packageName = fileUtility.getDataFromPropertyFile(PropertyFileKeys.PACKAGENAME.converttoString());
		WebElement pname=userTMSpage.getActualPackageName(packageName);

		webDriverUtility.windowScrollBy(pname);
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), pname);
		Assert.assertTrue(pname.isDisplayed());
		Reporter.log("Admin created Package is Displayed in user module");
		Reporter.log("integration Test case2 is Pass", true);
		common.getUserLogoutLink();	
	}

	@Test(priority = 1)
	public void AdmincreatepackageTest() throws NumberFormatException, IOException
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

		Reporter.log("system Test case1 is pass", true);
		common.getAdministratorDropdwn();
		common.getadminLogout();
		common.getadminBackToHome();
	}

	@Test(priority = 3)
	public void UserbookpackageTest() throws IOException, NumberFormatException, EncryptedDocumentException
	{
		BusinessLibraryPage businessLibrary=new BusinessLibraryPage();
		UserTMSPage userTMSpage=new UserTMSPage(driver);
		UserTMSDetailsPage userTMSdetails=new UserTMSDetailsPage(driver);
		CommonPage common=new CommonPage(driver);

		businessLibrary.userSignIn(driver);

		WebElement welcome = userTMSpage.getuserWelcomeText();
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), welcome);
		Assert.assertTrue(welcome.isDisplayed());
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

		Reporter.log("regrasion Test case3 is pass", true);
		userTMSpage.getHomeBtn();
		common.getUserLogoutLink();
	}

	@Test(priority = 4)
	public void UserpasswordchangeTest() throws NumberFormatException, IOException
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
			Reporter.log("Password is changed successfully");
		}
		catch(Exception e)
		{
			Reporter.log("Password is not updated");
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
		Reporter.log("Logged in With NewPasword is Succes");
		Reporter.log("integration Test case4 is Passed", true);

		userTMSpage.getHomeBtn();
		common.getUserLogoutLink();

	}

}

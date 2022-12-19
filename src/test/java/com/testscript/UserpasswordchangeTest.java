package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.holidaygurutravel.genericUtility.BaseClassVeriables;
import com.holidaygurutravel.genericUtility.ExcelUtility;
import com.holidaygurutravel.genericUtility.FileUtility;
import com.holidaygurutravel.genericUtility.IConstantPath;
import com.holidaygurutravel.genericUtility.PropertyFileKeys;
import com.holidaygurutravel.genericUtility.SheetName;
import com.holidaygurutravel.genericUtility.WebDriverUtility;
import com.objectRepository.BusinessLibraryPage;
import com.objectRepository.CommonPage;
import com.objectRepository.HomePage;
import com.objectRepository.UserChangePasswordPage;
import com.objectRepository.UserSignInPage;
import com.objectRepository.UserTMSPage;

public class UserpasswordchangeTest extends BaseClassVeriables
{
	static WebDriver driver;
	public static void main(String[] args) throws IOException {

		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();

		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);


		driver = webDriverUtility.lunchAppication();

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
			System.out.println("User is Successfully logged in");
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
		if(success.isDisplayed())
		{
			System.out.println("Password is changed successfully");
		}
		else
		{
			System.out.println("Password is not updated");
		}

		WebElement logout=userChangePassword.getUserLogoutElement();
		//	 = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), logout);
		logout.click();


		homePage.getUserSignInLink().click();
		userSignIn.enterYourEmail(fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.converttoString()));
		userSignIn.enterUserPassword(newPassword);
		userSignIn.getSignInButton();

		//		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		//		driver.findElement(By.xpath("//input[@id='email' and @placeholder='Enter your Email']")).sendKeys(userUsername);
		//		driver.findElement(By.xpath("//input[@id='password' and @placeholder='Password']")).sendKeys(newPassword);
		//		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();	


		WebElement welcome1=userTMSpage.getuserWelcomeText();
		//		WebElement welcome1 = driver.findElement(By.xpath("//li[text()='Welcome :']"));
		webDriverUtility.waitVesibilityOfElemement(Long.parseLong(fileUtility.getDataFromPropertyFile("timeout")), welcome1);
		if(welcome1.isDisplayed())
		{
			System.out.println("Logged in With NewPasword is Succes");
			System.out.println("Text case4 is Passed");

			userTMSpage.getHomeBtn();
			common.getUserLogoutLink();
			//			driver.findElement(By.xpath("//a[text()='Home']")).click();
			//			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			excelUtility.closeExcel();
			fileUtility.closePropertyFile();
			webDriverUtility.quit();
		}
		
	}
}

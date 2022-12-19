package com.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.holidaygurutravel.genericUtility.FileUtility;
import com.holidaygurutravel.genericUtility.IConstantPath;
import com.holidaygurutravel.genericUtility.PropertyFileKeys;


/**
 * This class includes all BusinessLibrary methods
 * @author THRINESH
 *
 */
public class BusinessLibraryPage {
	FileUtility fileUtility;

	/**
	 * User Sign in method
	 * @param driver
	 * @throws IOException
	 */
	public void userSignIn(WebDriver driver) throws IOException
	{
		fileUtility=new FileUtility();
		HomePage homePage=new HomePage(driver);
		UserSignInPage userSignIn=new UserSignInPage(driver);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		
		String userUsername = fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.converttoString());
		String userPassword = fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAMEPASSWORD.converttoString());
	
		homePage.getUserSignInLink().click();
		userSignIn.enterYourEmail(userUsername);
		userSignIn.enterUserPassword(userPassword);
		userSignIn.getSignInButton();	
	}
	
	public void userSignIn(WebDriver driver, String userUsername, String userPassword) throws IOException
	{
		fileUtility=new FileUtility();
		HomePage homePage=new HomePage(driver);
		UserSignInPage userSignIn=new UserSignInPage(driver);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		
		homePage.getUserSignInLink().click();
		userSignIn.enterYourEmail(userUsername);
		userSignIn.enterUserPassword(userPassword);
		userSignIn.getSignInButton();
	}
	/**
	 * Admin sign in method
	 * @param driver
	 * @throws IOException
	 */
	public void adminSignIn(WebDriver driver) throws IOException
	{
		fileUtility=new FileUtility();
		HomePage homePage=new HomePage(driver);
		AdminSignPage adminSign=new AdminSignPage(driver);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		
		String adminUsername = fileUtility.getDataFromPropertyFile(PropertyFileKeys.ADMINUSERNAME.converttoString());
		String adminPassword = fileUtility.getDataFromPropertyFile(PropertyFileKeys.ADMINPASSWORD.converttoString());

		
		homePage.getAdminSignInLink();
		adminSign.enterAdminUserName(adminUsername);
		adminSign.enterAdminPassword(adminPassword);
		adminSign.getSignInButton();
	}
	
	public void adminSignIn(WebDriver driver, String adminUsername, String adminPassword) throws IOException
	{
		fileUtility=new FileUtility();
		HomePage homePage=new HomePage(driver);
		AdminSignPage adminSign=new AdminSignPage(driver);
		fileUtility.openPropertyFile(IConstantPath.PROPERTIES_PATH);
		
		homePage.getAdminSignInLink();
		adminSign.enterAdminUserName(adminUsername);
		adminSign.enterAdminPassword(adminPassword);
		adminSign.getSignInButton();
	}
	

}

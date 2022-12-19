package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Home page objects repository class
 * @author THRINESH
 *
 */
public class HomePage{

	WebDriver driver;
	
	//@FindBy used for only Static elements
	//WebElement and List>WebElement we can use
	//we can create Business library inside the same class then we don't use getters just create normal method

	@FindBy(xpath="//a[contains(text(),'Sign In')]") private WebElement userSignIn;
	@FindBy(xpath="//a[text()='Admin Login']") private WebElement adminSignIn;


	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * To get user Sign in in Link
	 * @return 
	 */
	public WebElement getUserSignInLink() 
	{
		return userSignIn;
	}

	/**
	 * To get Admin Sign in Link
	 */
	public void getAdminSignInLink() 
	{
		adminSignIn.click();
	}





}

package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.holidaygurutravel.genericUtility.PropertyFileKeys;
/**
 * This class is includes user sign in page object repository
 * @author THRINESH
 *
 */
public class UserSignInPage {

	@FindBy(xpath = "//input[@id='email' and @placeholder='Enter your Email']") private WebElement enterYourEmailTextField;
	@FindBy(xpath = "//input[@id='password' and @placeholder='Password']") private WebElement userPasswordTextField;
	@FindBy(xpath = "//input[@value='SIGNIN']") private WebElement userSignInButton;

	
	
	
	public UserSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	/**
	 * To enter email
	 * @param userUsername
	 */
	public void enterYourEmail(String userUsername)
	{
		enterYourEmailTextField.sendKeys(userUsername);
	}
	
	/**
	 * To enter Password
	 * @param userPassword
	 */
	public void enterUserPassword(String userPassword)
	{
		userPasswordTextField.sendKeys(userPassword);
	}
	
	/**
	 * click on Sign in button
	 */
	public void getSignInButton()
	{
		userSignInButton.click();
	}

}

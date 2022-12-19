package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSignPage 
{
	@FindBy(xpath = "//input[@name='username']") private WebElement adminUserNameTextField;
	@FindBy(xpath = "//input[@name='password']") private WebElement adminPasswordTextField;
	@FindBy(xpath = "//input[contains(@value,'Sign In')]") private WebElement adminSignInButton;

	
	public AdminSignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to enter user name
	 * @param adminUsername
	 */
	public void enterAdminUserName(String adminUsername)
	{
		adminUserNameTextField.sendKeys(adminUsername);
	}
	/**
	 * * This method is used to enter password of admin
	 * @param adminPassword
	 */
	 
	public void enterAdminPassword(String adminPassword)
	{
		adminPasswordTextField.sendKeys(adminPassword);
	}
	
	/**
	 * To get Sign in button and click action
	 */
	public void getSignInButton()
	{
		adminSignInButton.click();
	}
	

}

package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class includes all common objects or elements in project
 * @author THRINESH
 *
 */
public class CommonPage {
	
	@FindBy(xpath = "//span[contains(text(),'Tour Packages')]") private WebElement tourPakagesLHN;
	@FindBy(xpath = "//a[text()='Create']") private WebElement tourPakagesCreateLHN;
	@FindBy(xpath = "//a[@data-toggle='dropdown']") private WebElement administratorDropdwn;
	@FindBy(xpath = "//a[@href='logout.php']") private WebElement adminLogout;
	@FindBy(xpath = "//a[text()='Back to home']") private WebElement adminBackToHome;
	@FindBy(xpath = "//a[contains(text(),'Logout')]") private WebElement userLogoutLink;
	

	
	
	public CommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	/**
	 * To get Tour package click action
	 */
	public void getTourPackagesLHN()
	{
		tourPakagesLHN.click();
	}
	
	
	/**
	 * To get Tour Package click action
	 */
	public void getTourPackagesCreateLHN()
	{
		tourPakagesCreateLHN.click();
	}
	
	/**
	 * To get Admin dropdown for logout click action
	 */
	public void getAdministratorDropdwn()
	{
		administratorDropdwn.click();
	}
	
	
	/**
	 * To get admin logout click action
	 */
	public void getadminLogout()
	{
		adminLogout.click();
	}
	
	
	/**
	 * To get admin back to home  click action
	 */
	public void getadminBackToHome()
	{
		adminBackToHome.click();
	}
	
	/**
	 * To get user log out click action
	 */
	public void getUserLogoutLink()
	{
		userLogoutLink.click();
	}

}

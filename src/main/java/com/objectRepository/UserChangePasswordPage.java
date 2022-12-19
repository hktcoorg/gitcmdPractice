package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class change Password Page object repository
 * @author THRINESH
 *
 */
public class UserChangePasswordPage {
	
	@FindBy(xpath ="//input[@name='password' and @placeholder='Current Password']") private WebElement cuurertPasswordTF;
	@FindBy(xpath ="//input[@id='newpassword' and @placeholder='New Password']") private WebElement newPasswordTF;
	@FindBy(xpath ="//input[@id='confirmpassword' and @placeholder='Confrim Password']") private WebElement confirmPasswordTF;
	@FindBy(xpath ="//button[text()='Change']") private WebElement changeBtn;
	@FindBy(xpath ="//strong[.='SUCCESS']") private WebElement successStatus;
	@FindBy(xpath ="//a[contains(text(),'Logout')]") private WebElement userLogoutElement;
	
	public UserChangePasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * To get Current password text field
	 * @param currentPassword
	 */
	public void getCuurertPasswordTF(String currentPassword)
	{
		cuurertPasswordTF.sendKeys(currentPassword);;
	}
	
	/**
	 * To get New Password text field
	 * @param newPassword
	 */
	public void getNewPasswordTF(String newPassword)
	{
		newPasswordTF.sendKeys(newPassword);;
	}
	
	
	/**
	 * To get confirm password
	 * @param confirmPassword
	 */
	public void getConfirmPasswordTF(String confirmPassword)
	{
		confirmPasswordTF.sendKeys(confirmPassword);;
	}
	
	/**
	 * To get change button click action
	 */
	public void getchangeBtn()
	{
		changeBtn.click();
	}
	
	/**  
	 * to get Success status
	 * @return
	 */
	public WebElement getSuccessStatus()
	{
		return successStatus;
	}
	
	/**
	 * To get USer log out Element to verify
	 * @return
	 */
	public WebElement getUserLogoutElement()
	{
		return userLogoutElement;
	}

}

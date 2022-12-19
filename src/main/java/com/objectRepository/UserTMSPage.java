package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class includes User Tour management page object repository
 * @author THRINESH
 *
 */
public class UserTMSPage {
	WebDriver driver;
	
	
	
	@FindBy(xpath = "//li[text()='Welcome :']") private WebElement userWelcomeText;
	@FindBy(xpath ="//a[text()='Home']") private WebElement homeBtn;
	@FindBy(xpath ="//a[contains(text(),'Change Password')]") private WebElement changeaPasswordLink;
	String pN="//div/h3[.='Package List']/../div/div[2]/h4[contains(text(),'%s')]";
	String details="//div/h3[.='Package List']/../div/div[2]/h4[contains(text(),'%s')]/../../div[3]/a[text()='Details']";
	
	public UserTMSPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

/**
 * To get user welcome Text
 * @return
 */
	public WebElement getuserWelcomeText()
	{
		return  userWelcomeText;
	}

	/**
	 * To get Home Button
	 */
	public void getHomeBtn()
	{
		homeBtn.click();
	}
	
	
	/**
	 * To get change password link
	 */
	public void getchangeaPasswordLink()
	{
		changeaPasswordLink.click();
	}
	
	/**
	 * String to WebElement conversion
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement stringToWebElement(String partialXpath, String replaceData)
	{
		String xpath=String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * To get WebElement with expected xpathName
	 * @param expectedDetailsButton
	 * @return
	 */
	public WebElement getActualPackageName(String expectedPackageName)
	{
		return stringToWebElement(pN, expectedPackageName);
	}
	/**
	 * To get WebElement with expected xpathName
	 * @param expectedDetailsButton
	 * @return
	 */
	public WebElement getActualDetailsButton(String expectedDetailsButton)
	{
		return stringToWebElement(details, expectedDetailsButton);
	}
}

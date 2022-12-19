package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class includes the user Tour Management system page object repository
 * @author THRINESH
 *
 */
public class UserTMSDetailsPage {
	WebDriver driver;
	
	@FindBy(xpath ="//label[text()='From']/../input") private WebElement fromDateInput;
	@FindBy(xpath ="//label[text()='To']/../input") private WebElement toDateInput;
	@FindBy(xpath ="//button[text()='Book']") private WebElement bookBtn;
	@FindBy(xpath ="//input[@name='comment']") private WebElement commentTF;
	@FindBy(xpath ="//strong[.='SUCCESS']") private WebElement successStatus;
	String fD="//table/tbody/tr/td/a[text()='%s']";
	String tD="//table/tbody/tr/td/a[text()='%s']";
	
	
	//calender popup
	@FindBy(xpath ="//div/span[@class='ui-datepicker-month']") private WebElement calcurrentMonth;
	@FindBy(xpath ="//div/span[@class='ui-datepicker-year']") private WebElement calcurrentYear;
	@FindBy(xpath ="//div/a[@title='Next']") private WebElement calnextButton;
	@FindBy(xpath ="//div/a[@title='Prev']") private WebElement calPreviousButton;
	String reqDate="//td[@data-handler='selectDay']/a[.='%s']";
	

	
	
	public UserTMSDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * get from date Click action
	 */
	public void getfromDateInput()
	{
		fromDateInput.click();
	}
	
	/**
	 * to get TO date click action
	 */
	public void getToDateInput()
	{
		toDateInput.click();
	}
	
	/**
	 * To get Book button click
	 * @return
	 */
	public WebElement getBookBtn()
	{
		return	bookBtn;
	}
	
	/**
	 * To get comment Text block
	 * @param comment
	 */
	public void getCommentTF(String comment)
	{
		commentTF.sendKeys(comment);
	}
	
	/**
	 * Get Success status to verify
	 * @return
	 */
	public WebElement getSuccessStatus()
	{
		return successStatus;
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
	
	private WebElement stringToWebElementForConertionInt(String partialXpath, int replaceData)
	{
		String xpath=String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * To get WebElement with expected xpathName
	 * @param expectedDetailsButton
	 * @return
	 */
	public WebElement getActualFromDate(String expectedFromDate)
	{
		return stringToWebElement(fD, expectedFromDate);
	} 
	
	/**
	 * To get WebElement with expected xpathName
	 * @param expectedDetailsButton
	 * @return
	 */
	public WebElement getActualToDate(String expectedToDate)
	{
		return stringToWebElement(tD, expectedToDate);
	} 
	
	
	
	
	/**
	 * This below element for calendar
	 * @return
	 */
	
	/**
	 * To get WebElement with expected xpathName for calendar popup
	 * @param expectedreqDate
	 * @return
	 */
	public WebElement getCalDate(String expectedreqDate)
	{
		return stringToWebElement(reqDate, expectedreqDate);
	}
	
	/**
	 * This method is used to Month and date conversion for int form
	 * @param expectedreqDate
	 * @return
	 */
	public WebElement getCalDateIntForm(int expectedreqDate)
	{
		return stringToWebElementForConertionInt(reqDate, expectedreqDate);
	}
	
	public WebElement getCalcurrentMonth()
	{
		return	calcurrentMonth;
	}
	
	public WebElement getCalcurrentYear()
	{
		return	calcurrentYear;
	}
	
	public WebElement getCalnextButton()
	{
		return	calnextButton;
	}
	public WebElement getcalPreviousButton()
	{
		return	calPreviousButton;
	}
}

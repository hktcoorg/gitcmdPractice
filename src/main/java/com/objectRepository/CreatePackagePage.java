package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePackagePage {
	
	@FindBy(xpath = "//input[@placeholder='Create Package']") private WebElement createPackageTF;
	@FindBy(xpath = "//input[@id='packagetype']") private WebElement packagetypeTF;
	@FindBy(xpath = "//input[@id='packagelocation']") private WebElement packagelocationTF;
	@FindBy(xpath = "//input[@id='packageprice']") private WebElement packagepriceTF;
	@FindBy(xpath = "//input[@id='packagefeatures']") private WebElement packagefeaturesTF;
	@FindBy(xpath = "//textarea[@id='packagedetails']") private WebElement packagedetailsTAreaF;
	@FindBy(xpath = "//input[@id='packageimage']") private WebElement packageimageUpload;
	@FindBy(xpath = "//button[text()='Reset']") private WebElement resetButton;
	@FindBy(xpath = "//button[text()='Create']") private WebElement createButton;
	@FindBy(xpath = "//strong[.='SUCCESS']") private WebElement successStatus;
	

	
	
	
	public CreatePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * create package text field
	 * @param createPackageName
	 */
	public void createPackageTF(String createPackageName)
	{
		createPackageTF.sendKeys(createPackageName);
	}
	
	/**
	 * Package type text field
	 * @param packageType
	 */
	public void packagetypeTF(String packageType)
	{
		packagetypeTF.sendKeys(packageType);
	}
	
	/**
	 * To get location text field
	 * @param packageLocation
	 */
	
	public void packagelocationTF(String packageLocation)
	{
		packagelocationTF.sendKeys(packageLocation);
	}
	
	/**
	 * to get package price
	 * @param packageLocation
	 */
	public void packagepriceTF(String packageLocation)
	{
		packagepriceTF.sendKeys(packageLocation);
	}
	/**
	 * to get package features text field
	 * @param packageFeatures
	 */
	public void packagefeaturesTF(String packageFeatures)
	{
		packagefeaturesTF.sendKeys(packageFeatures);
	}
	
	/**
	 * To get package details text area
	 * @param packageDetails
	 */
	public void packagedetailsTAreaF(String packageDetails)
	{
		packagedetailsTAreaF.sendKeys(packageDetails);
	}
	
	/**
	 * to upload the package image use this method
	 * @param packageImage
	 */
	public void packageimageUpload(String packageImage)
	{
		packageimageUpload.sendKeys(packageImage);
	}
	
	
	/**
	 * To get Reset button click action
	 * @return
	 */
	public WebElement getResetButton()
	{
		return resetButton;
	}

	/**
	 * To get create button click action
	 */
	public void getCreateButton()
	{
		createButton.click();
	}
	
	/**
	 * To get Success status verify
	 * @return
	 */
	public WebElement getSuccessStatus()
	{
		return successStatus;
	}
	

}

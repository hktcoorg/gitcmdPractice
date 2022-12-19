package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {
	
	@FindBy(xpath="//div/h2[.='Top Offers']") private WebElement FashionDeals;
	
	public FlipkartPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFashionDeals()
	{
		return FashionDeals;
	}

}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage
{
	//Page Locator
	//Locator of one product that is having product id = 0093344
	private By productId = By.xpath("//article[@data-product-id='0093344']"); 
	
	//Constructor of page "HomePage"
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//public getter of private variable "productId"
	public WebElement getproductId()
	{
		return getElement(productId); 
	}
	
	// Method to click one product on Home Page
	public ProductDetailsPage clickProduct() 
	{
		js.executeScript("arguments[0].scrollIntoView();",getproductId());
		// Click on one product on Bunnings Home Page
		getproductId().click();
		// Calling Non Abstract Method "getInstance" from Page class that is returning "ProductDetailsPage" class 
		return getInstance(ProductDetailsPage.class);
	}
}

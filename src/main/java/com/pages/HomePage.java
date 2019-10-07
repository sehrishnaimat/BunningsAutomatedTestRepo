package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage
{
	//Page Locator
	//Locator of one random product that is having unique product id = 0093344
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
	
	// Actions
	
	// Method to click one product on Home Page
	public ProductDetailsPage clickProduct() 
	{
		//Calling method scrollDown from BasePage 
		scrollDown(getproductId());
		// Click on one product on Bunnings Home Page
		getproductId().click();
		// Calling Non Abstract Method "getInstance" from Page class that is returning "ProductDetailsPage" class 
		return getInstance(ProductDetailsPage.class);
	}
}

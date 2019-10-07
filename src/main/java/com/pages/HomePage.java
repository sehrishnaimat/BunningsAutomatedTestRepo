package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage
{
	//Page Locator
	//Locator of one random product that is having unique product id = 0093344
	//private By productId = By.xpath("//article[@data-product-id='0093344']"); 
	private By searchresult_item = By.xpath("//*[contains(@class,'product-tile__row--title')]");
	
	//Constructor of page "HomePage"
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//public getter of private variable "productId"
	public List<WebElement> getsearchresult_item()
	{
		return getListOfElement(searchresult_item); 
	}
	
	// Actions
	
	// Method to click one product on Home Page
	public ProductDetailsPage clickProduct() 
	{
		//Calling method scrollDown from BasePage 
		scrollDown(getsearchresult_item());
		// Click on one product on Bunnings Home Page
		Integer myRandomNumber = generateRandomNumber(getsearchresult_item());
		String productFullText = getsearchresult_item().get(myRandomNumber).getText();
		System.out.println("Selected Product:" +productFullText);
		getsearchresult_item().get(myRandomNumber).click();
		//getsearchresult_item().click();
		// Calling Non Abstract Method "getInstance" from Page class that is returning "ProductDetailsPage" class 
		return getInstance(ProductDetailsPage.class);
	}
}

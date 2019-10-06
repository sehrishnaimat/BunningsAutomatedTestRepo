package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage
{
	
	//Page Locators
	//Locator of Product ID present on Product Details Page
	private By detailsPageProductID = By.xpath("//span[@class='product-in']");
	// Locator of "Add To Wish List" button
	private By addToWishListBtn = By.xpath("//button[@class='btn-add-wishlist inactive']");
	// Locator of "Wish List" Link
	private By wishListLink = By.xpath("//div[@class='added-message']//span//a[@class='shopping-list-btn btn']");

	//Public getter of private variable "detailsPageProductID"
	public WebElement getdetailsPageProductID() 
	{
		return getElement(detailsPageProductID);
	}
	//Public getter of private variable "addWishListBtn"
	public WebElement getAddWishListBtn() 
	{
	return getElement(addToWishListBtn);
	}
	//Public getter of private variable "wishListLink"
	public WebElement getWishListLink()
	{
	return getElement(wishListLink);
	}
	
	//Constructor of ProductDetailsPage
	public ProductDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Actions
	
	//Method to get Product ID on Product Details Page, adding product to WishList and navigating to WishList Page
	public String addProductToWishList() throws InterruptedException 
	{
		String productIDDetailsPage = getdetailsPageProductID().getAttribute("content") ;
		System.out.println("Product id on Details Page is: " +productIDDetailsPage);
		
		// Click on "Add To Wish List" button
		getAddWishListBtn().click();
		
		// Calling method "waitForElementPresent" from BasePage to add explicit wait
		//waitForElementPresent(getWishListLink());
	
		//This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", getWishListLink());
        
        Thread.sleep(2000);
        // Click on "Wish List" Link
		js.executeScript("arguments[0].click();",getWishListLink());
		
		// This Method will return the product Id present on Product Details Page
		return productIDDetailsPage;
	}

}

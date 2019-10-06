package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishListPage extends BasePage
{
	//Page Locator
	//Locator of Product Id present on WishList Page
	private By wishListPageProductID = By.xpath("//small[@class='fineline']");

	//public getter of private variable "wishListPageProductID"
	public WebElement getWishListPageProductID() 
	{
		return getElement(wishListPageProductID);
	}
	
	//Constructor of MyWishListPage
	public MyWishListPage(WebDriver driver)
	{
		// Calling constructor of of Parent Class i.e. BasePage
		super(driver);
	}
	
	//Get the Product ID on Wish List page of previously added product from Product Details Page 
	public String getProductIdWishListPage()
	{
		String productIDWishListPage = getWishListPageProductID().getText().split(":")[1].trim();
		System.out.println("Product ID on WishList Page is: " +productIDWishListPage);
		// This Method will return the product Id present on Wish List Page
		return productIDWishListPage;
	}
}

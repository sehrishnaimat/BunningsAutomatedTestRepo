package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	public WebDriver driver;
	public WebDriverWait wait;
	
	// Constructor of Class "Page"
	public Page(WebDriver driver){
		this.driver = driver;
		this.wait   = new WebDriverWait(this.driver,15);
	} 
	
	//Abstract Method to locate elements
	public abstract WebElement getElement(By locator);
	
	//Abstract Method to add explicit wait
	public abstract void waitForElementPresent(WebElement element);
	
	//Method created through Java Generics that returns a new page object
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
			try 
			{
				return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return null;
			}
	}
	
}

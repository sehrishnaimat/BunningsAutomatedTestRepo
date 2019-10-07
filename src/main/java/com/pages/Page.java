package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	// Constructor of Class "Page"
	public Page(WebDriver driver)
	{
		this.driver = driver;
		this.wait   = new WebDriverWait(this.driver,15);
	} 
	
	//Abstract Method to get List of Elements
	public abstract List<WebElement> getListOfElement(By locator); 
	
	//Abstract Method to locate elements
	public abstract WebElement getElement(By locator);
	
	//Abstract Method to scroll down until the element is present
	public abstract void scrollDown(WebElement element);
	
	//Abstract Method to scroll down until the list of element
	public abstract void scrollDown(List<WebElement> element);
	
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

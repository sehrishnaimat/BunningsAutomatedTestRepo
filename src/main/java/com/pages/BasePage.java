package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends Page
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//Constructor of BasePage Class
	public BasePage(WebDriver driver) 
	{
		super(driver);	
	}
	
	// Overridden Methods 
	@Override
	public WebElement getElement(By locator) 
	{
		WebElement element=null;
		try 
		{
			element = driver.findElement(locator);  
			return element;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return element; 
	}

	@Override
	public void waitForElementPresent(WebElement element) 
	{
		try 
		{
		wait.until(ExpectedConditions.invisibilityOf(element));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

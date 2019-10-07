package com.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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
	public void scrollDown(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	@Override
	public List<WebElement> getListOfElement(By locator) 
	{
		List<WebElement> element=null;
		try 
		{
			element = driver.findElements(locator);  
			return element;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return element; 
	}	
	
	@Override
	public void scrollDown(List<WebElement> element) 
	{
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public static Integer generateRandomNumber(List<WebElement> WebElement) 
	{
		Random r = new Random();
		Integer randomNumber = r.nextInt(WebElement.size());
		return randomNumber;
	}

}

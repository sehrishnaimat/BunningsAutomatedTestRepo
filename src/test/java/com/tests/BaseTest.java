package com.tests;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pages.BasePage;
import com.pages.Page;

public class BaseTest 
{
	WebDriver driver;
	public Page page;
	Environment testEnvironment;	
	
@BeforeMethod

@Parameters({"environment"})

public void setUp(String environemnt) 
{
	System.setProperty("webdriver.chrome.driver","D:\\selnium\\chromedriver_win32\\chromedriver.exe");
	// launch chrome browser
	driver = new ChromeDriver();
	// Maximize window
	driver.manage().window().maximize(); 
	// Delete all cookies
	driver.manage().deleteAllCookies(); 
	ConfigFactory.setProperty("env", environemnt); 
	//creating an instance of the Environment interface & access the property file.
	testEnvironment = ConfigFactory.create(Environment.class);
	String envUrl=testEnvironment.url();
	// Open the URL
	driver.get(envUrl);
	
	page = new BasePage(driver);
}

@AfterMethod
public void tearDown()
{
	//Quitting browser
	driver.quit();
}

}

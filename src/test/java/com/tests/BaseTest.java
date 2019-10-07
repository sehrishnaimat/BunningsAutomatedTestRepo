package com.tests;

import java.io.File;

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
//TestNG test will access the environment parameter from the testng.xml and use it to read the specific property file.
@Parameters({"environment"})

	public void setUp(String environemnt) 
	{
		String userdir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", userdir + File.separator + "/src/main/resources/drivers/chromedriver.exe");
		// launch chrome browser
		driver = new ChromeDriver();
		// Maximize window
		driver.manage().window().maximize(); 
		// Delete all cookies
		driver.manage().deleteAllCookies(); 
		//env in Environment interface will be set to value fetched from properties file
		ConfigFactory.setProperty("env", environemnt); 
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

package com.eBanking.testCases;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public String baseURL = "https://demo.guru99.com/v4/";
	public String username = "mngr545042";
	public String password = "udyrEbe";
	public static WebDriver driver;
	public static Logger logger;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    logger = Logger.getLogger("E-Banking");
	    PropertyConfigurator.configure("log4j.properties");
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

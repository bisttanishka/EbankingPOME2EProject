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
		// Print the absolute path to log4j.properties for debugging
	    System.out.println("log4j.properties path: " +
	            new File("log4j.properties").getAbsolutePath());
		//logger = Logger.getLogger("TC_LoginTest");
		
		
		// Get the absolute path to log4j.properties
	    String log4jConfigPath = System.getProperty("user.dir") + "/log4j.properties";
	    System.out.println("log4j.properties path: " + log4jConfigPath);

	    // Configure Log4j with the specified path
	    PropertyConfigurator.configure(log4jConfigPath);

	    logger = Logger.getLogger("TC_LoginTest");
		
		
		
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

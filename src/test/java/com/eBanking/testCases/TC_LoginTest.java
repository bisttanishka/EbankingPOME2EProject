package com.eBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass

{

	@Test
	public void loginTest() throws IOException {

		logger.info("Browser Open");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("UserName Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			captureScreenshots(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test fail");
		}
	}
}

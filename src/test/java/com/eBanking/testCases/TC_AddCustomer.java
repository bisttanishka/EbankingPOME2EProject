package com.eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.AddCustomerPage;
import com.eBanking.pageObjects.LoginPage;

public class TC_AddCustomer extends BaseClass {

	@Test
	public void addCustomer() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addcustomer = new AddCustomerPage(driver);
		logger.info("Providing customer details");
		Thread.sleep(3000);
		addcustomer.clickNewCustomer();
		addcustomer.custName("Sumit");
		addcustomer.custGender("Male");
		addcustomer.custdob("07", "10", "2000");
		addcustomer.custAddress("Vasant Vihar");
		addcustomer.custCity("Dehradun");
		addcustomer.custState("Uttrakhand");
		addcustomer.custPincode("248001");
		addcustomer.custtelephone("9090909090");
		String email = randomString() + "@gmail.com";
		addcustomer.custEmail(email);
		addcustomer.custPassword("abcd");
		addcustomer.custSubmit();
		Thread.sleep(3000);

		logger.info("customer validation is started");

		boolean registrationMsg = driver.findElement(By.xpath("//p[text()=\"Customer Registered Successfully!!!\"]"))
				.isDisplayed();
		
		if (registrationMsg == true) {
			
			captureScreenshots(driver, "AddCust1");
			Assert.assertTrue(true);
			logger.info("Test case is passed");
			System.out.println("Registration is successfull !!");

		} else {
			
			logger.info("Test case is failed");
			captureScreenshots(driver, "AddCust");
			Assert.assertTrue(false);
			System.out.println("Registration is not done !!");
		}

}

	
}

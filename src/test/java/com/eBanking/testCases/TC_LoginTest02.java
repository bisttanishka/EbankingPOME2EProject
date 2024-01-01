package com.eBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilities.XLUtils;

public class TC_LoginTest02 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String upwd) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(upwd);
		lp.clickSubmit();

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed due to incorrect username and password");
		}

		else {
			Assert.assertTrue(true);
			logger.info("Login is successful");
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {

			return false;

		}

	}

	@DataProvider(name = "LoginData")

	public String[][] getdata() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/eBanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] data = new String[rownum][colnum];
		for (int i = 1; i <=rownum; i++) {

			for (int j = 0; j < colnum; j++) {

				data[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return data;

	}

}

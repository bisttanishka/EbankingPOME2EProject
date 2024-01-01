package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public AddCustomerPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//a[@href=\"addcustomerpage.php\"]")
	WebElement AddCustomer;

	@FindBy(name = "name")
	WebElement CustomerName;

	@FindBy(name = "rad1")
	WebElement Gender;
	@FindBy(name = "dob")
	WebElement DoB;

	@FindBy(name = "addr")
	WebElement Address;

	@FindBy(name = "city")
	WebElement City;

	@FindBy(name = "state")
	WebElement State;

	@FindBy(name = "pinno")
	WebElement Pin;

	@FindBy(name = "telephoneno")
	WebElement telephone;

	@FindBy(name = "emailid")
	WebElement EmailId;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//input[@value=\"Submit\"]")
	WebElement Submit;

	public void clickNewCustomer() {
		AddCustomer.click();
	}

	public void custName(String cname) {
		CustomerName.sendKeys(cname);
	}

	public void custGender(String cgender) {
		Gender.sendKeys(cgender);
	}
	
	public void custdob(String mm,String dd,String yy) {
		DoB.sendKeys(mm);
		DoB.sendKeys(yy);
		DoB.sendKeys(dd);
	}
	public void custAddress(String caddress) {
		Address.sendKeys(caddress);
	}
	public void custCity(String ccity) {
		City.sendKeys(ccity);
	}
	public void custState(String cstate) {
		State.sendKeys(cstate);
	}
	public void custPincode(String cpincode) {
		Pin.sendKeys(String.valueOf(cpincode));
	}
	public void custtelephone(String ctelephone) {
		telephone.sendKeys(ctelephone);
	}
	public void custEmail(String cemail) {
		EmailId.sendKeys(cemail);
	}
	public void custPassword(String cpassword) {
		Password.sendKeys(cpassword);
	}
	public void custSubmit() {
		Submit.click();
}
   
}
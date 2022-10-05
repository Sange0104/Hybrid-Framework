package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver driver;
	
	public AddNewCustomer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCust;
	
	@FindBy(how = How.NAME, using ="rad1") // another way of finding web elements
	@CacheLookup
	WebElement btnGender;
	
	@FindBy(how = How.ID, using ="dob")
	@CacheLookup
	WebElement btndob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPincode;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtMobile;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;

	
	public void clickAddNewCustomer() {
		lnkNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCust.sendKeys(cname);
	}
	
	public void custgender(String gender) {
		btnGender.click();
	}
	
	public void custdob(String mm, String dd, String yyyy) {
		btndob.sendKeys(mm);
		btndob.sendKeys(dd);
		btndob.sendKeys(yyyy);
	}
	
	public void custaddr(String address) {
		txtAddress.sendKeys(address);
	}
	
	public void custcity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void custstate(String state) {
		txtState.sendKeys(state);
	}
	
	public void custpincode(String pin) {
		txtPincode.sendKeys(String.valueOf(pin)); //if pincode is integer data type then use the function String.valueof(pin)
	}
	
	public void custmobile(String tel) {
		txtMobile.sendKeys(tel);
	}
	
	public void custemail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void custpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
}

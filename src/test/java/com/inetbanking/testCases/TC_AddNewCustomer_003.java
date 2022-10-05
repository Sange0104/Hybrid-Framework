package com.inetbanking.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		
		//login to the application
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		
		AddNewCustomer addcust = new AddNewCustomer(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Sangeetha");
		addcust.custgender("female");
		addcust.custdob("10", "20", "1980");
		addcust.custcity("West windsor");
		addcust.custstate("NewJersey");
		addcust.custmobile("6789654323");
		addcust.custaddr("2 Everett dr");
		addcust.custpincode("456321");
		
		String email = randomString()+"@gmail.com";
		addcust.custemail(email);
		addcust.custpassword("sdsds");
		addcust.custsubmit();
		Thread.sleep(2000);
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");	
		
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}

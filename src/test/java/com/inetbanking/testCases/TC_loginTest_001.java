package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
	
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
	
		
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				Assert.assertTrue(true);
				
			}
			
			  else {
				  captureScreen(driver, "loginTest"); //captures screen shot on failure
				  Assert.assertTrue(false);
				  }
			
		
		}
	
	}

	


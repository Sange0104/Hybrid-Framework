package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "loginData")
	public void loginDDT(String user , String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // this will close the log out alert
			driver.switchTo().defaultContent();
		}
		
	}
		
	public boolean isAlertPresent() { //user defined method created to check whether alert is present or not
		
		try {
			driver.switchTo().alert();
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
		
			
		}
		
		

	
	@DataProvider(name ="loginData")
	String[] [] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/loginData.xlsx";
		XLUtils xlutils = new XLUtils(path);
		int rownum = xlutils.getRowCount("Sheet1");
		int colnum = xlutils.getCellCount("Sheet1", rownum);
		String loginData[][]= new String[rownum][colnum];
				for (int i=1;i<rownum;i++) {
					for(int j =0;j<colnum;j++) {
						loginData[i-1][j]= xlutils.getCellData("Sheet1", i, j);
						
					}
				}
				return loginData;
	}
	

}

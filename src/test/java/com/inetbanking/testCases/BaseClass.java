package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		if(br.equals("chrome"))
		{
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") +"/Screenshots/" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
	}
	
	
	public static String randomString() {								//basically used for email fields
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
		
		public static String randomNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(8);
			return generatedString2;
	}
}

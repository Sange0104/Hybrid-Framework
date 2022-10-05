package com.inetbanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testcontext) {
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "Test-report"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		
		htmlReporter.config().setDocumentTitle("Automation Report");//Title of the report
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester Name", "Sangeetha");
		extent.setSystemInfo("Browser", "Chrome");
		
			
	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
	
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotpath = System.getProperty("user.dir") +"\\ScreenShots\\"+tr.getName() + ".png";
		File f = new File(screenshotpath);
		if(f.exists()) {
			try {
				logger.fail("Screen shot is below" + logger.addScreenCaptureFromPath(screenshotpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		}
	
	public void onFinish(ITestContext testcontext) {
		extent.flush();
	}
	

}

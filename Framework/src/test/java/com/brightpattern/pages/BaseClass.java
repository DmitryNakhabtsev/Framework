package com.brightpattern.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.brightpattern.utility.BrowserFactory;
import com.brightpattern.utility.ConfigDataProvider;
import com.brightpattern.utility.ExcelDataProvider;
import com.brightpattern.utility.Helper;

public class BaseClass {
	
	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;
	protected ExtentReports report;
	protected ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and Test is getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+ "/Reports/brightpatternAD_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done >> Test can be Started", true);
		
	}
	@Parameters({"browser", "urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String url) {
		
		Reporter.log("Trying to start Browser and Getting application ready", true);
//		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		driver = BrowserFactory.startApplication(driver, browser, url);
	
		Reporter.log("Browser and application is up and running", true);
		
	}

	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			// LoginTestAD>BaseClass.tearDownMethod:70 » IllegalArgument ScreenCapture path m...
			
		}
		
		report.flush();
		
		Reporter.log("Test Completed >>> Report generated", true);
		
	}


}

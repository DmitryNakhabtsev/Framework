package com.brightpattern.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.brightpattern.pages.BaseClass;
import com.brightpattern.pages.LoginPage;
import com.brightpattern.utility.BrowserFactory;
import com.brightpattern.utility.ExcelDataProvider;
import com.brightpattern.utility.Helper;

public class LoginTestAD extends BaseClass {
	
	@Test(priority = 1)
	public void loginApp() {
		
		logger = report.createTest("Login to Brightpattern AD");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToAD(excel.getStringData("Login",0,0), excel.getStringData("Login",0,1));
		
		logger.pass("Login Success");
	
	}
	
	@Test(priority = 2)
	public void loginApp_aj() {
		
		logger = report.createTest("Login to Brightpattern alan.jenks AD");
		
		LoginPage loginPage = PageFactory.initElements(driver_aj, LoginPage.class);
		
		logger.info("Starting Application alan.jenks");
		
		loginPage.loginToAD(excel.getStringData("Login",1,0), excel.getStringData("Login",1,1));
		
		logger.pass("Login Success");
	
	}	
	
	@Test(priority = 3)
	public void loginApp_tb() {
		
		logger = report.createTest("Login to Brightpattern tony.cobb AD");
		
		LoginPage loginPage = PageFactory.initElements(driver_tb, LoginPage.class);
		
		logger.info("Starting Application tony.cobb");
		
		loginPage.loginToAD(excel.getStringData("Login",2,0), excel.getStringData("Login",2,1));
		
		logger.pass("Login Success");
	
	}

	@Test(priority = 4)
	public void loginApp1() {
		
		logger = report.createTest("Logout");
		
		logger.fail("Logout failed");
	
	}

	
}

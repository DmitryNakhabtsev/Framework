package com.brightpattern.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.brightpattern.pages.BaseClass;
import com.brightpattern.pages.LoginPage;
import com.brightpattern.utility.BrowserFactory;
import com.brightpattern.utility.ExcelDataProvider;
import com.brightpattern.utility.Helper;

public class LoginTestAD {
	
	@Test(priority = 1)
	public void loginApp() {
		

		String agentName = "admin";
		String agentPassword = "password";
		System.setProperty("webdriver.chrome.driver", "Drivers/Linux/chromedriver");
		System.setProperty("webdriver.chrome.whitelistedIps", ""); // Cannot assign requested address (99) while starting chromedriver
	
		ChromeOptions options = new ChromeOptions();

		options.addArguments("headless");
//		options.addExtensions(new File("C:\\Users\\admin\\Documents\\AUTOMATION\\Agent Desktop Chrome Extension 1.16.0.0.crx")); // BPClient chrome extension
		options.addArguments("--disable-notifications");
		options.addArguments("use-fake-ui-for-media-stream"); // microphone access in the agent desktop
		  
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

//		driver.get("https://dima1.ssf.bugfocus.com/agentdesktop/"); //aha
		driver.get("https://autotests.ssf.bugfocus.com/agentdesktop/");
		System.out.println("Browser started on " + driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
		driver.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
		driver.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
		
/****************************************************************************************************************************/
		agentName = "alan.jenks";
		agentPassword = "password";
		
		WebDriver driver_aj = new ChromeDriver(options);
		driver_aj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver_aj.manage().window().maximize();

//		driver.get("https://dima1.ssf.bugfocus.com/agentdesktop/"); //aha
		driver_aj.get("https://autotests.ssf.bugfocus.com/agentdesktop/");
		System.out.println("Browser started on " + driver_aj.getCurrentUrl());
		
		driver_aj.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
		driver_aj.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
		driver_aj.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
		
		/****************************************************************************************************************************/
		agentName = "tony.cobb";
		agentPassword = "password";
		
		WebDriver driver_tb = new ChromeDriver(options);
		driver_tb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver_tb.manage().window().maximize();

//		driver.get("https://dima1.ssf.bugfocus.com/agentdesktop/"); //aha
		driver_tb.get("https://autotests.ssf.bugfocus.com/agentdesktop/");
		System.out.println("Browser started on " + driver_tb.getCurrentUrl());
		
		driver_tb.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
		driver_tb.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
		driver_tb.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();		
		
		driver.quit();
		System.out.println("Browser admin closed");
	
		driver_aj.quit();
		System.out.println("Browser alan.jenks closed");
		
		driver_tb.quit();
		System.out.println("Browser tony.cobb closed");
	}
	

}

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
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		WebDriver driver;

		options.addArguments("headless");

//		  options.addExtensions(new File("C:\\Users\\admin\\Documents\\AUTOMATION\\Agent Desktop Chrome Extension 1.16.0.0.crx")); // BPClient chrome extension
		  options.addArguments("--disable-notifications");
		  options.addArguments("use-fake-ui-for-media-stream"); // microphone access in the agent desktop
		  
		  WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://dima1.ssf.bugfocus.com/agentdesktop/");
		System.out.println("Browser started");
		driver.get("https://autotests.ssf.bugfocus.com/agentdesktop/");
		driver.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
		driver.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
		driver.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("Browser closed");
	
	}
	

}

package com.brightpattern.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		
		if(browserName.equals("Chrome"))
		{
			  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  
//			  options.addArguments("headless");

			  options.addExtensions(new File("C:\\Users\\admin\\Documents\\AUTOMATION\\Agent Desktop Chrome Extension 1.16.0.0.crx")); // BPClient chrome extension
			  options.addArguments("--disable-notifications");
			  options.addArguments("use-fake-ui-for-media-stream"); // microphone access in the agent desktop
			  driver = new ChromeDriver(options);
	
		}
		else if (browserName.equals("Firefox"))
		{
			System.out.println("We do not support this "+ browserName + " browser!");
		}
		else if (browserName.equals("IE"))
		{
			System.out.println("We do not support this "+ browserName + " browser!");			
		}
		else if (browserName.equals("Edge"))
		{
			System.out.println("We do not support this "+ browserName + " browser!");
		}
		else
		{
			System.out.println("We do not support this "+ browserName + " browser!");
		}
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();

		driver.quit();
		
	}

}

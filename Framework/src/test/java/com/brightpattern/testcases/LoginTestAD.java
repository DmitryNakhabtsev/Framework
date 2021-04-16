package com.brightpattern.testcases;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.brightpattern.utility.Helper;
public class LoginTestAD extends API {
	

	
	@Test(priority = -3)
	public void ArrayBefore() {

		agentInit("admin","password");
		agentInit("alan.jenks","password");
		
		agentCallTo("admin", "2022");
		wait(2000);
		System.out.println(Helper.captureScreenshot(driver_aj));
		
		String str = driver_aj.getPageSource();
//		System.out.println(str);	
		System.out.println("Page Source Length is: " + str.length());

		if (str.contains("Bright Pattern")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		wait(1000);		
		System.out.println(Helper.captureScreenshot(driver_aj));
		agentCallAnswer("alan.jenks");
		wait(2000);
		
		agentEndCall("alan.jenks");
		agentEndCall("admin");		
		
		agentLogOut("admin");				
		agentLogOut("alan.jenks");


	}
	
}
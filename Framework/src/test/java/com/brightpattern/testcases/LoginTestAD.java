package com.brightpattern.testcases;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTestAD extends API {
	

	
	@Test(priority = -3)
	public void ArrayBefore() {

		agentInit("admin","password");
		agentInit("alan.jenks","password");
		
		agentCallTo("admin", "2022");
		wait(5000);
		
		String str = driver_aj.getPageSource();
		System.out.println(str);	
		System.out.println("Page Source Length is: " + str.length());

		if (str.contains("Bright Pattern")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
//		agentCallAnswer("alan.jenks");
		wait(5000);	
		
		agentLogOut("admin");				
		agentLogOut("alan.jenks");


	}
	
}
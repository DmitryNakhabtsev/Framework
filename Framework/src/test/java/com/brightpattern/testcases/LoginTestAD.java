package com.brightpattern.testcases;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTestAD extends API {
	

	
	@Test(priority = -3)
	public void ArrayBefore() {

		agentInit("admin","password");
//		agentInit("alan.jenks","password");
//		agentCallTo("admin", "2022");
//		wait(5000);
//		agentCallAnswer("alan.jenks");
		wait(5000);
//		agentLogOut("alan.jenks");
		agentLogOut("admin");		
		
	
//		return serviceMetricsBefore;

	}
	
}
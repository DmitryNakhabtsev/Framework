package com.brightpattern.testcases;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.brightpattern.utility.Helper;
public class LoginTestAD extends API {
	
	//getServicesMetrics
	protected int serviceMetricNumber; //Service Metric index in array
	protected static String[][] serviceMetricsBefore;
	protected static String[][] serviceMetricsAfter;
	
	String agent1 = "alan.jenks";
	String agent2 = "tony.cobb";
	String admin = "admin";
	String pwd = "password";

	int callDuration = 2000; // 10 sec for every conversation
	int action = 1000; 
	
	
	@Test(priority = -3)
	public void ArrayBefore() {

		agentInit(admin,pwd);
		wait(action);
		serviceMetricsBefore = getServicesMetrics("Service A", 3);	
//		agentMetricsBefore = getAgentsMetrics("admin", 1);	
//		teamMetricsBefore = getTeamsMetrics("TeamDmitry");
		System.out.println(Helper.captureScreenshot(driver));
		printOutMetrics(serviceMetricsBefore);
		
		agentInit(agent1, pwd);
		setServiceToAgent(agent1);
		System.out.println(Helper.captureScreenshot(driver_aj));
		
		agentInit(agent2, pwd);
		setServiceToAgent(agent2);
		System.out.println(Helper.captureScreenshot(driver_tb));
		
		agentCallTo(admin, "8003");
		wait(action);
		System.out.println(Helper.captureScreenshot(driver));
		
		setReadyToAgent(agent1);
		
		agentCallAnswer(agent1);
		wait(callDuration);
		System.out.println(Helper.captureScreenshot(driver_aj));
		
		agentEndCall(agent1);
//		agentEndCall("admin");		
//		wait(2000);
		System.out.println(Helper.captureScreenshot(driver));
		agentLogOut(admin);				
		agentLogOut(agent1);
		agentLogOut(agent2);

	}
	
}
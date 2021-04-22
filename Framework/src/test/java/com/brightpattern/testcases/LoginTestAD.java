package com.brightpattern.testcases;

import java.util.Arrays;

import org.openqa.selenium.By;
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
		System.out.println(">>>>>>>>>>>>>>>>>> print serviceMetricsBefore <<<<<<<<<<<<<<<<<<");
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
		driver.findElement(By.xpath("//*[@id='b-navigation-item-supervisor']")).click(); //supervision panel activation
//		agentEndCall("admin");		
		wait(12000);
		System.out.println("Start getServicesMetrics after wait(12000) <<<<<<<<<<<<<<<<<<<");
		System.out.println(Helper.captureScreenshot(driver));
		serviceMetricsAfter = getServicesMetrics("Service A", 3);
		System.out.println(">>>>>>>>>>>>>>>>>> print serviceMetricsAfter <<<<<<<<<<<<<<<<<<");
		printOutMetrics(serviceMetricsAfter);
		
		agentLogOut(admin);				
		agentLogOut(agent1);
		agentLogOut(agent2);

	}
	
	@Test
	public void test_028_ServiceA_INTotalTalkTime() {
		serviceMetricNumber = 28;
//		String parseTimeExpectation(String strTime, int expectedSec)
		String strTime = serviceMetricsBefore[2][serviceMetricNumber];
		int expectedSec = 2;
		String expected = parseTimeExpectation(strTime, expectedSec);
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}	
	
	@Test
	public void test_036_ServiceA_INRouted() {
		serviceMetricNumber = 36;
// String parseStringExpectation(String metricValueBefore, int delta)
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		
		Assert.assertEquals(actual, expected);
	}	

	@Test
	public void test_043_ServiceA_INQueuedUnique() {
		serviceMetricNumber = 43;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void test_055_ServiceA_INinProgress() {
		serviceMetricNumber = 55;
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void test_058_ServiceA_INHandledUnique() {
		serviceMetricNumber = 58;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		Assert.assertEquals(actual, expected);
	}	
	
	@Test
	public void test_070_ServiceA_INAgentDisconnected() {
		serviceMetricNumber = 71;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void test_074_ServiceA_BusySvc() {
		serviceMetricNumber = 74;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void test_076_ServiceA_ACWCount() {
		serviceMetricNumber = 76;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}	
	
	@Test
	public void test_081_ServiceA_NotReady() {
		serviceMetricNumber = 81;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}	
	
	@Test
	public void test_082_ServiceA_LoggedIn() {
		serviceMetricNumber = 82;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void test_087_ServiceA_INReceived() {
		serviceMetricNumber = 87;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_088_ServiceA_INQueued() {
		serviceMetricNumber = 88;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_089_ServiceA_INHandled() {
		serviceMetricNumber = 89;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 2;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		Assert.assertEquals(actual, expected);
	}
	// ****************************************************************************************************************************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
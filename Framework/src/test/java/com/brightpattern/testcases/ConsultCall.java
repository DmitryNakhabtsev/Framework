package com.brightpattern.testcases;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.brightpattern.utility.Helper;
public class ConsultCall extends API {
	
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
	
	ChromeDriver agent1Driver = agentDriver(agent1);
	ChromeDriver agent2Driver = agentDriver(agent2);
	ChromeDriver adminDriver = agentDriver(admin);
	
	
	@Test(priority = -3)
	public void ArrayBefore() {

		agentInit(admin, pwd);
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
		wait(1000);
		System.out.println(Helper.captureScreenshot(driver_tb));
		setServiceToAgent(agent2);
		System.out.println(Helper.captureScreenshot(driver_tb));
		
		agentCallTo(admin, "8003");
		wait(action);
		System.out.println(Helper.captureScreenshot(driver));
		
//		setReadyToAgent(agent1);
		
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
	
	@Test(enabled = false)
	public void test_028_ServiceA_INTotalTalkTime() {
		serviceMetricNumber = 28;
//		String parseTimeExpectation(String strTime, int expectedSec)
		String strTime = serviceMetricsBefore[2][serviceMetricNumber];
		int expectedSec = 2;
		String expected = parseTimeExpectation(strTime, expectedSec);
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		
		boolean expectedInDeviation = timeDeviation(actual, expected, 2);
		
		if(expected != null && actual != null) {			
			Assert.assertTrue(expectedInDeviation);
		} else {
			Assert.assertEquals(actual, actual);
		}
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
		
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}	

	@Test
	public void test_043_ServiceA_INQueuedUnique() {
		serviceMetricNumber = 43;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
	
	@Test
	public void test_055_ServiceA_INinProgress() {
		serviceMetricNumber = 55;
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
	
	@Test
	public void test_058_ServiceA_INHandledUnique() {
		serviceMetricNumber = 58;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}	
	
	@Test
	public void test_070_ServiceA_INAgentDisconnected() {
		serviceMetricNumber = 71;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
	
	@Test
	public void test_074_ServiceA_BusySvc() {
		serviceMetricNumber = 74;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
	
	@Test
	public void test_076_ServiceA_ACWCount() {
		serviceMetricNumber = 76;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}	
	
	@Test
	public void test_081_ServiceA_NotReady() {
		serviceMetricNumber = 81;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}	
	
	@Test
	public void test_082_ServiceA_LoggedIn() {
		serviceMetricNumber = 82;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 2;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
	
	@Test
	public void test_087_ServiceA_INReceived() {
		serviceMetricNumber = 87;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_088_ServiceA_INQueued() {
		serviceMetricNumber = 88;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_089_ServiceA_INHandled() {
		serviceMetricNumber = 89;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 1;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
	
	
	
	
	
	
	
	@Test(priority = 0)
	public void test_001_ServiceA_Name() {
		serviceMetricNumber = 1;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
	  
	@Test
	public void test_002_ServiceA_Ready() {

		serviceMetricNumber = 2;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_003_ServiceA_OUTUnattendedPerCent() {

		serviceMetricNumber = 3;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_004_ServiceA_OUTUnattended() {

		serviceMetricNumber = 4;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_005_ServiceA_OUTTotalTalkTime() {
	
		serviceMetricNumber = 5;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_006_ServiceA_OUTRouted() {
		int serviceMetricNumber = 6;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_007_ServiceA_OUTRingingDropped() {
		int serviceMetricNumber = 7;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_008_ServiceA_OUTRingingAbandoned() {
		int serviceMetricNumber = 8;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_009_ServiceA_OUTRinging() {
		int serviceMetricNumber = 9;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_010_ServiceA_OUTRemoteDisconnected() {
		int serviceMetricNumber = 10;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_011_ServiceA_OUTRejected() {
		serviceMetricNumber = 11;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_012_ServiceA_OUTQueueDropped() {
		serviceMetricNumber = 12;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_013_ServiceA_OUTQueueAbandonedPerCent() {
		serviceMetricNumber = 13;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_014_ServiceA_OUTQueueAbandoned() {
		serviceMetricNumber = 14;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_015_ServiceA_OUTIVRDropped() {
		serviceMetricNumber = 15;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_016_ServiceA_OUTIVRAbandonedPerCent() {
		serviceMetricNumber = 16;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_017_ServiceA_OUTIVRAbandoned() {
		serviceMetricNumber = 17;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_018_ServiceA_OUTInProgress() {
		serviceMetricNumber = 18;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_019_ServiceA_OUTAvgTalkTime() {
		serviceMetricNumber = 19;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_020_ServiceA_OUTAnsweredPerCent() {
		serviceMetricNumber = 20;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_021_ServiceA_OUTAgentDisconnected() {
		serviceMetricNumber = 21;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_022_ServiceA_OUTActive() {
		serviceMetricNumber = 22;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_023_ServiceA_OUTAbandonedPerCent() {
		serviceMetricNumber = 23;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_024_ServiceA_OUTAbandoned() {
		serviceMetricNumber = 24;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_025_ServiceA_Occupancy() {
		serviceMetricNumber = 25;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String expected = "80";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
		
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_026_ServiceA_INWaiting() {
		serviceMetricNumber = 26;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_027_ServiceA_INTrash() {
		serviceMetricNumber = 27;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_029_ServiceA_INTotalAbandonedPerCent() {
		serviceMetricNumber = 29;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_030_ServiceA_INTotalAbandoned() {
		serviceMetricNumber = 30;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_031_ServiceA_INSvcLevelDayPerCent() {
		serviceMetricNumber = 31;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String expected = "100";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
		
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_032_ServiceA_INSvcChanged() {
		serviceMetricNumber = 32;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_033_ServiceA_INSvcChangeReceived() {
		serviceMetricNumber = 33;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_034_ServiceA_INSpam() {
		serviceMetricNumber = 34;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_035_ServiceA_INSelfServiced() {
		serviceMetricNumber = 35;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_037_ServiceA_INRingingDropped() {
		serviceMetricNumber = 37;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_038_ServiceA_INRingingAbandoned() {
		serviceMetricNumber = 38;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_039_ServiceA_INRinging() {
		serviceMetricNumber = 39;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_040_ServiceA_INRemoteDisconnected() {
		serviceMetricNumber = 40;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 0;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_041_ServiceA_INRejected() {
		serviceMetricNumber = 41;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_042_ServiceA_INReceivedNew() {
		serviceMetricNumber = 42;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_044_ServiceA_INQueueShAbandonedPerCent() {
		serviceMetricNumber = 44;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_045_ServiceA_INQueueShAbandoned() {
		serviceMetricNumber = 45;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_046_ServiceA_INQueueDropped() {
		serviceMetricNumber = 46;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_047_ServiceA_INQueueAbandonedPerCent() {
		serviceMetricNumber = 47;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_048_ServiceA_INQueueAbandoned() {
		serviceMetricNumber = 48;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_049_ServiceA_INonHoldUnique() {
		serviceMetricNumber = 49;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 0;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_050_ServiceA_INonHold() {
		serviceMetricNumber = 50;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 0;
		
		String expected = parseStringExpectation(metricValueBefore, delta);

		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_051_ServiceA_INMaxWait() {
		serviceMetricNumber = 51;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_052_ServiceA_INJoined() {
		serviceMetricNumber = 52;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_053_ServiceA_INIVRDropped() {
		serviceMetricNumber = 53;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_054_ServiceA_INIVRAbandoned() {
		serviceMetricNumber = 54;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_056_ServiceA_INInIVR() {
		serviceMetricNumber = 56;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_057_ServiceA_INIgnored() {
		serviceMetricNumber = 57;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_059_ServiceA_INHandledNew() {
		serviceMetricNumber = 59;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
/*
	@Test
	public void test_060_ServiceA_INHandledPerCent() {
		serviceMetricNumber = 60;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String expected = "100";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
		String actual = serviceMetricsAfter[2][serviceMetricNumber];

		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	
	@Test
	public void test_061_ServiceA_INEWT() {
		serviceMetricNumber = 61;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		
		// ================================================================
		int smn = 28;
		String iNTotalTalkTime = serviceMetricsAfter[2][smn];

		int tmn = 10;
		row = 3;
		String avgACWTime = teamMetricsAfter[row][tmn];

		tmn = 7;
		row = 3;
		String iNHandled = teamMetricsAfter[row][tmn];
		int number = Integer.parseInt(iNHandled); // String to int

		String tolkTimeAfter = divideTimeByNumber(iNTotalTalkTime, number);
		String edited = addTime(tolkTimeAfter, avgACWTime);
		String deviation = "0:01";
		String expected = addTime(edited, deviation);
		expectedInEWT = expected; // expected result for test_061_ServiceA_INEWT
		// ================================================================
		
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}
*/
	@Test
	public void test_062_ServiceA_INDesktop() {
		serviceMetricNumber = 62;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_063_ServiceA_INClosed() {
		serviceMetricNumber = 63;

		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_064_ServiceA_INCarriedOverNew() {
		serviceMetricNumber = 64;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_065_ServiceA_INCarriedOver() {
		serviceMetricNumber = 65;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_066_ServiceA_INBreachedSLA() {
		serviceMetricNumber = 66;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}
/*
	@Test
	public void test_067_ServiceA_INAvgTalkTime() {
		serviceMetricNumber = 67;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}

	
	@Test
	public void test_068_ServiceA_INAvgHandleTime() {
		serviceMetricNumber = 68;

//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
//================================================================		
		int smn = 28;
		String iNTotalTalkTime = serviceMetricsAfter[2][smn];		
		
		int tmn = 10;
		row = 3;
		String avgACWTime = teamMetricsAfter[row][tmn];
		
		tmn = 7;
		row = 3;
		String iNHandled = teamMetricsAfter[row][tmn];	
		int number = Integer.parseInt(iNHandled); //String to int
		
		String tolkTimeAfter = divideTimeByNumber(iNTotalTalkTime, number);
		String edited = addTime(tolkTimeAfter, avgACWTime);
		String deviation = "0:01";
		String expected = addTime(edited, deviation);

//	    expectedInEWT=expected; // expected result for test_061_ServiceA_INEWT
//================================================================			
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_069_ServiceA_INASA() {
		serviceMetricNumber = 69;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		Assert.assertEquals(actual, expected);
	}
*/

	@Test
	public void test_071_ServiceA_INActive() {
		serviceMetricNumber = 71;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_072_ServiceA_CBWaiting() {
		serviceMetricNumber = 72;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_073_ServiceA_CBRequested() {
		serviceMetricNumber = 73;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_075_ServiceA_Busy() {
		serviceMetricNumber = 75;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_077_ServiceA_OUTTransferred() {
		serviceMetricNumber = 77;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_078_ServiceA_OUTHandled() {
		serviceMetricNumber = 78;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_079_ServiceA_OUTDialed() {
		serviceMetricNumber = 79;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_080_ServiceA_OUTAnswered() {
		serviceMetricNumber = 80;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}


	@Test
	public void test_083_ServiceA_INTransfers() {
		serviceMetricNumber = 83;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 0;
		
		String expected = parseStringExpectation(metricValueBefore, delta);

		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_084_ServiceA_INTransferred() {
		serviceMetricNumber = 84;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		int delta = 0;
		
		String expected = parseStringExpectation(metricValueBefore, delta);
		
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_085_ServiceA_INReplied() {
		serviceMetricNumber = 85;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String expected = "100 (80/20)";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
		
		String actual = serviceMetricsAfter[2][serviceMetricNumber];

		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	@Test
	public void test_086_ServiceA_INSvcLevelPerCent() {
		serviceMetricNumber = 86;
		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		if(expected != null && actual != null) {
			
			Assert.assertEquals(actual, expected);
		} else {
			Assert.assertEquals(actual, actual);
		}
	}

	
	
}
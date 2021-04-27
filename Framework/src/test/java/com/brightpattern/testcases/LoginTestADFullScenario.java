package com.brightpattern.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.brightpattern.pages.BaseClass;
import com.brightpattern.pages.LoginPage;
import com.brightpattern.utility.BrowserFactory;
import com.brightpattern.utility.ExcelDataProvider;
import com.brightpattern.utility.Helper;


public class LoginTestADFullScenario extends API{
/*		
		private DimaAfter scenario = new DimaAfter();

		
		
		 public int test_025_ServiceA_Occupancy = 1;   				//java.lang.AssertionError: expected [52] but found [53]
		 public int test_028_ServiceA_INTotalTalkTime = 1;   		//java.lang.AssertionError: expected [08:09] but found [08:32] 
		 public int test_031_ServiceA_INSvcLevelDayPerCent = 5;    	//java.lang.AssertionError: expected [25] but found [30]
		 public int test_036_ServiceA_INRouted = 1;    				//java.lang.AssertionError: expected [14] but found [15]
		 public int test_040_ServiceA_INRemoteDisconnected = 1;    	//java.lang.AssertionError: expected [12] but found [13]
		 public int test_043_ServiceA_INQueuedUnique = 1;    		//java.lang.AssertionError: expected [12] but found [13]
		 public int test_049_ServiceA_INonHoldUnique = 1;    		//java.lang.AssertionError: expected [12] but found [13]
		 public int test_050_ServiceA_INonHold = 2;    				//java.lang.AssertionError: expected [22] but found [24]
		 public int test_058_ServiceA_INHandledUnique = 1;    		//java.lang.AssertionError: expected [12] but found [13]
		 public int test_061_ServiceA_INEWT = 1;    				//java.lang.AssertionError: expected [01:04] but found [01:03]
		 public int test_067_ServiceA_INAvgTalkTime = 1;    		//java.lang.AssertionError: expected [00:20] but found [00:19]
		 public int test_068_ServiceA_INAvgHandleTime = 1; 			//java.lang.AssertionError: expected [01:04] but found [01:03]   
		 public int test_069_ServiceA_INASA = 1;    				//java.lang.AssertionError: expected [00:22] but found [00:21]   
		 public int test_083_ServiceA_INTransfers = 1;    			//java.lang.AssertionError: expected [12] but found [13]
		 public int test_084_ServiceA_INTransferred = 1;    		//java.lang.AssertionError: expected [12] but found [13]
		 public int test_085_ServiceA_INReplied = 5;    			//java.lang.AssertionError: expected [25] but found [30]
		 public int test_087_ServiceA_INReceived = 1;    			//java.lang.AssertionError: expected [12] but found [13]
		 public int test_088_ServiceA_INQueued = 1;    				//java.lang.AssertionError: expected [12] but found [13]
		 public int test_089_ServiceA_INHandled = 2;    			//java.lang.AssertionError: expected [24] but found [26]
		 
		 int i = Integer.parseInt("50"); //String to int
		 String s = String.valueOf(i); //int to String
		 
			// getAgentsMetrics
			protected int agentMetricNumber;
			protected String expectedInEWT;
			protected static String[][] agentMetricsBefore;
			protected static String[][] agentMetricsAfter;

			//getTeamsMetrics
			protected int teamMetricNumber;
			protected static String[][] teamMetricsBefore;
			protected static String[][] teamMetricsAfter;
			protected int row = 3;
			
			//getServicesMetrics
			protected int serviceMetricNumber; //Service Metric index in array
			protected static String[][] serviceMetricsBefore;
			protected static String[][] serviceMetricsAfter;

		
		@Test(priority = -3)
		public void ArrayBefore() {

			agentInit("admin","password");
//			String[][] servicesMetrics = obj1.servicesMetrics89();
			
			serviceMetricsBefore = getServicesMetrics("Service A", 3);	
			agentMetricsBefore = getAgentsMetrics("admin", 1);	
			teamMetricsBefore = getTeamsMetrics("TeamDmitry");
			System.out.println(Helper.captureScreenshot(driver_aj));
			printOutMetrics(serviceMetricsBefore);
		
//			return serviceMetricsBefore;

		}
		
		@Test(priority = -2)
		public void ArrayAfter() {
			
			scenario.olgaInteraction(); // scenario execution
			wait(13000); // 13000 ms waiting time for supervision refreshing (refresh logout agents)
			System.out.println("started gathering after interaction 13 sec >> servicesMetricsAfter");
			System.out.println(Helper.captureScreenshot(driver));
//			String[][] servicesMetricsAfter = obj1.servicesMetrics89();	
			
			serviceMetricsAfter = getServicesMetrics("Service A", 3);
			agentMetricsAfter = getAgentsMetrics("admin", 1);
			teamMetricsAfter = getTeamsMetrics("TeamDmitry");
			
			agentLogOut("admin");
			
			printOutMetrics(serviceMetricsAfter);
//			printOutMetrics(agentMetricsAfter);
//			printOutMetrics(teamMetricsAfter);
			
//			return serviceMetricsAfter;

		}
		
		@Test(enabled = false, priority = -1)
		public void printMetrics() {
			for (int i = 1; i<=89; i++) {
				System.out.println(serviceMetricsBefore[2][i]);
			}
		
		}
		
//		@Test(priority = 0)
//		public void testSuite() {
//		new TestMetrics();
//		}
		
		@Test(priority = 0)
		public void test_001_ServiceA_Name() {
			serviceMetricNumber = 1;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];	
			Assert.assertEquals(actual, expected);
		}
		  
		@Test
		public void test_002_ServiceA_Ready() {
			wait(100);
			serviceMetricNumber = 2;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_003_ServiceA_OUTUnattendedPerCent() {
			wait(100);
			serviceMetricNumber = 3;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_004_ServiceA_OUTUnattended() {
			wait(100);
			serviceMetricNumber = 4;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_005_ServiceA_OUTTotalTalkTime() {
			wait(100);
			serviceMetricNumber = 5;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_006_ServiceA_OUTRouted() {
			serviceMetricNumber = 6;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_007_ServiceA_OUTRingingDropped() {
			serviceMetricNumber = 7;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_008_ServiceA_OUTRingingAbandoned() {
			serviceMetricNumber = 8;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_009_ServiceA_OUTRinging() {
			serviceMetricNumber = 9;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_010_ServiceA_OUTRemoteDisconnected() {
			serviceMetricNumber = 10;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_011_ServiceA_OUTRejected() {
			serviceMetricNumber = 11;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_012_ServiceA_OUTQueueDropped() {
			serviceMetricNumber = 12;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_013_ServiceA_OUTQueueAbandonedPerCent() {
			serviceMetricNumber = 13;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_014_ServiceA_OUTQueueAbandoned() {
			serviceMetricNumber = 14;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_015_ServiceA_OUTIVRDropped() {
			serviceMetricNumber = 15;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_016_ServiceA_OUTIVRAbandonedPerCent() {
			serviceMetricNumber = 16;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_017_ServiceA_OUTIVRAbandoned() {
			serviceMetricNumber = 17;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_018_ServiceA_OUTInProgress() {
			serviceMetricNumber = 18;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_019_ServiceA_OUTAvgTalkTime() {
			serviceMetricNumber = 19;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_020_ServiceA_OUTAnsweredPerCent() {
			serviceMetricNumber = 20;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_021_ServiceA_OUTAgentDisconnected() {
			serviceMetricNumber = 21;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_022_ServiceA_OUTActive() {
			serviceMetricNumber = 22;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_023_ServiceA_OUTAbandonedPerCent() {
			serviceMetricNumber = 23;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_024_ServiceA_OUTAbandoned() {
			serviceMetricNumber = 24;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_025_ServiceA_Occupancy() {
			serviceMetricNumber = 25;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String expected = "98";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_026_ServiceA_INWaiting() {
			serviceMetricNumber = 26;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_027_ServiceA_INTrash() {
			serviceMetricNumber = 27;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_028_ServiceA_INTotalTalkTime() {
			serviceMetricNumber = 28;
//			String parseTimeExpectation(String strTime, int expectedSec)
			String strTime = serviceMetricsBefore[2][serviceMetricNumber];
			int expectedSec = 34;
			String expected = parseTimeExpectation(strTime, expectedSec);
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_029_ServiceA_INTotalAbandonedPerCent() {
			serviceMetricNumber = 29;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_030_ServiceA_INTotalAbandoned() {
			serviceMetricNumber = 30;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_031_ServiceA_INSvcLevelDayPerCent() {
			serviceMetricNumber = 31;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String expected = "100";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_032_ServiceA_INSvcChanged() {
			serviceMetricNumber = 32;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_033_ServiceA_INSvcChangeReceived() {
			serviceMetricNumber = 33;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_034_ServiceA_INSpam() {
			serviceMetricNumber = 34;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_035_ServiceA_INSelfServiced() {
			serviceMetricNumber = 35;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_036_ServiceA_INRouted() {
			serviceMetricNumber = 36;
	// String parseStringExpectation(String metricValueBefore, int delta)
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_037_ServiceA_INRingingDropped() {
			serviceMetricNumber = 37;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_038_ServiceA_INRingingAbandoned() {
			serviceMetricNumber = 38;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_039_ServiceA_INRinging() {
			serviceMetricNumber = 39;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_040_ServiceA_INRemoteDisconnected() {
			serviceMetricNumber = 40;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_041_ServiceA_INRejected() {
			serviceMetricNumber = 41;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_042_ServiceA_INReceivedNew() {
			serviceMetricNumber = 42;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_043_ServiceA_INQueuedUnique() {
			serviceMetricNumber = 43;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_044_ServiceA_INQueueShAbandonedPerCent() {
			serviceMetricNumber = 44;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_045_ServiceA_INQueueShAbandoned() {
			serviceMetricNumber = 45;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_046_ServiceA_INQueueDropped() {
			serviceMetricNumber = 46;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_047_ServiceA_INQueueAbandonedPerCent() {
			serviceMetricNumber = 47;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_048_ServiceA_INQueueAbandoned() {
			serviceMetricNumber = 48;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_049_ServiceA_INonHoldUnique() {
			serviceMetricNumber = 49;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_050_ServiceA_INonHold() {
			serviceMetricNumber = 50;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 2;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_051_ServiceA_INMaxWait() {
			serviceMetricNumber = 51;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_052_ServiceA_INJoined() {
			serviceMetricNumber = 52;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_053_ServiceA_INIVRDropped() {
			serviceMetricNumber = 53;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_054_ServiceA_INIVRAbandoned() {
			serviceMetricNumber = 54;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_055_ServiceA_INinProgress() {
			serviceMetricNumber = 55;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_056_ServiceA_INInIVR() {
			serviceMetricNumber = 56;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_057_ServiceA_INIgnored() {
			serviceMetricNumber = 57;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_058_ServiceA_INHandledUnique() {
			serviceMetricNumber = 58;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_059_ServiceA_INHandledNew() {
			serviceMetricNumber = 59;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_060_ServiceA_INHandledPerCent() {
			serviceMetricNumber = 60;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String expected = "52";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_061_ServiceA_INEWT() {
			serviceMetricNumber = 61;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			
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

		@Test
		public void test_062_ServiceA_INDesktop() {
			serviceMetricNumber = 62;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_063_ServiceA_INClosed() {
			serviceMetricNumber = 63;

			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];

			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_064_ServiceA_INCarriedOverNew() {
			serviceMetricNumber = 64;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_065_ServiceA_INCarriedOver() {
			serviceMetricNumber = 65;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_066_ServiceA_INBreachedSLA() {
			serviceMetricNumber = 66;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

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

//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
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

//		    expectedInEWT=expected; // expected result for test_061_ServiceA_INEWT
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

		@Test
		public void test_070_ServiceA_INAgentDisconnected() {
			serviceMetricNumber = 71;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_071_ServiceA_INActive() {
			serviceMetricNumber = 71;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_072_ServiceA_CBWaiting() {
			serviceMetricNumber = 72;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_073_ServiceA_CBRequested() {
			serviceMetricNumber = 73;
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
		public void test_075_ServiceA_Busy() {
			serviceMetricNumber = 75;
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
		public void test_077_ServiceA_OUTTransferred() {
			serviceMetricNumber = 77;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_078_ServiceA_OUTHandled() {
			serviceMetricNumber = 78;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_079_ServiceA_OUTDialed() {
			serviceMetricNumber = 79;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_080_ServiceA_OUTAnswered() {
			serviceMetricNumber = 80;
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
		public void test_083_ServiceA_INTransfers() {
			serviceMetricNumber = 83;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_084_ServiceA_INTransferred() {
			serviceMetricNumber = 84;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_085_ServiceA_INReplied() {
			serviceMetricNumber = 85;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String expected = "100 (80/20)";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
			
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_086_ServiceA_INSvcLevelPerCent() {
			serviceMetricNumber = 86;
			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_087_ServiceA_INReceived() {
			serviceMetricNumber = 87;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_088_ServiceA_INQueued() {
			serviceMetricNumber = 88;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 1;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}

		@Test
		public void test_089_ServiceA_INHandled() {
			serviceMetricNumber = 89;
//			String expected = serviceMetricsBefore[2][serviceMetricNumber];
			String metricValueBefore = serviceMetricsBefore[2][serviceMetricNumber];
			String actual = serviceMetricsAfter[2][serviceMetricNumber];
			int delta = 2;
			
			String expected = parseStringExpectation(metricValueBefore, delta);
			Assert.assertEquals(actual, expected);
		}
		// ****************************************************************************************************************************

		@Test(enabled = false)
		public void test_101_CustomerServiceChat_Name() {
			serviceMetricNumber = 1;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_102_CustomerServiceChat_Ready() {
			serviceMetricNumber = 2;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_103_CustomerServiceChat_OUTUnattendedPerCent() {
			serviceMetricNumber = 3;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_104_CustomerServiceChat_OUTUnattended() {
			serviceMetricNumber = 4;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_105_CustomerServiceChat_OUTTotalTalkTime() {
			serviceMetricNumber = 5;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_106_CustomerServiceChat_OUTRouted() {
			serviceMetricNumber = 6;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_107_CustomerServiceChat_OUTRingingDropped() {
			serviceMetricNumber = 7;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_108_CustomerServiceChat_OUTRingingAbandoned() {
			serviceMetricNumber = 8;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_109_CustomerServiceChat_OUTRinging() {
			serviceMetricNumber = 9;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_110_CustomerServiceChat_OUTRemoteDisconnected() {
			serviceMetricNumber = 10;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_111_CustomerServiceChat_OUTRejected() {
			serviceMetricNumber = 11;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_112_CustomerServiceChat_OUTQueueDropped() {
			serviceMetricNumber = 12;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_113_CustomerServiceChat_OUTQueueAbandonedPerCent() {
			serviceMetricNumber = 13;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_114_CustomerServiceChat_OUTQueueAbandoned() {
			serviceMetricNumber = 14;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_115_CustomerServiceChat_OUTIVRDropped() {
			serviceMetricNumber = 15;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_116_CustomerServiceChat_OUTIVRAbandonedPerCent() {
			serviceMetricNumber = 16;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_117_CustomerServiceChat_OUTIVRAbandoned() {
			serviceMetricNumber = 17;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_118_CustomerServiceChat_OUTInProgress() {
			serviceMetricNumber = 18;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_119_CustomerServiceChat_OUTAvgTalkTime() {
			serviceMetricNumber = 19;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_120_CustomerServiceChat_OUTAnsweredPerCent() {
			serviceMetricNumber = 20;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_121_CustomerServiceChat_OUTAgentDisconnected() {
			serviceMetricNumber = 21;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_122_CustomerServiceChat_OUTActive() {
			serviceMetricNumber = 22;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_123_CustomerServiceChat_OUTAbandonedPerCent() {
			serviceMetricNumber = 23;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_124_CustomerServiceChat_OUTAbandoned() {
			serviceMetricNumber = 24;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_125_CustomerServiceChat_Occupancy() {
			serviceMetricNumber = 25;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_126_CustomerServiceChat_INWaiting() {
			serviceMetricNumber = 26;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_127_CustomerServiceChat_INTrash() {
			serviceMetricNumber = 27;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_128_CustomerServiceChat_INTotalTalkTime() {
			serviceMetricNumber = 28;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_129_CustomerServiceChat_INTotalAbandonedPerCent() {
			serviceMetricNumber = 29;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_130_CustomerServiceChat_INTotalAbandoned() {
			serviceMetricNumber = 30;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_131_CustomerServiceChat_INSvcLevelDayPerCent() {
			serviceMetricNumber = 31;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_132_CustomerServiceChat_INSvcChanged() {
			serviceMetricNumber = 32;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_133_CustomerServiceChat_INSvcChangeReceived() {
			serviceMetricNumber = 33;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_134_CustomerServiceChat_INSpam() {
			serviceMetricNumber = 34;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_135_CustomerServiceChat_INSelfServiced() {
			serviceMetricNumber = 35;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_136_CustomerServiceChat_INRouted() {
			serviceMetricNumber = 36;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_137_CustomerServiceChat_INRingingDropped() {
			serviceMetricNumber = 37;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_138_CustomerServiceChat_INRingingAbandoned() {
			serviceMetricNumber = 38;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_139_CustomerServiceChat_INRinging() {
			serviceMetricNumber = 39;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_140_CustomerServiceChat_INRemoteDisconnected() {
			serviceMetricNumber = 40;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_141_CustomerServiceChat_INRejected() {
			serviceMetricNumber = 41;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_142_CustomerServiceChat_INReceivedNew() {
			serviceMetricNumber = 42;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_143_CustomerServiceChat_INQueuedUnique() {
			serviceMetricNumber = 43;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_144_CustomerServiceChat_INQueueShAbandonedPerCent() {
			serviceMetricNumber = 44;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_145_CustomerServiceChat_INQueueShAbandoned() {
			serviceMetricNumber = 45;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_146_CustomerServiceChat_INQueueDropped() {
			serviceMetricNumber = 46;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_147_CustomerServiceChat_INQueueAbandonedPerCent() {
			serviceMetricNumber = 47;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_148_CustomerServiceChat_INQueueAbandoned() {
			serviceMetricNumber = 48;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_149_CustomerServiceChat_INonHoldUnique() {
			serviceMetricNumber = 49;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_150_CustomerServiceChat_INonHold() {
			serviceMetricNumber = 50;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_151_CustomerServiceChat_INMaxWait() {
			serviceMetricNumber = 51;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_152_CustomerServiceChat_INJoined() {
			serviceMetricNumber = 52;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_153_CustomerServiceChat_INIVRDropped() {
			serviceMetricNumber = 53;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_154_CustomerServiceChat_INIVRAbandoned() {
			serviceMetricNumber = 54;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_155_CustomerServiceChat_INinProgress() {
			serviceMetricNumber = 55;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_156_CustomerServiceChat_INInIVR() {
			serviceMetricNumber = 56;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_157_CustomerServiceChat_INIgnored() {
			serviceMetricNumber = 57;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_158_CustomerServiceChat_INHandledUnique() {
			serviceMetricNumber = 58;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_159_CustomerServiceChat_INHandledNew() {
			serviceMetricNumber = 59;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_160_CustomerServiceChat_INHandledPerCent() {
			serviceMetricNumber = 60;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_161_CustomerServiceChat_INEWT() {
			serviceMetricNumber = 61;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_162_CustomerServiceChat_INDesktop() {
			serviceMetricNumber = 62;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_163_CustomerServiceChat_INClosed() {
			serviceMetricNumber = 63;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_164_CustomerServiceChat_INCarriedOverNew() {
			serviceMetricNumber = 64;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_165_CustomerServiceChat_INCarriedOver() {
			serviceMetricNumber = 65;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_166_CustomerServiceChat_INBreachedSLA() {
			serviceMetricNumber = 66;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_167_CustomerServiceChat_INAvgTalkTime() {
			serviceMetricNumber = 67;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_168_CustomerServiceChat_INAvgHandleTime() {
			serviceMetricNumber = 68;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_169_CustomerServiceChat_INASA() {
			serviceMetricNumber = 69;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_170_CustomerServiceChat_INAgentDisconnected() {
			serviceMetricNumber = 71;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_171_CustomerServiceChat_INActive() {
			serviceMetricNumber = 71;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_172_CustomerServiceChat_CBWaiting() {
			serviceMetricNumber = 72;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_173_CustomerServiceChat_CBRequested() {
			serviceMetricNumber = 73;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_174_CustomerServiceChat_BusySvc() {
			serviceMetricNumber = 74;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_175_CustomerServiceChat_Busy() {
			serviceMetricNumber = 75;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_176_CustomerServiceChat_ACWCount() {
			serviceMetricNumber = 76;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_177_CustomerServiceChat_OUTTransferred() {
			serviceMetricNumber = 77;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_178_CustomerServiceChat_OUTHandled() {
			serviceMetricNumber = 78;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_179_CustomerServiceChat_OUTDialed() {
			serviceMetricNumber = 79;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_180_CustomerServiceChat_OUTAnswered() {
			serviceMetricNumber = 80;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_181_CustomerServiceChat_NotReady() {
			serviceMetricNumber = 81;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_182_CustomerServiceChat_LoggedIn() {
			serviceMetricNumber = 82;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_183_CustomerServiceChat_INTransfers() {
			serviceMetricNumber = 83;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_184_CustomerServiceChat_INTransferred() {
			serviceMetricNumber = 84;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_185_CustomerServiceChat_INReplied() {
			serviceMetricNumber = 85;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_186_CustomerServiceChat_INSvcLevelPerCent() {
			serviceMetricNumber = 86;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_187_CustomerServiceChat_INReceived() {
			serviceMetricNumber = 87;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_188_CustomerServiceChat_INQueued() {
			serviceMetricNumber = 88;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_189_CustomerServiceChat_INHandled() {
			serviceMetricNumber = 89;
			String expected = serviceMetricsBefore[1][serviceMetricNumber];
			String actual = serviceMetricsAfter[1][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}
		// ****************************************************************************************************************************

		@Test(enabled = false)
		public void test_201_ServiceZen_Name() {
			serviceMetricNumber = 1;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_202_ServiceZen_Ready() {
			serviceMetricNumber = 2;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_203_ServiceZen_OUTUnattendedPerCent() {
			serviceMetricNumber = 3;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_204_ServiceZen_OUTUnattended() {
			serviceMetricNumber = 4;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_205_ServiceZen_OUTTotalTalkTime() {
			serviceMetricNumber = 5;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_206_ServiceZen_OUTRouted() {
			serviceMetricNumber = 6;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_207_ServiceZen_OUTRingingDropped() {
			serviceMetricNumber = 7;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_208_ServiceZen_OUTRingingAbandoned() {
			serviceMetricNumber = 8;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_209_ServiceZen_OUTRinging() {
			serviceMetricNumber = 9;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_210_ServiceZen_OUTRemoteDisconnected() {
			serviceMetricNumber = 10;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_211_ServiceZen_OUTRejected() {
			serviceMetricNumber = 11;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_212_ServiceZen_OUTQueueDropped() {
			serviceMetricNumber = 12;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_213_ServiceZen_OUTQueueAbandonedPerCent() {
			serviceMetricNumber = 13;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_214_ServiceZen_OUTQueueAbandoned() {
			serviceMetricNumber = 14;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_215_ServiceZen_OUTIVRDropped() {
			serviceMetricNumber = 15;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_216_ServiceZen_OUTIVRAbandonedPerCent() {
			serviceMetricNumber = 16;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_217_ServiceZen_OUTIVRAbandoned() {
			serviceMetricNumber = 17;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_218_ServiceZen_OUTInProgress() {
			serviceMetricNumber = 18;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_219_ServiceZen_OUTAvgTalkTime() {
			serviceMetricNumber = 19;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_220_ServiceZen_OUTAnsweredPerCent() {
			serviceMetricNumber = 20;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_221_ServiceZen_OUTAgentDisconnected() {
			serviceMetricNumber = 21;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_222_ServiceZen_OUTActive() {
			serviceMetricNumber = 22;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_223_ServiceZen_OUTAbandonedPerCent() {
			serviceMetricNumber = 23;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_224_ServiceZen_OUTAbandoned() {
			serviceMetricNumber = 24;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_225_ServiceZen_Occupancy() {
			serviceMetricNumber = 25;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_226_ServiceZen_INWaiting() {
			serviceMetricNumber = 26;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_227_ServiceZen_INTrash() {
			serviceMetricNumber = 27;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_228_ServiceZen_INTotalTalkTime() {
			serviceMetricNumber = 28;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_229_ServiceZen_INTotalAbandonedPerCent() {
			serviceMetricNumber = 29;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_230_ServiceZen_INTotalAbandoned() {
			serviceMetricNumber = 30;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_231_ServiceZen_INSvcLevelDayPerCent() {
			serviceMetricNumber = 31;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_232_ServiceZen_INSvcChanged() {
			serviceMetricNumber = 32;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_233_ServiceZen_INSvcChangeReceived() {
			serviceMetricNumber = 33;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_234_ServiceZen_INSpam() {
			serviceMetricNumber = 34;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_235_ServiceZen_INSelfServiced() {
			serviceMetricNumber = 35;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_236_ServiceZen_INRouted() {
			serviceMetricNumber = 36;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_237_ServiceZen_INRingingDropped() {
			serviceMetricNumber = 37;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_238_ServiceZen_INRingingAbandoned() {
			serviceMetricNumber = 38;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_239_ServiceZen_INRinging() {
			serviceMetricNumber = 39;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_240_ServiceZen_INRemoteDisconnected() {
			serviceMetricNumber = 40;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_241_ServiceZen_INRejected() {
			serviceMetricNumber = 41;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_242_ServiceZen_INReceivedNew() {
			serviceMetricNumber = 42;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_243_ServiceZen_INQueuedUnique() {
			serviceMetricNumber = 43;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_244_ServiceZen_INQueueShAbandonedPerCent() {
			serviceMetricNumber = 44;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_245_ServiceZen_INQueueShAbandoned() {
			serviceMetricNumber = 45;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_246_ServiceZen_INQueueDropped() {
			serviceMetricNumber = 46;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_247_ServiceZen_INQueueAbandonedPerCent() {
			serviceMetricNumber = 47;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_248_ServiceZen_INQueueAbandoned() {
			serviceMetricNumber = 48;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_249_ServiceZen_INonHoldUnique() {
			serviceMetricNumber = 49;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_250_ServiceZen_INonHold() {
			serviceMetricNumber = 50;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_251_ServiceZen_INMaxWait() {
			serviceMetricNumber = 51;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_252_ServiceZen_INJoined() {
			serviceMetricNumber = 52;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_253_ServiceZen_INIVRDropped() {
			serviceMetricNumber = 53;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_254_ServiceZen_INIVRAbandoned() {
			serviceMetricNumber = 54;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_255_ServiceZen_INinProgress() {
			serviceMetricNumber = 55;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_256_ServiceZen_INInIVR() {
			serviceMetricNumber = 56;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_257_ServiceZen_INIgnored() {
			serviceMetricNumber = 57;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_258_ServiceZen_INHandledUnique() {
			serviceMetricNumber = 58;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_259_ServiceZen_INHandledNew() {
			serviceMetricNumber = 59;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_260_ServiceZen_INHandledPerCent() {
			serviceMetricNumber = 60;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_261_ServiceZen_INEWT() {
			serviceMetricNumber = 61;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_262_ServiceZen_INDesktop() {
			serviceMetricNumber = 62;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_263_ServiceZen_INClosed() {
			serviceMetricNumber = 63;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_264_ServiceZen_INCarriedOverNew() {
			serviceMetricNumber = 64;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_265_ServiceZen_INCarriedOver() {
			serviceMetricNumber = 65;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_266_ServiceZen_INBreachedSLA() {
			serviceMetricNumber = 66;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_267_ServiceZen_INAvgTalkTime() {
			serviceMetricNumber = 67;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_268_ServiceZen_INAvgHandleTime() {
			serviceMetricNumber = 68;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_269_ServiceZen_INASA() {
			serviceMetricNumber = 69;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_270_ServiceZen_INAgentDisconnected() {
			serviceMetricNumber = 71;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_271_ServiceZen_INActive() {
			serviceMetricNumber = 71;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_272_ServiceZen_CBWaiting() {
			serviceMetricNumber = 72;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_273_ServiceZen_CBRequested() {
			serviceMetricNumber = 73;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_274_ServiceZen_BusySvc() {
			serviceMetricNumber = 74;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_275_ServiceZen_Busy() {
			serviceMetricNumber = 75;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_276_ServiceZen_ACWCount() {
			serviceMetricNumber = 76;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_277_ServiceZen_OUTTransferred() {
			serviceMetricNumber = 77;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_278_ServiceZen_OUTHandled() {
			serviceMetricNumber = 78;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_279_ServiceZen_OUTDialed() {
			serviceMetricNumber = 79;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_280_ServiceZen_OUTAnswered() {
			serviceMetricNumber = 80;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_281_ServiceZen_NotReady() {
			serviceMetricNumber = 81;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_282_ServiceZen_LoggedIn() {
			serviceMetricNumber = 82;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_283_ServiceZen_INTransfers() {
			serviceMetricNumber = 83;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_284_ServiceZen_INTransferred() {
			serviceMetricNumber = 84;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_285_ServiceZen_INReplied() {
			serviceMetricNumber = 85;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_286_ServiceZen_INSvcLevelPerCent() {
			serviceMetricNumber = 86;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_287_ServiceZen_INReceived() {
			serviceMetricNumber = 87;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_288_ServiceZen_INQueued() {
			serviceMetricNumber = 88;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_289_ServiceZen_INHandled() {

			serviceMetricNumber = 89;
			String expected = serviceMetricsBefore[3][serviceMetricNumber];
			String actual = serviceMetricsAfter[3][serviceMetricNumber];
			Assert.assertEquals(actual, expected);
		}
		  
		  //****************************************************************************************************************************
		
		@Test(enabled = false)
		public void test_004_AgentMetrics_Name() {
			agentMetricNumber = 4;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_005_AgentMetrics_TimeINState() {
			agentMetricNumber = 5;
			String expected = addTime(agentMetricsBefore[1][agentMetricNumber], "1:43");
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_006_AgentMetrics_Talk() {
			agentMetricNumber = 6;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_007_AgentMetrics_Survey2() {
			agentMetricNumber = 7;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_008_AgentMetrics_Survey1() {
			agentMetricNumber = 8;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_009_AgentMetrics_SkippedPerCent() {
			agentMetricNumber = 9;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_010_AgentMetrics_Skipped() {
			agentMetricNumber = 10;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_011_AgentMetrics_Service() {
			agentMetricNumber = 11;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_012_AgentMetrics_Sentiment() {
			agentMetricNumber = 12;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_013_AgentMetrics_Rec() {
			agentMetricNumber = 13;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_014_AgentMetrics_ReadyTime() {
			agentMetricNumber = 14;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_015_AgentMetrics_Previewed() {
			agentMetricNumber = 15;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_016_AgentMetrics_PreviewDuration() {
			agentMetricNumber = 16;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_017_AgentMetrics_OUTTransferred() {
			agentMetricNumber = 17;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_018_AgentMetrics_OUTRemoteDisconnected() {
			agentMetricNumber = 18;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_019_AgentMetrics_OUTRejected() {
			agentMetricNumber = 19;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_020_AgentMetrics_OUTHandled() {
			agentMetricNumber = 20;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_021_AgentMetrics_OUTDesktop() {
			agentMetricNumber = 21;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_022_AgentMetrics_OUTAgentDisconnected() {
			agentMetricNumber = 22;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_023_AgentMetrics_Occupancy() {
			agentMetricNumber = 23;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_024_AgentMetrics_NPS() {
			agentMetricNumber = 24;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_025_AgentMetrics_ListsPARemaining() {
			agentMetricNumber = 25;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_026_AgentMetrics_ListsPACompleted() {
			agentMetricNumber = 26;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_027_AgentMetrics_Interaction() {
			agentMetricNumber = 27;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_028_AgentMetrics_INTransfers() {
			agentMetricNumber = 28;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_029_AgentMetrics_INTransferred() {
			agentMetricNumber = 29;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_030_AgentMetrics_INTotalTalkTime() {
			agentMetricNumber = 30;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_031_AgentMetrics_INSvcChanged() {
			agentMetricNumber = 31;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_032_AgentMetrics_INReplied() {
			agentMetricNumber = 32;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_033_AgentMetrics_INRejected() {
			agentMetricNumber = 33;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_034_AgentMetrics_INPulled() {
			agentMetricNumber = 34;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_035_AgentMetrics_INonHoldUnique() {
			agentMetricNumber = 35;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_036_AgentMetrics_INonHold() {
			agentMetricNumber = 36;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_037_AgentMetrics_INOffered() {
			agentMetricNumber = 37;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_038_AgentMetrics_INJoined() {
			agentMetricNumber = 38;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_039_AgentMetrics_INIgnored() {
			agentMetricNumber = 39;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_040_AgentMetrics_INHandledUnique() {
			agentMetricNumber = 40;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_041_AgentMetrics_INHandledNew() {
			agentMetricNumber = 41;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_042_AgentMetrics_INHandled() {
			agentMetricNumber = 42;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_043_AgentMetrics_INDesktop() {
			agentMetricNumber = 43;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_044_AgentMetrics_INClosed() {
			agentMetricNumber = 44;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_045_AgentMetrics_INCarriedOverNew() {
			agentMetricNumber = 45;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_046_AgentMetrics_INCarriedOver() {
			agentMetricNumber = 46;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_047_AgentMetrics_INBreachedSLA() {
			agentMetricNumber = 47;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_048_AgentMetrics_INAvgTalkTime() {
			agentMetricNumber = 48;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_049_AgentMetrics_INAvgHandleTime() {
			agentMetricNumber = 49;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_050_AgentMetrics_INActive() {
			agentMetricNumber = 50;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_051_AgentMetrics_IdleTime() {
			agentMetricNumber = 51;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_052_AgentMetrics_Hold() {
			agentMetricNumber = 52;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_053_AgentMetrics_FCR() {
			agentMetricNumber = 53;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_054_AgentMetrics_CSAT() {
			agentMetricNumber = 54;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_055_AgentMetrics_CALReminders() {
			agentMetricNumber = 55;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_056_AgentMetrics_CALOverdue() {
			agentMetricNumber = 56;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_057_AgentMetrics_BusyTime() {
			agentMetricNumber = 57;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_058_AgentMetrics_BT() {
			agentMetricNumber = 58;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_059_AgentMetrics_AvgPreviewTime() {
			agentMetricNumber = 59;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_060_AgentMetrics_AvgIdleTime() {
			agentMetricNumber = 60;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_061_AgentMetrics_AvgACWTime() {
			agentMetricNumber = 61;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_062_AgentMetrics_AgentState() {
			agentMetricNumber = 62;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_063_AgentMetrics_AgentLogINtime() {
			agentMetricNumber = 4;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_064_AgentMetrics_ACWTime() {
		}

		@Test(enabled = false)
		public void test_065_AgentMetrics_Active() {
			agentMetricNumber = 65;
			String expected = agentMetricsBefore[1][agentMetricNumber];
			String actual = agentMetricsAfter[1][agentMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		//============================================================================================================
		

		@Test(enabled = false)
		public void test_001_TeamMetrics_Name() {
			teamMetricNumber = 1;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_002_TeamMetrics_Ready() {
			teamMetricNumber = 2;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_003_TeamMetrics_Occupancy() {
			teamMetricNumber = 3;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_004_TeamMetrics_NotReady() {
			teamMetricNumber = 4;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_005_TeamMetrics_LoggedIn() {
			teamMetricNumber = 5;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_006_TeamMetrics_INHandledUnique() {
			teamMetricNumber = 6;
			int delta = 2;
			String expectedBefore = teamMetricsBefore[row][teamMetricNumber];
			String expected = parseStringExpectation(expectedBefore, delta);
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_007_TeamMetrics_INHandled() {
			teamMetricNumber = 7;
			int delta = 2;
			String expectedBefore = teamMetricsBefore[row][teamMetricNumber];
			String expected = parseStringExpectation(expectedBefore, delta);
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_008_TeamMetrics_INAvgHandleTime() {
			teamMetricNumber = 8;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_009_TeamMetrics_Busy() {
			teamMetricNumber = 9;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_010_TeamMetrics_AvgACWTime() {
			teamMetricNumber = 10;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}

		@Test(enabled = false)
		public void test_011_TeamMetrics_ACWCount() {
			teamMetricNumber = 11;
			String expected = teamMetricsBefore[row][teamMetricNumber];
			String actual = teamMetricsAfter[row][teamMetricNumber];
			Assert.assertEquals(actual, expected);
		}
		
		
		//*****************************************************************************


	
*/
}

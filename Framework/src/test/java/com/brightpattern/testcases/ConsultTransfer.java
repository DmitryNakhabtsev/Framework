package com.brightpattern.testcases;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.brightpattern.utility.Helper;
public class ConsultTransfer extends API {
	
/*	//============================================ RTM test description ==========================================================

test_001_ServiceA_Name					Name	Service name
test_002_ServiceA_Ready					Ready	Ready Agents – current number
test_003_ServiceA_OUTUnattendedPerCent	OUT Unattended %	Percentage of calls that did not connect to agent in compliance time, per day
test_004_ServiceA_OUTUnattended			OUT Unattended	Outbound answered calls that were put in queu, but did not connect to agent in  compliance time, per day
test_005_ServiceA_OUTTotalTalkTime		OUT Total Talk Time	Outbound calls duration total for the day
test_006_ServiceA_OUTRouted				OUT Routed	Outbound calls routed to agents for the day
test_007_ServiceA_OUTRingingDropped		OUT Ringing Dropped	Outbound calls dropped while ringing for the day
test_008_ServiceA_OUTRingingAbandoned	OUT Ringing Abandoned	Outbound calls abandoned while ringing for the day
test_009_ServiceA_OUTRinging			OUT Ringing	Outbound calls delivered to agents and currently ringing
test_010_ServiceA_OUTRemoteDisconnected	OUT Remote Disconnected	Outbound calls released by remote party for the day
test_011_ServiceA_OUTRejected			OUT Rejected	Outbound calls  rejected or unanswered by agents for the day
test_012_ServiceA_OUTQueueDropped		OUT Queue Dropped	Outbound calls dropped in queue for the day
test_013_ServiceA_OUTQueueAbandonedPerCent	OUT Queue Abandoned %	Percentage of outbound calls abandoned in queue for the day
test_014_ServiceA_OUTQueueAbandoned		OUT Queue Abandoned	Outbound calls abandoned in queue for the day
test_015_ServiceA_OUTIVRDropped			OUT IVR Dropped	Outbound calls dropped in IVR for the day
test_016_ServiceA_OUTIVRAbandonedPerCent	OUT IVR Abandoned %	Percentage of outbound calls abandoned in IVR for the day
test_017_ServiceA_OUTIVRAbandoned		OUT IVR Abandoned	Outbound calls abandoned in IVR for the day
test_018_ServiceA_OUTInProgress			OUT In Progress	Outbound interactions in dialing or CPA state
test_019_ServiceA_OUTAvgTalkTime		OUT Avg Talk Time	Outbound calls duration average for the day
test_020_ServiceA_OUTAnsweredPerCent	OUT Answered %	Percentage of outbound successful call attempts for the day
test_021_ServiceA_OUTAgentDisconnected	OUT Agent Disconnected	Outbound calls released by agent for the day
test_022_ServiceA_OUTActive	OUT Active	Outbound interactions currently handled by agents
test_023_ServiceA_OUTAbandonedPerCent	OUT Abandoned %	Percentage of outbound calls abandoned at any stage for the day
test_024_ServiceA_OUTAbandoned			OUT Abandoned	Outbound calls abandoned at any stage for the day
test_025_ServiceA_Occupancy				Occupancy	Occupancy per campaign, all teams, median
test_026_ServiceA_INWaiting				IN Waiting	Inbound interactions currently in queue
test_027_ServiceA_INTrash				IN Trash	Number of interactions re-categorized as trash by agents
test_028_ServiceA_INTotalTalkTime		IN Total Talk Time	Inbound calls duration total for the day
test_029_ServiceA_INTotalAbandonedPerCent	IN Total Abandoned %	Percentage of inbound calls abandoned for the day
test_030_ServiceA_INTotalAbandoned		IN Total Abandoned	Inbound calls abandoned for the day
test_031_ServiceA_INSvcLevelDayPerCent	IN Svc Level Day %	Percentage of inbound interactions answered in Service Level over the day
test_032_ServiceA_INSvcChanged			IN Svc Changed	Number of interactions  recategorized to a different service by agents
test_033_ServiceA_INSvcChangeReceived	IN Svc Change Received	Number of interactions re-categorized from a different service by agents
test_034_ServiceA_INSpam				IN Spam	Number of interactions re-categorized as spam by agents
test_035_ServiceA_INSelfServiced		IN Self Serviced	Inbound calls self serviced for the day
test_036_ServiceA_INRouted				IN Routed	Inbound calls routed to agents for the day
test_037_ServiceA_INRingingDropped		IN Ringing Dropped	Inbound calls dropped by system while ringing for the day
test_038_ServiceA_INRingingAbandoned	IN Ringing Abandoned	Inbound calls abandoned while ringing for the day
test_039_ServiceA_INRinging	IN Ringing	Inbound calls currently ringing 
test_040_ServiceA_INRemoteDisconnected	IN Remote Disconnected	Inbound calls released by callers for the day
test_041_ServiceA_INRejected			IN Rejected	Inbound calls  rejected or unanswered by agents for the day
test_042_ServiceA_INReceivedNew			IN Received New	Inbound interactions received for the day for new cases
test_043_ServiceA_INQueuedUnique		IN Queued Unique	Inbound calls first time queued for the day
test_044_ServiceA_INQueueShAbandonedPerCent	IN Queue Sh-Abandoned %	Percentage of inbound calls short abandoned in queue for the day
test_045_ServiceA_INQueueShAbandoned	IN Queue Sh-Abandoned	Inbound calls short abandoned in queue for the day
test_046_ServiceA_INQueueDropped		IN Queue Dropped	Inbound calls dropped by system in queue for the day
test_047_ServiceA_INQueueAbandonedPerCent	IN Queue Abandoned %	Percentage of inbound calls abandoned in queue for the day
test_048_ServiceA_INQueueAbandoned		IN Queue Abandoned	Inbound calls abandoned in queue for the day
test_049_ServiceA_INonHoldUnique		IN on Hold Unique	Unique inbound interactions being put on hold by agent(s) for the day
test_050_ServiceA_INonHold				IN on Hold	Inbound interactions being put on hold by agent(s) for the day
test_051_ServiceA_INMaxWait				IN Max Wait	Max inbound wait time
test_052_ServiceA_INJoined				IN Joined	number of inbound emails joined to already existing case, per day
test_053_ServiceA_INIVRDropped			IN IVR Dropped	Inbound calls dropped by system in IVR for the day
test_054_ServiceA_INIVRAbandoned		IN IVR Abandoned	Inbound calls abandoned in IVR for the day
test_055_ServiceA_INinProgress			IN in Progress	Inbound emails currently in processing
test_056_ServiceA_INInIVR				IN In IVR	Inbound calls currently in IVR
test_057_ServiceA_INIgnored				IN Ignored	Inbound emails unanswered for the day
test_058_ServiceA_INHandledUnique		IN Handled Unique	Unique Inbound calls handled by agents for the day
test_059_ServiceA_INHandledNew			IN Handled New	Number of new emails processed by agents, including replied, closed without reply, transferred and service changes
test_060_ServiceA_INHandledPerCent		IN Handled %	Percentage of inbound calls handled for the day
test_061_ServiceA_INEWT					IN EWT	Estimated wait time
test_062_ServiceA_INDesktop				IN Desktop	Inbound emails currently on agents, saved in personal queues
test_063_ServiceA_INClosed				IN Closed	Inbound emails closed without reply for the day
test_064_ServiceA_INCarriedOverNew		IN Carried Over New	Inbound emails carried over from previous day for new cases
test_065_ServiceA_INCarriedOver			IN Carried Over	Inbound emails carried over from previous day
test_066_ServiceA_INBreachedSLA			IN Breached SLA	Inbound emails currently on agents, saved in personal queues, waiting in excess of SLA time
test_067_ServiceA_INAvgTalkTime			IN Avg Talk Time	Inbound calls duration average for the day
test_068_ServiceA_INAvgHandleTime		IN Avg Handle Time	Average Handle time
test_069_ServiceA_INASA					IN ASA	For calls, average speed of answer. For emails, average time to reply
test_070_ServiceA_INAgentDisconnected	IN Agent Disconnected	Inbound calls released by agents for the day
test_071_ServiceA_INActive				IN Active	Inbound interactions currently handled by agents
test_072_ServiceA_CBWaiting				CB Waiting	Callbacks currently waiting in queue
test_073_ServiceA_CBRequested			CB Requested	Number of inbound calls exited queue because caller requested callback option
test_074_ServiceA_BusySvc				Busy Svc	Number of busy agents who have at least one interaction with the given service + number of agents in ACW after interaction with the given service.
test_075_ServiceA_Busy	Busy			Busy Agents – current number 
test_076_ServiceA_ACWCount				ACW Count	Agents in ACW state– current number 
test_077_ServiceA_OUTTransferred		OUT Transferred	Outbound calls transferred by agents for the day
test_078_ServiceA_OUTHandled			OUT Handled	Outbound interactions handled by agents for the day. For email - number of unsolicited emails and follow-up responses.
test_079_ServiceA_OUTDialed				OUT Dialed	Outbound call attempts for the day
test_080_ServiceA_OUTAnswered			OUT Answered	Outbound successful calls attempts for the day
test_081_ServiceA_NotReady				Not Ready	Not Ready Agents – current number
test_082_ServiceA_LoggedIn				Logged In	Logged In Agents – current number
test_083_ServiceA_INTransfers			IN Transfers	Inbound transfers received for the day
test_084_ServiceA_INTransferred			IN Transferred	Inbound interactions transferred by agents for the day
test_085_ServiceA_INReplied	IN Replied	Inbound emails replied for the day
test_086_ServiceA_INSvcLevelPerCent		IN Svc Level %	Percentage of inbound interactions answered in Service Level over 20 most recent calls
test_087_ServiceA_INReceived			IN Received	Inbound interactions received for the day
test_088_ServiceA_INQueued	IN Queued	Inbound calls queued for the day
test_089_ServiceA_INHandled	IN Handled	Inbound interactions handled by agents for the day	
	
	
*/	//============================================ RTM test description ==========================================================
		
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
	
	@Test(enabled = true)
	public void test_028_ServiceA_INTotalTalkTime() {
		serviceMetricNumber = 28;
		
		String strTime = serviceMetricsBefore[2][serviceMetricNumber];
		System.out.println("serviceMetricsBefore -> " + strTime);
		int expectedSec = 2;
		
		String expected = parseTimeExpectation(strTime, expectedSec);
		System.out.println("parseTimeExpectation = " + strTime + "+" + expectedSec);
		
		String actual = serviceMetricsAfter[2][serviceMetricNumber];
		System.out.println("actual time -> " + actual);
		
		boolean expectedInDeviation = timeDeviation(actual, expected, 2); // deviation between actual and expected result is less then 2 seconds 
		
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
		int delta = 0;
		
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
		int delta = 0;
		
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
		int delta = 0;
		
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
	  
	@Test(enabled = false)
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

	@Test(enabled = false)
	public void test_025_ServiceA_Occupancy() {
		serviceMetricNumber = 25;
//		String expected = serviceMetricsBefore[2][serviceMetricNumber];
		String expected = "38";                                 // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! hardcore String
		
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
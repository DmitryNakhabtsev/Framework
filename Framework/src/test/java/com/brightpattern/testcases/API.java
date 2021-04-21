/*
 * 
 */
package com.brightpattern.testcases;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;

import com.brightpattern.utility.Helper;

/**
 * The API implements methods that simply interact with the Agent Desktop
 * application for The Java-Selenium-TestNG Automation Project
 * 
 * @author Dmitry Nakhabtsev
 * @version 1.0
 * @since 12 Mart, 2021
 *        <p>
 *        This API implements automation methods for "T2717706 Basic inbound
 *        call routing and blind transfer" Make a call from Phone to Scenario
 *        dial-In number. Switch Agent 1 to "Ready". Answer to the call by Agent
 *        1. Check voice interaction. Check Hold. Set Flag. Check Contact
 *        Identification Make blind transfer the call to Agent 2 by Agent 1.
 *        Answer by Agent 2. Check voice interaction. Check Hold. Check Contact
 *        Identification Hang-up the call by Phone. Set Dispositions for both
 *        Agent 1 and Agent 2. Add notes by Agent 1 and Agent 2. Complete
 *        interactions. Check Contact Activity history (Agent should has a role
 *        to see the call recordings). Play voice recording from Activity
 *        history
 */
public class API {
//**************************** WERTC LOCATORS ***********************************
//	ACCEPT CALL ->
//	/html/body/div[8]/div/table/tbody/tr[2]/td[2]/div/div/div[3]/button[1] ACCEPT CALL
//
//	INITIAL TRANSFER BUTTON ->
//	//*[@id="contact-panel"]/div/div/div[1]/div[2]/div/div[1]/div[6]/button[13]
//
//	ENTER NUBER WHEN INITIAL TRANSFER ->
//	/html/body/div[10]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/input
//
//	INITIAL CALL AFTER ENTERD NUMBER ->
//	/html/body/div[10]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/div/div/button/div
//	//*/div[1]/div/div/div[1]/div[2]/div/div/button/div[@class='b-svg']
//
//	COMPLETE TRANSFER <-
//	//*[@id="cpTransfer"]/div
//
//	NOTES <-
//	//*[@id="cp-notes"]
//
//	SELECT DISPOSITION BUTTON ->
//	//*[@id="gwt-uid-92"]
//
//	SELECT DISPOSITION (PRODUCT SOLD) ->
//	/html/body/div[9]/div/div/div/div/table/tbody/tr[3]/td
//
//	COMPLETE DISPOSITION ->
//	//*[@id="contact-panel"]/div/div/div[1]/div[5]/div/div[1]/button
//
//
//	HOLD ->
//	//*[@id='cpHold']/div
//
//	RETRIVE AFTER HOLD <-
//	//*[@id="cpRetrieve"]/div
//
//	END CALL
//	//*[@id="cpEndCall"]/div

	static 	ChromeDriver driver_aj;
	static 	ChromeDriver driver_tb;
	static 	ChromeDriver driver_cc;
	static 	ChromeDriver driver;
	
	/**
	 * Agent Desktop initialization 
	 * <ul>
	 * <li>BPClient Google Chrome extension initialization.
	 * <li>Set disable-notifications. 
	 * <li>Set microphone access in the agent desktop. 
	 * <li>AGENT DESKTOP LOGIN: user name and default password is "password". 
	 * <li>setPosition of the browser window (alan.jenks 1920,0), (tony.cobb 2880,0), (carlos.clapper 2400,0), (admin maximize())
	 * </ul>
	 * 
	 * @param agentName user name
	 * @param agentPassword default password is "password" 
	 */
	protected static void agentInit(String agentName, String agentPassword) {

		System.setProperty("webdriver.chrome.driver", "Drivers/Linux/chromedriver");
		System.setProperty("webdriver.chrome.whitelistedIps", ""); // Cannot assign requested address (99) while starting chromedriver
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--headless");		
//		options.addExtensions(new File("C:\\Users\\admin\\Documents\\AUTOMATION\\Agent Desktop Chrome Extension 1.16.0.0.crx")); // BPClient chrome extension
		options.addArguments("--disable-notifications");
		options.addArguments("use-fake-ui-for-media-stream"); // Disable permission dialogs for camera/mic access
		
		options.addArguments("--enable-webrtc-stun-origin[13]");	//STUN server used to gather
		/*
		 * Session Traversal Utilities for NAT (STUN) is a standardized set of methods,
		 * including a network protocol, for traversal of network address translator
		 * (NAT) gateways in applications of real-time voice, video, messaging, and
		 * other interactive communications
		 */

		options.addArguments("--no-sandbox");
		
		options.addArguments("--disable-gpu");
		
		options.addArguments("--use-fake-device-for-media-stream"); //Bypass the media stream infobar by selecting the default device for media streams (e.g. WebRTC)
		
	    options.addArguments("--verbose");
	    options.addArguments("--whitelisted-ips=''");
	    
	    String hostURL = "https://dima1.ssf.bugfocus.com/agentdesktop/";
//	    String hostURL = "https://autotests.ssf.bugfocus.com/agentdesktop/";
		
		switch(agentName) {
		  case "alan.jenks":
			  driver_aj = new ChromeDriver(options);
			  driver_aj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver_aj.manage().window().maximize();
			  
			  driver_aj.get(hostURL); 

			  driver_aj.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
			  driver_aj.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password

		  
				try {
					// try to submit
					  driver_aj.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
					System.out.println("AGENT " + agentName + " WAS LOGIN successfully");

				} catch (NoSuchElementException e) {
					// Code for Handling exception
					System.out.println(e.toString());
				}

			  driver_aj.findElement(By.xpath("//*[@id='b-navigation-item-acl1']")).click(); //activation dial pad
		    break;
		  case "tony.cobb":

			  driver_tb = new ChromeDriver(options);
			  driver_tb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver_tb.manage().window().maximize();
			  
			  driver_tb.get(hostURL);

			  driver_tb.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
			  driver_tb.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
			  

			  
				try {
					// try to submit
					driver_tb.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
					System.out.println("AGENT " + agentName + " WAS LOGIN successfully");

				} catch (NoSuchElementException e) {
					// Code for Handling exception
					System.out.println(e.toString());
				}

			  driver_tb.findElement(By.xpath("//*[@id=\"b-navigation-item-acl1\"]/div[1]")).click(); //activation dial pad
		    break;
		  case "carlos.clapper":
			  
			  driver_cc = new ChromeDriver(options);
			  driver_cc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver_cc.manage().window().maximize();
			  
			  driver_cc.get(hostURL);

			  driver_cc.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
			  driver_cc.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
			  driver_cc.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
		  
			  try
			  {
				  // try to login
				  driver_cc.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();	
				  System.out.println("AGENT "+agentName+" WAS LOGIN successfully");
				  
			  } catch (NoSuchElementException e) {
				  // Code for Handling exception
				  System.out.println(e.toString());
			  }

//			  driver_cc.findElement(By.xpath("//*[@id=\"b-navigation-item-supervisor\"]/div[1]")).click(); //supervision panel activation
			  driver_cc.findElement(By.xpath("//*[@id=\"b-navigation-item-acl1\"]/div[1]")).click(); //activation dial pad
			  break;
		  default:
			  driver = new ChromeDriver(options);
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  
			  driver.get(hostURL); 

			  driver.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
			  driver.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
			  
			  
			  
				try {
					// try to login
					driver.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
					System.out.println("AGENT " + agentName + " WAS LOGIN successfully");

				} catch (NoSuchElementException e) {
					// Code for Handling exception
					System.out.println(e.toString());
				}
			  
			  driver.findElement(By.xpath("//*[@id='b-navigation-item-supervisor']")).click(); //supervision panel activation
			  driver.findElement(By.xpath("//*[@id='b-navigation-item-acl1']")).click(); //activation dial pad

		}
}// end of agent_init
	
	  /**
	   * Put a phone number in the input field of the agent and call to.
	   * 
	   * @param agentName enter an agent Name
	   * @param calleeNumber enter the phone number
	   */	
	protected static void agentCallTo(String agentName, String calleeNumber) {

		switch (agentName) {
		case "alan.jenks":
			// input field for enter number, call to calleeNumber
			driver_aj.findElement(By.xpath("//*[@id=\"sp-destination\"]")).sendKeys(calleeNumber);
			driver_aj.findElement(By.xpath("//*[@id=\"dial-toolbar-call\"]/button")).click(); // initiate call button
			break;
		case "tony.cobb":
			// input field for enter number, call tocalleeNumber
			driver_tb.findElement(By.xpath("//*[@id=\"sp-destination\"]")).sendKeys(calleeNumber);
			driver_tb.findElement(By.xpath("//*[@id=\"dial-toolbar-call\"]/button")).click(); // initiate call button
			break;
		case "carlos.clapper":
			// input field for enter number, call tocalleeNumber
			driver_cc.findElement(By.xpath("//*[@id=\"sp-destination\"]")).sendKeys(calleeNumber);
			driver_cc.findElement(By.xpath("//*[@id=\"dial-toolbar-call\"]/button")).click(); // initiate call button
			break;
		default:
			// input field for enter number, call tocalleeNumber

			driver.findElement(By.xpath("//*[@id=\"dial-toolbar-call\"]/button")).click(); // initiate call button
			
			
			  try
			  {
				  driver.findElement(By.xpath("//*[@id=\"sp-destination\"]")).sendKeys(calleeNumber);	
				  System.out.println("AGENT "+ agentName +" ENTER NUMBER of " + calleeNumber);
				  
			  } catch (NoSuchElementException e) {
				  // Code for Handling exception
				  System.out.println(e.toString() + "AGENT "+ agentName +" ENTER NUMBER of " + calleeNumber + "FAILED!!! !!! !!!");
			  }
			  
			  try
			  {
				  driver.findElement(By.xpath("//*[@id=\"dial-toolbar-call\"]/button")).click(); // initiate call button	
				  System.out.println("AGENT "+ agentName +" CLICK call button FOR " + calleeNumber);
				  
			  } catch (NoSuchElementException e) {
				  // Code for Handling exception
				  System.out.println(e.toString() + "AGENT "+ agentName +" CLICK call button FOR " + calleeNumber + "FAILED!!! !!! !!!");
			  }
			
		}
	}// end of agentCallTo
	
	  /**
	   * End the call. Click the "end call" button. 
	   * 
	   * @param agentName enter an agent Name
	   */
	protected static void agentEndCall(String agentName) {

		switch (agentName) {
		case "alan.jenks":

			
			try //TRY to click the "end call" button
			  {
				driver_aj.findElement(By.xpath("//*[@id=\"cpEndCall\"]")).click(); // button end call	
				  System.out.println("AGENT "+ agentName +" ended the call");
				  
			  } catch (NoSuchElementException e) {
				  // Code for Handling exception
				  System.out.println(e.toString() + "AGENT "+ agentName +" click END CALL button FAILED!!! !!! !!!");
			  }
			
			break;
		case "tony.cobb":
			
			try //TRY to click the "end call" button
			  {
				driver_tb.findElement(By.xpath("//*[@id=\"cpEndCall\"]")).click(); // button end call
				  System.out.println("AGENT "+ agentName +" ended the call");
				  
			  } catch (NoSuchElementException e) {
				  // Code for Handling exception
				  System.out.println(e.toString() + "AGENT "+ agentName +" click END CALL button FAILED!!! !!! !!!");
			  }
			break;
		case "carlos.clapper":
			
			try //TRY to click the "end call" button
			  {
				driver_cc.findElement(By.xpath("//*[@id=\"cpEndCall\"]")).click(); // button end call
				  System.out.println("AGENT "+ agentName +" ended the call");
				  
			  } catch (NoSuchElementException e) {
				  // Code for Handling exception
				  System.out.println(e.toString() + "AGENT "+ agentName +" click END CALL button FAILED!!! !!! !!!");
			  }
			break;
		default:
			try //TRY to click the "end call" button
			  {
				driver.findElement(By.xpath("//*[@id=\"cpEndCall\"]")).click(); // button end call
				  System.out.println("AGENT "+ agentName +" ended the call");
				  
			  } catch (NoSuchElementException e) {
				  // Code for Handling exception
				  System.out.println(e.toString() + "AGENT "+ agentName +" click END CALL button FAILED!!! !!! !!!");
			  }
		}
	}// end of agentEndCall
	
	  /**
	   * Click the "Complete Transfer" button. 
	   * 
	   * @param agentName enter an agent Name
	   */
	protected static void agentCompleteTransfer(String agentName) {

		switch (agentName) {
		case "alan.jenks":

			driver_aj.findElement(By.xpath("//*[@id=\"cpTransfer\"]/div")).click(); // "Complete Transfer" button
			break;
		case "tony.cobb":
			driver_tb.findElement(By.xpath("//*[@id=\"cpTransfer\"]/div")).click(); // "Complete Transfer" button
			break;
		case "carlos.clapper":
			driver_cc.findElement(By.xpath("//*[@id=\"cpTransfer\"]/div")).click(); // "Complete Transfer" button
			break;
		default:
			driver.findElement(By.xpath("//*[@id=\"cpTransfer\"]/div")).click(); // "Complete Transfer" button
		}
	}// end of agentCompleteTransfer
	
	  /**
	   * WebRTC
	   *Answer incoming call. Click the "activation incoming call" button.
	   * 
	   * @param agentName enter an agent Name
	   */
	protected static void agentCallAnswer(String agentName) {

//		String AcceptCallButton = "/html/body/div[8]/div/table/tbody/tr[2]/td[2]/div/div/div[3]/button[1]";		
		String AcceptCallButton = "/html/body/div[8]//button[contains(text(),'Accept')]";
		                         
		switch (agentName) {
		case "alan.jenks":
		
			try {
				// try to check ACCEPT CALL
				driver_aj.findElement(By.xpath(AcceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "ACCEPT CALL for " + agentName + " was not set");
			}
					
			break;
		case "tony.cobb":		
			try {
				// try to check ACCEPT CALL
				driver_tb.findElement(By.xpath(AcceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "ACCEPT CALL for " + agentName + " was not set");
			}
			
			break;
		case "carlos.clapper":
			try {
				// try to check ACCEPT CALL
				driver_cc.findElement(By.xpath(AcceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "ACCEPT CALL for " + agentName + " was not set");
			}
			break;
		default:			
			try {
				// try to check ACCEPT CALL
				driver.findElement(By.xpath(AcceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "ACCEPT CALL for " + agentName + " was not set");
			}
		}
	}// end of agentAnswerCall
	

	
	  /**
	   * Log out Agent from the agent desktop and close the browser.
	   * 
	   * @param agentName enter an agent Name
	   */
	protected static void agentLogOut(String agentName) {

		switch (agentName) {
		case "alan.jenks":

			driver_aj.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();
			driver_aj.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();
			driver_aj.quit();
			break;
		case "tony.cobb":

			driver_tb.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();
			driver_tb.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();
			driver_tb.quit();
			break;
		case "carlos.clapper":

			driver_cc.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();
			driver_cc.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();
			driver_cc.quit();
			break;
		default:

			driver.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();
			driver.quit();
		}
		
		System.out.println("agent " + agentName + " was LOGOUT successfully");

	}// end of agentLogOut
	
	  /**
	   * Get Services Metrics for 3 services: Customer Service Chat, Service A, ServiceZen 
	   * from the "admin" Supervision board.
	   * 
	   * @param agentName not implemented feature
	   * @param numberOfAgents enter number of agents that metrics we want to get
	   * @return String[][] two-dimensional array of all agents (Customer Alan Jenks, Tony Cobb, User Super ) metrics
	   */
	protected static String[][] getServicesMetrics(String serviceName, int numberOfServices) {
		
		System.out.println("************************ 89 services metrics gathering ******************************");
		int size = 89;
		String[][] metrics = new String[4][size+1]; // create a metrics array
		
		for (int i = 1; i <= size; i++) {// get name fields
			String xpath_names = "//*[@id=\"monServiceTable\"]/div[1]/div[3]/table/thead/tr/th[" + i + "]/div/span";

			try	{metrics[0][i] = driver.findElement(By.xpath(xpath_names)).getText();
			} catch (StaleElementReferenceException e) {System.out.println(e.toString());}

		}

		for (int j = 1; j < 4; j++) {// get value fields for 3 services: Customer Service Chat, Service A, ServiceZen		
			for (int i = 1; i <= size; i++) {
				String xpath_values = "//*[@id=\"monServiceTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]/div/div";
				  try {metrics[j][i] = driver.findElement(By.xpath(xpath_values)).getText();
				  } catch (StaleElementReferenceException e) {System.out.println(e.toString());}
			}


		}
		
		return metrics;
	} // servicesMetrics89 ========================================================================================================================================
	
	  /**
	   * Get Agents Metrics for all configured agents (Alan Jenks, Tony Cobb, User Super ) from the "admin" Supervision board.
	   * 
	   * @param agentName not implemented feature
	   * @param numberOfAgents enter number of agents that metrics we want to get
	   * @return String[][] two-dimensional array of all agents (Customer Alan Jenks, Tony Cobb, User Super ) metrics
	   */
	protected static String[][] getAgentsMetrics(String agentName, int numberOfAgents) {

		System.out.println("************************ 62 getAgentsMetrics gathering ******************************");
		int size = 62;
		String[][] agentsMetrics = new String[5][4+size]; // create a two-dimensional array

		for (int i = 4; i <= 3+size; i++) {// get name fields

			String xpath_names = "//*[@id=\"monUserTable\"]/div[1]/div[3]/table/thead/tr/th[" + i + "]/div/span";

			try	{agentsMetrics[0][i] = driver.findElement(By.xpath(xpath_names)).getText();
			} catch (StaleElementReferenceException e) {System.out.println(e.toString());}	

		}

		
		for (int j = 1; j <= numberOfAgents; j++) {// get value fields for 3 agents: Alan Jenks, Tony Cobb, User Super 
			for (int i = 4; i <= 3+size; i++) {

				String xpath_values = "//*[@id=\"monUserTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]";
				
				try	{agentsMetrics[j][i] = driver.findElement(By.xpath(xpath_values)).getText();
				} catch (StaleElementReferenceException e) {System.out.println(e.toString());}	

			}
			
		}
		
		return agentsMetrics;

	}// end of getAgentsMmetrics
	
	  /**
	   * Get Teams Metrics for all configured teams from the "admin" Supervision board. 
	   * 
	   * @param teamName not implemented feature
	   * @return teamsMetrics two-dimensional array String[][] of all teams (Customer Service Chat, Service A, ServiceZen) metrics
	   */
	protected static String[][] getTeamsMetrics(String teamName) {
		
		System.out.println("************************ 10 getTeamsMetrics gathering ******************************");
		int size = 11;
		
		String[][] teamsMetrics = new String[4][size+1]; // create a two-dimensional array for Teams Metrics

		for (int i = 1; i <= size; i++) {//get name fields

			String xpath_names = "//*[@id=\"monTeamTable\"]/div[1]/div[3]/table/thead/tr/th["+i+"]/div/span";

			try	{teamsMetrics[0][i] = driver.findElement(By.xpath(xpath_names)).getText();
			} catch (StaleElementReferenceException e) {System.out.println(e.toString());}

		}
		System.out.println();
//			
		for (int j = 2; j < 4; j++) {// get value fields for 3 teams
			for (int i = 1; i <= size; i++) {

				String xpath_values =    "//*[@id=\"monTeamTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]";	
				try	{teamsMetrics[j][i] = driver.findElement(By.xpath(xpath_values)).getText();
				} catch (StaleElementReferenceException e) {System.out.println(e.toString());}				

			}
			System.out.println();
		}
		
		return teamsMetrics;

	}// end of getTeamsMmetrics
	
	
	/**
  	 * Get Services Metrics for all configured services from the "admin" Supervision board .
  	 *
  	 * @param serviceName not implemented feature
  	 * @return servicesMetrics String[][] two-dimensional array of all services (Customer Service Chat, Service A, ServiceZen) metrics
  	 */
	protected static String[][] getServicesMetrics(String serviceName) {
		
		String[][] servicesMetrics = new String[4][16]; // create a two-dimensional array

		for (int i = 1; i <= 15; i++) {// get name fields

			String xpath_names = "//*[@id=\"monServiceTable\"]/div[1]/div[3]/table/thead/tr/th[" + i + "]/div/span";
			servicesMetrics[0][i] = driver.findElement(By.xpath(xpath_names)).getText();
			System.out.print(servicesMetrics[0][i] + " ");

		}
		System.out.println();

		for (int j = 1; j < 4; j++) {// get value fields for 3 services: Customer Service Chat, Service A, ServiceZen
			for (int i = 1; i <= 15; i++) {

				String xpath_values = "//*[@id=\"monServiceTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]";
				servicesMetrics[j][i] = driver.findElement(By.xpath(xpath_values)).getText();
				System.out.print(servicesMetrics[j][i] + " ");

			}
			System.out.println();
		}
		return servicesMetrics;

	}// end of getServicesMmetrics
	
	  /**
	   * Set "Service A" after Agent Login. 
	   * And check if the service was not set
	   * 
	   * @param agentName enter the agent name
	   */
	protected static void setServiceToAgent(String agentName) {

		String xpath_select = "//*[@title='Service Selector']/div";
		String xpath_ServiceA = "//*[@aria-label='Service A']";
		String service_names;

		switch (agentName) {
		case "alan.jenks":

			driver_aj.findElement(By.xpath(xpath_select)).click();
			driver_aj.findElement(By.xpath(xpath_ServiceA)).click();
			
			//Thread.sleep(1000);
			
			try {
				// try to check setting of "Service A"
				service_names = driver_aj.findElement(By.xpath(xpath_select)).getText();
				System.out.println(service_names + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "Service A for " + agentName + " was not set");
			}
			
			break;
		case "tony.cobb":

			driver_tb.findElement(By.xpath(xpath_select)).click();
			driver_tb.findElement(By.xpath(xpath_ServiceA)).click();
			
//			Thread.sleep(1000);
			try {
				// // try to check setting of "Service A"
				service_names = driver_tb.findElement(By.xpath(xpath_select)).getText();
				System.out.println(service_names + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "Service A for " + agentName + " was not set");
			}
			break;
		case "carlos.clapper":

			driver_cc.findElement(By.xpath(xpath_select)).click();
			driver_cc.findElement(By.xpath(xpath_ServiceA)).click();
			
//			Thread.sleep(1000);
			
			try {
				// // try to check setting of "Service A"
				service_names = driver_cc.findElement(By.xpath(xpath_select)).getText();
				System.out.println(service_names + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "Service A for " + agentName + " was not set");
			}
			break;
		default:

			driver.findElement(By.xpath(xpath_select)).click();
			driver.findElement(By.xpath(xpath_ServiceA)).click();
			
//			Thread.sleep(1000);
			
			try {
				// try to check setting of "Service A"
				service_names = driver.findElement(By.xpath(xpath_select)).getText();
				System.out.println(service_names + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "Service A for " + agentName + " was not set");
			}
		}
	}// end of setServiceToAgent
	
	  /**
	   * After Login Agent, switch the agent status to "Ready" and check if the status was not changed.
	   * 
	   * @param agentName enter the agent name
	   * @see NoSuchElementException in Selenium: https://www.selenium.dev/exceptions/#stale_element_reference
	   */	
	protected static void setReadyToAgent(String agentName) {
		
		
//		String xpathSelectStatus ="//*[@id=\"gwt-debug-acStateMenuContainer\"]/div[1]"; // <-   xpathSelectStatus /img
		String xpathSelectStatus ="//*[@id='header-panel']/div"; //*[@id='header-panel']/div
		String xpathReady = "//*[@title='Ready']";
		String xpathSelectReadyStatus = "//*[@id=\"header-panel\"]/div"; // locator for READY status in agent desktop 

		
		String service_names;
		String status_names;

		switch (agentName) {
		case "alan.jenks":

			driver_aj.findElement(By.xpath(xpathSelectStatus)).click();
			System.out.println(Helper.captureScreenshot(driver_aj));
			wait(1000);
			driver_aj.findElement(By.xpath(xpathReady)).click();	
			System.out.println(Helper.captureScreenshot(driver_aj));

			
			try {
			// try to find status Not Ready
				status_names = driver_aj.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
				System.out.println("click to STATUS field: " + status_names);
			
		} catch (NoSuchElementException e) {
			// Code for Handling exception
			System.out.println(e.toString() + "agent" +  agentName + "status was not changed");
		}
			
			break;
		case "tony.cobb":

			driver_tb.findElement(By.xpath(xpathSelectStatus)).click();
			driver_tb.findElement(By.xpath(xpathReady)).click();	
			
			try {
			// try to find status Not Ready
				status_names = driver_tb.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
				System.out.println("click to STATUS field: " + status_names);
			
		} catch (NoSuchElementException e) {
			// Code for Handling exception
			System.out.println(e.toString() + "agent" +  agentName + "status was not changed");
		}
		
			break;
		case "carlos.clapper":

			driver_cc.findElement(By.xpath(xpathSelectStatus)).click();
			driver_cc.findElement(By.xpath(xpathReady)).click();	

			try {
			// try to find status Not Ready
				status_names = driver_cc.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
				System.out.println("click to STATUS field: " + status_names);
			
		} catch (NoSuchElementException e) {
			// Code for Handling exception
			System.out.println(e.toString() + "agent" +  agentName + "status was not changed");
		}
			
			break;
		default:

			driver.findElement(By.xpath(xpathSelectStatus)).click();
			driver.findElement(By.xpath(xpathReady)).click();	

			
			try {
			// try to find status Not Ready
				status_names = driver.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
				System.out.println("click to STATUS field: " + status_names);
			
		} catch (NoSuchElementException e) {
			// Code for Handling exception
			System.out.println(e.toString() + "agent" +  agentName + "status was not changed");
		}
			
		}
	}// end of setReadyToAgent
	
	
	  /**
	   * Check the service inbound call is routing to Agent. Agent has a ringing call. Agent state is "Ringing".
	   * 
	   * @param agentName enter the agent name
	   * @return callContinuing boolean of existing of the call status 
	   */
	protected static boolean checkCalling(String agentName) {

		boolean callContinuing=false;

		switch (agentName) {
		case "alan.jenks":

			try {
				// try to find the calling status element
				String callNoAnswer = driver_aj.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[1]/div/div[10]/div[1]/div[6]")).getAttribute("class");
				
				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "agent" + agentName + "is not calling");
				callContinuing = false;
				return callContinuing;
			}


		case "tony.cobb":

			try {
				// try to find the calling status element
				String callNoAnswer = driver_tb.findElement(By.xpath(
						"/html/body/div[5]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[1]/div/div[10]/div[1]/div[6]"))
						.getAttribute("class");
				
				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "agent" + agentName + "is not calling");
				callContinuing = false;
				return callContinuing;
			}

		case "carlos.clapper":

			try {
				// try to find the calling status element
				String callNoAnswer = driver_cc.findElement(By.xpath(
						"/html/body/div[5]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[1]/div/div[10]/div[1]/div[6]"))
						.getAttribute("class");
				
				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "agent" + agentName + "is not calling");
				callContinuing = false;
				return callContinuing;
			}


		default:

			try {
				// try to find the calling status element
				String callNoAnswer = driver.findElement(By.xpath(
						"/html/body/div[5]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[1]/div/div[10]/div[1]/div[6]"))
						.getAttribute("class");

				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "agent" + agentName + "is not calling");
				callContinuing = false;
				return callContinuing;
			}

			
		}
	}// end of checkCalling


	  /**
	   * Check Flag setting.
	   * 
	   * @param agentName enter the agent name
	   * @return boolean of the Flag button existing and clicking
	   */
	protected static boolean checkFlag(String agentName) {

		switch (agentName) {
		case "alan.jenks":
			// check flag
			try {
				driver_aj.findElement(By.xpath("//button[@title='Flag the call']")).click();
				System.out.println("Flag the call check PASSED");
				return true;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Flag the call check FAILED");
				return false;
			}

		case "tony.cobb":
			// check flag
			try {
				driver_tb.findElement(By.xpath("//button[@title='Flag the call']")).click();
				System.out.println("Flag the call status PASSED");
				return true;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Flag the call status FAILED");
				return false;
			}

		case "carlos.clapper":
			// check flag
			try {
				driver_cc.findElement(By.xpath("//button[@title='Flag the call']")).click();
				System.out.println("Flag the call status PASSED");
				return true;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Flag the call status FAILED");
				return false;
			}

		default:
			// check flag
			try {
				driver.findElement(By.xpath("//button[@title='Flag the call']")).click();
				System.out.println("Flag the call status PASSED");
				return true;

			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Flag the call status FAILED");
				return false;
			}
		
		}
	}// end of checkFlag	
	
	  /**
	   * Check the "Retrieve" button after place the call on hold. 
	   * 
	   * @param agentName enter the agent name
	   * @return boolean existing and clicking of the "Retrieve" button 
	   */
	protected static boolean checkRetrieveButton(String agentName) {

		switch (agentName) {
		case "alan.jenks":
			// check retrieve
			try {
				driver_aj.findElement(By.xpath("//*[@id=\"cpRetrieve\"]")).click();
				System.out.println("RETRIEVE status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " RETRIEVE status FAILED");
				return false;
			}

		case "tony.cobb":
			// check retrieve
			try {
				driver_tb.findElement(By.xpath("//*[@id=\"cpRetrieve\"]")).click();
				System.out.println("RETRIEVE status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " RETRIEVE status FAILED");
				return false;
			}

		case "carlos.clapper":
			// check retrieve
			try {
				driver_cc.findElement(By.xpath("//*[@id=\"cpRetrieve\"]")).click();
				System.out.println("RETRIEVE status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " RETRIEVE status FAILED");
				return false;
			}

		default:
			// check retrieve
			try {
				driver.findElement(By.xpath("//*[@id=\"cpRetrieve\"]")).click();
				System.out.println("RETRIEVE status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " RETRIEVE status FAILED");
				return false;
			}
		
		}
	}// end of checkRetriveButton
	
	  /**
	   * Check the "Hold" button. Place the call on hold.
	   * 
	   * @param agentName enter the agent name
	   * @return boolean of the Hold button existing and clicking
	   */
	protected static boolean checkHoldButton(String agentName) {

		switch (agentName) {
		case "alan.jenks":
			// check hold
			try {
				driver_aj.findElement(By.xpath("//*[@id='cpHold']/div")).click();
				System.out.println("HOLD status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "HOLD status FAILED");
				return false;
			}

		case "tony.cobb":
			// check hold
			try {
				driver_tb.findElement(By.xpath("//*[@id='cpHold']/div")).click();
				System.out.println("HOLD status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "HOLD status FAILED");
				return false;
			}

		case "carlos.clapper":
			// check hold
			try {
				driver_cc.findElement(By.xpath("//*[@id='cpHold']/div")).click();
				System.out.println("HOLD status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "HOLD status FAILED");
				return false;
			}

		default:
			// check hold
			try {
				driver.findElement(By.xpath("//*[@id='cpHold']/div")).click();
				System.out.println("HOLD status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "HOLD status FAILED");
				return false;
			}
		
		}
	}// end of checkHoldButton	

	  /**
	   * Check Contact Identification. Contact is identified and shown on the left icon.
	   * 
	   * @param agentName enter the agent name
	   * @return boolean of the Activity Form existing 
	   */
	protected static boolean checkContactIdentification(String agentName) {

		switch (agentName) {
		case "alan.jenks":
			// check contact identification
			try {
				driver_aj.findElement(By.xpath("//span[text()='User Super']")).click();
				System.out.println("contact identification PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "contact identification FAILED");
				return false;
			}

		case "tony.cobb":
			// check contact identification
			try {
				driver_tb.findElement(By.xpath("//span[text()='User Super']")).click();
				System.out.println("contact identification PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "contact identification FAILED");
				return false;
			}

		case "carlos.clapper":
			// check contact identification
			try {
				driver_cc.findElement(By.xpath("//span[text()='User Super']")).click();
				System.out.println("contact identification PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "contact identification FAILED");
				return false;
			}

		default:
			// check contact identification
			try {
				driver.findElement(By.xpath("//span[text()='User Super']")).click();
				System.out.println("contact identification PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + "contact identification FAILED");
				return false;
			}
		
		}
	}// end of checkContactIdentification	
	
	  /**
	   * Check existing of the pop-up URL form for the agent who answered the "service" inbound call.
	   * There is pop-up with Form or Screen pop.  
	   * 
	   * @param agentName enter the agent name
	   * @return boolean existing of the Activity popup form  
	   */
	protected static boolean checkPopup(String agentName) {

		switch (agentName) {
		case "alan.jenks":
			// check popup
			try {
				driver_aj.findElement(By.xpath("//div[@title='URL']")).click();
				System.out.println("Popup URL PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Popup URL FAILED");
				return false;
			}

		case "tony.cobb":
			// check popup
			try {
				driver_tb.findElement(By.xpath("//div[@title='URL']")).click();
				System.out.println("Popup URL PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Popup URL FAILED");
				return false;
			}

		case "carlos.clapper":
			// check popup
			try {
				driver_cc.findElement(By.xpath("//div[@title='URL']")).click();
				System.out.println("Popup URL PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Popup URL FAILED");
				return false;
			}

		default:
			// check popup
			try {
				driver.findElement(By.xpath("//div[@title='URL']")).click();
				System.out.println("Popup URL PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Popup URL FAILED");
				return false;
			}
		
		}
	}// end of checkPopup	
	
	  /**
	   * Check existing of the Activity form for the agent who answered the "service" inbound call. 
	   * There is pop-up with Form or Screen pop.
	   * 
	   * @param agentName enter the agent name
	   * @return boolean of the Activity Form existing 
	   */
	protected static boolean checkActivityForm(String agentName) {

		switch (agentName) {
		case "alan.jenks":
			// check activity form
			try {
				driver_aj.findElement(By.xpath("//div[@title='AF_ServiceA']")).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Service Form FAILED");
				return false;
			}

		case "tony.cobb":
			// check activity form
			try {
				driver_tb.findElement(By.xpath("//div[@title='AF_ServiceA']")).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Service Form FAILED");
				return false;
			}

		case "carlos.clapper":
			// check activity form
			try {
				driver_cc.findElement(By.xpath("//div[@title='AF_ServiceA']")).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Service Form FAILED");
				return false;
			}

		default:
			// check activity form
			try {
				driver.findElement(By.xpath("//div[@title='AF_ServiceA']")).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {
				// Code for Handling exception
				System.out.println(e.toString() + " Service Form FAILED");
				return false;
			}
		
		}
	}// end of checkActivityForm	

	  /**
	   * Initiate the transfer button.
	   * Put a phone number in the input field of the agent.
	   * Click the "blind transfer" button
	   * 
	   * @param agentName enter the agent name
	   * @param calleeNumber enter the outcoming number
	   */	
	protected static void agentBlindTransfer(String agentName, String calleeNumber) {

		switch (agentName) {
		case "alan.jenks":
			// agentBlindTransfer
			driver_aj.findElement(By.xpath("//button[@id='cpReminder']/following-sibling::button/following-sibling::button")).click(); // initiate transfer button
			driver_aj.findElement(By.xpath("//*[@id=\"ConfirmDialogBox\"]/div/table/tbody/tr[2]/td[2]/div/div/div/div/div/div/div[2]/input")).sendKeys(calleeNumber); // it is ok too!`
			
			driver_aj.findElement(By.xpath("/html/body/div[11]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/div/button/div")).click(); // blind transfer button
			System.out.println("blind transfer button was clicked!!!!!!!!!!!!");
			
			break;
		case "tony.cobb":
			// agentBlindTransfer
			driver_tb.findElement(By.xpath("//button[@id='cpReminder']/following-sibling::button/following-sibling::button")).click(); // initiate transfer button
			driver_tb.findElement(By.xpath("//*[@id=\"ConfirmDialogBox\"]/div/table/tbody/tr[2]/td[2]/div/div/div/div/div/div/div[2]/input")).sendKeys(calleeNumber); 
			driver_tb.findElement(By.xpath("/html/body/div[11]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/div/button/div")).click(); // blind transfer button
			
			break;
		case "carlos.clapper":
			// agentBlindTransfer
			driver_cc.findElement(By.xpath("//button[@id='cpReminder']/following-sibling::button/following-sibling::button")).click(); // initiate transfer button
			driver_cc.findElement(By.xpath("//*[@id=\"ConfirmDialogBox\"]/div/table/tbody/tr[2]/td[2]/div/div/div/div/div/div/div[2]/input")).sendKeys(calleeNumber); 
			driver_cc.findElement(By.xpath("/html/body/div[11]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/div/button/div")).click(); // blind transfer button
			break;
		default:
			// agentBlindTransfer
			driver.findElement(By.xpath("//button[@id='cpReminder']/following-sibling::button/following-sibling::button")).click(); // initiate transfer button
			driver.findElement(By.xpath("//*[@id=\"ConfirmDialogBox\"]/div/table/tbody/tr[2]/td[2]/div/div/div/div/div/div/div[2]/input")).sendKeys(calleeNumber); 
			driver.findElement(By.xpath("/html/body/div[11]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/div/button/div")).click(); // blind transfer button
		}
	}// agentBlindTransfer	
	
	  /**
	   * Initiate the transfer button.
	   * Put a phone number in the input field of the agent.
	   * Click the "initiate call button"
	   * 
	   * @param agentName enter the agent name
	   * @param calleeNumber enter the outcoming number
	   */	
	protected static void agentConsultCall(String agentName, String calleeNumber) {
		
		String InitalTransferButton = "//*[@id=\"contact-panel\"]/div/div/div[1]/div[2]/div/div[1]/div[6]/button[13]";
		String EnterNumber = "/html/body/div[10]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/input";
		String SubmitNumber = "//*/div[1]/div/div/div[1]/div[2]/div/div/button/div[@class='b-svg']";

		switch (agentName) {
		case "alan.jenks":
			// Consult call
			driver_aj.findElement(By.xpath(InitalTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driver_aj.findElement(By.xpath(EnterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driver_aj.findElement(By.xpath(SubmitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER
			System.out.println(agentName + " initiate call button was clicked!");
			
			break;
		case "tony.cobb":
			// Consult call
			driver_tb.findElement(By.xpath(InitalTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driver_tb.findElement(By.xpath(EnterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driver_tb.findElement(By.xpath(SubmitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER
			System.out.println(agentName + " initiate call button was clicked!");		
			break;
		case "carlos.clapper":
			// Consult call
			driver_cc.findElement(By.xpath(InitalTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driver_cc.findElement(By.xpath(EnterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driver_cc.findElement(By.xpath(SubmitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER
			System.out.println(agentName + " initiate call button was clicked!");
			break;
		default:
			// Consult call
			driver.findElement(By.xpath(InitalTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driver.findElement(By.xpath(EnterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driver.findElement(By.xpath(SubmitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER
			System.out.println(agentName + " initiate call button was clicked!");
		}
	}// agentConsultCall	
	
	  /**
	   * Fill out the notes field.
	   * 
	   * @param agentName enter the agent name
	   * @param notes enter a note text
	   */
	protected static void fillOutNotes(String agentName, String notes) {

		switch (agentName) {
		case "alan.jenks":
			// fillOutNotes
			driver_aj.findElement(By.xpath("//*[@id=\"cp-notes\"]")).sendKeys(notes); 
			break;
		case "tony.cobb":
			// fillOutNotes
			driver_tb.findElement(By.xpath("//*[@id=\"cp-notes\"]")).sendKeys(notes); 	
			break;
		case "carlos.clapper":
			// fillOutNotes
			driver_cc.findElement(By.xpath("//*[@id=\"cp-notes\"]")).sendKeys(notes); 
			break;
		default:
			// fillOutNotes
			driver.findElement(By.xpath("//*[@id=\"cp-notes\"]")).sendKeys(notes); 
		}
	}// end of fillOutNotes	

	  /**
	   * Select the disposition button.
	   * Choose the disposition "Appointments Set."
	   * Complete the interaction.
	   * 
	   * @param agentName enter the agent name
	   */	
	protected static void selectDisposition(String agentName) {
		
	String SelectDispositionButton = "//*[@id='gwt-uid-92']"; // SELECT DISPOSITION BUTTON
	String SelectDisposition = "/html/body/div[9]/div/div/div/div/table/tbody/tr[3]/td"; // SELECT DISPOSITION (PRODUCT SOLD)	
	String CompleteDispositionButton = "//*[@id=\"contact-panel\"]/div/div/div[1]/div[5]/div/div[1]/button/div"; // COMPLETE DISPOSITION

		switch (agentName) {
		case "alan.jenks":
			// selectDisposition
			driver_aj.findElement(By.xpath(SelectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driver_aj.findElement(By.xpath(SelectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driver_aj.findElement(By.xpath(CompleteDispositionButton)).click(); // COMPLETE DISPOSITION

			break;
		case "tony.cobb":
			// selectDisposition
			driver_tb.findElement(By.xpath(SelectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driver_tb.findElement(By.xpath(SelectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driver_tb.findElement(By.xpath(CompleteDispositionButton)).click(); // COMPLETE DISPOSITION
			break;
		case "carlos.clapper":
			// selectDisposition
			driver_cc.findElement(By.xpath(SelectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driver_cc.findElement(By.xpath(SelectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driver_cc.findElement(By.xpath(CompleteDispositionButton)).click(); // COMPLETE DISPOSITION
			break;
		default:
			// selectDisposition
			driver.findElement(By.xpath(SelectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driver.findElement(By.xpath(SelectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driver.findElement(By.xpath(CompleteDispositionButton)).click(); // COMPLETE DISPOSITION
		}
	}// end of selectDisposition	

	  /**
	   * Waiting time for scenario steps
	   * 
	   * @param t ms waiting time
	   */
	protected static void wait(int t) {
		try {Thread.sleep(t);} catch (InterruptedException e) {e.printStackTrace();} // t ms waiting time
	}
	
	  /**
	   * Print metrics in console
	   * 
	   * @param metricArray enter the metric array  name
	   */
	protected static void printOutMetrics(String[][] metricArray) {
	
		System.out.println("************ mettrics *************");
		System.out.println(Arrays.deepToString(metricArray)); 
	}
	
	  /**
	   * Set scenario counter result to metric. Used as expected result.
	   * 
	   * @param metricValue as before scenario interaction
	   * @param delta as delta between metricValue and expected result
	   */
	protected static String parseStringExpectation(String metricValueBefore, int delta) {	
		
	 int i = Integer.parseInt(metricValueBefore); //String to int
	 String metricValueAfter = String.valueOf(i + delta); //int to String
	 
	 return metricValueAfter;
	}
	
	  /**
	   * Set scenario timer result to metric. Used as expected result.
	   * 
	   * @param strTime as before scenario interaction
	   * @param expectedSec as delta between strTime and expected result
	   */	
    public static String parseTimeExpectation(String strTime, int expectedSec) {

        String timeAfter;
        DateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Date d = null;
		try {
			d = dateFormat.parse(strTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int min = d.getMinutes();
        int sec = d.getSeconds();
//        int min = d.Calendar.MINUTE;
//        int sec = d.getSeconds();
        String timeBefore = min + ":"+ sec;

        if((expectedSec+sec)>60) {
     	   min = min + 1;
     	   sec = (expectedSec + sec) - 60;
        }else {
     	   sec =  sec + expectedSec;
        }
        if (sec<10) {
     	   timeAfter = min + ":0"+ sec;
     	   }else {
         	   timeAfter = min + ":"+ sec;
     	   }
        
        return timeAfter;
        
     }
	
	  /**
	   * Divide Time By Number
	   * 
	   * @param strTime as before dividing
	   * @param number as number by 
	   */	
  public static String divideTimeByNumber(String strTime, int number) {

      String timeAfter;
      DateFormat dateFormat = new SimpleDateFormat("mm:ss");
      Date d = null;
		try {d = dateFormat.parse(strTime);} catch (ParseException e) {e.printStackTrace();}
		
      int min = d.getMinutes();
      int sec = d.getSeconds();

      int totalSec = min * 60 +sec; 
      int totalDividedSec = totalSec/number;
      int divideMin = totalDividedSec/60;
      int dividedSec = totalDividedSec - divideMin*60;



      if (dividedSec<10) {
   	   timeAfter = divideMin + ":0"+ dividedSec;
   	   }else {
       	   timeAfter = divideMin + ":"+ dividedSec;
   	   }
      
      return timeAfter;
      
   }
  
  /**
   * Addition Time in String
   * 
   * @param strTime as before dividing
   * @param number as number by 
   */	
public static String addTime(String firstTime, String secondTime) {
    String timeAfter;
    DateFormat dateFormat = new SimpleDateFormat("mm:ss");
    Date d = null;
    
    // parse second Time value 
	try {d = dateFormat.parse(firstTime);} catch (ParseException e) {e.printStackTrace();}	
    int firstMin = d.getMinutes();
    int firstSec = d.getSeconds();
    int firstTotalSec = firstMin * 60 +firstSec;
    
 // parse second Time value   
	try {d = dateFormat.parse(secondTime);} catch (ParseException e) {e.printStackTrace();}
	int secondMin = d.getMinutes();
    int secondSec = d.getSeconds();
    int secondTotalSec = secondMin * 60 +secondSec;
    
    int totalSec = firstTotalSec + secondTotalSec;
    int afterMin = totalSec/60;
    int afterSec = totalSec - afterMin*60;
    
    if (afterMin<10) {
    	if (afterSec<10) {
    		timeAfter = "0"+afterMin + ":0"+ afterSec;
    	}else {
    		timeAfter = "0"+afterMin + ":"+ afterSec;
    	}
    }else {
    	if (afterSec<10) {
    		timeAfter = afterMin + ":0"+ afterSec;
    	}else {
    		timeAfter = afterMin + ":"+ afterSec;
    	}
    }
    

    return timeAfter;
}
	
}// end of class API

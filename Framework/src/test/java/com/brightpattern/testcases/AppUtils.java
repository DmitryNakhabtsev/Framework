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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brightpattern.utility.Helper;

// TODO: Auto-generated Javadoc
/**
 * The API implements methods that simply interact with the Agent Desktop
 * application for The Java-Selenium-TestNG Automation Project.
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

public class AppUtils {
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

	/** The driverAJ. */
   protected static ChromeDriver driverAJ;
	
	/** The driverTC. */
   protected static ChromeDriver driverTC;
	
	/** The driverCC. */
   protected static ChromeDriver driverCC;
	
	/** The driver. */
   public static ChromeDriver driver;
	
	/**
	 * Agent driver.
	 *
	 * @param agentName the agent name
	 * @return the chrome driver
	 */
	protected static ChromeDriver agentDriver(String agentName) {
		
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
	    options.addArguments("--window-size=1920,1200");

		switch (agentName) {

		case "alan.jenks":
			driverAJ = new ChromeDriver(options);
			driverAJ.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driverAJ.manage().window().maximize();
			return driverAJ;
		case "tony.cobb":
			driverTC = new ChromeDriver(options);
			driverTC.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driverTC.manage().window().maximize();
			return driverTC;
		case "carlos.clapper":
			driverCC = new ChromeDriver(options);
			driverCC.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driverCC.manage().window().maximize();
			return driverCC;
		default:
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
}
	

	
/*
	protected static void agentInit(String agentName, String agentPassword, ChromeDriver agentDriver) {

		String hostURL = "https://dima1.ssf.bugfocus.com/agentdesktop/";
//	    String hostURL = "https://autotests.ssf.bugfocus.com/agentdesktop/";

		agentDriver.get(hostURL);
		System.out.println("agentDriver.get(hostURL); --> SUCCESS");
		agentDriver.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
		System.out.println("AGENT DESKTOP LOGIN: user name --> SUCCESS");
		agentDriver.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
		System.out.println("AGENT DESKTOP LOGIN: password --> SUCCESS");
		wait(1000);
		System.out.println(Helper.captureScreenshot(agentDriver));

		try {
			agentDriver.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
			System.out.println("Agent " + agentName + " was Logged IN successfully");
		} catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}

		try {
			agentDriver.findElement(By.xpath("//*[@id='b-navigation-item-acl1']")).click(); // activation dial pad
			System.out.println("Agent " + agentName + " activation dial pad was successfully");
		} catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}

		if (agentName.equals("admin")) {
			agentDriver.findElement(By.xpath("//*[@id='b-navigation-item-acl1']")).click(); // activation dial pad
		}

	}// end of agent_init
	*/
	
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
	    options.addArguments("--window-size=1920,1200");
	    
//	    String hostURL = "https://dima1.ssf.bugfocus.com/agentdesktop/";
//	    String hostURL = "https://autotests.ssf.bugfocus.com/agentdesktop/";
	    String hostURL = "https://olgaa.brightpattern.com/agentdesktop/"; //ocean08 NewAD build

		
		switch(agentName) {
		  case "alan.jenks":
			  driverAJ = new ChromeDriver(options);
			  driverAJ.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driverAJ.manage().window().maximize();
			  
			  driverAJ.get(hostURL); 

			  driverAJ.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
			  driverAJ.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password

		  
				try {
					// try to submit
					  driverAJ.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
					System.out.println("AGENT " + agentName + " WAS LOGIN successfully");

				} catch (NoSuchElementException e) {
					
					System.out.println(e.toString());
				}
				
				//*[@id='b-navigation']/div[2]
				//*[@title="Conversations"]
				// /html/body/div[4]/div/div[2]/div/div/div[1]/div[2]/div[2]
				try {
					// try to activation dial pad
					driverAJ.findElement(By.xpath("//*[@title=\"Conversations\"]")).click(); 
					System.out.println("AGENT " + agentName + " has dial pad activation");

				} catch (Exception e) {
					
					System.out.println(agentName + " can't activate dial pad ->>> " + e.toString());
				}
			  
				wait(1000);
				System.out.println(Helper.captureScreenshot(driverAJ));
		    break;
		  case "tony.cobb": 

			  driverTC = new ChromeDriver(options);
			  driverTC.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driverTC.manage().window().maximize();
			  
			  driverTC.get(hostURL);

			  driverTC.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
			  driverTC.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
			  

			  
				try {
					// try to submit
					driverTC.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
					System.out.println("AGENT " + agentName + " WAS LOGIN successfully");

				} catch (NoSuchElementException e) {
					
					System.out.println(e.toString());
				}

				try {
					// try to activation dial pad
					driverTC.findElement(By.xpath("//*[@title=\"Conversations\"]")).click(); 
					System.out.println("AGENT " + agentName + " has dial pad activation");

				} catch (Exception e) {
					
					System.out.println(agentName + " can't activate dial pad ->>> " + e.toString());
				}
		    break;
		  case "carlos.clapper":
			  
			  driverCC = new ChromeDriver(options);
			  driverCC.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driverCC.manage().window().maximize();
			  
			  driverCC.get(hostURL);

			  driverCC.findElement(By.xpath("//*[@id=\"auth-login\"]")).sendKeys(agentName); // AGENT DESKTOP LOGIN: user name
			  driverCC.findElement(By.xpath("//*[@id=\"auth-password\"]")).sendKeys(agentPassword); // AGENT DESKTOP LOGIN: password
			  driverCC.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();
		  
			  try
			  {
				  // try to login
				  driverCC.findElement(By.xpath("//*[@id=\"auth-submit\"]")).click();	
				  System.out.println("AGENT "+agentName+" WAS LOGIN successfully");
				  
			  } catch (NoSuchElementException e) {
				  
				  System.out.println(e.toString());
			  }

//			  driver_cc.findElement(By.xpath("//*[@id=\"b-navigation-item-supervisor\"]/div[1]")).click(); //supervision panel activation
				try {
					// try to activation dial pad
					driverCC.findElement(By.xpath("//*[@title=\"Conversations\"]")).click(); 
					System.out.println("AGENT " + agentName + " has dial pad activation");

				} catch (Exception e) {
					
					System.out.println(agentName + " can't activate dial pad ->>> " + e.toString());
				}
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
					
					System.out.println(e.toString());
				}

				wait(1000);
				System.out.println("screenshot after login --> " + Helper.captureScreenshot(driver));
			  
				try {
					// try to supervision panel activation //*[@id="b-navigation"]/div[11]
					driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div[1]/div[2]/div[11]")).click(); 
					System.out.println("AGENT " + agentName + " has supervision panel activation");

				} catch (Exception e) {
					
					System.out.println("can't activate supervision panel -> "+e.toString());
				}
			  
				wait(1000);
				System.out.println(Helper.captureScreenshot(driver));
				
			  
			  
				try {
					// try to activation dial pad
					driver.findElement(By.xpath("//*[@title=\"Conversations\"]")).click(); 
					System.out.println("AGENT " + agentName + " has dial pad activation");

				} catch (Exception e) {
					
					System.out.println(agentName + " can't activate dial pad ->>> " + e.toString());
				}
			  
				wait(1000);
				System.out.println(Helper.captureScreenshot(driver));
				

		}
}// end of agent_init_original
	
	
  /**
   * Put a phone number in the input field of the agent and call to.
   * 
   * @param agentName enter an agent Name
   * @param calleeNumber enter the phone number
   */	
	protected static void agentCallTo(String agentName, String calleeNumber) {
		String numberFieldXpath = "//*[@id=\"sp-destination\"]";
		String callButtonXpath = "//*[@id=\"dial-toolbar-call\"]/button";

		switch (agentName) {
		case "alan.jenks":
			// input field for enter number, call to calleeNumber
			driverAJ.findElement(By.xpath(numberFieldXpath)).sendKeys(calleeNumber);
			driverAJ.findElement(By.xpath(callButtonXpath)).click(); // initiate call button
			break;
		case "tony.cobb":
			// input field for enter number, call tocalleeNumber
			driverTC.findElement(By.xpath(numberFieldXpath)).sendKeys(calleeNumber);
			driverTC.findElement(By.xpath(callButtonXpath)).click(); // initiate call button
			break;
		case "carlos.clapper":
			// input field for enter number, call tocalleeNumber
			driverCC.findElement(By.xpath(numberFieldXpath)).sendKeys(calleeNumber);
			driverCC.findElement(By.xpath(callButtonXpath)).click(); // initiate call button
			break;
		default:
			driver.findElement(By.xpath(callButtonXpath)).click(); // initiate call button
						
			  try
			  {
				  driver.findElement(By.xpath(numberFieldXpath)).sendKeys(calleeNumber);	
				  System.out.println("AGENT "+ agentName +" ENTER NUMBER of " + calleeNumber);				  
			  } catch (NoSuchElementException e) {			  
				  System.out.println(e.toString() + "AGENT "+ agentName +" ENTER NUMBER of " + calleeNumber + "FAILED!!! !!! !!!");
			  }
			  
			  try
			  {
				  driver.findElement(By.xpath(callButtonXpath)).click(); // initiate call button	
				  System.out.println("AGENT "+ agentName +" CLICK call button FOR " + calleeNumber);				  
			  } catch (NoSuchElementException e) {			  
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
		String endButtonXpath = "//*[@id='cpEndCall']";

		switch (agentName) {
		case "alan.jenks":			
			try 
			  {
				driverAJ.findElement(By.xpath(endButtonXpath)).click(); // button end call	
				  System.out.println("AGENT "+ agentName +" ended the call");		  
			  } catch (NoSuchElementException e) {				  
				  System.out.println(e.toString() + "AGENT "+ agentName +" click END CALL button FAILED!!! !!! !!!");
			  }			
			break;
		case "tony.cobb":			
			try 
			  {
				driverTC.findElement(By.xpath(endButtonXpath)).click(); // button end call
				  System.out.println("AGENT "+ agentName +" ended the call");		  
			  } catch (NoSuchElementException e) {				  
				  System.out.println(e.toString() + "AGENT "+ agentName +" click END CALL button FAILED!!! !!! !!!");
			  }
			break;
		case "carlos.clapper":		
			try 
			  {
				driverCC.findElement(By.xpath(endButtonXpath)).click(); // button end call
				  System.out.println("AGENT "+ agentName +" ended the call");			  
			  } catch (NoSuchElementException e) {				  
				  System.out.println(e.toString() + "AGENT "+ agentName +" click END CALL button FAILED!!! !!! !!!");
			  }
			break;
		default:
			try 
			  {
				driver.findElement(By.xpath(endButtonXpath)).click(); // button end call
				  System.out.println("AGENT "+ agentName +" ended the call");			  
			  } catch (NoSuchElementException e) {				  
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
		String xpathSelect = "//*[@id='cpTransfer']/div";

		switch (agentName) {
		case "alan.jenks":

		    //Wait for element to be Clickable
		    WebDriverWait waitAJ = new WebDriverWait(driverAJ, 15);
		    waitAJ.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));
			System.out.println("Complete Transfer button is clickable for " + agentName);
				
			driverAJ.findElement(By.xpath(xpathSelect)).click(); // "Complete Transfer" button
			break;
		case "tony.cobb":
			driverTC.findElement(By.xpath(xpathSelect)).click(); 
			break;
		case "carlos.clapper":
			driverCC.findElement(By.xpath(xpathSelect)).click(); 
			break;
		default:
			driver.findElement(By.xpath(xpathSelect)).click(); 
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
		String acceptCallButton = "/html/body/div[8]//button[contains(text(),'Accept')]";
		                         
		switch (agentName) {
		case "alan.jenks":
		
			try {
				// try to check ACCEPT CALL
				driverAJ.findElement(By.xpath(acceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "ACCEPT CALL for " + agentName + " was not set");
			}
					
			break;
		case "tony.cobb":		
			try {
				// try to check ACCEPT CALL
				driverTC.findElement(By.xpath(acceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "ACCEPT CALL for " + agentName + " was not set");
			}
			
			break;
		case "carlos.clapper":
			try {
				// try to check ACCEPT CALL
				driverCC.findElement(By.xpath(acceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "ACCEPT CALL for " + agentName + " was not set");
			}
			break;
		default:			
			try {
				// try to check ACCEPT CALL
				driver.findElement(By.xpath(acceptCallButton)).click(); // ACCEPT CALL
				System.out.println("ACCEPT CALL was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
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

			driverAJ.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();
			driverAJ.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();
			driverAJ.quit();
			break;
		case "tony.cobb":

			driverTC.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();
			driverTC.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();
			driverTC.quit();
			break;
		case "carlos.clapper":

			driverCC.findElement(By.xpath("//*[@id=\"top-toolbar-logout\"]")).click();
			driverCC.findElement(By.xpath("//*[@id=\"gwt-debug-cdbOk\"]")).click();
			driverCC.quit();
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
	   * @param serviceName enter service names
	   * @param numberOfServices enter number of services
	   * @return String[][] two-dimensional array of all agents (Customer Alan Jenks, Tony Cobb, User Super ) metrics
	   */
	protected static String[][] getServicesMetrics(String serviceName, int numberOfServices) {
		
		System.out.println("************************ 89 services metrics gathering ******************************");
		int size = 89;
		String[][] metrics = new String[4][size+1]; // create a metrics array
		
		for (int i = 1; i <= size; i++) {// get name fields
			String xpathNames = "//*[@id=\"monServiceTable\"]/div[1]/div[3]/table/thead/tr/th[" + i + "]/div/span";

			try	{metrics[0][i] = driver.findElement(By.xpath(xpathNames)).getText();
			} catch (StaleElementReferenceException e) {System.out.println(e.toString());}

		}

		for (int j = 1; j < 4; j++) {// get value fields for 3 services: Customer Service Chat, Service A, ServiceZen		
			for (int i = 1; i <= size; i++) {
				String xpathValues = "//*[@id=\"monServiceTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]/div/div";
				  try {metrics[j][i] = driver.findElement(By.xpath(xpathValues)).getText();
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

			String xpathNames = "//*[@id=\"monUserTable\"]/div[1]/div[3]/table/thead/tr/th[" + i + "]/div/span";

			try	{agentsMetrics[0][i] = driver.findElement(By.xpath(xpathNames)).getText();
			} catch (StaleElementReferenceException e) {System.out.println(e.toString());}	

		}

		
		for (int j = 1; j <= numberOfAgents; j++) {// get value fields for 3 agents: Alan Jenks, Tony Cobb, User Super 
			for (int i = 4; i <= 3+size; i++) {

				String xpathValues = "//*[@id=\"monUserTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]";
				
				try	{agentsMetrics[j][i] = driver.findElement(By.xpath(xpathValues)).getText();
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

			String xpathMetricsNames = "//*[@id=\"monTeamTable\"]/div[1]/div[3]/table/thead/tr/th["+i+"]/div/span";

			try	{teamsMetrics[0][i] = driver.findElement(By.xpath(xpathMetricsNames)).getText();
			} catch (StaleElementReferenceException e) {System.out.println(e.toString());}

		}
		System.out.println();
//			
		for (int j = 2; j < 4; j++) {// get value fields for 3 teams
			for (int i = 1; i <= size; i++) {

				String xpathMetricsValues =    "//*[@id=\"monTeamTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]";	
				try	{teamsMetrics[j][i] = driver.findElement(By.xpath(xpathMetricsValues)).getText();
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

			String xpathNames = "//*[@id=\"monServiceTable\"]/div[1]/div[3]/table/thead/tr/th[" + i + "]/div/span";
			servicesMetrics[0][i] = driver.findElement(By.xpath(xpathNames)).getText();
			System.out.print(servicesMetrics[0][i] + " ");

		}
		System.out.println();

		for (int j = 1; j < 4; j++) {// get value fields for 3 services: Customer Service Chat, Service A, ServiceZen
			for (int i = 1; i <= 15; i++) {

				String xpathMetricsValues = "//*[@id=\"monServiceTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]";
				servicesMetrics[j][i] = driver.findElement(By.xpath(xpathMetricsValues)).getText();
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
		

		String xpathSelect = "//*[@title='Service Selector']/div";
//		String xpath_select = "/html/body/div[5]/div/div[2]/div/div/div[1]/div[2]/div[1]";
//		String xpath_ServiceA = "/html/body/div[7]/div/div/div/div/table/tbody/tr[2]/td";
		
		String xpathServiceA = "//*[@aria-label='Service A']";
		String serviceNames;

		switch (agentName) {
		case "alan.jenks":
			
		    //Wait for element to be clickable
		    WebDriverWait waitAJ = new WebDriverWait(driverAJ, 15);
		    waitAJ.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));
		    System.out.println("waitng expected conditions");
		    wait(1000);
		    System.out.println("wait(1000)");
			driverAJ.findElement(By.xpath(xpathSelect)).click();
			System.out.println("click by Service Selector");
			driverAJ.findElement(By.xpath(xpathServiceA)).click();
			
			//Thread.sleep(1000);
			
			try {
				// try to check setting of "Service A"
				serviceNames = driverAJ.findElement(By.xpath(xpathSelect)).getText();
				System.out.println(serviceNames + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "Service A for " + agentName + " was not set");
			}
			
			break;
		case "tony.cobb":

		    //Wait for element to be clickable
			
			System.out.println("screenshot inside of method --> " + Helper.captureScreenshot(driverTC));
		    WebDriverWait waitTC = new WebDriverWait(driverTC, 15);
		    waitTC.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));
			
			driverTC.findElement(By.xpath(xpathSelect)).click();
			driverTC.findElement(By.xpath(xpathServiceA)).click();
			
//			Thread.sleep(1000);
			try {
				// // try to check setting of "Service A"
				serviceNames = driverTC.findElement(By.xpath(xpathSelect)).getText();
				System.out.println(serviceNames + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "Service A for " + agentName + " was not set");
			}
			break;
		case "carlos.clapper":
			
		    //Wait for element to be clickable
		    WebDriverWait waitCC = new WebDriverWait(driverCC, 15);
		    waitCC.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));

			driverCC.findElement(By.xpath(xpathSelect)).click();
			driverCC.findElement(By.xpath(xpathServiceA)).click();
			
//			Thread.sleep(1000);
			
			try {
				// // try to check setting of "Service A"
				serviceNames = driverCC.findElement(By.xpath(xpathSelect)).getText();
				System.out.println(serviceNames + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "Service A for " + agentName + " was not set");
			}
			break;
		default:
			
		    //Wait for element to be clickable
		    WebDriverWait wait = new WebDriverWait(driver, 15);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));

			driver.findElement(By.xpath(xpathSelect)).click();
			driver.findElement(By.xpath(xpathServiceA)).click();
			
//			Thread.sleep(1000);
			
			try {
				// try to check setting of "Service A"
				serviceNames = driver.findElement(By.xpath(xpathSelect)).getText();
				System.out.println(serviceNames + " was set succesfully for agent " + agentName);

			} catch (NoSuchElementException e) {
				
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
		
		String xpathSelectStatus ="//*[@id='header-panel']/div"; //*[@id='header-panel']/div
		String xpathReady = "//*[@title='Ready']";
		String xpathSelectReadyStatus = "//*[@id=\"header-panel\"]/div"; // locator for READY status in agent desktop 
		
		String serviceNames;
		String statusNames;

		switch (agentName) {
		case "alan.jenks":

//			System.out.println(agentName + " attempts to set READY");
			driverAJ.findElement(By.xpath(xpathSelectStatus)).click();
//			System.out.println(Helper.captureScreenshot(driverAJ));
			driverAJ.findElement(By.xpath(xpathReady)).click();	
//			System.out.println(Helper.captureScreenshot(driverAJ));			
			try {
				statusNames = driverAJ.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
//				System.out.println("click to STATUS field: " + statusNames);
			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + "agent" + agentName + "status was not changed");
			}
			
			break;
		case "tony.cobb":

			driverTC.findElement(By.xpath(xpathSelectStatus)).click();
			driverTC.findElement(By.xpath(xpathReady)).click();				
			try {				
				statusNames = driverTC.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
//				System.out.println("click to STATUS field: " + statusNames);
			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + "agent" + agentName + "status was not changed");
			}
		
			break;
		case "carlos.clapper":

			driverCC.findElement(By.xpath(xpathSelectStatus)).click();
			driverCC.findElement(By.xpath(xpathReady)).click();	
			try {
				statusNames = driverCC.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
//				System.out.println("click to STATUS field: " + statusNames);
			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + "agent" + agentName + "status was not changed");
			}
			
			break;
		default:

			driver.findElement(By.xpath(xpathSelectStatus)).click();
			driver.findElement(By.xpath(xpathReady)).click();				
			try {
				statusNames = driver.findElement(By.xpath(xpathSelectReadyStatus)).getAttribute("aria-label");
//				System.out.println("click to STATUS field: " + statusNames);
			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + "agent" + agentName + "status was not changed");
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
		String callStatusXpath = "/html/body/div[5]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/div[1]/div/div[10]/div[1]/div[6]";

		switch (agentName) {
		case "alan.jenks":

			try {
				// try to find the calling status element
				String callNoAnswer = driverAJ.findElement(By.xpath(callStatusXpath)).getAttribute("class");
				
				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + "agent" + agentName + "is not calling");
				callContinuing = false;
				return callContinuing;
			}


		case "tony.cobb":

			try {
				// try to find the calling status element
				String callNoAnswer = driverTC.findElement(By.xpath(callStatusXpath)).getAttribute("class");

				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + "agent" + agentName + "is not calling");
				callContinuing = false;
				return callContinuing;
			}

		case "carlos.clapper":

			try {
				// try to find the calling status element
				String callNoAnswer = driverCC.findElement(By.xpath(callStatusXpath)).getAttribute("class");
				
				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + "agent" + agentName + "is not calling");
				callContinuing = false;
				return callContinuing;
			}


		default:

			try {
				// try to find the calling status element
				String callNoAnswer = driver
						.findElement(By.xpath(callStatusXpath))
						.getAttribute("class");

				if (callNoAnswer.equals("b-desk-repeater-ixn-name-label")) {
					callContinuing = true;
					System.out.println("agent " + agentName + " is calling");
				}
				return callContinuing;

			} catch (NoSuchElementException e) {
				
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
		String flagButtonXpath = "//button[@title='Flag the call']";

		switch (agentName) {
		case "alan.jenks":
			try {
				driverAJ.findElement(By.xpath(flagButtonXpath)).click();
				System.out.println("Flag the call check PASSED");
				return true;

			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + " Flag the call check FAILED");
				return false;
			}

		case "tony.cobb":
			try {
				driverTC.findElement(By.xpath(flagButtonXpath)).click();
				System.out.println("Flag the call status PASSED");
				return true;

			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + " Flag the call status FAILED");
				return false;
			}

		case "carlos.clapper":
			try {
				driverCC.findElement(By.xpath(flagButtonXpath)).click();
				System.out.println("Flag the call status PASSED");
				return true;

			} catch (NoSuchElementException e) {
				System.out.println(e.toString() + " Flag the call status FAILED");
				return false;
			}

		default:
			try {
				driver.findElement(By.xpath(flagButtonXpath)).click();
				System.out.println("Flag the call status PASSED");
				return true;

			} catch (NoSuchElementException e) {
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
				driverAJ.findElement(By.xpath("//*[@id=\"cpRetrieve\"]")).click();
				System.out.println("RETRIEVE status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + " RETRIEVE status FAILED");
				return false;
			}

		case "tony.cobb":
			// check retrieve
			try {
				driverTC.findElement(By.xpath("//*[@id=\"cpRetrieve\"]")).click();
				System.out.println("RETRIEVE status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + " RETRIEVE status FAILED");
				return false;
			}

		case "carlos.clapper":
			// check retrieve
			try {
				driverCC.findElement(By.xpath("//*[@id=\"cpRetrieve\"]")).click();
				System.out.println("RETRIEVE status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
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
				driverAJ.findElement(By.xpath("//*[@id='cpHold']/div")).click();
				System.out.println("HOLD status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "HOLD status FAILED");
				return false;
			}

		case "tony.cobb":
			// check hold
			try {
				driverTC.findElement(By.xpath("//*[@id='cpHold']/div")).click();
				System.out.println("HOLD status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "HOLD status FAILED");
				return false;
			}

		case "carlos.clapper":
			// check hold
			try {
				driverCC.findElement(By.xpath("//*[@id='cpHold']/div")).click();
				System.out.println("HOLD status PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
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
				driverAJ.findElement(By.xpath("//span[text()='User Super']")).click();
				System.out.println("contact identification PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "contact identification FAILED");
				return false;
			}

		case "tony.cobb":
			// check contact identification
			try {
				driverTC.findElement(By.xpath("//span[text()='User Super']")).click();
				System.out.println("contact identification PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + "contact identification FAILED");
				return false;
			}

		case "carlos.clapper":
			// check contact identification
			try {
				driverCC.findElement(By.xpath("//span[text()='User Super']")).click();
				System.out.println("contact identification PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
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
				driverAJ.findElement(By.xpath("//div[@title='URL']")).click();
				System.out.println("Popup URL PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + " Popup URL FAILED");
				return false;
			}

		case "tony.cobb":
			// check popup
			try {
				driverTC.findElement(By.xpath("//div[@title='URL']")).click();
				System.out.println("Popup URL PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
				System.out.println(e.toString() + " Popup URL FAILED");
				return false;
			}

		case "carlos.clapper":
			// check popup
			try {
				driverCC.findElement(By.xpath("//div[@title='URL']")).click();
				System.out.println("Popup URL PASSED");
				return true;
			} catch (NoSuchElementException e) {
				
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
		String activityFormXpath = "//div[@title='AF_ServiceA']";

		switch (agentName) {
		case "alan.jenks":
			try {
				driverAJ.findElement(By.xpath(activityFormXpath)).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {				
				System.out.println(e.toString() + " Service Form FAILED");
				return false;
			}

		case "tony.cobb":
			try {
				driverTC.findElement(By.xpath(activityFormXpath)).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {				
				System.out.println(e.toString() + " Service Form FAILED");
				return false;
			}

		case "carlos.clapper":
			try {
				driverCC.findElement(By.xpath(activityFormXpath)).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {				
				System.out.println(e.toString() + " Service Form FAILED");
				return false;
			}

		default:
			try {
				driver.findElement(By.xpath(activityFormXpath)).click();
				System.out.println("Service Form PASSED");
				return true;
			} catch (NoSuchElementException e) {				
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
	   * @param agentName as an agent name
	   * @param calleeNumber as an outcoming number
	   */	
	protected static void agentBlindTransfer(String agentName, String calleeNumber) {
		String initiateXpath = "//button[@id='cpReminder']/following-sibling::button/following-sibling::button";
		String numberFieldXPath = "//*[@id=\"ConfirmDialogBox\"]/div/table/tbody/tr[2]/td[2]/div/div/div/div/div/div/div[2]/input";
		String tansferButtonXpath = "/html/body/div[10]//button[@title='Blind transfer']";

		switch (agentName) {
		case "alan.jenks":
			driverAJ.findElement(By.xpath(initiateXpath)).click(); // initiate transfer button
			driverAJ.findElement(By.xpath(numberFieldXPath)).sendKeys(calleeNumber);
			driverAJ.findElement(By.xpath(tansferButtonXpath)).click(); // blind transfer button
			
			break;
		case "tony.cobb":
			driverTC.findElement(By.xpath(initiateXpath)).click(); // initiate transfer button
			driverTC.findElement(By.xpath(numberFieldXPath)).sendKeys(calleeNumber);
			driverTC.findElement(By.xpath(tansferButtonXpath)).click(); // blind transfer button	
			break;
		case "carlos.clapper":
			driverCC.findElement(By.xpath(initiateXpath)).click(); // initiate transfer button
			driverCC.findElement(By.xpath(numberFieldXPath)).sendKeys(calleeNumber);
			driverCC.findElement(By.xpath(tansferButtonXpath)).click(); // blind transfer button
			break;
		default:
			driver.findElement(By.xpath(initiateXpath)).click(); // initiate transfer button
			driver.findElement(By.xpath(numberFieldXPath)).sendKeys(calleeNumber);
			driver.findElement(By.xpath(tansferButtonXpath)).click(); // blind transfer button
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
		
		String initialTransferButton = "//*[@id=\"contact-panel\"]/div/div/div[1]/div[2]/div/div[1]/div[6]/button[13]";
		String enterNumber = "/html/body/div[10]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div/div[1]/div[2]/input";
		String submitNumber = "//*/div[1]/div/div/div[1]/div[2]/div/div/button/div[@class='b-svg']";

		switch (agentName) {
		case "alan.jenks":
			// Consult call
			driverAJ.findElement(By.xpath(initialTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driverAJ.findElement(By.xpath(enterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driverAJ.findElement(By.xpath(submitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER			
			break;
		case "tony.cobb":
			// Consult call
			driverTC.findElement(By.xpath(initialTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driverTC.findElement(By.xpath(enterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driverTC.findElement(By.xpath(submitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER
			break;
		case "carlos.clapper":
			// Consult call
			driverCC.findElement(By.xpath(initialTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driverCC.findElement(By.xpath(enterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driverCC.findElement(By.xpath(submitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER
			break;
		default:
			// Consult call
			driver.findElement(By.xpath(initialTransferButton)).click(); // INITIAL TRANSFER BUTTON 
			driver.findElement(By.xpath(enterNumber)).sendKeys(calleeNumber); // ENTER NUBER WHEN INITIAL TRANSFER
			driver.findElement(By.xpath(submitNumber)).click(); //INITIAL CALL AFTER ENTERD NUMBER
		}
	}// agentConsultCall	
	
	  /**
	   * Fill out the notes field.
	   * 
	   * @param agentName enter the agent name
	   * @param notes enter a note text
	   */
	protected static void fillOutNotes(String agentName, String notes) {
		String notesFieldXpath = "//*[@id='cp-notes']";

		switch (agentName) {
		case "alan.jenks":
			driverAJ.findElement(By.xpath(notesFieldXpath)).sendKeys(notes); 
			break;
		case "tony.cobb":
			driverTC.findElement(By.xpath(notesFieldXpath)).sendKeys(notes); 	
			break;
		case "carlos.clapper":
			driverCC.findElement(By.xpath(notesFieldXpath)).sendKeys(notes); 
			break;
		default:
			driver.findElement(By.xpath(notesFieldXpath)).sendKeys(notes); 
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
		
	String selectDispositionButton = "//*[@id='gwt-uid-92']"; // SELECT DISPOSITION BUTTON
	String selectDisposition = "/html/body/div[9]/div/div/div/div/table/tbody/tr[3]/td"; // SELECT DISPOSITION (PRODUCT SOLD)	
	String completeDispositionButton = "//*[@id=\"contact-panel\"]/div/div/div[1]/div[5]/div/div[1]/button/div"; // COMPLETE DISPOSITION

		switch (agentName) {
		case "alan.jenks":
			driverAJ.findElement(By.xpath(selectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driverAJ.findElement(By.xpath(selectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driverAJ.findElement(By.xpath(completeDispositionButton)).click(); // COMPLETE DISPOSITION

			break;
		case "tony.cobb":
			driverTC.findElement(By.xpath(selectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driverTC.findElement(By.xpath(selectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driverTC.findElement(By.xpath(completeDispositionButton)).click(); // COMPLETE DISPOSITION
			break;
		case "carlos.clapper":
			driverCC.findElement(By.xpath(selectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driverCC.findElement(By.xpath(selectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driverCC.findElement(By.xpath(completeDispositionButton)).click(); // COMPLETE DISPOSITION
			break;
		default:
			driver.findElement(By.xpath(selectDispositionButton)).click(); // SELECT DISPOSITION BUTTON
			driver.findElement(By.xpath(selectDisposition)).click(); // SELECT DISPOSITION (PRODUCT SOLD)		                                
			driver.findElement(By.xpath(completeDispositionButton)).click(); // COMPLETE DISPOSITION
		}
	}// end of selectDisposition	

	  /**
  	 * Waiting time for scenario steps.
  	 *
  	 * @param t ms waiting time
  	 */
	protected static void wait(int t) {
		try {Thread.sleep(t);} catch (InterruptedException e) {e.printStackTrace();} // t ms waiting time
	}
	
	  /**
  	 * Print metrics in console.
  	 *
  	 * @param metricsArray enter the metric array  name
  	 */
	protected static void printOutMetrics(String[][] metricsArray) {
	
		System.out.println("************ mettrics *************");
		System.out.println(Arrays.deepToString(metricsArray)); 
	}
	

	
	
	/**
	 * Set scenario counter result to metric. Used as expected result.
	 *
	 * @param metricValueBefore the metric value before
	 * @param delta the delta
	 * @return the string as expected result
	 */
	protected static String parseStringExpectation(String metricValueBefore, int delta) {
		if(metricValueBefore != null) {
			int i = Integer.parseInt(metricValueBefore); // String to int
			String metricValueAfter = String.valueOf(i + delta); // int to String
			return metricValueAfter;			
		}else {
			return "0";
		}

	}
	
	  /**
  	 * Set scenario timer result to metric. Used as expected result.
  	 *
  	 * @param strTime as before scenario interaction
  	 * @param expectedSec as delta between strTime and expected result
  	 * @return the string
  	 */	
    public static String parseTimeExpectation(String strTime, int expectedSec) {

        String timeAfter;
        DateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Date d = null;
		try {d = dateFormat.parse(strTime);} catch (ParseException e) {e.printStackTrace();}
		
        int min = d.getMinutes();
        int sec = d.getSeconds();

        String timeBefore = min + ":"+ sec;

        if((expectedSec+sec)>60) {
     	   min = min + 1;
     	   sec = (expectedSec + sec) - 60;
        }else {
     	   sec =  sec + expectedSec;
        }
        if (sec<10) {
     	   timeAfter = "0" + min + ":0" + sec;
     	   }else {
         	   timeAfter = "0" + min + ":"+ sec;
     	   }
        
        return timeAfter;
        
     }
	
    
	  /**
  	 * Set deviation for time value.
  	 *
  	 * @param actualTime String variable
  	 * @param expectedTime String variable
  	 * @param deviation in seconds
  	 * @return true, if successful
  	 */	
  public static boolean timeDeviation(String actualTime, String expectedTime, int deviation) {

      boolean timeAfterDeviation;
      DateFormat dateFormat = new SimpleDateFormat("mm:ss");
      Date d = null;
      
	  try {d = dateFormat.parse(actualTime);} catch (ParseException e) {e.printStackTrace();}		
      int minActual = d.getMinutes();
      int secActual = d.getSeconds();

	  try {d = dateFormat.parse(expectedTime);} catch (ParseException e) {e.printStackTrace();}		
      int minExpected = d.getMinutes();
      int secExpected = d.getSeconds();

      
      if (Math.abs(secActual-secExpected) <= deviation) {
    	  timeAfterDeviation = true;
      }else {
    	  timeAfterDeviation = false;
      }


      
      return timeAfterDeviation;
      
   }
    
	  /**
  	 * Divide Time By Number.
  	 *
  	 * @param strTime as before dividing
  	 * @param number as number by
  	 * @return the string
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
   * Addition Time in String.
   *
   * @param firstTime the first time
   * @param secondTime the second time
   * @return the string
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

/**
 * Verify expected and actual result by assertion (no null exception).
 *
 * @param expected the expected result
 * @param actual the actual result
 */
public static void assertNotNull(String expected, String actual) {
	
	if(expected != null && actual != null) {
		Assert.assertEquals(actual, expected);
	} else {
		if (actual != null) {
			Assert.assertEquals(actual, actual);			
		} else {
			Assert.assertEquals(expected, expected);
		}
	}
	
}

/**
 * Verify expected and actual result by not null
 *
 * @param expected the expected result
 * @param actual the actual result
 */
public static boolean checkNotNull(String expected, String actual) {
	if(expected != null && actual != null) {
		return true;
	} else {
	return false;
	}
}

	
}// end of class API

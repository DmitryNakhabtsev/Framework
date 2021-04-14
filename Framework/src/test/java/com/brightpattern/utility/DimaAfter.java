package com.brightpattern.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public class DimaAfter extends API{
	
	public void dimaInteraction() { // afterInteraction ========================================================================================================================================

//		agentInit("admin", "password");
		
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();} // 200 ms waiting time
		agentInit("alan.jenks", "password");
		setServiceToAgent("alan.jenks");
		setReadyToAgent("alan.jenks");
		
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();} // 200 ms waiting time
		agentInit("tony.cobb", "password");
		setServiceToAgent("tony.cobb");
		setReadyToAgent("tony.cobb");

/************************ test case body ******************************/
		
		agentCallTo("admin", "8003");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();} // 2000 ms waiting time
		agentCallAnswer("alan.jenks");  
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();} // 2000 ms waiting time // CONVERSATIOIN TIME
		
		agentBlindTransfer("alan.jenks", "2023");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();} // 2000 ms waiting time// CALLING TIME
		agentCallAnswer("tony.cobb");
		try {Thread.sleep(120000);} catch (InterruptedException e) {e.printStackTrace();} // 2min waiting time// CALLING TIME		
		
		checkActivityForm("tony.cobb");
		checkPopup("tony.cobb");
		checkContactIdentification("tony.cobb");
		checkHoldButton("tony.cobb");
		checkRetrieveButton("tony.cobb");
		checkFlag("tony.cobb");

		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();} // 1000 ms waiting time // CALLING TIME
		
		agentEndCall("admin");
		System.out.println("admin ended service call");
	
		fillOutNotes("alan.jenks", "BrightPattern is the Best!");
		System.out.println("BrightPattern is the Best! was filled out to notes!!!!!!!!!");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();} // 2000 ms waiting time
		selectDisposition("alan.jenks");
		
		fillOutNotes("tony.cobb", "Anatol Dialer is the Best!!!");
		System.out.println("Anatol Dialer is the Best!!! was filled out to notes!!!!!!!!!");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();} // 2000 ms waiting time	
		selectDisposition("tony.cobb");
		
		agentLogOut("alan.jenks");
		agentLogOut("tony.cobb");
	} // ==== end dimaInteraction ======================================================================================	
	

	
	public void olgaInteraction() { // olgaInteraction ==================================================================
		
		String agent1 = "alan.jenks";
		String agent2 = "tony.cobb";
		String admin = "admin";
		String pwd = "password";

		int callDuration = 3000; // 10 sec for every conversation
		int action = 1000; 
		
		wait(200);
		agentInit(agent1, pwd);
		wait(200);
		setServiceToAgent(agent1);
		
		wait(200);
		agentInit(agent2, pwd);
		wait(200);
		setServiceToAgent(agent2);

/************************ scenario body ******************************/
		
		agentCallTo(admin, "8003");             //Customer calls to Scenario (ServiceA)
		wait(action); 							// 10sec Customer listens to IVR prompt 
		wait(action); 							// 10sec Customer waits in Q for 10 seconds  		
		setReadyToAgent(agent1);                // Agent1 set himself as Ready
		wait(action); 							// Call is routed to Agent and call is in Ringing state for 10 seconds 
	
		agentCallAnswer(agent1);                // Agent1 accepts the call 
		wait(callDuration+callDuration);  		// Agent1 talks to Customer for 2*callDuration seconds
		checkHoldButton(agent1); 
		wait(action);  							//Agent1 puts call on Hold for 10 seconds

		agentConsultCall(agent1, "2023");       // Agent1 takes consult call from Hold 		
		wait(action);  							// In 10 seconds Agent1 places a consult call to Agent2
		agentCallAnswer(agent2);				// Agent2 answered to Agent1
		wait(action);  							// Agent1 and Agent2 talks for 10 seconds	
		
		agentCompleteTransfer(agent1);          // "Complete Transfer" button
		wait(3*callDuration);  					// Agent1 talks to Customer for 3*callDuration seconds
		
		checkHoldButton(agent2); 
		wait(action);  							// Agent2 puts call on hold for 10 seconds	
		checkRetrieveButton(agent2); 			// Agent2 takes call from Hold
		
		wait(4*callDuration);  					// Agent1 talks to Customer for 4*callDuration seconds 
		
		agentEndCall(admin);                    // Customer hangs up the call
		
		wait(action);  							// Agent2 sets up disposition and completes interaction in 10 seconds
		selectDisposition(agent2);
		selectDisposition(agent1);
	
		agentLogOut(agent1);
		agentLogOut(agent2);
		
	} // olgaInteraction ==================================================================================================	

	
	/************************ 89 services metrics gathering ******************************/
	
	public String[][] servicesMetrics89() { 
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

			System.out.println("************************ 89 services metrics gathering ******************************");

		}
		
		return metrics;
	} // servicesMetrics89 ========================================================================================================================================
	
	
	/************************ metrics gathering ******************************/
	
/*	
	
	public String[][] servicesMetricsAfter() { 
		
		String[][] servicesMetricsAfter = new String[4][16]; // create a two-dimensional array
		
		for (int i = 1; i <= 15; i++) {// get fields names
		
			String xpath_names = "//*[@id=\"monServiceTable\"]/div[1]/div[3]/table/thead/tr/th[" + i + "]/div/span";
			servicesMetricsAfter[0][i] = driver.findElement(By.xpath(xpath_names)).getText();
			System.out.print(servicesMetricsAfter[0][i] + " ");
		
		}
		System.out.println();
		
		try {Thread.sleep(18000);} catch (InterruptedException e) {e.printStackTrace();} // 18000 ms waiting time for dash board refreshing

		for (int j = 1; j < 4; j++) {// get value fields for 3 services: Customer Service Chat, Service A, ServiceZen
			for (int i = 1; i <= 15; i++) {

				String xpath_values = "//*[@id=\"monServiceTable\"]/div[3]/div/div[1]/div/div/table/tbody/tr[" + j + "]/td[" + i + "]";
				servicesMetricsAfter[j][i] = driver.findElement(By.xpath(xpath_values)).getText();
				System.out.print(servicesMetricsAfter[j][i] + " ");

			}
			System.out.println();
		}
		return servicesMetricsAfter;
	} // servicesMetricsAfter ========================================================================================================================================	

*/

}

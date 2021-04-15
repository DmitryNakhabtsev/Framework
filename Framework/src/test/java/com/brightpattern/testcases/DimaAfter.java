package com.brightpattern.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public class DimaAfter extends API{

	public void olgaInteraction() { // olgaInteraction ==================================================================
		
		String agent1 = "alan.jenks";
		String agent2 = "tony.cobb";
		String admin = "admin";
		String pwd = "password";

		int callDuration = 3000; // 10 sec for every conversation
		int action = 1000; 
		
		agentInit(agent1, pwd);
		setServiceToAgent(agent1);
		
		agentInit(agent2, pwd);
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



}

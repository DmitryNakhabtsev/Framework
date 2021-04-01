package com.brightpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	// this is agent initialization
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}

	@FindBy(xpath = "//*[@id=\"auth-login\"]") WebElement uname;
	
	@FindBy(xpath = "//*[@id=\"auth-password\"]") WebElement pass;
	
	@FindBy(xpath = "//*[@id=\"auth-submit\"]") WebElement loginButton;
	
public void loginToAD(String userName, String password) {
	
	uname.sendKeys(userName);
	pass.sendKeys(password);
	loginButton.click();
	
}
	
}

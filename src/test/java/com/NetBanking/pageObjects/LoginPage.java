package com.NetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordele;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBtn;
	
	// Action Methods
	
	public void setUsername(String username) {
		userName.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordele.sendKeys(password);
	}
	public void clickLogin() {
		loginBtn.click();
	}

}

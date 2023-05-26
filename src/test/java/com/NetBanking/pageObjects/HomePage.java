package com.NetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Account']")
	WebElement newAccountBtn;
	
	public void clickNewAccountBarOption() {
		newAccountBtn.click();
	}
}

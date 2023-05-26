package com.NetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAccount {
	WebDriver driver;
	public AddAccount(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement newCustomerID;
	
	@FindBy(xpath="//select[@name='selaccount']")
	WebElement newAccountTypeDropdown;
	
	@FindBy(xpath="//option[@value='Current']")
	WebElement newAccountType;
	
	@FindBy(xpath="//input[@name='inideposit']")
	WebElement initialDeposit;
	
	@FindBy(xpath="//input[@name='button2']")
	WebElement clickSubmitBtn;
	
	
	public void setCustomerId(String newAccId) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newCustomerID.sendKeys(newAccId);
	}
	
	public void setAccType() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newAccountTypeDropdown.click();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newAccountType.click();
	}
	public void setInitialDeposit() {
		initialDeposit.sendKeys("10000");
	}
	public void cliclSubmit() {
		clickSubmitBtn.click();
	}
}

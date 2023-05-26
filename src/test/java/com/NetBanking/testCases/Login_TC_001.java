package com.NetBanking.testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NetBanking.pageObjects.AddAccount;
import com.NetBanking.pageObjects.HomePage;
import com.NetBanking.pageObjects.LoginPage;

public class Login_TC_001 extends BaseTest{
	
	@Test
	public void LoginValidation() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickLogin();
		Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", driver.findElement(By.xpath("//marquee[@class='heading3']")).getText());
		
	}
	


	
	@Test(dependsOnMethods ={"LoginValidation"})
	public void addaccount() {
		HomePage hp = new HomePage(driver);
		
		hp.clickNewAccountBarOption();
		AddAccount addacc = new AddAccount(driver);
		addacc.setCustomerId(customerID);
		addacc.setAccType();
		addacc.setInitialDeposit();
		addacc.cliclSubmit();
		Assert.assertTrue(false);
	}


}


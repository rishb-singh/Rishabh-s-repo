package com.NetBanking.testCases;

import org.testng.annotations.Test;

import com.NetBanking.pageObjects.AddAccount;
import com.NetBanking.pageObjects.HomePage;
import com.NetBanking.pageObjects.LoginPage;

public class AddNewAccount extends BaseTest {
	
	@Test()
	public void addaccount() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickLogin();
		HomePage hp = new HomePage(driver);
		hp.clickNewAccountBarOption();
		AddAccount addacc = new AddAccount(driver);
		addacc.setCustomerId(customerID);
		addacc.setAccType();
		addacc.setInitialDeposit();
		addacc.cliclSubmit();
	}

}


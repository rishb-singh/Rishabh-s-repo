package com.NetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.NetBanking.utilities.ReadConfig;
import com.NetBanking.utilities.Reporting;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	ReadConfig rc = new ReadConfig();
	

	public WebDriver driver;
	String baseURL = rc.getURL();
	String userName = rc.getUsername();
	String wrongUsername = rc.getWrongUsername();
	String password = rc.getPassword();
	
	// add account variables
	String customerID = "1234567890";

	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) {

		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();

		
	}

	
	public void tearDown() {

		driver.quit();
	}

	public String takeScreenshot(String testCaseName) {
		


		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

         // Specify the path and filename for the screenshot
		 String screenshotPath = System.getProperty("user.dir") + "//Screenshots//"+testCaseName+ ".png";
         File destinationFile = new File(screenshotPath);

         // Copy the screenshot file to the specified location
         try {
			FileUtils.copyFile(screenshotFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         return screenshotPath;
		
	}
}










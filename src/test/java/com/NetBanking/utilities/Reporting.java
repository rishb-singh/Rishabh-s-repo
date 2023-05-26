package com.NetBanking.utilities;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.NetBanking.testCases.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends BaseTest implements ITestListener {


	ExtentReports extent;
	ExtentTest test;

	  public void onTestStart(ITestResult result) {
	        System.out.println("Test Started: " + result.getName());

	        String timestamp = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss").format(new Date());
	        String reportName = result.getMethod().getMethodName() + "_" + timestamp;

	        // Specify the path and filename for the report
	        String path = System.getProperty("user.dir") + "\\reports\\" + reportName + ".html";

	        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	        reporter.config().setTheme(Theme.STANDARD);
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, "Test Got Failed");
		
		String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshotPath, "Failed screen");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}

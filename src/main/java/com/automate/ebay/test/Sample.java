package com.automate.ebay.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Sample {
	ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;
	 
	@Test
	public void verifyBlogTitle()
	{
	report=new ExtentReports("D:\\workSpaceWip\\EbayWip\\Screen-Shots\\LearnAutomation.html", true); 
	logger=report.startTest("VerifyBlogTitle");
	report.endTest(logger);
	report.flush();
	}
	
}

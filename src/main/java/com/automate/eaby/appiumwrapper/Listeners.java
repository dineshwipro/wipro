package com.automate.eaby.appiumwrapper;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Listeners implements ITestListener
{
	public AppiumDriver driver;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestSuccess(ITestResult result) {
	/*	try {
			Robot rob=new Robot();
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img=rob.createScreenCapture(screenRect);
			ImageIO.write(img, "jpg", new File(".\\Screen-Shots\\"+"screenshot_failed"+System.currentTimeMillis()+".jpg"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	public void onTestFailure(ITestResult result) {
		try {
			Robot rob=new Robot();
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img=rob.createScreenCapture(screenRect);
			ImageIO.write(img, "jpg", new File(".\\Screen-Shots\\"+"screenshot_failed"+System.currentTimeMillis()+".jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void onTestSkipped(ITestResult result) {
		try {
			Robot rob=new Robot();
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img=rob.createScreenCapture(screenRect);
			ImageIO.write(img, "jpg", new File(".\\Screen-Shots\\"+"screenshot_failed"+System.currentTimeMillis()+".jpg"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}

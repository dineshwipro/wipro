package com.automate.eaby.appiumwrapper;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class Genericclass 
{
	public static  AppiumDriver driver;
	
	//To read the values from property file
	public static String readDataFromProperityFile(String value){
		
		Properties prop = null;
		try {			 
			 FileInputStream fileInput = new FileInputStream(new File("./resources/Config.properities"));  
			 prop = new Properties();  
			  prop.load(fileInput);
			  
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		return prop.getProperty(value);
	}
	
	//to take the screenshot
	public static String takeScreenShot(ITestResult result){
		
		String scrPath="D://workSpaceWip//EbayWip//Screen-Shots//"+"screenshot_"+System.currentTimeMillis()+".jpg";
		try {
		  	TakesScreenshot ts=(TakesScreenshot)driver;	   
		  	File source=ts.getScreenshotAs(OutputType.FILE);	   
		  	FileUtils.copyFile(source, new File("./Failed--Screenshots/"+result.getName()+".png"));	   
		  	System.out.println("Screenshot taken");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return scrPath;
		
	}

	//Taking screenshot and returning taken screenshot 
		public String takeSnapShot1(MobileDriver mobiledriver, String fileWithPath) throws IOException 
		{
			//To convert mobile driver object to TakeScreenshot
			TakesScreenshot scrShot = ((TakesScreenshot)mobiledriver);
			//call getScreenshotAs method to create image file
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			File DestFile = new File(fileWithPath);
			//copy file at destination
			FileUtils.copyFile(ScrFile, DestFile);
			return fileWithPath;
		}
	

}

package com.automate.eaby.appiumwrapper;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.read.biff.BiffException;

/***
 * <h1>AppiumBase</h1>
 * <p>
 * <b>Description:</b>RemoteWebDriverURL Driver initialisation and setting of capabilities 
 *
 * @author Dinesh B M
 * @version 
 * @since 19/7/2018
 */
	@Listeners(com.automate.eaby.appiumwrapper.Listeners.class)
	public class AppiumBase {
		String userDirPath = System.getProperty("user.dir");
		public AppiumDriver driver = null;
		public ExtentReports extent;
		public static ExtentReports report;
		public static String reportPath;
		public static String filepath = "./ExtentReports/" + "reports_" + System.currentTimeMillis() + ".html";
		
		@BeforeSuite
		public static ExtentReports launch() throws IOException 
		{		
			reportPath = Genericclass.readDataFromProperityFile("Reports_Path");
			//filepath = reportPath + "reports_" + System.currentTimeMillis() + ".html";
			report = new ExtentReports(filepath, true);
			Reporter.log("Before Suite is executed successfully", true);
			return report;
		}
		
		/*
		 * Method to intantiate the RemoteWebDriverURL driver and setting of capabilities
		 * 
		 * @return Returns the Driver with the capabilities set as per the parameters passed.
		 * 
		 * @exception Exception on any error
		 */	
		@BeforeMethod(alwaysRun = true)
		public void startBrowser() throws BiffException, IOException {
			extent = new ExtentReports(filepath, false);
			//Getting Platform to be executed from property file 
			String browserName = Genericclass.readDataFromProperityFile("Platform");
			//if the platform is Android
			if (browserName.equalsIgnoreCase("android")) {
				ExcelSheetLib1 excel = new ExcelSheetLib1(userDirPath+"/src/Ebay.xls", "Capabilities");
				
				// Setting up desired capabilities and pass the Android app-activity and
				// app-package to Appium
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("unicodeKeyboard", excel.ReadCell(excel.GetCell("UniCodeKeyboard"),1));
				capabilities.setCapability(MobileCapabilityType.VERSION, excel.ReadCell(excel.GetCell("VERSION"),1));
				capabilities.setCapability(MobileCapabilityType.PLATFORM, excel.ReadCell(excel.GetCell("PLATFORM"),1));
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, excel.ReadCell(excel.GetCell("DeviceName"),1));
				capabilities.setCapability(MobileCapabilityType.UDID, excel.ReadCell(excel.GetCell("UDID"),1));
				
				// The package name of the app and activity name
				capabilities.setCapability("appPackage", excel.ReadCell(excel.GetCell("AppPackage"),1));
				capabilities.setCapability("appActivity", excel.ReadCell(excel.GetCell("AppActivity"),1));
				
				// Create RemoteWebDriver instance and connect to the Appium server.
				driver = new AndroidDriver(new URL(excel.ReadCell(excel.GetCell("Url"),1)), capabilities);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//if the platform is iOS
				//All the cablilites are empty becuase currenlty not working on ios
			} else if (browserName.equalsIgnoreCase("ios")) {

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
				capabilities.setCapability(MobileCapabilityType.VERSION, "");
				capabilities.setCapability(MobileCapabilityType.PLATFORM, "");
				capabilities.setCapability("deviceName", "");
				capabilities.setCapability("platformName", "");
				capabilities.setCapability("appPackage", "");
				capabilities.setCapability("appActivity", "");

				// Create RemoteWebDriver instance and connect to the Appium server.
				driver = new AndroidDriver(new URL(""), capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}
		/*Killing driver after class*/
		@AfterClass
		public void closeBrowser() {
			if (driver!= null) {
				driver.quit();
			}
		}

}

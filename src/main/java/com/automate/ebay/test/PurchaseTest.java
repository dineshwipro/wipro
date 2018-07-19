package com.automate.ebay.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automate.eaby.appiumwrapper.AppiumBase;
import com.automate.eaby.appiumwrapper.ExcelSheetLib1;
import com.automate.eaby.appiumwrapper.Genericclass;
import com.automate.ebay.pageobjects.LoginPageObject;
import com.automate.ebay.pageobjects.SearchAndPurchasePageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileDriver;

/***
 * <h1>PurchaseTest</h1>
 * <p>
 * <b>Description:</b> Device related Test cases to seaech and purchase an Item
 *
 * @author Dinesh B M
 * @version 
 * @since 19/7/2018
 */

public class PurchaseTest extends AppiumBase{

	ExtentTest logger;
	String userDirPath = System.getProperty("user.dir");	
		
	/***
	 * @TestName toVerifyPurchasingAnItem
	 * @TestDescription Launching ebay app and login with valid credentials then search and purchase an item
	 */
	@Test(groups={"Positive","Smoke","UAT"})
	  public void toVerifyPurchasingAnItem() throws Exception 
	  {	
		try{			
			String tcName = Thread.currentThread().getStackTrace()[1].getMethodName();
			logger=extent.startTest("PurchaseTest-"+tcName+"", "To verify successful Purchase");
			ExcelSheetLib1 excel = new ExcelSheetLib1(userDirPath+"/src/Ebay.xls", "Login");
			logger.log(LogStatus.INFO, "Fetched successfully username and password from Excelsheet");
		  	LoginPageObject login = new LoginPageObject(driver);
		  	login.loginToApp(excel.ReadCell(excel.GetCell("UserName"),1), excel.ReadCell(excel.GetCell("Password"),1));
		  	logger.log(LogStatus.INFO, "Successfully logged into the app with valid");
		  	
		  	ExcelSheetLib1 excel1 = new ExcelSheetLib1(userDirPath+"/src/Ebay.xls", "ItemName");
		  	logger.log(LogStatus.INFO, "Fetched successfully a item from Excelsheet");
		  	SearchAndPurchasePageObject purchase = new SearchAndPurchasePageObject(driver);
		  	purchase.searchAndPurchaseAnItem(excel1.ReadCell(excel.GetCell("Item"),1));
		  	logger.log(LogStatus.INFO, "Successfully searched and purchased a given item ");
		  	
		}catch(Exception e){
				//Taking and atatching screenshot in the report
				logger.log(LogStatus.FAIL, ExceptionUtils.getStackTrace(e));
				Genericclass gen = new Genericclass();
				String img=logger.addScreenCapture(gen.takeSnapShot1((MobileDriver) driver, userDirPath+"/Screenshots/failed.png"));
				logger.log(LogStatus.INFO, "Failure Screenshot Taken",img);
				throw new Exception("Exception : " + e.getMessage());
		}
	  }
	
	//This method is to take failed screenshots after every testcase
	@AfterMethod(alwaysRun=true)
	public void endtest(ITestResult result) throws IOException
		{
			  if(driver!=null)
			  {
				  if(ITestResult.FAILURE==result.getStatus())
				  	{
					  	//Taking screenshots when testcase is failed
					  	TakesScreenshot ts=(TakesScreenshot)driver;	   
					  	File source=ts.getScreenshotAs(OutputType.FILE);	   
					  	FileUtils.copyFile(source, new File("./FailedScreenshots/"+result.getName()+".png"));	
					  	logger.log(LogStatus.INFO, "Successfully taken failed screenshot");
					  	System.out.println("Screenshot taken");
				  	}
		  		 driver.quit();
		  	  extent.endTest(logger);
		  	  extent.flush();
			  }
		  }
}

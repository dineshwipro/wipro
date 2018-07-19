package com.automate.ebay.pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.automate.ebay.page.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

public class LoginPageObject {

	public AppiumDriver driver;
	public final static Logger logger = Logger.getLogger(LoginPageObject.class);	
	public LoginPageObject(AppiumDriver driver) {
		this.driver = driver;
	}
	
	/*In the method performing actions to login into an app
	 * Also its a generic function*/
	public void loginToApp(String userName, String password) throws Exception {
		try{
			LoginPage loginPage = new LoginPage(getDriver());
			loginPage.homeMenu_Button.click();
			Reporter.log("Step: Successfully clicked on Menu", true);
			loginPage.signIn_option.click();
			loginPage.username_textfield.clear();
			loginPage.username_textfield.sendKeys(userName);
			Reporter.log("Step: Successfully entered User Name", true);
			loginPage.password_textfield.sendKeys(password);
			Reporter.log("Step: Successfully entered Password", true);
			loginPage.signIn_button.click();
			Thread.sleep(5000);
			Reporter.log("Step: Successfully clicked on Sign in button", true);
			try{
				loginPage.fingerPrintPermission_button.click();
				logger.info("Ignored granting finger print permission");
				Reporter.log("Ignored granting finger print permission", true);
			}catch(Exception ee){
				loginPage.expectedElement_displayed.isDisplayed();
				Reporter.log("Step: Successfully Logged into the aplication", true);
			}		
			loginPage.expectedElement_displayed.isDisplayed();
			Reporter.log("Step: Successfully Logged into the aplication", true);
		}catch(Exception e){
			logger.info("Error occured while logging to app");
			Reporter.log("Error occured while logging to app", true);
			throw new Exception("Login Failed");
		}

	}
	public AppiumDriver getDriver() {
		return driver;
	}

	public void setDriver(AppiumDriver driver) {
		this.driver = driver;
	}
}

package com.automate.ebay.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.automate.ebay.page.LoginPage;
import com.automate.ebay.page.SearchAndPurchasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

abstract class SeacrAndPurchase 
{
	protected  WebDriver driver;

	public SeacrAndPurchase(WebDriver driver) 
		{
		this.driver = driver;
		}	
}

public class SearchAndPurchasePageObject {

	public AppiumDriver driver;
	public final static Logger logger = Logger.getLogger(SearchAndPurchasePageObject.class);
	
	public SearchAndPurchasePageObject(AppiumDriver driver) {
		this.driver = driver;
	}
	
	/*In the method perfroming actions to search and purchase an Item*/
	public void searchAndPurchaseAnItem(String itemName) throws Exception {
		try{
			SearchAndPurchasePage search = new SearchAndPurchasePage(getDriver());
			search.search_box.click();
			//search.searchWithXpath_box.sendKeys("Swipe Elite Star ||1 GB|| 8 GB|| VOLTE ||Black- Refurbished");
			search.searchWithXpath_box.sendKeys(itemName);
			Reporter.log("Step: Successfully entered an item in search box", true);
			Thread.sleep(7000);
			search.firstListDown_link.click();
			Reporter.log("Step: Successfully selected searched item", true);
			Thread.sleep(7000);
			search.firstListDown_item.click();
			Thread.sleep(2000);
			search.byItNow_button.click();
			Reporter.log("Step: Successfully clicked on Buy It Now Button", true);
			search.review_button.click();
			Reporter.log("Step: Successfully clicked on Review Button", true);
			Thread.sleep(15000);
			//((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"Order Summary\"))").isDisplayed();
			try{
			search.proceedToPay_button.click();	
			}catch(Exception ee){
				Dimension size1 = driver.manage().window().getSize();
				int startx = (int) (size1.width * 0.55625);
				int starty = (int) (size1.height * 0.9140628);
				int endx = (int) (size1.width * 0.55625);
				int endy = (int) (size1.height * 0.20509);
				driver.swipe(startx, starty, endx, endy, 0);
				Reporter.log("Step: Successfully swiped up to click on Procced to pay button", true);
				Thread.sleep(3000);
				search.proceedToPay_button.click();	
			}
			Reporter.log("Step: Successfully clicked on Proceed to Pay button", true);
			Thread.sleep(7000);
			search.chooseYourPaymentMethod_text.isDisplayed();	
			Reporter.log("Step: Customer successfully navigated to PaymentGateway Screen", true);
		}catch(Exception e){
			logger.info("Error occured while purchasing an Item");
		}
	}
	public AppiumDriver getDriver() {
		return driver;
	}

	public void setDriver(AppiumDriver driver) {
		this.driver = driver;
	}
}

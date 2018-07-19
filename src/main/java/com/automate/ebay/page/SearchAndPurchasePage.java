package com.automate.ebay.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;

public class SearchAndPurchasePage 
{
	public SearchAndPurchasePage(AppiumDriver<WebElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/*Intializing all web elements required for to search and purchase*/ 
	@WithTimeout(time  = 20, unit = TimeUnit.SECONDS)
	@AndroidFindBy(xpath = "//android.view.View[@text='Choose your payment method']")
	public WebElement chooseYourPaymentMethod_text ;
	@AndroidFindBy(id="com.ebay.mobile:id/search_box")
	public  WebElement search_box;
	@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
	public  WebElement searchWithXpath_box;
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/text') and @index=0]")
	public  WebElement firstListDown_link;
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[contains(@resource-id,'com.ebay.mobile:id/cell_collection_item') and @index=0]")
	public  WebElement firstListDown_item;
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@index=3]/android.widget.RelativeLayout[@index=0]/android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/textview_item_title') and @index=0]")
	public  WebElement firstListDown_titlename;
	@AndroidFindBy(id="com.ebay.mobile:id/button_bin")
	public  WebElement byItNow_button;
	@AndroidFindBy(id="com.ebay.mobile:id/take_action")
	public  WebElement review_button;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Proceed to Pay']")
	public  WebElement proceedToPay_button;
}

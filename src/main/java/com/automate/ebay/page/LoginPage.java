package com.automate.ebay.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;

public class LoginPage {

	public LoginPage(AppiumDriver<WebElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/*Intializing all web elements required for to Login app*/ 
	@WithTimeout(time  = 20, unit = TimeUnit.SECONDS)
	@AndroidFindBy(id = "com.ebay.mobile:id/search_box")
	public WebElement expectedElement_displayed ;
	@AndroidFindBy(id="com.ebay.mobile:id/home")
	public  WebElement homeMenu_Button;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='SIGN IN']")
	public  WebElement signIn_option;
	@AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
	public  WebElement username_textfield;
	@AndroidFindBy(id="com.ebay.mobile:id/edit_text_password")
	public  WebElement password_textfield;
	@AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
	public  WebElement signIn_button;
	@AndroidFindBy(xpath="//android.widget.Button[@text='MAYBE LATER']")
	public  WebElement fingerPrintPermission_button;
}

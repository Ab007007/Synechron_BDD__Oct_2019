package com.synechron.bdd.actitime.pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LoginPage 
{
	public static final String LOGIN_PAGE_TITLE = "actiTIME - Login";
	
	
	@FindBy(id = "username")
	WebElement userNameTextBox;
	
	@FindBy(name = "pwd")
	WebElement passwordTextBox;
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	public void enterUserName(String name)
	{
		System.out.println("Entering user name : " + name);
		userNameTextBox.sendKeys(name);
	}

	public void enterPassword(String name)
	{
		System.out.println("Entering Password : " + name);
		passwordTextBox.sendKeys(name);
	}
	
	public void clickOnLoginButton() 
	{
		System.out.println("Clicking on login Button");
		loginButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loginToActiTime(String un,String pwd)
	{
		enterUserName(un);
		enterPassword(pwd);
		clickOnLoginButton();
	}
	
	
	public LoginPage(WebDriver driver) 
	{
		System.out.println("Calling Login Page constructor to initialize the Page Objects...");
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginTitle(String actualTitle) {
		
		Assert.assertEquals(LOGIN_PAGE_TITLE, actualTitle);
	}
}

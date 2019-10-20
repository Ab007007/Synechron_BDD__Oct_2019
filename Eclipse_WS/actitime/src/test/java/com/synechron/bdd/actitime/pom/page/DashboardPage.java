package com.synechron.bdd.actitime.pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class DashboardPage 
{

	public static final String DASHBOARD_PAGE_TITLE = "actiTIME - Enter Time-Track";
	
	@FindBy(xpath = "//a[div[text()='TASKS']]")
	WebElement tasksLink;
	
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	public void clickOnTasksLink()
	{
		System.out.println("clicking on tasks link");
		tasksLink.click();
	}
	
	public void clickOnLogOut()
	{
		System.out.println("clicking on logout link");
		logoutLink.click();
	}
	
	public DashboardPage(WebDriver driver)
	{
		System.out.println("Dashboard page constructor is called..");
		PageFactory.initElements(driver, this);
	}
	
	public void verifyDashBoardTitle(String actualTitle) {
		
		Assert.assertEquals(DASHBOARD_PAGE_TITLE, actualTitle);
	}
}

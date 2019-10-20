package com.synechron.bdd.actitime.pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.bdd.actitime.utils.DriverUtils;

import junit.framework.Assert;

public class TasksPage {
	public static final String TASKS_PAGE_TITLE = "actiTIME - Task List";
	WebDriver driver;

	@FindBy(xpath = "//div[@class='addNewContainer']")
	WebElement addNewButton;

	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	WebElement newCustomerButton;

	@FindBy(id = "customerLightBox_nameField")
	WebElement customerNameTextBox;

	@FindBy(id = "customerLightBox_descriptionField")
	WebElement customerDescTextBox;

	@FindBy(id = "customerLightBox_commitBtn")
	WebElement createCustomerButton;

	
	@FindBy(xpath = "//div[@class='addNewContainer']/following-sibling::div//input")
	WebElement searchCustomerTextBox;
	
	@FindBy(xpath = "//div[@class='customerNamePlaceHolder']/following-sibling::div[contains(@class,'actions')]//div[@class='actionButton']")
	WebElement actionButton;
	
	@FindBy(xpath = "//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='deleteButton']")
	WebElement deleteButton;
	
	@FindBy(id = "customerPanel_deleteConfirm_submitTitle")
	WebElement deletePermanently;
	
	public void clickOnAddNewButton() {
		System.out.println("Clicking on Add New Button...");
		addNewButton.click();
	}

	public void clickOnAddNewCustomerButton() {
		System.out.println("Clicking on Add New Customer Button...");
		newCustomerButton.click();
	}

	public void enterCustomerName(String cn) {
		System.out.println("Entering Customer Name " + cn);
		customerNameTextBox.sendKeys(cn);
	}

	public void enterCustomerDesc(String cd) {
		System.out.println("Entering Customer Name " + cd);
		customerDescTextBox.sendKeys(cd);
	}

	public void clickOnCreateCustomerButton() {
		System.out.println("Clicking on Create Customer Button...");
		createCustomerButton.click();
	}

	public void validateCustomerCreationSuccessMessage() {
		System.out.println("Waiting for the Success Message to appear and disappear");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));

		System.out.println("Success Message - " + successMsg.getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("Element is disappear...");
	}

	public void enterCustomerNameToSearch(String customername) {
		System.out.println("Entering Customer Name " + customername);
		searchCustomerTextBox.sendKeys(customername);
		userDefinedSleep(6000);
	}

	public void userDefinedSleep(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void moveMouseOnTheSearchElement()
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[span[@class='highlightToken']]"))).perform();
		userDefinedSleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//div[span[@class='highlightToken']]/following-sibling::div[@class='editButton available']"))).click().perform();
		userDefinedSleep(2000);
	}
	
	public void clickOnActionAndDeleteButton()
	{
		actionButton.click();
		userDefinedSleep(2000);
		deleteButton.click();
		userDefinedSleep(2000);
	}
	
	public void clickOnDeletePermanentlyButton()
	{
		deletePermanently.click();
		userDefinedSleep(2000);
	}
	
	public TasksPage(WebDriver driver) {
		System.out.println("Tasks page constructor is called..");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public void verifyTasksPageTitle(String actualTitle) {

		Assert.assertEquals(TASKS_PAGE_TITLE, actualTitle);
	}

}

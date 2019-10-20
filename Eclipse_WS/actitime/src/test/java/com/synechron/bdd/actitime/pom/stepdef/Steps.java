package com.synechron.bdd.actitime.pom.stepdef;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.synechron.bdd.actitime.pom.page.DashboardPage;
import com.synechron.bdd.actitime.pom.page.LoginPage;
import com.synechron.bdd.actitime.pom.page.TasksPage;
import com.synechron.bdd.actitime.utils.PropertyReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Da;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

	WebDriver driver = null;
	LoginPage loginPage = null;
	DashboardPage dPage = null;
	TasksPage tasksPage = null;
	
	public void initializePageObjects()
	{
		loginPage = new LoginPage(driver);
		dPage = new DashboardPage(driver);
		tasksPage = new TasksPage(driver);
	}

	@Before
	public void setupTest() {
		System.out.println("---------------------Creating a Driver Object for Executing Scenario -----------");
		switch (PropertyReader.getBrowerType()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Please check with framework developer for more browser support!!!");
			break;
		}

		driver.manage().timeouts().implicitlyWait(Integer.valueOf(PropertyReader.getMaxTimeOut()), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		initializePageObjects();
	}

	@After
	public void tearDown() {
		driver.close();
		driver = null;
	}

	@Given("^User is on Actitime Login Page$")
	public void user_is_on_Actitime_Login_Page() throws Throwable {

		driver.get(PropertyReader.getApplicationUrl());
	}

	@When("^I enter valid user name and password$")
	public void i_enter_valid_user_name_and_password() throws Throwable {
		loginPage.verifyLoginTitle(driver.getTitle());

		loginPage.enterUserName(PropertyReader.getUserName());
		loginPage.enterPassword(PropertyReader.getPassword());
		loginPage.clickOnLoginButton();

	}

	@Then("^I should be able to see home page$")
	public void i_should_be_able_to_see_home_page() throws Throwable {
		
		dPage.verifyDashBoardTitle(driver.getTitle());
	}

	@When("^I click on Task Link and Add New Button$")
	public void i_click_on_Task_Link_and_Add_New_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dPage.clickOnTasksLink();
		tasksPage.verifyTasksPageTitle(driver.getTitle());
		tasksPage.clickOnAddNewButton();
	}

	@Then("^I should be able to see New Customer Button$")
	public void i_should_be_able_to_see_New_Customer_Button() throws Throwable {

	}

	@Then("^I click on New Customer Button$")
	public void i_click_on_New_Customer_Button() throws Throwable {
		tasksPage.clickOnAddNewCustomerButton();

	}

	@Then("^I should be able to enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_and(String arg1, String arg2) throws Throwable {
		tasksPage.enterCustomerName(arg1);
		tasksPage.enterCustomerDesc(arg2);
		tasksPage.clickOnCreateCustomerButton();

	}

	@Then("^I validate Success Message$")
	public void i_validate_Success_Message() throws Throwable {
		tasksPage.validateCustomerCreationSuccessMessage();

	}

	@Then("^I should be able to logout of the application$")
	public void i_should_be_able_to_logout_of_the_application() throws Throwable {
		dPage.clickOnLogOut();

	}
	
	@When("^I click on Task Link$")
	public void i_click_on_Task_Link() throws Throwable {
	    dPage.clickOnTasksLink();
	    tasksPage.verifyTasksPageTitle(driver.getTitle());
	    
	}

	@Then("^I should be able to Search a customer \"([^\"]*)\"$")
	public void i_should_be_able_to_Search_a_customer(String customername) throws Throwable {
	    tasksPage.enterCustomerNameToSearch(customername);
	    
	}

	@When("^I click on settings Icon next to Customer name$")
	public void i_click_on_settings_Icon_next_to_Customer_name() throws Throwable {
	    tasksPage.moveMouseOnTheSearchElement();
	    
	    
	}

	@Then("^I should see Customer details Section$")
	public void i_should_see_Customer_details_Section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^I click on actions and delete button$")
	public void i_click_on_actions_and_delete_button() throws Throwable {
	    tasksPage.clickOnActionAndDeleteButton();
	    
	}

	@Then("^I should prompt popup$")
	public void i_should_prompt_popup() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^I click on delete Permanently button$")
	public void i_click_on_delete_Permanently_button() throws Throwable {
		 tasksPage.clickOnDeletePermanentlyButton(); // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^I verify success message$")
	public void i_verify_success_message() throws Throwable {
	    tasksPage.validateCustomerCreationSuccessMessage();
	    
	}

	@Then("^Logout of application$")
	public void logout_of_application() throws Throwable {
	   dPage.clickOnLogOut();
	    
	}



}

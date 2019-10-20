package com.synechron.bdd.actitime.stepdefinitions;

import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.bdd.actitime.utils.DriverUtils;
import com.synechron.bdd.actitime.utils.PropertyReader;
import com.synechrone.bdd.actitime.App;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumImplementations {
	WebDriver driver = null;
	List<WebElement> googleSearchReasults = null;

	@Before
	public void beforeMyScenario() {
		System.out.println("Creating a Browser Object....");
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
		
	}

	@After
	public void afterMyScenario() {
		driver.close();
		driver = null;
	}

	@Given("^I'm on google page$")
	public void i_m_on_google_page() throws Throwable {
		driver.get(PropertyReader.getGoogleUrl());
	}

	@When("^I enter \"([^\"]*)\" in the search box$")
	public void i_enter_in_the_search_box(String arg1) throws Throwable {
		System.out.println("Enter " + arg1 + " in search field...");
		driver.findElement(By.name("q")).sendKeys(arg1);
	}

	@When("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		driver.findElement(By.name("btnK")).click();
	}

	@Then("^Results for \"([^\"]*)\" should be displayed$")
	public void results_for_my_search_criteria_should_be_displayed(String companyName) throws Throwable {
		googleSearchReasults = driver.findElements(By.xpath("//h3[starts-with(text(),'" + companyName + "')]"));

		System.out.println("For your search there are " + googleSearchReasults.size() + "  elements displayed..");
	}

	@Then("^I should print those information on Console$")
	public void i_should_print_those_information_on_Console() throws Throwable {

		for (WebElement webElement : googleSearchReasults) {
			System.out.println(webElement.getText());
		}
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
		driver = null;
	}

	@Given("^User is on Actitime Login Page$")
	public void user_is_on_Actitime_Login_Page() throws Throwable {
		driver.get(PropertyReader.getApplicationUrl());
		Assert.assertTrue(driver.getTitle().equals("actiTIME - Login"));
	}

	@When("^I enter valid user name and password$")
	public void i_enter_valid_user_name_and_password() throws Throwable {
		driver.findElement(By.id("username")).sendKeys(PropertyReader.getUserName());
		driver.findElement(By.name("pwd")).sendKeys(PropertyReader.getPassword());
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);

	}

	@Then("^I should be able to see home page$")
	public void i_should_be_able_to_see_home_page() throws Throwable {
		Assert.assertTrue(driver.getTitle().equals("actiTIME - Enter Time-Track"));
	}

	@Then("^the titile of the page is matched$")
	public void the_titile_of_the_page_is_matched() throws Throwable {
		Assert.assertTrue(driver.getTitle().equals("actiTIME - Enter Time-Track"));
	}

	@Then("^I should be able to logout of the application$")
	public void i_should_be_able_to_logout_of_the_application() throws Throwable {
		driver.findElement(By.id("logoutLink")).click();
	}

	@When("^I enter valid username \"([^\"]*)\" and valid password \"([^\"]*)\"$")
	public void i_enter_valid_username_and_valid_password(String username, String password) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
	}

	@Then("^the titile of the page is matched with \"([^\"]*)\"$")
	public void the_titile_of_the_page_is_matched_with(String expectedTitle) throws Throwable {
		Assert.assertTrue(driver.getTitle().equals(expectedTitle));
	}

	@When("^I enter valid outline \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_valid_outline_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(arg1);
		driver.findElement(By.name("pwd")).sendKeys(arg2);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
	}

	@Then("^the titile of the page is with \"([^\"]*)\"$")
	public void the_titile_of_the_page_is_with(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.getTitle().equals(arg1));
	}

	@When("^I enter valid Credentials$")
	public void i_enter_valid_Credentials(DataTable userCredentials) throws Throwable {
		List<List<String>> data = userCredentials.raw();
		String userName = data.get(0).get(0);
		String password = data.get(0).get(1);

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);

	}

	@When("^I enter valid Credentials with header$")
	public void i_enter_valid_Credentials_with_header(DataTable userCredentials) throws Throwable {

		List<Map<String, String>> data = userCredentials.asMaps(String.class, String.class);
		String userName = data.get(0).get("Username");
		String password = data.get(0).get("password");

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
	}

	@When("^I enter valid multiple Credentials with header$")
	public void i_enter_valid_multiple_Credentials_with_header(DataTable userCredentials) throws Throwable {

		String userName, password;

		List<Map<String, String>> data = userCredentials.asMaps(String.class, String.class);
		for (Map<String, String> map : data) {
			userName = map.get("Username");
			password = map.get("password");
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.name("pwd")).sendKeys(password);
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(6000);
			driver.findElement(By.id("logoutLink")).click();
		}

	}

	@Given("^User is on Formy App$")
	public void user_is_on_Formy_App() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PropertyReader.getFormyUrl());

	}

	@When("^User Enter FN \"([^\"]*)\"$")
	public void user_Enter_FN(String arg1) throws Throwable {
		System.out.println("Entering User First Name");
		DriverUtils.typeOnElement(driver, "id", "first-name", arg1);

	}

	@When("^User Enter LN \"([^\"]*)\"$")
	public void user_Enter_LN(String arg1) throws Throwable {
		System.out.println("Entering user Last Name");
		DriverUtils.typeOnElement(driver, "id", "last-name", arg1);

	}

	@When("^User Enter JT \"([^\"]*)\"$")
	public void user_Enter_JT(String arg1) throws Throwable {
		System.out.println("Entering Job Title");
		DriverUtils.typeOnElement(driver, "id", "job-title", arg1);
	}

	@When("^User Select ED \"([^\"]*)\"$")
	public void user_Select_ED(String arg1) throws Throwable {
		System.out.println("Select Education");
		DriverUtils.clickOnElement(driver, "id", "radio-button-3");
	}

	@When("^User Select SEX \"([^\"]*)\"$")
	public void user_Select_SEX(String arg1) throws Throwable {
		System.out.println("Select Sex");
		DriverUtils.clickOnElement(driver, "id", "checkbox-1");

	}

	@When("^User Select EXP \"([^\"]*)\"$")
	public void user_Select_EXP(String arg1) throws Throwable {
		Select sel = new Select(driver.findElement(By.id("select-menu")));
		sel.selectByVisibleText(arg1);

	}

	@When("^User Select DATE \"([^\"]*)\"$")
	public void user_Select_DATE(String arg1) throws Throwable {
		System.out.println("Clickon Date to select Date");
		DriverUtils.typeOnElement(driver, "id", "datepicker", arg1);

	}

	@When("^Click on Submit Button$")
	public void click_on_Submit_Button() throws Throwable {
		DriverUtils.clickOnElement(driver, "xpath", "//a[text()='Submit']");

	}

	@Then("^User Verify Success Message$")
	public void user_Verify_Success_Message() throws Throwable {
		WebElement ele = DriverUtils.getMyElement(driver, "xpath", "//div[@role='alert']");
		Assert.assertEquals("The form was successfully submitted!", ele.getText());
		driver.close();

	}

	@When("^User click on Form Button$")
	public void user_click_on_Form_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		DriverUtils.clickOnElement(driver, "xpath", "//a[@class='nav-link']");
	}

	@When("^User Click on Drag and Drop Link$")
	public void user_Click_on_Drag_and_Drop_Link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Drag and drop page should be displayed$")
	public void drag_and_drop_page_should_be_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Use Should drag the selenium icon to Box$")
	public void use_Should_drag_the_selenium_icon_to_Box() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^User Click on Enabled and Disabled elements$")
	public void user_Click_on_Enabled_and_Disabled_elements() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^User navigated to Enabled and Disabled elements Page$")
	public void user_navigated_to_Enabled_and_Disabled_elements_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^User performs Type on disabled Element$")
	public void user_performs_Type_on_disabled_Element() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^it should not perform type$")
	public void it_should_not_perform_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^User enter text on enabled Element$")
	public void user_enter_text_on_enabled_Element() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Type operation should be successfull$")
	public void type_operation_should_be_successfull() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	//////// Create customer
	@When("^I click on Task Link and Add New Button$")
	public void i_click_on_Task_Link_and_Add_New_Button() throws Throwable {
		Assert.assertEquals("actiTIME - Enter Time-Track", driver.getTitle());

		DriverUtils.clickOnElement(driver, "xpath", "//a[div[text()='TASKS']]");
		Assert.assertEquals("actiTIME - Task List", driver.getTitle());

		DriverUtils.clickOnElement(driver, "xpath", "//div[@class='addNewContainer']");

	}

	@Then("^I should be able to see New Customer Button$")
	public void i_should_be_able_to_see_New_Customer_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(
				DriverUtils.getMyElement(driver, "xpath", "//div[@class='dropdownContainer addNewMenu']")));
		
		Assert.assertTrue(" Add new button not found",ele.isDisplayed());
		
		System.out.println("Element is exist??? - " + ele.isDisplayed());
		System.out.println("Element is Enable??? - " + ele.isEnabled());

	}

	@Then("^I click on New Customer Button$")
	public void i_click_on_New_Customer_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		DriverUtils.clickOnElement(driver, "xpath", "//div[contains(text(),'New Customer')]");
	}

	@Then("^I should be able to enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_customerName_and_customerDesc(String cn, String cd) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		DriverUtils.typeOnElement(driver, "id", "customerLightBox_nameField", cn);
		DriverUtils.typeOnElement(driver, "id", "customerLightBox_descriptionField", cd);
		DriverUtils.clickOnElement(driver, "id", "customerLightBox_commitBtn");

	}

	@Then("^I should be able to enter \"([^\"]*)\" and \"([^\"]*)\" and unselect All Checkboxes$")
	public void i_should_be_able_to_enter_and_and_unselect_All_Checkboxes(String cn, String cd) throws Throwable {
		DriverUtils.typeOnElement(driver, "id", "customerLightBox_nameField", cn);
		DriverUtils.typeOnElement(driver, "id", "customerLightBox_descriptionField", cd);
	
		DriverUtils.unSelectCheckBox(driver, "id", "customerLightBox_importProjectsDescriptions");
		DriverUtils.unSelectCheckBox(driver, "id", "customerLightBox_importTasksDescriptions");
		
		DriverUtils.clickOnElement(driver, "id", "customerLightBox_commitBtn");
	}
	
	
	
	@When("^I validate Success Message$")
	public void i_validate_Success_Message() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(DriverUtils.getMyElement(driver, "xpath", "//div[@class='toast']")));

		System.out.println("Success Message - " + successMsg.getText());
		wait.until(ExpectedConditions.invisibilityOf(DriverUtils.getMyElement(driver, "xpath", "//div[@class='toast']")));
		System.out.println("Element is disappear...");
	}

}

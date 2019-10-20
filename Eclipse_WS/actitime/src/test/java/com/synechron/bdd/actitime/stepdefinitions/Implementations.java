package com.synechron.bdd.actitime.stepdefinitions;



import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Implementations {

	int a, b, c;
	double d;
	Person person ; 
	
	public Implementations(Person person) {
		this.person = person;
		
	}

	@Given("^I want to perform addition on two numbers$")
	public void i_want_to_perform_addition_on_two_numbers() throws Throwable {
		a = 10;
		b = 20;
		System.out.println("Assigned Value a " + a  + " and b " + b);


	}

	@When("^I add two numbers$")
	public void i_add_two_numbers() throws Throwable {
		c = a + b;
		System.out.println("Sum of two numbers is "  + c);
	}

	@Then("^it should match the sum$")
	public void it_should_match_the_sum() throws Throwable {
	//	assertEquals(c, 30);
	}
	
	
	@Given("^I want to perform addition on two floating numbers$")
	public void i_want_to_perform_addition_on_two_floating_numbers() throws Throwable {
	   System.out.println("Welcom to addition of float numbers...");
	}

	@When("^I add \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_add_and(String arg1, String arg2) throws Throwable {
	   d =  Double.valueOf(arg1) + Double.valueOf(arg2);
	}

	@Then("^it should mathch \"([^\"]*)\"$")
	public void it_should_mathch(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		double expectedValue = Double.valueOf(arg1);
	//    assertEquals(d, expectedValue);
	}

	
	@Given("^User will login successfully$")
	public void user_will_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("dummy Test");
	}

	@Given("^User Ill be able to login with below users$")
	public void user_Ill_be_able_to_login_with_below_users() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("dummy Test");
	}

	@Given("^Logged in user will be able to logout successfully$")
	public void logged_in_user_will_be_able_to_logout_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("dummy Test");
	}

	@Given("^customer creation will be successfull using CSV Data$")
	public void customer_creation_will_be_successfull_using_CSV_Data() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("dummy Test");
	}

	@Given("^Create multiple customers$")
	public void create_multiple_customers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("dummy Test");
	}

	@Given("^User should create a task$")
	public void user_should_create_a_task() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("dummy Test");
	}

	
	@Given("^the first step is executed$")
	public void the_first_step_is_executed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(" First ");
	}

	@When("^i enter the details$")
	public void i_enter_the_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(" Second ");
	}

	@Then("^applicaiton returns output$")
	public void applicaiton_returns_output() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(" Third ");
	}
	
	@Given("^User should be able to access other class members$")
	public void user_should_be_able_to_access_other_class_members() throws Throwable {
	    System.out.println("Person object Hash code is : " + person.hashCode());
	}

	@Then("^Print those$")
	public void print_those() throws Throwable {
	   System.out.println("Person default name : "  + person.name);
	   System.out.println("Person default Address : "  + person.address);
	   person.setName("ARAVINDA HB");
	   person.setAddress("USA");
	   System.out.println("Person New name : "  + person.getName());
	   System.out.println("Person New Address : "  + person.getAddress());
	}


}

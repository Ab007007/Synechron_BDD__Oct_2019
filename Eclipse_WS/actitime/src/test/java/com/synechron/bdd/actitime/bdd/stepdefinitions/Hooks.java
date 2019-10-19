package com.synechron.bdd.actitime.bdd.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks
{
	@Before(order = 0)
	public void beforeScenario()
	{
		System.out.println("------ This will be executed before the scenario starts its execution--------------");
	}

	
	@After(order = 1)
	public void afterScenario()
	{
		System.out.println("------- This will be executed after the scenario is executed ------------");
	}
	
	
	@Before(order = 1)
	public void beforeMyScenario()
	{
		System.out.println("------ #####--------------");
	}

	
	@After(order = 0)
	public void afterMyScenario()
	{
		System.out.println("-------$$$$$$$$$$ ------------");
	}
	
	@Before("@First,@third")
	public void beforeCommonStep()
	{
		System.out.println("==================================================================");
	}

	
	@After("@First,@third")
	public void afterCommonStep()
	{
		System.out.println("???????????????????????????????????????????????????????????????????????");
	}
	
	@Before("@First")
	public void beforeFirstScenario()
	{
		System.out.println("************ Before First Scenario *******************");
	}

	@Before("@second")
	public void beforeSecondScenario()
	{
		System.out.println("************ Before Second Scenario *******************");
	}

	@Before("@third")
	public void beforeThirdScenario()
	{
		System.out.println("************ Before Third Scenario *******************");
	}


	@After("@First")
	public void afterFirstScenario()
	{
		System.out.println("************ After First Scenario *******************");
	}

	@After("@second")
	public void aftersecondScenario()
	{
		System.out.println("************ After second Scenario *******************");
	}

	@After("@third")
	public void afterThirdScenario()
	{
		System.out.println("************ After third Scenario *******************");
	}




}

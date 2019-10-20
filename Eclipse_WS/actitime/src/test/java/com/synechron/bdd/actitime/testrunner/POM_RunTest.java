package com.synechron.bdd.actitime.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/createCustomerUsingPOM.feature",
		glue = {"com/synechron/bdd/actitime/pom/stepdef"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty","html:test-output","json:json-output/cucumber.json","junit:junit-output/cucumber.xml"},
		tags = {"@regression"}
		
		)
public class POM_RunTest {

}

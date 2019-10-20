package com.synechron.bdd.actitime.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/temp.feature",
		glue = {"temp"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty","html:test-output","json:json-output/cucumber.json","junit:junit-output/cucumber.xml"}
		
		
		)
public class TempRunnerTest {

}

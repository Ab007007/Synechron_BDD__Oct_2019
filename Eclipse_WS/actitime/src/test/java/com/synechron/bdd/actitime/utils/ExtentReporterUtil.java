package com.synechron.bdd.actitime.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.java.sk.Tak;
import sun.awt.RepaintArea;

public class ExtentReporterUtil extends DriverUtils
{
	String fileName = loc + "abcd.html";
	
	public void ExtentReport()
	{
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReport =  new ExtentHtmlReporter(fileName);
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setDocumentTitle("Test Report");
		htmlReport.config().setReportName("Test Report ");
		
		extent.attachReporter(htmlReport);
	
	}
	
	
	
}

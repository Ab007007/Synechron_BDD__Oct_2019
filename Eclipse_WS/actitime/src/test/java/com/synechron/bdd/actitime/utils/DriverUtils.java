package com.synechron.bdd.actitime.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtils {
	public static WebElement getMyElement(WebDriver driver, String identifier, String identifierValue)  {
		System.out.println("Finding element using " + identifier + " and " + identifierValue);
		WebElement ele = null;

		switch (identifier.toLowerCase()) {
		case "id":
			ele =  driver.findElement(By.id(identifierValue));
			break;

		case "name":
			ele =  driver.findElement(By.name(identifierValue));
			break;

		case "classname":
			ele =  driver.findElement(By.className(identifierValue));
			break;

		case "tagname":
			ele =  driver.findElement(By.tagName(identifierValue));
			break;

		case "linktext":
			ele =  driver.findElement(By.linkText(identifierValue));
			break;

		case "partiallinktext":
			ele =  driver.findElement(By.partialLinkText(identifierValue));
			break;

		case "css":
			ele =  driver.findElement(By.cssSelector(identifierValue));
			break;

		case "xpath":
			ele =  driver.findElement(By.xpath(identifierValue));
			break;

		default:
			System.out.println("Please check your identifier!!!!!");
			break;
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele;
	}


	
	public static void typeOnElement(WebDriver driver, String identifier, String identifierValue,String textToType)
	{
		System.out.println("*** Performing type operation *** ");
		WebElement ele =  getMyElement(driver, identifier, identifierValue);
		
		ele.sendKeys(textToType);
		
	}

	
	public static void clickOnElement(WebDriver driver, String identifier, String identifierValue)
	{
		System.out.println("*** Performing click operation **** ");
		WebElement ele = getMyElement(driver, identifier, identifierValue);
		ele.click();
	}
	
	public static void unSelectCheckBox(WebDriver driver, String identifier, String identifierValue)
	{
		WebElement ele  = getMyElement(driver, identifier, identifierValue);
		
		if(ele.isSelected())
		{
			System.out.println("Checkbox is already selected i'm unSelecting it!!!");
			ele.click();
		}
		else
		{
			System.out.println("checkbox is already unselected so i'm not performing any operation");
		}
	}
	
	public static void selectCheckBox(WebDriver driver, String identifier, String identifierValue)
	{
		WebElement ele  = getMyElement(driver, identifier, identifierValue);
		
		if(!(ele.isSelected()))
		{
			System.out.println("Checkbox is not  selected i'm Selecting it!!!");
			ele.click();
		}
		else
		{
			System.out.println("checkbox is already selected so i'm not performing any operation");
		}
	}
	
	

}

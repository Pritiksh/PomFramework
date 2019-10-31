package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions;

public class HomePage extends BasePage{
	ElementActions elementActions;
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
}

package com.demoqa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends BasePage  {

	public DropdownPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	// ✅ WebElements
	
	@FindBy(xpath = " //input[@id='name']")
	WebElement usernameInput;

}

package com.demoqa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.Utilities.WebActionUtility;

public class BasePage {

	protected WebDriver driver;
	WebActionUtility action;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;	
		
		PageFactory.initElements(driver, this);
		action= new WebActionUtility(driver) ;
	}
	
	
	
}

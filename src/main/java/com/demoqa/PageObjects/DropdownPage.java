package com.demoqa.PageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage  {

	public DropdownPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	// ✅ WebElements

	@FindBy(xpath = " //select[@id='country']")
	WebElement CountryDropDown;
	@FindBy(xpath = " 	//select[@id='animals']")
	WebElement animalList;
	
	   //✅ Methods
	
	public void dropdownselectByText(String option) throws InterruptedException
	{
		action.dropdownselectByText(CountryDropDown, option);
		
		
	}
	 public void selectFromList(String animal)
	 {
		 action.scrollToElementInsideSection(animalList, driver.findElement(By.xpath("//option[@value='"+animal+"']")));
		 action.click(driver.findElement(By.xpath("//option[@value='"+animal+"']")));
	 }
	

}

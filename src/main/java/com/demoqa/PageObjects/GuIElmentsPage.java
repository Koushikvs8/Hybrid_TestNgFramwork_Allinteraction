package com.demoqa.PageObjects;

import org.apache.xmlbeans.impl.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuIElmentsPage extends BasePage{
	
	public GuIElmentsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	// ✅ WebElements
	
@FindBy(xpath = " //input[@id='name']")
WebElement usernameInput;
	
@FindBy(xpath = " //input[@id='email']")
WebElement emailInput;

@FindBy(xpath = " //input[@id='phone']")
WebElement phoneinput;

@FindBy(xpath = "//textarea[@id='textarea']")
WebElement TextAreaInput ;

@FindBy(xpath = "//input[@id='male']")
WebElement maleOption;

@FindBy(xpath = "//input[@id='female']")
WebElement femaleOption;





   //✅ Methods


public void EnterUserCredentials(String username,String email,String phoneNum,String address , String Gender, String freeday) throws InterruptedException
{  
Thread.sleep(1000);
	action.sendKeys(usernameInput, username);
	Thread.sleep(1000);
	action.sendKeys(emailInput, email);
	Thread.sleep(1000);
	action.sendKeys(phoneinput, phoneNum);
	Thread.sleep(1000);
	action.sendKeys(TextAreaInput, address);
	Thread.sleep(1000);
	switch (Gender) {
	case "male":
		maleOption.click();
		break;
	case "female":
		femaleOption.click();
		break;
	default:
		try {
		throw new IllegalArgumentException("Gender is invalid :" + Gender);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	Thread.sleep(1000);
	action.click(By.xpath("//input[@id='"+freeday+"']"));
}
	
	
}

package com.demoqa.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoqa.PageObjects.GuIElmentsPage;
import com.demoqa.TestBase.BaseClass;
import com.demoqa.Utilities.Dataproviders;

public  class UserLogin extends BaseClass  {
	 GuIElmentsPage guiElementpage;
	
	@Test(dataProvider = "logindata" ,dataProviderClass = Dataproviders.class)
	public void validate_form_with_validData(String username,String email,String phoneNum,String address , String Gender, String freeday) throws InterruptedException
	{    
		guiElementpage=new GuIElmentsPage(getDriver());
		guiElementpage.EnterUserCredentials(username, email, phoneNum,address, Gender, freeday);
				
		
	}
	
	
	
}

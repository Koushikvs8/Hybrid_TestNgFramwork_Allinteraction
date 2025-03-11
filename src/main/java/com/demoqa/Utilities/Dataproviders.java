package com.demoqa.Utilities;

import org.testng.annotations.DataProvider;

public class Dataproviders {

	
	@DataProvider(name ="logindata" )
	public Object[][] logindata()
	{
		 Object[][] data = {{"koushik", "koushik@gmail.com", "657483920", "davanadere", "male", "monday"},
				            {"swathi", "swathi@gmail.com", "557483920", "darwada", "female", "sunday"},
		                    {"Ramesh", "Ramesh@gmail.com", "957483920", "Bangalore", "male", "tuesday"}
		 };
		 return data;
	}
	
	
}

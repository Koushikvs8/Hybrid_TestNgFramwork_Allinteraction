package com.demoqa.TestCases;

import org.testng.annotations.Test;

import com.demoqa.PageObjects.DatePicker;
import com.demoqa.TestBase.BaseClass;

public class DatePickerTest extends BaseClass{
   DatePicker Datepicker;
	@Test
		public void Validate_userIs_Able_ToPick_Date() throws InterruptedException
		{
		Datepicker=new DatePicker(getDriver());
		
		Datepicker.selectDate("26/March/2023");
		Thread.sleep(3000);
		
		
		}
	
	
	
}

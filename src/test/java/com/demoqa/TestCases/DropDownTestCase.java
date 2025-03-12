package com.demoqa.TestCases;

import org.testng.annotations.Test;

import com.demoqa.PageObjects.DropdownPage;
import com.demoqa.TestBase.BaseClass;

public class DropDownTestCase extends BaseClass {
     DropdownPage   dropdown;
     @Test
     public void Validate_User_able_to_Select_All_Option() throws InterruptedException
     {
    	 dropdown=new DropdownPage(getDriver());
    	 dropdown.dropdownselectByText("India");
    	 Thread.sleep(2000);
    	 dropdown.selectFromList("rabbit");
    	 Thread.sleep(2000);
     }
     
}

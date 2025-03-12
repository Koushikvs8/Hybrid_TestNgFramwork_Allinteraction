package com.demoqa.PageObjects;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class DatePicker extends BasePage {

	public DatePicker(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// ✅ WebElements

	@FindBy(xpath = " //input[@id='datepicker']")
	WebElement datepickerButton;
	@FindBy(xpath = " //div[@id='ui-datepicker-div']")
	WebElement datepickerCalenderSection;
	// span[@class='ui-datepicker-month']

	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
	WebElement prev;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	WebElement next;

	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	WebElement Currentmonth;

	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	WebElement Currentyear;
	// a[normalize-space()='11']
	// ✅ Methods

	public void selectDate(String dateMonthYear) throws InterruptedException {
		action.click(datepickerButton);
		Thread.sleep(2000);
		// 26/February/2023
		String[] combination = dateMonthYear.split("/");
		String date = combination[0];
		String month = combination[1];
		String year = combination[2];

		Map<String, String> monthMap = new HashMap<>();
		monthMap.put("January", "01");
		monthMap.put("February", "02");
		monthMap.put("March", "3");
		monthMap.put("April", "04");
		monthMap.put("May", "05");
		monthMap.put("June", "06");
		monthMap.put("July", "07");
		monthMap.put("August", "08");
		monthMap.put("September", "09");
		monthMap.put("October", "10");
		monthMap.put("November", "11");
		monthMap.put("December", "12");
		// months
		String monthGivenS = monthMap.get(month);
		int monthGivenI = Integer.parseInt(monthGivenS);
		String monthCurrentS = monthMap.get(Currentmonth.getText());
		int monthCurrentI = Integer.parseInt(monthCurrentS);
		// Years
		int yearGiven = Integer.parseInt(year);
		int yearCurrent = Integer.parseInt(Currentyear.getText());
		// Years
		
		boolean flag = true;
		System.out.println(monthCurrentI + " " + monthGivenI + " " + yearGiven + " " + yearCurrent + ""
				+ (yearGiven > yearCurrent) + "" +(monthGivenI > monthCurrentI) );
		while (flag) {
			if (Currentmonth.getText().equalsIgnoreCase(month) && Currentyear.getText().equalsIgnoreCase(year)) {
				action.jseScrollIntoViewWithCenter(datepickerButton);
				Thread.sleep(1000);
				action.click(By.xpath("//a[normalize-space()='" + date + "']"));
				flag = false;
			} else {
				if (yearGiven > yearCurrent|| (yearGiven==yearCurrent && monthGivenI > monthCurrentI)) {
					next.click();
					if (Currentmonth.getText().equalsIgnoreCase(month)
							&& Currentyear.getText().equalsIgnoreCase(year)) {
						action.click(By.xpath("//a[normalize-space()='" + date + "']"));
					}
				} else {
					prev.click();
					if (Currentmonth.getText().equalsIgnoreCase(month)
							&& Currentyear.getText().equalsIgnoreCase(year)) {
						action.click(By.xpath("//a[normalize-space()='" + date + "']"));
					}
				}

			}

		}
	}
}

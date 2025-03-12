package com.demoqa.Utilities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.demoqa.PageObjects.BasePage;

public class WebActionUtility {
	WebDriver driver;
	JavascriptExecutor js ;
	public WebActionUtility(WebDriver driver) {
		this.driver=driver;
		 js = (JavascriptExecutor) driver;
		// TODO Auto-generated constructor stub
	}

	//✅ Click method MethodOverloading 
	
	//✅ Click
	
	public void click(WebElement element)
	{    boolean status=false;
	try {
	      status=element.isDisplayed();
	      if(status==true)
	      {   jseScrollIntoView(element);
	    	  element.click();
	      }
	     
	}
	catch (Exception e) {
	
	}
	     finally {
			if(status)
			{
				
			}
			else
			{
				System.out.println("element is not Clickable");
			}
		}
	}
	public boolean click(By locater)
	{    boolean status=false;
	try { WebElement element=findelement(locater);
	       jseScrollIntoView(element);
	      status=findelement(locater).isDisplayed();
	      if(status==true)
	      {
	    	  element.click();
	      }
	      return status;
	}
	catch (Exception e) {
		return false;
	}
	     finally {
			if(status)
			{
				
			}
			else
			{
				System.out.println("element is not displayed");
			}
		}
	}
	
	//✅ SendKeys
	
	public void sendKeys(WebElement element ,String text)
	{
		 boolean status=false;
			try {
			      status=element.isDisplayed();
			      if(status==true)
			      {   jseScrollIntoView(element);
			    	  element.sendKeys(text);
			      }
			     
			}
			catch (Exception e) {
			
			}
			     finally {
					if(status)
					{
					}
					else
					{
						System.out.println("details are not posible enter");
					}
				}
	}
	//✅ dropdownSelecter

	public void dropdownselectByText(WebElement element , String  option) throws InterruptedException
	{
		Select mydropdown= new Select(element);
		mydropdown.selectByVisibleText(option);
		Thread.sleep(2000);
		  List<WebElement> options= mydropdown.getOptions();
		   Iterator<WebElement> itrator=options.iterator();
		   while(itrator.hasNext())
		   {      
		    mydropdown.selectByVisibleText(itrator.next().getText());
		   }
		
	}

	
	//✅ findelementBy
	public WebElement findelement(By locater)
	{
		return driver.findElement(locater);
	}
	
	//✅ isDisplayed
		public boolean isDisplayed(WebElement element)
		{    boolean status=false;
		try {
		      status=element.isDisplayed();
		      return status;
		}
		catch (Exception e) {
			return false;
		}
		     finally {
				if(status)
				{
					
				}
				else
				{
					System.out.println("element is not displayed");
				}
			}
		}
		//✅ JavaScript_Executer
		public void jseScrollIntoView(WebElement element)
		{
			
			Boolean isInViewport = (Boolean) js.executeScript(
				    "var rect = arguments[0].getBoundingClientRect();" +
				    "return (" +
				    "rect.top >= 0 && " +
				    "rect.left >= 0 && " +
				    "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
				    "rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
				    ");", element);
			if (!isInViewport) {
			    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
			}
		}
		public void scrollToElementInsideSection(WebElement section, WebElement targetElement) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        "arguments[0].scrollTop = arguments[1].offsetTop - arguments[0].offsetTop;", 
		        section, targetElement
		    );
		}
		public WebElement jseScrollIntoViewWithCenter(WebElement element)
		{
			
			js.executeScript(
				    "const element = arguments[0];" +
				    	    "const rect = element.getBoundingClientRect();" +
				    	    "const absoluteElementTop = rect.top + window.pageYOffset;" +
				    	    "const middle = absoluteElementTop - (window.innerHeight / 2);" +
				    	    "window.scrollTo({top: middle, behavior: 'smooth'});", 
				    	    element);
			
			return element;
			
		}
	
	
}

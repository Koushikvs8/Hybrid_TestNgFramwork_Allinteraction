package com.demoqa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {
  
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();  // ✅ ThreadLocal for the Thread Safe Execution
    private static Properties properties;
  
    // Load config file once
   static 
   {
	   loadConfigFile(); 
   }

    @BeforeMethod
    public void setUp() {
    	// Load config file once
    	
        if (driver.get() == null) {
            webdriverManager();  // Correctly initialize driver
            launchTheUrl();      // Load URL
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
        }
        driver.remove();
    }

    // ✅ Correct static config loader
    public static void loadConfigFile() {
        try {
            FileInputStream myFileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            properties = new Properties();
            properties.load(myFileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while accessing the file: " + e.getMessage());
        }
    }

    // ✅ Correct browser manager without @Test
    public static void webdriverManager() {
        String browserFromConfig = properties.getProperty("Browser");
        if (browserFromConfig.equalsIgnoreCase("Chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserFromConfig.equalsIgnoreCase("Firefox")) {
            driver.set(new FirefoxDriver());
        } else if (browserFromConfig.equalsIgnoreCase("Edge")) {
            driver.set(new EdgeDriver());
        } else {
            throw new IllegalArgumentException("Invalid browser name in config file.");
        }
    }

    // ✅ Correct URL launch method
    
    public static void launchTheUrl() {
        String urlFromConfig = properties.getProperty("Url");
        System.out.println(urlFromConfig);
        WebDriver webDriver = driver.get();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Fix setter
        webDriver.get(urlFromConfig);
    }

    // ✅ Optional getter for driver
    public static WebDriver getDriver() {
        return driver.get();
    }

   
	
}

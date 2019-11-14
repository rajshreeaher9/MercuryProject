package com.mercury.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver = null;
	public WebDriver getDriver() {
		 System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\MercuryDemoProject\\libs\\chromedriver.exe");
		driver= new  ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		return driver;
		
	}

}

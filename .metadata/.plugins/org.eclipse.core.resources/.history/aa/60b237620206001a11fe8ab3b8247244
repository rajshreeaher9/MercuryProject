 package com.mercury.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mercury.demo.Base;

public class login extends Base {

	public WebDriver driver;
	
public login(WebDriver driver)
{
	this.driver= driver;

}
public By username =By.name("userName");
public WebElement getusername() {
	return driver.findElement(username);
}

public By password =(By.name("password"));
public WebElement getpassword() {
	return driver.findElement(password);
}

public By login =(By.xpath("//input[@name='login' and @value='Login']"));
public WebElement getlogin() {
	return driver.findElement(login);
}
public WebElement trvlopt= driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']"));
public WebElement gettrvlopt() {
	return (WebElement) driver.findElements((By) trvlopt);
}
}

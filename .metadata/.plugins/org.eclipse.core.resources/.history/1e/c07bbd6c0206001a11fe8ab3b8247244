package com.mercury.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mercury.demo.Base;

public class Login extends Base {

	public WebDriver driver;

	public By login = (By.xpath("//input[@name='login' and @value='Login']"));

	public By password = (By.name("password"));

	public WebElement trvlopt = driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']"));

	public By username = By.name("userName");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getlogin() {
		return driver.findElement(login);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement gettrvlopt() {
		return trvlopt;
	}

	public WebElement getusername() {
		return driver.findElement(username);
	}
}

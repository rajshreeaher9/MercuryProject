package com.mercury.demo.regression;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.aop.target.SimpleBeanTargetSource;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mercury.demo.Base;
import com.mercury.demo.business.execute;

public class RunTest {
	WebDriver driver;

	@AfterMethod
	public void afterTest() {
		driver.quit();

	}

	@BeforeMethod
	public void beforeLogin() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse-workspace\\MercuryDemoProject\\libs\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@DataProvider
	public Object[][] getLoginData() {
		Object data[][] = TestUtil.getTestData("login3");
		return data;

	}

	@Test(dataProvider = "getLoginData")
	public void pageLogin(String Travelopt, String passCount, String fromPort, String fromMonth, String fromDay,
			String toPort, String toMonth, String toDay, String servClass, String airline, String totalPrc,
			String fname, String lname, String fname1, String lname1, String fname2, String lname2, String fname3,
			String lname3) throws InterruptedException {

		/*
		 * Base b= new Base(); WebDriver driver= b.getDriver();
		 */
		// execute exe= PageFactory.initElements(driver, execute.class);

		String url = "http://newtours.demoaut.com/mercurysignon.php";
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.xpath("//input[@name='login' and @value='Login']")).click();

		/*
		 * exe.loginFillUp("mercury", "mercury"); exe.getlogin().click();
		 */

		/*
		 * boolean b_result = f_verify_element_exists(driver.findElement(By.
		 * xpath("//img[@src = '/images/masts/mast_flightfinder.gif']")));
		 * if(b_result==true){ System.out.println("Login is Successfull."); }else{
		 * System.out.println("Login Failed."); }
		 */
		Thread.sleep(100);
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Find a Flight: Mercury Tours: ";

		if (expectedTitle1.equals(actualTitle1)) {
			System.out.println("Find a Flight: Mercury Tours:");
		} else {
			System.out.println("Verification failed! Incorrect title is displayed");
		}

		// WebElement select = driver.findElement(By.cssSelector("tbody:nth-child(1)
		// tr:nth-child(2) td:nth-child(2) b:nth-child(1) > font:nth-child(1)"));
		if (Travelopt.contentEquals("oneway")) {
			driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']")).click();
		}

		else {
			driver.findElement(By.xpath("//input[@name='tripType' and @value='roundtrip']")).click();
		}

		Select o_num_pass_list = new Select(driver.findElement(By.name("passCount")));
		Select o_departing_from_list = new Select(driver.findElement(By.name("fromPort")));
		Select o_departing_date_month_list = new Select(driver.findElement(By.name("fromMonth")));
		Select o_departing_date_date_list = new Select(driver.findElement(By.name("fromDay")));
		Select o_arriving_in_list = new Select(driver.findElement(By.name("toPort")));
		Select o_returning_date_month_list = new Select(driver.findElement(By.name("toMonth")));
		Select o_returning_date_date_list = new Select(driver.findElement(By.name("toDay")));
		List<WebElement> o_service_class_radio = driver.findElements(By.name("servClass"));
		Select o_airline_list = new Select(driver.findElement(By.name("airline")));

		o_num_pass_list.selectByValue(passCount);
		o_departing_from_list.selectByValue(fromPort);
		o_departing_date_month_list.selectByVisibleText(fromMonth);
		o_departing_date_date_list.selectByValue(fromDay);
		o_arriving_in_list.selectByValue(toPort);
		o_returning_date_month_list.selectByVisibleText(toMonth);
		o_returning_date_date_list.selectByValue(toDay);
		for (WebElement option : o_service_class_radio) {
			if ("Coach".equals(option.getText())) {
				option.click();
			} else if ("Business".equals(option.getText())) {
				option.click();
			} else if ("First".equals(option.getText())) {
				option.click();

			}
		}

		o_airline_list.selectByVisibleText(airline);
		Thread.sleep(2000);
		driver.findElement(By.name("findFlights")).click();

		// Wait for Next page to appear

		String actualTitle2 = driver.getTitle();
		String expectedTitle2 = "Select a Flight: Mercury Tours";

		if (expectedTitle2.equals(actualTitle2)) {
			System.out.println("Select a Flight: Mercury Tours");
		} else {
			System.out.println("Verification failed!");
		}
		Thread.sleep(5000);

		driver.findElement(By.name("reserveFlights")).click();
		Thread.sleep(2000);

		String actualTitle3 = driver.getTitle();
		String expectedTitle3 = "Book a Flight: Mercury Tours";

		if (expectedTitle3.equals(actualTitle3)) {
			System.out.println("Book a Flight: Mercury Tours");
		} else {
			System.out.println("Verification failed! Incorrect title is displayed");
		}
		// total price

		String oneWay = driver
				.findElement(By.cssSelector(
						"table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) td.data_center > font:nth-child(1)"))
				.getText();
		System.out.println("price for Oneway: " + oneWay);
		int result1 = Integer.parseInt(oneWay);
		String roundPrice = driver
				.findElement(By.cssSelector(
						"table:nth-child(1) tbody:nth-child(1) tr:nth-child(6) td.data_center > font:nth-child(1)"))
				.getText();
		System.out.println("price for Rondtrip: " + roundPrice);
		int result2 = Integer.parseInt(roundPrice);
		int pasng = Integer.parseInt(driver.findElement(By.cssSelector(
				"table:nth-child(1) tbody:nth-child(1) tr:nth-child(7) td.data_left:nth-child(2) > font:nth-child(1)"))
				.getText());
		System.out.println("Number of passesnger: " + pasng);
		String tax = driver.findElement(By.cssSelector(
				"table:nth-child(1) tbody:nth-child(1) tr:nth-child(8) td.data_left:nth-child(2) > font:nth-child(1)"))
				.getText();

		String newStr = tax.replace("$", "").replace(",", "");

		System.out.println("price for tax: " + newStr);
		int result = Integer.parseInt(newStr);
		String totalPrice = driver.findElement(By.cssSelector(
				"tbody:nth-child(1) tr:nth-child(9) td.data_left:nth-child(2) font:nth-child(1) > b:nth-child(1)"))
				.getText();
		String newStr1 = totalPrice.replace("$", "").replace(",", "");
		// System.out.println("Total price with tax: "+newStr1);

		int finalResult = result2 + result1 + result;
		System.out.println("price calculated in program: " + finalResult);
		if (Integer.parseInt(totalPrc) == finalResult) {
			System.out.println("Total Price is correct ");
		} else {
			System.out.println("Total Price is incorrect");
		}

		if ("1".equals(passCount))

		{
			driver.findElement(By.name("passFirst0")).sendKeys(fname);
			driver.findElement(By.name("passLast0")).sendKeys(lname);
			System.out.println("first name and last name entered for 1 passenger");
			Thread.sleep(5000);
		} else if ("2".equals(passCount)) {
			driver.findElement(By.name("passFirst0")).sendKeys(fname);
			driver.findElement(By.name("passLast0")).sendKeys(lname);
			driver.findElement(By.name("passFirst1")).sendKeys(fname1);
			driver.findElement(By.name("passLast1")).sendKeys(lname1);
			System.out.println("first name and last name entered for 2 passenger");
			Thread.sleep(5000);

		} else if ("3".equals(passCount)) {
			driver.findElement(By.name("passFirst0")).sendKeys(fname);
			driver.findElement(By.name("passLast0")).sendKeys(lname);
			driver.findElement(By.name("passFirst1")).sendKeys(fname1);
			driver.findElement(By.name("passLast1")).sendKeys(lname1);
			driver.findElement(By.name("passFirst2")).sendKeys(fname2);
			driver.findElement(By.name("passLast2")).sendKeys(lname2);
			System.out.println("first name and last name entered for 3 passenger");
			Thread.sleep(5000);
		} else if ("4".equals(passCount)) {
			driver.findElement(By.name("passFirst0")).sendKeys(fname);
			driver.findElement(By.name("passLast0")).sendKeys(lname);
			driver.findElement(By.name("passFirst1")).sendKeys(fname1);
			driver.findElement(By.name("passLast1")).sendKeys(lname1);
			driver.findElement(By.name("passFirst2")).sendKeys(fname2);
			driver.findElement(By.name("passLast2")).sendKeys(lname2);
			driver.findElement(By.name("passFirst3")).sendKeys(fname3);
			driver.findElement(By.name("passLast3")).sendKeys(lname3);
			System.out.println("first name and last name entered for 4 passenger");
			Thread.sleep(5000);

		}
	}
}

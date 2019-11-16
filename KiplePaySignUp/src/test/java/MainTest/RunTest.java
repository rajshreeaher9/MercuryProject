package MainTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.configReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.KipleObjects;
import tests.BaseClass;

public class RunTest {
	BaseClass base;
	KipleObjects kipleobjects;
	configReader config;
	private AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void initialiseTest() {

		base = new BaseClass();
		driver = base.setup();

	}

	@Test

	public void startSignUp() {

		kipleobjects = new KipleObjects(driver);

		System.out.println("Im inside");
		config = new configReader();

		kipleobjects.getgoogleSign().click();
		kipleobjects.getgoogleNme().sendKeys(config.getusername());

	}

}

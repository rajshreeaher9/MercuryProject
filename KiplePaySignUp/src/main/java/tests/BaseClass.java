package tests;


import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static AppiumDriver<MobileElement> driver;

	public AppiumDriver<MobileElement> setup() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PLATFORM_NAME,"ANDROID");
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note5");
		capabilities.setCapability(MobileCapabilityType.UDID, "0415384133313636");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capabilities.setCapability(MobileCapabilityType.APP,"");
		
		capabilities.setCapability("appPackage","com.mobi.wallet");
		capabilities.setCapability("appActivity","com.mobi.wallet.MainActivity");
		
		try {
			URL url= new URL("http://127.0.0.1:4723/wd/hub");
			driver= new AppiumDriver<MobileElement>(url,capabilities);
			
		} catch (Exception e) {
			System.out.println("Cause is" +e.getCause());
			System.out.println("Cause is" +e.getMessage());
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public void teardown() {

	}

}

package Util;

import java.time.Duration;

import org.apache.commons.logging.Log;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import tests.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class util extends BaseClass{
	
	private static FluentWait<AppiumDriver<MobileElement>> wait;
	private static Logger logger;
	private AppiumDriver<MobileElement> driver = null;
	
	//public static MobileElement mobileElement;
	
	

	
	public util(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		logger = LogManager.getLogger(util.class);
	}

	public MobileElement waitForPresence(AppiumDriver<MobileElement> driver,MobileElement Element){

		final long startTime = System.currentTimeMillis();

		int tries = 0;
		boolean found = false;

		wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(StaleElementReferenceException.class);

		while ((System.currentTimeMillis() - startTime) < 91000) {
			logger.info("Searching for element " + Element.toString() + ". Try number " + (tries++));
			try {

				Element = (MobileElement) wait.until(ExpectedConditions.visibilityOf(Element));

				found = true;

				break;

			} catch (StaleElementReferenceException e) {
				logger.error("Stale element: \n" + e.getMessage() + "\n");
			}
		}

		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		if (found) {
			logger.info("Found element "  + Element.toString() + " after waiting for " + totalTime + " milliseconds.");
		} else {
			logger.error("Failed to find element "  + Element.toString() + " after " + totalTime + " milliseconds.");
		}
		return Element;
}
	/*public void swipe()
	{
		int startX=1022;
		int startY=1460;
		int endX=1007;
		int endY=1095;
		logger.info("scroll from : startX " +startX + ", startY "+ startY+ ", to  endX "+ endX+ ",endY "+ endY);
		  try {
		    TouchAction touchAction = new TouchAction(driver);
		    PointOption pointStart = PointOption.point(startX, startY);
		    PointOption pointEnd = PointOption.point(endX, endY);
		    WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
		    touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();
		  }catch (Exception e){
			  logger.error("scroll from : startX " +startX + ", startY "+ startY+ ", to  endX "+ endX+ ",endY "+ endY);
		    e.printStackTrace();
		  }
	}*/
}
		
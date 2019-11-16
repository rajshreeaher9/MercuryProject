package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Util.util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import tests.BaseClass;

public class KipleObjects extends BaseClass {
	public AppiumDriver<MobileElement> driver;

	public KipleObjects(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		util = new util(this.driver);
		PageFactory.initElements(this.driver, this);
	}

	// Page Object Repositories
	// private MobileElement googleBtn;

	// public By googleBtn = By.id("com.mobi.wallet:id/btnLogInGG");

	@AndroidFindBy(id = "com.mobi.wallet:id/btnLogInGG")
	private AndroidElement googleBtn;

	@AndroidFindBy(id = "com.mobi.wallet:id/edtFullName")
	private AndroidElement googleNme;

	@AndroidFindBy(id = "com.mobi.wallet:id/edtEmail")
	private AndroidElement googleEml;

	@AndroidFindBy(id = "	com.mobi.wallet:id/edtPassword")
	private AndroidElement googlePwd;

	@AndroidFindBy(id = "com.mobi.wallet:id/edtConfirmPassword")
	private AndroidElement googleCpwd;

	@AndroidFindBy(id = "com.mobi.wallet:id/tvSignUp")
	public AndroidElement googleSign;

	@AndroidFindBy(id = "com.mobi.wallet:id/btnSubmit")
	private AndroidElement signUp;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'][@index='1']")
	private AndroidElement googleClk;

	@AndroidFindBy(xpath = "//android.view.View[@index='0']")
	private AndroidElement googleEmail;

	@AndroidFindBy(id = "identifierNext")
	private AndroidElement googleNxt;

	@AndroidFindBy(xpath = "//android.view.View[@index='0']")
	private AndroidElement googlePswd;

	@AndroidFindBy(id = "passwordNext")
	private AndroidElement googleNxt1;

	@AndroidFindBy(xpath = "//android.widget.Button[@index='0'][@text='Yes, I’m in']")
	private AndroidElement googleIn;

	@AndroidFindBy(id = "signinconsentNext")
	private AndroidElement googleAgree;

	@AndroidFindBy(id = "com.mobi.wallet:id/rbHavent")
	private AndroidElement noReferral;

	@AndroidFindBy(id = "com.mobi.wallet:id/btnSubmitReferral")
	private AndroidElement submitReferral;

	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement submitYes;

	// Gmail Objects
	@AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
	private AndroidElement gmailGotIt;

	@AndroidFindBy(id = "com.google.android.gm:id/action_done")
	private AndroidElement gmailTakeMe;

	@AndroidFindBy(id = "com.google.android.gm:id/gm_dismiss_button")
	private AndroidElement gmailNext;

	@AndroidFindBy(id = "com.google.android.gm:id/gm_dismiss_button")
	private AndroidElement gmailOk;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Kiple Unlock your kiplePay account with this secret code!')]")

	private AndroidElement gmailMail;
	@AndroidFindBy(xpath = "//android.view.View[22]")
	private AndroidElement gmailOTP;
	@AndroidFindBy(id = "com.mobi.wallet:id/edtVerifyCode")
	private AndroidElement gmailEnterOTP;

	private util util;

	public AndroidElement getgoogleBtn() {
		return (AndroidElement) util.waitForPresence(driver, googleBtn);
	}

	public AndroidElement getgoogleClk() {
		return (AndroidElement) util.waitForPresence(driver, googleClk);
	}

	public AndroidElement getgoogleEmail() {
		return (AndroidElement) util.waitForPresence(driver, googleEmail);
	}

	public AndroidElement getgoogleNxt() {
		return (AndroidElement) util.waitForPresence(driver, googleNxt);
	}

	public AndroidElement getgooglePswd() {
		return (AndroidElement) util.waitForPresence(driver, googlePswd);
	}

	public AndroidElement getgoogleNxt1() {
		return (AndroidElement) util.waitForPresence(driver, googleNxt1);
	}

	public AndroidElement getgoogleIn() {
		return (AndroidElement) util.waitForPresence(driver, googleIn);
	}

	public AndroidElement getgoogleAgree() {
		return (AndroidElement) util.waitForPresence(driver, googleAgree);
	}

	public AndroidElement getnoReferral() {
		return (AndroidElement) util.waitForPresence(driver, noReferral);
	}

	public AndroidElement getsubmitReferral() {
		return (AndroidElement) util.waitForPresence(driver, submitReferral);
	}

	public AndroidElement getsubmitYes() {
		return (AndroidElement) util.waitForPresence(driver, submitYes);
	}

	public AndroidElement getgoogleSign() {
		return (AndroidElement) util.waitForPresence(driver, googleSign);
		// return (driver,googleSign);

	}

	public AndroidElement getgoogleEml() {
		return (AndroidElement) util.waitForPresence(driver, googleEml);
	}

	public AndroidElement getgooglePwd() {
		return (AndroidElement) util.waitForPresence(driver, googlePwd);
	}

	public AndroidElement getgoogleCpwd() {
		return (AndroidElement) util.waitForPresence(driver, googleCpwd);
	}

	public AndroidElement getgoogleNme() {
		return (AndroidElement) util.waitForPresence(driver, googleNme);
	}

	public AndroidElement getsignUp() {
		return (AndroidElement) util.waitForPresence(driver, signUp);
	}

	public AndroidElement getgmailGotIt() {
		return (AndroidElement) util.waitForPresence(driver, gmailGotIt);
	}

	public AndroidElement getgmailTakeMe() {
		return (AndroidElement) util.waitForPresence(driver, gmailTakeMe);
	}

	public AndroidElement getgmailNext() {
		return (AndroidElement) util.waitForPresence(driver, gmailNext);
	}

	public AndroidElement getgmailOk() {
		return (AndroidElement) util.waitForPresence(driver, gmailOk);
	}

	public AndroidElement getgmailMail() {
		return (AndroidElement) util.waitForPresence(driver, gmailMail);
	}

	public AndroidElement getgmailOTP() {
		return (AndroidElement) util.waitForPresence(driver, gmailOTP);
	}

	public AndroidElement getgmailEnterOTP() {
		return (AndroidElement) util.waitForPresence(driver, gmailEnterOTP);
	}

}

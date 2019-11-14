package com.mercury.demo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.mercury.demo.business.execute;
import com.mercury.demo.regression.RunTest;
import com.mercury.demo.regression.TestUtil;

public class ParallelRun {
	WebDriver driver;

	@Test
	public void test1() throws InterruptedException {
		RunTest run = new RunTest();

		run.beforeLogin();

		run.pageLogin("oneway", "4", "Paris", "February", "3", "Sydney", "February", "6", "Business", "Pangea Airlines",
				"2338", "Rajshree", "Aher", "ABC", "DEF", "EFG", "HIJ", "KLM", "NMP");
		run.afterTest();

		System.out.println("Total Price is correct ");

	}

	@Test
	public void test2() throws InterruptedException {
		RunTest run = new RunTest();

		run.beforeLogin();

		run.pageLogin("oneway", "4", "Paris", "February", "3", "Sydney", "February", "6", "Business", "Pangea Airlines",
				"2330", "Rajshree", "Aher", "ABC", "DEF", "EFG", "HIJ", "KLM", "NMP");
		run.afterTest();

		System.out.println("Total Price is incorrect");

	}

}

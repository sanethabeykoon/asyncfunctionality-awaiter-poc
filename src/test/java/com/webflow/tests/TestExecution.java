package com.webflow.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webflow.pageobjects.HomePage;
import com.webflow.pageobjects.ProblemsPage;
import com.webflow.pageobjects.SelectDevicePage;

public class TestExecution {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void executeTest() {
		driver.get("https://url.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		HomePage homePage = new HomePage(driver);
		SelectDevicePage selectDevicePage = homePage.navigateToSelectDevicePage();
		ProblemsPage problemsPage = selectDevicePage.navigateToProblemsPage();
		problemsPage.pickProblemCategory();
		problemsPage.pickProblem();
		problemsPage.enterProblemDesc("");
		problemsPage.clickNext();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

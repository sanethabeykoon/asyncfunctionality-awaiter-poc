package com.webflow.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectDevicePage {

	private WebDriver driver;
	
	public SelectDevicePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[text()[contains(.,'')]]")
	private WebElement device;
	
	public ProblemsPage navigateToProblemsPage() {
		device.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, ProblemsPage.class);
	}
}

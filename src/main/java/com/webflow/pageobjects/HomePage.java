package com.webflow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[text()[contains(.,'')]]")
	@CacheLookup
	private WebElement country;
	
	public SelectDevicePage navigateToSelectDevicePage() {
		country.click();
		return PageFactory.initElements(driver, SelectDevicePage.class);
	}
}

package com.webflow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.testng.Assert;

import com.webflow.util.Awaiter;

public class ProblemsPage {

	private WebDriver driver;
	private Awaiter awaiter;
	
	public ProblemsPage(WebDriver driver) {
		this.driver = driver;
		this.awaiter = new Awaiter();
	}
	
	@FindBy(how = How.XPATH, using = "//button[text()[contains(.,'')]]")
	private WebElement problemCategory;
	
	@FindBy(how = How.XPATH, using = "//button[text()[contains(.,'')]]")
	private WebElement problem;
	
	@FindBy(how = How.XPATH, using = "//textarea")
	private WebElement problemDesc;
	
	@FindBy(how = How.XPATH, using = "//button[text()[contains(.,'')]]")
	private WebElement nextButton;
	
	public void pickProblemCategory() {
		boolean readyState = awaiter.awaitForElement(problemCategory, 1, 15);
		
		System.out.println("Element ready state: " + readyState);
		Assert.assertEquals(readyState, true);
		
		problemCategory.click();
	}
	
	public void pickProblem() {
		problem.click();
	}
	
	public void enterProblemDesc(String note) {
		problemDesc.sendKeys(note);
	}
	
	public void clickNext() {
		nextButton.click();
	}
}

package com.webflow.util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;

public class Awaiter {
	private WebElement webElement;
		
	public boolean awaitForElement(WebElement webElement, long pollInterval, long awaitTime) {
		this.webElement = webElement;
		return with().pollInterval(pollInterval, TimeUnit.SECONDS).await().atMost(awaitTime, TimeUnit.SECONDS).until(checkElement(), equalTo(true));
	}
	
	private Callable<Boolean> checkElement() {
	      return new Callable<Boolean>() {
	            public Boolean call() throws Exception {
	            	return webElement.isDisplayed();
	            }
	      };
	}
}

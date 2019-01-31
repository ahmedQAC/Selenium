package com.qa.cucumberDemonstration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	@FindBy(id="sb_form_q")
	private WebElement searchBox;
	
	@FindBy(id="sb_form_go")
	private WebElement submitButton;
	
	public void submitText(String inputText) {
		searchBox.sendKeys(inputText);
		submitButton.click();
	}
}

package com.qa.cucomberDemonstration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class MenuPage {
	@FindBys(@FindBy(className="wsb-element-image"))
	private WebElement images;
	
	public boolean isListPresent() {
		Dimension num = images.getSize();
		if (num != null) {
			return true;
		}
		return false;
	}
}

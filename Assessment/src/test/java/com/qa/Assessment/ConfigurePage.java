package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurePage {
	
	@FindBy(name = "_.fullName")
	private WebElement configureName; 
	
	public void changeName(String arg1) {
		configureName.sendKeys(arg1);
		configureName.submit(); 
		
	}
}

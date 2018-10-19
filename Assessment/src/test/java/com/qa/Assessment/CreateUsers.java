package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUsers {
	
	//Create user fields 
		@FindBy(id = "username")
		private WebElement createUsername; 
		
		@FindBy(name = "password1")
		private WebElement createPassword;
		
		@FindBy(name = "password2")
		private WebElement confirmPassword; 
		
		@FindBy(name = "fullname")
		private WebElement fullName; 
		
		
		//Method
		public void createUser (String arg1, String arg2, String arg3, String arg4) { 
			createUsername.sendKeys(arg1);
			createPassword.sendKeys(arg2);
			confirmPassword.sendKeys(arg3);
			fullName.sendKeys(arg4);
			fullName.submit(); 
		}


}

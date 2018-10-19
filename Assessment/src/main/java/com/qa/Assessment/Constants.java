package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Constants {
	
	public static String url = "localhost:8080";
	
	//Log in page 
	@FindBy(id = "j_username")
	private WebElement username;
	
	@FindBy(name = "j_password")
	private WebElement password; 
	
	//Website navigation 
	@FindBy(linkText = "Manage Jenkins")
	private WebElement manageJenkins;
	
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Install as Windows Service'])[1]/following::dt[1]")
	private WebElement manageUsers;
	
	@FindBy(linkText = "Create User")
	private WebElement createUser;
	
	//Create user fields 
	@FindBy(id = "username")
	private WebElement createUsername; 
	
	@FindBy(name = "password1")
	private WebElement createPassword;
	
	@FindBy(name = "password2")
	private WebElement confirmPassword; 
	
	@FindBy(name = "fullname")
	private WebElement fullName; 
	
	
	//Methods 
	public void enterUsername(String arg1) { 
		username.sendKeys(arg1);
	}
	
	public void enterPassword(String arg1) { 
		password.sendKeys(arg1);
		password.submit(); 
	}
	
	public void manageJenkinsPage () { 
		manageJenkins.click(); 
	}
	
	public void manageUsersPage () { 
		manageUsers.click(); 
	}
	public void createUserPage() { 
		createUser.click(); 
	}
	public void createUser(String arg1, String arg2, String arg3) { 
		createUsername.sendKeys(arg1);
		createPassword.sendKeys(arg2);
		confirmPassword.sendKeys(arg2);
		fullName.sendKeys(arg3);
		fullName.submit(); 
	}

}

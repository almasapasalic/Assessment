package com.qa.Assessment;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.*; 

public class FirstTask {
	WebDriver driver; 
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Almasa\\FirstTask.html", true);
	
	ExtentTest test; 
	
	@Before //set up Chrome driver 
	public void setup() { 
		test = extent.startTest("Create a new Jenkins user");  
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started"); 
	}
	
	@After //quit driver and create test report 
	public void teardown() { 
	driver.quit(); 
	extent.flush();
	}
	
	@Test //automation of creation of a user using own input
	public void createUser() { 
		
		//open Jenkins
		driver.manage().window().maximize(); 
		driver.get(Constants.url);
		
		//log in
		String username = "admin";
		String password = "123456";
		
		Constants c = PageFactory.initElements(driver, Constants.class);
		c.enterUsername(username);
		c.enterPassword(password);
		
		//Navigate to "Manage Jenkins" 
		c.manageJenkinsPage();
		
		//Navigate to "Manage Users"
		c.manageUsersPage();
		
		//Navigate to "Create User"
		c.createUserPage();
		
		//Fill in form
		String newUsername = "newUser";
		String newPassword = "examplepass";
		String name = "Example User";
		c.createUser(newUsername, newPassword, name);
		
		test.log(LogStatus.PASS, "New user created");
		
	}

}

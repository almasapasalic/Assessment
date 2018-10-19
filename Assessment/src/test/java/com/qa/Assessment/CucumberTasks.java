package com.qa.Assessment;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTasks {
	
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Almasa\\CucumberReport.html", true);
	ExtentTest test;
	WebDriver driver; 
	Constants c = PageFactory.initElements(driver, Constants.class);
	
@Before 
public void setup() { 
	System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
	driver = new ChromeDriver();
	} 
	
@After
public void teardown() { 
	driver.quit();
	extent.flush(); 
	}

 @Given("^that you are on the create UserScreen$")
public void that_you_are_on_the_create_UserScreen() {
	 test = extent.startTest("Create a new Jenkins user"); 
	 
	 //open Jenkins
	 driver.manage().window().maximize(); 
	 driver.get(Constants.url);
	 test.log(LogStatus.INFO, "Browser started"); 
			
	 //Null Pointer Exception crops up when trying to reference Constants.java 
	 //So have hardcoded log in instead
			
	 WebElement user = driver.findElement(By.id("j_username"));
	 user.sendKeys("admin");
			
	 WebElement pass = driver.findElement(By.name("j_password"));
	 pass.sendKeys("123456"); 
	 pass.submit(); 
			
	 //Navigate to "Manage Jenkins" 
	 WebElement manageJenkins = driver.findElement(By.linkText("Manage Jenkins"));
	 manageJenkins.click(); 
			
	 //Navigate to "Manage Users"
	 WebElement manageUsers = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Install as Windows Service'])[1]/following::dt[1]"));
	 manageUsers.click(); 
			
	 //Navigate to "Create User"
	 WebElement createUser = driver.findElement(By.linkText("Create User"));
	 createUser.click(); 
	 }

@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) {
	CreateUsers u = PageFactory.initElements(driver, CreateUsers.class);
	u.createUser(arg1, arg2, arg3, arg4);
	test.log(LogStatus.PASS, "New user(s) created");
}

@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
public void the_username_should_be_visible_on_the_UsersScreen(String arg1) {
	 driver.manage().window().maximize(); 
	 driver.get(Constants.url);
			
	 WebElement user = driver.findElement(By.id("j_username"));
	 user.sendKeys("admin");
			
	 WebElement pass = driver.findElement(By.name("j_password"));
	 pass.sendKeys("123456"); 
	 pass.submit(); 
			
	 //Navigate to "Manage Jenkins" 
	 WebElement manageJenkins = driver.findElement(By.linkText("Manage Jenkins"));
	 manageJenkins.click(); 
			
	 //Navigate to "Manage Users"
	 WebElement manageUsers = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Install as Windows Service'])[1]/following::dt[1]"));
	 manageUsers.click(); 
}

@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
public void the_username_is_visible_on_the_UsersScreen(String arg1) {
	 driver.manage().window().maximize(); 
	 driver.get(Constants.url);
			
	 WebElement user = driver.findElement(By.id("j_username"));
	 user.sendKeys("admin");
			
	 WebElement pass = driver.findElement(By.name("j_password"));
	 pass.sendKeys("123456"); 
	 pass.submit(); 
			
	 //Navigate to "Manage Jenkins" 
	 WebElement manageJenkins = driver.findElement(By.linkText("Manage Jenkins"));
	 manageJenkins.click(); 
			
	 //Navigate to "Manage Users"
	 WebElement manageUsers = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Install as Windows Service'])[1]/following::dt[1]"));
	 manageUsers.click(); 
}

@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
public void the_username_is_clicked_on_the_UserScreen(String arg1) {
	//Click users
	//My code locates the wrong Matt 
	//Tried to use the xpath for Matt instead but couldn't make it work 
		WebElement users = driver.findElement(By.linkText(arg1)); 
		users.click(); 
	}

@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) {
	 //Show users profile
	String username = arg1; 
	assertEquals("http://localhost:8080/securityRealm/user/" + username + "/", driver.getCurrentUrl());
}

@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
public void the_Username_s_profile_page_has_been_loaded(String arg1) {
	//Click users 
		 driver.getCurrentUrl(); 
}

@Given("^the configure button has been clicked on the profile page$")
public void the_configure_button_has_been_clicked_on_the_profile_page() {
	WebElement configure = driver.findElement(By.linkText("Configure"));
	configure.click(); 
}

@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) {
    ConfigurePage config = PageFactory.initElements(driver, ConfigurePage.class); 
    config.changeName(arg1);
}

@When("^I save the changes to the Configure Page$")
public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}


}

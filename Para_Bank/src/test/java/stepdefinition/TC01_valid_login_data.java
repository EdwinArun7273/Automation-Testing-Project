package stepdefinition;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import utilities.reportGenerator;
import utilities.screenshot;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.login;

public class TC01_valid_login_data  extends reportGenerator{
	screenshot shot = new screenshot(hooks.driver);
	login lo = new login(hooks.driver);
	@Given("the user is in the login page")
	public void the_user_is_in_the_login_page() {
		System.out.println("User in login page");
	}
	
	@When("he enters valid username {string} and valid password {string}")
	public void he_enters_valid_username_and_valid_password(String username, String password) throws InterruptedException 
	{	
		lo.loginCredentials(username, password);
		lo.clickLoginButton();
	}
		
	@Then("user navigates to home page")
	public void user_navigates_to_home_page () throws IOException 
	{
		logger = extent.startTest("Test Case 1: User logs in with valid username and valid password");
		boolean sts = lo.validateLogin();
		try
		{
			assertEquals(sts, false, "Login Failed");
			logger.log(LogStatus.PASS, "Test Case 1 : User logs in with valid email and valid password");
			System.out.println("Test case 1 passed");
			Allure.step("Login with valid email and valid password: PASSED");
		}
		catch(AssertionError e)
		{
			String tcn = "User logs in with valid username and valid password";
			screenshot.takeScreenshot(tcn);
			logger.log(LogStatus.FAIL, "Test Case 1 : User logs in with valid username and valid password");
			System.out.println("Test case 1 failed");
			Allure.addAttachment("Screenshot Taken", e.getMessage());
			throw e;
		}
		lo.closeLoginPage();
		extent.endTest(logger);
	}
}

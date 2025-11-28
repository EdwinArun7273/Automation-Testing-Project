package stepdefinition;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.login;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC04_blank_username_login extends reportGenerator
{
login lo = new login(hooks.driver);
	
	@When("he enters blank username {string} and password {string}")
	public void he_enters_blank_username_and_password(String username, String password) throws InterruptedException 
	{
		lo.loginCredentials(username, password);
		lo.clickLoginButton();
	}
	
	@Then("system displays error message for blank username")
	public void system_displays_error_message_for_blank_username() throws IOException 
	{
		logger = extent.startTest("Test Case 2: User logs in with invalid password");
		boolean sts = lo.validateLogin();
		if(sts == true)
		{
			logger.log(LogStatus.PASS, "Test Case 4 : User logs in with invalid password");
			assertTrue(true);
			System.out.println("Test case 4 passed");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Test Case 4 : User logs in with invalid password");
			System.out.println("Test case 4 failed");
			String tcn = "User logs in with invalid password";
			screenshot.takeScreenshot(tcn);
			assertTrue(false);
		}
		lo.closeLoginPage();
		extent.endTest(logger);
	}
}


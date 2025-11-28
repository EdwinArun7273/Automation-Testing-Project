package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.login;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC05_blank_password_login extends reportGenerator
{
login lo = new login(hooks.driver);
	
@When("he enters username {string} and blank password")
public void he_enters_username_and_blank_password(String username) throws InterruptedException 
	{
		lo.loginCredentials(username, "");
		lo.clickLoginButton();
	}
	
	@Then("system displays error message for blank password")
	public void system_displays_error_message_for_blank_password() throws IOException 
	{
		logger = extent.startTest("Test Case 5: User logs in with invalid password");
		boolean sts = lo.validateLogin();
		if(sts == true)
		{
			logger.log(LogStatus.PASS, "Test Case 5 : User logs in with invalid password");
			assertTrue(true);
			System.out.println("Test case 5 passed");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Test Case 5 : User logs in with invalid password");
			System.out.println("Test case 5 failed");
			String tcn = "User logs in with invalid password";
			screenshot.takeScreenshot(tcn);
			assertTrue(false);
		}
		lo.closeLoginPage();
		extent.endTest(logger);
	}
}

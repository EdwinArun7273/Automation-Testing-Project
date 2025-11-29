package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.login;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC02_invalid_username_login extends reportGenerator{
	login lo = new login(hooks.driver);
	
	@When("he enters invalid username {string} and password {string}")
	public void he_enters_invalid_username_and_password(String username, String password) throws InterruptedException 
	{
		lo.loginCredentials(username, password);
		lo.clickLoginButton();
	}
		
	@Then("system displays error message for invalid username")
	public void system_displays_error_message_for_invalid_username() throws IOException 
	{
		logger = extent.startTest("Test Case 2: User logs in with invalid email");
		boolean sts = lo.validateLogin();
		try
		{
			assertTrue(sts, "Login Success");
			logger.log(LogStatus.PASS, "Test Case 2 : User logs in with invalid email");
			System.out.println("Test case 2 passed");
			Allure.step("Login with invalid email and password: PASSED");
		}
		catch(AssertionError e)
		{
			String tcn = "User logs in with invalid email";
			screenshot.takeScreenshot(tcn);
			logger.log(LogStatus.FAIL, "Test Case 2 : User logs in with invalid email");
			System.out.println("Test case 2 failed");
			Allure.addAttachment("Screenshot Taken", e.getMessage());
			throw e;
		}
		lo.closeLoginPage();
		extent.endTest(logger);
	}
}

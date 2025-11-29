package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.forgetPassword;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC11_invalid_state_forgot_password extends reportGenerator
{
	screenshot shot = new screenshot(hooks.driver);
	forgetPassword fr = new forgetPassword(hooks.driver);
	
	@When("he enters valid firstname {string} and valid lastname {string} and valid address {string} and valid city {string} and invalid state {string} and valid zipcode {string} and valid ssn {string}")
	public void he_enters_valid_firstname_and_valid_lastname_and_valid_address_and_valid_city_and_invalid_state_and_valid_zipcode_and_valid_ssn(String firstname, String lastname, String address, String city, String state, String zipcode, String ssn) throws InterruptedException 
	{	
		fr.forgetPasswordData(firstname, lastname, address, city, state, zipcode, ssn);
		fr.clickFindUserButton();
	}
		
	@Then("system displays error message for invalid state")
	public void system_displays_error_message_for_invalid_state() throws IOException 
	{
		logger = extent.startTest("Test Case 11: User enters invalid state in forget password page");
		boolean sts = fr.validateData();
		try
		{
			assertTrue(sts, "Reset Password Passed");
			logger.log(LogStatus.PASS, "Test Case 11 : User enters invalid state in forget password page");
			System.out.println("Test case 11 passed");
		}
		catch(AssertionError e)
		{
			String tcn = "User enters invalid state in forget password page";
			screenshot.takeScreenshot(tcn);
			logger.log(LogStatus.FAIL, "Test Case 11 : User enters invalid state in forget password page");
			System.out.println("Test case 11 failed");
			Allure.addAttachment("Screenshot Taken", e.getMessage());
			throw e;
		}
		fr.closeForgetPasswordPage();
		extent.endTest(logger);
	}
}

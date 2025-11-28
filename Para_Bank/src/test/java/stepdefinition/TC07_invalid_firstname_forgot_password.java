package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.forgetPassword;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC07_invalid_firstname_forgot_password extends reportGenerator
{
		screenshot shot = new screenshot(hooks.driver);
		forgetPassword fr = new forgetPassword(hooks.driver);
		
		@When("he enters invalid firstname {string} and valid lastname {string} and valid address {string} and valid city {string} and valid state {string} and valid zipcode {string} and valid ssn {string}")
		public void he_enters_invalid_firstname_and_valid_lastname_and_valid_address_and_valid_city_and_valid_state_and_valid_zipcode_and_valid_ssn(String firstname, String lastname, String address, String city, String state, String zipcode, String ssn) throws InterruptedException 
		{	
			fr.forgetPasswordData(firstname, lastname, address, city, state, zipcode, ssn);
			fr.clickFindUserButton();
		}
			
		@Then("system displays error message for invalid firstname")
		public void system_displays_error_message_for_invalid_firstname() throws IOException 
		{
			logger = extent.startTest("Test Case 7: User enters invalid firstname in forget password page");
			boolean sts = fr.validateData();
			if(sts == true)
			{
				logger.log(LogStatus.PASS, "Test Case 7 : User enters invalid firstname in forget password page");
				System.out.println("Test case 7 passed");
				assertTrue(true);
			}
			else
			{
				logger.log(LogStatus.FAIL, "Test Case 7 : User enters invalid firstname in forget password page");
				System.out.println("Test case 7 failed");
				String tcn = "User enters invalid firstname in forget password page";
				screenshot.takeScreenshot(tcn);
				assertTrue(false);
			}
			fr.closeForgetPasswordPage();
			extent.endTest(logger);
		}
	}

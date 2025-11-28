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


public class TC06_valid_forgot_password_data extends reportGenerator
{
	screenshot shot = new screenshot(hooks.driver);
	forgetPassword fr = new forgetPassword(hooks.driver);
	
	@Given("the user is in the reset password page")
	public void the_user_is_in_the_reset_password_page() {
		fr.clickForgetPasswordButton();
		System.out.println("User in reset password page");
	}
	
	@When("he enters valid firstname {string} and valid lastname {string} and valid address {string} and valid city {string} and valid state {string} and valid zipcode {string} and valid ssn {string}")
	public void he_enters_valid_firstname_and_valid_lastname_and_valid_address_and_valid_city_and_valid_state_and_valid_zipcode_and_valid_ssn(String firstname, String lastname, String address, String city, String state, String zipcode, String ssn) throws InterruptedException 
	{	
		fr.forgetPasswordData(firstname, lastname, address, city, state, zipcode, ssn);
		fr.clickFindUserButton();
	}
		
	@Then("system displays username and password")
	public void system_displays_username_and_password() throws IOException 
	{
		logger = extent.startTest("Test Case 6: User enters valid data to retrive password");
		boolean sts = fr.validateData();
		if(sts == true)
		{
			logger.log(LogStatus.FAIL, "Test Case 6 : User enters valid data to retrive password");
			System.out.println("Test case 6 failed");
			String tcn = "User enters valid data to retrive password";
			screenshot.takeScreenshot(tcn);
			assertTrue(false);
		}
		else
		{
			logger.log(LogStatus.PASS, "Test Case 6 : User enters valid data to retrive password");
			System.out.println("Test case 6 passed");
			assertTrue(true);
		}
		fr.closeForgetPasswordPage();
		extent.endTest(logger);
	}
}

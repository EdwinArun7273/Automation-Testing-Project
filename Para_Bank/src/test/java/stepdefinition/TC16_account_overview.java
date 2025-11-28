package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.accountOverview;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC16_account_overview extends reportGenerator
{
	screenshot shot = new screenshot(hooks.driver);
	accountOverview ao = new accountOverview(hooks.driver);
	
	@Given("the user is in the account overview page")
	public void the_user_is_in_the_account_overview_page() throws InterruptedException
	{
		ao.enterWebPage();
		System.out.println("User In Account Overview Page");
	}
	
	@When("user selects a desired account")
	public void user_selects_a_desired_account() throws InterruptedException
	{
			ao.enterAccountOverview();
			ao.viewAccountDetails();
	}
	
	@Then("system displays account details")
	public void system_displays_account_details() throws IOException
	{
		logger = extent.startTest("Test Case 16: User enters account overview");
		boolean sts = ao.validateData();
		if(sts == true)
		{
			logger.log(LogStatus.PASS, "Test Case 16: User enters account overview");
			System.out.println("Test case 16 passed");
			assertTrue(true);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Test Case 16: User enters account overview");
			System.out.println("Test case 16 failed");
			String tcn = "User enters account overview";
			screenshot.takeScreenshot(tcn);
			assertTrue(false);
		}
		ao.closeAccountOverviewPage();
		extent.endTest(logger);
	}
}

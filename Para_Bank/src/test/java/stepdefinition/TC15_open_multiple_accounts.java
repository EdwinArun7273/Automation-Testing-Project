package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.openNewAccount;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC15_open_multiple_accounts extends reportGenerator
{
	screenshot shot = new screenshot(hooks.driver);
	openNewAccount ona = new openNewAccount(hooks.driver);
	
	
	@When("he selects account type {string} multiple times")
	public void he_selects_account_type_multiple_times(String type) throws InterruptedException
	{
		for(int i=0; i<5; i++)
		{
			ona.enterAccountInfo(type);
			ona.clickOpenNewAccountButton();
		}
	}
	
	@Then("system displays error message")
	public void system_displays_error_message() throws IOException
	{
		logger = extent.startTest("Test Case 15: User opens multiple new account");
		boolean sts = ona.validateData2();
		if(sts == true)
		{
			logger.log(LogStatus.PASS, "Test Case 15: User opens multiple new new account");
			System.out.println("Test case 15 passed");
			assertTrue(true);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Test Case 15: User opens multiple new new account");
			System.out.println("Test case 15 failed");
			String tcn = "User opens multiple new new account";
			screenshot.takeScreenshot(tcn);
			assertTrue(false);
		}
		ona.closeOpenNewAccountPage();
		extent.endTest(logger);
	}
}
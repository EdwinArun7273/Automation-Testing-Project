package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.openNewAccount;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC14_open_new_checking_account_open_new_account extends reportGenerator
{
	screenshot shot = new screenshot(hooks.driver);
	openNewAccount ona = new openNewAccount(hooks.driver);
	
	@Given("the user is in the open new accounts page")
	public void the_user_is_in_the_open_new_accounts_page() throws InterruptedException
	{
		ona.enterOpenNewAccountPage();
		System.out.println("User In Open New Account Page");
	}
	
	
	@When("he selects account type {string}")
	public void he_selects_account_type(String type) throws InterruptedException
	{
		ona.enterAccountInfo(type);
		ona.clickOpenNewAccountButton();
	}
	
	
	@Then("system creates a new account")
	public void system_creates_a_new_account() throws IOException
	{
		logger = extent.startTest("Test Case 14: User opens new CHECKING account");
		boolean sts = ona.validateData();
		try
		{
			assertTrue(sts, "Open New Account Test Failed");
			logger.log(LogStatus.PASS, "Test Case 14: User opens new CHECKING account");
			System.out.println("Test case 14 passed");
			assertTrue(true);
		}
		catch(AssertionError e)
		{
			String tcn = "User opens new CHECKING account";
			screenshot.takeScreenshot(tcn);
			logger.log(LogStatus.FAIL, "Test Case 14: User opens new CHECKING account");
			System.out.println("Test case 14 failed");
			Allure.addAttachment("Screenshot Taken", e.getMessage());
			throw e;
		}
		ona.closeOpenNewAccountPage();
		extent.endTest(logger);
	}
}

package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.transferFund;
import utilities.reportGenerator;
import utilities.screenshot;

public class TC17_transfer_fund extends reportGenerator
{
	screenshot shot = new screenshot(hooks.driver);
	transferFund tf = new transferFund(hooks.driver);
	
	@Given("the user is in the transfer fund page")
	public void the_user_is_in_the_transfer_fund_page() throws InterruptedException
	{
		tf.enterWebPage();
		System.out.println("User In Account Overview Page");
	}
	
	@When("user enters {string} and selects transfer button")
	public void user_enters_and_selects_transfer_button(String amt) throws InterruptedException
	{
			tf.enterTransferFund();
			tf.TransferFund(amt);
	}
	
	@Then("system displays success message")
	public void system_displays_success_message() throws IOException
	{
		logger = extent.startTest("Test Case 17: User transfers fund");
		boolean sts = tf.validateData();
		if(sts == true)
		{
			logger.log(LogStatus.PASS, "Test Case 17: User transfers fund");
			System.out.println("Test case 17 passed");
			assertTrue(true);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Test Case 17: User transfers fund");
			System.out.println("Test case 17 failed");
			String tcn = "User transfers fund";
			screenshot.takeScreenshot(tcn);
			assertTrue(false);
		}
		tf.closeTransferFundsPage();
		extent.endTest(logger);
	}
}

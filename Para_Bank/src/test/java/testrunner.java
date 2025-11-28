import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features", glue = {"stepdefinition"})
public class testrunner extends AbstractTestNGCucumberTests
{
	
}

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="Features",glue= {"stepdefinition"}, plugin = {
        "pretty",
        "html:ReportsFolder/cucumber_reports.html",
        "json:ReportsFolder/cucumber.json",
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"  
    },
    monochrome = true)

public class testrunner extends AbstractTestNGCucumberTests{

}
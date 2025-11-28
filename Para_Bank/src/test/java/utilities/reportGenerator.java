package utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class reportGenerator {
	public static ExtentReports extent;
    public static ExtentTest logger;  



  @BeforeSuite
  public void beforeSuite() 
  {
	  extent = new ExtentReports ("C:\\Users\\Administrator\\Documents\\Selenium Demo\\capstone\\report\\report.html", true);
  }

  @AfterSuite
  public void afterSuite() 
  {
	  extent.flush();
  }
}
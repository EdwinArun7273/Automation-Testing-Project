package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	
	public static WebDriver driver;
	
	@Before
	public void before()
	{
		driver = new EdgeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void after()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		driver.quit();
	}
}

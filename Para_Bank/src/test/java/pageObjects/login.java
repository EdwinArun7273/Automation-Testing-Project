package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class login {
	WebDriver driver;
	
	public login(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void loginCredentials(String username, String password)
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void clickLoginButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value= 'Log In']")).click();
		Thread.sleep(3000);
	}
	public boolean validateLogin()
	{
		if(driver.getTitle().contains("ParaBank | Error"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void closeLoginPage()
	{
		driver.quit();
	}
}

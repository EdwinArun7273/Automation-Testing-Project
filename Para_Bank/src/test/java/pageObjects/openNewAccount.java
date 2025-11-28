package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import stepdefinition.hooks;

public class openNewAccount {
	WebDriver driver;
	login lo = new login(hooks.driver);

	public openNewAccount(WebDriver driver)
	{
		this.driver = driver;
	}

	public void enterOpenNewAccountPage() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("user1usthp");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Pass@word123");
		driver.findElement(By.xpath("//input[@value= 'Log In']")).click();
		Thread.sleep(2000);
	}
	
	public void enterAccountInfo(String type)
	{
		driver.findElement(By.linkText("Open New Account")).click();;
		driver.findElement(By.xpath("//select[@id = 'type']")).click();
		if (type.equals("CHECKING"))
		{
			driver.findElement(By.xpath("//option[@value = '0']")).click();
		}
		else if (type.equals("SAVINGS"))
		{
			driver.findElement(By.xpath("//option[@value = '1']")).click();
		}
	}
	
	public void clickOpenNewAccountButton() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value = 'Open New Account']")).click();
		Thread.sleep(3000);
	}
	
	public boolean validateData()
	{
		if(driver.findElement(By.xpath("//*[contains(text(),'Congratulations, your account is now open.')]")).isDisplayed())										  
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean validateData2()
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
	public void closeOpenNewAccountPage()
	{
		driver.quit();
	}
}

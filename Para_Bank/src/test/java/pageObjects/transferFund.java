package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class transferFund {
	WebDriver driver;

	public transferFund(WebDriver driver) {
		this.driver = driver;
	}

	public void enterWebPage() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("user1usthp");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Pass@word123");
		driver.findElement(By.xpath("//input[@value= 'Log In']")).click();
		Thread.sleep(2000);
	}
	
	public void enterTransferFund() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(), 'Transfer Funds')]")).click();
		Thread.sleep(2000);
	}
	
	public void TransferFund(String amt) throws InterruptedException
	{
		driver.findElement(By.id("amount")).sendKeys(amt);
		driver.findElement(By.xpath("//input[@value = 'Transfer']")).click();
		Thread.sleep(2000);
	}
	
	public boolean validateData()
	{
		if(driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]")).isDisplayed())										  
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void closeTransferFundsPage()
	{
		driver.quit();
	}
}

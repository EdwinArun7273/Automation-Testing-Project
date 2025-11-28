package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class accountOverview {
	WebDriver driver;

	public accountOverview(WebDriver driver) {
		this.driver = driver;
	}

	public void enterWebPage() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("user1usthp");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Pass@word123");
		driver.findElement(By.xpath("//input[@value= 'Log In']")).click();
		Thread.sleep(2000);
	}
	
	public void enterAccountOverview() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(), 'Accounts Overview')]")).click();
		Thread.sleep(2000);
	}
	
	public void viewAccountDetails() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).click();
		Thread.sleep(2000);
	}
	
	public boolean validateData()
	{
		if(driver.findElement(By.xpath("//h1[contains(text(),'Account Activity')]")).isDisplayed())										  
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void closeAccountOverviewPage()
	{
		driver.quit();
	}
}

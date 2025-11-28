package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class forgetPassword {
WebDriver driver;

	public forgetPassword(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickForgetPasswordButton() 
	{
		driver.findElement(By.linkText("Forgot login info?")).click();
	}
	
	public void forgetPasswordData(String firstname, String lastname, String address, String city, String state, String zipcode, String ssn)
	{
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("address.street")).sendKeys(address);
		driver.findElement(By.name("address.city")).sendKeys(city);
		driver.findElement(By.name("address.state")).sendKeys(state);
		driver.findElement(By.name("address.zipCode")).sendKeys(zipcode);
		driver.findElement(By.name("ssn")).sendKeys(ssn);
	}
	
	public void clickFindUserButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value = 'Find My Login Info']")).click();
		Thread.sleep(3000);
	}
	
	public boolean validateData()
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
	
	public void closeForgetPasswordPage()
	{
		driver.quit();
	}
}

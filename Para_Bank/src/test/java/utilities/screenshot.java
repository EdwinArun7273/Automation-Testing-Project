package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.messages.internal.com.google.common.io.Files;

public class screenshot {
	static WebDriver driver;

	public screenshot(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public static void takeScreenshot(String tcn) throws IOException
	{
		File srcFile;
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("C:\\Users\\Administrator\\Documents\\Selenium Demo\\capstone\\screenshots\\" + tcn + ".jpeg"));
		System.out.println("Screenshot Taken for Test Case : " + tcn);
	}
}

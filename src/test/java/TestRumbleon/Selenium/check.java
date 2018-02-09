package TestRumbleon.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class check {

	@Test
	public void ff() {
		System.setProperty("webdriver.gecko.driver", "F:\\Resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.toolsqa.com");
		driver.manage().window().maximize();
		
		
	}
}

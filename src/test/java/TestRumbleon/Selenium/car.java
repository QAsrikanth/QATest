package TestRumbleon.Selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class car {

	@Test
	public void browser () {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Resources\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
	
		driver.get("http://qatradeinvalet.azurewebsites.net/TradeInVallet/TradeInValet?EncryptDealerId=LfrGciTAW3QiWjAIP5UXng%3D%3D");
		driver.manage().window().maximize();
		
	List<WebElement> element =	driver.findElements(By.xpath("//select[@id='CBRYear']"));
	
	Iterator<WebElement> element1 =element.iterator();
	
	int i ;
	while(element1.hasNext()){
		i=0;
	
		WebElement o =element1.next();
		
		System.out.println(o.getText()+"--"+i);
		
	}
	
	}
	
	
	
	/*int l = s.length();
	
	System.out.println(s );
	
	for(int i =1;i<l;i++) {
	
		System.out.println(s+"-->"+i);
	}
	
	
	}
	*/
}

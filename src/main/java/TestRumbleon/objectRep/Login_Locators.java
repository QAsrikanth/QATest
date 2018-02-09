package TestRumbleon.objectRep;

import org.openqa.selenium.By;

public class Login_Locators {

	
	public static By  Signin  =By.xpath("//*[@id='home']/div[2]/nav/div/ul/ul[1]/li[1]/a");
	public static By Are_you_customer = By.linkText("CUSTOMER");
	public static By username = By.xpath(".//*[@id='user_name'][1]");
	public static By password = By.xpath(".//*[@id='login_password']");
	public static By login = By.xpath("//button[@id='btnLogin']");
	public static By login_confirm = By.xpath("//div[@class='profile_pic']");
	
	
}

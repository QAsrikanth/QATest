package TestRumbleon.Selenium;

import org.testng.annotations.Test;

import TestRumbleon.UIpages.LoginPage;
import TestRumbleon.library.Base;

public class LoginApp extends Base {

	
	LoginPage Login= new LoginPage();
	
	@Test
	public void Login_process() throws InterruptedException {
	
		Login.Signin();
		Login.Are_you_customer();
		Login.Username();
		Login.Password();
		Login.Login();
	}
	
	
}

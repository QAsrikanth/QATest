package TestRumbleon.UIpages;

import org.openqa.selenium.By;

import TestRumbleon.library.Base;
import TestRumbleon.library.Util;
import TestRumbleon.objectRep.Login_Locators;

public class LoginPage extends Util {
	boolean status;

	public void Signin() {
		
		
		
		
		System.out.println(getdata("Password"));
		System.out.println(getdata("Search11"));
		status = clickElement(Login_Locators.Signin, driver);
		Logevents(status, "clicked on signin", "Not clicked on signin ");
		System.out.println(status + "click on sign in ");

	}

	public void Are_you_customer() {

		status = clickElement(Login_Locators.Are_you_customer, driver);
		Logevents(status, "Selected Are_you_customer", "Not selected Are_you_customer");
		System.out.println(status + "click are you a customer ");
	}

	public void Username() {

		status = SetText(Login_Locators.username,  getdata("Username"), driver);
		Logevents(status, "Enter Username ", "Not able to enter username   ");
		System.out.println(status + "Enter user name ");

	}

	public void Password() {

		status = SetText(Login_Locators.password, getdata("Password"), driver);
		Logevents(status, "Enter Password", "Not able to enter password  ");
		System.out.println(status + "Enter password ");
	}

	public void Login() {

		status = clickElement(Login_Locators.login, driver);
		Logevents(status, "clicked on Login ", "Not clicked on login  ");
		System.out.println(status + "click on login ");
	}

	public void Login_confirm() {

		
		Logevents(status, "clicked on Login ", "Not clicked on login  ");
		System.out.println(status + "click on login ");
	}
	
	
}

package TestRumbleon.Selenium;

import org.testng.annotations.Test;

import TestRumbleon.UIpages.BuyPage;
import TestRumbleon.UIpages.LoginPage;
import TestRumbleon.library.Base;

public class Buy extends Base{
	
	BuyPage buy_p =new BuyPage();
	//LoginApp Login = new LoginApp();
	LoginPage Login = new LoginPage();
	
	@Test
	public void buy() throws InterruptedException 
	
	{
		Login.Signin();
		Login.Are_you_customer();
		Login.Username();
		Login.Password();
		Login.Login();
		buy_p.buy();	
		buy_p.search();
		//buy_p.click_Search();
		buy_p.Verify_Tab_counts();
		buy_p.Verify_tab_counts_List_header_count();
	}

}

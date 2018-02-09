package TestRumbleon.UIpages;

import TestRumbleon.library.Util;
import TestRumbleon.objectRep.Buy_Locators;

public class BuyPage extends Util{
	boolean status;

	public void buy() {
		
		System.out.println(getdata("Browser"));
		System.out.println(getdata("Search11"));
		
		
	status =clickElement(Buy_Locators.Buy, driver);	
	Logevents(status, "click on buy menu ", "Un able to click on buy menu ");
		
	}
	public void search() {
		
	status =SetText(Buy_Locators.search, getdata("Search11"), driver);	
	Logevents(status, "enter search text  ", "Un able to enter search text  ");	
	}
	
	
	public void click_Search () {
		  clickElement(Buy_Locators.click_search, driver);
		  Logevents(status, "click search icon  ", "Un able to click search icon   ");	
	}
	
	
	public void Verify_Tab_counts () throws InterruptedException {
		
		Thread.sleep(2000);
		String all_count =Text(Buy_Locators.All, driver);
		String Rc_count =Text(Buy_Locators.R_CR, driver);
		String RL_count =Text(Buy_Locators.R_Ls, driver);
		String Rk_count =Text(Buy_Locators.R_Tk, driver);
		
		int all = Integer.parseInt(all_count);
		int RC = Integer.parseInt(Rc_count);
		int RL = Integer.parseInt(RL_count);
		int Rk = Integer.parseInt(Rk_count);
		
		int total  =RC+RL+Rk ;
		boolean status;
		
		if(all==total) {
			status=true;
			Logevents(status, "All tab count is equal to  RumbleOn Certified + Listed +Tinker", " ");	
		}else {
			status=false;
			Logevents(status, " ", "All tab count is  not  equal to  RumbleOn Certified + Listed +Tinker");	
		}
		
		
	}
	
	public void Verify_tab_counts_List_header_count() {
		
		String Rc_count =Text(Buy_Locators.R_CR, driver);
		String RL_count =Text(Buy_Locators.R_Ls, driver);
		String Rk_count =Text(Buy_Locators.R_Tk, driver);
		
		String Rc_Lscount =Text(Buy_Locators.R_CR_List, driver);
		String RL_Lscount =Text(Buy_Locators.R_Ls_List, driver);
		String RK_Lscount =Text(Buy_Locators.R_Tk_List, driver);
		
		
		System.out.println(Rc_Lscount);
		
		
		MoveToElement(Buy_Locators.R_Ls_List, driver);
		
		System.out.println(RL_Lscount);
		
		MoveToElement(Buy_Locators.R_Tk_List, driver);
		
		System.out.println(RK_Lscount);
	}
	
	
}

package TestRumbleon.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

public class Base  extends Util{

	@BeforeSuite
	public void beforesuite() {
		
		Properties prop = new Properties();
		InputStream input;
		try 
		{
			input = new FileInputStream("F:\\Selenium\\config\\config.Properties");
			prop.load(input);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to load data from configuraton.properties file");
		}
		
		
		CommVar_BrowserName  = prop.getProperty("BrowserName");	
		CommVar_BaseURL =prop.getProperty("Url");
		
		// get current folder path
				CurrentFolderPath = System.getProperty("user.dir") + "\\Results";
				// create folder with date and time stamp
				DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
				String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
				DateTimeStamp = DateTimeStamp.replace(",", "");
				DateTimeStamp = DateTimeStamp.replace(" ", "_");
				DateTimeStamp = DateTimeStamp.replace(":", "-");
				CurrentFolderPath = CurrentFolderPath + "\\" + DateTimeStamp;
				File dir = new File(CurrentFolderPath);
				dir.mkdir();
		
		//System.out.println(CommVar_BrowserName);
		
		// create extent report
				TestReport = new ExtentReports(CurrentFolderPath + "\\Summary.html", true);
		
				//TestReport.loadConfig(new File(System.getProperty("F:\\Selenium\\config\\Extent.properties")));
				TestReport.loadConfig(new File("F:\\Selenium\\config\\Extent.properties"));
				
				TestReport.addSystemInfo("Environment", "Automation Testing");
				TestReport.addSystemInfo("User Name", "SRIKANTH");
				
				
				
				
				
				// create screen
				 ScreenshotsFolderPath=CurrentFolderPath + "\\Screenshots";
				 
				File screenshotdir = new File(ScreenshotsFolderPath);
				screenshotdir.mkdir();
	}
	
	@BeforeMethod
	public void beforemethod(Method method) {
		if (CurrentTestData != null)
			CurrentTestData.clear();
		
		CurrentModuleName	=	method.getName();
		System.out.println(CurrentModuleName);

		
		
		//System.out.println("aaaaaaaaaa");
		
		CurrentTestCasename	 =this.getClass().getSimpleName();
		
		CurrentTestData=elib_loadData(CurrentTestCasename,CurrentModuleName);
		
		//String x=	result.getMethod().getMethodName();
		//System.out.println("3333333333333"+x);
		
		CommVar_test = TestReport.startTest(CurrentModuleName);
		
		
		System.out.println("<<TestStart>>" + CurrentTestCasename);
		
		
        String browser = getdata("Browser");
        driver = launchBrowser(browser);
        
        
        
		System.out.println(browser + " -->opening");
		LaunchApplication(CommVar_BaseURL);
		
		
		driver.manage().window().maximize();
		
	}
	
	
	@BeforeClass
	public void beforeclass() {
		
	}
	
	
	
	@AfterMethod
	public void Aftermethod() {
		TestReport.endTest(CommVar_test);
		//driver.close();
	}
	
	
	@AfterSuite
	public void Aftersuite() {
		
		TestReport.close();
	}
	
	
	
	
}

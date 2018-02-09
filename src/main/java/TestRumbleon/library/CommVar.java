package TestRumbleon.library;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CommVar {

	
	protected static WebDriver driver;
	protected static String CommVar_BrowserName;
	protected static String CurrentTestCasename;
	protected static String CommVar_BaseURL;
	protected static boolean highlightelement = true;
	protected  static ExtentReports TestReport;
	protected static ExtentTest CommVar_test;
	protected static String CurrentFolderPath;
	protected static boolean CommVar_TakeScreenshotForEveryStep=true;
	protected static String ScreenshotsFolderPath;
	protected static HashMap<String,String> CurrentTestData;
	protected static String CurrentModuleName;
}


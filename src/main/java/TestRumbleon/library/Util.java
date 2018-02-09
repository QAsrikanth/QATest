package TestRumbleon.library;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class Util extends CommVar {

	public WebDriver launchBrowser(String browser) {

		WebDriver Tempdriver = null;
		//String browser = CommVar_BrowserName;

		switch (browser.toLowerCase()) {
		
		case "firefox": {
			
		
			
		

			
				System.setProperty("webdriver.gecko.driver", "F:\\Resources\\geckodriver.exe");
				Tempdriver = new FirefoxDriver();	
			
			break;
		}
		
		
		case "ie":
		case "internetexplorer": {
			System.setProperty("webdriver.ie.driver", "BrowserServers\\IEDriverServer.exe");
			Tempdriver = new InternetExplorerDriver();
			break;
		}
		
		
		
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "F:\\Resources\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("disable-infobars"); 
			//WebDriver driver = new ChromeDriver(options);
		
			Tempdriver = new ChromeDriver();
			break;
		}
		
		
		
		default: {
			System.out.println("please Select the correct browser");
		}
		}
		return Tempdriver;
	}

	public boolean SetText(By element, String value,WebDriver driver) {

		boolean status;

		try {
			if(highlightelement) highlight(element, driver);
			//driver.findElement(element).click();
			//driver.findElement(element).clear();
			driver.findElement(element).sendKeys(value);
			status = true;
		} catch (Exception e) {
			System.out.println(e);
			status = false;

		}

		return status;
	
	}
	public boolean clickElement (By element,WebDriver driver  ) {
		
		boolean status = false;
		try {
			if(highlightelement) highlight(element, driver);
			driver.findElement(element).click();
			status = true;
		}catch(Exception e) {
			System.out.println(e);
			status = false;
		}
		
		return status;
		
	}
	public boolean LaunchApplication(String Url ) {
		boolean status = false;	
		try {
			
			driver.get(Url);
			status = true;
		}catch(Exception e) {
			status = false;	
		}
		
		
		
		return false;
		
		
	}
	
	
	public static String Text(By element,WebDriver driver ) {
		
		String App_Text = null ;
		try {
			if(highlightelement) highlight(element, driver);
		 App_Text =	driver.findElement(element).getText();
		}catch(Exception e) {
			System.out.println(" unable to get text from application ");
		}
		
		return App_Text;
		
		
		
	}
	public boolean MoveToElement(By r_Ls_List,WebDriver driver) {
		
		boolean status = false;
		try {
			Actions builder = new Actions(driver);
	        builder.moveToElement((WebElement) r_Ls_List).build().perform();
	
	        status=true;
		}catch(Exception e) {
			 status=false;
		}
		
		
		return status;
		
		
		
	}
	
	
	
	
	
	
	
	
	protected static void highlight(By by,WebDriver driver)
	{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        try
        {
	        WebElement ele = driver.findElement(by);
	        for(int i = 1;i<=2;i++)
	        {
	        	Thread.sleep(400);
		        js.executeScript("arguments[0].style.border='solid 4px black'", ele);
				Thread.sleep(400);
		        js.executeScript("arguments[0].style.border=''", ele);
	        }
        }
        catch(Exception e)
        {
        	
        }
           
	}
	
	public static void Logevents(boolean status, String Pass, String Fail) {

		if (CommVar_TakeScreenshotForEveryStep == false) {

			if (status == true) {

				CommVar_test.log(LogStatus.PASS, Pass);
				System.out.println("	<<Pass>> " + Pass);

			} else {

				String ScreenShotPath = getScreenShort(driver);
				String LoggerScreenShotpath = CommVar_test.addScreenCapture(ScreenShotPath);
				CommVar_test.log(LogStatus.FAIL, Fail +LoggerScreenShotpath);
				System.out.println("	<<Pass>> " + Fail);
				
				
				
			}

		} else {

			if (status == true) {
				String ScreenShotPath = getScreenShort(driver);
				String LoggerScreenShotpath = CommVar_test.addScreenCapture(ScreenShotPath);
				CommVar_test.log(LogStatus.PASS, Pass+LoggerScreenShotpath);
				System.out.println("	<<Pass>> " + Pass);

			} else {
				String ScreenShotPath = getScreenShort(driver);
				String LoggerScreenShotpath = CommVar_test.addScreenCapture(ScreenShotPath);
				CommVar_test.log(LogStatus.FAIL, Fail+LoggerScreenShotpath);
				System.out.println("	<<Pass>> " + Fail);
			}

		}
		
		
	}
	public static String  getScreenShort(WebDriver driver) {
		
		try {
			
			String ScreenshotName;
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
			DateTimeStamp = DateTimeStamp.replace(",", "");
			DateTimeStamp = DateTimeStamp.replace(" ", "_");
			DateTimeStamp = DateTimeStamp.replace(":", "_");
			ScreenshotName =  CurrentTestCasename + "_"+ DateTimeStamp;
			
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String Dest = ScreenshotsFolderPath + "//" + ScreenshotName + ".png";
			File destination = new File(Dest);
			
	
			FileUtils.copyFile(source, destination);
			return Dest;
			
		}	
			catch(Exception e) {
				return e.getMessage();	
			
		}
		
		
	}
	
  // Excel data 
	public void putdata(String FieldName,String FieldValue)

	{
		
		if(CurrentTestData.containsKey(FieldName))
		{
			CurrentTestData.put(FieldName, FieldValue);
		}
		else
		{
			System.out.println("'" + FieldName + "' Field Name Not Found");
		}
	}
		
	
	
	
	public String getdata(String FieldName)
	{
		if(CurrentTestData.containsKey(FieldName))
			
		{
			 CurrentTestData.get(FieldName);
		
			return CurrentTestData.get(FieldName);
			
		}
		else
		{
			System.out.println("Data Not Found For '" + FieldName + "' Field");
			return null;
		}
	}
	public HashMap<String,String> elib_loadData(String TestCaseName,String Module)
	{
		
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HashMap<String,String> TestData = new HashMap<String,String>();
		try
		{		
			//String FilePath = CommVar_DataFilesPath + "\\Module1.xlsx";
		
			
			//File f1 = new File("F:\\Selenium\\TestData\\Login1.xls");
			
			
			
			
			FileInputStream fis = new FileInputStream("F:\\Selenium\\TestData\\Login1.xls");
			HSSFWorkbook wb1 = new HSSFWorkbook(fis);
			
			HSSFSheet ws1 = wb1.getSheet(TestCaseName);
			
			int rowcount = ws1.getLastRowNum();
			for(int r = 0;r<=rowcount;r++)
			{
				if(ws1.getRow(r).getCell(0)!=null)
				{
					String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
					if(Excel_TestCaseName.equalsIgnoreCase(Module))
					{
						int datarow = r + 1;
						int valuerow = r + 2;
						int cellcount = ws1.getRow(datarow).getLastCellNum();
						for(int c = 0;c<cellcount;c++)
						{
							String ExcelFieldName="";
							String ExcelFieldValue="";
							
							if(ws1.getRow(datarow).getCell(c)!=null) {
								
								
								HSSFCell cell= ws1.getRow(datarow).getCell(c);
								
								
								
								if(cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
									
									ExcelFieldName = NumberToTextConverter.toText(cell.getNumericCellValue());	
								}else {
									ExcelFieldName=cell.getStringCellValue();
									
								}
							
							}
							if(ws1.getRow(valuerow).getCell(c)!=null) {
								
								HSSFCell cell2= ws1.getRow(valuerow).getCell(c);
								
								if(cell2.getCellType() == cell2.CELL_TYPE_NUMERIC) {	
								
									ExcelFieldName = NumberToTextConverter.toText(cell2.getNumericCellValue());	
								
							}else {
								
								ExcelFieldValue =cell2.getStringCellValue();
							}
							
							}
							
							
							
							/*if(ws1.getRow(valuerow).getCell(c)!=null) {
								
							ExcelFieldValue = ws1.getRow(valuerow).getCell(c).getStringCellValue();
							}*/
							
							if(ExcelFieldName.length()>1) {
							TestData.put(ExcelFieldName, ExcelFieldValue);
							}
						}
						break;
					}
				}
			}
			//fis.close();
			//ws1.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Exception occured while reading data of '" + TestCaseName + "'  TestCase ");
		}
		
		
		return TestData;
	}
}

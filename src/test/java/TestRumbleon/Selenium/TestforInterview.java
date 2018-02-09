package TestRumbleon.Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import jdk.nashorn.internal.codegen.types.Type;

public class TestforInterview {
	
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ch.srikanth\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://rumbleonqa.tracker.bike");
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='SIGN IN' and @href='#DealerCustomer'])[2]"))).click();
		driver.findElement(By.xpath("//a[text()='CUSTOMER']")).click();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("qa.ram459@gmail.com");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Ab1234$");
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		
		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='home']/div[2]/nav/div/ul/li[2]/a"))).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='searchText']"))).sendKeys("BMW");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='searchText']"))).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='dvPreferred']/div/a/div/div[2]/div[1]/div[1]/h1")));
		
		
		List<WebElement> matchedrecords=driver.findElements(By.xpath("//div[@id='dvPreferred']/div/a/div/div[2]/div[1]/div[1]/h1"));
		
		String a;
		
		for(int i=0;i< matchedrecords.size();i++) {
			
			System.out.println(matchedrecords.get(i).getText());
			a=matchedrecords.get(i).getText();
			
		}
		
		ExcelRead(matchedrecords);
		
         
       
 
      
    }
	
	public void ExcelRead(List a) throws Exception{
		
		
		Object[] b=a.toArray();
		
		

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Results in Java");
        
        System.out.println("Creating excel");

       // for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(0);
            int colNum = 0;
            for (Object field : b) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
       // }

        try {
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Ch.srikanth\\Desktop\\ResultsTest.xls");
            workbook.write(outputStream);
         
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		
		
		
		
		/*FileInputStream fis=new FileInputStream("C:\\Users\\Ch.srikanth\\Desktop\\ResultsTest.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheetAt(0);
        
    int lastrow= sheet.getLastRowNum();
    for(int row=0;row<lastrow;row++) {
    	int lastcellnumber=sheet.getRow(row).getLastCellNum();
    	for(int cellno=0;cellno<lastcellnumber;cellno++) {
    		
    		Cell cell=sheet.getRow(row).getCell(cellno);
    		
    		for(int i=0;i<a.size();i++) {
    		if (cell==CellFormatType.TEXT) {
                cell.setCellValue(((WebElement) a.get(i)).getText());
            } else if (cell==CellFormatType.NUMBER) {
            	cell.setCellValue(Integer.parseInt(((WebElement) a.get(i)).getText()));
            }
    		
    		}
    		
    	}*/
    	
  //  }
         
        
          
        
         
         
       /* try {FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Ch.srikanth\\Desktop\\ResultsTest.xls"); 
            workbook.write(outputStream);
            outputStream.close();
        }
        catch(Exception e) {
        	
        }*/
		
		
	}
		
}
		
		
		
		
		
		
		
		

	


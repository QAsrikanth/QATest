package TestRumbleon.GenerateXml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GetStatus {
	
	static HSSFWorkbook wb;
	static HSSFSheet sh;
	static int R;
	
	
	
	public GetStatus(String File) throws IOException {
		
		FileInputStream fs =new FileInputStream(File);
		
		 wb = new HSSFWorkbook(fs);
		
	}
	
	
	public static List<String> storeTestcaseNeedToExecute(String sheet) throws IOException{
		
		ArrayList<String> list1= new ArrayList<String>();
		/*FileInputStream fs =new FileInputStream("F:\\Test2.xls");
		
		 wb = new HSSFWorkbook(fs);
		*/
		
		sh=wb.getSheet(sheet);
		
		R=sh.getLastRowNum();
		
		
		System.out.println(R);
		for(int i = 0;i<R+1;i++) {
			
			
			String Testcase = sh.getRow(i).getCell(0).getStringCellValue();
			//System.out.println(Testcase);
			String Execute = sh.getRow(i).getCell(1).getStringCellValue();
			//System.out.println(Execute);
			
			if(Execute.equalsIgnoreCase("YES")) {
				
				
				list1.add(Testcase);	
					
			}
			
		}
		
		 
		return list1;
		
		
	}
/*
	public static void main (String arg[]) throws IOException {
		GetStatus bb =new GetStatus();
		bb.storeTestcaseNeedToExecute("Sheet1");
	}*/
	

}

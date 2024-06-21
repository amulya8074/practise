package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	
	 public String readExcel(int rownum, int colnum, String readfile) throws Exception{

		  

		  File file = new File(System.getProperty("user.dir")+"\\ExcelFiles\\"+readfile+".xlsx");

		  System.out.println(file);

		  FileInputStream fis = new FileInputStream(file);

		  XSSFWorkbook wb = new XSSFWorkbook(fis);

		Sheet s1=wb.getSheetAt(0);
		 
		 String data=s1.getRow(rownum).getCell(colnum).getStringCellValue();
		 
		 return data;

		  

		 

		  

	  }
}

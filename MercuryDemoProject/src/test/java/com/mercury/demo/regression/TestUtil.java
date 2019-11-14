package com.mercury.demo.regression;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class TestUtil {
	static Workbook book;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH="D:\\eclipse-workspace\\MercuryDemoProject\\src\\test\\java\\com\\mercury\\demo\\pages\\Airline.xlsx";
	public static Object[][] getTestData(String sheetName) {
		
		FileInputStream file = null;
				
			try {
				file=	new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		try {
			book= WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    

	    
	    //Read sheet inside the workbook by its name

	    sheet  = book.getSheet(sheetName);
	    Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    

	  
	    for (int i = 0; i < sheet.getLastRowNum(); i++) {
	    	Row row =sheet.getRow(i+1);
	    	
	        for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
	        	 Cell cell = row.getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); 
	        	 String value;
	                try {
	                    value = cell.getRichStringCellValue().toString();
	                } catch (Exception e) {
	                    value = ((XSSFCell) cell).getRawValue();
	                }
	        
	           data[i][j]= value;

	        }

	     
	    } 
	    return data;

	    }  

	    

}

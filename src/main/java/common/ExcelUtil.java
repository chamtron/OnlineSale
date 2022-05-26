package common;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import jxl.Cell;
//import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil{
    
    private Map<String, Integer> columns = new HashMap<>();
    
    private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	
    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   ExcelWBook = new XSSFWorkbook(ExcelFile);

			   ExcelWSheet = ExcelWBook.getSheet(SheetName);

			   int startRow = 1;

			   int startCol = 0;

			   int ci,cj;

			   int totalRows = ExcelWSheet.getLastRowNum();

			   // you can write a function as well to get Column count

			   int totalCols = 3;

			   tabArray=new String[totalRows][totalCols];

			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

				  cj=0;

				   for (int j=startCol;j<totalCols;j++, cj++){

					   tabArray[ci][cj]=getCellData(i,j);

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}
    
    public static String getCellData(int RowNum, int ColNum) {

		

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			
			
			 
			
			//CellType dataType = Cell.getCellType();
			
			switch (Cell.getCellType()) {
	        case NUMERIC:
	            int data = (int) Cell.getNumericCellValue();
	            return String.valueOf(data);
	        case STRING:
	            return Cell.getStringCellValue();
	        case ERROR:
	            return String.valueOf(Cell.getErrorCellValue());
	        case BLANK:
	            return "";
	        case FORMULA:
	            return Cell.getCellFormula();
	        case BOOLEAN:
	            return String.valueOf(Cell.getBooleanCellValue());
	    }
			return "error decoding string value of the cell";
    }



public By getLocator(String ex, String typeEx, String param) {
	By result;
	switch (typeEx) {
	case "id":
		result = By.id(ex);
		break;
	case "xpath":
		result = By.xpath(ex);
		break;
	case "linkText":
		result = By.linkText(ex);
		break;
	case "className":
		result = By.className(ex);
		break;
	case "cssSelector":
		result = By.cssSelector(ex);
		break;
	case "name":
		result = By.name(ex);
		break;
	case "partialLinkText":
		result = By.partialLinkText(ex);
		break;
	case "tagName":
		result = By.tagName(ex);
		break;
	case "xpath_param":
		result = By.xpath(ex.replace("${param}", param));
		break;
	default:
	result = null;
	}
	return result;
}
    
//public static List<HashMap<String,String>> getTestData(String FilePath,
//String SheetName, String tableName) {
//
//List<HashMap<String,String>> listData = new
//
//ArrayList<HashMap<String,String>>();
//
//try {
//	Workbook workbook = Workbook.getWorkbook(new File(FilePath));
//	  Sheet sheet = workbook.getSheet(SheetName);
//	int startRow, startCol, endRow, endCol;
//	Cell tableStart = sheet.findCell(tableName);
//	startRow = tableStart.getRow();
//	startCol = tableStart.getColumn();
//	Cell tableEnd = sheet.findCell(tableName, startCol + 1,startRow + 1, 100, 64000, false);
//
//	endRow = tableEnd.getRow();
//	endCol = tableEnd.getColumn();
//	info("Loaded data from Excel: Row["+ startRow + ".." + endRow + "], Columns[" + startCol + ".." + endCol + "]");
//
//	for(int i = startRow + 1; i < endRow; i++)
//	{
//	HashMap<String,String> valSet = new HashMap<String,String>();
//
//		for(int j = 1; j <endCol; j++)
//		{
//		
//		valSet.put(sheet.getCell(j,startRow).getContents(), sheet.getCell(j, i).getContents());
//		
//		}
//		listData.add(valSet);
//
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return (listData);
//	}
//
//private static void info(String string) {
//	// TODO Auto-generated method stub
//	
//}
	
}

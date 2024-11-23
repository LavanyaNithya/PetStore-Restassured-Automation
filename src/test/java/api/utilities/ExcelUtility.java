package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet s;
	public Row row;
	public Cell cell;
	
	
	public ExcelUtility(String path)
	{
		this.path = path;               //constructor to set the path of the excel
	}
	
	public int getRowCount(String sheetName) throws IOException        //method to return the total row count
	{
	   fis = new FileInputStream(path);
	   wb = new XSSFWorkbook(fis);
	   s = wb.getSheet(sheetName);
       int rowcount = s.getPhysicalNumberOfRows();
       wb.close();
       fis.close();
       return rowcount;
	   
	 }
	
	public int getCellCount(String sheetName,int rownum) throws IOException     //method to return the total cell count
	{
	   fis = new FileInputStream(path);
	   wb = new XSSFWorkbook(fis);
	   s = wb.getSheet(sheetName);
	   row = s.getRow(rownum);               
	   int cellcount = row.getPhysicalNumberOfCells();
       wb.close();
       fis.close();
       return cellcount;
	   
	 }
	
	public String getCellData(String sheetName,int rownum,int cellnum) throws IOException      //method to get the cell data
	{
		 fis = new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 s = wb.getSheet(sheetName);
		 row = s.getRow(rownum);
		 cell = row.getCell(cellnum);
		 DataFormatter dft = new DataFormatter();
		 String data = dft.formatCellValue(cell);
		 wb.close();
	     fis.close();
		 return data;   
		
	}
		
	
}

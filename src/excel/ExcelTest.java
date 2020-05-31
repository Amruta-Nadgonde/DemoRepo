package excel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ExcelTest {
	
	WebDriver driver;
	XSSFWorkbook wkbk;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	FileOutputStream fout;
	FileInputStream fin;
	File f;
	
	
	@SuppressWarnings("deprecation")
	public String cellToString(XSSFCell cell)
	{
		Object data=null;
		
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_NUMERIC:
			data = cell.getNumericCellValue();
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			data = cell.getBooleanCellValue();
			break;
		case XSSFCell.CELL_TYPE_STRING:
			data = cell.getStringCellValue();
			break;

		default:
			break;
		}
		return data.toString();
	}
	@Test(priority =1)
	public void writeExcel() throws IOException {
		
		String [][] data = getData();
		
		wkbk = new XSSFWorkbook();
		
		sheet = wkbk.createSheet("data");
		
		for(int r =0; r< data.length; r++)
		{
			row = sheet.createRow(r);
			for(int c =0 ; c< 3; c++)
			{
				cell = row.createCell(c);
				cell.setCellValue(data[r][c]);
			}
		}
		
		wkbk.write(fout);
		wkbk.close();
		fout.close();
	  
	}
  
	@Test(priority =2)
	public void readExcel() throws IOException
	{
		wkbk = new XSSFWorkbook(fin); 
		 sheet = wkbk.getSheetAt(0);
		
		 for(Row r : sheet )
		 {
			 for(Cell c : r)
			 {
				 System.out.println(cellToString((XSSFCell) c));
			 }
		 }
		 
		 wkbk.close();
		 fin.close();
	}
	@BeforeClass
	public void beforeClass() throws IOException {
		
		f = new File("exceltest.xlsx");
		fout = new FileOutputStream(f);
		fin = new FileInputStream(f);
	}

	@AfterClass
	public void afterClass() {
	}

	@DataProvider
	@Test
	public String [][]getData()
	{
		String data [][] = {{"Comapny", "City", "Zip"}
		  ,{"HSBC", "Mumbai", "400001"},{"Infosys", "Pune", "411057"}};

		return data;
	}
}

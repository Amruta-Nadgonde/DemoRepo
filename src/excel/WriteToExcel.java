package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteToExcel {

	public static void main(String[] args) throws IOException {


		File f = new File("Demo.xlsx");
		FileOutputStream fout = new FileOutputStream(f);

		
		XSSFWorkbook wkbk = new XSSFWorkbook();
		
		XSSFSheet sheet = wkbk.createSheet("data");
		
		XSSFRow row = sheet.createRow(0);
		
		XSSFCell cell = row.createCell(0);
		
		cell.setCellValue("xyz");
		
		wkbk.write(fout);
		
		wkbk.close();
		
		fout.close();
		
		FileInputStream fin = new FileInputStream(f);
		
		wkbk = new XSSFWorkbook(fin);
		
		sheet = wkbk.getSheetAt(0);
		
		row = sheet.getRow(0);
		
		cell = row.getCell(0);
		
		System.out.println(cell.getStringCellValue());
		
	}

}

package framework;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class DDT {
	WebDriver driver;
	File f;
	XSSFWorkbook wkbk;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	 XSSFSheet resultsheet;
	
	FileInputStream fin;
	FileOutputStream fout;

	
	String[][] data;
	String expMsg ="Invalid Username/Password";
	String actMsg;
	
  @Test(dataProvider = "readExcel")
  public void login(String username, String password) {
	  
	  driver.findElement(By.id("txtCustomerID")).sendKeys(username);
	  driver.findElement(By.id("txtPassword")).sendKeys(password);
	  driver.findElement(By.id("Butsub")).click();
	  
	  actMsg  = driver.findElement(By.id("lblMsg")).getText();
	  assertEquals(actMsg, expMsg);
  }
  
  @DataProvider
  public String [][] readExcel() throws Exception
  {
	  f =new File("F:\\AdvancedSelenium\\EchoLogin.xlsx");
	  fin = new FileInputStream(f);
	  wkbk = new XSSFWorkbook(fin);
	  sheet = wkbk.getSheet("data");
	  
	  int rowCount = sheet.getPhysicalNumberOfRows();
	  int colCount = sheet.getRow(0).getLastCellNum();
	  
	  data = new String[rowCount-1][colCount];
	  
	  for(int r= 0; r<rowCount -1; r++)
	  {
		  row = sheet.getRow(r+1);
		  
		  for(int c =0 ; c< colCount; c++)
		  {
			  cell = row.getCell(c);
			  data[r][c] = cell.getStringCellValue();
		  }
	  }
	  wkbk.close();
	  fin.close();
	 
	  return data;
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	
	  
  }

 @AfterMethod
  public void afterMethod() throws IOException {
	  driver.findElement(By.id("txtCustomerID")).clear();
	  driver.findElement(By.id("txtPassword")).clear();
  }  
  
  @BeforeClass
  public void beforeClass() throws IOException {
	 
	  driver = new FirefoxDriver();
	  driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
	  driver.manage().window().maximize();
	 
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }



}

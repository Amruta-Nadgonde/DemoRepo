package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.DataProvider;

import org.testng.annotations.BeforeClass;

public class ParamTest {
	WebDriver driver;
	/*@Parameters({"un" , "pwd"})
	@Test
	public void login(String un, String pwd) {
		
		driver.findElement(By.id("txtCustomerID")).sendKeys(un);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("Butsub")).click();
	}*/
	
	
	@Test(dataProvider = "getData")
	public void loginData(String un, String pwd)
	{
		driver.findElement(By.id("txtCustomerID")).sendKeys(un);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("Butsub")).click();
	}
	@BeforeClass
	public void beforeClass() {
		  driver = new FirefoxDriver();
			
		  driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
			
		  driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.id("txtCustomerID")).clear();
		driver.findElement(By.id("txtPassword")).clear();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

	
	
	@DataProvider
	@Test
	public Object[][] getData()
	{
		Object[][] data = new String[3][2];
		  data[0][0] = "user01";
		  data[0][1] = "user01";
		  
		  data[1][0] = "user02";
		  data[1][1] = "user02";
		  
		  data[2][0] = "user03";
		  data[2][1] = "user03";
		 
		return data;
	}

}

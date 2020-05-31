package framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	FileInputStream fin;
	WebDriver driver;
	Properties p;
	String msg = "Invalid Username/Password";
	
	@Test
	public void login() {
		driver.findElement(By.id(p.getProperty("txt_username"))).sendKeys("admin");
		driver.findElement(By.id(p.getProperty("txt_password"))).sendKeys("admin");
		driver.findElement(By.id(p.getProperty("btn_login"))).click();
	}
	@BeforeClass
	public void beforeClass() throws FileNotFoundException {
	  
		  try {

				fin = new FileInputStream(new File("F:\\AdvancedSelenium\\AdvSelenium\\echo.properties"));
			} 
			  catch (FileNotFoundException e) {
				System.out.println("File not found");
			} 
			  
			  p = new Properties();
			  try {
				p.load(fin);
			} catch (IOException e) {
				System.out.println("Unable to load the file");
			}
			  			
			  driver = new FirefoxDriver();
				
			  
			  driver.get(p.getProperty("txt_url"));
			  driver.manage().window().maximize();

	}
	  
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}

package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class GoogleTest {
	WebDriver driver;
  @Test(priority =1)
  public void search() {
	  
	  driver.findElement(By.id("lst-ib")).sendKeys("testng");
		
	  driver.findElement(By.name("btnK")).click();
		
	  assertEquals(driver.getTitle(), "testng - Google Search");
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
		
	  driver.get("https://www.google.com");
		
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}

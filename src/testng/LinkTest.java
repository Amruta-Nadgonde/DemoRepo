package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LinkTest {
	WebDriver driver;
  @Test(groups = "TOP")
  public void gmail() {
	  
	  driver.findElement(By.linkText("Gmail")).click();
	  
  }
  @Test(groups = "BOTTOM")
  public void advert() {
	  
	  driver.findElement(By.linkText("Advertising")).click();
	  
  }
  @Test(groups = "BOTTOM")
  public void business() {
	  
	  driver.findElement(By.linkText("Business")).click();
	  
  }
  @Test(groups = "TOP")
  public void image() {
	  
	  driver.findElement(By.linkText("Images")).click();
	  
  }
  @BeforeTest(alwaysRun = true)
  public void beforeTest() {
	  
	  driver = new FirefoxDriver();
		
	  driver.get("https://www.google.com");
		
	  driver.manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
	  driver.navigate().back();
  }
  
  @AfterTest(alwaysRun = true)
  public void afterTest()
  {
	  driver.close();
  }

}

package testng;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest {
	WebDriver driver;
	public static void selectItem(WebDriver driver, By by, String item)
	{
		List<WebElement> list = driver.findElements(by);
		for(WebElement l : list)
		{
			if(l.getText().equalsIgnoreCase(item))
			{
				l.click();
				break;
			}
		}
	}
	@Test  
	public void gmail()
	{
		
		
		driver.findElement(By.id("FirstName")).sendKeys("amr");
		driver.findElement(By.id("LastName")).sendKeys("amr01");
		driver.findElement(By.id("GmailAddress")).sendKeys("harryamr001");
		driver.findElement(By.id("Passwd")).sendKeys("Tricktest@11");
		driver.findElement(By.id("PasswdAgain")).sendKeys("Tricktest@11");
		driver.findElement(By.id("BirthMonth")).click();
		selectItem(driver, By.xpath("//span[@id='BirthMonth']/div[2]/div/div"), "June");
		driver.findElement(By.id("BirthDay")).sendKeys("20");
		driver.findElement(By.id("BirthYear")).sendKeys("1998");
		driver.findElement(By.id("Gender")).click();
		selectItem(driver, By.xpath("//div[@id='Gender']/div[2]/div/div"), "Female");
		driver.findElement(By.id("RecoveryPhoneNumber")).sendKeys("9988712345");
		driver.findElement(By.id("CountryCode")).click();
		selectItem(driver, By.xpath("//div[@id='CountryCode']/div[2]/div/div"), "Aruba");
		
		
	}
  @BeforeTest
  public void beforeTest()
  {
	  Reporter.log("Executing Gmail");
  }
  @BeforeClass
  public void beforeClass() {
		
		driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		
		driver.manage().window().maximize();
		
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}


package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Locating by id, name
		
	//	System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDownloads\\chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("lst-ib")).sendKeys("Java");
		
		driver.findElement(By.name("btnK")).click();
		
		assertEquals(driver.getTitle(), "Java - Google Search");
		
		//linkText
		
		driver.findElement(By.linkText("Images")).click();
		
		//partial linkText
		
		driver.findElement(By.partialLinkText("ook")).click();
		
		
		driver.findElement(By.linkText("All")).click();
		
		driver.findElement(By.className("gsfi")).sendKeys(" books");
		
		driver.findElement(By.className("sbico-c")).click();
		
		assertEquals(driver.getTitle(), "Java books - Google Search");
		
		//Tag name
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement we : links)
		{
			System.out.println(we.getText());
		}

		driver.close();
	}

}

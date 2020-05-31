package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronize {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("lst-ib")).sendKeys("a");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sbqs_c")));
		
		driver.findElement(By.cssSelector("div.sbqs_c")).click();
		
		wait.until(ExpectedConditions.titleContains("amazon - Google Search"));
		
		driver.findElement(By.partialLinkText("amazon")).click();

	}

}

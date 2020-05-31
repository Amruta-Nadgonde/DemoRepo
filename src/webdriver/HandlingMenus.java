package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingMenus {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.istqb.in/");
		
		driver.manage().window().maximize();
		
		WebElement menu = driver.findElement(By.id("menu632"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(menu).build().perform();
		
		Thread.sleep(5000);
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='megamenu level1']/li/a")));
		List<WebElement> submenus = driver.findElements(By.xpath("//ul[@class='megamenu level1']/li/a"));
		
		for(WebElement we : submenus)
		{
			if((we.getAttribute("title")).equalsIgnoreCase("BENEFITS"))
			{
				we.click();
					
			}
	}
		
		
	}

}

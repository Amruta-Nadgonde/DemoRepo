package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingTables {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://money.rediff.com/index.html");
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.linkText("More gainers")).click();
		
		WebElement table = driver.findElement(By.className("dataTable"));
		
		List<WebElement> header = table.findElements(By.tagName("th"));
		
		for(WebElement h : header)
		{
			System.out.println(h.getText());
		}
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(WebElement r : rows)
		{
			List<WebElement> cols = r.findElements(By.tagName("td"));
			
			for(WebElement c : cols)
			{
				if ((c.getText().equalsIgnoreCase("Tata Steel")))
						{
							System.out.println("found");
							break;
						}
			}
		}
		

	}

}

package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorAdv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		//By CSS
		//tagname.className
		
		driver.findElement(By.cssSelector("input.gsfi")).sendKeys("Selenium");
		
		//tagname#id
		driver.findElement(By.cssSelector("input#lst-ib")).sendKeys(" Books");
		
		//tag[attri='value']
		
		driver.findElement(By.cssSelector("input[name='btnK']")).click();
		
		System.out.println(driver.getTitle());

		driver.close();
		
		//XPath
		
		driver = new FirefoxDriver();
		
		driver.get("http://www.rediff.com/");
		
		driver.manage().window().maximize();
		
		//absolute
		
		driver.findElement(By.xpath("/html/body/div[2]/div[8]/div[1]/div[1]/div/form/div/input[1]")).sendKeys("Testing");
		
		//relative
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
	}

}

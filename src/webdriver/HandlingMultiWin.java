package webdriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingMultiWin {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://online.citibank.co.in/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='applyTxt']")).click();
		driver.findElement(By.xpath("//div[@class='applyDiv']/ul/li[1]/a")).click();
		
		Set<String>  wins = driver.getWindowHandles();
		
		Iterator<String> it = wins.iterator();
		
		String main = it.next();
		String newwin = it.next();
		
		driver.switchTo().window(newwin);
		
		driver.findElement(By.xpath("//li[@id='dividend1']/a")).click();
		
		driver.switchTo().window(main);
		
		driver.findElement(By.xpath("//div[@class='signOnAccount']/p/a/img[1]")).click();
		
		
		wins = driver.getWindowHandles();
		
		 it = wins.iterator();
		
		 main = it.next();
		 newwin = it.next();
		 String newwin1 = it.next();
		 
		 driver.switchTo().window(newwin1);
		 
		 driver.findElement(By.id("User_Id")).sendKeys("xyz@gmail.com");
		 
		 driver.switchTo().window(main);
		 
		 System.out.println(driver.getTitle());
		 
		 driver.quit();

	}

}

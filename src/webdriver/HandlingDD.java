package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDD {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Create a new account")).click();
		Select day = new Select(driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[22]/td[3]/select[1]")));
		
		day.selectByValue("10");
		
		Select month = new Select(driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[22]/td[3]/select[2]")));
		
		month.selectByVisibleText("FEB");
		
		Select year = new Select(driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[22]/td[3]/select[3]")));
		
		year.selectByValue("2017");
		
		
		List<WebElement> days = day.getOptions();
		
		for(WebElement we : days)
		{
			System.out.println(we.getText());
		}
		
		

	}

}

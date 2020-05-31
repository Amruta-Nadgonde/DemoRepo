package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://demoqa.com/registration/");
		
		driver.manage().window().maximize();
		
		List<WebElement> chkbox = driver.findElements(By.xpath("//div[@class='radio_wrap']/input"));
		
		for(WebElement ch : chkbox)
		{
			System.out.println(ch.getAttribute("value"));
			if(ch.getAttribute("value").equals("reading"))
			{
				
				if(!ch.isSelected())
				{
					ch.click();
				}
			}
		}
		
		

	}

}

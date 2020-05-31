package webdriver;



import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(drag, drop).perform();
		
		driver.close();
		
		driver = new FirefoxDriver();
		
		driver.get("http://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		
		drag = driver.findElement(By.id("draggable"));
		
		Point p = drag.getLocation();
		
		act.moveByOffset(p.getX()+20, p.getY()+20);
		
		driver.close();
		
		

	}

}

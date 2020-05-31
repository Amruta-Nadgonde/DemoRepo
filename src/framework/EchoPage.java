package framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class EchoPage {
	  
	  private WebElement txtCustomerID;
	  private WebElement txtPassword;
	  private WebElement Butsub;
	  private WebElement lblMsg;
	  
	 String url = "https://www.echotrak.com/Login.aspx?ReturnUrl=%2f";
	  public EchoPage(WebDriver driver)
		{
		
			driver = new FirefoxDriver();		  
			driver.get(url);
			driver.manage().window().maximize();
			
			PageFactory.initElements(driver, this);
		}
		
		public void login(String un, String pwd)
		{
			txtCustomerID.sendKeys(un);
			txtPassword.sendKeys(pwd);
			Butsub.click();
		}

	  public String getMessage()
	  {
		  return lblMsg.getText();
	  }
	
}

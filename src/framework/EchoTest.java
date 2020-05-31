package framework;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class EchoTest {
	WebDriver driver;
	String exp ="Invalid Username/Password";
	
	  @Test
	  public void EchoLogin() {
		  
		  EchoPage page = new EchoPage(driver);
		  page.login("test", "test");
		  
		  String act = page.getMessage();
		  assertEquals(act, exp);
	  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}

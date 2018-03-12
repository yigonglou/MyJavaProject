import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import static org.testng.Assert.*;
import org.openqa.selenium.*;

@Test
public class TestNG {
  private WebDriver driver;
  private String baseUrl;
  private String browser;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


@BeforeMethod
@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	     
	//For Firefox tests  
	       System.setProperty("webdriver.firefox.marionette","C:\\Program Files\\Java\\geckodriver.exe");       
            driver = new FirefoxDriver();
	  	  
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	  	    
  }

@Test

  public void testWeblinks () throws Exception {
	  
	  baseUrl = "https://www.yahoo.com/";  
	  System.out.println("Base URL: baseUrl"); 
	  driver.get(baseUrl + "/");
	  driver.findElement(By.id("uh-search-box")).clear();
	  driver.findElement(By.id("uh-search-box")).sendKeys("sports");
	  driver.findElement(By.id("uh-search-button")).click();
    
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("yui_3_10_0_1_1516837327461_327")).click();
  }

 

@AfterMethod
@AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      AssertJUnit.fail(verificationErrorString);
    }
  }

 // @SuppressWarnings("unused")
//private boolean isElementPresent(By by) throws NoSuchElementException {
  //  driver.findElement(by);
  //    return true;
 // }

  //@SuppressWarnings("unused")
//private boolean isAlertPresent() {
//    try {
 //     driver.switchTo().alert();
 //     return true;
 //   } catch (NoAlertPresentException e) {
 //     return false;
 //   }
//  }

//  @SuppressWarnings("unused")
private String closeAlertAndGetItsText() {
    try {
      Alert alert = (Alert) driver.switchTo().alert();
      String alertText = alert.getContentText();
      if (acceptNextAlert) {
        ((org.openqa.selenium.Alert) alert).accept();
      } else {
        ((org.openqa.selenium.Alert) alert).dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

package MyAdobe;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyAdobeTest {


		 private WebDriver driver;
		  private String baseUrl;
		  private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
		  public void setUp() throws Exception {
		
		//added teh setProperty
		 System.setProperty("webdriver.firefox.marionette","C:\\Program Files\\Java\\geckodriver.exe");       
        
		    driver = new FirefoxDriver();
		    baseUrl = "https://www.adobe.com/";
		    	    
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	

	@Test
		  public void testAdobe() throws Exception {
		
	    driver.get(baseUrl + "/#");
	    driver.findElement(By.cssSelector("span.Gnav-action-close")).click();
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("cloud");
	    
	    //added waiting time
	    
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Adobe Marketing Cloud")).click();
	  
	    driver.findElement(By.linkText("Sign In")).click();
	    driver.findElement(By.id("adobeid_username")).clear();
	    driver.findElement(By.id("adobeid_username")).sendKeys("yigonglou");
	    driver.findElement(By.id("adobeid_password")).clear();
	    driver.findElement(By.id("adobeid_password")).sendKeys("abc1234567");
	    driver.findElement(By.id("sign_in")).click();

		    	   
	}

		  
	@AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      Assert.fail(verificationErrorString);
		    }
	}

}

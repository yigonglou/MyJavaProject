package TestTC15280;


	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.*;

	import org.openqa.selenium.firefox.FirefoxDriver;
    
	public class tc15280 {
		
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	 // @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://github.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  //@Test
	  public void testMySt() throws Exception {
	    driver.get(baseUrl + "/SeleniumHQ/selenium/wiki/SeIDEReleaseNotes");
	    driver.findElement(By.linkText("selenium")).click();
	    driver.findElement(By.linkText("http://seleniumhq.org/")).click();
	  }

	 // @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      //fail(verificationErrorString);
	    }
	  }
	}




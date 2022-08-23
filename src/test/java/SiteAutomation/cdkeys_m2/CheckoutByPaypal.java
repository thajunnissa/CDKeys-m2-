package SiteAutomation.cdkeys_m2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Enumeration;
import java.util.Properties;
//import java.util.logging.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
//import com.mongodb.diagnostics.logging.Logger;

//import com.sun.tools.sjavac.Log;

import resources.base;

public class CheckoutByPaypal extends base{
	 public static Logger log =LogManager.getLogger(CheckoutByPaypal.class.getName());
	//public static Logger log = Logger.getLogger(test.class);
public WebDriver driver;
	@Test
	public void CheckCart() throws InterruptedException, IOException  {

		Properties prop=new Properties();
		FileInputStream fls=new FileInputStream("/home/thajunnissa/eclipse-workspace/cdkeys-m2/src/main/java/resources/data.properties");
	prop.load(fls);
	Enumeration KeyValues = prop.keys();
	while (KeyValues.hasMoreElements()) {
		String key = (String) KeyValues.nextElement();
		String value = prop.getProperty(key);
		System.out.println(key + ":- " + value);
	}
        driver=initializeDriver();
//		System.setProperty("webdriver.chrome.driver","/home/thajunnissa/Downloads/chromedriver_linux64/chromedriver");
//		 WebDriver driver=new ChromeDriver();
      // Launch Website  
   driver.get("https://test:test123@@m2.omn-it.net/");
   //log.info("Navigation Bar is displayed");
     
    //Maximize the browser  
     driver.manage().window().maximize(); 
     driver.findElement(By.xpath("//li[@class='currency']")).click();
     driver.findElement(By.xpath("//li[@class='currency-EUR switcher-option']")).click();

     driver.findElement(By.linkText("PC")).click();
     Thread.sleep(2000);
    ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
     Thread.sleep(2000);
    driver.findElement(By.xpath("//form[@data-product-sku='D/ELDRINPC']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@id='top-cart-btn-checkout']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("  //*[@id='checkout']/div[2]/div/div[2]/div/div[3]/p[2]/button")).click();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    
    driver.findElement(By.xpath("//*[@id=\'customer-email']")).sendKeys("testomnyex@gmail.com");
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    Thread.sleep(4000);

    WebElement myElement = driver.findElement(By.xpath("//*[@name='country_id']"));
    Select dropdown= new Select(myElement);
    
   //selectByVisibleText
    dropdown.selectByVisibleText("United Kingdom");
driver.findElement(By.name("firstname")).sendKeys("Jamsheer");;
driver.findElement(By.name("lastname")).sendKeys("Kandoth");
driver.findElement(By.name("street[0]")).sendKeys("test");
driver.findElement(By.name("city")).sendKeys("test");
driver.findElement(By.name("postcode")).sendKeys("12345");
driver.findElement(By.name("city")).sendKeys("test");
driver.findElement(By.name("telephone")).sendKeys("8976543217");
Thread.sleep(4000);

driver.findElement(By.xpath("//*[@id='checkout']/div[3]/div[2]/fieldset/div[3]/div/button[1]")).click();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(4000);
//driver.switchTo().frame("singleIframe");
driver.findElement(By.xpath("//body/div[3]/main[1]/div[3]/div[1]/div[2]/div[4]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/label[1]"));

driver.findElement(By.id("paypal_express")).click();

Thread.sleep(6000);
//JavascriptExecutor js = ((JavascriptExecutor) driver);
//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//Thread.sleep(5000);
((JavascriptExecutor)driver).executeScript("scroll(0,document.body.scrollHeight)");

driver.findElement(By.xpath("//*[@id='checkoutcom_card_payment_btn']")).click();

//driver.findElement(By.xpath("//*[@id='checkoutcom_card_payment_btn']")).click();
//Thread.sleep(6000);
//
////driver.switchTo().frame("singleIframe");
//driver.findElement(By.id("password")).sendKeys("Checkout1!");
//driver.findElement(By.name("txtButton")).click();






        //Assert.assertTrue(true);
    }
	

}

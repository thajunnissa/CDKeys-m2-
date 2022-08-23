package SiteAutomation.cdkeys_m2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
//import java.util.logging.LogManager;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
//import com.mongodb.diagnostics.logging.Logger;

//import com.sun.tools.sjavac.Log;

import resources.base;

public class CheckoutByCard extends base{
	 public static Logger log =LogManager.getLogger(CheckoutByCard.class.getName());
	//public static Logger log = Logger.getLogger(CheckoutByCard.class);
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
    driver.findElement(By.xpath("//form[@data-product-sku='D/MARMSPC_WW']")).click();
    Thread.sleep(4000);

    driver.findElement(By.xpath("//*[@id='top-cart-btn-checkout']")).click();
    Thread.sleep(2000);

    driver.findElement(By.xpath("  //*[@id='checkout']/div[2]/div/div[2]/div/div[3]/p[2]/button")).click();
    
    Thread.sleep(4000);

    
    driver.findElement(By.xpath("//*[@id=\'customer-email']")).sendKeys("testomnyex@gmail.com");
    Thread.sleep(2000);

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
Thread.sleep(4000);

driver.switchTo().frame("singleIframe");
driver.findElement(By.name("cardnumber")).sendKeys("4242 4242 4242 4242");
driver.findElement(By.name("exp-date")).sendKeys("08/24");
driver.findElement(By.name("cvc")).sendKeys("100");
//driver.findElement(By.name("numeric")).sendKeys("100");
driver.switchTo().defaultContent();
Thread.sleep(2000);

((JavascriptExecutor)driver).executeScript("scroll(0,document.body.scrollHeight)");

driver.findElement(By.xpath("//*[@id='checkoutcom_card_payment_btn']")).click();

//driver.findElement(By.xpath("//*[@id='checkoutcom_card_payment_btn']")).click();
Thread.sleep(6000);

driver.switchTo().frame("cko-3ds2-iframe");
driver.findElement(By.name("password")).sendKeys("Checkout1!");
driver.findElement(By.xpath("//*[@id='txtButton']")).click();






        //Assert.assertTrue(true);
    }
	

}

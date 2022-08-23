package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
public WebDriver driver;
	By Currency=By.xpath("//li[@class='currency']");
	By EURCurrency=By.xpath("//li[@class='currency-EUR switcher-option']");
	By NavigateToPC=By.linkText("PC");
	By product=By.xpath("//form[@data-product-sku='D/MARMSPC_WW']");
	By customerEmail=By.xpath("//*[@id=\'customer-email']");
	By countryList=By.xpath("//*[@name='country_id']");
	By firstName=By.name("firstname");
	By lastName=By.name("lastname");
	By street=By.name("street[0]");
	By city=By.name("city");
	By postcode=By.name("postcode");
	By telephone=By.name("telephone");
	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	public WebElement getCurrency()
	{
		return driver.findElement(Currency);
	}
	public WebElement getEURCurrency()
	{
		return driver.findElement(EURCurrency);
	}
	public WebElement getNavigateToPC()
	{
		return driver.findElement(NavigateToPC);
	}
	public WebElement getproduct()
	{
		return driver.findElement(product);
	}
	
	public WebElement getcustomerEmail()
	{
		return driver.findElement(customerEmail);
	}
	
	public WebElement getcountryList()
	{
		return driver.findElement(countryList);
	}
	
	public WebElement getfirstName()
	{
		return driver.findElement(firstName);
	}
	public WebElement getlastName()
	{
		return driver.findElement(lastName);
	}
	public WebElement getstreet()
	{
		return driver.findElement(street);
	}
	public WebElement getcity()
	{
		return driver.findElement(city);
	}
	public WebElement getpostcode()
	{
		return driver.findElement(postcode);
	}
	public WebElement gettelephone()
	{
		return driver.findElement(telephone);
	}
	

}

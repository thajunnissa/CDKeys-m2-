package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
	Properties prop=new Properties();
	FileInputStream fls=new FileInputStream("/home/thajunnissa/eclipse-workspace/E2EProject/src/main/java/resources/data.properties");
prop.load(fls);
String browserName=prop.getProperty("browser");
if(browserName.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver","/home/thajunnissa/Downloads/chromedriver_linux64/chromedriver");
	 driver=new ChromeDriver();
	
	
}
else if(browserName.equals("firefox"))
{
	System.setProperty("webdriver.gecko.driver","/home/thajunnissa/Downloads/geckodriver-v0.31.0-linux64/geckodriver");
	driver=new FirefoxDriver();
}
else if (browserName.equals("IE"))
{
//	IE code
}

//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}

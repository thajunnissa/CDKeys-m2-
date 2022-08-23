package SiteAutomation.cdkeys_m2;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class CDKeyLinkCheck extends base{
		
		
		//builds a new report using the html template 
	    @SuppressWarnings("deprecation")
		//ExtentHtmlReporter htmlReporter;
	    
	    ExtentReports extent;
	    //helps to generate the logs in test report.
	    ExtentTest test;
	    WebDriver driver;	    
	   // @BeforeTest
//	    public void startReport() {
//	    	// initialize the HtmlReporter
//	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
//	        
//	        //initialize ExtentReports and attach the HtmlReporter
//	        extent = new ExtentReports();
//	        extent.attachReporter(htmlReporter);
//	         
//	        //To add system or environment info by using the setSystemInfo method.
//	        extent.setSystemInfo("OS", "Linux");
//	        extent.setSystemInfo("Browser", "Chrome");
//	        
//	        //configuration items to change the look and feel
//	        //add content, manage tests etc
//	        htmlReporter.config().setChartVisibilityOnOpen(true);
//	        htmlReporter.config().setDocumentTitle("CDKeys() Test Report");
//	        htmlReporter.config().setReportName("Test Report");
//	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
//	        htmlReporter.config().setTheme(Theme.STANDARD);
//	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//	        
//	    }
	    
	    
	     @BeforeMethod
	     
	    public void configure()
	     {
	 	    	 
	     }
	    
	    @Test 
	    public void CheckMainMenu() throws IOException {
	    	
	        test = extent.createTest("Test the loading of all the main category links", "Test Passed");
	        driver=initializeDriver();
//	        System.setProperty("webdriver.chrome.driver", "/home/thajunnissa/chromedriver_linux64\n/chromedriver");
//	          
//            // Instantiate a ChromeDriver class.     
//        driver=new ChromeDriver();  
         
          // Launch Website  
       driver.get("https://test:test123@@m2.omn-it.net/");
         
        //Maximize the browser  
         driver.manage().window().maximize(); 
         String[] mainMenu= {"PC","PSN","XBOX","NINTENDO","TOP-UPS","VALENTINE'S SALE","DAILY DEALS","NEW","COMING SOON"};
         String[] actualUrl= {"https://m2.omn-it.net/pc","https://m2.omn-it.net/playstation-network-psn","https://m2.omn-it.net/xbox-live","https://m2.omn-it.net/nintendo","https://m2.omn-it.net/top-up-cards","https://m2.omn-it.net/better-together","https://m2.omn-it.net/daily-deals","https://m2.omn-it.net/new","https://m2.omn-it.net/coming-soon"};
         
         for(int i=0;i<mainMenu.length;i++)
         {
	        driver.findElement(By.linkText(mainMenu[i])).click();
         String currentUrl = driver.getCurrentUrl();
         Assert.assertEquals(actualUrl[i], currentUrl);
         driver.navigate().back();
         }
	        
	        driver.quit();
	    }
	    
	    @Test 
	    public void CheckPCSubmenu() throws IOException, InterruptedException  {
	        test = extent.createTest("Check sub-categories of PC ", "PASSED test case");
	        test = extent.createTest("Test the loading of all the menu links", "Test Passed");
	        driver=initializeDriver();
          // Launch Website  
       driver.get("https://test:test123@@m2.omn-it.net/");
         
        //Maximize the browser  
         driver.manage().window().maximize(); 
	        String[] PCsubMenu={"GAMES","TIME CARDS & DLC"};
	        String[] actualUrl={"https://m2.omn-it.net/pc/games","https://m2.omn-it.net/pc/time-cards"};
	        for(int i=0;i<PCsubMenu.length;i++)
	        {
	        WebElement PC = driver.findElement(By.linkText("PC"));
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(PC).perform();
	        Thread.sleep(2000);
	        action.moveToElement(driver.findElement(By.linkText(PCsubMenu[i]))).click().perform();
	        String currentUrl = driver.getCurrentUrl();
	         Assert.assertEquals(actualUrl[i], currentUrl);
	        //System.out.println(driver.getCurrentUrl());
	        driver.navigate().back();
	       
	    }
	        driver.quit();
//	        Actions action = new Actions(driver);
//	        //WebElement PC = driver.findElement(By.linkText("PC"));
//	        action.moveToElement(driver.findElement(By.linkText("PC"))).perform();
//	        Thread.sleep(2000);
//	        action.moveToElement(driver.findElement(By.linkText("GAMES"))).click().perform();
}
	    
	    
	    
	    @Test 
	    public void CheckPSNsubmenus() throws InterruptedException, IOException {
	        test = extent.createTest("Check sub-categories of PSN", "PASSED test case");
	        driver=initializeDriver();
       driver.get("https://test:test123@@m2.omn-it.net/");
         
        //Maximize the browser  
         driver.manage().window().maximize(); 
	        String[] PSNsubMenu={"PSN TOPUP CARDS","PLAYSTATION PLUS","PLAYSTATION NOW","PSN GAMES","ADDONS & SEASON PASSES"};
	        String[] actualUrl={"https://m2.omn-it.net/playstation-network-psn/psn-cards","https://m2.omn-it.net/playstation-network-psn/playstation-plus","https://m2.omn-it.net/playstation-network-psn/playstation-now","https://m2.omn-it.net/playstation-network-psn/psn-games","https://m2.omn-it.net/playstation-network-psn/psn-addons-season-passes"};
	        for(int i=0;i<PSNsubMenu.length;i++)
	        {
	        WebElement PSN = driver.findElement(By.linkText("PSN"));
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(PSN).perform();
	        Thread.sleep(2000);
	        action.moveToElement(driver.findElement(By.linkText(PSNsubMenu[i]))).click().perform();
	        String currentUrl = driver.getCurrentUrl();
	         Assert.assertEquals(actualUrl[i], currentUrl);
	        //System.out.println(driver.getCurrentUrl());
	        driver.navigate().back();
	       
	    }
	        driver.quit();
       }
	    
	    @Test 
	    public void CheckXBOXsubmenus() throws InterruptedException, IOException {
	        test = extent.createTest("Check sub-categories of XBOX", "PASSED test case");
	        test = extent.createTest("Test the loading of all the menu links", "Test Passed");
	        driver=initializeDriver();
          // Launch Website  
       driver.get("https://test:test123@@m2.omn-it.net/");
         
        //Maximize the browser  
         driver.manage().window().maximize(); 
	        String[] XBOXsubMenu={"GIFT CARDS/POINTS","MEMBERSHIPS","GAMES","SEASON PASSES"};
	        String[] actualUrl={"https://m2.omn-it.net/xbox-live/gift-cards-points","https://m2.omn-it.net/xbox-live/memberships","https://m2.omn-it.net/xbox-live/games","https://m2.omn-it.net/xbox-live/season-passes"};
	        for(int i=0;i<XBOXsubMenu.length;i++)
	        {
	        WebElement XBOX = driver.findElement(By.linkText("XBOX"));
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(XBOX).perform();
	        Thread.sleep(2000);
	        action.moveToElement(driver.findElement(By.linkText(XBOXsubMenu[i]))).click().perform();
	        String currentUrl = driver.getCurrentUrl();
	         Assert.assertEquals(actualUrl[i], currentUrl);
	        //System.out.println(driver.getCurrentUrl());
	        driver.navigate().back();
	       
	    }
	        driver.quit();
       }
	    @Test 
	    public void CheckNINTENDOsubmenus() throws InterruptedException, IOException {
	        test = extent.createTest("Check sub-categories of NINTENDO", "PASSED test case");
	        test = extent.createTest("Test the loading of all the menu links", "Test Passed");
	        driver=initializeDriver();
          // Launch Website  
       driver.get("https://test:test123@@m2.omn-it.net/");
         
        //Maximize the browser  
         driver.manage().window().maximize(); 
	        String[] NINTENDOsubMenu={"WII U GAMES","3DS GAMES","ESHOP TOPUP CARDS","SWITCH"};
	        String[] actualUrl={"https://m2.omn-it.net/nintendo/wii-u-games","https://m2.omn-it.net/nintendo/games-3ds","https://m2.omn-it.net/nintendo/eshop-topup-cards","https://m2.omn-it.net/nintendo/switch"};
	        for(int i=0;i<NINTENDOsubMenu.length;i++)
	        {
	        WebElement NINTENDO = driver.findElement(By.linkText("NINTENDO"));
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(NINTENDO).perform();
	        Thread.sleep(2000);
	        action.moveToElement(driver.findElement(By.linkText(NINTENDOsubMenu[i]))).click().perform();
	        String currentUrl = driver.getCurrentUrl();
	         Assert.assertEquals(actualUrl[i], currentUrl);
	        System.out.println(driver.getCurrentUrl());
	        driver.navigate().back();
	       
	    }
	       
	        driver.quit();
       }
	    @Test 
	    public void CheckTOPUPSsubmenus() throws InterruptedException, IOException {
	        test = extent.createTest("Check sub-categories of TOPUPS", "PASSED test case");
	        test = extent.createTest("Test the loading of all the menu links", "Test Passed");
	        driver=initializeDriver();
         
          // Launch Website  
       driver.get("https://test:test123@@m2.omn-it.net/");
         
        //Maximize the browser  
         driver.manage().window().maximize(); 
	        String[] TOPUPSsubMenu={"FIFA FUT POINTS","ITUNES","FACEBOOK","GOOGLE PLAY","ORIGIN","STEAM","BATTLENET","NETFLIX","PUBG MOBILE","FREE FIRE","RAZER","AMAZON","ROBLOX","RIOT","MOBILE LEGENDS"};
	        String[] actualUrl={"https://m2.omn-it.net/top-up-cards/fifa-fut-points","https://m2.omn-it.net/top-up-cards/itunes","https://m2.omn-it.net/top-up-cards/facebook","https://m2.omn-it.net/top-up-cards/google-play","https://m2.omn-it.net/top-up-cards/origin","https://m2.omn-it.net/top-up-cards/steam","https://m2.omn-it.net/top-up-cards/battlenet","https://m2.omn-it.net/top-up-cards/netflix","https://m2.omn-it.net/top-up-cards/pubg-mobile","https://m2.omn-it.net/top-up-cards/free-fire","https://m2.omn-it.net/top-up-cards/razer","https://m2.omn-it.net/top-up-cards/amazon","https://m2.omn-it.net/top-up-cards/roblox","https://m2.omn-it.net/top-up-cards/riot","https://m2.omn-it.net/top-up-cards/mobile-legends"};

	        for(int i=0;i<TOPUPSsubMenu.length;i++)
	        {
	        WebElement TOPUPS = driver.findElement(By.linkText("TOP-UPS"));
	        Actions action = new Actions(driver);
	        
	        action.moveToElement(TOPUPS).perform();
	        Thread.sleep(2000);
	        action.moveToElement(driver.findElement(By.linkText(TOPUPSsubMenu[i]))).click().perform();
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertEquals(actualUrl[i], currentUrl);
	        //System.out.println(driver.getCurrentUrl());
	        driver.navigate().back();
	       
	    }
	        driver.quit();
       }
	    @Test 
	    public void CheckCart() throws IOException {
	        test = extent.createTest("Check cart functionality", "Test Passed");
	        driver=initializeDriver();
         
          // Launch Website  
       driver.get("https://test:test123@@m2.omn-it.net/");
         
        //Maximize the browser  
         driver.manage().window().maximize(); 
         driver.findElement(By.linkText("PC")).click();
         
         ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        driver.findElement(By.xpath("")).click();
         
             
	        Assert.assertTrue(true);
	    }
	     
	   
	    @Test
		public void testCase6(){
				test = extent.createTest("Test Case 6", "I'm Not Ready, please don't execute me");
			}
	   
	    @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	     
	    @AfterTest
	    public void tearDown() {
	    	//to write or update test information to reporter
	        extent.flush();
	    }
	}



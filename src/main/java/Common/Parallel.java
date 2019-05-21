package Common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parallel {

	public String username = "vipul.kumar1804";
	   public String accesskey = "848X4Uw4PkvWr36OJS2d8uYAvmUTgJhfEHBX1K78ebdLOH1ykz";
	    public static RemoteWebDriver driver = null;
	   public String gridURL = "@hub.lambdatest.com/wd/hub";
	    boolean status = false;
	    @Test(dataProvider= "Set_Environment")
	    public void setUp(Platform platform_used, String browser_Name, String browser_Version) {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setPlatform(platform_used);
	        capabilities.setBrowserName(browser_Name);
	        capabilities.setVersion(browser_Version);
	        // capabilities.setCapability("platform", "Windows 7"); // If this cap isn't specified, it will just get any available one.
	        capabilities.setCapability("build", "LambdaTestSampleApp");
	        capabilities.setCapability("name", "LambdaTestJavaSample");
	        capabilities.setCapability("network", true); // To enable network logs
	        capabilities.setCapability("visual", true); // To enable step by step screenshot
	        capabilities.setCapability("video", true); // To enable video recording
	        capabilities.setCapability("console", true); // To capture console logs
	        try {
	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	        } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        try
	        {
    		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  	        driver.get("https://www.google.com/");
	        }
            catch (Exception e) {
         System.out.println(e.getMessage());
                }
	    }
	    @DataProvider(name="Set_Environment", parallel=true)
	    public Object[][] getData(){
	    
	    Object[][] Browser_Property = new Object[][]{
	    		
	 
	    {Platform.WIN8, "chrome", "70.0"},
	    {Platform.WIN8, "Firefox", "58.0"}
	    };
	    return Browser_Property;
	    
	    }
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	   
	            driver.quit(); //really important statement for preventing your test execution from a timeout.
	        }
	    }
	}

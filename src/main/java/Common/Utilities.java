package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utilities {

public static String getCongifProperty(String propertyName) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")  +"\\src\\test\\resources\\config.properties");
	    prop.load(fis);
	   return prop.getProperty(propertyName);
		}

    public static void refreshPage(WebDriver driver) {
    	driver.navigate().refresh();
    }
	public static WebDriver startApplication() throws IOException, InterruptedException {
		WebDriver driver;
		if(Utilities.getCongifProperty("browser").equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if(Utilities.getCongifProperty("browser").equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
			
		} else if(Utilities.getCongifProperty("browser").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		} else {
			
			driver = new FirefoxDriver();
		}
	
	
		driver.get(Utilities.getCongifProperty("url"));
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	   return driver;
		
	}

	
	
}

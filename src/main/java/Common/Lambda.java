package Common;


import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Lambda {
   public String username = "vipul.kumar1804";
   public String accesskey = "848X4Uw4PkvWr36OJS2d8uYAvmUTgJhfEHBX1K78ebdLOH1ykz";
    public static RemoteWebDriver driver = null;
   public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    @Test
    public void test() {
        // To Setup driver
        setUp();
        try {
              //Change it to production page
            driver.get("https://lambdatest.github.io/sample-todo-app/");
             
              //Let's mark done first two items in the list.
              driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();
             
             // Let's add an item in the list.
              driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();
             
              // Let's check that the item we added is added in the list.
            String enteredText = driver.findElementByXPath("/html/body/div/div/div/ul/li[6]/span").getText();
            if (enteredText.equals("Yey, Let's add it to list")) {
                status = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            tearDown();
        }
    }
    @BeforeClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "Windows 7"); // If this cap isn't specified, it will just get any available one.
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
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
   
            driver.quit(); //really important statement for preventing your test execution from a timeout.
        }
    }
}
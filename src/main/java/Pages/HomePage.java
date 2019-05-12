package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	static String dataimageindex="0";
	 static String department="//a[@id='nav-link-shopall']";
	 static String electronics="//span[contains(text(),'Electronics')]";
	 static String headPhones= "//span[contains(text(),'Headphones')]";
	 static String availablePhone="img[data-image-index='0']";
	 public static void addProduct(WebDriver driver) {
		 WebElement element = driver.findElement(By.xpath(department));
		 
		    Actions  = new Actions(driver);
	        action.moveToElement(element).build().perform();
	        WebDriverWait wait = new WebDriverWait(driver, 15);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(electronics))).click();
	        
	         driver.findElement(By.xpath(headPhones)).click();
	         
	         WebDriverWait wait1 = new WebDriverWait(driver, 10);
	         wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(availablePhone))).click();
	        
	 }
	 
}

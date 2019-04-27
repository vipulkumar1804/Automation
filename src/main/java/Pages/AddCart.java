package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCart {
	
	static String addTocart="//input[@id='add-to-cart-button']";
	
	public static void addToCart(WebDriver driver) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addTocart))).click();
        Thread.sleep(3000);
        
        }
   
	}


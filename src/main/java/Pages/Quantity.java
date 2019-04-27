package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Common.Utilities;

public class Quantity {
	static String popup1="//input[@class='a-button-input' and @type='submit']";
	static String quantity="//select[@name='quantity']";
	
	public static void productQuantity(WebDriver driver) throws IOException, InterruptedException {
		
		driver.findElement(By.xpath(quantity)).sendKeys(Utilities.getCongifProperty("quantity"));
		Thread.sleep(3000);	
	}
}
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloseButton {
	
	static String closeButton="//a[@class='a-link-normal close-button']";
	
	public static void clickToCloseBtn(WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath(closeButton)).click();
	        Thread.sleep(2000);
		
	}
	
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUp {
	
	 static String popUpBtn="//input[@class='a-button-input' and @type='submit']";
	 
	 public static void handlePopUp(WebDriver driver) {
		 
		 WebElement element= driver.findElement(By.xpath(popUpBtn));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
	 }

}

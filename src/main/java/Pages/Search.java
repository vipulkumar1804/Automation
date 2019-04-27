package Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Common.Utilities;

public class Search {
	static String searchBar="//input[@id='twotabsearchtextbox']";
	static String searchButton="//input[@value='Go']";
	static String macBook="(//img[@class='mediaCentralImage imageContainer__image'])[3]";
	
	public static void searchProduct(WebDriver driver) throws IOException, InterruptedException {
		driver.findElement(By.xpath(searchBar)).sendKeys(Utilities.getCongifProperty("product"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(searchButton)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(macBook)).click();
		
	}

}

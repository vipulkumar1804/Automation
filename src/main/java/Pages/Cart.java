package Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

	static String cart="//span[@class='nav-cart-icon nav-sprite']";
	static String delete="(//input[@value='Delete'])[2]";
	static String quantity="(//span[@data-a-class='quantity'])[1]";
	static String updateQuantity="//a[@id='dropdown1_0']";
	static String proceedCheckout="//input[@value='Proceed to checkout']";
	public static void clickToCart(WebDriver driver) throws InterruptedException, IOException {
		driver.findElement(By.xpath(cart)).click();
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(quantity)).click();
		driver.findElement(By.xpath(updateQuantity)).click();
		driver.findElement(By.xpath(proceedCheckout)).click();
	}
}

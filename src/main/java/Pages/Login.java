package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Utilities;

public class Login {
	
	static String clickLogin ="//span[contains(text(),'Hello, Sign in')]";
	static String email ="//input[@name='email']";
	static String password="//input[@id='ap_password']";
	static String signIn="//input[@id='signInSubmit']";
	
	public static void loginUser(WebDriver driver) throws IOException {
		driver.findElement(By.xpath(clickLogin)).click();
		driver.findElement(By.xpath(email)).sendKeys(Utilities.getCongifProperty("email"));
		driver.findElement(By.xpath(password)).sendKeys(Utilities.getCongifProperty("password"));
		driver.findElement(By.xpath(signIn)).click();
		
	}
	

}

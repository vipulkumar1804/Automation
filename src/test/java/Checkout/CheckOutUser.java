package Checkout;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Pages.AddCart;
import Pages.Cart;
import Pages.CloseButton;
import Pages.HomePage;
import Pages.Login;
import Pages.PopUp;
import Pages.Quantity;
import Pages.Search;

public class CheckOutUser {
	
	WebDriver driver;
	
	  @BeforeMethod
	  public void setup() throws IOException, InterruptedException{

			  driver =  Utilities.startApplication();
				driver.manage().window().maximize();
		   }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.close();
	  }
	  
	 @Test
	 public void userChkOut() throws IOException, InterruptedException {
		Login.loginUser(driver);
		HomePage.addProduct(driver);
		AddCart.addToCart(driver);
		CloseButton.clickToCloseBtn(driver);
		Search.searchProduct(driver);
		Quantity.productQuantity(driver);
		AddCart.addToCart(driver);
		PopUp.handlePopUp(driver);
		Cart.clickToCart(driver);
	}	
}

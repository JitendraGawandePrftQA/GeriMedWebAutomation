// CartPageTest.java content// ProductPageTest.java content
package gmd.sand.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import gmd.sand.pages.CartPage;
import gmd.sand.pages.ProductListingPage;

public class CartPageTest extends CartPage {
	WebDriver driver;

	public CartPageTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test(enabled = false)
	public void verifyProductInCart() throws InterruptedException {
		launchApplication();
		LoginTest login = new LoginTest();
		login.validUserLogin();
		ProductListingPage plp = new ProductListingPage(driver);
		plp.navigateToProductsCategoryLandingPage();
		plp.navigateToCategoryProductListingPage();
		plp.addProductsToCartFromPLP();
		navigateToCartPage();
		verifyItemsOnCartPage();
	}

	@Test
	public void proceedToCheckout() throws InterruptedException {
		launchApplication();
		LoginTest login = new LoginTest();
		login.validUserLogin();
		ProductListingPage plp = new ProductListingPage(driver);
		plp.navigateToProductsCategoryLandingPage();
		plp.navigateToCategoryProductListingPage();
		plp.addProductsToCartFromPLP();
		navigateToCartPage();
		verifyItemsOnCartPage();
		proceedToCheckout();
	}
}

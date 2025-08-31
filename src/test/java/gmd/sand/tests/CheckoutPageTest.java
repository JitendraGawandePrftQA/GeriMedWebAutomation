
package gmd.sand.tests;

import org.testng.annotations.Test;

import gmd.sand.base.BaseTest;
import gmd.sand.pages.CartPage;
import gmd.sand.pages.CheckoutReviewPage;
import gmd.sand.pages.HomePage;
import gmd.sand.pages.ProductListingPage;

public class CheckoutPageTest extends BaseTest {

	@Test
	public void PlaceOrder() throws InterruptedException {
		LoginTest login = new LoginTest();
		login.validUserLogin();
		HomePage home = new HomePage(driver);
		home.changeCustomer("KATZMAN");
		ProductListingPage plp = new ProductListingPage(driver);
		plp.navigateToProductsCategoryLandingPage();
		plp.navigateToCategoryProductListingPage();
		plp.addProductsToCartFromPLP();
		CartPage cart = new CartPage(driver);
		cart.navigateToCartPage();
		cart.proceedToCheckout();
		CheckoutReviewPage checkout = new CheckoutReviewPage(driver);
		checkout.enterPoNumber();
		checkout.placeOrder();
	}
}


package gmd.sand.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.ConfigReader;
import gmd.sand.utils.ReportManager;

public class CheckoutPageTest extends BaseTest {
	ExtentTest test = ReportManager.createTest("Checkout Page Test");

	@Test
	public void PlaceOrder() throws InterruptedException {
		homePage.userLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		test.info("User logged in successfully");
		homePage.changeCustomer(ConfigReader.getProperty("customerName"));
		test.info("Customer changed successfully");
		plp.navigateToProductsCategoryLandingPage();
		test.info("Navigated to Products Category Landing Page");
		plp.navigateToCategoryProductListingPage();
		test.info("Navigated to Category Product Listing Page");
		plp.addProductsToCartFromPLP();
		test.info("Product added to cart from PLP");
		cart.navigateToCartPage();
		test.info("Navigated to Cart Page");
		cart.proceedToCheckout();
		test.info("Proceeded to Checkout Page");
		checkout.enterPoNumber();
		checkout.placeOrder();
		test.pass("Order placed successfully");
	}
}

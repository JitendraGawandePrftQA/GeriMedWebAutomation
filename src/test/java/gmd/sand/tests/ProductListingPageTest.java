// ProductPageTest.java content
package gmd.sand.tests;

import org.testng.annotations.Test;

import gmd.sand.base.BaseTest;
import gmd.sand.pages.HomePage;
import gmd.sand.pages.ProductListingPage;

public class ProductListingPageTest extends BaseTest {

	@Test
	public void navigateToProductListingPage() throws InterruptedException {
		LoginTest login = new LoginTest();
		login.validUserLogin();
		ProductListingPage plp = new ProductListingPage(driver);
		plp.navigateToProductsCategoryLandingPage();
		plp.navigateToCategoryProductListingPage();
	}

	@Test
	public void addProductToCartFromPLP() throws InterruptedException {

		LoginTest login = new LoginTest();
		login.validUserLogin();
		HomePage home = new HomePage(driver);
		home.changeCustomer("KATZMAN");
		ProductListingPage plp = new ProductListingPage(driver);
		plp.navigateToProductsCategoryLandingPage();
		plp.navigateToCategoryProductListingPage();
		plp.addProductsToCartFromPLP();
	}
}

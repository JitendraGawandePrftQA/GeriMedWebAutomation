package gmd.sand.base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import gmd.sand.pages.CartPage;
import gmd.sand.pages.CheckoutReviewPage;
import gmd.sand.pages.HomePage;
import gmd.sand.pages.ProductListingPage;

public class PageObjectManager extends BaseTest {
	WebDriver driver;
	ExtentTest test;

	HomePage homePage;
	ProductListingPage plp;
	CartPage cartPage;
	CheckoutReviewPage checkoutReviewPage;

	public PageObjectManager(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver, test) : homePage;
	}

	public ProductListingPage getPlp() {
		return (plp == null) ? plp = new ProductListingPage(driver, test) : plp;
	}

	public CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(driver, test) : cartPage;
	}

	public CheckoutReviewPage getCheckoutReviewPage() {
		return (checkoutReviewPage == null) ? checkoutReviewPage = new CheckoutReviewPage(driver, test)
				: checkoutReviewPage;
	}
}


package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;
import gmd.sand.utils.CommonWaits;

public class CartPage extends BaseTest {
	WebDriver driver;
	ExtentTest test;

	public CartPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-test-selector='cartLink']")
	WebElement cartLink;

	@FindBy(css = "div[data-test-selector^='cartline_expanded']")
	WebElement cartItemSection;

	@FindBy(xpath = "//button[starts-with(@class,'ButtonWrapper')]/span[text()='Checkout']")
	WebElement checkoutButton;

	public void navigateToCartPage() throws InterruptedException {
		CommonActions.click(cartLink);
		test.info("Clicked on Cart Link to navigate to Cart Page");
		CommonWaits.waitForPageLoad(driver);
	}

	public void verifyItemsOnCartPage() {
		CommonWaits.waitForVisibility(driver, cartItemSection, 20);
		test.info("Verifying items on Cart Page");
		if (cartItemSection.isDisplayed()) {
			System.out.println("Cart page is displayed with items.");
		} else {
			System.out.println("Cart page is not displayed or is empty.");
		}
	}

	public void proceedToCheckout() throws InterruptedException {
		Thread.sleep(5000);
		CommonActions.click(checkoutButton);
		test.info("Clicked on Checkout button to proceed to Checkout Page");

	}
}

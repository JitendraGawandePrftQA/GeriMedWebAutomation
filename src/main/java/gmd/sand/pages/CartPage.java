
package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;

public class CartPage extends BaseTest {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-test-selector=\"cartLink\"]")
	WebElement cartLink;

	@FindBy(css = "div[data-test-selector^=\"cartline_expanded\"]")
	WebElement cartItemSection;

	@FindBy(xpath = "//button[starts-with(@class,'ButtonWrapper')]/span[text()='Checkout']")
	WebElement checkoutButton;

	public void navigateToCartPage() throws InterruptedException {
		CommonActions.click(cartLink);
		waitForPageLoad();
	}

	public void verifyItemsOnCartPage() {
		waitForVisibility(cartItemSection, 20);
		if (cartItemSection.isDisplayed()) {
			System.out.println("Cart page is displayed with items.");
		} else {
			System.out.println("Cart page is not displayed or is empty.");
		}
	}

	public void proceedToCheckout() throws InterruptedException {
		Thread.sleep(2000);
		CommonActions.click(checkoutButton);

	}
}

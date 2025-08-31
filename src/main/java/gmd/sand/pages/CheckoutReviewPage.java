
package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;

public class CheckoutReviewPage extends BaseTest {
	WebDriver driver;

	public CheckoutReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-test-selector=\"checkoutReviewAndSubmit_poNumber\"]")
	WebElement poNumberField;

	@FindBy(xpath = "(//button[@data-test-selector='checkoutReviewAndSubmit_placeOrder'])[2]")
	WebElement placeOrderButton;

	public void enterPoNumber() {
		waitForVisibility(poNumberField, 10);
		CommonActions.scrollToElement(driver, poNumberField);
		CommonActions.sendKeys(poNumberField, "QAtestPO");
	}

	public void placeOrder() {
		waitForVisibility(placeOrderButton, 10);
		CommonActions.click(placeOrderButton);
	}

}

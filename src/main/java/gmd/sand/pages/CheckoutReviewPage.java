
package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;
import gmd.sand.utils.CommonWaits;
import gmd.sand.utils.ConfigReader;

public class CheckoutReviewPage extends BaseTest {
	WebDriver driver;
	ExtentTest test;

	public CheckoutReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-test-selector='checkoutReviewAndSubmit_poNumber']")
	WebElement poNumberField;

	@FindBy(xpath = "(//button[@data-test-selector='checkoutReviewAndSubmit_placeOrder'])[2]")
	WebElement placeOrderButton;

	public void enterPoNumber() {
		CommonWaits.waitForVisibility(driver, poNumberField, 10);
		CommonActions.scrollToElement(driver, poNumberField);
		String poNumber = ConfigReader.getProperty("poNumber");
		CommonActions.sendKeys(poNumberField, poNumber);
		test.info("Entered PO Number as " + poNumber);
	}

	public void placeOrder() {
		CommonWaits.waitForVisibility(driver, placeOrderButton, 10);
		CommonActions.click(placeOrderButton);
		test.info("Clicked on Place Order button to place the order");
	}

}

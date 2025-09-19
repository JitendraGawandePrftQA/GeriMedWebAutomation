
package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;
import gmd.sand.utils.CommonWaits;

public class HomePage extends BaseTest {
	WebDriver driver;
	ExtentTest test;

	@FindBy(xpath = "//input[@id='userName']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@data-test-selector='signIn_submit']")
	WebElement signInButton;

	@FindBy(xpath = "//input[@data-test-selector='changeCustomerBillToSelector-input']")
	WebElement changeCustomerDropdown;

	@FindBy(xpath = "//ul[@data-test-selector='changeCustomerBillToSelector-listbox']")
	WebElement customerDropdownSuggestionList;

	@FindBy(xpath = "//button[@data-test-selector='changeCustomer_continue']")
	WebElement continueButton;

	@FindBy(css = "button[data-test-selector='cookiePolicy_AcceptCookies']")
	WebElement acceptCookiesButton;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public void userLogin(String username, String password) throws InterruptedException {
		CommonActions.sendKeys(usernameField, username);
		CommonActions.sendKeys(passwordField, password);
		CommonActions.click(signInButton);
		test.info("Entered Username as" + username + " Password as " + password + " and clicked on Sign In button");
		Thread.sleep(5000);
		CommonWaits.waitForPageLoad(driver);
	}

	public void changeCustomer(String customerName) {
		CommonWaits.waitForVisibility(driver, changeCustomerDropdown, 10);
		CommonActions.click(changeCustomerDropdown);
		CommonActions.sendKeys(changeCustomerDropdown, customerName);
		CommonWaits.waitForVisibility(driver, customerDropdownSuggestionList, 10);
		CommonActions.click(customerDropdownSuggestionList);
		CommonActions.click(continueButton);
		test.info("Changed customer to " + customerName);

	}

}

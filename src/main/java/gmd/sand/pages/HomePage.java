
package gmd.sand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gmd.sand.base.BaseTest;
import gmd.sand.utils.CommonActions;

public class HomePage extends BaseTest {
	WebDriver driver;

	@FindBy(xpath = "//input[@id=\"userName\"]")
	WebElement usernameField;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordField;

	@FindBy(xpath = "//button[@data-test-selector=\"signIn_submit\"]")
	WebElement signInButton;

	@FindBy(xpath = "//input[@data-test-selector=\"changeCustomerBillToSelector-input\"]")
	WebElement changeCustomerDropdown;

	@FindBy(xpath = "//ul[@data-test-selector=\"changeCustomerBillToSelector-listbox\"]")
	WebElement customerDropdownSuggestionList;

	@FindBy(xpath = "//button[@data-test-selector=\"changeCustomer_continue\"]")
	WebElement continueButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void userLogin(String username, String password) throws InterruptedException {
		CommonActions.sendKeys(usernameField, username);
		CommonActions.sendKeys(passwordField, password);
		CommonActions.click(signInButton);
		System.out.println("User logged in with username: " + username);
		Thread.sleep(5000); // Wait for potential page load after login
		waitForPageLoad();
	}

	public void changeCustomer(String customerName) {
		waitForVisibility(changeCustomerDropdown, 10);
		CommonActions.click(changeCustomerDropdown);
		CommonActions.sendKeys(changeCustomerDropdown, customerName);
		waitForVisibility(customerDropdownSuggestionList, 10);
		CommonActions.click(customerDropdownSuggestionList);
		CommonActions.click(continueButton);
		System.out.println("Customer changed to: " + customerName);

	}

}

package gmd.sand.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import gmd.sand.pages.CartPage;
import gmd.sand.pages.CheckoutReviewPage;
import gmd.sand.pages.HomePage;
import gmd.sand.pages.ProductListingPage;
import gmd.sand.utils.CommonActions;
import gmd.sand.utils.CommonWaits;
import gmd.sand.utils.ConfigReader;
import gmd.sand.utils.ReportManager;

public class BaseTest {
	protected static WebDriver driver;
	protected PageObjectManager pageObjectManager;
	protected HomePage homePage;
	protected ProductListingPage plp;
	protected CartPage cart;
	protected CheckoutReviewPage checkout;

	@BeforeClass
	public void launchApplication() {
		try {
			String browser = ConfigReader.getProperty("browser");
			if (browser == null || browser.isEmpty()) {
				throw new IllegalStateException("Browser type is not specified in config.");
			}

			driver = DriverFactory.initDriver(browser);
			if (driver == null) {
				throw new IllegalStateException("WebDriver initialization failed.");
			}

			driver.get(ConfigReader.getProperty("sandboxURL"));

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			ExtentTest test = ReportManager.createTest("Test Initialization");
			pageObjectManager = new PageObjectManager(driver, test);
			if (pageObjectManager == null) {
				throw new IllegalStateException("PageObjectManager initialization failed.");
			}
			try {
				WebElement acceptCookiesButton = driver
						.findElement(By.xpath("//button[@data-test-selector=\"cookiePolicy_AcceptCookies\"]"));
				if (acceptCookiesButton != null) {
					CommonWaits.waitForVisibility(driver, acceptCookiesButton, 10);
					CommonActions.click(acceptCookiesButton);
				}
			} catch (NoSuchElementException e) {
				System.out.println("Accept Cookies button not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Error interacting with Accept Cookies button: " + e.getMessage());
			}

			CommonActions.setPageZoom(driver, 90);

		} catch (Exception e) {
			System.err.println("Error during application launch: " + e.getMessage());
			throw e; // Optional: rethrow to fail the test setup
		}
	}

	@BeforeMethod
	public void initPages() {
		if (pageObjectManager == null) {
			throw new IllegalStateException("PageObjectManager is not initialized.");
		}
		homePage = pageObjectManager.getHomePage();
		plp = pageObjectManager.getPlp();
		cart = pageObjectManager.getCartPage();
		checkout = pageObjectManager.getCheckoutReviewPage();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			DriverFactory.quitDriver();
		}
	}

	@AfterSuite
	public void cleanUp() {
		ReportManager.flushReports();
	}
}

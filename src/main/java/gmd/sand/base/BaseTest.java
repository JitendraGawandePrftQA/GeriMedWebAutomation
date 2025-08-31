
package gmd.sand.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import gmd.sand.utils.CommonActions;
import gmd.sand.utils.ConfigReader;
import gmd.sand.utils.ReportManager;

public class BaseTest {
	protected static WebDriver driver;

	@BeforeMethod
	public void launchApplication() {
		driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));

		driver.get("https://spire-gerimed.commerce.insitesandbox.com/");

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement acceptCookiesButton = driver
				.findElement(By.cssSelector("button[data-test-selector='cookiePolicy_AcceptCookies']"));
		waitForVisibility(acceptCookiesButton, 10);
		CommonActions.click(acceptCookiesButton);

		CommonActions.setPageZoom(driver, 90);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

	@AfterSuite
	public void cleanUp() {
		ReportManager.flushReports();
	}

	public static void waitForVisibility(WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForClickability(WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementEnabled(WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForPageLoad() {
		int defaultTimeout = 10; // seconds
		new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout))
				.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
	}

	public void waitForInvisibility(WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.invisibilityOf(element));
	}

}

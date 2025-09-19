package gmd.sand.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

	public static WebDriver initDriver(String browser) {
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();
		driverThreadLocal.set(driver);
		return driver;
	}

	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}

	public static void quitDriver() {

		if (driverThreadLocal.get() != null) {
			driverThreadLocal.get().quit();
			driverThreadLocal.remove();
		}

	}
}


package gmd.sand.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver initDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}

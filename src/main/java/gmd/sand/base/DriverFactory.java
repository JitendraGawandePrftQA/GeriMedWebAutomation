
package gmd.sand.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static WebDriver driver;

	public static <Webdriver> WebDriver initDriver(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}

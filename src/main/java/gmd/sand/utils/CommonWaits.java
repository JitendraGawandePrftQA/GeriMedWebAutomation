package gmd.sand.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWaits {

	public static void waitForVisibility(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForClickability(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementEnabled(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForPageLoad(WebDriver driver) {
		int defaultTimeout = 10; // seconds
		new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout))
				.until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}

	public static void waitForInvisibility(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.invisibilityOf(element));
	}
}

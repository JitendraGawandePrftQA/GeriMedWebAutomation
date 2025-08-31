
package gmd.sand.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gmd.sand.base.BaseTest;

public class CommonActions extends BaseTest {

	static WebDriver driver;

	public static void click(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element, String fieldInput) {
		element.sendKeys(fieldInput);
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void selectByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	public static void selectByValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	public static void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	public static void moveToElement(WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	public static void doubleClick(WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	public static void rightClick(WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		new Actions(driver).dragAndDrop(source, target).perform();
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public static String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public static void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollToMiddleOfPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
	}

	public static void setPageZoom(WebDriver driver, double zoomPercent) {
		double zoom = zoomPercent / 100.0;
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='" + zoom + "';");
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
}

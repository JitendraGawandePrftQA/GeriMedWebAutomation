package gmd.sand.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonMethods {

	private WebDriver driver;

	@FindBy(css = "button[class$='react-datetime-picker__button']")
	private List<WebElement> datePicker;

	@FindBy(css = ".react-calendar__navigation__label__labelText--from")
	private WebElement monthToYearButton;

	@FindBy(css = ".react-calendar__navigation__label")
	private WebElement yearToYearButton;

	@FindBy(css = "button[class*='year-view__months__month']")
	private List<WebElement> monthButtons;

	@FindBy(css = "button[class*='month-view__days__day']")
	private List<WebElement> dayButtons;

	@FindBy(css = "input.react-datetime-picker__inputGroup__input")
	private List<WebElement> dateInputs;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String selectDateFromCalendar(String day, String month, String year) {
		// Open the date picker
		datePicker.get(0).click();

		// Navigate to year selection
		monthToYearButton.click();
		yearToYearButton.click();

		// Select year
		WebElement yearSelector = driver.findElement(By.xpath("//button[text()='" + year + "']"));
		yearSelector.click();
		System.out.println("Selected Year: " + year);

		// Select month (0-based index)
		int monthIndex = Integer.parseInt(month) - 1;
		monthButtons.get(monthIndex).click();
		System.out.println("Selected Month: " + month);

		// Select day (0-based index)
		int dayIndex = Integer.parseInt(day) - 1;
		dayButtons.get(dayIndex).click();
		System.out.println("Selected Day: " + day);

		// Read selected date from input fields
		String selectedDate = dateInputs.get(0).getAttribute("value") + "/" + dateInputs.get(1).getAttribute("value")
				+ "/" + dateInputs.get(2).getAttribute("value");

		System.out.println("Selected Date: " + selectedDate);
		return selectedDate;
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + ".png";
		File dest = new File(path);
		try {
			Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Error capturing screenshot: " + e.getMessage());
		}
		return path;
	}

}


package gmd.sand.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import gmd.sand.base.DriverFactory;
import gmd.sand.utils.CommonMethods;
import gmd.sand.utils.ReportManager;

public class TestListener implements ITestListener {

	WebDriver driver;

	public void onTestStart(ITestResult result) {
		ReportManager.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		ReportManager.getTest().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		WebDriver driver = DriverFactory.getDriver();
		ExtentTest test = ReportManager.getTest();
		String screenshotPath = CommonMethods.captureScreenshot(driver, result.getName());
		test.fail("Test Failed: " + result.getThrowable());
		try {
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			test.warning("Failed to attach screenshot: " + e.getMessage());
		}

	}

	public void onTestSkipped(ITestResult result) {
		ReportManager.getTest().log(Status.SKIP, "Test Skipped");
	}
	/*
	 * public void onStart(ITestContext context) {
	 * ReportManager.getTest().log(Status.INFO, "Test execution started: " +
	 * context.getName()); }
	 */

	public void onFinish(ITestContext context) {
		ReportManager.getTest().log(Status.INFO, "Test execution finished: " + context.getName());
	}

}

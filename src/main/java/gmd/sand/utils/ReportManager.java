package gmd.sand.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("User", System.getProperty("user.name"));
			extent.setSystemInfo("Browser", "Chrome");
		}
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		test = getExtentReports().createTest(testName);
		return test;
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static void flushReports() {
		if (extent != null) {
			extent.flush();
		}
	}
}

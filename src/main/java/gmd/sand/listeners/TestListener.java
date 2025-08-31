
package gmd.sand.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import gmd.sand.utils.ReportManager;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        ReportManager.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        ReportManager.getTest().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        ReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        ReportManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onStart(ITestContext context) {}
    public void onFinish(ITestContext context) {}
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}

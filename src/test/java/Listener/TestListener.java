package Listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import reports.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	
	ExtentReports extent = ExtentReportManager.getReportInstance();
    ExtentTest test;
	
	@Override
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
		String browser = result.getTestContext()
	            .getCurrentXmlTest()
	            .getParameter("browser");

	    test.info("Browser: " + browser);
	}
	
	@Override 
	public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

    }
	 @Override
	    public void onTestFailure(ITestResult result) {

	        test.fail(result.getThrowable());

	        BaseTest baseTest = (BaseTest) result.getInstance();

	        WebDriver driver = baseTest.getDriver();

	        if (driver != null) {
	            try {
	                String screenshotPath =
	                        ScreenshotUtils.captureScreenshot(
	                                driver,
	                                result.getName()
	                        );

	                test.addScreenCaptureFromPath(screenshotPath);

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 public void onTestSkipped(ITestResult result) {

	        test.skip("Test Skipped");

	    }

	    @Override
	    public void onFinish(org.testng.ITestContext context) {

	        extent.flush();

	    }
	
	
}
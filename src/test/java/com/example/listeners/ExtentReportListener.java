package com.example.listeners;



import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ExtentReportListener extends ExtentITestListenerClassAdapter {

    private static ExtentReports extentReports;
    private static Map<String, ExtentTest> extentTestMap = new ConcurrentHashMap<>();
    private static final Logger logger = Logger.getLogger(ExtentReportListener.class.getName());

    public ExtentReportListener() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reporting/Spark_ExtentReport.html");
            extentReports.attachReporter(sparkReporter);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass().getName() + "::" + result.getMethod().getMethodName();
        ExtentTest test = extentReports.createTest(testName);
        extentTestMap.put(result.getName(), test);
        super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        attachScreenshot(result, "Pass");
        super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot(result, "Fail");
        super.onTestFailure(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
            logger.info("ExtentReports flushed and report generated.");
        }
        super.onFinish(context);
    }

    private void attachScreenshot(ITestResult result, String status) {
        try {
       
            String screenshotPath = System.getProperty("user.dir")+"screenshots/" + result.getName() + ".png";
            logger.info("Looking for screenshot at: " + screenshotPath);
            if (Files.exists(Paths.get(screenshotPath))) {
                byte[] fileContent = Files.readAllBytes(Paths.get(screenshotPath));
                String base64Image = Base64.getEncoder().encodeToString(fileContent);
                result.setAttribute("screenshot", base64Image);

                getExtentTest(result).log(
                        status.equals("Pass") ? Status.PASS : Status.FAIL,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build()
                );
                logger.info("Screenshot attached for test: " + result.getName());
            } else {
                logger.warning("Screenshot not found for test: " + result.getName());
            }
        } catch (Exception e) {
            logger.severe("Error attaching screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private ExtentTest getExtentTest(ITestResult result) {
        return extentTestMap.get(result.getName());
    }
}
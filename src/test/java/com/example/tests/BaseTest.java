package com.example.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.utils.ConfigReader;
import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentTest extentTest;  // will be auto-injected by adapter
    protected BrowserContext context;
    
    @BeforeClass(alwaysRun = true)
    public void setupPlaywright() {
        playwright = Playwright.create();

        String browserName = ConfigReader.get("browser", "chromium");
        boolean headless = ConfigReader.getBoolean("headless");

        BrowserType browserType = switch (browserName.toLowerCase()) {
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            default -> playwright.chromium();
        };

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
        context = browser.newContext();
        page = browser.newPage();
    }
   
           protected void log(Status status, String message) {
        if (extentTest != null) {
            extentTest.log(status, message);
        }
        System.out.println("[" + status + "] " + message);
    }

           @AfterMethod
           public void captureFailureScreenshot(ITestResult result) {

               if (result.getStatus() == ITestResult.FAILURE && page != null) {
                   try {
                       String screenshotPath = "screenshots/" + result.getName() + ".png";
                       page.screenshot(
                           new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath))
                       );

                       if (extentTest != null) {
                           extentTest.addScreenCaptureFromPath(screenshotPath);
                       }

                   } catch (Exception e) {
                       log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
                   }
               }
           }

    
    @AfterClass
    public void teardownPlaywright() {

        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

}

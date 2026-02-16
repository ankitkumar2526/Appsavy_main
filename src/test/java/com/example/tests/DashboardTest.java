package com.example.tests;

import com.aventstack.extentreports.Status;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(description = "Verify dashboard after successful login")
    public void testDashboardAfterValidLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        log(Status.INFO, "Performing login with valid credentials");

        loginPage.login(
            ConfigReader.get("default.username"),
            ConfigReader.get("default.password")
        );

        DashboardPage dashboardPage = new DashboardPage(page);

        Assert.assertTrue(dashboardPage.isDashboardLoaded(), "Dashboard should be visible after login");
        Assert.assertEquals(dashboardPage.getHeaderText(), "Secure Area");

        log(Status.PASS, "Dashboard header verified: Secure Area");
    }
}
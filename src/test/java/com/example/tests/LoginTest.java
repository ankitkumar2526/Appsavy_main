package com.example.tests;

import com.aventstack.extentreports.Status;
import com.example.pages.LoginPage;
import com.example.utils.ConfigReader;
import com.example.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
      //  String excelPath = "C:/Users/DELL/Testingpw/Testingpw/src/test/resources/testdata/testdata.xlsx";
        String excelPath = System.getProperty("user.dir")  + "/src/test/resources/testdata/testdata.xlsx";

        ExcelUtil excel = new ExcelUtil(excelPath);
        Object[][] data = excel.getData("LoginData");
        excel.close();
        return data;
    }

    @Test(dataProvider = "loginData", description = "Data-driven login validation using Excel")
    public void testLoginWithExcelData(String username, String password) {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        log(Status.INFO, "Navigated to login page. Trying → Username: " +username);

        loginPage.login(username, password);

        boolean success = loginPage.isLoginSuccessful();
     //   String message = loginPage.getMessageText();

       // log(Status.INFO, "Login message: " + message);

        if (username.equals(ConfigReader.get("default.username")) &&
            password.equals(ConfigReader.get("default.password"))) {
            Assert.assertTrue(success, "Welcome to ControltestProject");
            log(Status.PASS, "Login successful for valid user");
        } else {
            Assert.assertFalse(success, "Invalid credentials should fail");
            log(Status.PASS, "Correctly rejected invalid credentials");
        }
    }
}
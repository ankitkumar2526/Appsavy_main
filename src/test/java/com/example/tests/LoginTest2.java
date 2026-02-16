package com.example.tests;


	import com.aventstack.extentreports.Status;
	import com.example.pages.LoginPage;
	import com.example.utils.ConfigReader;
	import org.testng.Assert;
	import org.testng.annotations.Test;
 
	public class LoginTest2 extends BaseTest {
 
	    @Test(description = "Verify successful login with valid credentials from config.properties")
	    public void testSuccessfulLogin() {
	        String username = ConfigReader.get("username");
	        String password = ConfigReader.get("password");
 
	        LoginPage loginPage = new LoginPage(page);
	        loginPage.navigate();
 
	        log(Status.INFO, "Navigated to login page");
	        log(Status.INFO, "Attempting login with username: " + username);
 
	        loginPage.login(username, password);
 
	        boolean success = loginPage.isLoginSuccessful();
	        String message = loginPage.getMessageText();
 
	        log(Status.INFO, "Login result message: " + message);
 
	        Assert.assertTrue(success, "Welcome to ControltestProject");
	      //  Assert.assertTrue(message.contains("You logged into a secure area!"), 
	                //         "Success message should be displayed");
 
	        log(Status.PASS, "Login successful with valid credentials from config");
	    }
	}
 



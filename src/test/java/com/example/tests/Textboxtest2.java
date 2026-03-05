package com.example.tests;

import java.util.concurrent.PriorityBlockingQueue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.DashboardPage;
import com.example.pages.Textbox;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.example.pages.LoginPage;

public class Textboxtest2 extends BaseTest {

	LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Textbox textboxPage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        textboxPage = new Textbox(page);
    }
    
	@DataProvider(name = "multilingualData")
	public Object[][] multilingualDataProvider() {
		return new Object[][] {
			{"yes", new String[] {"english", " हिंदी"}},
			{"no", new String[] {"singlename"}}
			
		};
	}

	 @Test(priority=1, description = "Naviagte to textbox form")
		public void Multilingual() {
			
			
			loginPage.navigate();

			loginPage.login(
			    ConfigReader.get("username"),
			    ConfigReader.get("password")
			   );
			
			
			adminRolePage.clickAdmin1();
			page.waitForTimeout(2000);
		            controlTestProject.clipBar();
			    	controlTestProject.searchbox();
			    	controlTestProject.textbox();
			    	 page.waitForTimeout(2000);
	 }
			    	
			    	 @Test(priority=2,dataProvider = "multilingualData", description = "Verify Multilingual Functionality")
			    	public void testMultilingualFunctionality(String MultilingualOption, String[] names) {
			    	
			    	// Multilingual Functionality
			    	log(Status.INFO, "Starting Multilingual Functionality Test with option: " + MultilingualOption);
			    	textboxPage.selectMultilingualOption(MultilingualOption);
			    	// handling option
			    	if ("yes".equalsIgnoreCase(MultilingualOption)) {
			    		for(String name : names) {
			    		log(Status.INFO, "Verifying name: " + name);
			    		textboxPage.multilingualFunctionality(names[0], names[1]);
			    		}
			    	} else if ("no".equalsIgnoreCase(MultilingualOption)) {
			    	    String singlename =	names[0];
			    	   	log(Status.INFO, "Verifying singlename: " + singlename);
			    	   	textboxPage.multilingualFunctionality(singlename, singlename);
			    	}
			    	 }
			    	 
			    	 
			    	public void 
  } 
		
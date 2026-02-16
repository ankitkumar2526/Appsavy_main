package com.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.pages.Textbox;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class ControlTestPro extends BaseTest {
	LoginPage loginPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
   
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
       
    }

 @Test(priority=1, description = "Verify Admin Role Functionality")
	public void loginFunctionality() {
		
		
		
		loginPage.navigate();
        loginPage.login(ConfigReader.get("username"),ConfigReader.get("password") );
 }
        @Test(priority=2, description = "Verify Admin Role Functionality")
        		public void testAdminRole() {
		    	
		adminRolePage.clickAdmin1();
		 log(Status.INFO, "Clicked on Admin1");
		 page.waitForTimeout(2000);
        }
		
        @Test(priority=3, description = "Verify Control Test Functionality")
            public void testControlTestProject() {
        	
		    	// Click on Admin1
		    	controlTestProject.clipBar();
		    	controlTestProject.searchbox();
		    	controlTestProject.textbox();
		    	 page.waitForTimeout(2000);
		    	PlaywrightAssertions.assertThat(page.locator("#frmName")).isVisible();
		    }

}


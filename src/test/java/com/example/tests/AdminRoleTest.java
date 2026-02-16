package com.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class AdminRoleTest extends BaseTest {


	LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;

    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
    }
	 
	@Test(priority=1, description = "Verify Admin Role Functionality")
	public void testAdminRoleFunctionality() {
		
		
		loginPage.navigate();

		loginPage.login(
		    ConfigReader.get("username"),
		    ConfigReader.get("password")
		   );
	}
		    @Test(priority=2, description = "verify admin role") 
		    public void testAdminRole() {
		    
		    	// Click on Admin1
		    	
		adminRolePage.clickAdmin1();
		 log(Status.INFO, "Clicked on Admin1");
		 page.waitForTimeout(2000);
		 PlaywrightAssertions.assertThat(page.locator("#proAppName")).isVisible();
		
//		// Click on Admin2
//		adminRolePage.clickAdmin2();
//		log(Status.INFO, "Clicked on Admin2");
		
		// Add assertions as needed to verify the expected behavior after clicking Admin1 and Admin2
		log(Status.PASS, "Admin Role functionality verified successfully");
	}
		    @Test(priority=3, description = "verify user button ")  
		    public void testUserButton() {
		    	// ControlTestProject controlTestProject = new ControlTestProject(page);
		    	// Click on Admin1
		    	controlTestProject.clipBar();
		    	controlTestProject.searchbox();
		    	controlTestProject.textbox();
		    	PlaywrightAssertions.assertThat(page.locator("#lblCap109381")).isVisible();
		    }
}

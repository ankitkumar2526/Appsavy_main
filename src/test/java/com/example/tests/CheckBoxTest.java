package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.CheckBoxPage;
import com.example.pages.CheckboxDropDownPage;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class CheckBoxTest extends BaseTest {
	LoginPage loginPage;
	AdminRole adminRolePage;
	ControlTestProject controlTestProject;
	CheckBoxPage checkBoxPage;

	@BeforeClass
	public void initPages() throws InterruptedException {
		loginPage = new LoginPage(page);
		adminRolePage = new AdminRole(page);
		controlTestProject = new ControlTestProject(page);
		Thread.sleep(2000);
		checkBoxPage = new CheckBoxPage(page);

	}

	@Test(priority = 1, description = "Verify Admin Role Functionality")
	public void loginFunctionality() {

		loginPage.navigate();
		loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
	}

	@Test(priority = 2, description = "Verify Admin Role Functionality")
	public void testAdminRole() {

		adminRolePage.clickAdmin1();
		log(Status.INFO, "Clicked on Admin1");
		page.waitForTimeout(5000);
	}
	@Test(priority = 3, description = "Verify Control Test Functionality")
	public void testControlTestProject() {

		// Click on Admin1
		controlTestProject.clipBar();
		checkBoxPage.searchbox();
		checkBoxPage.CheckBox();
		page.waitForTimeout(2000);
		PlaywrightAssertions.assertThat(page.locator("#proAppName")).isVisible();
	}
	
	@Test(priority = 4, description = "by fetching the page title, verifying the correct page is opened")
	public void verifyCheckbox_control_testSuccessfullyOpen() { 
		String pageTitle = page.title();
    System.out.println("Page Title is: " + pageTitle);
    Assert.assertEquals(pageTitle, "chkbox_9sep", "Page title does not match!");}
}

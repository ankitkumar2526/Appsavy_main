package com.example.tests;

import java.io.IOException;

import javax.sound.sampled.Line;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.CheckboxDropDownPage;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.Label;
import com.example.pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class CheckboxDropDownTest extends BaseTest {
	LoginPage loginPage;
	AdminRole adminRolePage;
	ControlTestProject controlTestProject;
	CheckboxDropDownPage checkboxDropDownPage;

	@BeforeClass
	public void initPages() throws InterruptedException {
		loginPage = new LoginPage(page);
		adminRolePage = new AdminRole(page);
		controlTestProject = new ControlTestProject(page);
		Thread.sleep(2000);
		checkboxDropDownPage = new CheckboxDropDownPage(page);

	}

	@Test(priority = 1, description = "Verify Admin Role Functionality")
	public void loginFunctionality() {

		loginPage.navigate();
		loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
		System.out.println("LINE..................................46");
	}

	@Test(priority = 2, description = "Verify Admin Role Functionality")
	public void testAdminRole() {

		adminRolePage.clickAdmin1();
		System.out.println("LINE..................................53");
		log(Status.INFO, "Clicked on Admin1");
		page.waitForTimeout(2000);
	}

	@Test(priority = 3, description = "Verify Control Test Functionality")
	public void testControlTestProject() {

		// Click on Admin1
		controlTestProject.clipBar();
		checkboxDropDownPage.searchbox();
		checkboxDropDownPage.checkboxDropDown();
		page.waitForTimeout(2000);
		PlaywrightAssertions.assertThat(page.locator("#proAppName")).isVisible();
	}

	@Test(priority = 4)
	public void verifyCheckboxDropDownFontSize() throws IOException, InterruptedException {

		checkboxDropDownPage.CaptionFontSize();

	}

	@Test(priority = 5)
	public void verifyUniqueControlNamesOnSingleForm() throws IOException, InterruptedException {

		checkboxDropDownPage.unniqueControl();

	}
	@Test(priority = 6)
	public void verifyCaptionFontColor() throws IOException, InterruptedException {
		
		checkboxDropDownPage.CaptionFontColor();
		
	}

	@Test(priority = 7)
	 public void verifyBackgroundColor_Checkbox() throws InterruptedException {
		checkboxDropDownPage.backgroundColor();  
    }
}

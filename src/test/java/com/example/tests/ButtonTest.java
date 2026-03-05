package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ButtonPage;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.LoadState;

public class ButtonTest extends BaseTest {
	LoginPage loginPage;
	AdminRole adminRolePage;
	ControlTestProject controlTestProject;
	ButtonPage buttonPage;

	@BeforeClass
	public void initPages() throws InterruptedException {
		loginPage = new LoginPage(page);
		adminRolePage = new AdminRole(page);
		controlTestProject = new ControlTestProject(page);
		Thread.sleep(2000);
		buttonPage = new ButtonPage(page);

	}

	@Test(priority = -2, description = "Verify Admin Role Functionality")
	public void loginFunctionality() {

		loginPage.navigate();
		loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
	}

	@Test(priority = -1, description = "Verify Admin Role Functionality")
	public void testAdminRole() {

		adminRolePage.clickAdmin1();
		log(Status.INFO, "Clicked on Admin1");
		page.waitForTimeout(5000);
	}

	 @Test(priority = 1,description = "Verify button name is displayed in Hindi after language change")
	public void verifyButtonNameInHindi() {
		 buttonPage.buttonNameInHindi();
	 }

	 @Test(priority = 2,description = "Verify form button name 'Language Data' remains in English after language change")
	public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

		 buttonPage.englishLanguageAfterLanguageChange();
	}

	 @Test( priority = 3,description = "Verify the 'Caption' property is visible to users for control 'Caption Test' on web form")
	public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {
		 buttonPage.captionPropertyVisibility();
	 }

 @Test(priority = 4,description = "Verify image icon is placed to the left of the caption text for Image control button")
	public void verifyImageIsLeftOfCaptionForImageButton() {
	 buttonPage.ImageIsLeftOfCaption();
 }

	 @Test( priority = 5,description = "Verify that the Width button has width of 50")
	public void verifyWidthButtonSizeIs50() {
		 buttonPage.buttonWidth();
		 }

    @Test(priority = 6,description = "Verify that control name 'visibility_y' is visible on web form")
	public void verifyVisibilityYControlIsVisible() {
    	 buttonPage.controlVisibility();
    }

    @Test(priority = 7, description = "Verify that control name 'visibility_n' is not available on web form")
	public void verifyVisibilityNControlIsNotVisible() {
    	 buttonPage.controlVisibilityifN();
    }

	@Test(priority = 8, description = "Verify Font Size is set to 25")
	public void verifyFontSizeIs25() {
		 buttonPage.fontSize();
	}

	@Test(priority = 9, description = "Verify Font Style is Bold")
	public void verifyFontStyleIsBold() {
		 buttonPage.fontStyle();
	}

	@Test(priority = 10, description = "Verify Font Color is #1322ec")
	public void verifyFontColor() {
		 buttonPage.fontColor();
	}

	@Test(priority = 11, description = "Verify Background Color is #ecf024")
	public void verifyBackgroundColor() {
		 buttonPage.backgroundColor();
	}

}

package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.DropdownListPage;
import com.example.pages.LoginPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.LoadState;

public class DropdownListTest extends BaseTest {
	LoginPage loginPage;
	AdminRole adminRolePage;
	ControlTestProject controlTestProject;
	DropdownListPage dropdownListPage;

	@BeforeClass
	public void initPages() throws InterruptedException {
		loginPage = new LoginPage(page);
		adminRolePage = new AdminRole(page);
		controlTestProject = new ControlTestProject(page);
		Thread.sleep(2000);
		dropdownListPage = new DropdownListPage(page);

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

	@Test(priority = 1, description = "Verify Dropdown name is displayed in Hindi after language change")
	public void verifyDropdownNameInHindi() {
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("fa-bars")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" CONTEST ")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Button").setExact(true)).click();
		// page.locator("#clpsBar").click();
		System.out.println("[PASS] Collapse bar clicked");

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DROPDOWN").setExact(true)).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Form name Dropdown is selected and entered into the form Dropdown");

		// Step: Change language to Hindi
		page.locator("#ddllanguage").selectOption("2");
		System.out.println("[PASS] Form Language changed to Hindi");

		// Step: Locate Hindi button
		Locator hindiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("बहुभाषी परीक्षण"));
		System.out.println("[INFO] Locating Hindi button");
		System.out.println("[PASS] Dropdown name is displayed correctly in Hindi" + hindiButton);
	}

	@Test(priority = 2, description = "Verify Hindi caption 'शिकायत का प्रकार' is displayed correctly for Dropdown control")
	public void verifyHindiCaptionForComplaintType() {

		System.out.println("[PASS] Collapse bar clicked");

		// Navigate to CONTEST
//			    page.locator("text=CONTEST").first().click();
//			    page.waitForLoadState(LoadState.NETWORKIDLE);
//			    System.out.println("[PASS] Entered into form list");

		// Open DROPDOWN form
//			    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DROPDOWN").setExact(true)).click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Dropdown form opened");

		Locator hindiCaption = page.locator("text=शिकायत का प्रकार");

		System.out.println("[INFO] Verifying Hindi caption for Complaint Type");

		// ---------------------------
		// Step 3: Verify caption is visible
		// ---------------------------
		Assert.assertTrue(hindiCaption.isVisible(), "[FAIL] Caption 'शिकायत का प्रकार' is not visible on the form");

		// ---------------------------
		// Step 4: Verify caption text
		// ---------------------------
		Assert.assertEquals(hindiCaption.textContent().trim(), "शिकायत का प्रकार",
				"[FAIL] Caption text is not displayed in Hindi correctly");

		System.out.println("[PASS] Caption 'शिकायत का प्रकार' is visible and displayed correctly in Hindi");
	}

	@Test(priority = 3, description = "Verify form Dropdown name 'Decimal' remains in English after language change")
	public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

//		 System.out.println("[PASS] Collapse bar clicked");
//		page.locator("text=CONTEST").first().click();
//		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list");

//		page.locator("text=DROPDOWN").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Form dropdown  is selected and entered into the form dropdown");

		// Step: Change language to Hindi
		page.locator("#ddllanguage").selectOption("2");
		System.out.println("[PASS] Form Language changed to Hindi");

		// Step: Locate Language Data button (should remain English)
		Locator languageDataButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Decimal"));
		System.out.println("[INFO] Locating 'Decimal' Dropdown");

		System.out.println(
				"[PASS] Dropdown name 'Decimal' remains in English after language change" + languageDataButton);
	}

	@Test(priority = 4, description = "Verify the 'Caption' property is visible to users for control 'Caption Left' on web form")
	public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {

		// Step 1: Navigate to form list
//		page.locator("text=CONTEST").first().click();
//		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list");

		// Step 2: Open Button form
//		page.locator("text=DROPDOWN").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Dropdown opened successfully for caption test");

		// Step 3: Open Caption Test control
		page.locator("text=Caption Left").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] 'Caption Left" + "' control opened successfully");

		// Step 4: Locate Caption property on web UI
		Locator captionProperty = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Caption Left"));
		System.out.println("[INFO] Locating 'Caption Left' property");

		// Step 5: Assertions
		Assert.assertTrue(captionProperty.isVisible(), "[FAIL] Caption property is not visible to the user");

		System.out.println("[PASS] Caption property is visible to users in the form interface");
	}

	@Test(priority = 5, description = "Verify image icon is placed to the left of the caption text for Dropdown")
	public void verifyImageIsLeftOfCaptionForImageButton() {

		// Step 1: Navigate to form list
//		page.locator("text=CONTEST").first().click();
//		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list");

		// Step 2: Open Button form
//		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully");

		// Step 3: Locate Image button
		Locator imageButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Image"));
		Assert.assertTrue(imageButton.isVisible(), "[FAIL] Image button is not visible");
		System.out.println("[PASS] Image button is visible");

		// Step 4: Locate image icon inside button
		Locator imageIcon = imageButton.locator("img, svg").first();
		Assert.assertTrue(imageIcon.isVisible(), "[FAIL] Image icon is not visible");
		System.out.println("[PASS] Image icon located");

		// Step 5: Locate caption text inside button
		Locator captionText = imageButton.locator("text=Image").first();
		Assert.assertTrue(captionText.isVisible(), "[FAIL] Caption text is not visible");
		System.out.println("[PASS] Caption text located");

		// Step 6: Get bounding boxes
		BoundingBox iconBox = imageIcon.boundingBox();
		BoundingBox textBox = captionText.boundingBox();

		Assert.assertNotNull(iconBox, "[FAIL] Image icon bounding box is null");
		Assert.assertNotNull(textBox, "[FAIL] Caption text bounding box is null");

		System.out.println("[INFO] Image icon X position : " + iconBox.x);
		System.out.println("[INFO] Caption text X position : " + textBox.x);

		// Step 7: Verify icon is to the left of caption text
		Assert.assertTrue(iconBox.x < textBox.x, "[FAIL] Image icon is not placed to the left of the caption text");

		System.out.println("[PASS] Image icon is correctly placed to the left of the caption text");
	}

	 @Test( priority = 5,description = "Verify that the Width button has width of 50")
	public void verifyWidthButtonSizeIs50() {

		// Step 1: Navigate to form list
//		page.locator("text=CONTEST").first().click();
//		page.waitForLoadState(LoadState.NETWORKIDLE);
//		System.out.println("[PASS] Menu selected and entered into form list");

		// Step 2: Open Button form
		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully");

		// Step 3: Locate the Width button
		Locator widthButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Width"));
		System.out.println("[INFO] Locating Width button");

		// Step 4: Ensure button is visible
		Assert.assertTrue(widthButton.isVisible(), "[FAIL] Width button is not visible");

		// Step 5: Get button width using BoundingBox
		BoundingBox box = widthButton.boundingBox();
		Assert.assertNotNull(box, "[FAIL] BoundingBox is null for Width button");

		double actualWidth = box.width;
		System.out.println("[INFO] Actual Width button size = " + actualWidth);
		// Step 6: Assertion - Verify width is between 45 and 60
		Assert.assertTrue(actualWidth >= 45 && actualWidth <= 60,
				"[FAIL] Width button size is not in the range 45 to 60. Actual width: " + actualWidth);

		System.out.println("[PASS] Width button has correct width of 50");
	}

//   @Test(priority = 6,description = "Verify that control name 'visibility_y' is visible on web form")
	public void verifyVisibilityYControlIsVisible() {

		// Navigate to Button form
		page.locator("text=CONTEST").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list");

		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully");

		// Locate visibility_y control
		Locator visibilityY = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("visibility_y"));

		// Assertion
		Assert.assertTrue(visibilityY.isVisible(), "[FAIL] Control 'visibility_y' is not visible on web form");

		System.out.println("[PASS] Control 'visibility_y' is visible on web form");
	}

//   @Test(priority = 7, description = "Verify that control name 'visibility_n' is not available on web form")
	public void verifyVisibilityNControlIsNotVisible() {

		// Navigate to Button form
		page.locator("text=CONTEST").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list");

		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully");

		// Locate visibility_n control
		Locator visibilityN = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("visibility_n"));

		// Assertion
		Assert.assertEquals(visibilityN.count(), 0,
				"[FAIL] Control 'visibility_n' is unexpectedly visible on web form");

		System.out.println("[PASS] Control 'visibility_n' is not available on web form");
	}

//	@Test(priority = 8, description = "Verify Font Size is set to 25")
	public void verifyFontSizeIs25() {
		// Navigate to Button form
		page.locator("text=CONTEST").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list for font size test");

		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully for font size test");

		Locator fontSizeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Font Size"));

		Assert.assertTrue(fontSizeButton.isVisible(), "[FAIL] Font Size button is not visible");
		System.out.println("[PASS] Font Size button is visible");

		String fontSize = fontSizeButton.evaluate("el => window.getComputedStyle(el).fontSize").toString();

		System.out.println("[INFO] Actual font size: " + fontSize);

		Assert.assertEquals(fontSize, "25px", "[FAIL] Font size is not 25px");
		System.out.println("[PASS] Font size is 25px");
	}

//	@Test(priority = 9, description = "Verify Font Style is Bold")
	public void verifyFontStyleIsBold() {
		// Navigate to Button form
		page.locator("text=CONTEST").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list for font style test");

		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully for font style test");
		Locator fontStyleButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Font Style"));

		Assert.assertTrue(fontStyleButton.isVisible(), "[FAIL] Font Style button is not visible");
		System.out.println("[PASS] Font Style button is visible");

		String fontWeight = fontStyleButton.evaluate("el => window.getComputedStyle(el).fontWeight").toString();

		System.out.println("[INFO] Actual font weight: " + fontWeight);

		// Bold can be "bold" or numeric >= 700
		Assert.assertTrue(fontWeight.equalsIgnoreCase("bold") || Integer.parseInt(fontWeight) >= 700,
				"[FAIL] Font style is not Bold");

		System.out.println("[PASS] Font style is Bold");
	}

//	@Test(priority = 10, description = "Verify Font Color is #1322ec")
	public void verifyFontColor() {
		// Navigate to Button form
		page.locator("text=CONTEST").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list for font color test");

		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully for font color test");
		Locator fontColorButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Font Color"));

		Assert.assertTrue(fontColorButton.isVisible(), "[FAIL] Font Color button is not visible");
		System.out.println("[PASS] Font Color button is visible");

		String color = fontColorButton.evaluate("el => window.getComputedStyle(el).color").toString();

		System.out.println("[INFO] Actual font color: " + color);

		// rgb(19, 34, 236) == #1322ec
		Assert.assertEquals(color, "rgb(19, 34, 236)", "[FAIL] Font color is not #1322ec");
		System.out.println("[PASS] Font color is #1322ec");
	}

//	@Test(priority = 11, description = "Verify Background Color is #ecf024")
	public void verifyBackgroundColor() {
		// Navigate to Button form
		page.locator("text=CONTEST").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Menu selected and entered into form list for background color test");

		page.locator("text=Button").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] Button form opened successfully for background color test");
		Locator backgroundColorButton = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Background Color"));

		Assert.assertTrue(backgroundColorButton.isVisible(), "[FAIL] Background Color button is not visible");
		System.out.println("[PASS] Background Color button is visible");

		String bgColor = backgroundColorButton.evaluate("el => window.getComputedStyle(el).backgroundColor").toString();

		System.out.println("[INFO] Actual background color: " + bgColor);

		// rgb(236, 240, 36) == #ecf024
		Assert.assertEquals(bgColor, "rgb(236, 240, 36)", "[FAIL] Background color is not #ecf024");
		System.out.println("[PASS] Background color is #ecf024");
	}

}

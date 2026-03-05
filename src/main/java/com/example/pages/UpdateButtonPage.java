package com.example.pages;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

//import tests.String;

public class UpdateButtonPage {
	
	
	
	
	
	private final Page page;

	public UpdateButtonPage (Page page) {
		this.page = page;

	}
	
	// Verify Hindi caption is saved and displayed correctly for Update Button
	public void verifyHindiCaptionSavedAndVisibleForUpdateButton() {

	    // Step: Change language to Hindi
	    page.locator("#ddllanguage").selectOption("2");
	    System.out.println("[PASS] Form Language changed to Hindi");

	    // Step 1: Locate Save button
	    Locator saveButtonHindi = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("भाषा")
	    );

	    System.out.println("[INFO] Locating Update button with Hindi label");

	    // Step 2: Verify visibility
	    Assert.assertTrue(
	            saveButtonHindi.isVisible(),
	            "[FAIL] Save button 'भाषा' is not visible on the form"
	    );

	    // Step 3: Verify button text
	    Assert.assertEquals(
	            saveButtonHindi.textContent().trim(),
	            "भाषा",
	            "[FAIL] Save button text is incorrect"
	    );

	    System.out.println("[PASS] Save button name 'भाषा' is visible and correct");
	}
	
	
	
	
	// Verify Update button name is displayed in Hindi after language change
	public void verifySaveButtonNameChnageInHindi() {

	    // Step: Change language to Hindi
	    page.locator("#ddllanguage").selectOption("2");

	    // Step: Locate Hindi button
	    Locator hindiButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("बहुभाषी परीक्षण")
	    );

	    // Step: Verify visibility
	    Assert.assertTrue(
	            hindiButton.isVisible(),
	            "[FAIL] Hindi Update button is not visible"
	    );

	    // Step: Verify text
	    Assert.assertEquals(
	            hindiButton.textContent().trim(),
	            "बहुभाषी परीक्षण",
	            "[FAIL] Update button name is not correct in Hindi"
	    );
	}
	
	
	// Verify form button name 'Do Not Show' remains in English after language change
	public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

	    // Step: Change language to Hindi
	    page.locator("#ddllanguage").selectOption("2");

	    // Step: Locate Language Data button (should remain English)
	    Locator languageDataButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Do Not Show")
	    );

	    // Assertions
	    Assert.assertTrue(
	            languageDataButton.isVisible(),
	            "[FAIL] Language Data Updatebutton is not visible"
	    );

	    Assert.assertEquals(
	            languageDataButton.textContent().trim(),
	            "Do Not Show",
	            "[FAIL] Update Button name changed after language selection"
	    );
	}
	
	
	
	
	// Verify the ' Caption Test' property is visible to users for control 'Update Button' on web form
	public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {

	    // Step 3: Open Caption Test control
	    page.locator("text= Caption Test").first().click();
	    page.waitForLoadState(LoadState.NETWORKIDLE);

	    // Step 4: Locate Caption property on web UI
	    Locator captionProperty = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Caption Test")
	    );

	    // Step 5: Assertion
	    Assert.assertTrue(
	            captionProperty.isVisible(),
	            "[FAIL] Caption property is not visible to the user"
	    );
	}
	
	
	// Verify that control name 'VISIBILITY_Y' is visible on web form
	public void verifyVisibilityYControlIsVisible() {

	    // Locate visibility_y control
	    Locator visibilityY = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("VISIBILITY_Y")
	    );

	    // Assertion
	    Assert.assertTrue(
	            visibilityY.isVisible(),
	            "[FAIL] Control 'VISIBILITY_Y' is not visible on web form"
	    );
	}
	
	
	
	
	// Verify that control name 'VISIBILITY_N' is not available on web form
	public void verifyVisibilityNControlIsNotVisible() {

	    // Locate visibility_n control
	    Locator visibilityN = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("VISIBILITY_N")
	    );

	    // Assertion (element should NOT exist)
	    Assert.assertEquals(
	            visibilityN.count(),
	            0,
	            "Control 'VISIBILITY_N' is unexpectedly visible on web form"
	    );
	}
	
	
	
	
	// Verify Font Size is set to 30 for save button named 'Font Size'
	public void verifyFontSizeIs30() {

	    Locator fontSizeButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Font Size")
	    );

	    // Visibility check
	    Assert.assertTrue(
	            fontSizeButton.isVisible(),
	            "Font Size button is not visible"
	    );

	    // Get computed font size
	    String fontSize = fontSizeButton
	            .evaluate("el => window.getComputedStyle(el).fontSize")
	            .toString();

	    // Assertion
	    Assert.assertEquals(
	            fontSize,
	            "30px",
	            "Font size is not 30px"
	    );
	}
	
	
	
	// Verify Font Style is Bold
	public void verifyFontStyleIsBold() {

	    Locator fontStyleButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Font Style")
	    );

	    // Visibility check
	    Assert.assertTrue(
	            fontStyleButton.isVisible(),
	            "Font Style button is not visible"
	    );

	    // Get computed font weight
	    String fontWeight = fontStyleButton
	            .evaluate("el => window.getComputedStyle(el).fontWeight")
	            .toString();

	    // Bold can be "bold" or numeric >= 700
	    Assert.assertTrue(
	            fontWeight.equalsIgnoreCase("bold") ||
	            Integer.parseInt(fontWeight) >= 700,
	            "Font style is not Bold"
	    );
	}

	
	
	// Verify Font Color is #1724de
	public void verifyFontColor() {

	    Locator fontColorButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Font Color")
	    );

	    // Visibility check
	    Assert.assertTrue(
	            fontColorButton.isVisible(),
	            "Font Color Savebutton is not visible"
	    );

	    // Get computed font color
	    String color = fontColorButton
	            .evaluate("el => window.getComputedStyle(el).color")
	            .toString();

	    // #1724de = rgb(23, 36, 222)
	    Assert.assertEquals(
	            color,
	            "rgb(23, 36, 222)",
	            "Font color is not #1724de"
	    );
	}

	
	

	
	// Verify Background Color is #e1c019
	public void verifyBackgroundColor() {

	    Locator backgroundColorButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Background Color")
	    );

	    // Visibility check
	    Assert.assertTrue(
	            backgroundColorButton.isVisible(),
	            "Background Color button is not visible"
	    );

	    // Get computed background color
	    String bgColor = backgroundColorButton
	            .evaluate("el => window.getComputedStyle(el).backgroundColor")
	            .toString();

	    // #e1c019 = rgb(225, 192, 25)
	    Assert.assertEquals(
	            bgColor,
	            "rgb(225, 192, 25)",
	            "Background color is not #e1c019"
	    );
	}







	
	
	
	
	
	
	
	
	
	
	
	

}

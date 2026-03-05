package com.example.pages;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

//import tests.String;

public class SaveButtonPage {
	
	
	
	
	
	
	
	
	
	
	
	
	private final Page page;

	public SaveButtonPage (Page page) {
		this.page = page;

	}
	
	// Verify savebutton name is displayed in Hindi after language change
	public void verifySaveButtonNameChnageInHindi() {

	    // Change language to Hindi
	    page.locator("#ddllanguage").selectOption("2");

	    // Locate Hindi button
	    Locator hindiButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("भाषा")
	    );

	    // Assertions
	    Assert.assertTrue(
	            hindiButton.isVisible(),
	            "SaveButton Hindi name is not visible"
	    );

	    Assert.assertEquals(
	            hindiButton.textContent().trim(),
	            "भाषा",
	            "SaveButton name is not displayed correctly in Hindi"
	    );
	}
	
	
	
	// Verify form button name 'Vertical' remains in English after language change
	public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

	    // Change language to Hindi
	    page.locator("#ddllanguage").selectOption("2");

	    // Locate Vertical button (should remain English)
	    Locator languageDataButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Vertical")
	    );

	    // Assertions
	    Assert.assertTrue(
	            languageDataButton.isVisible(),
	            "Language Data savebutton is not visible"
	    );

	    Assert.assertEquals(
	            languageDataButton.textContent().trim(),
	            "Vertical",
	            "SaveButton name changed after language selection"
	    );
	}


	
	
	
	
	
	
	// Verify Hindi input is saved and visible in Language Details grid
	public void verifyHindiInputSavedAndVisibleInGrid() {

	    String hindiText = "सूर्य प्रकाश";

	    // Enter Hindi text
	    Locator hindiInput = page.locator("#ctrl109067");
	    hindiInput.click();
	    hindiInput.fill(hindiText);

	    // Handle confirmation dialog
	    page.onceDialog(dialog -> dialog.dismiss());

	    // Click Save button (भाषा)
	    page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("भाषा")
	    ).click();

	    // Open Language Details section
	    page.getByText("language details").click();
	    page.waitForLoadState(LoadState.NETWORKIDLE);

	    // Validate Hindi text in grid (STRICT MODE SAFE)
	    Locator gridText = page.getByRole(
	            AriaRole.GRIDCELL,
	            new Page.GetByRoleOptions().setName(hindiText)
	    ).first();

	    Assert.assertTrue(
	            gridText.isVisible(),
	            "Hindi text is not saved or not visible in Language Details grid"
	    );
	}


	
	
	// Verify Save button name 'भाषा' is visible on the form
	public void verifySaveButtonNameInHindi() {

	    // Change language to Hindi
	    page.locator("#ddllanguage").selectOption("2");

	    // Locate Save button
	    Locator saveButtonHindi = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("भाषा")
	    );

	    // Verify visibility
	    Assert.assertTrue(
	            saveButtonHindi.isVisible(),
	            "Save button 'भाषा' is not visible on the form"
	    );

	    // Verify button text
	    Assert.assertEquals(
	            saveButtonHindi.textContent().trim(),
	            "भाषा",
	            "Save button text is incorrect"
	    );
	}

	
	
	// Verify the 'Caption' property is visible to users for control 'Caption Test' on web form
	public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {

	    // Open Caption Test control
	    page.getByText("CAPTION TEST").first().click();
	    page.waitForLoadState(LoadState.NETWORKIDLE);

	    // Locate Caption property
	    Locator captionProperty = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("CAPTION TEST")
	    );

	    // Assertion
	    Assert.assertTrue(
	            captionProperty.isVisible(),
	            "Caption property is not visible to the user"
	    );
	}
	
	
	// Verify that control name 'visibility_y' is visible on web form
	public void verifyVisibilityYControlIsVisible() {

	    // Locate visibility_y control
	    Locator visibilityY = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("VISIBILITY_Y")
	    );

	    // Assertion
	    Assert.assertTrue(
	            visibilityY.isVisible(),
	            "Control 'visibility_y' is not visible on web form"
	    );
	}


	
	
	
	
	
	// Verify that control name 'visibility_n' is not available on web form
	public void verifyVisibilityNControlIsNotVisible() {

	    // Locate visibility_n control
	    Locator visibilityN = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("VISIBILITY_N")
	    );

	    // Assertion (should NOT exist in DOM)
	    Assert.assertEquals(
	            visibilityN.count(),
	            0,
	            "Control 'visibility_n' is unexpectedly visible on web form"
	    );
	}

	
	
	// Verify Font Size is set to 30 for save button named 'Font Size'
	public void verifyFontSizeIs25() {

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

	    // Validate font size
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
	
	// Verify Font Color is #470af0
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

	    // Validate color (rgb(231, 19, 40))
	    Assert.assertEquals(
	            color,
	            "rgb(231, 19, 40)",
	            "Font color is not #470af0"
	    );
	}

	// Verify Background Color is #fac01e
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

	    // Validate background color (rgb(250, 192, 30))
	    Assert.assertEquals(
	            bgColor,
	            "rgb(250, 192, 30)",
	            "Background color is not #fac01e"
	    );
	}

}
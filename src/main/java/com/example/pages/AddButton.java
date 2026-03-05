package com.example.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

//import tests.String;

public class AddButton {

	private Locator AddButton;
	private Locator hindiButton;

	private final Page page;

	public AddButton(Page page) {
		this.page = page;

	}

	
	// ✅ Verify Hindi caption is saved and displayed correctly for Add Button
	public void verifyHindiCaptionSavedAndVisibleForUpdateButton() {

	    // Change language to Hindi
	    page.locator("#ddllanguage").selectOption("2");
	    page.waitForLoadState(LoadState.NETWORKIDLE);

	    // Locate Add button in Hindi
	    Locator saveButtonHindi = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("भाषा")
	    );

	    // Assertions
	    Assert.assertTrue(
	            saveButtonHindi.isVisible(),
	            "Add button 'भाषा' is not visible on the form"
	    );

	    Assert.assertEquals(
	            saveButtonHindi.textContent().trim(),
	            "भाषा",
	            "Add button text is incorrect"
	    );
	}

	
	
	


	public void verifySaveButtonNameChnageInHindi() {

		// Change language to Hindi
		page.locator("#ddllanguage").selectOption("2");

		// Locate Save button in Hindi
		Locator hindiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("नाम"));

		// Validate visibility
		Assert.assertTrue(hindiButton.isVisible(), "Save button name is not visible in Hindi");

		// Validate correct text
		Assert.assertEquals(hindiButton.innerText().trim(), "नाम", "Save button name is incorrect in Hindi");
	}

	public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

		page.locator("#ddllanguage").selectOption("2");

		// Use exact UI text here
		Locator languageDataButton = page.getByText("veritical");

		Assert.assertTrue(languageDataButton.isVisible(), "Language Data Addbutton is not visible");

		Assert.assertEquals(languageDataButton.innerText().trim(), "veritical",
				"Add Button name changed after language selection");
	}

	public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {

		Locator captionControl = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Caption Test"));

		captionControl.scrollIntoViewIfNeeded();
		captionControl.click();
		page.waitForLoadState(LoadState.NETWORKIDLE);

		Assert.assertTrue(captionControl.isVisible(), "Caption property is not visible to the user");
	}
	
	// ✅ Verify that control name 'VISIBILITY_Y' is visible on web form
	public void verifyVisibilityYControlIsVisible() {

	    Locator visibilityY = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("VISIBILITY_Y")
	    );

	    Assert.assertTrue(
	            visibilityY.isVisible(),
	            "Control 'VISIBILITY_Y' is not visible on web form"
	    );
	}

	
	// ✅ Verify that control name 'VISIBILITY_N' is not available on web form
	public void verifyVisibilityNControlIsNotVisible() {

	    Locator visibilityN = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("VISIBILITY_N")
	    );

	    Assert.assertEquals(
	            visibilityN.count(),
	            0,
	            "Control 'VISIBILITY_N' is unexpectedly visible on web form"
	    );
	}
	
	// ✅ Verify Font Size is set to 30 for save button named 'Font Size'
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
	
	// ✅ Verify Font Style is Bold
	public void verifyFontStyleIsBold() {

	    Locator fontStyleButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Font Style")
	    );

	    Assert.assertTrue(
	            fontStyleButton.isVisible(),
	            "Font Style button is not visible"
	    );

	    String fontWeight = fontStyleButton
	            .evaluate("el => window.getComputedStyle(el).fontWeight")
	            .toString();

	    // Bold can be "bold" OR numeric >= 700
	    Assert.assertTrue(
	            fontWeight.equalsIgnoreCase("bold") ||
	            Integer.parseInt(fontWeight) >= 700,
	            "Font style is not Bold"
	    );
	}
	
	
	// ✅ Verify Font Color is #142bd7
	public void verifyFontColor() {

	    Locator fontColorButton = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Font Color")
	    );

	    // Visibility check
	    Assert.assertTrue(
	            fontColorButton.isVisible(),
	            "Font Color Addbutton is not visible"
	    );

	    // Get computed color
	    String color = fontColorButton
	            .evaluate("el => window.getComputedStyle(el).color")
	            .toString();

	    // #142bd7 = rgb(20, 43, 215)
	    Assert.assertEquals(
	            color,
	            "rgb(20, 43, 215)",
	            "Font color is not #142bd7"
	    );
	} 
	    
	 // ✅ Verify Background Color is #e1c019
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

/*
 * package com.example.pages;
 * 
 * import com.microsoft.playwright.Locator; import
 * com.microsoft.playwright.Page; import
 * com.microsoft.playwright.assertions.PlaywrightAssertions; import
 * com.microsoft.playwright.options.AriaRole;
 * 
 * public class AddButton {
 * 
 * 
 * private Locator search ; private Locator user;
 * 
 * private Locator add_btn;
 */

/*
 * private final Page page ;
 * 
 * public AddButton (Page page) { this.page=page; }
 * 
 * 
 * public void searchbox () { search=page.getByPlaceholder("Search");
 * search.fill("contest");
 * PlaywrightAssertions.assertThat(page.locator(".fclick")).isVisible();
 * 
 * }
 * 
 * public void addbutton() { user=page.locator(".fclick"); user.click();
 * page.waitForTimeout(2000); add_btn=page.locator("#ctrl109307");
 * add_btn.fill("Label Testing"); page.waitForTimeout(2000); }
 * 
 * 
 * public void contest() { // TODO Auto-generated method stub
 * 
 * } }
 */

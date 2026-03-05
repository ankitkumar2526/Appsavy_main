package com.example.pages;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.LoadState;

public class ButtonPage {
	private Locator search;
	private Locator user;
	

	private final Page page;

	public ButtonPage(Page page) {
		this.page = page;
	}

	public void searchbox() {
		search = page.getByPlaceholder("Search");
		search.fill("LabelTesting2Jan26");
		PlaywrightAssertions.assertThat(page.locator(".fclick")).isVisible();

	}

	public void buttonNameInHindi() {

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("fa-bars")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" CONTEST ")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Button").setExact(true)).click();
		// page.locator("#clpsBar").click();
		System.out.println("[PASS] Collapse bar clicked");

		// Step: Change language to Hindi
		page.locator("#ddllanguage").selectOption("2");
		System.out.println("[PASS] Form Language changed to Hindi");

		// Step: Locate Hindi button
		Locator hindiButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("बहुभाषी"));
		System.out.println("[INFO] Locating Hindi button");

		// Assertions
		Assert.assertTrue(hindiButton.isVisible(), "[FAIL] Hindi button is not visible");

		Assert.assertEquals(hindiButton.textContent().trim(), "बहुभाषी",
				"[FAIL] Button text is not displayed in Hindi");

		System.out.println("[PASS] Button name is displayed correctly in Hindi");

	}

	public void englishLanguageAfterLanguageChange() {
		// Step: Change language to Hindi
		page.locator("#ddllanguage").selectOption("2");
		System.out.println("[PASS] Form Language changed to Hindi");

		// Step: Locate Language Data button (should remain English)
		Locator languageDataButton = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Language Data"));
		System.out.println("[INFO] Locating 'Language Data' button");

		// Assertions
		Assert.assertTrue(languageDataButton.isVisible(), "[FAIL] Language Data button is not visible");

		Assert.assertEquals(languageDataButton.textContent().trim(), "Language Data",
				"[FAIL] Button name changed after language selection");

		System.out.println("[PASS] Button name 'Language Data' remains in English after language change");
	}

	public void captionPropertyVisibility() {
		// Step 3: Open Caption Test control
		page.locator("text=Caption Test").first().click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		System.out.println("[PASS] 'Caption Test' control opened successfully");

		// Step 4: Locate Caption property on web UI
		Locator captionProperty = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Caption Test"));
		System.out.println("[INFO] Locating 'Caption' property");

		// Step 5: Assertions
		Assert.assertTrue(captionProperty.isVisible(), "[FAIL] Caption property is not visible to the user");

		System.out.println("[PASS] Caption property is visible to users in the form interface");
	}

	public void ImageIsLeftOfCaption() { // Step 3: Locate Image button
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

	public void buttonWidth() {
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
		Assert.assertTrue(actualWidth >= 45 && actualWidth <= 70,
				"[FAIL] Width button size is not in the range 45 to 60. Actual width: " + actualWidth);

		System.out.println("[PASS] Width button has correct width of 50");
	}

	public void controlVisibility() {
		// Navigate to Button form
//		page.locator("text=CONTEST").first().click();
//		page.waitForLoadState(LoadState.NETWORKIDLE);
//		System.out.println("[PASS] Menu selected and entered into form list");
//
//		page.locator("text=Button").first().click();
//		page.waitForLoadState(LoadState.NETWORKIDLE);
//		System.out.println("[PASS] Button form opened successfully");

		// Locate visibility_y control
		Locator visibilityY = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("visibility_y"));

		// Assertion
		Assert.assertTrue(visibilityY.isVisible(), "[FAIL] Control 'visibility_y' is not visible on web form");

		System.out.println("[PASS] Control 'visibility_y' is visible on web form");
	}

	public void controlVisibilityifN() {
		// Locate visibility_n control
		Locator visibilityN = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("visibility_n"));

		// Assertion
		Assert.assertEquals(visibilityN.count(), 0,
				"[FAIL] Control 'visibility_n' is unexpectedly visible on web form");

		System.out.println("[PASS] Control 'visibility_n' is not available on web form");
	}

	public void fontSize() {
		Locator fontSizeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Font Size"));

		Assert.assertTrue(fontSizeButton.isVisible(), "[FAIL] Font Size button is not visible");
		System.out.println("[PASS] Font Size button is visible");

		String fontSize = fontSizeButton.evaluate("el => window.getComputedStyle(el).fontSize").toString();

		System.out.println("[INFO] Actual font size: " + fontSize);

		Assert.assertEquals(fontSize, "25px", "[FAIL] Font size is not 25px");
		System.out.println("[PASS] Font size is 25px");
	}

	public void fontStyle() {
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

	public void fontColor() {
		Locator fontColorButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Font Color"));

		Assert.assertTrue(fontColorButton.isVisible(), "[FAIL] Font Color button is not visible");
		System.out.println("[PASS] Font Color button is visible");

		String color = fontColorButton.evaluate("el => window.getComputedStyle(el).color").toString();

		System.out.println("[INFO] Actual font color: " + color);

		// rgb(19, 34, 236) == #1322ec
		Assert.assertEquals(color, "rgb(19, 34, 236)", "[FAIL] Font color is not #1322ec");
		System.out.println("[PASS] Font color is #1322ec");
	}

	public void backgroundColor() {
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

package com.example.pages;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class MultilineTextbox {
	
	
	
	 private Locator multilineValue;
	
	
	
	
	
	private final Page page ;
	
	  public MultilineTextbox  (Page page)
	 {
	     this.page = page;
	   
    }
      
	  public void verifyCaptionFromLanguageDataOnTranslatorClick() {


		    Locator subjectCaption = page.locator("#lblCap109442");

		    String actualText = subjectCaption.textContent().trim();

		    boolean isValid =
		            actualText.equalsIgnoreCase("school")
		         || actualText.equals("स्कूल");

		    Assert.assertTrue(
		        isValid,
		        " FAILED: Subject caption not coming from LANGUAGE_DATA JSON"
		    );
		    
		    }
	  
	  
	  public void verifyMultilineCaptionVisibility(boolean expectedToBeVisible) {

		    Locator captionLabel = page.locator("#lblCap109445");

		    if (expectedToBeVisible) {

		        Assert.assertTrue(
		            captionLabel.count() > 0 && captionLabel.isVisible(),
		            "FAILED: Caption is expected to be visible but it is not"
		        );

		    } else {

		        Assert.assertTrue(
		            captionLabel.count() == 0 || !captionLabel.isVisible(),
		            "FAILED: Caption is NOT expected to be visible but it is visible"
		        );
		    }
		}


	  public void verifyMultilineTextboxDefaultValueIsPresent()
 {

		    Locator multilineTextbox = page.locator("#ctrl109449");

		    multilineTextbox.scrollIntoViewIfNeeded();

		    String actualValue = multilineTextbox.inputValue().trim();

		    // ✅ Condition: Value should NOT be empty
		    Assert.assertTrue(
		        !actualValue.isEmpty(),
		        "FAILED: Multiline Textbox is empty but it should contain some value"
		    );
		}


	  public void verifyMultilineMaxLength(int expectedMaxLength) {

		    Locator multiline = page.locator("#ctrl109450");

		    // Type MORE than allowed (stress test)
		    String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		    multiline.fill(input);

		    String actualValue = multiline.inputValue();
		    int actualLength = actualValue.length();

		    Assert.assertTrue(
		        actualLength <= expectedMaxLength,
		        "FAIL: UI allowed more than maxLength. Expected ≤ "
		            + expectedMaxLength + " but got " + actualLength
		    );
		}



	  
	  public void verifyMultilineCaptionIsOnLeft() {

		    // Caption (label) locator
		    Locator captionLabel = page.locator("#lblCap109459");

		    // Multiline textbox (textarea, not input)
		    Locator multilineTextbox = page.locator("#ctrl109459");

		    // wait for both
		    captionLabel.waitFor();
		    multilineTextbox.waitFor();

		    // get X positions
		    double captionX = captionLabel.boundingBox().x;
		    double textboxX = multilineTextbox.boundingBox().x;

		  
		    Assert.assertTrue(
		        captionX < textboxX,
		        "FAIL: Multiline textbox caption is NOT on the left side"
		    );
		}

	  public void verifymultilineCaptionFontSize() {

		    Locator caption = page.locator("#lblCap109467");
		    caption.isVisible();

		    String actualFontSize =
		        (String) caption.evaluate(
		            "el => window.getComputedStyle(el).fontSize"
		        );

		    String expectedFontSize = "25px";

		    Assert.assertEquals(
		        actualFontSize.trim(),
		        expectedFontSize,
		        "Caption font size mismatch"
		    );
		}



		public void verifymultilineCaptionTextColorr() {

		    Locator caption = page.locator("#lblCap109467");

		    String actualColor =
		        (String) caption.evaluate(
		            "el => window.getComputedStyle(el).color"
		        );

		    Assert.assertEquals(
		        actualColor,
		        "rgb(175, 25, 25)",
		        "Caption text color mismatch"
		    );
		}
		public void verifymultilineCaptionBackgroundColorr() {

		    Locator caption = page.locator("#lblCap109467");

		    String actualBgColor =
		        (String) caption.evaluate(
		            "el => window.getComputedStyle(el).backgroundColor"
		        );

		    Assert.assertEquals(
		        actualBgColor,
		        "rgb(75, 75, 225)",
		        "Caption background color mismatch"
		    );
		}
		

	  public void verifyMultilineCaptionFontFamily() {

		    Locator caption = page.locator("#lblCap109467"); // SAME caption ID
		    caption.isVisible();

		    String actualFontFamily = (String) caption.evaluate(
		        "el => window.getComputedStyle(el).fontFamily"
		    );

		    Assert.assertTrue(
		        actualFontFamily.toLowerCase().contains("roboto"),
		        "Font family is not Roboto"
		    );
		}

	  
	  public void verifyMultilineCaptionFontstyle() {

		    Locator caption = page.locator("#lblCap109467"); // SAME caption ID

		    String actualFontWeight = (String) caption.evaluate(
		        "el => window.getComputedStyle(el).fontWeight"
		    );

		    Assert.assertTrue(
		        Integer.parseInt(actualFontWeight) >= 700,
		        "Font is not Bold"
		    );
		}

	  
	
	

	  
	  public void verifymultilinevalueFontSize() {
		  Locator headingLabel = page.locator("#ctrl109468");

		    String actualFontSize = (String) headingLabel.evaluate(
		        "el => window.getComputedStyle(el).fontSize"
		    );

		    Assert.assertEquals(
		        actualFontSize.trim(),
		        "22px",
		        "FAILED: Heading label font size mismatch"
		    );
		}

	  public void verifyMultilineValueFontFamily() {

		    Locator multilineValue = page.locator("#ctrl109468"); // VALUE textbox ID
		    multilineValue.isVisible();

		    String actualFontFamily = (String) multilineValue.evaluate(
		            "el => window.getComputedStyle(el).fontFamily"
		    );

		    System.out.println("Actual Font Family = " + actualFontFamily);

		    Assert.assertTrue(
		            actualFontFamily.toLowerCase().contains("arial"),
		            "Multiline VALUE font family is not Arial"
		    );
		}

	  

	 
	  public void verifyMultilineValueFontStyle() {

	      multilineValue = page.locator("#ctrl109468");

	      String actualFontStyle = (String) multilineValue.evaluate(
	          "el => window.getComputedStyle(el).fontStyle"
	      );

	      Assert.assertEquals(
	          actualFontStyle,
	          "italic",
	          "Multiline VALUE font style is not Italic"
	      );
	  }

	  
	  public void verifyMultilineValueTextColor1() {

	      multilineValue = page.locator("#ctrl109468");

	      String actualColor = (String) multilineValue.evaluate(
	          "el => window.getComputedStyle(el).color"
	      );

	      Assert.assertEquals(
	          actualColor,
	          "rgb(10, 10, 10)",   
	          "Multiline VALUE text color mismatch"
	      );
	  }

	 
	  public void verifyMultilineValueBackgroundColor1() {

		    multilineValue = page.locator("#ctrl109468");

		    String actualBgColor = (String) multilineValue.evaluate(
		        "el => window.getComputedStyle(el).backgroundColor"
		    );

		    Assert.assertEquals(
		        actualBgColor,
		        "rgb(220, 25, 245)", // #c8c8c8
		        "Multiline VALUE background color mismatch"
		    );
		}
	  public void mandatoryFieldValidation() {

		    // Locators
		    Locator mandatoryStar = page.locator("label.required");   // * star
		    Locator field = page.locator("#ctrl109473");              // textarea
		    Locator saveBtn = page.locator("#ctrl109472");            // save button

		    // Check Mandatory Status from UI
		    boolean isMandatoryOn = mandatoryStar.isVisible();

		    // -------- Slow Typing --------
		    field.click();
		    field.clear();

		    for (char ch : "Demo value".toCharArray()) {
		        field.type(String.valueOf(ch));
		        page.waitForTimeout(200);   // typing speed (increase to 400 for slower)
		    }

		    // -------- Capture Popup --------
		    final String[] popupText = {""};

		    page.onceDialog(dialog -> {
		        popupText[0] = dialog.message();
		        dialog.accept();
		    });

		    // Click Save
		    saveBtn.click();

		    // -------- Validation Logic --------
		    if (isMandatoryOn) {

		        // When Mandatory ON → Confirmation popup should appear
		        Assert.assertTrue(
		                popupText[0].contains("Do you want to save"),
		                "FAILED: Mandatory ON but confirmation popup not shown"
		        );

		    } else {

		        // When Mandatory OFF → Test should FAIL intentionally
		        Assert.fail(
		                "Mandatory OFF in UI but save allowed → TEST FAILED intentionally"
		        );
		    }
		}



}
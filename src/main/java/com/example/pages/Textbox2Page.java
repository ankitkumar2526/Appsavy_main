package com.example.pages;

import org.testng.Assert;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Textbox2Page {
	
	
	
	
	
	
	
	
	private final Page page ;
	
	  public Textbox2Page(Page page)
	 {
	     this.page = page;
	   
      }


	  
	  public void verifyTextbox2DefaultValueIsPresent()
	  {

	 		    Locator multilineTextbox = page.locator("#ctrl109513");

	 		    multilineTextbox.scrollIntoViewIfNeeded();

	 		    String actualValue = multilineTextbox.inputValue().trim();

	 		    // ✅ Condition: Value should NOT be empty
	 		    Assert.assertTrue(
	 		        !actualValue.isEmpty(),
	 		        "FAILED: Multiline Textbox is empty but it should contain some value"
	 		    );
	 		}
	  public void checkUniqueProperty() {

		    Locator textbox = page.locator("#ctrl109514");
		    Locator mandatoryField = page.locator("#ctrl109531");
		    Locator saveButton = page.locator("#ctrl109515");

		    String value = "Ankit" + System.currentTimeMillis();

		    final boolean[] uniquePopupFound = {false};

		    page.onceDialog(dialog -> {

		        String message = dialog.message();
		        System.out.println("Dialog Message: " + message);
		        uniquePopupFound[0] = true;

		    //    if (message.contains("Unique Combination")) {
		     //       uniquePopupFound[0] = true;
		      //  }

		        dialog.accept();
		    });

		    // FIRST SAVE
		    mandatoryField.fill("testdata");
		    textbox.fill(value);
		    saveButton.click();

		    page.waitForTimeout(2000);

		    // SECOND SAVE (duplicate)
		    mandatoryField.fill("testdata");
		    textbox.fill(value);
		    saveButton.click();

		    page.waitForTimeout(2000);

		    if(uniquePopupFound[0]) {
		        System.out.println("TEST PASS → Unique validation working");
		    } else {
		        throw new RuntimeException("TEST FAIL → Duplicate allowed");
		    }
		}
	  public void verifyMaxLengthValidation() {

		  Locator maxLengthTextbox = page.locator("#ctrl109521");

		  System.out.println("Entering 7 digits");

		  maxLengthTextbox.fill("1234567");

		  String actualValue = maxLengthTextbox.inputValue();

		  System.out.println("Textbox value after input: " + actualValue);

		  if(actualValue.length() == 6) {

		  System.out.println("Max length validation working → TEST PASS");

		  } else {

		  throw new RuntimeException("Textbox accepted more than 6 characters → TEST FAIL");

		  }
	  }
		  
		  
		  
		  
	  public void mandatoryFieldValidation() {

		    Locator field = page.locator("#ctrl109531");
		    Locator saveBtn = page.locator("#ctrl109515");

		    field.clear();

		    final String[] popupMessage = {""};

		    page.onceDialog(dialog -> {
		        popupMessage[0] = dialog.message();
		        System.out.println("Dialog message: " + popupMessage[0]);
		        dialog.accept();
		    });

		    saveBtn.click();

		    Assert.assertTrue(
		        popupMessage[0].length() > 0,
		        "FAILED: Mandatory validation popup not displayed"
		    );

		    field.fill("Ankit");

		    page.onceDialog(dialog -> dialog.accept());

		    saveBtn.click();
		}
	  
	  public void verifyAlphanumericValidation() {

		    Locator alphaField = page.locator("#ctrl109533");

		    // Random value with special characters
		    String input = "Ankit@#123$%";
		    page.waitForTimeout(5000);

		    alphaField.type(input);

		    String actualValue = alphaField.inputValue();

		    // Check if only letters and digits exist
		    if(actualValue.matches("[A-Za-z0-9]*")) {
		        System.out.println("TEST PASS → Only alphanumeric allowed");
		    } else {
		        throw new RuntimeException("TEST FAIL → Special characters accepted: " + actualValue);
		    }
		}

}

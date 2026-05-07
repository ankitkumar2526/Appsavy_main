package com.example.pages;


import java.nio.file.Paths;

import org.testng.Assert; 
  import com.microsoft.playwright.Locator;
  import com.microsoft.playwright.Page;
  import com.microsoft.playwright.options.WaitForSelectorState;

public class ActiveInactivePage {
	
	
	
	 private final Page page ;
	  
	  public ActiveInactivePage(Page page)
	  
	  { 
		  this.page = page; 
		  }
	  

	  public void verifyActiveTextboxOnTextChange(String inputText) {

		    // INPUT BOX (left side - trigger)
		    Locator inputBox = page.locator("#ctrl109697");

		    // OUTPUT BOX (right side - result)
		    Locator outputBox = page.locator("#ctrl109698");

		    // STEP 1: Verify output box is initially disabled
		    Assert.assertTrue(outputBox.isDisabled(),
		            "FAILED: Output box should be disabled initially");

		    // STEP 2: Enter text in input box
		    inputBox.fill(inputText);

		    // STEP 3: Click outside to trigger event
		    page.locator("body").click();

		    // STEP 4: Wait for output box to become enabled
		    page.waitForTimeout(1000); // small wait for UI update

		    // STEP 5: Verify output box is enabled
		    Assert.assertFalse(outputBox.isDisabled(),
		            "FAILED: Output box is still disabled after text change");

		    System.out.println("PASS: Output box activated after text change");
		} 
	  
	  
	  public void verifyInactiveOnTextChange(String inputText) {

		    // Trigger textbox (LEFT)
		    Locator triggerTextBox = page.locator("#ctrl109696");

		    // Affected textbox (RIGHT - should become inactive)
		    Locator affectedTextBox = page.locator("#ctrl109699");

		    // STEP 1 → Type in trigger textbox
		    triggerTextBox.fill(inputText);

		    // STEP 2 → Click outside (event trigger)
		    page.locator("body").click();

		    // STEP 3 → Wait for UI update
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify affected textbox is disabled
		    boolean isDisabled = affectedTextBox.isDisabled();

		    Assert.assertTrue(isDisabled,
		        "FAILED: Affected textbox is still active after text change");

		    System.out.println("PASS: Affected textbox became inactive after text change");
		}
	  
	  
	  public void verifyActiveOnCheckbox() {

		    // Trigger checkbox (LEFT)
		    Locator triggerCheckbox = page.locator("#ctrl109701");

		    // Affected textbox (RIGHT - should become active)
		    Locator affectedTextBox = page.locator("#ctrl109702");

		    // STEP 1 → Click checkbox
		    triggerCheckbox.check();

		    // STEP 2 → Wait for UI update
		    page.waitForTimeout(1000);

		    // STEP 3 → Verify textbox is enabled (active)
		    boolean isEnabled = affectedTextBox.isEnabled();

		    Assert.assertTrue(isEnabled,
		        "FAILED: Affected textbox is still inactive after checkbox click");

		    System.out.println("PASS: Affected textbox became active after checkbox click");
		}
	  public void verifyInactiveOnCheckbox() {

		    // Trigger checkbox (LEFT)
		    Locator triggerCheckbox = page.locator("#ctrl109700");

		    // Affected textbox (RIGHT)
		    Locator affectedTextBox = page.locator("#ctrl109703");

		    // STEP 1 → Verify initially active
		    Assert.assertTrue(affectedTextBox.isEnabled(),
		        "FAILED: Textbox should be active initially");

		    // STEP 2 → Click checkbox
		    triggerCheckbox.check();

		    // STEP 3 → Wait
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify becomes inactive
		    Assert.assertTrue(affectedTextBox.isDisabled(),
		        "FAILED: Textbox did not become inactive after checkbox click");

		    System.out.println("PASS: Textbox became inactive after checkbox click");
		}
	  
	  
	  public void verifyActiveOnButtonClick() {

		    // LEFT → Trigger button
		    Locator activeButton = page.locator("#btncap109705");

		    // RIGHT → Affected textbox (initially disabled)
		    Locator affectedTextbox = page.locator("#ctrl109706");

		    // STEP 1 → Verify initially disabled
		    Assert.assertTrue(affectedTextbox.isDisabled(),
		            "FAILED: Textbox should be disabled initially");

		    // STEP 2 → Click button
		    activeButton.click();

		    // STEP 3 → Wait
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify becomes active
		    Assert.assertTrue(affectedTextbox.isEnabled(),
		            "FAILED: Textbox did not become active after button click");

		    System.out.println("PASS: Textbox became active after button click");
		}
	  
	  public void verifyInactiveOnButtonClick() {

		    // LEFT → Trigger button
		    Locator inactiveButton = page.locator("#btncap109704");

		    // RIGHT → Affected textbox (initially active)
		    Locator affectedTextbox = page.locator("#ctrl109707");

		    // STEP 1 → Verify initially active
		    Assert.assertTrue(affectedTextbox.isEnabled(),
		            "FAILED: Textbox should be active initially");

		    // STEP 2 → Click button
		    inactiveButton.click();

		    // STEP 3 → Wait
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify becomes inactive
		    Assert.assertTrue(affectedTextbox.isDisabled(),
		            "FAILED: Textbox did not become inactive after button click");

		    System.out.println("PASS: Textbox became inactive after button click");
		}
	  
	  
	  public void verifyTextboxBecomesActive_OnRadioNoSelection() {

		    // LEFT → Radio "No" (Trigger)
		    Locator radioNo = page.locator("#radio1_109714");

		    // RIGHT → Affected Textbox
		    Locator affectedTextbox = page.locator("#ctrl109713");

		    // STEP 1 → Verify initially inactive
		    Assert.assertTrue(affectedTextbox.isDisabled(),
		            "FAILED: Textbox should be inactive (disabled) initially");

		    // STEP 2 → Select radio "No"
		    radioNo.check();

		    // STEP 3 → Wait
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify becomes active
		    Assert.assertTrue(affectedTextbox.isEnabled(),
		            "FAILED: Textbox did not become active after selecting radio 'No'");

		    System.out.println("PASS: Textbox became active after selecting radio 'No'");
		}
	  
	  
	  
	  public void verifyTextboxBecomesInactive_OnInactiveRadioNo() {

		    // LEFT → Radio "No"
		    Locator radioNo = page.locator("#radio1_109711");

		    // RIGHT → Affected textbox
		    Locator affectedTextbox = page.locator("#ctrl109712");

		    // STEP 1 → Verify initially ACTIVE
		    Assert.assertTrue(affectedTextbox.isEnabled(),
		            "FAILED: Textbox should be active initially");

		    // STEP 2 → Click "No"
		    radioNo.check();

		    // STEP 3 → Wait for UI update
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify becomes INACTIVE
		    Assert.assertTrue(affectedTextbox.isDisabled(),
		            "FAILED: Textbox did not become inactive after selecting 'No'");

		    System.out.println("PASS: Textbox became inactive after selecting 'No'");
		}
	  
	  
	  
	  
	  public void verifyTextboxBecomesActive_OnLabelClick() {

		    // Parent label (LOCAL locator)
		    Locator label = page.locator("#ctrl109715");

		    // RIGHT textbox
		    Locator textbox = page.locator("#ctrl109716");

		    // STEP 1 → Initially inactive
		    Assert.assertTrue(textbox.isDisabled(),
		            "FAILED: Textbox should be inactive initially");

		    // STEP 2 → Click on "No" (inside label)
		    label.click();
		    // 👉 right side pe click karega (No part)

		    // STEP 3 → Wait
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify active
		    Assert.assertTrue(textbox.isEnabled(),
		            "FAILED: Textbox did not become active after label click");

		    System.out.println("PASS: Textbox became active after label click");
		}
	  
	  
	  
	  public void verifyInactiveTextbox_OnLabelClick() {

		    // LEFT label (LOCAL locator)
		    Locator inactiveLabel = page.locator("#ctrl109718");

		    // RIGHT textbox
		    Locator textbox = page.locator("#ctrl109717");

		    // STEP 1 → Initially active hona chahiye
		    Assert.assertTrue(textbox.isEnabled(),
		            "FAILED: Textbox should be active initially");

		    // STEP 2 → Label pe click (value1/value2 area)
		    inactiveLabel.click();

		    // STEP 3 → Wait for event trigger
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify textbox inactive ho gaya
		    Assert.assertTrue(textbox.isDisabled(),
		            "FAILED: Textbox did not become inactive after label click");

		    System.out.println("PASS: Textbox became inactive after label click");
		}
	  
	  
	  public void verifyTextboxBecomesActive_OnGraphClick() {

		    // LEFT → Graph item (Female)
		    Locator femaleGraph = page.locator("#btn_109730_1_Female");

		    // RIGHT → Affected textbox
		    Locator affectedTextbox = page.locator("#ctrl109735");

		    // STEP 1 → Verify initially INACTIVE
		    Assert.assertTrue(affectedTextbox.isDisabled(),
		            "FAILED: Textbox should be inactive initially");

		    // STEP 2 → Click on graph (Female)
		    femaleGraph.click();

		    // STEP 3 → Wait for UI update
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify becomes ACTIVE
		    Assert.assertTrue(affectedTextbox.isEnabled(),
		            "FAILED: Textbox did not become active after graph click");

		    System.out.println("PASS: Textbox became active after graph click");
		}
	  
	  
	  public void verifyTextboxBecomesInactive_OnGraphClick() {

		    // LEFT → Graph item (Female)
		    Locator femaleGraph = page.locator("#btn_109736_1_Female");

		    // RIGHT → Affected textbox
		    Locator affectedTextbox = page.locator("#ctrl109725");

		    // STEP 1 → Verify initially ACTIVE
		    Assert.assertTrue(affectedTextbox.isEnabled(),
		            "FAILED: Textbox should be active initially");

		    // STEP 2 → Click on graph (Female)
		    femaleGraph.click();

		    // STEP 3 → Wait for UI update
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify becomes INACTIVE
		    Assert.assertTrue(affectedTextbox.isDisabled(),
		            "FAILED: Textbox did not become inactive after graph click");

		    System.out.println("PASS: Textbox became inactive after graph click");
		}
	  
	  
	  public void verifyTextboxBecomesActive_OnIndexChange() {

		    // LEFT dropdown (index change)
		    Locator dropdown = page.locator("#ctrl109734");

		    // RIGHT textbox
		    Locator textbox = page.locator("#ctrl109733");

		    // STEP 1 → Initially textbox inactive hona chahiye
		    Assert.assertTrue(textbox.isDisabled(),
		            "FAILED: Textbox should be inactive initially");

		    // STEP 2 → Change index (select value "2")
		    dropdown.selectOption("2");

		    // STEP 3 → Wait for event trigger
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify textbox becomes active
		    Assert.assertTrue(textbox.isEnabled(),
		            "FAILED: Textbox did not become active after index change");

		    System.out.println("PASS: Textbox became active after index change");
		}
	  
	  public void verifyTextboxBecomesInactive_OnIndexChange() {

		    // LEFT dropdown (InactiveOnIndexChange)
		    Locator dropdown = page.locator("#ctrl109728");

		    // RIGHT textbox
		    Locator textbox = page.locator("#ctrl109732");

		    // STEP 1 → Initially textbox ACTIVE hona chahiye
		    Assert.assertTrue(textbox.isEnabled(),
		            "FAILED: Textbox should be active initially");

		    // STEP 2 → Change index (3 → 4)
		    dropdown.selectOption("4");

		    // STEP 3 → Wait for event trigger
		    page.waitForTimeout(1000);

		    // STEP 4 → Verify textbox becomes INACTIVE
		    Assert.assertTrue(textbox.isDisabled(),
		            "FAILED: Textbox did not become inactive after index change");

		    System.out.println("PASS: Textbox became inactive after index change");
		}
	  
	  public void verifyTextboxBecomesActive_OnGridTextChange() {

		    // LEFT → Grid textbox (ANKIT)
		    Locator gridTextbox = page.locator("#ctrl24228_1");  // correct from your screenshot

		    // RIGHT → Textbox
		    Locator rightTextbox = page.locator("#ctrl109739");

		    // STEP 1 → Verify initially DISABLED
		    Assert.assertTrue(rightTextbox.isDisabled(),
		            "FAILED: Right textbox should be inactive initially");

		    // STEP 2 → Change value in grid
		    gridTextbox.fill("abc");

		    // STEP 3 → Click outside (IMPORTANT)
		    page.locator("body").click();

		    // STEP 4 → Wait for event trigger
		    page.waitForTimeout(1000);

		    // STEP 5 → Verify becomes ACTIVE
		    Assert.assertTrue(rightTextbox.isEnabled(),
		            "FAILED: Right textbox did not become active after grid text change");

		    System.out.println("PASS: Textbox became active after grid text change");
		}
	  public void verifyTextboxBecomesInactive_OnGridTextChange() {

		    // LEFT → Grid textbox (InactiveOnGridText section)
		    Locator gridTextbox = page.locator("#ctrl24226_1");

		    // RIGHT → Affected textbox
		    Locator rightTextbox = page.locator("#ctrl109740");

		    // STEP 1 → Verify initially ACTIVE
		    Assert.assertTrue(rightTextbox.isEnabled(),
		            "FAILED: Right textbox should be active initially");

		    // STEP 2 → Change value in grid textbox
		    gridTextbox.fill("xyz");

		    // STEP 3 → Click outside to trigger event
		    page.locator("body").click();

		    // STEP 4 → Wait for UI update
		    page.waitForTimeout(1000);

		    // STEP 5 → Verify textbox becomes INACTIVE
		    Assert.assertTrue(rightTextbox.isDisabled(),
		            "FAILED: Right textbox did not become inactive after grid text change");

		    System.out.println("PASS: Right textbox became inactive after grid text change");
		}
	  public void verifyTextboxBecomesActive_OnFileUpload() {

		    Locator rightTextbox = page.locator("#ctrl109753");

		    // ✅ Correct locator (Active capture)
		    Locator fileInput = page.locator("#ctrl109750");

		    // STEP 1 → initially disabled
		    Assert.assertTrue(rightTextbox.isDisabled(),
		            "FAILED: Textbox should be inactive initially");

		    // STEP 2 → upload file
		    fileInput.setInputFiles(Paths.get(
		        "C:/Users/DELL/OneDrive - Mobineers Info Systems Pvt Ltd/Desktop/Screenshot 2025-12-04 160411.png"
		    ));

		    page.waitForTimeout(1000);

		    // STEP 3 → verify active
		    Assert.assertTrue(rightTextbox.isEnabled(),
		            "FAILED: Textbox did not become active after file upload");

		    System.out.println("PASS: Textbox became active after file upload");
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}


  package com.example.pages;
  
  
  
  
  import java.nio.file.Paths;

import org.testng.Assert; 
  import com.microsoft.playwright.Locator;
  import com.microsoft.playwright.Page;
  import com.microsoft.playwright.options.WaitForSelectorState;
  
  public class ShowHidePage {
  
  
  
  
  
  
  
  private final Page page ;
  
  public ShowHidePage(Page page)
  
  { 
	  this.page = page; 
	  }
  
  
  public void verifyShowLabelOnTyping(String inputText) {

	    Locator showTextBox = page.locator("#ctrl109616");
	    Locator showLabel = page.locator("#lblCap109614");

	    // STEP 0 → Ensure label is hidden initially
	    Assert.assertFalse(showLabel.isVisible(),
	            "FAILED: Show label is already visible before typing");

	    // STEP 1 → Type text
	    showTextBox.fill(inputText);

	    // STEP 2 → Click outside
	    page.locator("body").click();

	    // STEP 3 → Wait for label
	    showLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    // STEP 4 → Verify
	    Assert.assertTrue(showLabel.isVisible(),
	            "FAILED: Show label is not visible after typing");

	    System.out.println("PASS: Show label is visible after typing");
	}
  
  
  public void verifyHideLabelOnTyping(String inputText) {

	    Locator hideTextBox = page.locator("#ctrl109619");   // your textbox
	    Locator hideLabel = page.locator("#lblCap109615");   // your hide label

	    // STEP 1 → Verify label is initially visible
	    Assert.assertTrue(hideLabel.isVisible(), 
	        "FAILED: Hide label is not visible initially");

	    // STEP 2 → Type text
	    hideTextBox.fill(inputText);

	    // STEP 3 → Click outside to trigger event
	    page.locator("body").click();

	    // STEP 4 → Wait for label to be hidden
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 5 → Verify label is hidden
	    boolean isHidden = !hideLabel.isVisible();

	    Assert.assertTrue(isHidden, 
	        "FAILED: Hide label is still visible after typing");

	    System.out.println("PASS: Hide label is hidden after typing");
	}
  
  
  public void verifyShowLabelOnCheckboxSelect() {

	    Locator checkbox = page.locator("#ctrl109617");     // checkbox
	    Locator label = page.locator("#lblCap109613");      // show label

	    // STEP 1 → Verify label is initially hidden
	    Assert.assertFalse(label.isVisible(), 
	        "FAILED: Label is visible before checkbox selection");

	    // STEP 2 → Select checkbox
	    checkbox.check();

	    // STEP 3 → Wait for label to appear
	    label.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    // STEP 4 → Verify label is visible
	    Assert.assertTrue(label.isVisible(), 
	        "FAILED: Label is not visible after checkbox selection");

	    System.out.println("PASS: Label is visible after checkbox selection");
	}
  
  
  
  public void verifyHideLabelOnCheckboxSelect() {

	    Locator checkbox = page.locator("#ctrl109618");     // checkbox
	    Locator label = page.locator("#lblCap109612");      // hide label

	    // STEP 1 → Verify label is initially visible
	    Assert.assertTrue(label.isVisible(), 
	        "FAILED: Hide label is not visible before checkbox selection");

	    // STEP 2 → Select checkbox
	    checkbox.check();

	    // STEP 3 → Wait for label to be hidden
	    label.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 4 → Verify label is hidden
	    Assert.assertFalse(label.isVisible(), 
	        "FAILED: Hide label is still visible after checkbox selection");

	    System.out.println("PASS: Hide label is hidden after checkbox selection");
	}
  
  
  public void verifyShowLabelOnButtonClick() {

	    Locator showButton = page.locator("#ctrl109627");     // ShowOnButton
	    Locator showLabel = page.locator("#lblCap109623");    // ShowLabelOnClickButton

	    // STEP 1 → Verify label is NOT visible initially
	    showLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.ATTACHED));

	    Assert.assertFalse(showLabel.isVisible(),
	            "FAILED: Label is visible before clicking Show button");

	    // STEP 2 → Click on Show button
	    showButton.click();

	    // STEP 3 → Wait for label to become visible
	    showLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    // STEP 4 → Verify label is visible
	    Assert.assertTrue(showLabel.isVisible(),
	            "FAILED: Label is not visible after clicking Show button");

	    System.out.println("PASS: Label is visible after clicking Show button");
	}
  
  
  public void verifyHideLabelOnButtonClick() {

	    Locator hideButton = page.locator("#ctrl109625");     // HideOnButton
	    Locator hideLabel = page.locator("#lblCap109622");    // HideLabelOnClickButton

	    // STEP 1 → Verify label is visible initially
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    Assert.assertTrue(hideLabel.isVisible(),
	            "FAILED: Label is not visible before clicking Hide button");

	    // STEP 2 → Click on Hide button
	    hideButton.click();

	    // STEP 3 → Wait for label to be hidden
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 4 → Verify label is hidden
	    Assert.assertFalse(hideLabel.isVisible(),
	            "FAILED: Label is still visible after clicking Hide button");

	    System.out.println("PASS: Label is hidden after clicking Hide button");
	}
  
  
  public void verifyShowLabelOnRadioButtonClick() {

	    Locator noRadio = page.locator("#radio1_109629");   // NO radio button
	    Locator showLabel = page.locator("#lblCap109624");  // Label to be shown

	    // STEP 1 → Verify label is NOT visible initially
	    Assert.assertFalse(showLabel.isVisible(),
	            "FAILED: Label is already visible before selecting radio button");

	    // STEP 2 → Click NO radio button
	    noRadio.check();

	    // STEP 3 → Wait for label to be visible
	    showLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    // STEP 4 → Verify label is visible
	    Assert.assertTrue(showLabel.isVisible(),
	            "FAILED: Label is not visible after selecting NO radio button");

	    System.out.println("PASS: Label is visible after selecting NO radio button");
	}
  
  
  public void verifyHideLabelOnRadioButtonClick() {

	    Locator noRadio = page.locator("#radio1_109626");   // NO radio button
	    Locator hideLabel = page.locator("#lblCap109628");  // Label to be hidden

	    // STEP 1 → Verify label is visible initially
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    Assert.assertTrue(hideLabel.isVisible(),
	            "FAILED: Label is not visible before selecting radio button");

	    // STEP 2 → Click NO radio button
	    noRadio.check();

	    // STEP 3 → Wait for label to be hidden
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 4 → Verify label is hidden
	    Assert.assertFalse(hideLabel.isVisible(),
	            "FAILED: Label is still visible after selecting NO radio button");

	    System.out.println("PASS: Label is hidden after selecting NO radio button");
	}
  
  public void verifyShowLabelOnLabelClick() {

	    Locator clickableLabel = page.locator("#ctrl109630");   // YES,NO label
	    Locator showLabel = page.locator("#lblCap109631");      // Label to be shown

	    // STEP 1 → Verify label is NOT visible initially
	    Assert.assertFalse(showLabel.isVisible(),
	            "FAILED: Label is already visible before clicking");

	    // STEP 2 → Click on label (YES,NO)
	    clickableLabel.click();

	    // STEP 3 → Wait for label to be visible
	    showLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    // STEP 4 → Verify label is visible
	    Assert.assertTrue(showLabel.isVisible(),
	            "FAILED: Label is not visible after clicking on label");

	    System.out.println("PASS: Label is visible after clicking on label");
	}
 
  
  public void verifyHideLabelOnLabelClick() {

	    Locator clickableLabel = page.locator("#ctrl109633");   // YES,NO label
	    Locator hideLabel = page.locator("#lblCap109632");      // Label to be hidden

	    // STEP 1 → Wait & verify label is visible initially
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    Assert.assertTrue(hideLabel.isVisible(),
	            "FAILED: Label is not visible before clicking");

	    // STEP 2 → Click on label
	    clickableLabel.click();

	    // STEP 3 → Wait for label to be hidden
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 4 → Verify label is hidden
	    Assert.assertFalse(hideLabel.isVisible(),
	            "FAILED: Label is still visible after clicking");

	    System.out.println("PASS: Label is hidden after clicking on label");
	}
  
  public void verifyShowLabelOnGraphClick() {

	    Locator graphFemale = page.locator("#btn_109647_1_Female");  // Graph item
	    Locator showLabel = page.locator("#lblCap109648");           // Label

	    // STEP 1 → Verify label is NOT visible initially
	    Assert.assertFalse(showLabel.isVisible(),
	            "FAILED: Label is already visible before graph click");

	    // STEP 2 → Click on graph (Female)
	    graphFemale.click();

	    // STEP 3 → Wait for label to be visible
	    showLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    // STEP 4 → Verify label is visible
	    Assert.assertTrue(showLabel.isVisible(),
	            "FAILED: Label is not visible after graph click");

	    System.out.println("PASS: Label is visible after clicking on graph");
	}
  
  public void verifyHideLabelOnGraphClick() {

	    Locator graphFemale = page.locator("#btn_109645_1_Female"); // Hide graph
	    Locator hideLabel = page.locator("#lblCap109646");          // Label

	    // STEP 1 → Wait & verify label is visible initially
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    Assert.assertTrue(hideLabel.isVisible(),
	            "FAILED: Label is not visible before graph click");

	    // STEP 2 → Click on graph (Female)
	    graphFemale.click();

	    // STEP 3 → Wait for label to be hidden
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 4 → Verify label is hidden
	    Assert.assertFalse(hideLabel.isVisible(),
	            "FAILED: Label is still visible after graph click");

	    System.out.println("PASS: Label is hidden after clicking on graph");
	}
  
 
  
  public void verifyShowLabelOnSelectIndexChange() {

	    Locator dropdown = page.locator("#ctrl109649");
	    Locator label = page.locator("#lblCap109651");

	    // STEP 1 → Initially label should be hidden
	    Assert.assertFalse(label.isVisible(),
	        "FAILED: Label should not be visible initially");

	    // STEP 2 → Change dropdown value (select index 2)
	    dropdown.selectOption("2");

	    // STEP 3 → Wait for label to appear
	    label.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    // STEP 4 → Verify label is visible
	    Assert.assertTrue(label.isVisible(),
	        "FAILED: Label is not visible after index change");

	    System.out.println("PASS: Label visible after dropdown index change");
	}
  
  
  public void verifyHideLabelOnSelectIndexChange() {

	    Locator dropdown = page.locator("#ctrl109650");
	    Locator label = page.locator("#lblCap109652");

	    // STEP 1 → Verify label is visible initially
	    label.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));

	    Assert.assertTrue(label.isVisible(),
	        "FAILED: Label should be visible initially");

	    // STEP 2 → Change dropdown value (2 → 3)
	    dropdown.selectOption("3");

	    // STEP 3 → Wait for label to hide
	    label.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 4 → Verify label is hidden
	    Assert.assertFalse(label.isVisible(),
	        "FAILED: Label is still visible after index change");

	    System.out.println("PASS: Label hidden after dropdown index change");
	    
	    page.waitForTimeout(5000);
	}
  
  
  public void verifyShowLabelAfterUpload(String filePath) {
	  
	    // ✅ ONLY SHOW SECTION
	    Locator section = page.locator("#divCtrl109634");
	 
	    Locator attachBtn = section.locator("#btnAttach109634");
	    Locator iconBar = page.locator("#divicons109634");
	    Locator label = page.locator("#lblCap109635");
	 
	    // STEP 1: Label hidden
	    Assert.assertFalse(label.isVisible(), "Label already visible ❌");
	 
	    // STEP 2: Click attach
	    attachBtn.click();
	    page.waitForTimeout(1000); // Wait for icon bar to appear
	 
	    // STEP 3: Wait icon bar
	    iconBar.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));
	 
	    // STEP 4: Click document icon
	    iconBar.locator("i.fa-picture-o")
	            .click(new Locator.ClickOptions().setForce(true));
	 
	    // 🔥 FINAL FIX HERE 🔥
	    // SPECIFIC FILE INPUT (SHOW SECTION ONLY)
	    Locator fileInput = page.locator("#ctrl109634");
	 
	    fileInput.setInputFiles(Paths.get(filePath));
	 
	    // STEP 5: Wait label
	    label.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE)
	            .setTimeout(15000));
	 
	    Assert.assertTrue(label.isVisible(), "Label not visible ❌");
	 
	    System.out.println("✅ PASS: Show label visible after upload");
	}
  public void verifyHideLabelAfterUpload(String filePath) {
	  
	    // ✅ ONLY HIDE SECTION (IMPORTANT)
	    Locator section = page.locator("#divCtrl109636");
	 
	    Locator attachBtn = section.locator("#btnAttach109636");
	    Locator iconBar = page.locator("#divicons109636");
	 
	    // 👉 RIGHT SIDE LABEL (already visible initially)
	    Locator label = page.locator("#lblCap109637");
	 
	    // STEP 1: Label should be visible before upload
	    Assert.assertTrue(label.isVisible(), "Label should be visible before upload ❌");
	 
	    // STEP 2: Click attach
	    attachBtn.click();
	 
	    // STEP 3: Wait icon menu
	    iconBar.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE));
	 
	    // STEP 4: Click document icon
	    iconBar.locator("i.fa-picture-o")
	            .click(new Locator.ClickOptions().setForce(true));
	 
	    // 🔥 IMPORTANT: correct input (HIDE section)
	    Locator fileInput = page.locator("#ctrl109636");
	 
	    fileInput.setInputFiles(Paths.get(filePath));
	 
	    // STEP 5: Wait for label to HIDE
	    label.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN)
	            .setTimeout(15000));
	 
	    // STEP 6: Assertion
	    Assert.assertFalse(label.isVisible(), "Label still visible ❌");
	 
	    System.out.println("✅ PASS: Label hidden after upload");
	}
  
  public void verifyShowLabelOnGridTextButtonClick(String inputText) {

	    // LEFT SIDE → Grid textbox
	    Locator gridTextbox = page.locator("#ctrl24219_1");  
	    // (id tu already inspect se le chuka hai)

	    // RIGHT SIDE → Label (jo show hona hai)
	    Locator showLabel = page.locator("#lblCap109691");  

	    // STEP 1: Ensure label initially hidden
	    Assert.assertFalse(showLabel.isVisible(), "Label already visible ❌");

	    // STEP 2: Type inside grid textbox
	    gridTextbox.fill(inputText);

	    // STEP 3: Click बाहर (IMPORTANT trigger)
	    page.locator("body").click();

	    // STEP 4: Wait for label to appear
	    showLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.VISIBLE)
	            .setTimeout(10000));

	    // STEP 5: Assertion
	    Assert.assertTrue(showLabel.isVisible(), "Label not visible after grid input ❌");

	    System.out.println("✅ PASS: Label visible after grid text input");
	}
  
  public void verifyHideLabelOnGridTextButtonClick() {

	    // LEFT SIDE GRID TEXTBOX (already filled with "Pass")
	    Locator gridTextbox = page.locator("#ctrl24223_1");

	    // RIGHT SIDE LABEL (jo hide hona chahiye)
	    Locator hideLabel = page.locator("#lblCap109690");

	    // STEP 1: Ensure label is visible initially
	    Assert.assertTrue(hideLabel.isVisible(), "Label should be visible initially");

	    // STEP 2: Click on textbox (edit mode)
	    gridTextbox.click();

	    // OPTIONAL → value change karna ho to
	    // gridTextbox.fill("Ankit");

	    // STEP 3: Click outside (important trigger)
	    page.locator("body").click();

	    // STEP 4: Wait for label to hide
	    hideLabel.waitFor(new Locator.WaitForOptions()
	            .setState(WaitForSelectorState.HIDDEN));

	    // STEP 5: Assertion
	    Assert.assertFalse(hideLabel.isVisible(), "Label is still visible (FAILED)");

	    System.out.println("PASS: Label hidden after grid text click");
	}
	 
  }
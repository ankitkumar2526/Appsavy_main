/*
 * package com.example.pages;
 * 
 * 
 * 
 * 
 * import org.testng.Assert; import com.microsoft.playwright.Locator; import
 * com.microsoft.playwright.Page; import
 * com.microsoft.playwright.options.WaitForSelectorState;
 * 
 * public class ShowHidePage {
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * private final Page page ;
 * 
 * public ShowHidePage(Page page) { this.page = page; }
 * 
 * 
 * 
 * public void verifyShowLabelOnTyping(String inputText) {
 * 
 * 
 * Locator showTextBox = page.locator("#ctrl109616"); // your textbox Locator
 * showLabel = page.locator("#lblCap109614"); // your label
 * 
 * // STEP 1 → Type text showTextBox.fill(inputText);
 * 
 * // STEP 2 → Click outside (important for triggering event)
 * page.locator("body").click();
 * 
 * // STEP 3 → Wait for label to appear showLabel.waitFor(new
 * Locator.WaitForOptions() .setState(WaitForSelectorState.VISIBLE));
 * 
 * // STEP 4 → Verify label is visible boolean isVisible =
 * showLabel.isVisible();
 * 
 * Assert.assertTrue(isVisible,
 * "FAILED: Show label is not visible after typing");
 * 
 * System.out.println("PASS: Show label is visible after typing"); }
 * 
 * 
 * public void verifyHideLabelOnTyping(String inputText) {
 * 
 * Locator hideTextBox = page.locator("#ctrl109619"); // your textbox Locator
 * hideLabel = page.locator("#lblCap109615"); // your hide label
 * 
 * // STEP 1 → Verify label is initially visible
 * Assert.assertTrue(hideLabel.isVisible(),
 * "FAILED: Hide label is not visible initially");
 * 
 * // STEP 2 → Type text hideTextBox.fill(inputText);
 * 
 * // STEP 3 → Click outside to trigger event page.locator("body").click();
 * page.waitForTimeout(10000); // 10 seconds
 * 
 * // STEP 4 → Wait for label to be hidden hideLabel.waitFor(new
 * Locator.WaitForOptions() .setState(WaitForSelectorState.HIDDEN));
 * 
 * // STEP 5 → Verify label is hidden boolean isHidden = !hideLabel.isVisible();
 * 
 * Assert.assertTrue(isHidden,
 * "FAILED: Hide label is still visible after typing");
 * 
 * System.out.println("PASS: Hide label is hidden after typing"); }
 * 
 * 
 * public void verifyShowLabelOnCheckboxSelect() {
 * 
 * Locator checkbox = page.locator("#ctrl109617"); // checkbox Locator label =
 * page.locator("#lblCap109613"); // show label
 * 
 * // STEP 1 → Verify label is initially hidden
 * Assert.assertFalse(label.isVisible(),
 * "FAILED: Label is visible before checkbox selection");
 * 
 * // STEP 2 → Select checkbox checkbox.check(); page.waitForTimeout(10000); //
 * 10 seconds
 * 
 * // STEP 3 → Wait for label to appear label.waitFor(new
 * Locator.WaitForOptions() .setState(WaitForSelectorState.VISIBLE));
 * 
 * // STEP 4 → Verify label is visible Assert.assertTrue(label.isVisible(),
 * "FAILED: Label is not visible after checkbox selection");
 * 
 * System.out.println("PASS: Label is visible after checkbox selection"); }
 * 
 * public void verifyHideLabelOnCheckboxSelect() {
 * 
 * Locator checkbox = page.locator("#ctrl109618"); // checkbox Locator label =
 * page.locator("#lblCap109612"); // hide label
 * 
 * // STEP 1 → Verify label is initially visible
 * Assert.assertTrue(label.isVisible(),
 * "FAILED: Hide label is not visible before checkbox selection");
 * 
 * // STEP 2 → Select checkbox checkbox.check(); page.waitForTimeout(10000); //
 * 10 seconds
 * 
 * // STEP 3 → Wait for label to be hidden label.waitFor(new
 * Locator.WaitForOptions() .setState(WaitForSelectorState.HIDDEN));
 * 
 * // STEP 4 → Verify label is hidden Assert.assertFalse(label.isVisible(),
 * "FAILED: Hide label is still visible after checkbox selection");
 * 
 * System.out.println("PASS: Hide label is hidden after checkbox selection"); }
 * 
 * }
 */
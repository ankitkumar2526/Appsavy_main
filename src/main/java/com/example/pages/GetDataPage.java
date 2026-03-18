package com.example.pages;

import org.testng.Assert;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class GetDataPage {
	
	
	
	
	
	
	
	
	
	
	
	
	private final Page page ;
	
	  public GetDataPage(Page page)
	 {
	     this.page = page;
	   
      }
	  
	  
	  
	  public void verifyGetDataTriggeredOnTyping(String name) {

		    Locator nameTextbox = page.locator("#ctrl109548");
		    Locator genderDropdown = page.locator("#ctrl109549");

		   
		    genderDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109549 option");
		    int beforeCount = optionsBefore.count();

		    
		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Gender dropdown already has values before typing in Name textbox");

		    System.out.println("PASS: Gender dropdown initially empty");

	
		    nameTextbox.type(name);
		    nameTextbox.press("Tab");

		  
		    genderDropdown.click();
		    page.waitForTimeout(3000);

		    Locator optionsAfter = page.locator("#ctrl109549 option");
		    int afterCount = optionsAfter.count();

		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Gender dropdown values did not load after typing in Name textbox");

		    System.out.println("PASS: Gender dropdown values loaded after typing in Name textbox");
		}
	  
	  
	  public void verifyGetDataTriggeredOnCheckboxChange() {

		    Locator getDataCheckbox = page.locator("#ctrl109556");
		    Locator subjectsDropdown = page.locator("#ctrl109557");

		  
		    subjectsDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109557 option");
		    int beforeCount = optionsBefore.count();

		   
		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Subjects dropdown already has values before clicking checkbox");

		    System.out.println("PASS: Subjects dropdown initially empty");

		    getDataCheckbox.click();

		  
		    subjectsDropdown.click();
		    page.waitForTimeout(1000);

		    Locator optionsAfter = page.locator("#ctrl109557 option");
		    int afterCount = optionsAfter.count();

		    
		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Subjects dropdown values did not load after clicking GetData checkbox");

		    System.out.println("PASS: Subjects dropdown values loaded after clicking GetData checkbox");
		}


	  public void verifyGetDataTriggeredOnButtonClickLoadsDaysDropdown() {

		   
		    Locator getDataButton = page.locator("#ctrl109558");
		    Locator daysDropdown = page.locator("#ctrl109559");

		 
		    daysDropdown.click();
 
		    Locator optionsBefore = page.locator("#ctrl109559 option");
		    int beforeCount = optionsBefore.count();

		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Days dropdown already has values before clicking GetData button");
		  
            System.out.println("PASS: Days dropdown initially empty");

		   
		    getDataButton.click();
            daysDropdown.click();
		    page.waitForTimeout(2000);
		   

		    Locator optionsAfter = page.locator("#ctrl109559 option");
		    int afterCount = optionsAfter.count();

		   
		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Days dropdown values did not load after clicking GetData button");

		    System.out.println("PASS: Days dropdown values loaded successfully after button click");
		}


	  
	  public void verifyGetDataTriggeredOnGridbuttonClickLoadsFestivalsDropdown() {

		    Locator gridSelectIcon = page.locator("span.fa.fa-hand-o-up");
		    Locator festivalsDropdown = page.locator("#ctrl109565");

		    // STEP 1 → Open dropdown before grid click
		    festivalsDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109565 option");
		    int beforeCount = optionsBefore.count();

		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Festivals dropdown already has values before grid click");

		    System.out.println("PASS: Festivals dropdown initially empty");

		    // STEP 2 → Click grid icon
		    gridSelectIcon.first().click();

		    // STEP 3 → Open dropdown again
		    festivalsDropdown.click();
		    page.waitForTimeout(2000);

		    Locator optionsAfter = page.locator("#ctrl109565 option");
		    int afterCount = optionsAfter.count();

		    // STEP 4 → Verify values loaded
		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Festivals dropdown values did not load after grid click");

		    System.out.println("PASS: Festivals dropdown values loaded after grid click");
		}
	  
	  
	  public void verifyGetDataTriggeredOnLabelClickLoadsFruitsDropdown() {

		    Locator fruitsDropdown = page.locator("#ctrl109568");
		    Locator appleLabel = page.locator("#ctrl109567");
		    appleLabel.scrollIntoViewIfNeeded();

		    // STEP 1 → Open dropdown before label click
		    fruitsDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109568 option");
		    int beforeCount = optionsBefore.count();

		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Fruits dropdown already has values before clicking APPLE label");

		    System.out.println("PASS: Fruits dropdown initially empty");

		    // STEP 2 → Click APPLE label
		    appleLabel.click();

		   
		    fruitsDropdown.click();
		    page.waitForTimeout(4000);

		    Locator optionsAfter = page.locator("#ctrl109568 option");
		    int afterCount = optionsAfter.count();

		    
		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Fruits dropdown values did not load after clicking APPLE label");

		    System.out.println("PASS: Fruits dropdown values loaded after clicking APPLE label");
		}
	  
	  
	  
	  
	  public void verifyGetDataTriggeredOnRadioButtonClickLoadsSpicesDropdown() {

		    Locator garlicRadioButton = page.locator("#radio1_109569");
		    Locator spicesDropdown = page.locator("#ctrl109570");

		   
		    spicesDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109570 option");
		    int beforeCount = optionsBefore.count();

		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Spices dropdown already has values before clicking radio button");

		    System.out.println("PASS: Spices dropdown initially empty");

		   
		    garlicRadioButton.click();

		   
		    spicesDropdown.click();
		    page.waitForTimeout(2000);

		    Locator optionsAfter = page.locator("#ctrl109570 option");
		    int afterCount = optionsAfter.count();

		    
		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Spices dropdown values did not load after clicking GARLIC radio button");

		    System.out.println("PASS: Spices dropdown values loaded after radio button click");
		}
	  
	  
	  public void verifyGetDataTriggeredOnSelectedIndexChangeLoadsGroupDropdown() {

		    Locator indexChangeDropdown = page.locator("#ctrl109575");
		    Locator groupDropdown = page.locator("#ctrl109577");

		    // STEP 1 → Check group dropdown before index change
		    groupDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109577 option");
		    int beforeCount = optionsBefore.count();

		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Group dropdown already has values before index change");

		    System.out.println("PASS: Group dropdown initially empty");

		    // STEP 2 → Change index
		    indexChangeDropdown.selectOption("2");

		    // STEP 3 → Open group dropdown again
		    groupDropdown.click();
		    page.waitForTimeout(2000);

		    Locator optionsAfter = page.locator("#ctrl109577 option");
		    int afterCount = optionsAfter.count();

		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Group dropdown values did not load after selected index change");

		    System.out.println("PASS: Group dropdown values loaded after selected index change");
		}
	  
	  
	  public void verifyGetDataTriggeredOnGraphClickLoadsResultDropdown() {

		    Locator graphBox = page.locator("#btn_109591_1_Male");
		    Locator resultDropdown = page.locator("#ctrl109592");

		    // STEP 1 → Open Result dropdown before graph click
		    resultDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109592 option");
		    int beforeCount = optionsBefore.count();

		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Result dropdown already has values before graph click");

		    System.out.println("PASS: Result dropdown initially empty");

		    // STEP 2 → Click on Graph box
		    graphBox.click();

		    // STEP 3 → Open Result dropdown again
		    resultDropdown.click();
		    page.waitForTimeout(2000);

		    Locator optionsAfter = page.locator("#ctrl109592 option");
		    int afterCount = optionsAfter.count();

		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Result dropdown values did not load after graph click");

		    System.out.println("PASS: Result dropdown values loaded after graph click");
		}
	  
	  
	  public void verifyGetDataTriggeredAfterDocumentUploadLoadsVegetablesDropdown() {

		    Locator vegetablesDropdown = page.locator("#ctrl109603");
		    Locator captureIcon = page.locator("#btnAttach109588");
		    Locator documentIcon = page.locator("i.fa-picture-o");
		    Locator fileInput = page.locator("input[type='file']");
		    

		    // STEP 1 → Open vegetables dropdown before upload
		    vegetablesDropdown.click();

		    Locator optionsBefore = page.locator("#ctrl109603 option");
		    int beforeCount = optionsBefore.count();

		    Assert.assertTrue(beforeCount <= 1,
		            "FAILED: Vegetables dropdown already has values before upload");

		    System.out.println("PASS: Vegetables dropdown initially empty");

		    // STEP 2 → Click capture button
		    captureIcon.click();

		    // STEP 3 → Click document option
		    documentIcon.click();

		    // STEP 4 → Upload file directly (no OS popup handling)
		    fileInput.setInputFiles(Paths.get("C:\\Users\\DELL\\Downloads/Ankit Kumar _CV_Manual and Automation Testing (2) (1) (1).pdf"));

		    page.waitForTimeout(3000);

		    // STEP 5 → Open dropdown again
		    vegetablesDropdown.click();

		    Locator optionsAfter = page.locator("#ctrl109603 option");
		    int afterCount = optionsAfter.count();

		    Assert.assertTrue(afterCount > 1,
		            "FAILED: Vegetables dropdown values did not load after file upload");

		    System.out.println("PASS: Vegetables dropdown values loaded after document upload");
		}
	  
	  
	  public void verifyGetDataTriggeredOnPageLoad() {

		    Locator countryDropdown = page.locator("#ctrl109604");

		    // wait for page load data
		    page.waitForTimeout(2000);

		    Locator options = page.locator("#ctrl109604 option");
		    int optionCount = options.count();

		    Assert.assertTrue(optionCount > 1,
		            "FAILED: Country dropdown values did not load on page load");

		    System.out.println("PASS: Country dropdown values loaded automatically on page load");
		}

}

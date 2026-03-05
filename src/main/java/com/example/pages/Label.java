package com.example.pages;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Label {
	
	
	private Locator search ;
	private Locator user;
	private Locator lbl_txt_box;	
	
	private final Page page ;
	
	public Label(Page page)
	{
		this.page=page;
	}
	
	
	 public void searchbox ()
	  {
		  search=page.getByPlaceholder("Search");
		  search.fill("LabelTesting2Jan26");
		  PlaywrightAssertions.assertThat(page.locator(".fclick")).isVisible();
		  
	  }
     
     public void label()
     {
		  user=page.locator(".fclick");//this is the ID when form name appears after searching for the form
		  user.click();
		  page.waitForTimeout(2000);
		  lbl_txt_box=page.locator("#ctrl109307");//ID for the control NAME onn the form LabelTesting2Jan26
		  lbl_txt_box.fill("Label Testing");//Providing the input for the control NAME inputbox
		  	page.waitForTimeout(2000);
		  }
     public String getCaptionText() {

    	    page.getByText("chkbox_9sep",
    	        new Page.GetByTextOptions().setExact(true));

    	    page.getByRole(AriaRole.TEXTBOX,
    	        new Page.GetByRoleOptions().setName("Search"))
    	        .fill("LabelTesting2Jan26");

    	    page.getByRole(AriaRole.LINK,
    	        new Page.GetByRoleOptions()
    	            .setName("LabelTesting2Jan26")
    	            .setExact(true))
    	        .click();

    	    Locator captionLabel = page.locator("#lblCap109310");

    	    captionLabel.waitFor();

    	    return captionLabel.textContent().trim();
    	}
//     public void verifyCaptionText(  Label label) {
//         String actualText = label.getCaptionText();
//         Assert.assertEquals(actualText, "Label3",
//                 "Caption text does not match!");
//		}
     
     public void LabelFormIsOpenned() {
    	 String pageTitle = page.title();
         System.out.println("Page Title is: " + pageTitle);
         Assert.assertEquals(pageTitle, "LabelTesting2Jan26", "Page title does not match!");
       
     }
     public void CaptionVisibility() {
    	 page.getByText("chkbox_9sep", new Page.GetByTextOptions().setExact(true));

//       System.out.println("Scrolled to chkbox_9sep form...");
       page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("LabelTesting2Jan26");
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true)).click();

       Locator captionLabel = page.locator("#lblCap109310");//caption chkbox2 
       captionLabel.waitFor(); // Ensure the element is present in the DOM
       String captionsTxt = captionLabel.textContent(); // Get the text content of the label
       Assert.assertEquals(captionsTxt, "Label3", "Caption text does not match!");
      	 
     }
     public void mandatoryField() {

         Locator textbox = page.locator("#ctrl109308");

         // Scroll to element
         textbox.scrollIntoViewIfNeeded();

         // Ensure textbox is blank
         textbox.fill("");  // Make sure it is empty
         String value = textbox.inputValue();
         Assert.assertEquals(value, "", "Textbox is not blank!");

         // Handle alert before clicking Save
         page.onceDialog(dialog -> {
             String alertMessage = dialog.message();
             System.out.println("Alert Message: " + alertMessage);

             // Validate alert message
             Assert.assertEquals(alertMessage, "Please Enter Address",
                     "Alert message does not match!");

             dialog.accept();  // Click OK
         });

         // Click Save button
         page.click("#ctrl109306");
       
     }
     public void Tranlsator() {
        	page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Search"))
            .fill("LabelTesting2Jan26");

        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true))
            .click();

        page.locator("#ddllanguage").selectOption("2"); // translator icon

        // ✅ Use UNIQUE locator instead of getByText
        Locator el = page.locator("#lblCap109310");

        String actualText = el.textContent().trim();
        String expectedText = "लेबल3";

        Assert.assertEquals(actualText, expectedText,
                "❌ Text match nahi hua");

        System.out.println("✅ Text successfully verified: " + actualText);
        }
     public void unniqueControl() {

     	Locator labels = page.locator(".ibox-content")//complete container class
     	        .getByText("LabelTesting2Jan26",
     	                new Locator.GetByTextOptions().setExact(true));

     	int count = labels.count();
     	System.out.println("Total labels: " + count);

     	Set<String> uniqueTexts = new HashSet<>();

     	for (int i = 0; i < count; i++) {
     	    String text = labels.nth(i).textContent().trim();
     	    System.out.println("Label Text: " + text);

     	    if (uniqueTexts.contains(text)) {
     	        throw new AssertionError("❌ Duplicate label text found: " + text);
     	    } else {
     	        uniqueTexts.add(text);
     	    }
     	}

     	System.out.println("✅ All label texts under ibox-content are unique");

     }
     public void ControlDisplayed() {
    	 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("LabelTesting2Jan26");
         page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true)).click();

    	    // Locator for the label
    	    Locator label = page.locator("#lblCap109310");

    	    // Wait until the element is attached to DOM
    	    label.waitFor(new Locator.WaitForOptions()
    	            .setState(WaitForSelectorState.ATTACHED));

    	    // Scroll into view (in case it's below the fold)
    	    label.scrollIntoViewIfNeeded();

    	    // Assert visibility
    	    Assert.assertTrue(
    	            label.isVisible(),
    	            "❌ Label with id lblCap109310 is NOT displayed on the UI"
    	    );

    	    System.out.println("✅ Label lblCap109310 is displayed on the UI");
    	
    }
     public void CaptionFontSize() {
     	  page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("LabelTesting2Jan26");
    	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true)).click();

    	    String ActualfontSize = page.evaluate(
    	            "el => window.getComputedStyle(el).fontSize",
    	            page.locator("#lblCap109319").elementHandle()).toString();

    	    System.out.println("Font Size................................: " + ActualfontSize);
     String expectedFontSize = "50px";

    Assert.assertEquals(ActualfontSize, expectedFontSize, "Font size is not matching");
      }
     public void CaptionFontColor() {
     	  page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("LabelTesting2Jan26");
     	  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true)).click();
     	  
     	  String Actualcolor = (String) page.evaluate(
     		        "id => window.getComputedStyle(document.getElementById(id)).color",
     		        "lblCap109319"//chkbox6 caption
     		    );
     	  String expectedColor = "rgb(225, 55, 55)";

     		    System.out.println("Text Color...............................: " + Actualcolor);

     		    // Example: red color = rgb(225, 55, 55)
     		 Assert.assertEquals(Actualcolor, expectedColor, "Font color is not matching");

     	  
       }
     public void backgroundColor() {
   	  page.getByRole(AriaRole.TEXTBOX,
	            new Page.GetByRoleOptions().setName("Search"))
	        .fill("LabelTesting2Jan26");

	    page.getByRole(AriaRole.LINK,
	            new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true))
	        .click();

	    // 🔹 Get background color
	    String actualBgColor = (String) page.evaluate(
	        "id => window.getComputedStyle(document.getElementById(id)).backgroundColor",
	        "lblCap109319"//chkbox6 caption
	    );

	    String expectedBgColor = "rgb(43, 150, 218)"; // change as per UI

	    System.out.println("Background Color: " + actualBgColor);

	    Assert.assertEquals(
	        actualBgColor,
	        expectedBgColor,
	        "Background color is not matching"
	    );
}
     public void gridOrientation() {
 		String expectedOrientation = "Vertical"; // Change to "vertical" to test vertical orientation
	  	  page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("LabelTesting2Jan26");
	  	  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true)).click();

      // Locate elements (change locators as per your app)
      Locator ele1 = page.locator("#lblCap108953"); // chkbox5
      Locator ele2 = page.locator("#lblCap108952"); // chkbox6

      // Wait till visible
      ele1.waitFor();
      ele2.waitFor();

      // Get bounding boxes
      BoundingBox box1 = ele1.boundingBox();
      BoundingBox box2 = ele2.boundingBox();

      if (box1 == null || box2 == null) {
          Assert.fail("❌ One or both elements are not visible on screen");
      }

      double x1 = box1.x;
      double y1 = box1.y;
      double x2 = box2.x;
      double y2 = box2.y;

      System.out.println("Element1 -> X: " + x1 + " Y: " + y1);
      System.out.println("Element2 -> X: " + x2 + " Y: " + y2);

      boolean isHorizontal = false;
      boolean isVertical = false;

      // 🔹 Orientation logic
      if (Math.abs(y1 - y2) < 5 && x1 != x2) {
          isHorizontal = true;
          System.out.println("Grid Orientation: Horizontal");
      } 
      else if (Math.abs(x1 - x2) < 5 && y1 != y2) {
          isVertical = true;
          System.out.println("Grid Orientation: Vertical");
      }

      // 🔹 Assertion
      if (expectedOrientation.equalsIgnoreCase("horizontal")) {
          Assert.assertTrue(isHorizontal, "Expected Horizontal but found Vertical");
      } 
      else if (expectedOrientation.equalsIgnoreCase("vertical")) {
          Assert.assertTrue(isVertical, "Expected Vertical but found Horizontal");
      } 
      else {
          Assert.fail("Invalid orientation value. Use 'horizontal' or 'vertical'");
      }
  }
     public void widthOfTheControl() {
 		int expectedWidth = 10;
		 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("checkBox14Nov");
	  	  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("checkBox14Nov").setExact(true)).click();

	  	  // 1️⃣ Locate element
	      Locator label = page.locator("#lblCap108953");//chkbox5 caption
	      label.waitFor();
	      System.out.println("Element lblCap108953 found");

	      // 2️⃣ Convert Locator → ElementHandle
	      ElementHandle elementHandle = label.elementHandle();

	      if (elementHandle == null) {
	          Assert.fail("❌ ElementHandle is null for lblCap108953");
	      }

	      // 3️⃣ Get width (Appium getRect().getWidth() equivalent)
	      double actualWidth = (double) page.evaluate(
	              "el => el.getBoundingClientRect().width",
	              elementHandle
	      );

	      System.out.println("Actual width : " + actualWidth);

	      // 4️⃣ SAME formula as your Appium code
	      double assignedWidth = (actualWidth / 47.0) * 10.0;
	      System.out.println("assignedWidth : " + assignedWidth);

	      // 5️⃣ SAME assertion logic
	      Assert.assertTrue(
	              (expectedWidth - 2) > assignedWidth || assignedWidth >= expectedWidth,
	              "❌ Width validation failed for lblCap108953"//chkbox5 caption
	      );
	}
     public void checkboxEnabledStatus() {	
		 page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("checkBox14Nov");
	  	  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("checkBox14Nov").setExact(true)).click();

	  	
		    // 1️⃣ Locate element by ID
		    Locator checkboxLabel = page.locator("#lblCap108953");

		    // 2️⃣ Wait until visible
		    checkboxLabel.waitFor();
		    System.out.println("Element lblCap108953 found");

		    // 3️⃣ Assertions (equivalent to Appium)
		    Assert.assertTrue(
		            checkboxLabel.isVisible(),
		            "❌ Checkbox label should be visible"
		    );

		    Assert.assertTrue(
		            checkboxLabel.isEnabled(),
		            "❌ Checkbox label should be enabled"
		    );

		    // 4️⃣ Logs (same as your code)
		    System.out.println("isDisplayed: " + checkboxLabel.isVisible());
		    System.out.println("isEnabled: " + checkboxLabel.isEnabled());

		    // 5️⃣ Navigate back (browser equivalent)
		    page.goBack();
		

	}
      



}

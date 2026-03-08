package com.example.pages;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class CheckboxDropDownPage {

	private Locator search;
	private Locator user;
	private Locator lbl_txt_box;

	private final Page page;

	public CheckboxDropDownPage(Page page) {
		this.page = page;
	}

	public void searchbox() {
		search = page.getByPlaceholder("Search");
		search.fill("chkboxDD21Nov");
		PlaywrightAssertions.assertThat(page.locator(".fclick")).isVisible();

	}

	public void checkboxDropDown() {
		user = page.locator(".fclick");// this is the ID when form name appears after searching for the form
		user.click();
		page.waitForTimeout(2000);
//			  lbl_txt_box=page.locator("#ctrl109307");//ID for the control NAME onn the form LabelTesting2Jan26
//			  lbl_txt_box.fill("Label Testing");//Providing the input for the control NAME
//			  	page.waitForTimeout(2000);
	}

	public void CaptionFontSize() {

		String ActualfontSize = page
				.evaluate("el => window.getComputedStyle(el).fontSize", page.locator("#lblCap108985").elementHandle())
				.toString();

		System.out.println("Font Size................................: " + ActualfontSize);
		String expectedFontSize = "60px";

		Assert.assertEquals(ActualfontSize, expectedFontSize, "Font size is not matching");
	}

	public void unniqueControl() {

		Locator labels = page.locator(".ibox-content")// complete container class
				.getByText("LabelTesting2Jan26", new Locator.GetByTextOptions().setExact(true));

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
	
	 public void CaptionFontColor() {
//    	  page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("LabelTesting2Jan26");
//    	  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LabelTesting2Jan26").setExact(true)).click();
    	  
    	  String Actualcolor = (String) page.evaluate(
    		        "id => window.getComputedStyle(document.getElementById(id)).color",
    		        "lblCap108998"//chkbox6 caption
    		    );
    	  String expectedColor = "rgb(223, 38, 38)";

    		    System.out.println("Text Color...............................: " + Actualcolor);

    		    // Example: red color = rgb(225, 55, 55)
    		 Assert.assertEquals(Actualcolor, expectedColor, "Font color is not matching");

    	  
      }

	   public void backgroundColor() {

			    // 🔹 Get background color
			    String actualBgColor = (String) page.evaluate(
			        "id => window.getComputedStyle(document.getElementById(id)).backgroundColor",
			        "lblCap108997"//chkbox6 caption
			    );

			    String expectedBgColor = "rgb(231, 19, 19)"; // change as per UI

			    System.out.println("Background Color: " + actualBgColor);

			    Assert.assertEquals(
			        actualBgColor,
			        expectedBgColor,
			        "Background color is not matching"
			    );
		}
}

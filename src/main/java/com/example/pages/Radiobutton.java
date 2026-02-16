package com.example.pages;




import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.validator.PublicClassValidator;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Radiobutton {
	
	 private  Locator subjectCaption;
	 private  Locator caption;
	 private Locator cap_text;
	 private Locator valuee_text;
	
	
	
	
	private final Page page ;
	
	  public Radiobutton (Page page)
	 {
	     this.page = page;
	   
      }

	  public void verifySubjectCaptionIsEnglish() {

		    
		    Locator subjectCaption = page.locator("#lblCap109423");
            String captionText = subjectCaption.innerText().trim();
            boolean isEnglish = captionText.matches("^[A-Za-z ]+$");

		    Assert.assertTrue(
		        isEnglish,
		        "Subject caption is not in English. Found: " + captionText
		    );
		}

	  
	  public void verifyCaptionAllowsSpecialCharactersAndSpaces() {

		    Locator caption = page.locator("#lblCap109424");
		    String text = caption.innerText().trim();

		    boolean isValid =
		        text.matches("^(?=.*[A-Za-z])(?=.*\\s)(?=.*[@#$%&*!^()\\-_+=]).+$");

		    Assert.assertTrue(
		        isValid,
		        "Caption must contain letter, space and special character. Found: " + text
		    );
		}

	  public void verifyRadioButtonDefaultValues() {

		  
		    Assert.assertTrue(page.locator("#radio0_109423").count() > 0);
		    Assert.assertTrue(page.locator("#radio1_109423").count() > 0);
		    Assert.assertTrue(page.locator("#radio2_109423").count() > 0);

		    
		    Assert.assertTrue(
		        page.locator("#radio0_109423").isChecked(),
		        "Hindi should be selected by default"
		    );
		}

	

	  public void verifyRadioButtonOrderEasy() {

		   
		    Assert.assertEquals(
		        page.locator("label[id^='lbl'][id$='_109423']").nth(0).innerText().trim(),
		        "hindi",
		        "First option should be hindi"
		    );

		    
		    Assert.assertEquals(
		        page.locator("label[id^='lbl'][id$='_109423']").nth(1).innerText().trim(),
		        "english",
		        "Second option should be english"
		    );

		   
		    Assert.assertEquals(
		        page.locator("label[id^='lbl'][id$='_109423']").nth(2).innerText().trim(),
		        "math",
		        "Third option should be math"
		    );
		}

	  public void verifyNumericRadioOptions() {

		  
		    Assert.assertEquals(
		        page.locator("label[id^='lbl'][id$='_109424']").nth(0).innerText().trim(),
		        "1",
		        "First option should be 1"
		    );

		    
		    Assert.assertEquals(
		        page.locator("label[id^='lbl'][id$='_109424']").nth(1).innerText().trim(),
		        "2",
		        "Second option should be 2"
		    );

		    
		    Assert.assertEquals(
		        page.locator("label[id^='lbl'][id$='_109424']").nth(2).innerText().trim(),
		        "3",
		        "Third option should be 3"
		    );
		}

	  public void verifyRadioCaptionNotVisible() {

		  Locator caption = page.locator("label[id^='lbl_'][id$='_109425']");

		// Caption should NOT exist in DOM
		Assert.assertEquals(
		    caption.count(),
		    0,
		    "Caption should NOT exist in DOM when Show Caption = DO NOT SHOW"
		);

}
	  public void verifyRadioCaptionFontSize() {

		    Locator caption = page.locator("#lblCap109427");
		    caption.waitFor();

		    String actualFontSize =
		            (String) caption.evaluate(
		                    "el => window.getComputedStyle(el).fontSize"
		            );

		    String expectedFontSize = "30px";

		    Assert.assertEquals(
		            actualFontSize.trim(),
		            expectedFontSize,
		            "Radio caption font size is NOT matching"
		    );
		}

	  
	  
	  
	  
	  
	  
	  
	  
	  public void verifyRadioCaptionTextColor() {

		    Locator caption = page.locator("#lblCap109427");
		    caption.waitFor();

		    String actualColor =
		            (String) caption.evaluate(
		                    "el => window.getComputedStyle(el).color"
		            );

		    Assert.assertEquals(
		            actualColor,
		            "rgb(237, 29, 29)",
		            "Radio caption text color is NOT matching"
		    );
		}

	  public void verifyRadioCaptionBackgroundColor() {

		    Locator caption = page.locator("#lblCap109427");
		    caption.waitFor();

		    String actualBgColor =
		            (String) caption.evaluate(
		                    "el => window.getComputedStyle(el).backgroundColor"
		            );

		    Assert.assertEquals(
		            actualBgColor,
		            "rgb(201, 225, 20)",
		            "Radio caption background color is NOT matching"
		    );
		}


	  
	  
	  
	  
	  
	  
	// VALUE: Font Size
	  public void verifyRadioValueFontSize() {

	      Locator valueText = page.locator("#lblDistance_109426");
	      valueText.waitFor();
	      valueText.isVisible();

	      String actualFontSize = (String) valueText.evaluate(
	              "el => window.getComputedStyle(el).fontSize"
	      );

	      String expectedFontSize = "21px";  // <-- apne actual ke hisaab se change

	      Assert.assertEquals(
	              actualFontSize.trim(),
	              expectedFontSize.trim(),
	              "FAIL: Radio VALUE font size not matching"
	      );
	  }

	  // VALUE: Font Color
	  public void verifyRadioValueFontColor() {

	      Locator valueText = page.locator("#lblDistance_109426");
	      valueText.waitFor();
	      valueText.isVisible();

	      String actualColor = (String) valueText.evaluate(
	              "el => window.getComputedStyle(el).color"
	      );

	      String expectedColor = "rgb(32, 17, 235)"; // <-- apne expected ke hisaab se change

	      Assert.assertEquals(
	              actualColor.trim(),
	              expectedColor.trim(),
	              "FAIL: Radio VALUE font color not matching"
	      );
	  }

	 

			

			public void verifyRadioVisibility(String captionText, boolean expectedVisible) {

			    Locator caption = page.locator("text=" + captionText);

			    boolean actualVisible =
			            caption.count() > 0 && caption.first().isVisible();

			    Assert.assertEquals(
			            actualVisible,
			            expectedVisible,
			            "Radio visibility mismatch for: " + captionText
			    );
			}
			

			public void verifySubjectFromLanguageData() {

			    Locator subjectCaption = page.locator("#lblCap109423");

			    String actualText = subjectCaption.textContent().trim();

			    boolean isValid =
			            actualText.equalsIgnoreCase("subject")
			         || actualText.equals("सब्जेक्ट");

			    Assert.assertTrue(
			        isValid,
			        " Subject caption not coming from LANGUAGE_DATA JSON"
			    );
			    
			    
			}



			public void verifyThreeRadioButtonCaptionsAreDifferent() {

			    String subjectCaption =
			            page.locator("#lblCap109423").textContent().trim();

			    String studyModeCaption =
			            page.locator("#lblCap109426").textContent().trim();

			    String workLocationCaption =
			            page.locator("#lblCap109430").textContent().trim();

			    Assert.assertNotEquals(subjectCaption, studyModeCaption,
			            "Subject and Study Mode captions are same");

			    Assert.assertNotEquals(subjectCaption, workLocationCaption,
			            "Subject and Work Location captions are same");

			    Assert.assertNotEquals(studyModeCaption, workLocationCaption,
			            "Study Mode and Work Location captions are same");
			}

			}










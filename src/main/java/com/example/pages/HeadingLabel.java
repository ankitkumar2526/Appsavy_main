package com.example.pages;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeadingLabel {
	
	
	
	
	private Locator headingLabel;
	
	
	
	
	
	
	 private final Page page ;
	
	  public HeadingLabel (Page page)
	 {
	     this.page = page;
	   
   }
	  public void verifySitaFromLanguageData() {

		    Locator sitaCaption = page.locator("#ctrl109476");

		    String actualText = sitaCaption.textContent().trim();

		    boolean isValid =
		            actualText.equalsIgnoreCase("sita")
		         || actualText.equals("सीता");

		    Assert.assertTrue(
		        isValid,
		        " FAILED: Sita caption not coming from LANGUAGE_DATA JSON"
		    );
		    
		    }
	  public void verifyHeadingLabelCaptionVisible() {

		    Locator headingLabel = page.locator("#ctrl109477"); 

		   
		    headingLabel.waitFor();

		   
		    Assert.assertTrue(
		        headingLabel.isVisible(),
		        "FAILED: Heading label is not visible"
		    );

		   
		    String actualText = headingLabel.textContent().trim();

		    Assert.assertEquals(
		        actualText,
		        "heading label",
		        "FAILED: Heading label text mismatch"
		    );
		}
	  public void verifyShowCaptionEnabled() {

		    Locator headingLabel = page.locator("#ctrl109479");

		    headingLabel.waitFor();

		    Assert.assertTrue(
		        headingLabel.isVisible(),
		        "FAILED: Heading label is not visible when Show Caption is YES"
		    );

		    Assert.assertEquals(
		        headingLabel.textContent().trim(),
		        "show heading label",
		        "FAILED: Caption text mismatch when Show Caption is YES"
		    );
		}
	  public void verifyHeadingLabelvalueFontSize() {
		  Locator headingLabel = page.locator("#ctrl109480");

		    String actualFontSize = (String) headingLabel.evaluate(
		        "el => window.getComputedStyle(el).fontSize"
		    );

		    Assert.assertEquals(
		        actualFontSize.trim(),
		        "5px",
		        "FAILED: Heading label font size mismatch"
		    );
		}
	  public void verifyHeadingLabelvalueFontFamily() {
		  Locator headingLabel = page.locator("#ctrl109480");

		    String fontFamily = (String) headingLabel.evaluate(
		        "el => window.getComputedStyle(el).fontFamily"
		    );

		    Assert.assertTrue(
		        fontFamily.toLowerCase().contains("roboto"),
		        "FAILED: Heading label font family is not Roboto"
		    );
		}
	  public void verifyHeadingLabelvalueFontColor() {
		  Locator headingLabel = page.locator("#ctrl109480");

		    String actualColor = (String) headingLabel.evaluate(
		        "el => window.getComputedStyle(el).color"
		    );

		    Assert.assertEquals(
		        actualColor,
		        "rgb(249, 241, 241)",
		        "FAILED: Heading label font color mismatch"
		    );
		}
	  public void verifyHeadingLabelvalueBackgroundColor() {
		  Locator headingLabel = page.locator("#ctrl109480");

		    String bgColor = (String) headingLabel.evaluate(
		        "el => window.getComputedStyle(el).backgroundColor"
		    );

		    Assert.assertEquals(
		        bgColor,
		        "rgb(246, 19, 19)",
		        "FAILED: Heading label background color mismatch"
		    );
		}
	  public void verifyHeadingLabelvaluefontstyle() {
		  Locator headingLabel = page.locator("#ctrl109480");

		    String decoration = (String) headingLabel.evaluate(
		        "el => window.getComputedStyle(el).textDecoration"
		    );

		    Assert.assertTrue(
		        decoration.toLowerCase().contains("underline"),
		        "FAILED: Heading label is not underlined"
		    );
		    System.out.println("Heading label is underlined");
		}

}
	
	
	
	
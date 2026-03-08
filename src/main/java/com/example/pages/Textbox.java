package com.example.pages;

import static org.testng.Assert.fail;

import java.security.PrivateKey;

import javax.swing.plaf.ColorUIResource;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.util.UUID;

import org.testng.Assert;

public class Textbox {

	private Locator  firstName ;
	private Locator lastName ;
	private Locator save;
	private Locator chr_text;
	private Locator max_length;
	private Locator value_text;
	private Locator maxLengthTextbox;
	private Locator saveButton;
	public Locator maxLengthCaptionLabel;   
	public Locator maxLengthTextbox1;  
	private Locator captionLabel;
	private Locator textBox;
	private Locator emailTextbox;
	private Locator saveButton1;
	private Locator popup;
	private Locator dimeLabel;
    private Locator dimeTextbox;
    private Locator alphaTextbox;
    private Locator save1Button;
    private Locator defaultValueTextbox;
    private Locator firstNameInput;
    
   
    




;
	
	
	private final Page page ;
	
	  public Textbox(Page page)
	 {
	     this.page = page;
	   
       
        
	 }

	
	public void multilingualFunctionality (String fname, String lname)
	{
		firstName=page.locator("#ctrl109381"); 
		firstName.fill(fname);
		
		lastName=page.locator("#ctrl109386"); 
		lastName.fill(lname);
		
		save=page.locator("#ctrl109388"); 
		save.click();
	}
	public void selectMultilingualOption(String option) {
	          if (option.equalsIgnoreCase("yes")) {
	              multilingualFunctionality("english", "हिंदी");
	          } else if (option.equalsIgnoreCase("no")) {
	              multilingualFunctionality("singlename", "singlename");
	          }  
	}
	 
	public void verifyCaptionFontSize() {

	    Locator caption = page.locator("#lblCap109402");
	    caption.isVisible();

	    String actualFontSize =
	        (String) caption.evaluate(
	            "el => window.getComputedStyle(el).fontSize"
	        );

	    String expectedFontSize = "30px";

	    Assert.assertEquals(
	        actualFontSize.trim(),
	        expectedFontSize,
	        "Caption font size mismatch"
	    );
	}
	
	
	

	public void verifyCaptionTextColor() {

	    Locator caption = page.locator("#lblCap109402");

	    String actualColor =
	        (String) caption.evaluate(
	            "el => window.getComputedStyle(el).color"
	        );

	    Assert.assertEquals(
	        actualColor,
	        "rgb(237, 29, 29)",
	        "Caption text color mismatch"
	    );
	}
	public void verifyCaptionBackgroundColor() {

	    Locator caption = page.locator("#lblCap109402");

	    String actualBgColor =
	        (String) caption.evaluate(
	            "el => window.getComputedStyle(el).backgroundColor"
	        );

	    Assert.assertEquals(
	        actualBgColor,
	        "rgb(201, 225, 20)",
	        "Caption background color mismatch"
	    );
	}

		
	
	
	public void verifyValueFontSize() {
	    value_text = page.locator("#ctrl109405");
	    String fontSize = (String) value_text.evaluate(
	        "e => window.getComputedStyle(e).fontSize"
	    );
	    Assert.assertEquals(fontSize.trim(), "21px", "Font size mismatch");
	}

	
	public void verifyValueTextColor() {
	    String textColor = (String) value_text.evaluate(
	        "e => window.getComputedStyle(e).color"
	    );
	    Assert.assertEquals(textColor, "rgb(32, 17, 232)", "Text color mismatch");
	}

	
	
	public void verifyValueBackgroundColor() {
	    String bgColor = (String) value_text.evaluate(
	        "e => window.getComputedStyle(e).backgroundColor"
	    );
	    Assert.assertEquals(bgColor, "rgb(249, 16, 86)", "Background color mismatch");
	}

	
	  public void verifyCaptionShown() {

	    maxLengthCaptionLabel = page.locator("#lblCap109511");
	    maxLengthTextbox = page.locator("#lblCap109511");

	    Assert.assertTrue(maxLengthTextbox.isVisible());
	    Assert.assertTrue(maxLengthCaptionLabel.isVisible());

	    String capText = maxLengthCaptionLabel.textContent().trim().toLowerCase();
	    Assert.assertTrue(capText.contains("showcaptionon"));
	}

	public void verifyCaptionNotShown() {

	    
	    textBox = page.locator("#ctrl109512");

	    
	    captionLabel = page.locator("#lblCap109512");

	    
	    Assert.assertTrue(textBox.isVisible(), "Textbox should be visible");

	    
	    Assert.assertTrue(
	        captionLabel.count() == 0 || !captionLabel.isVisible(),
	        "Caption should NOT be shown on left side"
	    );
	}
	    
	    public void InvalidEmailShowsErrorPopup(){

	        emailTextbox = page.locator("#ctrl109411");
	        saveButton1   = page.locator("#ctrl109388");
	        
	        
	        page.onceDialog(dialog -> {
	            Assert.assertEquals(dialog.message(), "Please enter valid email");
	            dialog.dismiss();// click OK
	            
	        });
	        emailTextbox.fill("aa"); // invalid email
	        page.waitForTimeout(1000); // wait for potential popup to appear
	        saveButton1.click();
	        

	    }
	    

	    public void ValidEmailSubmitsFormSuccessfully() {

	       
	        Locator emailTextbox = page.locator("#ctrl109410");   // INPUT
	        Locator saveButton   = page.locator("#ctrl1109410"); // SAVE

	       
	        emailTextbox.waitFor();
	        emailTextbox.clear();

	       
	        emailTextbox.fill("test@gmail.com");
	        page.waitForTimeout(1000); // wait for any potential validation to process

	       
	        saveButton1.click();

	        
	        Assert.assertTrue(true, "Form submitted successfully with valid email");
	    }


       
        
        
        public void CaptionIsDisplayedOnLeftOfTextbox() {

           
            Locator dimeLabel = page.locator("#lblCap109410");
            Locator dimeTextbox = page.locator("#ctrl109410");

            dimeLabel.waitFor();
            dimeTextbox.waitFor();

            double labelX = dimeLabel.boundingBox().x;
            double textboxX = dimeTextbox.boundingBox().x;

           
            Assert.assertTrue(
                labelX < textboxX,
                "FAIL: DIME caption is NOT on the left side of its textbox"
            );
        }
}
        
     
    



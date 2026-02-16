package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;

import com.example.pages.LoginPage;
import com.example.pages.MultilineTextbox;
import com.example.pages.Textbox;

public class MultilineTextboxTest extends BaseTest {

	LoginPage loginPage;
    MultilineTextbox multilingualTextboxPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Textbox multilingualPage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        multilingualTextboxPage = new MultilineTextbox(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        multilingualPage = new Textbox(page);
    }
    @Test(priority=1, description = "Naviagte to multilinetextbox form")
	public void Multilingual() {
		
		
		loginPage.navigate();

		loginPage.login(
		    ConfigReader.get("username"),
		    ConfigReader.get("password")
		   );
		
		
		adminRolePage.clickAdmin1();
		page.waitForTimeout(2000);
	            controlTestProject.clipBar();
		    	controlTestProject.searchbox();
		    	controlTestProject.multilineTextbox();
		    	 page.waitForTimeout(2000);
 }
    
    @Test(
    	    priority = 2,
    	    description = "Verify Language_Data is working while clicking on the translator button"
    	)
    	public void verify_LanguageData_On_Translator_Click() {

    	    multilingualTextboxPage.verifyCaptionFromLanguageDataOnTranslatorClick();
    	}
    
    
    
    
    @Test(priority = 3, description = "Verify multiline caption visibility based on config")
    public void MultilineCaptionVisibility() {

        
        multilingualTextboxPage.verifyMultilineCaptionVisibility(true);

         }


    @Test(
    	    priority = 4,
    	    description = "Verify the behavior of the 'Default Value' property on the Multiline Textbox."
    	)
    	public void MultilineDefaultValueVisible() {

    	    multilingualTextboxPage.verifyMultilineTextboxDefaultValueIsPresent();
    	}



    @Test(priority = 5, description = "Verify max length for Multiline Textbox")
    public void MultilineMaxLength() {
        multilingualTextboxPage.verifyMultilineMaxLength(5);
    }

    @Test( priority = 6, description = "Verify that on caption type  If I set Left then caption should left on textbox."
			)
			public void CaptionIsDisplayedOnLeftOfmultilineTextbox() {
    	
    	multilingualTextboxPage.verifyMultilineCaptionIsOnLeft();
			}
    
    
    
    @Test(priority = 7, description = "Verify caption font size")
	 public void CaptionFontSize() {
    	multilingualTextboxPage.verifymultilineCaptionFontSize();
	 }

    @Test(priority = 8, description = "Verify caption text color")
	 public void CaptionTextColor() {
    	multilingualTextboxPage.verifymultilineCaptionTextColorr();
	 }

	 @Test(priority = 9, description = "Verify caption background color")
	 public void CaptionBackgroundColor() {
		 multilingualTextboxPage.verifymultilineCaptionBackgroundColorr();
	 }


  
    @Test(priority = 10, description = "Verify multiline caption font family")
    public void MultilineCaptionFontFamily() {
    	multilingualTextboxPage.verifyMultilineCaptionFontFamily();
    }

    @Test(priority = 11, description = "Verify multiline caption font style bold")
    public void MultilineCaptionFontBold() {
    	multilingualTextboxPage.verifyMultilineCaptionFontstyle();
    }
   
    
    @Test(priority = 12,description = "Verify multiline VALUE font size"
        	)
        	public void VerifymultilineValueFontSize() {

    	multilingualTextboxPage.verifymultilinevalueFontSize();
        	}


    @Test(priority = 13, description = "Verify multiline textbox VALUE font family")
    public void MultilineValueFontFamily() {
    	multilingualTextboxPage.verifyMultilineValueFontFamily();
    }

    @Test(priority = 14, description = "Verify multiline textbox VALUE font style ")
    public void MultilineValueFontStyle() {
    	multilingualTextboxPage.verifyMultilineValueFontStyle();
    }

    @Test(priority = 15, description = "Verify multiline textbox VALUE text color")
    public void MultilineValueTextColor1() {
    	multilingualTextboxPage.verifyMultilineValueTextColor1();
    }

    @Test(priority = 16, description = "Verify multiline textbox VALUE background color")
    public void MultilineValueBackgroundColor1() {
    	multilingualTextboxPage.verifyMultilineValueBackgroundColor1();
    }
  
     
    @Test(
    	    priority = 17,
    	    description = "Verify mandatory field behaviour: PASS when mandatory ON, FAIL when mandatory OFF"
    	)
    	public void Mandatory_Field_Validation() {

    	    MultilineTextbox pageObj = new MultilineTextbox(page);
    	    pageObj.mandatoryFieldValidation();
    	}

}

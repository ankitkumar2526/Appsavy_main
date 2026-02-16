package com.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.example.pages.Textbox;
import com.example.pages.Radiobutton;

public class Radiobuttontest extends BaseTest {

	LoginPage loginPage;
    Radiobutton radiobuttonPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Textbox multilingualPage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        radiobuttonPage = new Radiobutton(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        multilingualPage = new Textbox(page);
    }
    @Test(priority=1, description = "Naviagte to Radiobutton form")
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
		    	controlTestProject.radioBtn();
		    	 page.waitForTimeout(2000);
 }
    
    @Test(priority=2, description = "Verify Caption Language When Multilingual is No")
    public void verifyCaptionLanguageWhenMultilingualIsNo() {
        radiobuttonPage.verifySubjectCaptionIsEnglish();
    }

    
    @Test(priority =3, description = "Verify caption supports spaces and special characters"
    	)
    	public void verifyCaptionsupportSpecialCharactersandsupports() {

    	    radiobuttonPage.verifyCaptionAllowsSpecialCharactersAndSpaces();
    	}
   
    @Test(priority = 4, description = "Verify default values are displayed as radio button options on UI" )
    	public void verifyDefaultRadioButtonValuesaredisplayed() {
    	    radiobuttonPage.verifyRadioButtonDefaultValues();
    	}
         
 

    @Test( priority = 5, description = "Verify order of radio button options matches DEFAULT_VALUE" )
    	public void verifyRadioButtonOrderTest() {
    	    radiobuttonPage.verifyRadioButtonOrderEasy();
    	}
    
    
    @Test( priority = 6, description = "Verify that numeric radio button options are displayed correctly")
    	public void verifyNumericRadioButtonOptionsTest() {

    	    radiobuttonPage.verifyNumericRadioOptions();

    	}
    
    
    @Test(priority = 7, description = "Verify caption is NOT shown when Show Caption = DO NOT SHOW")
    	public void verifyRadioCaptionNotVisibleTest() {

    	    radiobuttonPage.verifyRadioCaptionNotVisible(); 
    	}
    
    
    
    
    @Test(
    	    priority = 8,
    	    description = "Verify radio button caption font size"
    	)
    	public void testRadioCaptionFontSize() {

    	    radiobuttonPage.verifyRadioCaptionFontSize();
    	}

    
    @Test(
    	    priority = 9,
    	    description = "Verify radio button caption text color"
    	)
    	public void testRadioCaptionTextColor() {

    	    radiobuttonPage.verifyRadioCaptionTextColor();
    	}

    
    
    @Test(
    	    priority = 10,
    	    description = "Verify radio button caption background color"
    	)
    	public void testRadioCaptionBackgroundColor() {

    	    radiobuttonPage.verifyRadioCaptionBackgroundColor();
    	}

    
    @Test(priority = 11, description = "Verify radio VALUE font size")
    public void testRadioValueFontSize() {
        radiobuttonPage.verifyRadioValueFontSize();
    }

    @Test(priority = 12, description = "Verify radio VALUE font color")
    public void testRadioValueFontColor() {
        radiobuttonPage.verifyRadioValueFontColor();
    }

    

    
    
    
    
   
    
    
    @Test(
    	    priority = 14,
    	    description = "Verify radio button visibility based on Visible Yes/No config"
    	)
    	public void verify_RadioButtonVisibilityTest() {

    	    radiobuttonPage.verifyRadioVisibility("education level", true);
    	    radiobuttonPage.verifyRadioVisibility("marital status", false);
   

}
    
    @Test(
    	    priority = 15,
    	    description = "Verify Language_Data is working while clicking on the translator button"
    	)
    	public void verify_LanguageData_On_Translator_Click() {

    	    radiobuttonPage.verifySubjectFromLanguageData();
    	}


    @Test(
    	    priority = 16,
    	    description = "Verify selected RadioButton captions are different"
    	)
    	public void verify_Selected_RadioButton_Captions_Are_Different() {
    	    radiobuttonPage.verifyThreeRadioButtonCaptionsAreDifferent();
    	}
 
}
    





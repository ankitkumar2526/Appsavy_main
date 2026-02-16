package com.example.tests;

import org.junit.platform.commons.annotation.Testable;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.HeadingLabel;
import com.example.pages.LoginPage;
import com.example.pages.MultilineTextbox;
import com.example.pages.Textbox;

public class HeadingLabelTest extends BaseTest {

	LoginPage loginPage;
    MultilineTextbox multilingualTextboxPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Textbox multilingualPage;
    HeadingLabel headingLabelPage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        multilingualTextboxPage = new MultilineTextbox(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        multilingualPage = new Textbox(page);
        headingLabelPage = new HeadingLabel(page);
    }
  
    
    @Test(priority=1, description = "Naviagte to Headinglabel form")
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
   		    	controlTestProject.headingLabel();
   		    	 page.waitForTimeout(2000);
    }
   
    @Test(priority = 2,description = "Verify Language_Data is working while clicking on the translator button"
    	)
    	public void verify_LanguageData_On_Translator_Click() {
    	    headingLabelPage.verifySitaFromLanguageData();
    	}
    
    
    @Test(priority = 3, description = "Verify heading label caption visible on web UI")
    public void verifyHeadingLabelCaption() {

        headingLabelPage.verifyHeadingLabelCaptionVisible();

    }
    @Test(priority = 4, description = "Verify Show Caption property on heading label")
    public void verifyshowCaption() {

      
        headingLabelPage.verifyShowCaptionEnabled();

    }
    @Test(priority = 5,description = "Verify Heading Label VALUE font size"
    	)
    	public void VerifyHeadingLabelValueFontSize() {

    	    headingLabelPage.verifyHeadingLabelvalueFontSize();
    	}

    	@Test(priority = 6,description = " Verify Heading Label VALUE font family"
    	)
    	public void VerifyHeadingLabelValueFontFamily() {

    	    headingLabelPage.verifyHeadingLabelvalueFontFamily();
    	}

    	@Test(priority = 7,description = " Verify Heading Label VALUE font color"
    	)
    	public void Verify_HeadingLabel_Value_FontColor() {

    	    headingLabelPage.verifyHeadingLabelvalueFontColor();
    	}

    	@Test( priority = 8,description = "Verify Heading Label VALUE background color")
    	
    	public void VerifyHeadingLabelValueBackgroundColor() {

    	    headingLabelPage.verifyHeadingLabelvalueBackgroundColor();
    	}

    	@Test(priority = 9,description = "Verify Heading Label VALUe font style"
    	)
    	public void VerifyHeadingLabelValuefontstyle() {

    	    headingLabelPage.verifyHeadingLabelvaluefontstyle();
    	}


}



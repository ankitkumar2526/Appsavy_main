package com.example.tests;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;



import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.util.Assert;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.Label;
import com.example.pages.LoginPage;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Labeltest  extends BaseTest {
	LoginPage loginPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Label label;
    
   
    
    @BeforeClass
    public void initPages() throws InterruptedException {
        loginPage = new LoginPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        Thread.sleep(2000);
        label = new Label(page);
       
    }

 @Test(priority=1, description = "Verify Admin Role Functionality")
	public void loginFunctionality() {		
		
		loginPage.navigate();
        loginPage.login(ConfigReader.get("username"),ConfigReader.get("password") );
 }
        @Test(priority=2, description = "Verify Admin Role Functionality")
        		public void testAdminRole() {
		    	
		adminRolePage.clickAdmin1();
		 log(Status.INFO, "Clicked on Admin1");
		 page.waitForTimeout(2000);
        }
		
        @Test(priority=3, description = "Verify Control Test Functionality")
            public void testControlTestProject() {
        	
		    	// Click on Admin1
		    	controlTestProject.clipBar();
		    	label.searchbox();
		    	label.label();
		    	 page.waitForTimeout(2000);
		    	PlaywrightAssertions.assertThat(page.locator("#ctrl109305")).isVisible();
		    }
        
//        @Test(priority = 4, description = "Verify Caption Visibility")
//        public void verifyCaptionVisibility() {
//        	label.verifyCaptionText( label);
//        }
        @Test(priority = 5, description = "by fetching the page title, verifying the correct page is opened")
        public void verifyLabel_control_PageSuccessfullyOpen() {
        	label.LabelFormIsOpenned();

        }
        @Test(priority = 6, description = "verifying that caption of the control is visible")
        public void verifyCaptionVisiblity() {
        	label.CaptionVisibility();            
        }

        
        @Test(priority = 7, description = "verify blank mandatory field submission is successful")//Hold
        public void verifyFormSubmissionWithoutFillingzTheMandatoryField() {
        	label.mandatoryField();  
        }
        @Test(priority = 8, description = "verifying translator is working fine for Label control")
        void verifyTranslatorWorking() throws InterruptedException {
        	label.Tranlsator();  
        }
        @Test(priority = 9, description = "verifying unique control names on a single form")//Hold
    	public void verifyUniqueControlNamesOnSingleForm() {
    		label.unniqueControl();  
    	}
        @Test(priority = 10, description = "verifying that checkbox are displayed on the form")
    	public void verifyCheckboxDisplayed() throws InterruptedException {
        	label.ControlDisplayed();  
        }    

        @Test(priority = 11)
        public void verifyCaptionFontSize(){
        	label.CaptionFontSize();  
        }
        @Test(priority = 12)
        public void verifyCaptionFotColor(){
        	label.CaptionFontColor();  
        }
        @Test(priority = 13, description = "verifying that checkboxes are displayed on the form")
        public void verifyBackgroundColor_Checkbox() throws InterruptedException {
        	label.backgroundColor();  
        }
//    	@Test(priority = 14, description = "verifying grid orientation of checkboxes on the form")	
        public void verifyGridOrientation_CheckBox() {
    					label.gridOrientation();  
		
    	}
    	@Test(priority = 15, description = "verifying width of the checkbox control on the form")
    	public void verifyWidthOfTheControl() throws IOException, InterruptedException {
    		label.widthOfTheControl();  
    	}
    	@Test(priority = 16, description = "verifying that checkbox is enabled on the form")
    	public void verifyCheckboxEnabled() {
    		label.checkboxEnabledStatus();
    	}
        


}





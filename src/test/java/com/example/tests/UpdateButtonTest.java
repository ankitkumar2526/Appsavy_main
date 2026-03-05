package com.example.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.example.pages.UpdateButtonPage;



public class UpdateButtonTest extends BaseTest {

	LoginPage loginPage;
   AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    UpdateButtonPage updateButtonPage;

   
    
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
      adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        updateButtonPage = new UpdateButtonPage(page);



      
    }
  
    
    @Test(priority=1, description = "Naviagte to UpdateButton  form")
   	public void Multilingual() {
   		
   		
   		loginPage.navigate();

   		loginPage.login(
   		    ConfigReader.get("username"),
   		    ConfigReader.get("password")
   		   );
   		
   		
   		adminRolePage.clickAdmin1();
   		page.waitForTimeout(2000);
   	            controlTestProject.clipBar();
   		    	controlTestProject.contest_Searchbox();
   		    	controlTestProject.UpdateButton();
   		    	 page.waitForTimeout(2000);
    }
    
    @Test(priority = 2, description = "Verify Hindi caption is saved and displayed correctly for Update Button")
    public void verifyHindiCaptionSavedAndVisibleForUpdateButton() {

        

        // Page validation logic
        updateButtonPage.verifyHindiCaptionSavedAndVisibleForUpdateButton();
    }
    
    @Test(priority = 3, description = "Verify Update button name is displayed in Hindi after language change")
    public void verifySaveButtonNameChnageInHindi() {

        // Navigation already handled separately
        updateButtonPage.verifySaveButtonNameChnageInHindi();
    }

    
    @Test(priority = 4, description = "Verify form button name 'Do Not Show' remains in English after language change")
    public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

        // Navigation handled separately
        updateButtonPage.verifyFormButtonNameRemainsEnglishAfterLanguageChange();
    }

    @Test(priority = 5, description = "Verify the ' Caption Test' property is visible to users for control 'Update Button' on web form")
    public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {

        // Navigation handled separately
        updateButtonPage.verifyCaptionPropertyIsVisibleForCaptionTestControl();
    }
    
    @Test(priority = 6, description = "Verify that control name 'VISIBILITY_Y' is visible on web form")
    public void verifyVisibilityYControlIsVisible() {

        // Navigation handled separately
        updateButtonPage.verifyVisibilityYControlIsVisible();
    }
    
    
    @Test(priority = 7, description = "Verify that control name 'VISIBILITY_N' is not available on web form")
    public void verifyVisibilityNControlIsNotVisible() {

        // Navigation handled separately
        updateButtonPage.verifyVisibilityNControlIsNotVisible();
    }

    @Test(priority = 8, description = "Verify Font Size is set to 30 for save button named 'Font Size'")
    public void verifyFontSizeIs30() {

        // Navigation handled separately
        updateButtonPage.verifyFontSizeIs30();
    }
    
    
    @Test(priority = 9, description = "Verify Font Style is Bold")
    public void verifyFontStyleIsBold() {

        // Navigation handled separately
        updateButtonPage.verifyFontStyleIsBold();
    }
    
    
    @Test(priority = 10, description = "Verify Font Color is #1724de")
    public void verifyFontColor() {

        // Navigation handled separately
        updateButtonPage.verifyFontColor();
    }

    @Test(priority = 11, description = "Verify Background Color is #e1c019")
    public void verifyBackgroundColor() {

        // Navigation handled separately
        updateButtonPage.verifyBackgroundColor();
    }



    
}
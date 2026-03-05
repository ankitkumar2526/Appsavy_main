package com.example.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.example.pages.SaveButtonPage;



public class SaveButtonTest extends BaseTest {

	LoginPage loginPage;
   AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    SaveButtonPage SaveButtonPage;

   
    
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
      adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        SaveButtonPage = new SaveButtonPage(page);



      
    }
  
    
    @Test(priority=1, description = "Naviagte to SaveButton  form")
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
   		    	controlTestProject.SaveButton();
   		    	 page.waitForTimeout(2000);
    }
    @Test(priority = 2, description = "Verify savebutton name is displayed in Hindi after language change")
    public void verifySaveButtonNameChnageInHindi() {

        // Navigation handled separately
        SaveButtonPage.verifySaveButtonNameChnageInHindi();
    }

    @Test(priority = 3, description = "Verify form button name 'Vertical' remains in English after language change")
    public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

        // Navigation handled separately
        SaveButtonPage.verifyFormButtonNameRemainsEnglishAfterLanguageChange();
    }
    
    
    @Test(priority = 4, description = "Verify Hindi input is saved and visible in Language Details grid")
    public void verifyHindiInputSavedAndVisibleInGrid() {

        // Navigation handled separately
        SaveButtonPage.verifyHindiInputSavedAndVisibleInGrid();
    }


    @Test(priority =5 , description = "Verify Save button name 'भाषा' is visible on the form")
    public void verifySaveButtonNameInHindi() {

        // Navigation handled separately
        SaveButtonPage.verifySaveButtonNameInHindi();
    }

    @Test(priority = 6,
            description = "Verify the 'Caption' property is visible to users for control 'Caption Test' on web form")
    public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {

        // Navigation handled separately
        SaveButtonPage.verifyCaptionPropertyIsVisibleForCaptionTestControl();
    }

    
    @Test(priority = 7,
            description = "Verify that control name 'visibility_y' is visible on web form")
    public void verifyVisibilityYControlIsVisible() {

        // Navigation handled separately
        SaveButtonPage.verifyVisibilityYControlIsVisible();
    }

    
    
    @Test(priority = 8,
            description = "Verify that control name 'visibility_n' is not available on web form")
    public void verifyVisibilityNControlIsNotVisible() {

        // Navigation handled separately
        SaveButtonPage.verifyVisibilityNControlIsNotVisible();
    }
    @Test(priority = 9,
            description = "Verify Font Size is set to 30 for save button named 'Font Size'")
    public void verifyFontSizeIs25() {

        // Navigation handled separately
        SaveButtonPage.verifyFontSizeIs25();
    }
    @Test(priority = 10, description = "Verify Font Style is Bold")
    public void verifyFontStyleIsBold() {

        // Navigation handled separately
        SaveButtonPage.verifyFontStyleIsBold();
    }
    @Test(priority = 11, description = "Verify Font Color is #470af0")
    public void verifyFontColor() {

        // Navigation handled separately
        SaveButtonPage.verifyFontColor();
    }

    @Test(priority = 12, description = "Verify Background Color is #fac01e")
    public void verifyBackgroundColor() {

        // Navigation handled separately
        SaveButtonPage.verifyBackgroundColor();
    }

}
package com.example.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.pages.AddButton;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;

import com.example.pages.LoginPage;



public class AddButtontest extends BaseTest {

	LoginPage loginPage;
   
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    AddButton addButtonPage;

   
    
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
      
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        addButtonPage = new AddButton(page);


      
    }
  
    
    @Test(priority=1, description = "Naviagte to Addbutton  form")
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
   		    	controlTestProject.AddButton();
   		    	 page.waitForTimeout(2000);
    }
    
    
    @Test(priority = 2, description = "Verify Hindi caption is saved and displayed correctly for Add Button")
    public void verifyHindiCaptionSavedAndVisibleForUpdateButton() {

     

        // Call page method
        addButtonPage.verifyHindiCaptionSavedAndVisibleForUpdateButton();
    }

	 
   
    @Test(priority = 3, description = "Verify Add button name is displayed in Hindi after language change")
    public void verifySaveButtonNameChnageInHindi() {

        addButtonPage.verifySaveButtonNameChnageInHindi();

    }

    
    @Test(priority = 4, description = "Verify form Add button name 'veritical' remains in English after language change")
    public void verifyFormButtonNameRemainsEnglishAfterLanguageChange() {

        addButtonPage.verifyFormButtonNameRemainsEnglishAfterLanguageChange();
    }

    
    @Test(priority = 5, description = "Verify the ' Caption Test' property is visible to users for control 'Add Button' on web form")
    public void verifyCaptionPropertyIsVisibleForCaptionTestControl() {

      

        // 🔹 Call page method
        addButtonPage.verifyCaptionPropertyIsVisibleForCaptionTestControl();
    }

    @Test(priority = 6, description = "Verify that control name 'VISIBILITY_Y' is visible on web form")
    public void verifyVisibilityYControlIsVisible() {

        

        // Call page method
        addButtonPage.verifyVisibilityYControlIsVisible();
    }
    
    @Test(priority = 7, description = "Verify that control name 'VISIBILITY_N' is not available on web form")
    public void verifyVisibilityNControlIsNotVisible() {

       

        // Call page method
        addButtonPage.verifyVisibilityNControlIsNotVisible();
    }
    
    @Test(priority = 8, description = "Verify Font Size is set to 30 for save button named 'Font Size'")
    public void verifyFontSizeIs30() {

      

        // Call page method
        addButtonPage.verifyFontSizeIs30();
        
        
}
    
    
    @Test(priority = 9, description = "Verify Font Style is Bold")
    public void verifyFontStyleIsBold() {

     
        addButtonPage.verifyFontStyleIsBold();
    }
    
    
    @Test(priority = 10, description = "Verify Font Color is #142bd7")
    public void verifyFontColor() {

        
        addButtonPage.verifyFontColor();
    }

    
    @Test(priority = 11, description = "Verify Background Color is #e1c019")
    public void verifyBackgroundColor() {

      
        addButtonPage.verifyBackgroundColor();
    }


    }























/*
 * package com.example.tests; import org.testng.Assert; import
 * org.testng.annotations.BeforeClass;
 * 
 * 
 * 
 * import org.testng.annotations.Test;
 * 
 * import com.aventstack.extentreports.Status; //import
 * com.aventstack.extentreports.util.Assert; import com.example.pages.AdminRole;
 * import com.example.pages.ConfigReader; import
 * com.example.pages.ControlTestProject; import com.example.pages.AddButton;
 * import com.example.pages.LoginPage; import
 * com.microsoft.playwright.assertions.PlaywrightAssertions;
 * 
 * public class AddButtontest extends BaseTest { LoginPage loginPage; AdminRole
 * adminRolePage; ControlTestProject controlTestProject; AddButton addButton;
 * 
 * 
 * @BeforeClass public void initPages() { loginPage = new LoginPage(page);
 * adminRolePage = new AdminRole(page); controlTestProject = new
 * ControlTestProject(page); addButton = new AddButton(page);
 * 
 * }
 * 
 * @Test(priority=1, description = "Verify Admin Role Functionality") public
 * void loginFunctionality() {
 * 
 * 
 * 
 * loginPage.navigate();
 * loginPage.login(ConfigReader.get("username"),ConfigReader.get("password") );
 * }
 * 
 * @Test(priority=2, description = "Verify Admin Role Functionality") public
 * void testAdminRole() {
 * 
 * adminRolePage.clickAdmin1(); log(Status.INFO, "Clicked on Admin1");
 * page.waitForTimeout(2000); }
 * 
 * @Test(priority=3, description = "Verify Control Test Functionality") public
 * void testControlTestProject() {
 * 
 * // Click on Admin1 controlTestProject.clipBar(); addButton.searchbox();
 * addButton.contest(); page.waitForTimeout(2000);
 * PlaywrightAssertions.assertThat(page.locator("#ctrl109305")).isVisible(); } }
 */
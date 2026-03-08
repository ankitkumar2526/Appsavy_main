package com.example.tests;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;

import com.example.pages.Textbox;
import com.example.pages.Textbox2Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.example.pages.LoginPage;
import com.example.pages.MultilineTextbox;

public class Textbox2Test extends BaseTest {

	LoginPage loginPage;
   
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Textbox2Page textboxPage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        textboxPage = new Textbox2Page(page);
    }
    
	@DataProvider(name = "multilingualData")
	public Object[][] multilingualDataProvider() {
		return new Object[][] {
			{"yes", new String[] {"english", " हिंदी"}},
			{"no", new String[] {"singlename"}}
			
		};
	}

	 @Test(priority=1, description = "Naviagte to textbox form")
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
			    	controlTestProject.textbox2();
			    	 page.waitForTimeout(2000);
	 }
	 
	 
	 @Test(
	    	    priority = 2,
	    	    description = "Verify the behavior of the 'Default Value' property on the  Textbox2."
	    	)
	    	public void MultilineDefaultValueVisible() {

	    	    textboxPage.verifyTextbox2DefaultValueIsPresent();
	    	}
	 
	 @Test(priority = 3, description = "Verify Unique Property for Textbox2")
	 public void verifyUniqueProperty() {

	 textboxPage.checkUniqueProperty();

	 }
	 @Test(priority = 4, description = "Verify Max Length Validation for Textbox2")
	 public void verifyMaxLengthTextbox() {

	 textboxPage.verifyMaxLengthValidation();

	 }

	 
	 
	 @Test(
	    	    priority = 5,
	    	    description = "Verify mandatory field behaviour: PASS when mandatory ON, FAIL when mandatory OFF"
	    	)
	    	public void Mandatory_Field_Validation() {

	    	  //  Textbox2 pageObj = new Textbox2(page);
	    	    textboxPage.mandatoryFieldValidation();
	    	}
	 
	 @Test(priority = 6, description = "Verify Alphanumeric Validation for Textbox2")
	 public void verifyAlphanumericTextbox() {

	     textboxPage.verifyAlphanumericValidation();

	 }
}
			    	
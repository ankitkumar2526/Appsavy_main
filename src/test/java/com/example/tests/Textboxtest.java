package com.example.tests;

import java.util.concurrent.PriorityBlockingQueue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.DashboardPage;
import com.example.pages.Textbox;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.example.pages.LoginPage;

public class Textboxtest extends BaseTest {

	LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Textbox textboxPage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        textboxPage = new Textbox(page);
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
			    	controlTestProject.textbox();
			    	 page.waitForTimeout(2000);
	 }
			    	
			    	 @Test(priority=2,dataProvider = "multilingualData", description = "Verify Multilingual Functionality")
			    	public void testMultilingualFunctionality(String MultilingualOption, String[] names) {
			    	
			    	// Multilingual Functionality
			    	log(Status.INFO, "Starting Multilingual Functionality Test with option: " + MultilingualOption);
			    	textboxPage.selectMultilingualOption(MultilingualOption);
			    	// handling option
			    	if ("yes".equalsIgnoreCase(MultilingualOption)) {
			    		for(String name : names) {
			    		log(Status.INFO, "Verifying name: " + name);
			    		textboxPage.multilingualFunctionality(names[0], names[1]);
			    		}
			    	} else if ("no".equalsIgnoreCase(MultilingualOption)) {
			    	    String singlename =	names[0];
			    	   	log(Status.INFO, "Verifying singlename: " + singlename);
			    	   	textboxPage.multilingualFunctionality(singlename, singlename);
			    	}

  } 
			    	 
			    	 @Test(priority = 3, description = "Verify caption font size")
			    	 public void testCaptionFontSize() {
			    	     textboxPage.verifyCaptionFontSize();
			    	 }

			    	 @Test(priority = 4, description = "Verify caption text color")
			    	 public void testCaptionTextColor() {
			    	     textboxPage.verifyCaptionTextColor();
			    	 }

			    	 @Test(priority = 5, description = "Verify caption background color")
			    	 public void testCaptionBackgroundColor() {
			    	     textboxPage.verifyCaptionBackgroundColor();
			    	 }

			    	 
			    		 @Test(priority = 6, description = "Verify value font size")
			    	 public void testValueFontSize() {
			    	     textboxPage.verifyValueFontSize();
			    	 }

			    	 
			    	 @Test(priority = 7, description = "Verify value text color")
			    	 public void testValueTextColor() {
			    	     textboxPage.verifyValueTextColor();
			    	 }
 
			    	 @Test(priority = 8, description = "Verify value background color")
			    	 public void testValueBackgroundColor() {
			    	     textboxPage.verifyValueBackgroundColor();
			    	 }

			    	 
			    	 @Test(priority = 9, description = "Verify the behavior of the 'Show Caption' property working correctly when I select show caption as ON.")
			    	    public void testverifyCaptionShowTest() {
			    	        textboxPage.verifyCaptionShown();
			    	 
}
			    	 @Test(priority = 10, description = "Verify that the behavior of the 'Show Caption' property on the text box when I select DO NOT SHOW  option .")
			    	 public void testVerifyCaptionNotShown() {
			    	     textboxPage.verifyCaptionNotShown();
			    	 }
			    	 @Test(priority = 11, description = "Verify that an error message is shown when an invalid email is entered and the form is not submitted.")
			    	 public void testInvalidEmailShowsErrorPopup(){
			    	     textboxPage.InvalidEmailShowsErrorPopup();
			    	 }

			    	 @Test(priority = 12, description = "Verify that the form is submitted successfully when a valid email is entered.")
			    	 public void testValidEmailSubmitsFormSuccessfully(){
			    	     textboxPage.ValidEmailSubmitsFormSuccessfully();
			    	 }

			    	 @Test( priority = 13, description = "Verify that on caption type  If I set Left then caption should left on textbox."
			    			)
			    			public void testCaptionIsDisplayedOnLeftOfTextbox() {
			    			    textboxPage.CaptionIsDisplayedOnLeftOfTextbox();
			    			}
  }
			    	 




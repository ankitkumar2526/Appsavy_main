package com.qa.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.pages.Radiobutton;
import com.example.pages.Textbox;
import com.example.tests.BaseTest;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class AppSavy extends BaseTest {


	LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Textbox multilingualPage;
    Radiobutton radiobuttonPage;

    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        multilingualPage = new Textbox(page);
        radiobuttonPage = new Radiobutton(page);
    }
    
    @DataProvider(name = "multilingualData")
	public Object[][] multilingualDataProvider() {
		return new Object[][] {
			{"yes", new String[] {"english", " हिंदी"}},
			{"no", new String[] {"singlename"}}
			
		};
	}
    
	@Test(priority=1, description = "Verify Admin Role Functionality")
	public void testAdminRoleFunctionality() {
		
		
		loginPage.navigate();

		loginPage.login(
		    ConfigReader.get("username"),
		    ConfigReader.get("password")
		   );
	}
		    @Test(priority=2, description = "verify admin role") 
		    public void testAdminRole() {
		    
		    	// Click on Admin1
		    	
		adminRolePage.clickAdmin1();
		 log(Status.INFO, "Clicked on Admin1");
		 page.waitForTimeout(2000);
		 PlaywrightAssertions.assertThat(page.locator("#proAppName")).isVisible();
		
//		// Click on Admin2
//		adminRolePage.clickAdmin2();
//		log(Status.INFO, "Clicked on Admin2");
		
		// Add assertions as needed to verify the expected behavior after clicking Admin1 and Admin2
		log(Status.PASS, "Admin Role functionality verified successfully");
	}
		    @Test(priority=3, description = "verify user button ")  
		    public void testUserButton() {
		    	// ControlTestProject controlTestProject = new ControlTestProject(page);
		    	// Click on Admin1
		    	controlTestProject.clipBar();
		    	controlTestProject.searchbox();
		    	controlTestProject.textbox();
		    	PlaywrightAssertions.assertThat(page.locator("#lblCap109381")).isVisible();
		    }
		    
		    
		    @Test(priority=4,dataProvider = "multilingualData", description = "Verify Multilingual Functionality")
	    	public void testMultilingualFunctionality(String MultilingualOption, String[] names) {
	    	
	    	// Multilingual Functionality
	    	log(Status.INFO, "Starting Multilingual Functionality Test with option: " + MultilingualOption);
	    	multilingualPage.selectMultilingualOption(MultilingualOption);
	    	// handling option
	    	if ("yes".equalsIgnoreCase(MultilingualOption)) {
	    		for(String name : names) {
	    		log(Status.INFO, "Verifying name: " + name);
	    		multilingualPage.multilingualFunctionality(names[0], names[1]);
	    		}
	    	} else if ("no".equalsIgnoreCase(MultilingualOption)) {
	    	    String singlename =	names[0];
	    	   	log(Status.INFO, "Verifying singlename: " + singlename);
	    	   	multilingualPage.multilingualFunctionality(singlename, singlename);
	    	}

}  @Test(priority = 5, description = "Verify caption font size")
public void testCaptionFontSize() {
    multilingualPage.verifyCaptionFontSize();
}

@Test(priority = 6, description = "Verify caption text color")
public void testCaptionTextColor() {
    multilingualPage.verifyCaptionTextColor();
}

@Test(priority = 7, description = "Verify caption background color")
public void testCaptionBackgroundColor() {
    multilingualPage.verifyCaptionBackgroundColor();
}

	    	 
	    	 @Test(priority=8, description = "Verify max length Functionality")
	    	 public void testMaxLengthFunctionality() {
	    		 			    		
	    		 multilingualPage.maxLength();
	    		 multilingualPage.incorrect_Length();
	    		 
	    	 }
	    	 
	    	 @Test(priority = 9, description = "Verify value font size")
	    	 public void testValueFontSize() {
	    	     multilingualPage.verifyValueFontSize();
	    	 }

	    	 
	    	 @Test(priority = 10, description = "Verify value text color")
	    	 public void testValueTextColor() {
	    	     multilingualPage.verifyValueTextColor();
	    	 }

	    	 @Test(priority = 11, description = "Verify value background color")
	    	 public void testValueBackgroundColor() {
	    	     multilingualPage.verifyValueBackgroundColor();
	    	 }

	    	 
	    	 @Test(priority = 12, description = "Verify the behavior of the 'Mandatory' property on the Textbox.")
	    	 public void testMaxLengthMandatoryValidation() {

	    	     multilingualPage.textboxmandatoryFieldValidation();
	    	 }

	    	 @Test(priority =13, description = "Verify the behavior of the 'Show Caption' property working correctly when I select show caption as ON.")
	    	    public void testverifyCaptionShowTest() {
	    	        multilingualPage.verifyCaptionShown();
	    	 
}
	    	 @Test(priority = 14, description = "Verify that the behavior of the 'Show Caption' property on the text box when I select DO NOT SHOW  option .")
	    	 public void testVerifyCaptionNotShown() {
	    	     multilingualPage.verifyCaptionNotShown();
	    	 }
	    	 @Test(priority = 15, description = "Verify that an error message is shown when an invalid email is entered and the form is not submitted.")
	    	 public void testInvalidEmailShowsErrorPopup(){
	    	     multilingualPage.InvalidEmailShowsErrorPopup();
	    	 }

	    	 @Test(priority = 16, description = "Verify that the form is submitted successfully when a valid email is entered.")
	    	 public void testValidEmailSubmitsFormSuccessfully(){
	    	     multilingualPage.ValidEmailSubmitsFormSuccessfully();
	    	 }

	    	 @Test( priority = 17, description = "Verify that on caption type  If I set Left then caption should left on textbox."
	    			)
	    			public void testCaptionIsDisplayedOnLeftOfTextbox() {
	    			    multilingualPage.CaptionIsDisplayedOnLeftOfTextbox();
	    			}

	    	 
	    	 @Test(
	    			    priority = 18,
	    			    description = "Verify the behavior of the 'Data Type' property on the Textbox for Alphanumeric  data type as Textbox can take both number and alphabets as input."
	    			)
	    			public void testVerifyAlphanumericDataTypeAllowsAlphaNumericInput()
{
	    			   
	    			    multilingualPage.VerifyAlphanumericDataTypeAllowsAlphaNumericInput();
	    			    multilingualPage.maxLength();
	    			    multilingualPage.saveBtn1_Click();
	    			}

	    	 @Test(priority = 19, description = "Verify the behavior of the 'Default Value' property on the Textbox.")
	    	 public void testDefaultValueVisible() {

	    	
	    		  multilingualPage.verifyTextboxDefaultValueIsPresent();
	    	 }
         
	    	 
	    	 @Test(priority = 20, description = "Verify the behavior of the 'Unique' property on the Textbox")
	    	 public void testUniqueProperty() {

	    	     multilingualPage.verifyDuplicateValueNotAllowedWhenUniqueIsEnabled();
	    	 }

	    	  @Test(priority=21, description = "Verify Caption Language When Multilingual is No")
	    	    public void verifyCaptionLanguageWhenMultilingualIsNo() {
			    	 page.waitForTimeout(3000);
	    		  controlTestProject.clipBar();
			    	controlTestProject.searchbox();
	    		  controlTestProject.radioBtn();
			    	 page.waitForTimeout(2000);
	    	        radiobuttonPage.verifySubjectCaptionIsEnglish();
	    	    }

	    	    
	    	    @Test(priority =22, description = "Verify caption supports spaces and special characters"
	    	    	)
	    	    	public void verifyCaptionSpecialCharactersSupport() {

	    	    	    radiobuttonPage.verifyCaptionAllowsSpecialCharactersAndSpaces();
	    	    	}
	    	   
	    	    @Test(
	    	    	    priority = 23,
	    	    	    description = "Verify default values are displayed as radio button options on UI"
	    	    	)
	    	    	public void verifyDefaultRadioButtonValues() {
	    	    	    radiobuttonPage.verifyRadioButtonDefaultValues();
	    	    	}
	    	         
	    	 

	    	    @Test(
	    	    	  priority = 24,
	    	    	    description = "Verify order of radio button options matches DEFAULT_VALUE"
	    	    	)
	    	    	public void verifyRadioButtonOrderTest() {
	    	    	    radiobuttonPage.verifyRadioButtonOrderEasy();
	    	    	}
	    	    @Test(
	    	    	    priority = 25,
	    	    	    description = "verifyNumericRadioOptionsTest"
	    	    	)
	    	    	public void verifyNumericRadioButtonOptionsTest() {

	    	    	    radiobuttonPage.verifyNumericRadioOptions();

	    	    	}
	    	    @Test(
	    	    	    priority = 26,
	    	    	    description = "Verify caption is NOT shown when Show Caption = DO NOT SHOW"
	    	    	)
	    	    	public void verifyRadioCaptionNotVisibleTest() {

	    	    	    radiobuttonPage.verifyRadioCaptionNotVisible(); 
	    	    	}
	    	}



	    	 





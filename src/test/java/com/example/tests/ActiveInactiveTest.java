
  package com.example.tests ;
  
  
  
 
  import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.example.pages.ActiveInactivePage;
  
  
  public class ActiveInactiveTest extends BaseTest {
  
	  LoginPage loginPage;
	  AdminRole adminRolePage;
	  ControlTestProject controlTestProject;
	  ActiveInactivePage activeInactivePage;

	  @BeforeClass
	  public void initPages() {
	      loginPage = new LoginPage(page);
	      adminRolePage = new AdminRole(page);
	      controlTestProject = new ControlTestProject(page);
	      activeInactivePage = new ActiveInactivePage(page);
	  }
  
		@DataProvider(name = "multilingualData")
		public Object[][] multilingualDataProvider() {
			return new Object[][] {
				{"yes", new String[] {"english", " हिंदी"}},
				{"no", new String[] {"singlename"}}
				
			};
		}

		 @Test(priority=1, description = "Naviagte to ActiveInactive form")
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
				    	controlTestProject.activeInactive();
				    	 page.waitForTimeout(2000);
		 }
		 @Test(priority = 2,
				 description = "Verify output textbox becomes active when user enters text in input textbox and clicks outside")
				 public void verifyActiveTextboxOnTextChangeTest() {

				    activeInactivePage.verifyActiveTextboxOnTextChange("Ankit");
				 }
		 
		 @Test(priority = 3,description = "Verify Inactive On Text Change functionality")
		 public void testVerifyInactiveOnTextChange() {

		     activeInactivePage.verifyInactiveOnTextChange("sample data");
		 }
		 
		 @Test(priority = 4, description = "Verify Active On Checkbox functionality")
		 public void testVerifyActiveOnCheckbox() {

		     activeInactivePage.verifyActiveOnCheckbox();
		 }
		 
		 @Test(priority = 5, description = "Verify Inactive On Checkbox functionality")
		 public void testVerifyInactiveOnCheckbox() {

		     activeInactivePage.verifyInactiveOnCheckbox();
		 }
		 
		 @Test(priority = 6, description = "Verify Active On Button Click functionality")
		 public void testActiveOnButtonClick() {
		     activeInactivePage.verifyActiveOnButtonClick();
		 }

		 @Test(priority = 7, description = "Verify Inactive On Button Click functionality")
		 public void testInactiveOnButtonClick() {
		     activeInactivePage.verifyInactiveOnButtonClick();
		     
		      }
		 
		 @Test(priority = 8, description = "Verify textbox becomes active when radio 'No' is selected")
		 public void testTextboxActive_OnRadioNo() {
		     activeInactivePage.verifyTextboxBecomesActive_OnRadioNoSelection();
		 }
		 
		 
		 @Test(priority = 9 , description = "Verify textbox becomes inactive when 'No' is selected in Inactive radio")
		 public void testTextboxInactive_OnInactiveRadioNo() {
		     activeInactivePage.verifyTextboxBecomesInactive_OnInactiveRadioNo();
		 }
		 
		 
		 @Test(priority = 10, description = "Verify textbox becomes active on clicking  label")
		 public void testTextboxActive_OnLabelClick() {
		     activeInactivePage.verifyTextboxBecomesActive_OnLabelClick();
		 }
		 @Test(priority = 11, description = "Verify textbox becomes inactive on clicking Inactive Label")
		 public void testTextboxInactive_OnLabelClick() {

		     activeInactivePage.verifyInactiveTextbox_OnLabelClick();

		 }
		 
		 
		  @Test(priority = 12, description = "Verify textbox becomes active on graph  click")
		 public void testTextboxActive_OnGraphClick() {
		     activeInactivePage.verifyTextboxBecomesActive_OnGraphClick();
		 }
		 
		 @Test(priority = 13, description = "Verify textbox becomes inactive on graph  click")
		 public void testTextboxInactive_OnGraphClick() {
		     activeInactivePage.verifyTextboxBecomesInactive_OnGraphClick();
		 }
		 
		 @Test(priority = 14, description = "Verify textbox becomes active on index change")
		 public void testTextboxActive_OnIndexChange() {

		     activeInactivePage.verifyTextboxBecomesActive_OnIndexChange();

		 }
		 
		 @Test(priority = 15, description = "Verify textbox becomes inactive on index change")
		 public void testTextboxInactive_OnIndexChange() {

		     activeInactivePage.verifyTextboxBecomesInactive_OnIndexChange();

		 }
		 
		 @Test(priority = 16, description = "Verify textbox becomes active on grid text change")
		 public void testTextboxActive_OnGridTextChange() {

		     activeInactivePage.verifyTextboxBecomesActive_OnGridTextChange();

		 }
		 @Test(priority = 17, description = "Verify textbox becomes inactive on grid text change")
		 public void testTextboxInactive_OnGridTextChange() {

		     activeInactivePage.verifyTextboxBecomesInactive_OnGridTextChange();

		 }
		 
		 @Test(priority = 18, description = "Verify textbox becomes active on file upload (capture)")
		 public void testTextboxActive_OnFileUpload() {

		     activeInactivePage.verifyTextboxBecomesActive_OnFileUpload();

		 }
		 }
 
  
  
  

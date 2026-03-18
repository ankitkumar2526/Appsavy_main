package com.example.tests;



//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.ShowHidePage;
import com.example.pages.LoginPage;


public class ShowHideTest extends BaseTest {

	LoginPage loginPage;
   AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    ShowHidePage showHidePage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        showHidePage = new ShowHidePage(page);
    }
    
	@DataProvider(name = "multilingualData")
	public Object[][] multilingualDataProvider() {
		return new Object[][] {
			{"yes", new String[] {"english", " हिंदी"}},
			{"no", new String[] {"singlename"}}
			
		};
	}

	 @Test(priority=1, description = "Naviagte to showHide (action) form")
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
			    	controlTestProject.showHide();
			    	 page.waitForTimeout(2000);
	 }
	 
	 
	 
	 @Test(priority = 2, description = "Verify Show label is visible after typing in textbox")
	 public void verifyShowLabelOnTypingTest() {

	     showHidePage.verifyShowLabelOnTyping("Ankit");

	 }
	 
	 
	 
	 @Test(priority = 3, 
			 description = "Verify Hide label is hidden after typing in textbox")
			 public void verifyHideLabelOnTypingTest() {

			     showHidePage.verifyHideLabelOnTyping("Ankit");
			 }
	 
	 @Test(priority = 4, 
			 description = "Verify label becomes visible after selecting checkbox")
			 public void verifyShowLabelOnCheckboxSelectTest() {

			     showHidePage.verifyShowLabelOnCheckboxSelect();
			 }
	 
	 @Test(priority = 5, 
			 description = "Verify HideLabelOnCheckboxChange is visible initially and gets hidden after selecting checkbox")
			 public void verifyHideLabelOnCheckboxSelectTest() {

			     showHidePage.verifyHideLabelOnCheckboxSelect();
			 }
}
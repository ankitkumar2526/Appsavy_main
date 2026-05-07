
  package com.example.tests ;
  
  
  
 
  import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.example.pages.ShowHidePage;
  
  
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
  @Test(priority = 6,
	      description = "Verify label becomes visible after clicking on Show button")
	public void verifyShowLabelOnButtonClickTest() {

	    showHidePage.verifyShowLabelOnButtonClick();
	}
  
  @Test(priority = 7,
	      description = "Verify label becomes hidden after clicking on Hide button")
	public void verifyHideLabelOnButtonClickTest() {

	    showHidePage.verifyHideLabelOnButtonClick();
	}
  
  @Test(priority = 8,
	      description = "Verify label becomes visible after clicking on  radio button")
	public void verifyShowLabelOnRadioButtonClickTest() {

	    showHidePage.verifyShowLabelOnRadioButtonClick();
	}
  
  @Test(priority = 9,
	      description = "Verify label becomes hidden after clicking radio button")
	public void verifyHideLabelOnRadioButtonClickTest() {

	    showHidePage.verifyHideLabelOnRadioButtonClick();
	}
  @Test(priority = 10,
	      description = "Verify label becomes visible after clicking on YES,NO label")
	public void verifyShowLabelOnLabelClickTest() {

	    showHidePage.verifyShowLabelOnLabelClick();
	}
  @Test(priority = 11,
	      description = "Verify label becomes hidden after clicking on YES,NO label")
	public void verifyHideLabelOnLabelClickTest() {

	    showHidePage.verifyHideLabelOnLabelClick();
	}
  
  @Test(priority = 12,
	      description = "Verify label becomes visible after clicking on graph")
	public void verifyShowLabelOnGraphClickTest() {

	    showHidePage.verifyShowLabelOnGraphClick();
	}
  
  @Test(priority = 13,
	      description = "Verify label becomes hidden after clicking on Hide graph")
	public void verifyHideLabelOnGraphClickTest() {

	    showHidePage.verifyHideLabelOnGraphClick();
	}
 
  @Test(priority = 14,
	      description = "Verify label becomes visible on dropdown index change")
	public void verifyShowLabelOnSelectIndexChangeTest() {

	    showHidePage.verifyShowLabelOnSelectIndexChange();
	}
  
  
  @Test(priority = 15, description = "Verify label hides on dropdown index change")
	public void verifyHideLabelOnSelectIndexChangeTest() {

	    showHidePage.verifyHideLabelOnSelectIndexChange();
	}
  
  @Test(priority = 16, description = "Verify label becomes visible after upload")
	public void verifyShowLabelAfterUploadTest() {

	    String filePath = "C:\\Users\\DELL\\OneDrive - Mobineers Info Systems Pvt Ltd\\Pictures\\Screenshots\\Screenshot 2025-12-04 131820.png";

	    showHidePage.verifyShowLabelAfterUpload(filePath);
	}
	
	  @Test(priority = 17, description = "Verify label hides after upload") public
	  void verifyHideLabelAfterUploadTest() {
	  
	  String filePath =
	  "C:\\Users\\DELL\\OneDrive - Mobineers Info Systems Pvt Ltd\\Pictures\\Screenshots\\Screenshot 2025-12-04 131820.png"
	  ;
	  
	  showHidePage.verifyHideLabelAfterUpload(filePath); }
	 
  
  
  
  
  @Test(priority = 18, description = "Verify label appears after entering text in grid textbox")
  public void verifyShowLabelOnGridTextButtonClickTest() {

      showHidePage.verifyShowLabelOnGridTextButtonClick("Ankit");

  }
  
  @Test(priority = 19, description = "Verify label hides after clicking on grid text and blur event")
  public void verifyHideLabelOnGridTextButtonClickTest() {

      showHidePage.verifyHideLabelOnGridTextButtonClick();
  }
  
 }
 
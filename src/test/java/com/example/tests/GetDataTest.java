package com.example.tests;



//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.GetDataPage;



import com.example.pages.LoginPage;


public class GetDataTest extends BaseTest {

	LoginPage loginPage;
   AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    GetDataPage getDataPage;
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
        adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        getDataPage = new GetDataPage(page);
    }
    
	@DataProvider(name = "multilingualData")
	public Object[][] multilingualDataProvider() {
		return new Object[][] {
			{"yes", new String[] {"english", " हिंदी"}},
			{"no", new String[] {"singlename"}}
			
		};
	}

	 @Test(priority=1, description = "Naviagte to getdata (action) form")
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
			    	controlTestProject.getData();
			    	 page.waitForTimeout(2000);
	 }
	 

	 @Test(priority = 2,
			 description = "Verify GetData is triggered when typing in Name textbox and dropdown values are loaded dynamically")
			 public void verifyGetDataTriggeredOnTyping() {
		 getDataPage.verifyGetDataTriggeredOnTyping("Ankit");
			     }
	 
	 
	 @Test(
			 priority = 3,
			 description = "Verify GetData is triggered when checkbox is clicked and Subjects dropdown values load from backend"
			 )
			 public void verifyGetDataTriggeredOnCheckboxChange() {

			     getDataPage.verifyGetDataTriggeredOnCheckboxChange();

			 }
	 @Test(
			 priority = 4,
			 description = "Verify Days dropdown is empty before clicking GetData button and loads values after button click"
			 )
			 public void verifyGetDataTriggeredOnButtonClickLoadsDaysDropdown() {

			     getDataPage.verifyGetDataTriggeredOnButtonClickLoadsDaysDropdown();

			 }
	 
@Test(
		priority = 5,
		description = "Verify Festivals dropdown loads values after selecting row from grid"
		)

		public void verifyGetDataTriggeredOnGridbuttonClickLoadsFestivalsDropdown() {

		    getDataPage.verifyGetDataTriggeredOnGridbuttonClickLoadsFestivalsDropdown();

		}


@Test(
priority = 6,
description = "Verify Fruits dropdown loads values after clicking APPLE label"
)

public void verifyGetDataTriggeredOnLabelClickLoadsFruitsDropdown() {

    getDataPage.verifyGetDataTriggeredOnLabelClickLoadsFruitsDropdown();

}


@Test(
priority = 7,
description = "Verify Spices dropdown loads values after clicking GARLIC radio button"
)

public void verifyGetDataTriggeredOnRadioButtonClickLoadsSpicesDropdown() {

    getDataPage.verifyGetDataTriggeredOnRadioButtonClickLoadsSpicesDropdown();

}



@Test(
priority = 8,
description = "Verify Group dropdown loads values after selected index change"
)

public void verifyGetDataTriggeredOnSelectedIndexChangeLoadsGroupDropdown() {

    getDataPage.verifyGetDataTriggeredOnSelectedIndexChangeLoadsGroupDropdown();

}


@Test(
priority = 9,
description = "Verify Result dropdown loads values after clicking GetDataOnGraphClick graph"
)

public void verifyGetDataTriggeredOnGraphClickLoadsResultDropdown() {

    getDataPage.verifyGetDataTriggeredOnGraphClickLoadsResultDropdown();

}




@Test(
priority = 10,
description = "Verify Vegetables dropdown loads values after uploading document in GetData capture"
)

public void verifyGetDataTriggeredAfterDocumentUploadLoadsVegetablesDropdown() {

    getDataPage.verifyGetDataTriggeredAfterDocumentUploadLoadsVegetablesDropdown();

}


@Test(
priority = 11,
description = "Verify GetData is triggered automatically on page load and dropdown values are loaded"
)

public void verifyGetDataTriggeredOnPageLoad() {

    getDataPage.verifyGetDataTriggeredOnPageLoad();

}

















}






 
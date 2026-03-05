package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.example.pages.AdminRole;
import com.example.pages.CheckBoxPage;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.LoginPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class GridTest extends BaseTest {
	LoginPage loginPage;
	AdminRole adminRolePage;
	ControlTestProject controlTestProject;
	CheckBoxPage checkBoxPage;

	@BeforeClass
	public void initPages() throws InterruptedException {
		loginPage = new LoginPage(page);
		adminRolePage = new AdminRole(page);
		controlTestProject = new ControlTestProject(page);
		Thread.sleep(2000);
		checkBoxPage = new CheckBoxPage(page);

	}

	@Test(priority = 1, description = "Verify Admin Role Functionality")
	public void loginFunctionality() {

		loginPage.navigate();
		loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
	}

	@Test(priority = 2, description = "Verify Admin Role Functionality")
	public void testAdminRole() {

		adminRolePage.clickAdmin1();
		log(Status.INFO, "Clicked on Admin1");
		page.waitForTimeout(5000);
	}
	@Test(priority = 3, description = "Verify Control Test Functionality")
	public void testControlTestProject() {
		// Click on Admin1
		controlTestProject.clipBar();
		checkBoxPage.searchbox();
		checkBoxPage.CheckBox();
		page.waitForTimeout(2000);
		PlaywrightAssertions.assertThat(page.locator("#proAppName")).isVisible();
	}
	@Test(priority=4, description="Verify Grid Form Successfully Open")
	public void verify_GridForm_SuccessfullyOpen(){	
//		 page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("fa-bars")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("GridTest4Dec");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("GridTest4Dec").setExact(true)).click();
	      String pageTitle = page.title();
	      System.out.println("Page Title is: " + pageTitle);
	      Assert.assertEquals(pageTitle, "GridTest4Dec");
	    System.out.println("clickOn4decForm finished...");
	}
	@Test(priority = 5, description = "verifying translator is working fine for checkbox control")
    void verifyTranslatorWorking() throws InterruptedException {
    	   page.getByText("chkbox_9sep", new Page.GetByTextOptions().setExact(true));   
//           page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("GridTest4Dec");
//           page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("GridTest4Dec").setExact(true)).click();
           page.locator("#ddllanguage").selectOption("2");
           page.getByText("नाम लेबल").click();

Locator el = page.locator("#lblCap109289");

// Actual text nikalo
String actualText = el.textContent().trim();

// Expected text
String expectedText = "नाम लेबल";

// Boolean assertion
Assert.assertTrue(actualText.equals(expectedText),
        "❌ Text match nahi hua. Actual: " + actualText + " | Expected: " + expectedText);

System.out.println("✅ Text successfully verified: " + actualText);

	}
  
   @Test(priority = 6)
    public void verifyGridCaptionFontSize(){
//	   page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("fa-bars")).click();
//	   page.getByText("GRIDTEST_29SEP", new Page.GetByTextOptions().setExact(true));   
       page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("GRIDTEST_29SEP");
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("GRIDTEST_29SEP").setExact(true)).click();
     
  	    String ActualfontSize = page.evaluate(
  	            "el => window.getComputedStyle(el).fontSize",
  	            page.locator("#gview_tbl108710").elementHandle()
  	    ).toString();

  	    System.out.println("Font Size................................: " + ActualfontSize);
   String expectedFontSize = "13px";

  Assert.assertEquals(ActualfontSize, expectedFontSize, "Font size is not matching");
    }
   
    @Test(priority = 7)
    public void verifyGridCaptionFontColor(){

    	    String actualBgColor = (String) page.evaluate(
    	        "id => window.getComputedStyle(document.getElementById(id)).backgroundColor",
    	        "gview_tbl108710"
    	    );

    	    String expectedBgColor = "rgba(0, 0, 0, 0)"; // change as per UI

    	    System.out.println("Background Color: " + actualBgColor);

    	    Assert.assertEquals(
    	        actualBgColor,
    	        expectedBgColor,
    	        "Background color is not matching"
    	    );
  	  
    }
	@Test(priority = 8, description = "verifying that checkbox is enabled on the form")
	public void verifyGridEnabled() {	
		  page.getByText("GRIDTEST_29SEP", new Page.GetByTextOptions().setExact(true));   
           page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("GRIDTEST_29SEP");
           page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("GRIDTEST_29SEP").setExact(true)).click();
         
		    // 1️⃣ Locate element by ID
		    Locator checkboxLabel = page.locator("#gview_tbl108710");

		    // 2️⃣ Wait until visible
		    checkboxLabel.waitFor();
		    System.out.println("Element gview_tbl108710 found");

		    // 3️⃣ Assertions (equivalent to Appium)
		    Assert.assertTrue(
		            checkboxLabel.isVisible(),
		            "❌ Checkbox label should be visible"
		    );

		    Assert.assertTrue(
		            checkboxLabel.isEnabled(),
		            "❌ Checkbox label should be enabled"
		    );

		    // 4️⃣ Logs (same as your code)
		    System.out.println("isDisplayed: " + checkboxLabel.isVisible());
		    System.out.println("isEnabled: " + checkboxLabel.isEnabled());

		    // 5️⃣ Navigate back (browser equivalent)
		    page.goBack();
		

	}
}

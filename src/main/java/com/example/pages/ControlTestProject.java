package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class ControlTestProject {
	
	private Locator  fn_line ;
	private Locator search ;
	private Locator user;
	private Locator txt_box;
	private Locator rd_btn;
	private Locator mul_Text; 
	private Locator headingLabel;
	private Locator drp_dwn;

	
	
	private final Page page ;
	
	public ControlTestProject(Page page)
	{
		this.page=page;
	}
	
	
	
      public void clipBar ()
      {
		  fn_line=page.locator("#clpsBar"); 
		   fn_line.click();
	  }
      
      public void searchbox ()
	  {
		  search=page.getByPlaceholder("Search");
		  search.fill("Ankit test menu");
		  PlaywrightAssertions.assertThat(page.locator("#span11773")).isVisible();
		  
	  }
      public void contest_Searchbox ()
	  {
		  search=page.getByPlaceholder("Search");
		  search.fill("contest");
		  PlaywrightAssertions.assertThat(page.locator("#span665")).isVisible();
		  
	  }
      
      public void textbox()
      {
		  user=page.locator("#span11773");
		  user.click();
		  
		  txt_box=page.locator("#a33762");
		  txt_box.click();
	  }
      
      public void radioBtn()
      {
		  user=page.locator("#span11773");
		 user.click();
		  
		  rd_btn=page.locator("#a33766");
		 rd_btn.click();
	  }
      public void multilineTextbox()
      {
		  user=page.locator("#span11773");
		 user.click();
		  
		 mul_Text = page.locator("#a33767");
		 mul_Text.click();
	  }
      
      public void headingLabel()
      {
          user = page.locator("#span11773");
          user.click();

          headingLabel = page.locator("#a33768"); 
          headingLabel.click();
      }
      public void dropDown()
      {
          user = page.locator("#span11773");
          user.click();

          drp_dwn = page.locator("#a33769"); 
          drp_dwn.click();
      }
      
      public void AddButton()
      {
          user = page.locator("#span665");
          user.click();

          drp_dwn = page.locator("#a33721"); 
          drp_dwn.click();
      }
      
      
      public void UpdateButton()
      {
          user = page.locator("#span665");
          user.click();

          drp_dwn = page.locator("#a33719"); 
          drp_dwn.click();
      }
      
      
      public void SaveButton()
      {
          user = page.locator("#span665");
          user.click();

          drp_dwn = page.locator("#a33716"); 
          drp_dwn.click();
      }
      
      public void textbox2()
      {
		  user=page.locator("#span11773");
		  user.click();
		  
		  txt_box=page.locator("#a33775");
		  txt_box.click();
	  }
      
      public void getData()
      {
		  user=page.locator("#span665");
		  user.click();
		  
		  txt_box=page.locator("#a33783");
		  txt_box.click();
	  }
      
      public void showHide()
      {
		  user=page.locator("#span665");
		  user.click();
		  
		  txt_box=page.locator("#a33799");
		  txt_box.click();
	  }
      
      
}

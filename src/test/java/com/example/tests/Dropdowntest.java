package com.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.pages.AdminRole;
import com.example.pages.ConfigReader;
import com.example.pages.ControlTestProject;
import com.example.pages.Dropdown;
import com.example.pages.LoginPage;



public class Dropdowntest extends BaseTest {

	LoginPage loginPage;
    AdminRole adminRolePage;
    ControlTestProject controlTestProject;
    Dropdown dropdownpage ;
   
   
    
    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(page);
       adminRolePage = new AdminRole(page);
        controlTestProject = new ControlTestProject(page);
        dropdownpage = new Dropdown(page);
        

        
    }
  
    
    @Test(priority=1, description = "Naviagte to Dropdown form")
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
   		    	controlTestProject.dropDown();
   		    	 page.waitForTimeout(2000);
    }
    
    

}

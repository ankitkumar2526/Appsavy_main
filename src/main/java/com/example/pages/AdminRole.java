package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AdminRole {
	private Locator  admin1 ;
	private Locator admin2 ;
	private final Page page ;
	
	public AdminRole(Page page)
	{
		this.page=page;
	}
	
	
	public void clickAdmin1( )
	{
		admin1=page.locator("xpath=//div[@id='divinnerDiv0']//a[1]");
		admin1.click();
				
	}

	public void clickAdmin2( )
	{
		admin2=page.locator("#divouterDiv1");
		admin2.click();
		 
	}
}
           

package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class GridPage {
	private Locator search;
	private Locator user;
	private Locator lbl_txt_box;

	private final Page page;

	public GridPage(Page page) {
		this.page = page;
	}
	
	public void searchbox() {
		search = page.getByPlaceholder("Search");
		search.fill("GridTest4Dec");
		PlaywrightAssertions.assertThat(page.locator(".fclick")).isVisible();

	}

	public void grid() {
		user = page.locator(".fclick");// this is the ID when form name appears after searching for the form
		user.click();
		page.waitForTimeout(2000);
//			  lbl_txt_box=page.locator("#ctrl109307");//ID for the control NAME onn the form LabelTesting2Jan26
//			  lbl_txt_box.fill("Label Testing");//Providing the input for the control NAME
//			  	page.waitForTimeout(2000);
	}
	
}

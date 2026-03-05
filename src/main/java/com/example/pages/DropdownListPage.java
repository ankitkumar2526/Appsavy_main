package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class DropdownListPage {
	private Locator search;
	private Locator user;
	

	private final Page page;

	public DropdownListPage(Page page) {
		this.page = page;
	}

	public void searchbox() {
		search = page.getByPlaceholder("Search");
		search.fill("LabelTesting2Jan26");
		PlaywrightAssertions.assertThat(page.locator(".fclick")).isVisible();

	}
}

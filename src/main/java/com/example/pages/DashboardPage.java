package com.example.pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
    private final Page page;

    private final String headerLocator = "h2";
    private final String logoutLinkLocator = "a[href='/logout']";

    public DashboardPage(Page page) {
        this.page = page;
    }

    public String getHeaderText() {
        return page.innerText(headerLocator).trim();
    }

    public boolean isDashboardLoaded() {
        return page.isVisible(logoutLinkLocator);
    }
}
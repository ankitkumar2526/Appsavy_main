package com.example.pages;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;


public class LoginPage {
    private final Page page;

    private final String usernameLocator = "#txtUserName";
    private final String passwordLocator = "#txtPassword";
    private final String loginButtonLocator = "#btnlogin";
    private final String successMessageLocator = "#lblProjectName";
   final String errorMessageLocator = ".flash.error";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigate() {
//    	System.out.println("Navigating to login page: " + ConfigReader.get("login.url"));
     //   page.navigate(ConfigReader.get("login.url"));
        
    
    		 
    	    String url = ConfigReader.get("login.url");
    	    System.out.println("Navigating to login page: " + url);
    	 
    	    page.navigate(url, new Page.NavigateOptions()
    	            .setWaitUntil(WaitUntilState.NETWORKIDLE));
    	}
       
    
    
    

    public void login(String username, String password) {
        page.fill(usernameLocator, username);
        page.fill(passwordLocator, password);
        page.click(loginButtonLocator);
        page.waitForTimeout(5000);
    }

    public boolean isLoginSuccessful() {
        return page.isVisible(successMessageLocator);
    }

    public String getMessageText() {
        if (page.isVisible(successMessageLocator)) {
            return page.innerText(successMessageLocator).trim();
        } else if (page.isVisible(errorMessageLocator)) {
            return page.innerText(errorMessageLocator).trim();
        }
        return "No message found";
    }
    
    
    

}
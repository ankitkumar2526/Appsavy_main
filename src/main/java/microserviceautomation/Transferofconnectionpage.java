package microserviceautomation;

import com.microsoft.playwright.Page;

import java.security.PrivateKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;

public class Transferofconnectionpage {

    private Page page;

    // Locators
    private Locator project;
    private Locator requestType;
    private Locator mobile;
    private Locator account;
    private Locator searchBtn1;
    private Locator searchBtn2;
    private Locator searchBtn3;
    private Locator fillForm;
    private Locator alternateMobile;
    private Locator reasonForLoadChange;
    private Locator currentLoad;
    private Locator saveBtn;
    private Locator twainPopupClose;
    private Locator clpsBar;
    private Locator checkStatus;
    private Locator applicationNumberField;
    private Locator statusSearchBtn;
    private Locator userIcon;
    private Locator backToProjectList;
    private Locator actionOnService;
    private Locator actionGridSearch;
    private Locator meterChangeRequired;
    private Locator augmentationRequired;
    private Locator remarks;
    private Locator finalSaveBtn;
    private Locator applicationNumberSearch;
    private Locator searchBtn;

    private String complaintNumber;
 
    
  
    private String requestValue = "Load Change";
    private String mobileNumber = "9889451451";
    private String accountNumber = "5045101000";
    private String alternateMobileNumber = "9812141092";
    private String reasonValue = "ok";
    private String currentLoadValue = "4";
    private String projectLoginRole;

 
    public Transferofconnectionpage (Page page) {

        this.page = page;
        project =  page.locator("#divcfoot336");
        requestType = page.locator("#ctrl126880");
        mobile = page.locator("#ctrl130315");
        account = page.locator("#ctrl127515");
        searchBtn1 = page.locator("#ctrl130316");
        searchBtn2 = page.locator("#ctrl127511");
        searchBtn3 = page.locator("#button_24981_1");
        fillForm = page.locator("#ctrl126896");
        alternateMobile = page.locator("#ctrl129643");
        reasonForLoadChange = page.locator("#ctrl126676");
        currentLoad = page.locator("#ctrl126672");
        saveBtn = page.locator("#ctrl126673");
        twainPopupClose = page.locator(".dynamsoft-dialog-close");
        clpsBar = page.locator("#clpsBar");
        checkStatus = page.locator("#a12347");
        applicationNumberField = page.locator("#ctrl130253");
        statusSearchBtn = page.locator("#ctrl130252");
        userIcon = page.locator("#usericon");
        backToProjectList = page.locator("#btnbak");
        actionOnService = page.locator("#a12312");
        actionGridSearch = page.locator("input[type='search']");
        meterChangeRequired = page.locator("#ctrl129480");
        augmentationRequired = page.locator("#ctrl129481");
        remarks = page.locator("#ctrl128727");
        finalSaveBtn =  page.locator("#ctrl128728");
        applicationNumberSearch =  page.locator("#ctrl130253");
        searchBtn =  page.locator("#ctrl130252");
    }}
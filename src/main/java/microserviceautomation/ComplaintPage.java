package microserviceautomation;

import com.microsoft.playwright.Page;

import java.security.PrivateKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;

public class ComplaintPage {

    private Page page;

    // Locators
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

 
    public ComplaintPage(Page page) {

        this.page = page;

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
    }

      
  public void performComplaintFlow() {

    
        requestType.selectOption(requestValue);
        mobile.type(mobileNumber);
        searchBtn1.click();
        page.waitForTimeout(2000);
        account.type(accountNumber);
        searchBtn2.click();
        page.waitForTimeout(3000);
        searchBtn3.click();
        page.waitForTimeout(2000);
        
        
        handleFillFormPopups();

        Locator closePopup = page.locator(".dynamsoft-dialog-close");
        closePopup.waitFor();
        closePopup.click();
        System.out.println("TWAIN Popup Closed");
        page.waitForTimeout(5000);
        
        alternateMobile.type(alternateMobileNumber);
        reasonForLoadChange.type(reasonValue);
        currentLoad.type(currentLoadValue);
        page.waitForTimeout(2000);

        handleSavePopups();


        // ================= AGAIN TWAIN POPUP =================

        twainPopupClose.waitFor();
        twainPopupClose.click();
        page.waitForTimeout(5000);
        

System.out.println("Opening Left Menu");
clpsBar.click();
page.waitForTimeout(3000);

System.out.println("Opening Check Status");
checkStatus.click();
page.waitForTimeout(5000);


System.out.println( "Entering Complaint Number : " + complaintNumber);
applicationNumberField.fill( complaintNumber);
page.waitForTimeout(2000);


// ================= CLICK SEARCH =================

statusSearchBtn.click();
page.waitForTimeout(5000);


//================= VALIDATION =================

String fullPageText = page.textContent("body");

System.out.println(fullPageText);

//===== PROJECT LOGIN ROLE FETCH =====

String projectLoginRole = "";

Pattern pattern = Pattern.compile("[A-Z]{2}_[A-Z]{2}_\\d+");

Matcher matcher =
      pattern.matcher(fullPageText);

if (matcher.find()) {

  projectLoginRole =
          matcher.group();

}

System.out.println(
      "Project Login Role : "
              + projectLoginRole);

//===== VALIDATION =====

if (!projectLoginRole.isEmpty()) {

  System.out.println(
          "Complaint Successfully Routed To "
                  + projectLoginRole);

  System.out.println(
          "Complaint Flow Working Fine");

} else {

  System.out.println(
          "Complaint NOT Routed");
}
    
    userIcon.click();

    page.waitForTimeout(2000);

    backToProjectList.click();

    page.waitForTimeout(5000);
    page.locator(
            "text=" + projectLoginRole)
            .click();

    page.waitForTimeout(5000);
    
    
    System.out.println("Opening Left Menu");

    clpsBar.click();
    
    System.out.println(
            "Opening Action On Service");

    actionOnService.click();

    page.waitForTimeout(5000);
    
    clickDynamicViewButton();
    openLatestComplaintFromGrid();
    fillComplaintDetails();
    completeComplaintAndVerifyStatus();
    }
    
    
     private void handleFillFormPopups() {

        page.onceDialog(dialog -> {

            System.out.println(
                    "Fill Popup : "
                            + dialog.message());

            dialog.accept();

        });

        fillForm.click();

        page.waitForTimeout(5000);
    }
    
    
    
    private void handleSavePopups() {

        final int[] popupCount = {0};

        page.onDialog(dialog -> {

            popupCount[0]++;

            String popupText = dialog.message();

            System.out.println(
                    "SAVE POPUP " +
                            popupCount[0] +
                            " : " +
                            popupText);

            // ===== SECOND POPUP =====

            if (popupCount[0] == 2) {

                if (popupText.contains("KSLC")) {

                    int index =
                            popupText.indexOf("KSLC");

                    complaintNumber =
                            popupText.substring(index)
                                    .replaceAll("[^A-Z0-9]", "")
                                    .trim();

                    System.out.println(
                            "Complaint Number : "
                                    + complaintNumber);
                }
            }

            dialog.accept();
        });

        saveBtn.scrollIntoViewIfNeeded();

        page.waitForTimeout(2000);

        saveBtn.click();

        page.waitForTimeout(8000);
    }


public void clickDynamicViewButton() {

    System.out.println(
            "Finding Request Type : "
                    + requestValue);

    Locator row =
            page.locator("table tbody tr")
                    .filter(
                            new Locator.FilterOptions()
                                    .setHasText(requestValue))
                    .first();

    row.scrollIntoViewIfNeeded();

    page.waitForTimeout(2000);

    System.out.println(
            "Clicking VIEW Button");

    row.locator("text=View")
            .click();

    page.waitForTimeout(5000);
}
public void openLatestComplaintFromGrid() {

	 System.out.println(
	            "Opening Latest Complaint From Grid");

	    page.waitForTimeout(5000);

	    // ===== PAGE HORIZONTAL SCROLL =====

	    System.out.println(
	            "Scrolling To Right Side");

	    page.evaluate(
	            "window.scrollTo(document.body.scrollWidth, 0)");

	    page.waitForTimeout(3000);

	    // ===== LAST ROW =====

	    Locator lastRow =
	            page.locator("table tbody tr")
	                    .last();

	    String latestApplicationNumber =
	            lastRow.locator("td")
	                    .nth(0)
	                    .textContent()
	                    .trim();

	    System.out.println(
	            "Latest Application Number : "
	                    + latestApplicationNumber);

	    // ===== DETAILS BUTTON =====

	    Locator detailsButton =
	            lastRow.locator("text=Details");

	    detailsButton.scrollIntoViewIfNeeded();

	    page.waitForTimeout(2000);

	    System.out.println(
	            "Clicking Details Button");

	    detailsButton.click();

	    page.waitForTimeout(5000);
	}

public void fillComplaintDetails() {

	

	    System.out.println(
	            "Scrolling Down");

	    page.mouse().wheel(0, 1000);

	    page.waitForTimeout(3000);

	    System.out.println(
	            "Filling Complaint Details");

	    // ===== METER CHANGE REQUIRED =====

	    System.out.println(
	            "Selecting Meter Change Required : No");

	    meterChangeRequired.selectOption("No");

	    page.waitForTimeout(2000);

	    // ===== AUGMENTATION REQUIRED =====

	    System.out.println(
	            "Selecting Augmentation Required : No");

	    augmentationRequired.selectOption("No");

	    page.waitForTimeout(2000);

	    // ===== REMARKS =====

	    System.out.println(
	            "Entering Remarks");

	    remarks.fill("ok");

	    page.waitForTimeout(2000);

	    // ===== SAVE =====

	  
	}

public void completeComplaintAndVerifyStatus() {

    // ===== SAVE POPUP 1 =====



	    System.out.println(
	            "Clicking Final Save Button");

	    finalSaveBtn.scrollIntoViewIfNeeded();

	    page.waitForTimeout(2000);

	    finalSaveBtn.click();

	    page.waitForTimeout(8000);

	    // ===== CLICK CHECK STATUS =====

	    System.out.println(
	            "Opening Check Status");

	    checkStatus.click();

	    page.waitForLoadState();

	    page.waitForTimeout(5000);

	    // ===== SEARCH APPLICATION NUMBER =====

	    System.out.println(
	            "Searching Application Number : "
	                    + complaintNumber);

	    applicationNumberSearch.fill(
	            complaintNumber);

	    page.waitForTimeout(2000);

	    // ===== CLICK SEARCH =====

	    System.out.println(
	            "Clicking Search Button");

	    searchBtn.click();

	    page.waitForTimeout(5000);

	    // ===== VERIFY STATUS =====

	    System.out.println(
	            "Scrolling To Right For Status");

	    page.evaluate(
	            "window.scrollTo(document.body.scrollWidth, 0)");

	    page.waitForTimeout(3000);


	    // ===== VERIFY STATUS =====

	    Locator status =
	            page.locator("td")
	                    .filter(new Locator.FilterOptions()
	                    .setHasText("CLOSED"))
	                    .first();

	    String actualStatus =
	            status.textContent().trim();

	    System.out.println(
	            "Final Complaint Status : "
	                    + actualStatus);
	}}
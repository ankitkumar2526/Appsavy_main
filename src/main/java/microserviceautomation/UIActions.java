package microserviceautomation;

import com.microsoft.playwright.Page;

public class UIActions {

    private RoleActionPage rolePage;
    private ComplaintPage complaintPage;

    public UIActions(Page page) {
        rolePage = new RoleActionPage(page);
        complaintPage = new ComplaintPage(page);
    }

    public void navigateToHelpDesk() {
        rolePage.openHelpDesk();
    }

    public void fillComplaintFlow() {
        complaintPage.performComplaintFlow();
    }

  
}
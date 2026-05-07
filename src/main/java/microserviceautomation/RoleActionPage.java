package microserviceautomation;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class RoleActionPage {

    private Page page;

    public RoleActionPage(Page page) {
        this.page = page;
    }

  
    public void openHelpDesk() {

      
        Locator project =  page.locator("#divcfoot336");
        project.waitFor();
        project.click();
        page.waitForTimeout(3000);

     
        Locator helpDesk = page.locator("text=HELPDESK");
         helpDesk.scrollIntoViewIfNeeded();
         page.waitForTimeout(2000);
          helpDesk.click();
          page.waitForLoadState();

      
    }
}
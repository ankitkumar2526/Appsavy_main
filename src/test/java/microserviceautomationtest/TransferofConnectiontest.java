
package microserviceautomationtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import microserviceautomation.BaseTest;
import microserviceautomation.UIActions;

public class TransferofConnectiontest {

    @Test(description = "Verify Complaint load chnage Flow Working Properly")
    public void testComplaintFlow() {

        UIActions ui = new UIActions(page);

        ui.navigateToHelpDesk();
        ui.Transferofconnectionpage();
         System.out.println(" Complaint for load chnage Working Fine");
    }
}
package microserviceautomationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import microserviceautomation.BaseTest;
import microserviceautomation.UIActions;

public class RoleBased extends BaseTest {

    @Test
    public void testRoleAccess() {

    	UIActions  ui = new UIActions (page);

        ui.navigateToHelpDesk();

        // Verify role text
        Assert.assertTrue(
                page.locator("text=Help Desk Executive").isVisible()
        );

        System.out.println("✅ Role Access Verified");
    }
}
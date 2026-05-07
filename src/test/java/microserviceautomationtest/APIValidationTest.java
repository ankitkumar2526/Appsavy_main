package microserviceautomationtest;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class APIValidationTest {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("http://172.30.0.63/");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("UserID")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("UserID")).fill("9992233321");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).press("CapsLock");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("A");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).press("CapsLock");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Ankitmehta@123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" LOG IN")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kesco EOL App KESCO EOL APP")).click();
      page.getByText("HELPDESK[ HELP_DESK ]").click();
      page.locator("#ctrl126880").selectOption("6");
      page.locator("#ctrl130315").click();
      page.locator("#ctrl130315").fill("9992233321");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Search")).click();
      page.locator("#ctrl127515").click();
      page.locator("#ctrl127515").fill("5045101000");
      page.locator("#ctrl127511").click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select")).click();
      page.onceDialog(dialog -> {
        System.out.println(String.format("Dialog message: %s", dialog.message()));
        dialog.dismiss();
      });
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Fill Form")).click();
      page.navigate("http://172.30.0.63/UI/Form?FormId=12091&129642=9026516366&126674=2.000000&126963=&126962=&126978=6&126677=81-A-SARAI%20MASWANPURKANPUR%20%20KANPUR%20NAGARKANPUR%20NAGAR%20UP%20%20%20%20IND%20&126675=5045101000&126670=SHANTI%20DEVI");
      page.locator(".dynamsoft-dialog-close").click();
      page.locator("#ctrl129643").click();
      page.locator("#ctrl129643").click();
      page.locator("#ctrl129643").fill("9812141092");
      page.locator("#ctrl126676").dblclick();
      page.locator("#ctrl126676").fill("1");
      page.locator("#ctrl126672").dblclick();
      page.locator("#ctrl126672").fill("1");
      page.onceDialog(dialog -> {
        System.out.println(String.format("Dialog message: %s", dialog.message()));
        dialog.dismiss();
      });
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Save")).click();
      page.navigate("http://172.30.0.63/UI/Form?FormId=12091");
      page.locator(".dynamsoft-dwt-dlg-header").click();
      page.locator(".dynamsoft-dialog-close").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("fa-bars")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Check Status")).click();
      page.locator("#ctrl130253").dblclick();
      page.locator("#ctrl130253").fill(" KSLC070526001");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" SEARCH")).click();
      page.locator(".dropdown-toggle").first().click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("   Back To Project List")).click();
      page.getByText("JE_JE_21[ JE DISTRIBUTION ]").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("fa-bars")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Action On Service")).click();
      page.locator("#button_25572_2").click();
      page.locator("#button_25273_29").click();
      page.locator("#div128821").click();
      page.locator("#ctrl129480").selectOption("No");
      page.locator("#ctrl129481").selectOption("No");
      page.locator("#iboxMain").click();
      System.out.println(" Complaint for load chnage Working Fine");

    }
  }
}
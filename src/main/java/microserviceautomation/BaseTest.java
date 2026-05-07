package microserviceautomation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected APIRequestContext request;

    @BeforeClass
    public void setUp() {

        // 🔹 Launch Playwright
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        // 🔥 SAME SESSION (important for API + UI)
        context = browser.newContext();
        page = context.newPage();
        request = context.request();

        // 🔹 Open URL
      page.navigate("http://172.30.0.63/");
  //      page.navigate("https://testui.appsavy.com/");
        

        // 🔹 Wait for login page
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);

        // 🔹 TYPE (slow typing for demo 🔥)
        page.locator("input[placeholder='UserID']")
                .type("9992233321", new Locator.TypeOptions().setDelay(100));

        page.locator("input[placeholder='Password']")
                .type("Ankitmehta@123", new Locator.TypeOptions().setDelay(100));

        // 🔹 Click Login
        page.locator("#btnlogin").click();

        // 🔹 Wait for navigation
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // 🔹 Debug print
        System.out.println("✅ Login done, URL: " + page.url());

        // 🔹 Safety wait (in case UI slow)
        page.waitForTimeout(3000);
    }

    @AfterClass
    public void tearDown() {

        context.close();
        browser.close();
        playwright.close();
    }
}
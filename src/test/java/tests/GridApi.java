

package tests;



import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.BaseTest;
import framework.ControlAPI;
import framework.ControlRequest;
import framework.RequestBuilder;
import framework.UIUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class GridApi extends BaseTest {

    int formId = 34089;
    String requestId = "7289049067";
    String controlId = "110096";

    UIUtil ui;

 // ===== BASIC =====
    
    String expectedCaptiontext = "mehrunnisa"; 
    String expectedDefaultValue = "ANKITtttttt";
    String expectedEnabled = "Y";
    String expectedVisibility = "Y";

    // ===== CAPTION FONT =====
    String expectedCaptionFontSize = "17";
    String expectedCaptionFontStyle = "Bold";
    String expectedCaptionFontColor = "#5f5f1c";
    String expectedCaptionFontFace = "Arial";
    String expectedCaptionBackgroundColor = "#2f2f2f";

    // ===== VALUE FONT =====
    String expectedValueFontSize = "14";
    String expectedValueFontStyle = "Italic";
    String expectedValueFontColor = "#123abc";
    String expectedValueFontFace = "Roboto";
    String expectedValueBackgroundColor = "#cccccc";

    // ===== LAYOUT =====
    String expectedControlWidth = "5";
    String expectedCaptionType = "Left";
    String expectedOrientation = "vertical";

    // ===== EXTRA =====
    String expectedMaxLength = "3";

    // ================== SETUP ==================
    @BeforeClass
    public void setup() {

        System.out.println("\n=== STEP 1: UI LOGIN + NAVIGATION ===");

        ui = new UIUtil(page);
        ui.clickAdmin();
        ui.clickThreeDot();
        ui.Grid();

        System.out.println("\n=== STEP 2: API HIT ===");

        ControlRequest.Changes ch = new ControlRequest.Changes();

     // ===== BASIC =====
    
     ch.CAPTION = expectedCaptiontext;
    // ch.TO_BE_SAVED = expectedToBeSaved;
     ch.DEFAULT_VALUE = expectedDefaultValue;
     ch.ENABLED = expectedEnabled;
     ch.VISIBILITY = expectedVisibility;

     // ===== CAPTION FONT =====
     ch.CAPTION_FONT_SIZE = expectedCaptionFontSize;
     ch.CAPTION_FONT_STYLE = expectedCaptionFontStyle;
     ch.CAPTION_FONT_COLOR = expectedCaptionFontColor;
     ch.CAPTION_FONT_FACE = expectedCaptionFontFace;
     ch.CAPTION_BACKGROUND_COLOR = expectedCaptionBackgroundColor;

     // ===== VALUE FONT =====
     ch.VALUE_FONT_SIZE = expectedValueFontSize;
     ch.VALUE_FONT_STYLE = expectedValueFontStyle;
     ch.VALUE_FONT_COLOR = expectedValueFontColor;
   
     ch.VALUE_FONT_FACE = expectedValueFontFace;
     ch.VALUE_BACKGROUND_COLOR = expectedValueBackgroundColor;

     // ===== LAYOUT =====
     ch.CONTROL_WIDTH = expectedControlWidth;
     ch.CAPTION_TYPE = expectedCaptionType;
     ch.ORIENTATION = expectedOrientation;

     // ===== EXTRA =====
     ch.MAX_LENGTH = expectedMaxLength;
     
        ControlRequest req = RequestBuilder.build(formId, requestId, controlId, ch);

        long startTime = System.currentTimeMillis();
        APIResponse res = ControlAPI.post(request, req);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("JSON: " + mapper.writeValueAsString(req));
        } catch (Exception e) {}

        System.out.println("Status Code: " + res.status());
        System.out.println("API Response Time : "
                + totalTime + " ms");

        System.out.println("API Response Time : "
                + (totalTime / 1000.0) + " sec");

        System.out.println("Response Body : ");
        System.out.println(res.text());
        Assert.assertEquals(res.status(), 200);

        System.out.println("\n=== STEP 3: UI REFRESH ===");
        ui.Gridafterapi();

        System.out.println("\n=== SETUP DONE ===\n");
    }

 // ========= TEST 1 =========
    @Test(priority = 1, description = "Verify Caption Font Size is updated via API and reflected correctly on UI")
    public void verifyCaptionFontSize() {

       
        Locator caption = page.locator("#gview_tbl" + controlId + " .ui-jqgrid-titlebar");

        caption.waitFor();

        String actualFontSizeFromUI = caption
            .evaluate("el => getComputedStyle(el).fontSize")
            .toString();

        String expectedFontSizeFromAPI = expectedCaptionFontSize + "px";

        System.out.println("=== FONT SIZE DEBUG ===");
        System.out.println("Element Checked: GRID CAPTION (Titlebar)");
        System.out.println("Expected (API): " + expectedFontSizeFromAPI);
        System.out.println("Actual (UI): " + actualFontSizeFromUI);

        Assert.assertEquals(
            actualFontSizeFromUI,
            expectedFontSizeFromAPI,
            "Caption Font Size mismatch! API vs UI not matching"
        );
   
    }

    // ========= TEST 2 =========
    @Test(priority = 2, description = "Verify Caption Font Color is updated via API and reflected correctly on UI")
    public void verifyCaptionFontColor() {

      
        Locator caption = page.locator("#gview_tbl" + controlId + " .ui-jqgrid-titlebar");

        caption.waitFor();

     
        String actualFontColor = caption
            .evaluate("el => getComputedStyle(el).color")
            .toString();

      
        String hex = expectedCaptionFontColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expectedFontColor = "rgb(" + r + ", " + g + ", " + b + ")";

        System.out.println("Expected Caption Font Color (API): " + expectedFontColor);
        System.out.println("Actual Caption Font Color (UI): " + actualFontColor);

        Assert.assertEquals(
            actualFontColor,
            expectedFontColor,
            "Font Color mismatch! API vs UI not matching"
        );
    }

    // ========= TEST 3 =========
    @Test(priority = 3, description = "Verify Caption Font Family is updated via API and reflected correctly on UI")
    public void verifyCaptionFontFamily() {

    	Locator grid = page.locator("#gview_tbl" + controlId);;

    
    	    String actualFontFamilyFromUI = grid
    	            .evaluate("el => getComputedStyle(el).fontFamily")
    	            .toString();

    	 
    	    String expectedFontFamilyFromAPI = expectedCaptionFontFace;

    	    System.out.println("Expected  Caption Font Family (API): " + expectedCaptionFontFace);
    	    System.out.println("Actual Caption Font Family (UI): " + actualFontFamilyFromUI);

    	    Assert.assertTrue(
    	    		actualFontFamilyFromUI.toLowerCase().contains(expectedCaptionFontFace.toLowerCase()),
    	        "Font Family mismatch! API vs UI not matching"
    	    );
    }

    // ========= TEST 4 =========
    @Test(priority = 4, description = "Verify Caption Font Style is updated via API and reflected correctly on UI")
    public void verifyCaptionFontStyle() {

        
        Locator caption = page.locator("#gview_tbl" + controlId + " .ui-jqgrid-titlebar");

        caption.waitFor();

        String expectedFontStyleFromAPI = expectedCaptionFontStyle.toLowerCase();
        String actualFontStyleFromUI = "";

        if (expectedFontStyleFromAPI.equals("underline")) {

            actualFontStyleFromUI = caption
                .evaluate("el => getComputedStyle(el).textDecorationLine")
                .toString().toLowerCase();

        } else if (expectedFontStyleFromAPI.equals("italic")) {

            actualFontStyleFromUI = caption
                .evaluate("el => getComputedStyle(el).fontStyle")
                .toString().toLowerCase();

        } else if (expectedFontStyleFromAPI.equals("bold")) {

            actualFontStyleFromUI = caption
                .evaluate("el => getComputedStyle(el).fontWeight")
                .toString();

         
            if (actualFontStyleFromUI.equals("700")) {
                actualFontStyleFromUI = "bold";
            }
        }

        System.out.println("Expected Font Style (API): " + expectedFontStyleFromAPI);
        System.out.println("Actual Font Style (UI): " + actualFontStyleFromUI);

        Assert.assertTrue(
            actualFontStyleFromUI.contains(expectedFontStyleFromAPI),
            "Font Style mismatch! API vs UI not matching"
        );
    }

    // ========= TEST 5 =========
    @Test(priority = 5, description = "Verify Caption Background Color is updated via API and reflected correctly on UI")
    public void verifyCaptionBackgroundColor() {

        Locator grid = page.locator("#gview_tbl" + controlId + " .ui-jqgrid-titlebar");
        grid.waitFor();

        String actualBackgroundColorFromUI = grid
                .evaluate("el => getComputedStyle(el).backgroundColor")
                .toString();

        String hex = expectedCaptionBackgroundColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expectedBackgroundColorFromAPI = "rgb(" + r + ", " + g + ", " + b + ")";

        System.out.println("Expected Caption Background Color (API): " + expectedBackgroundColorFromAPI);
        System.out.println("Actual Caption Background Color (UI): " + actualBackgroundColorFromUI);

        Assert.assertEquals(
                actualBackgroundColorFromUI,
                expectedBackgroundColorFromAPI,
                "Background Color mismatch! API vs UI not matching"
        );
    }
    
  
    
    @Test(priority = 6, description = "Verify Caption Text is updated via API and reflected correctly on Grid UI")
    public void verifyCaptionText() {

      
        Locator gridCaption = page.locator("#gview_tbl" + controlId + " .ui-jqgrid-titlebar");

        gridCaption.waitFor();

        String actualCaptionFromUI = gridCaption.textContent().trim();
        String expectedCaptionFromAPI = expectedCaptiontext.trim();

        System.out.println("Expected Grid Caption Text (API): " + expectedCaptionFromAPI);
        System.out.println("Actual Grid Caption Text (UI): " + actualCaptionFromUI);

        Assert.assertEquals(
            actualCaptionFromUI,
            expectedCaptionFromAPI,
            "Grid Caption mismatch! API vs UI not matching"
        );
    }
 
	 
    
 
}
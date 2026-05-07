package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

import framework.BaseTest;
import framework.ControlAPI;
import framework.ControlRequest;
import framework.RequestBuilder;
import framework.UIUtil;

public class ChechkboxDropdownApi2 extends BaseTest {

    int formId = 34120;
    String requestId = "7289049067";

    UIUtil ui;

    // ===== EXPECTED DEFAULT =====
    String expectedCaptiontext = "ANKIT mehta";
    String expectedDefaultValue = "mobineers";
    String expectedEnabled = "Y";
    String expectedVisibility = "Y";

    String expectedCaptionFontSize = "10";
    String expectedCaptionFontStyle = "italic";
    String expectedCaptionFontColor = "#ffffff";
    String expectedCaptionFontFace = "Roboto";
    String expectedCaptionBackgroundColor = "#aaa123";

    String expectedValueFontSize = "11";
    String expectedValueFontStyle = "bold";
    String expectedValueFontColor = "#1d1d1d";
    String expectedValueFontFace = "Arial";
    String expectedValueBackgroundColor = "#dddddd";

    String expectedControlWidth = "5";
    String expectedCaptionType = "left";
    String expectedOrientation = "vertical";

    String expectedMaxLength = "3";

    // ===== STEP 0 =====
    @BeforeClass
    public void setup() {

        System.out.println("STEP 0: UI LOGIN + NAVIGATION");

        ui = new UIUtil(page);
        ui.clickAdmin();
        ui.clickThreeDot();
        ui.Ccheckbox_dropdown();

        System.out.println("UI READY\n");
    }

    // ===== COMMON API METHOD =====
    public void hitAPI(
            String controlId,

            // ===== CAPTION =====
            String captionText,
            String captionFontSize,
            String captionFontColor,
            String captionFontFace,
            String captionFontStyle,
            String captionBackgroundColor,

            // ===== VALUE =====
            String defaultValue,
            String valueFontSize,
            String valueFontColor,
            String valueFontFace,
            String valueFontStyle,
            String valueBackgroundColor,

            // ===== FLAGS =====
            String enabled,
            String visibility,

            // ===== EXTRA =====
            String controlType,
            String orientation,
            String maxLength
            
    ) {

        System.out.println("==== API HIT START ====");
        System.out.println("Control ID: " + controlId);

    

        if (!captionText.equals("")) expectedCaptiontext = captionText;
        if (!captionFontSize.equals("")) expectedCaptionFontSize = captionFontSize;
        if (!captionFontColor.equals("")) expectedCaptionFontColor = captionFontColor;
        if (!captionFontFace.equals("")) expectedCaptionFontFace = captionFontFace;
        if (!captionFontStyle.equals("")) expectedCaptionFontStyle = captionFontStyle;
        if (!captionBackgroundColor.equals("")) expectedCaptionBackgroundColor = captionBackgroundColor;

        if (!defaultValue.equals("")) expectedDefaultValue = defaultValue;

        if (!valueFontSize.equals("")) expectedValueFontSize = valueFontSize;
        if (!valueFontColor.equals("")) expectedValueFontColor = valueFontColor;
        if (!valueFontFace.equals("")) expectedValueFontFace = valueFontFace;
        if (!valueFontStyle.equals("")) expectedValueFontStyle = valueFontStyle;
        if (!valueBackgroundColor.equals("")) expectedValueBackgroundColor = valueBackgroundColor;

        if (!enabled.equals("")) expectedEnabled = enabled;
        if (!visibility.equals("")) expectedVisibility = visibility;

        if (!controlType.equals("")) expectedCaptionType = controlType;
        if (!orientation.equals("")) expectedOrientation = orientation;
        if (!maxLength.equals("")) expectedMaxLength = maxLength;

       

        // ===== REQUEST BUILD =====
        ControlRequest.Changes ch = new ControlRequest.Changes();

        ch.CONTROL_ID = controlId;

        ch.CAPTION = expectedCaptiontext;
        ch.DEFAULT_VALUE = expectedDefaultValue;
        ch.ENABLED = expectedEnabled;
        ch.VISIBILITY = expectedVisibility;

        ch.CAPTION_FONT_SIZE = expectedCaptionFontSize;
        ch.CAPTION_FONT_COLOR = expectedCaptionFontColor;
        ch.CAPTION_FONT_FACE = expectedCaptionFontFace;
        ch.CAPTION_FONT_STYLE = expectedCaptionFontStyle;
        ch.CAPTION_BACKGROUND_COLOR = expectedCaptionBackgroundColor;

        ch.VALUE_FONT_SIZE = expectedValueFontSize;
        ch.VALUE_FONT_COLOR = expectedValueFontColor;
        ch.VALUE_FONT_FACE = expectedValueFontFace;
        ch.VALUE_FONT_STYLE = expectedValueFontStyle;
        ch.VALUE_BACKGROUND_COLOR = expectedValueBackgroundColor;

        ch.CAPTION_TYPE = expectedCaptionType;
        ch.ORIENTATION = expectedOrientation;
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

        System.out.println("UI Refresh after hitting API");
        ui.Ccheckbox_dropdownafterapi();
    }
    
    @Test(priority = 1, description = "Verify Caption Font Size is updated via API and reflected correctly on UI")
    
    public void verifyCaptionFontSize() {
    	
    	
    	
    	  String controlId = "110278";

          System.out.println("TEST CASE 1 (Verify Caption Font Size)");
          System.out.println("API HIT for Control ID: " + controlId);

          // ONLY FONT SIZE
          hitAPI(
              controlId,
              "",        // captionText
              "18",      // captionFontSize
              "", "", "", "",
              "", "", "", "", "", "",
              "", "",
              "", "", ""
          );

           Locator label = page.locator("#lblCap" + controlId);

           String actualFontSizeFromUI = label
                   .evaluate("el => getComputedStyle(el).fontSize")
                   .toString();

           
           String expectedFontSizeFromAPI = expectedCaptionFontSize + "px";
           System.out.println("Expected Caption Font Size (API): " + expectedFontSizeFromAPI);
           System.out.println("Actual Caption Font Size (UI): " + actualFontSizeFromUI);

           Assert.assertEquals(
               actualFontSizeFromUI,
               expectedFontSizeFromAPI,
               "Font Size mismatch! API vs UI not matching"
           );
           System.out.println("STATUS: PASS\n");
       }
    

       // ========= TEST 2 =========
       @Test(priority = 2, description = "Verify Caption Font Color is updated via API and reflected correctly on UI")
       public void verifyCaptionFontColor() {
    	   
    	   String controlId = "110270";
           System.out.println("TEST CASE 2 (Verify Caption Font Color)");
           System.out.println("API HIT for Control ID: " + controlId);

           // ONLY COLOR
           hitAPI(
               controlId,
               "",        // captionText
               "",        // fontSize
               "#abcabc", // fontColor
               "", "", "",
               "", "", "", "", "", "",
               "", "",
               "", "", ""
           );

           Locator label = page.locator("#lblCap" + controlId);

           String actualFontColor = label.evaluate("el => getComputedStyle(el).color").toString();

     
           String hex = expectedCaptionFontColor.replace("#", "");
           int r = Integer.parseInt(hex.substring(0, 2), 16);
           int g = Integer.parseInt(hex.substring(2, 4), 16);
           int b = Integer.parseInt(hex.substring(4, 6), 16);

           String expectedFontColor = "rgb(" + r + ", " + g + ", " + b + ")";
           
           
           System.out.println("Expected Caption Font Color (API): " + expectedFontColor);
           System.out.println("Actual  Caption Font Color (UI): " + actualFontColor);

           Assert.assertEquals(
               actualFontColor,
               expectedFontColor,
               "Font Color mismatch! API vs UI not matching"
           );
           System.out.println("STATUS: PASS\n");
       }

       // ========= TEST 3 =========
       @Test(priority = 3, description = "Verify Caption Font Family is updated via API and reflected correctly on UI")
       public void verifyCaptionFontFamily() {
    	   
    	   String controlId = "110271";
           

           System.out.println("===== TEST CASE 3 (Verify Caption Font Family) =====");
           System.out.println("API HIT for Control ID: " + controlId);

           // ===== API HIT =====
           hitAPI(
           	    controlId,

           	    // ===== CAPTION =====
           	    "",     // captionText
           	    "",     // captionFontSize
           	    "",     // captionFontColor
           	    "Helvetica",// captionFontFace
           	    "",     // captionFontStyle
           	    "",     // captionBackgroundColor

           	    // ===== VALUE =====
           	    "", "", "", "", "", "",

           	    // ===== FLAGS =====
           	    "", "",

           	    // ===== EXTRA =====
           	    "", "", ""
           	);

       	  Locator label = page.locator("#lblCap" + controlId);

       
       	    String actualFontFamilyFromUI = label
       	            .evaluate("el => getComputedStyle(el).fontFamily")
       	            .toString();

       	 
       	    String expectedFontFamilyFromAPI = expectedCaptionFontFace;

       	    System.out.println("Expected  Caption Font Family (API): " + expectedCaptionFontFace);
       	    System.out.println("Actual Caption Font Family (UI): " + actualFontFamilyFromUI);

       	    Assert.assertTrue(
       	    		actualFontFamilyFromUI.toLowerCase().contains(expectedCaptionFontFace.toLowerCase()),
       	        "Font Family mismatch! API vs UI not matching"
       	    );
       	 System.out.println("STATUS: PASS\n");
       }

       // ========= TEST 4 =========
       @Test(priority = 4, description = "Verify Caption Font Style is updated via API and reflected correctly on UI")

    public void verifyCaptionFontStyle() {
    	   
    	   String controlId = "110274";

           System.out.println("TEST CASE 4 (Verify Caption Font Style)");
           System.out.println("API HIT for Control ID: " + controlId);

           // ✅ correct position (captionFontStyle)
           hitAPI(
               controlId,
               "", "", "", "", 
               "Italic",   // ✅ STYLE correct position
               "",

               "", "", "", "", "", "",

               "", "",

               "", "", ""
           );
           

        Locator label = page.locator("#lblCap" + controlId);

        String expectedFontStyleFromAPI = expectedCaptionFontStyle.toLowerCase();

    
        String actualFontStyleFromUI = "";

        if (expectedFontStyleFromAPI.equals("underline")) {

            actualFontStyleFromUI = label
                    .evaluate("el => getComputedStyle(el).textDecorationLine")
                    .toString();

        } else if (expectedFontStyleFromAPI.equals("italic")) {

            actualFontStyleFromUI = label
                    .evaluate("el => getComputedStyle(el).fontStyle")
                    .toString();

        } else if (expectedFontStyleFromAPI.equals("bold")) {

            actualFontStyleFromUI = label
                    .evaluate("el => getComputedStyle(el).fontWeight")
                    .toString();

          
            expectedFontStyleFromAPI = "700";
        }


        System.out.println("Expected  Caption Font Style (API): " + expectedFontStyleFromAPI);
        System.out.println("Actual Caption Font Style (UI): " + actualFontStyleFromUI);


        Assert.assertTrue(
            actualFontStyleFromUI.toLowerCase().contains(expectedFontStyleFromAPI),
            "Font Style mismatch! API vs UI not matching"
        );
        
        System.out.println("STATUS: PASS\n");
    }

       // ========= TEST 5 =========
       @Test(priority = 5, description = "Verify Caption Background Color is updated via API and reflected correctly on UI")
       public void verifyCaptionBackgroundColor() {
    	   
    	   String controlId = "110269";

           System.out.println("TEST CASE 5 (Verify Caption Background Color)");
           System.out.println("API HIT for Control ID: " + controlId);

           // ✅ correct position (captionBackgroundColor)
           hitAPI(
               controlId,
               "", "", "", "", "", 
               "#ffffff",   // ✅ BACKGROUND सही जगह
               "", "", "", "", "", "", 
               "", "", 
               "", "", ""
           );
           
           Locator label = page.locator("#lblCap" + controlId);

           String actualBackgroundColorFromUI = label
                   .evaluate("el => getComputedStyle(el).backgroundColor")
                   .toString();

           String hex = expectedCaptionBackgroundColor.replace("#", "");
           int r = Integer.parseInt(hex.substring(0, 2), 16);
           int g = Integer.parseInt(hex.substring(2, 4), 16);
           int b = Integer.parseInt(hex.substring(4, 6), 16);

           String expectedBackgroundColorFromAPI = "rgb(" + r + ", " + g + ", " + b + ")";
      
           System.out.println("Expected  Caption Background Color (API): " + expectedBackgroundColorFromAPI);
           System.out.println("Actual Caption Background Color (UI): " + actualBackgroundColorFromUI);

     
           Assert.assertEquals(
               actualBackgroundColorFromUI,
               expectedBackgroundColorFromAPI,
               "Background Color mismatch! API vs UI not matching"
           );
           System.out.println("STATUS: PASS\n");
       }
       
     
       
       @Test(priority = 6, description = "Verify Caption Text is updated via API and reflected correctly on UI")

    public void verifyCaptionText() {
    	   

       	String controlId = "110276";

           System.out.println("TEST CASE 6 (Verify Caption Text)");
           System.out.println("API HIT for Control ID: " + controlId);

           // ✅ correct position (captionText)
           hitAPI(
               controlId,
               "New computer",   // ✅ CAPTION TEXT सही जगह (first caption field)
               "", "", "", "", "",
               "", "", "", "", "", "",
               "", "",
               "", "", ""
           );


       
        Locator label = page.locator("#lblCap" + controlId);

     
        String actualCaptionFromUI = label.textContent().trim();
        page.waitForTimeout(10000);
        String expectedCaptionFromAPI = expectedCaptiontext.trim();

        System.out.println("Expected Caption Text(API): " + expectedCaptionFromAPI);
        System.out.println("Actual Caption Text  (UI): " + actualCaptionFromUI);
        Assert.assertEquals(
            actualCaptionFromUI,
            expectedCaptionFromAPI,
            " Caption mismatch! API vs UI not matching"
        );
        System.out.println("STATUS: PASS\n");
    
   	 }
       
    @Test(priority = 7, description = "Verify Caption is aligned on LEFT side (UI)")

    public void verifyCaptionLeftAlignment() {
    	
    	 String controlId = "110273";

         System.out.println("TEST CASE 7 (Verify Caption Left Alignment)");
         System.out.println("API HIT for Control ID: " + controlId);

         // ✅ API HIT (controlType = left)
         hitAPI(
             controlId,
             "", "", "", "", "", "",
             "", "", "", "", "", "",
             "", "",
             "left",   // ✅ CAPTION TYPE (LEFT ALIGN)
             "",       // orientation
             ""        // maxLength
         );

        Locator caption = page.locator("#lblCap" + controlId);

        // Get alignment from UI
        String actualAlignment = caption.evaluate("el => window.getComputedStyle(el).textAlign").toString().trim().toLowerCase();
        String expectedAlignment = "left";

        System.out.println("Expected Alignment (UI): " + expectedAlignment);
        System.out.println("Actual Alignment (UI): " + actualAlignment);
        Assert.assertTrue(
       		    actualAlignment.equals("left") || actualAlignment.equals("start"),
       		    "Caption is not aligned LEFT"
       		);
        
    }
   }
 
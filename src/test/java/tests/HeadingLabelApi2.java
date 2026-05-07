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

public class HeadingLabelApi2 extends BaseTest {

    int formId = 34117;
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
        ui.headingLabel();

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
        ui.HeadinglabelafterApi();
    }
 
    
    
    @Test(priority = 1, description = "Verify Value Font Size is updated via API and reflected correctly on UI")
    public void verifyValueFontSize() {
    	
    	
    	 String controlId = "110226";

         System.out.println("TEST CASE 1 (Verify Value Font Size)");
         System.out.println("API HIT for Control ID: " + controlId);

         // ✅ correct position (valueFontSize)
         hitAPI(
             controlId,
             "", "", "", "", "", "",   // caption fields skip
             "11",                     // ✅ VALUE FONT SIZE सही जगह
             "", "", "", "", "", 
             "", "", 
             "", "", ""
         );

    	Locator value = page.locator("#ctrl" + controlId);

        String actualValueFontSizeFromUI = value
                .evaluate("el => getComputedStyle(el).fontSize")
                .toString();


        String expectedValueFontSizeFromAPI = expectedValueFontSize + "px";
        
 
        System.out.println("Expected Value Font Size (API): " + expectedValueFontSizeFromAPI);
        System.out.println("Actual Value Font Size (UI): " + actualValueFontSizeFromUI);

      
        Assert.assertEquals(
            actualValueFontSizeFromUI,
            expectedValueFontSizeFromAPI,
            "Value Font Size mismatch! API vs UI not matching"
        );
        System.out.println("STATUS: PASS\n");
    }
    
    @Test(priority = 2, description = "Verify Value Font Color is updated via API and reflected correctly on UI")
    public void verifyValueFontColor() {
    	 String controlId = "110223";

         System.out.println("TEST CASE 2 (Verify Value Font Color)");
         System.out.println("API HIT for Control ID: " + controlId);

         // ✅ correct position (valueFontColor)
         hitAPI(
             controlId,
             "", "", "", "", "", "",   // caption skip
             "",                       // valueFontSize
             "#00ffff",                // ✅ VALUE FONT COLOR सही जगह
             "", "", "", "", 
             "", "", 
             "", "", ""
         );

    	Locator value = page.locator("#ctrl" + controlId);

        String actualValueColorFromUI = value
                .evaluate("el => getComputedStyle(el).color")
                .toString();

        String hex = expectedValueFontColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expectedValueColorFromAPI = "rgb(" + r + ", " + g + ", " + b + ")";
 
        System.out.println("Expected Value Font Color (API): " + expectedValueColorFromAPI);
        System.out.println("Actual Value Font Color (UI): " + actualValueColorFromUI);

    
        Assert.assertEquals(
            actualValueColorFromUI,
            expectedValueColorFromAPI,
            "Value Font Color mismatch! API vs UI not matching"
        );
        System.out.println("STATUS: PASS\n");
    }
   
  
    @Test(priority = 3, description = "Verify Value Font Family is updated via API and reflected correctly on UI")

 public void verifyValueFontFamily() {
    	
    	 String controlId = "110222";

         System.out.println("TEST CASE 3 (Verify Value Font Family)");
         System.out.println("API HIT for Control ID: " + controlId);

         // ✅ correct position (valueFontFace)
         hitAPI(
             controlId,
             "", "", "", "", "", "",   // caption skip
             "",                       // valueFontSize
             "",                       // valueFontColor
             "Roboto",                  // ✅ VALUE FONT FAMILY सही जगह
             "", "", "", 
             "", "", 
             "", "", ""
         );

    	Locator value = page.locator("#ctrl" + controlId);

    	value.waitFor(new Locator.WaitForOptions()
    	    .setState(WaitForSelectorState.VISIBLE)
    	    .setTimeout(3000));

    	String actualFontFamilyFromUI = value
    	    .evaluate("el => getComputedStyle(el).fontFamily")
    	    .toString()
    	    .toLowerCase()
    	    .replace("\"", "")
    	    .trim();

    	System.out.println("Actual Value Font Family (UI): " + actualFontFamilyFromUI);
    	System.out.println("Expected Value Font Family (API): " + expectedValueFontFace);

    	boolean match = false;

    	for (String font : actualFontFamilyFromUI.split(",")) {
    	    if (font.trim().equals(expectedValueFontFace.toLowerCase())) {
    	        match = true;
    	        break;
    	    }
    	}

    	Assert.assertTrue(match, "Font Family mismatch! Actual: " + actualFontFamilyFromUI);
        System.out.println("STATUS: PASS\n");
    	}
    
    @Test(priority = 4, description = "Verify Value Font Style is updated via API and reflected correctly on UI")

 public void verifyValueFontStyle() {
    	
    	 String controlId = "110228";

         System.out.println("TEST CASE 4 (Verify Value Font Style)");
         System.out.println("API HIT for Control ID: " + controlId);

         // ✅ correct position (valueFontStyle)
         hitAPI(
         	    controlId,

         	    // ===== CAPTION =====
         	    "", "", "", "", "", "",

         	    // ===== VALUE =====
         	    "",        // defaultValue
         	    "",        // valueFontSize
         	    "",        // valueFontColor
         	    "",        // valueFontFace
         	    "Bold", // ✅ valueFontStyle (correct position)
         	    "",        // valueBackgroundColor

         	    // ===== FLAGS =====
         	    "", "",

         	    // ===== EXTRA =====
         	    "", "", ""
         	);

    
    	Locator value = page.locator("#ctrl" + controlId);
    	value.waitFor();

     
     String expectedStyleFromAPI = expectedValueFontStyle.toLowerCase();

    
     String actualStyleFromUI = "";


     if (expectedStyleFromAPI.equals("underline")) {

        
         actualStyleFromUI = value
             .evaluate("el => getComputedStyle(el).textDecorationLine")
             .toString();

     } else if (expectedStyleFromAPI.equals("italic")) {

        
         actualStyleFromUI = value
             .evaluate("el => getComputedStyle(el).fontStyle")
             .toString();

     } else if (expectedStyleFromAPI.equals("bold")) {

         
         actualStyleFromUI = value
             .evaluate("el => getComputedStyle(el).fontWeight")
             .toString();

        
         expectedStyleFromAPI = "700";
     }

    System.out.println("Expected value Font Style (API): " + expectedStyleFromAPI);
    System.out.println("Actual value Font Style (UI): " + actualStyleFromUI);
     Assert.assertTrue(
         actualStyleFromUI.toLowerCase().contains(expectedStyleFromAPI),
         "Font Style mismatch! API vs UI not matching"
     );
     System.out.println("STATUS: PASS\n");
 }
    @Test(priority = 5, description = "Verify Value Background Color is updated via API and reflected correctly on UI")
    public void verifyValueBackgroundColor() {
    	
    	 String controlId = "110224";

         System.out.println("TEST CASE 5 (Verify Value Background Color)");
         System.out.println("API HIT for Control ID: " + controlId);

         // ✅ correct position (valueBackgroundColor)
         hitAPI(
         	    controlId,

         	    // ===== CAPTION =====
         	    "", "", "", "", "", "",

         	    // ===== VALUE =====
         	    "",        // defaultValue
         	    "",        // valueFontSize
         	    "",        // valueFontColor
         	    "",        // valueFontFace
         	    "",        // valueFontStyle
         	    "#ff00ff", // ✅ valueBackgroundColor (correct position)

         	    // ===== FLAGS =====
         	    "", "",

         	    // ===== EXTRA =====
         	    "", "", ""
         	);

        Locator value = page.locator("#ctrl" + controlId);
        value.waitFor();

        String actualColorFromUI = value
            .evaluate("el => getComputedStyle(el).backgroundColor")
            .toString();

        String hex = expectedValueBackgroundColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expectedColorFromAPI = "rgb(" + r + ", " + g + ", " + b + ")";

        System.out.println("Expected Value Background Color (API): " + expectedColorFromAPI);
        System.out.println("Actual Value Background Color (UI): " + actualColorFromUI);

        Assert.assertEquals(
            actualColorFromUI,
            expectedColorFromAPI,
            "Background Color mismatch! API vs UI not matching"
        );
        System.out.println("STATUS: PASS\n");
    }
    
    @Test(priority = 6, description = "Verify Caption Text is updated via API and reflected correctly on UI")

 public void verifyCaptionText() {
    	
    	String controlId = "110227";

        System.out.println("TEST CASE 6 (Verify Caption Text)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ correct position (captionText)
        hitAPI(
            controlId,
            "New",   // ✅ CAPTION TEXT सही जगह (first caption field)
            "", "", "", "", "",
            "", "", "", "", "", "",
            "", "",
            "", "", ""
        );


    
    	Locator label = page.locator("#ctrl" + controlId);

  
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
}
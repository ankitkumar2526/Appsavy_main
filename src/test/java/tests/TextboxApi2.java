

package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;

import framework.BaseTest;
import framework.ControlAPI;
import framework.ControlRequest;
import framework.RequestBuilder;
import framework.UIUtil;

public class TextboxApi2 extends BaseTest {

    int formId = 34110;
    String requestId = "7289049067";

    UIUtil ui;

    // ===== EXPECTED DEFAULT =====
    String expectedCaptiontext = "ANKIT on heading label 2";
    String expectedDefaultValue = "meh";
    String expectedEnabled = "Y";
    String expectedVisibility = "Y";

    String expectedCaptionFontSize = "10";
    String expectedCaptionFontStyle = "italic";
    String expectedCaptionFontColor = "#bbbbbb";
    String expectedCaptionFontFace = "Roboto";
    String expectedCaptionBackgroundColor = "#aaaaaa";

    String expectedValueFontSize = "11";
    String expectedValueFontStyle = "bold";
    String expectedValueFontColor = "#008888";
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
        ui.textbox();

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
        ui.textboxafterapi();
    }

    @Test(priority = 1, description = "Verify Caption Font Size via API and validate on UI")
    public void verifyCaptionFontSize() {

        String controlId = "110169";

        System.out.println("TEST CASE 1 (Verify Caption Font Size)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ONLY FONT SIZE
        hitAPI(
            controlId,
            "",        // captionText
            "20",      // captionFontSize
            "", "", "", "",
            "", "", "", "", "", "",
            "", "",
            "", "", ""
        );

        Locator label = page.locator("#lblCap" + controlId);

        String actual = label.evaluate("el => getComputedStyle(el).fontSize").toString();
        String expected = expectedCaptionFontSize + "px";

        System.out.println("Expected: " + expected + " | Actual: " + actual);

        Assert.assertEquals(actual, expected);

        System.out.println("STATUS: PASS\n");
    }

    // ===== TEST CASE 2 =====
    @Test(priority = 2, description = "Verify Caption Font Color via API and validate on UI")
    public void verifyCaptionFontColor() {

        String controlId = "110168";

        System.out.println("TEST CASE 2 (Verify Caption Font Color)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ONLY COLOR
        hitAPI(
            controlId,
            "",        // captionText
            "",        // fontSize
            "#008888", // fontColor
            "", "", "",
            "", "", "", "", "", "",
            "", "",
            "", "", ""
        );

        Locator label = page.locator("#lblCap" + controlId);

        String actual = label.evaluate("el => getComputedStyle(el).color").toString();

        // HEX → RGB conversion
        String hex = expectedCaptionFontColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expected = "rgb(" + r + ", " + g + ", " + b + ")";

        System.out.println("Expected: " + expected + " | Actual: " + actual);

        Assert.assertEquals(actual, expected);

        System.out.println("STATUS: PASS\n");
    }

    // ===== TEST CASE 3 =====
    @Test(priority = 3, description = "Verify Caption Font Family via API and validate on UI")
    public void verifyCaptionFontFamily() {

        String controlId = "110166";
      

        System.out.println("===== TEST CASE 3 (Verify Caption Font Family) =====");
        System.out.println("API HIT for Control ID: " + controlId);

        // ===== API HIT =====
        hitAPI(
        	    controlId,

        	    // ===== CAPTION =====
        	    "",     // captionText
        	    "",     // captionFontSize
        	    "",     // captionFontColor
        	    "Arial",// captionFontFace
        	    "",     // captionFontStyle
        	    "",     // captionBackgroundColor

        	    // ===== VALUE =====
        	    "", "", "", "", "", "",

        	    // ===== FLAGS =====
        	    "", "",

        	    // ===== EXTRA =====
        	    "", "", ""
        	);

        // ===== LOCATOR =====
        Locator label = page.locator("#lblCap" + controlId);

        // 🔥 IMPORTANT WAIT (fix timing issue)
        label.waitFor(new Locator.WaitForOptions().setTimeout(60000));

        // ===== ACTUAL VALUE =====
        String actual = label
                .evaluate("el => getComputedStyle(el).fontFamily")
                .toString()
                .toLowerCase();

        // ===== EXPECTED VALUE =====
        String expected = expectedCaptionFontFace.toLowerCase();

        // ===== PRINT =====
        System.out.println("Expected (API): " + expected);
        System.out.println("Actual (UI): " + actual);

        // ===== ASSERTION =====
        Assert.assertTrue(
                actual.contains(expected),
                "Font Family mismatch! API vs UI not matching"
        );

        System.out.println("STATUS: PASS\n");
    }
    
    @Test(priority = 4, description = "Verify Caption Font Style via API and validate on UI")
    public void verifyCaptionFontStyle() {

        String controlId = "110170";

        System.out.println("TEST CASE 4 (Verify Caption Font Style)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ correct position (captionFontStyle)
        hitAPI(
            controlId,
            "", "", "", "", 
            "underline",   // ✅ STYLE correct position
            "",

            "", "", "", "", "", "",

            "", "",

            "", "", ""
        );

        Locator label = page.locator("#lblCap" + controlId);

        String actual = "";

        // ✅ use expected variable (dynamic)
        if (expectedCaptionFontStyle.equalsIgnoreCase("underline")) {
            actual = label.evaluate("el => getComputedStyle(el).textDecorationLine").toString();
        } 
        else if (expectedCaptionFontStyle.equalsIgnoreCase("italic")) {
            actual = label.evaluate("el => getComputedStyle(el).fontStyle").toString();
        } 
        else if (expectedCaptionFontStyle.equalsIgnoreCase("bold")) {
            actual = label.evaluate("el => getComputedStyle(el).fontWeight").toString();
        }

        String expected = expectedCaptionFontStyle.toLowerCase();

        System.out.println("Expected: " + expected + " | Actual: " + actual);

        Assert.assertTrue(actual.toLowerCase().contains(expected));

        System.out.println("STATUS: PASS\n");
    }
    
    @Test(priority = 5, description = "Verify Caption Background Color via API and validate on UI")
    public void verifyCaptionBackgroundColor() {

        String controlId = "110171";

        System.out.println("TEST CASE 5 (Verify Caption Background Color)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ correct position (captionBackgroundColor)
        hitAPI(
            controlId,
            "", "", "", "", "", 
            "#ff0000",   // ✅ BACKGROUND सही जगह
            "", "", "", "", "", "", 
            "", "", 
            "", "", ""
        );

        Locator label = page.locator("#lblCap" + controlId);

        String actual = label.evaluate("el => getComputedStyle(el).backgroundColor").toString();

        // ✅ dynamic expected
        String hex = expectedCaptionBackgroundColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expected = "rgb(" + r + ", " + g + ", " + b + ")";

        System.out.println("Expected: " + expected + " | Actual: " + actual);

        Assert.assertEquals(actual, expected);

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 6, description = "Verify Value Font Size via API and validate on UI")
    public void verifyValueFontSize() {

        String controlId = "110177";

        System.out.println("TEST CASE 6 (Verify Value Font Size)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ correct position (valueFontSize)
        hitAPI(
            controlId,
            "", "", "", "", "", "",   // caption fields skip
            "22",                     // ✅ VALUE FONT SIZE सही जगह
            "", "", "", "", "", 
            "", "", 
            "", "", ""
        );

        Locator value = page.locator("#ctrl" + controlId);

        String actual = value.evaluate("el => getComputedStyle(el).fontSize").toString();

        // ✅ dynamic expected
        String expected = expectedValueFontSize + "px";

        System.out.println("Expected: " + expected + " | Actual: " + actual);

        Assert.assertEquals(actual, expected);

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 7, description = "Verify Value Font Color via API and validate on UI")
    public void verifyValueFontColor() {

        String controlId = "110174";

        System.out.println("TEST CASE 7 (Verify Value Font Color)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ correct position (valueFontColor)
        hitAPI(
            controlId,
            "", "", "", "", "", "",   // caption skip
            "",                       // valueFontSize
            "#00ff00",                // ✅ VALUE FONT COLOR सही जगह
            "", "", "", "", 
            "", "", 
            "", "", ""
        );

        Locator value = page.locator("#ctrl" + controlId);

        String actual = value.evaluate("el => getComputedStyle(el).color").toString();

        // ✅ dynamic expected (hex → rgb)
        String hex = expectedValueFontColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expected = "rgb(" + r + ", " + g + ", " + b + ")";

        System.out.println("Expected: " + expected + " | Actual: " + actual);

        Assert.assertEquals(actual, expected);

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 8, description = "Verify Value Font Family via API and validate on UI")
    public void verifyValueFontFamily() {

        String controlId = "110173";

        System.out.println("TEST CASE 8 (Verify Value Font Family)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ correct position (valueFontFace)
        hitAPI(
            controlId,
            "", "", "", "", "", "",   // caption skip
            "",                       // valueFontSize
            "",                       // valueFontColor
            "Arial",                  // ✅ VALUE FONT FAMILY सही जगह
            "", "", "", 
            "", "", 
            "", "", ""
        );

        Locator value = page.locator("#ctrl" + controlId);

        String actual = value
                .evaluate("el => getComputedStyle(el).fontFamily")
                .toString()
                .toLowerCase();

        // ✅ dynamic expected
        String expected = expectedValueFontFace.toLowerCase();

        System.out.println("Expected: " + expected + " | Actual: " + actual);

        Assert.assertTrue(actual.contains(expected));

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 9, description = "Verify Value Font Style via API and validate on UI")
    public void verifyValueFontStyle() {

        String controlId = "110167";

        System.out.println("TEST CASE 9 (Verify Value Font Style)");
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
        	    "underline", // ✅ valueFontStyle (correct position)
        	    "",        // valueBackgroundColor

        	    // ===== FLAGS =====
        	    "", "",

        	    // ===== EXTRA =====
        	    "", "", ""
        	);

        Locator value = page.locator("#ctrl" + controlId);

        String expectedStyleFromAPI = expectedValueFontStyle.toLowerCase();
        String actualStyleFromUI = "";

        if (expectedStyleFromAPI.equals("underline")) {
            actualStyleFromUI = value.evaluate("el => getComputedStyle(el).textDecorationLine").toString();
        } 
        else if (expectedStyleFromAPI.equals("italic")) {
            actualStyleFromUI = value.evaluate("el => getComputedStyle(el).fontStyle").toString();
        } 
        else if (expectedStyleFromAPI.equals("bold")) {
            actualStyleFromUI = value.evaluate("el => getComputedStyle(el).fontWeight").toString();
            expectedStyleFromAPI = "700";
        }

        System.out.println("Expected: " + expectedStyleFromAPI + " | Actual: " + actualStyleFromUI);

        Assert.assertTrue(
            actualStyleFromUI.toLowerCase().contains(expectedStyleFromAPI),
            "Value Font Style mismatch!"
        );

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 10, description = "Verify Value Background Color via API and validate on UI")
    public void verifyValueBackgroundColor() {

        String controlId = "110179";

        System.out.println("TEST CASE 10 (Verify Value Background Color)");
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
        	    "#ff0000", // ✅ valueBackgroundColor (correct position)

        	    // ===== FLAGS =====
        	    "", "",

        	    // ===== EXTRA =====
        	    "", "", ""
        	);
        Locator value = page.locator("#ctrl" + controlId);

        String actualColorFromUI = value
            .evaluate("el => getComputedStyle(el).backgroundColor")
            .toString();

        // ✅ dynamic expected (hex → rgb)
        String hex = expectedValueBackgroundColor.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        String expectedColorFromAPI = "rgb(" + r + ", " + g + ", " + b + ")";

        System.out.println("Expected: " + expectedColorFromAPI + " | Actual: " + actualColorFromUI);

        Assert.assertEquals(
            actualColorFromUI,
            expectedColorFromAPI,
            "Value Background Color mismatch!"
        );

        System.out.println("STATUS: PASS\n");
    }
    
    @Test(priority = 11, description = "Verify Caption Text via API and validate on UI")
    public void verifyCaptionText() {

        String controlId = "110178";

        System.out.println("TEST CASE 11 (Verify Caption Text)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ correct position (captionText)
        hitAPI(
            controlId,
            "New Caption",   // ✅ CAPTION TEXT सही जगह (first caption field)
            "", "", "", "", "",
            "", "", "", "", "", "",
            "", "",
            "", "", ""
        );

        Locator label = page.locator("#lblCap" + controlId);

        String actualCaptionFromUI = label.textContent().trim();
        String expectedCaptionFromAPI = expectedCaptiontext.trim();

        System.out.println("Expected: " + expectedCaptionFromAPI + " | Actual: " + actualCaptionFromUI);

        Assert.assertEquals(
            actualCaptionFromUI,
            expectedCaptionFromAPI,
            "Caption Text mismatch!"
        );

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 12, description = "Verify Default Value is updated via API and reflected correctly on UI")
    public void verifyDefaultValue() {

        String controlId = "110176";

        System.out.println("TEST CASE 12 (Verify Default Value)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ ONLY DEFAULT VALUE PASS (correct position)
        hitAPI(
            controlId,
            "", "", "", "", "", "",
            "ANKIT123",    // ✅ DEFAULT VALUE सही जगह
            "", "", "", "", "",
            "", "",
            "", "", ""
        );

        Locator value = page.locator("#ctrl" + controlId);

        String actualDefaultValueFromUI = value.inputValue().trim();
        String expectedDefaultValueFromAPI = expectedDefaultValue.trim();

        System.out.println("Expected: " + expectedDefaultValueFromAPI + " | Actual: " + actualDefaultValueFromUI);

        Assert.assertEquals(
            actualDefaultValueFromUI,
            expectedDefaultValueFromAPI,
            "Default Value mismatch! API vs UI not matching"
        );

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 13, description = "Verify Max Length restriction is applied via API and reflected correctly on UI")
    public void verifyMaxLength() {

        String controlId = "110175";

        System.out.println("TEST CASE 13 (Verify Max Length)");
        System.out.println("API HIT for Control ID: " + controlId);

        // ✅ ONLY MAX LENGTH PASS (correct position)
        hitAPI(
            controlId,
            "", "", "", "", "", "",
            "", "", "", "", "", "",
            "", "",
            "", "", "5"   // ✅ maxLength सही जगह
        );

        Locator value = page.locator("#ctrl" + controlId);

        value.waitFor();
        value.click();
        value.fill("");

        String inputText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        value.type(inputText, new Locator.TypeOptions().setDelay(100));

        String actualValue = value.inputValue();

        System.out.println("Actual Value: " + actualValue);
        System.out.println("Actual Length: " + actualValue.length());
        System.out.println("Expected Max Length: " + expectedMaxLength);

        Assert.assertTrue(
            actualValue.length() <= Integer.parseInt(expectedMaxLength),
            "Max Length validation failed! Limit exceeded"
        );

        System.out.println("STATUS: PASS\n");
    }
    @Test(priority = 14, description = "Verify Caption is aligned on LEFT side (UI)")
    public void verifyCaptionLeftAlignment() {

        String controlId = "110172";

        System.out.println("TEST CASE 14 (Verify Caption Left Alignment)");
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

        String actualAlignment = caption
                .evaluate("el => window.getComputedStyle(el).textAlign")
                .toString()
                .trim()
                .toLowerCase();

        String expectedAlignment = expectedCaptionType.toLowerCase();

        System.out.println("Expected: " + expectedAlignment + " | Actual: " + actualAlignment);

        Assert.assertTrue(
            actualAlignment.equals("left") || actualAlignment.equals("start"),
            "Caption is not aligned LEFT"
        );

        System.out.println("STATUS: PASS\n");
    }	}
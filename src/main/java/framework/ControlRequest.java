package framework;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControlRequest {

    public int form_id;
    public String user_id;
    public Changes changes;

    public static class Changes {

    

    	    // ===== BASIC =====
    	    public String CONTROL_ID;
    	    public String CAPTION;
    	    public String TO_BE_SAVED;
    	    public String DEFAULT_VALUE;
    	    public String ENABLED;
    	    public String VISIBILITY;

    	    // ===== CAPTION FONT =====
    	    public String CAPTION_FONT_SIZE;
    	    public String CAPTION_FONT_STYLE;
    	    public String CAPTION_FONT_COLOR;
    	    public String CAPTION_FONT_FACE;
    	    public String CAPTION_BACKGROUND_COLOR;

    	    // ===== VALUE FONT =====
    	    public String VALUE_FONT_SIZE;
    	    public String VALUE_FONT_STYLE;
    	    public String VALUE_FONT_COLOR;
    	    public String VALUE_FONT_FACE;
    	    public String VALUE_BACKGROUND_COLOR;

    	    // ===== LAYOUT =====
    	    public String CONTROL_WIDTH;
    	    public String CAPTION_TYPE;
    	    public String ORIENTATION;

    	    // ===== OTHER (NEW ADD) =====
            public String MAX_LENGTH;
    	   
    	
    	}
    }

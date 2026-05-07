package framework;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class UIUtil {

    private Page page;

    public UIUtil(Page page) {
        this.page = page;
    }

    public void clickAdmin() {
       
    	page.locator("text=ADMIN").first().click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void clickThreeDot() {
        Locator menuBtn = page.locator("#clpsBar");
        menuBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        menuBtn.click();
    }

	
    public void ApiUiTesting() {
   
    	page.locator("a[href*='FormId=34050']").click();
        // important wait (double load handle)
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.waitForURL("**FormId=34050**");

      
    }
    
    
    public void textbox()
    {
    	
    	page.locator("#span11773").click();
    	page.locator("#a34110").click();
    //	page.locator("#a34110").click();
    	
    }
    
    public void textboxafterapi() {
        page.locator("#usericon").click();
        page.locator("#btnbak").click();
        page.locator("text=ADMIN[ ADMIN ]").click();
        page.locator("#clpsBar").click();
       page.locator("#span11773").click();
    	page.locator("#a34110").click();
    // page.locator("#a34089").click();
    	
        
     
    }
    
    public void multilineTextbox()
    {
    	
    	page.locator("#span11773").click();
    	page.locator("#a34109").click();
  // 	page.locator("#a34089").click();
    	
    }
    
    public void multilinetextboxafterapi() {
        page.locator("#usericon").click();
        page.locator("#btnbak").click();
        page.locator("text=ADMIN[ ADMIN ]").click();
        page.locator("#clpsBar").click();
        page.locator("#span11773").click();
    	page.locator("#a34109").click();
     // page.locator("#a34089").click();
    	  }
       
    public void radioButton()
    {
    	
    	page.locator("#span11773").click();
      page.locator("#a34111").click();
    //	page.locator("#a34089").click();
    	
    }
    
    public void radioButtonafterapi() {
        page.locator("#usericon").click();
        page.locator("#btnbak").click();
        page.locator("text=ADMIN[ ADMIN ]").click();
        page.locator("#clpsBar").click();
      page.locator("#span11773").click();
       	page.locator("#a34111").click();
    	//page.locator("#a34089").click();
  
    	  }
    
    public void headingLabel()
    {
    	
        page.locator("#span11773").click();
    	page.locator("#a34117").click();
    //	page.locator("#a34089").click();
    	
    }
    
    public void HeadinglabelafterApi() {
        page.locator("#usericon").click();
        page.locator("#btnbak").click();
        page.locator("text=ADMIN[ ADMIN ]").click();
        page.locator("#clpsBar").click();
        page.locator("#span11773").click();
    	page.locator("#a34117").click();
      //  page.locator("#a34089").click();
    	
        
    
    }
    
    
    
 
       
    
   public void labelButton()
   {
   	
   	page.locator("#span11773").click();
     page.locator("#a34118").click();
  // 	page.locator("#a34118").click();
   	
   }
   
   public void LabelButtonafterapi() {
       page.locator("#usericon").click();
       page.locator("#btnbak").click();
       page.locator("text=ADMIN[ ADMIN ]").click();
       page.locator("#clpsBar").click();
   page.locator("#span11773").click();
       	page.locator("#a34118").click();
  // 	page.locator("#a34089").click();
 
   	  }
   
   
   public void Ccheckbox()
   {
   	
   	page.locator("#span11773").click();
     page.locator("#a34119").click();
 //  	page.locator("#a34089").click();
   	
   }
   
   public void Ccheckboxafterapi() {
       page.locator("#usericon").click();
       page.locator("#btnbak").click();
       page.locator("text=ADMIN[ ADMIN ]").click();
       page.locator("#clpsBar").click();
     page.locator("#span11773").click();
       page.locator("#a34119").click();
  // 	page.locator("#a34089").click();
 
   	  }
   
   
   public void Ccheckbox_dropdown()
   {
   	
   	page.locator("#span11773").click();
     page.locator("#a34120").click();
 //  	page.locator("#a34089").click();
   	
   }
   
   public void Ccheckbox_dropdownafterapi() {
       page.locator("#usericon").click();
       page.locator("#btnbak").click();
       page.locator("text=ADMIN[ ADMIN ]").click();
       page.locator("#clpsBar").click();
     page.locator("#span11773").click();
       page.locator("#a34120").click();
  // 	page.locator("#a34089").click();
 
   	  }
   
   
   
   public void Grid()
   {
   	
//   	page.locator("#span665").click();
  //   	page.locator("#a33799").click();
   	page.locator("#a34089").click();
   	
   }
   
   public void Gridafterapi() {
       page.locator("#usericon").click();
       page.locator("#btnbak").click();
       page.locator("text=ADMIN[ ADMIN ]").click();
       page.locator("#clpsBar").click();
   //  page.locator("#span665").click();
    //  	page.locator("#a33799").click();
  	page.locator("#a34089").click();
 
   	  }
   
   
  
}
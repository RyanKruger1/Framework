import Core.Reporting;
import Core.SeleniumDriverInstance;
import FaceBookTests.LoginAndSubmit;
import PageObjects.Facebook_Page_Objects;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.runners.model.TestClass;

public class FacebookTestRunner extends SeleniumDriverInstance {


    @Rule
    public  TestName name = new TestName();


    @Before
    public void StartBrowser(){
        tname = name.getMethodName();

        r.CreateReportFile();

        if(!OpenBrowser()){
         r.Fail("Failed to open browser");
        }
        if(!navigate("https:\\www.facebook.com")){
           r.Fail("Failed to navigate to facebook");
        }



    }

    @After
    public void CloseBrowser(){

        if(!closeBrowser()){
            System.out.println("Could not close browser.");
        }

    }

    @Test
    public void FacbookTest()
    {
        String result = LoginAndSubmit.CreateNewUser();

        if(result != null){
            r.Fail("Failed to complete test.");
        }

    }

}

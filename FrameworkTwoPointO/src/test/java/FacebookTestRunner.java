import Core.Reporting;
import Core.SeleniumDriverInstance;
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
    Reporting r = new Reporting();

    @Rule
    public  TestName name = new TestName();


    @Before
    public void StartBrowser(){
        tname = name.getMethodName();

        r.CreateReportFile();

        if(!OpenBrowser()){
            System.out.println("Could not open browser");
        }

    }

    @After
    public void CloseBrowser(){

        if(!closeBrowser()){
            System.out.println("Could not close browser.");
        }

    }

    @Test
    public void FacbookTest(){

        if(!navigate("https:\\www.facebook.com")){
            System.out.println("Could not navigate to facebook.com");
        }
        r.Pass("Successfully navigated to:" + "Facebook.com");

        if(!EnterTextByXpath(Facebook_Page_Objects.username(),"gggggg@ggggg.ggg")){
            System.out.println("Could not enter username");
        }
        r.Pass("Successfully Enter username");

        if(!EnterTextByXpath(Facebook_Page_Objects.password(),"123456890")){
            System.out.println("Could not enter password");
        }
        r.Pass("Successfully entered password");

        waitSeconds(3000);

        if(!clickElementByXpath(Facebook_Page_Objects.loginButton())){
            System.out.println("Could not click login button");
        }
        r.Pass("Successfully clicked button:" + "Login");
    }

}

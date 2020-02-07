import Core.AppiumDriverInstance;
import Core.BaseFile;
import Core.CommandLineExecutorInterface;
import Core.Reporting;
import PageObjects.AppiumPageObjects;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.springframework.util.Assert;

public class AppiumTestRunner  extends AppiumDriverInstance {
   static Reporting r = new Reporting();

   @Rule
   public TestName name = new TestName();

    @Before
    public void init(){
        try {
            BaseFile.tname = name.getMethodName();
            r.CreateReportFile();
            if(CommandLineExecutorInterface.runCommand()){

            }


            StartAppiumServer();
            StartServer();

            r.Pass("Successfully Started required servers");


        }catch(Exception ex){

            String message = ex.getMessage();
            System.out.println(message);

        }
    }

    @Test
    public void AppiumTest(){
        System.out.println("Starting Clicking Test.");
        boolean result = clickElementByXpath(AppiumPageObjects.one());

        result = clickElementByXpath(AppiumPageObjects.two());

        result = clickElementByXpath(AppiumPageObjects.three());

        result = clickElementByXpath(AppiumPageObjects.four());

        result = clickElementByXpath(AppiumPageObjects.five());

        result = clickElementByXpath(AppiumPageObjects.six());

        result = clickElementByXpath(AppiumPageObjects.seven());

        result = clickElementByXpath(AppiumPageObjects.eight());

        result = clickElementByXpath(AppiumPageObjects.nine());

        if(!result){
            r.Fail("Could not enter all the numbers into the field.");
        }

        r.Pass("Successfully enterd numbers into the calculator.");
    }

    @After
    public void shutdown(){
        System.out.println("Shutdown");
        boolean result = closeServer();
        r.Pass("Successfully server shut down.");
        r.closeReport();
        Assert.isTrue(result);
    }

}

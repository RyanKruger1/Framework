import Core.AppiumDriverInstance;
import PageObjects.AppiumPageObjects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.springframework.util.Assert;

public class AppiumTestRunner  extends AppiumDriverInstance {

    @Before
    public void init(){
        try {

    
            StartAppiumServer();
            StartServer();

        }catch(Exception ex){
            String message = ex.getMessage();
            System.out.println(message);
        }
    }


    @Test
    public void test(){
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
         Assert.isTrue(result);
    }

    @After
    public void shutdown(){
    System.out.println("Shutdown");
        closeServer();

    }

}

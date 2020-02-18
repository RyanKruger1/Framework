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

public class AppiumTestRunner extends AppiumDriverInstance {

    static Reporting r = new Reporting(driver);

    @Rule
    public TestName name = new TestName();

    @Before
    public void init() {


        try {
            BaseFile.tname = name.getMethodName();

            r.CreateReportFile();

            CommandLineExecutorInterface.StartEmulator();

            StartAppiumServer();

            StartServer();

            r.SetDriver(driver);

            r.Pass("Successfully Started required servers");

        } catch (Exception ex) {

            String message = ex.getMessage();
            System.out.println(message);

        }
    }

    @Test
    public void AppiumTest() {
        System.out.println("Starting Clicking Test.");

        if (!clickElementByXpath(AppiumPageObjects.one())) {
            r.FailWithEmulatorScreenShot("Oops could not press 1");
        }
        if (!clickElementByXpath(AppiumPageObjects.two())) {
            r.FailWithEmulatorScreenShot("Oops could not press 2");
        }
        if (!clickElementByXpath(AppiumPageObjects.three())) {
            r.FailWithEmulatorScreenShot("Oops could not press 3");
        }
        if (!clickElementByXpath(AppiumPageObjects.four())) {
            r.FailWithEmulatorScreenShot("Oops could not press 4");
        }
        if (!clickElementByXpath(AppiumPageObjects.five())) {
            r.FailWithEmulatorScreenShot("Oops could not press 5 ");
        }
        if (!clickElementByXpath(AppiumPageObjects.six())) {
            r.FailWithEmulatorScreenShot("Oops could not press 6");
        }
        if (!clickElementByXpath(AppiumPageObjects.seven())) {
            r.FailWithEmulatorScreenShot("Oops could not press 7");
        }
        if (!clickElementByXpath(AppiumPageObjects.eight())) {
            r.FailWithEmulatorScreenShot("Oops could not press 8");
        }
        if (!clickElementByXpath(AppiumPageObjects.nine())) {
            r.FailWithEmulatorScreenShot("Oops could not press 9");
        }
        r.PassWithEmulatorScreenShot("Successfully enterd numbers into the calculator.");
    }

    @After
    public void shutdown() {
        System.out.println("Shutdown");
        boolean result = closeServer();
        r.Pass("Successfully server shut down.");
        r.closeReport();
        Assert.isTrue(result);
    }

}

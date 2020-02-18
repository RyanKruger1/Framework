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
import org.springframework.util.Assert;

public class UniversalMusic extends AppiumDriverInstance {

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

            StartServerUniversalMusicPlayer();

            r.SetDriver(driver);

            r.Pass("Successfully Started required servers");
    } catch (Exception ex) {

            String message = ex.getMessage();
            System.out.println(message);

        }
    }

    @Test
    public void UniversalTestAndroid() {
        System.out.println("Starting Clicking Test.");

        if (!clickElementByXpath(AppiumPageObjects.Genres())) {
            r.FailWithEmulatorScreenShot("Click Genres");
        }

        if (!clickElementByXpath(AppiumPageObjects.Rock())) {
            r.FailWithEmulatorScreenShot("Click Rock");
        }

        if (!clickElementByXpath(AppiumPageObjects.Awakening())) {
            r.FailWithEmulatorScreenShot("Click Awakening");
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

package Core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;

public class BaseFile {

    public static enum applicationType {
        Appium, Selenium
    }

    public static WebDriver driver;

    public static String tname = "";
    public static String ScreenshotDir = "";
    public static String finalReportDir = "";
    public static int ScreenshotCounter = 0;
    public static String CalculatorActivity = "com.android.calculator2.Calculator";
    public static String CalculatorPackageName = "com.android.calculator2";

    public static String UniversalMusicPlayerActivityName = "com.example.android.uamp.ui.MusicPlayerActivity";
    public static String UniversalMusicPlayerPackageName = "com.example.android.uamp";

    public static String udid = "emulator-5554";
    public static String platform = "Android";

    public static String emulatorLocationFolder = System.getenv("LOCALAPPDATA") + "\\Android\\Sdk\\emulator";

    //Set emulated device details here.....
    public static String avdName = "Nougat";// my devices name is nougat the same name as the version.
    public static String androidVersion = "9.0.0";


}

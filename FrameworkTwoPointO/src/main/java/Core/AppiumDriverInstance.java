package Core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.tools.jar.CommandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

public class AppiumDriverInstance {

    AppiumDriver app;
    public static String port = "4723";
    public static AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService service;
    static URL serverUrl;


    public void StartServer() {
        String command = "appium --port " + port;
        try {

            DesiredCapabilities c = new DesiredCapabilities();

            c.setCapability("deviceName", BaseFile.avdName);
            c.setCapability("udid", BaseFile.udid);
            c.setCapability("platform", BaseFile.platform);
            c.setCapability("platformVersion", BaseFile.androidVersion);
            c.setCapability("appPackage", BaseFile.CalculatorPackageName);
            c.setCapability("appActivity", BaseFile.CalculatorActivity);

            driver = new AppiumDriver<MobileElement>(serverUrl, c);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void StartServerUniversalMusicPlayer() {
        String command = "appium --port " + port;
        try {

            DesiredCapabilities c = new DesiredCapabilities();

            c.setCapability("deviceName", BaseFile.avdName);
            c.setCapability("udid", BaseFile.udid);
            c.setCapability("platform", BaseFile.platform);
            c.setCapability("platformVersion", BaseFile.androidVersion);
            c.setCapability("appPackage", BaseFile.UniversalMusicPlayerPackageName);
            c.setCapability("appActivity", BaseFile.UniversalMusicPlayerActivityName);

            driver = new AppiumDriver<MobileElement>(serverUrl, c);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean StartAppiumServer() {
        try {
            AppiumServiceBuilder ssb = new AppiumServiceBuilder();
            ssb.usingPort(4723);

            service = AppiumDriverLocalService.buildService(ssb);

            if (!service.isRunning()) {
                service.start();
            } else {
                System.out.println("There is already a service running");
            }
            serverUrl = service.getUrl();
            System.out.println((serverUrl));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean CheckServer() {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(Integer.parseInt(port));
            serverSocket.close();
        } catch (IOException e) {

            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static boolean closeServer() {
        try {
            System.out.println(serverUrl);
            service.stop();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }

    }

    public static boolean clickElementByXpath(By id) {
        try {
            WebElement element = driver.findElement(id);
            element.click();

        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static boolean enterTextByXpath(By id, String text) {
        try {
            MobileElement element = driver.findElement(id);
            element.sendKeys(text);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }


}

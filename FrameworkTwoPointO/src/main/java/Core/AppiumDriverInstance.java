package Core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

public class AppiumDriverInstance {

    AppiumDriver app ;
    public static String port = "4723";
   public static  AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService service ;
    static URL serverUrl ;


    public  void StartServer(){
        String command = "appium --port "+ port;
        try
        {

            DesiredCapabilities c = new DesiredCapabilities();

            c.setCapability("deviceName","Nougat");
            c.setCapability("udid","emulator-5554");
            c.setCapability("platform","Android");
            c.setCapability("platformVersion","9.0.0");
            c.setCapability("appPackage","com.android.calculator2");
            c.setCapability("appActivity","com.android.calculator2.Calculator");


            driver = new AppiumDriver<MobileElement>(serverUrl,c);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void CreateDeviceOnEmulator(){
        String command = "emulator @One";
        try
        {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            System.out.println(stdInput.readLine());

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void StartAppiumServer(){
        try
        {

             AppiumServiceBuilder ssb =new AppiumServiceBuilder();
             ssb.usingPort(4723);

             service = AppiumDriverLocalService.buildService(ssb);

             if(!service.isRunning()){
                 service.start();
             }else{
                 System.out.println("There is already a service running");
             }
            serverUrl = service.getUrl();
            System.out.println((serverUrl));

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public static boolean CheckServer(){
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

    public static boolean closeServer(){
        System.out.println(serverUrl);
        service.stop();
        return true;
    }

    public static boolean clickElementByXpath(By id){
        try{
            WebElement element = driver.findElement(id);
            element.click();

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    public static boolean enterTextByXpath(By id , String text){
        try{
            MobileElement element = driver.findElement(id);
            element.sendKeys(text);
        }catch(Exception ex){
            return false;
        }
        return true;
    }






}

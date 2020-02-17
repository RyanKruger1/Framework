package Core;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.model.MediaType;
import com.aventstack.extentreports.model.Screencast;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import freemarker.template.SimpleDate;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends BaseFile {

    static ExtentHtmlReporter html;
    static ExtentTest test;
    static ExtentReports extent;
    static ExtentAventReporter avent;
    static AppiumDriver<MobileElement> appDriver;

    public Reporting(AppiumDriver<MobileElement> driver){
        appDriver  = driver;
    }

    public void SetDriver( AppiumDriver<MobileElement> driver){
        appDriver = driver;
    }


    public boolean CreateReportFile() {
        String file = System.getProperty("user.dir");
        String reportDir = file + "\\Reports";
        File f = new File(reportDir);

        if (!f.exists()) {
            f.mkdir();
        }
        // directory where output is to be printed
        avent = new ExtentAventReporter(f.getPath());

        finalReportDir = f.getPath() + "\\" + tname + "\\" + dateTime();

        ScreenshotDir = finalReportDir + "\\Screenshots";

        File screenShots = new File(ScreenshotDir);

        if (!screenShots.exists()) {
            screenShots.mkdirs();
        }

        String reportfile = finalReportDir + "\\report.html";
        html = new ExtentHtmlReporter(reportfile);

        extent = new ExtentReports();
        test = extent.createTest(tname);

        extent.attachReporter(avent);
        extent.attachReporter(html);
        extent.flush();
        return false;
    }

    public static File TakeScreenShot() {
        try {
            ScreenshotCounter++;
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File f = scrShot.getScreenshotAs(OutputType.FILE);
            File output = new File(ScreenshotDir + "//" + ScreenshotCounter + ".png");
            FileUtils.copyFile(f, output);
            return output;
        } catch (Exception ex) {
            System.out.println("Could not take photo.");
            return null;
        }
    }

    public static File TakeEmulatorScreenShot() {
        try {
            ScreenshotCounter++;
            TakesScreenshot scrShot = ((TakesScreenshot) appDriver);
            File f = scrShot.getScreenshotAs(OutputType.FILE);
            File output = new File(ScreenshotDir + "//" + ScreenshotCounter + ".png");
            FileUtils.copyFile(f, output);
            return output;
        } catch (Exception ex) {
            System.out.println("Could not take photo.");
            return null;
        }
    }

    public void PassWithScreenShot(String message) {
        try {
            test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot().getPath()).build());
            extent.flush();
        } catch (Exception ex) {
            String me = ex.getMessage();
        }
    }

    public void FailWithScreenShot(String message) {
        try {
            test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot().getPath()).build());
            extent.flush();
        } catch (Exception ex) {
            String me = ex.getMessage();
        }
    }

    public void PassWithEmulatorScreenShot(String message) {
        try {
            test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(TakeEmulatorScreenShot().getPath()).build());
            extent.flush();
        } catch (Exception ex) {
            String me = ex.getMessage();
        }
    }

    public void FailWithEmulatorScreenShot(String message ) {
        try {
            test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(TakeEmulatorScreenShot().getPath()).build());
            extent.flush();
        } catch (Exception ex) {
            String me = ex.getMessage();
        }
    }

    public void Pass(String message) {
        test.pass(message);
        extent.flush();
    }

    public void Info(String message) {
        test.info(message);
        extent.flush();
    }

    public void Fail(String message) {
        test.fail(message);
        extent.flush();
    }

    public void closeReport() {
        extent.attachReporter(avent);
        extent.attachReporter(html);
        extent.flush();

    }


    public static String dateTime() {
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
        return f.format(d);
    }


}

package Core;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import freemarker.template.SimpleDate;
import org.jsoup.Connection;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends BaseFile {

    static ExtentHtmlReporter html;
    static String reportDirectory = "";
  static ExtentTest test;
  static ExtentReports extent;
   static  ExtentAventReporter avent ;

    public boolean CreateReportFile(){
        String file = System.getProperty("user.dir");
        String reportDir = file + "\\Reports";
        File f = new File(reportDir);

        if(!f.exists()){
            f.mkdir();
        }
        // directory where output is to be printed
         avent = new ExtentAventReporter(f.getPath());
        html = new ExtentHtmlReporter(f.getPath()+"\\"+tname+"\\"+dateTime()+"\\report.html");
        extent = new ExtentReports();
         test = extent.createTest(tname);

        extent.attachReporter(avent);
        extent.attachReporter(html);
        extent.flush();
        return false;
    }

    public  void Pass(String message){
        test.pass(message);
        extent.flush();
    }

    public void  Fail(String message){
        test.fail(message);
        extent.flush();
    }

    public void closeReport(){
        extent.attachReporter(avent);
        extent.attachReporter(html);
        extent.flush();

    }

    public static String dateTime(){
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
        return f.format(d);
    }





}

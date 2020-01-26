package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverInstance extends BaseFile{

    private static WebDriver driver ;

public static boolean OpenBrowser(){

   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();

    return true;
}

public static boolean navigate(String url){

    driver.get(url);
    return true;
}

public static boolean closeBrowser(){

    driver.close();
    driver.quit();

    return true;
}

public static boolean clickElementByXpath(By el){
        try{
            WebElement element = driver.findElement(el);
            element.click();

        }catch(Exception ex){
            System.out.println("Could not click element");
            return false;
        }

        return true;
    }

    public static boolean EnterTextByXpath(By el , String text){
        try{
            WebElement element = driver.findElement(el);
            element.sendKeys(text);

        }catch(Exception ex){
            System.out.println("Could not click element");
            return false;
        }

        return true;
    }

    public void waitSeconds(int count){
    try{
        Thread.sleep(count);
    }catch(Exception ex){
        System.out.println("Count");
    }
}



}

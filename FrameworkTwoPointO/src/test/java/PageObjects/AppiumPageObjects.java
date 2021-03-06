package PageObjects;

import org.openqa.selenium.*;

public class AppiumPageObjects {

    public static By one(){return By.xpath("//android.widget.Button[@text='1']");}
    public static By two(){return By.xpath("//android.widget.Button[@text='2']");}
    public static By three(){return By.xpath("//android.widget.Button[@text='3']");}
    public static By four(){return By.xpath("//android.widget.Button[@text='4']");}
    public static By five(){return By.xpath("//android.widget.Button[@text='5']");}
    public static By six(){return By.xpath("//android.widget.Button[@text='6']");}
    public static By seven(){return By.xpath("//android.widget.Button[@text='7']");}
    public static By eight(){return By.xpath("//android.widget.Button[@text='8']");}
    public static By nine(){return By.xpath("//android.widget.Button[@text='9']");}

    //----------- Universal Music Player application --------------------------//
    public static By Genres(){return By.xpath("//android.widget.TextView[@text='Genres']");}
    public static By Rock(){return By.xpath("//android.widget.TextView[@text='Rock']");}
    public static By Cinematic(){return By.xpath("//android.widget.TextView[@text='Cinematic']");}
    public static By JazzBlues(){return By.xpath("//android.widget.TextView[@text='Jazz & Blues']");}
    public static By Awakening(){return By.xpath("//android.widget.TextView[@text = 'Awakening']");}

}

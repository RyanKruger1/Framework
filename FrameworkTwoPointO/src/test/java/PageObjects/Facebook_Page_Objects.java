package PageObjects;

import org.openqa.selenium.By;

public class Facebook_Page_Objects {

    public static By username(){return By.xpath("//input[@type='email']");}
    public static By password(){return By.xpath("//input[@type='password']"); }
    public static By loginButton(){return By.xpath("//input[@value='Log In']"); }
    public static By firstName(){return By.xpath("//input[@name='firstname']");}
    public static By surname(){return By.xpath("//input[@name='lastname']");}
    public static By mobileOrEmail(){return By.xpath("//input[@name='reg_email__']");}
    public static By newPassword(){return By.xpath("//input[@name='reg_passwd__']");}
    public static By day(){return By.xpath("//select[@id='day']");}
    public static By month(){return By.xpath("//select[@id='month']");}
    public static By year(){return By.xpath("//select[@id='year']");}
    public static By confirmEmail(){return By.xpath("//input[@name='reg_email_confirmation__']");}
    public static By signUpButton(){ return By.xpath("//div[@class='_58mu']//..//button[text()='Sign Up' and @type='submit']"); }
    public static By gender(String gender){
     return By.xpath("//input[@name='sex']//..//label[text()='"+gender+"']");
    }



}

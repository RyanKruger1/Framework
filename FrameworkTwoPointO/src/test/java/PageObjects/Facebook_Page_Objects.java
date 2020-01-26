package PageObjects;

import org.openqa.selenium.By;

public class Facebook_Page_Objects {

    public static By username(){return By.xpath("//input[@type='email']");}
    public static By password(){return By.xpath("//input[@type='password']"); }
    public static By loginButton(){return By.xpath("//input[@value='Log In']"); }
}

package FaceBookTests;

import Core.Reporting;
import Core.SeleniumDriverInstance;
import PageObjects.Facebook_Page_Objects;
import net.bytebuddy.asm.Advice;

public class LoginAndSubmit extends SeleniumDriverInstance {



    public static String LoginNegative(){
        if(!navigate("https:\\www.facebook.com")){
            System.out.println("Could not navigate to facebook.com");
        }
        r.Pass("Successfully navigated to:" + "Facebook.com");
        waitSeconds(1000);

        if(!EnterTextByXpath(Facebook_Page_Objects.username(),"gggggg@ggggg.ggg")){
            System.out.println("Could not enter username");
        }
        r.Pass("Successfully Enter username");
        waitSeconds(1000);

        if(!EnterTextByXpath(Facebook_Page_Objects.password(),"123456890")){
            System.out.println("Could not enter password");
        }
        r.Pass("Successfully entered password");
        waitSeconds(1000);

        if(!clickElementByXpath(Facebook_Page_Objects.loginButton())){
            System.out.println("Could not click login button");
        }

        r.Pass("Successfully clicked button:" + "Login");
        waitSeconds(1000);


        return null;
    }

    public static String CreateNewUser(){


        if(!EnterTextByXpath(Facebook_Page_Objects.firstName(),"Wanda")){
            r.Fail("Could not enter any text into field.");
        }

        if(!EnterTextByXpath(Facebook_Page_Objects.surname(),"Banda")){
            r.Fail("Could not enter any text into surname field.");
        }

        if(!EnterTextByXpath(Facebook_Page_Objects.mobileOrEmail(),"wandabanda@gmail.com")){
            r.Fail("Could not enter any text into surname field.");
        }
        if(!SelectFromDropDownByXpath(Facebook_Page_Objects.confirmEmail(),"wandabanda@gmail.com")){
            r.Fail("Could not select from day drop down");
        }

        if(!EnterTextByXpath(Facebook_Page_Objects.newPassword(),"wandaheartjeremy123456780")){
            r.Fail("Could not enter any text into surname field.");
        }

        if(!clickElementByXpath(Facebook_Page_Objects.gender("Male"))){
            r.Fail("Could not select male.");
        }

        if(!SelectFromDropDownByXpath(Facebook_Page_Objects.day(),"8")){
            r.Fail("Could not select from day drop down");
        }

        if(!SelectFromDropDownByXpath(Facebook_Page_Objects.month(),"3")){
            r.Fail("Could not select from day drop down");
        }

        if(!SelectFromDropDownByXpath(Facebook_Page_Objects.year(),"1996")){
            r.Fail("Could not select from day drop down");
        }

        if(!clickElementByXpath(Facebook_Page_Objects.signUpButton())){
            r.Fail("Successfully clicked sign up");
        }

        return null;
    }




}

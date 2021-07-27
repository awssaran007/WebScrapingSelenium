package pages;



public class FaceBookLoginPage extends BasePage {
    String btn_take_to_login = "//span[contains(text(),'Login')]";

    String  txt_userName = "//input[@id='email']";

    String txt_password =  "//input[@id='password']";

    String btn_login = "//span[contains(text(),'Login')]/parent::button";



    public void loginToFaceBook(String userName, String passWord)  {try{
        pageWebDriver.clickWebElementIfDisplayed(btn_take_to_login);
        pageWebDriver.type(txt_userName, userName);
        pageWebDriver.type(txt_password, passWord);
        pageWebDriver.clickWebElementIfDisplayed(btn_login);
    }
    catch(Exception e){e.printStackTrace();}
}}
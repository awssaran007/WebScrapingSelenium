package driver;


import org.openqa.selenium.WebDriver;


//This class holds the most frequently required functions for interacting with ui element
//factory pattern implementation

public class DriverManager {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public DriverManager(WebDriver driver) throws Exception {
       try{ DriverManager.driver.set(driver);}
       catch (Exception e) {e.printStackTrace();
           throw new Exception("Unable to create driver..."); } }


    public static WebDriver getWebDriverClient() { return driver.get(); }

}
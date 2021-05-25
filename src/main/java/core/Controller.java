package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.LandingPage;
import pages.LandingPageNoon;
import driver.DriverManager;

import java.sql.Driver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Controller {

    public Controller() {
               initElements(new AjaxElementLocatorFactory(DriverManager.getWebDriverClient(),5), this);
    }


    public LandingPage landingPage() {
        return new LandingPage();
    }

    public LandingPageNoon landingPageNoon() {
        return new LandingPageNoon();
    }



}


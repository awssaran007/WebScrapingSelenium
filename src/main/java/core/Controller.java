package core;


import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.MoneyControlMainPage;
import pages.LandingPageNoon;
import pages.MoneyControlMainPage2;
import pages.MultipleWindows;


public class Controller {

    WebDriver driver;

    public Controller() {
        this.driver = DriverManager.getWebDriverClient();
    }

    public MoneyControlMainPage moneyControlLandingPage() {return new MoneyControlMainPage(); }

    public LandingPageNoon landingPageNoon() {
        return new LandingPageNoon();
    }

    public MultipleWindows landingPageMultipleWindows() { return new MultipleWindows();  }

    public MoneyControlMainPage2 moneyControlLandingPage2() {return new MoneyControlMainPage2(driver); }

}


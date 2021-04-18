package core;

import org.openqa.selenium.WebDriver;
import pageFactory.LandingPage;
import pageFactory.LandingPageNoon;
import utils.WebDriverClient;

public class Controller {
    //this class is the object factory for pagebjects
    WebDriverClient pageWebDriver = null;

    public Controller(WebDriver controllerDriver) {
        pageWebDriver = new WebDriverClient(controllerDriver);
    }

    public LandingPage landingPage() {
        return new LandingPage(pageWebDriver.getWebDriverClient());
    }

    public LandingPageNoon landingPageNoon() {
        return new LandingPageNoon(pageWebDriver.getWebDriverClient());
    }

}

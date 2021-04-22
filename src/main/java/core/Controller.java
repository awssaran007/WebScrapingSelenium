package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import pageFactory.LandingPage;
import pageFactory.LandingPageNoon;
import utils.WebDriverClient;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.out;

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


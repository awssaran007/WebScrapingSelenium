package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ReadYaml;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.System.out;


public class BaseTest {
    protected WebDriver driver;
    protected String testName;
    protected Controller pageController;
    protected ReadYaml rx = new ReadYaml();

    WebDriver browserSetup(String browser) {
//create object of Browsers Enum
        Browsers br = Browsers.valueOf(browser);

        switch (br) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                out.println("Incorrect browser value provided");

        }
        return driver;
    }

    @Parameters({"browser", "hubUrl"})
    @BeforeTest
    public void setUp(String browser, @Optional String hubUrl, ITestContext ctx) throws MalformedURLException {

        //if system uses selenium grid. Grid setup is on docker.
        if (hubUrl != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.LINUX);
            out.println("Hub port: -->    " + hubUrl);
            driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        } else driver = browserSetup(browser);

        //initiated objects factory (Controller) and passed the driver
        pageController = PageFactory.initElements(driver, Controller.class);

        //finds out which test case is pulled
        testName = ctx.getName();
    }

    // @AfterTest
    public void afterTest() {
        if (driver != null) {
            out.println("==== Quiting the browser =====");
            driver.quit();
        }
    }


}

package core;


import driver.BrowsersFactory;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.ReadYaml;
import java.net.MalformedURLException;
import java.net.URL;


import static java.lang.System.out;


@Listeners(utils.TestListenerReporter.class)

public class BaseTest {
    protected WebDriver initialDriver;
    protected ReadYaml rx = new ReadYaml();
    public Controller pageController;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    DesiredCapabilities capabilities = new DesiredCapabilities();



    @Parameters({"browser", "hubUrl"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String browser, @Optional String hubUrl, ITestContext ctx) throws Exception {

        //if system uses selenium grid. Grid setup is on docker.
        if (hubUrl != null) {
            try {
                capabilities.setBrowserName(browser);
                capabilities.setPlatform(Platform.LINUX);
                out.println("Hub port: -->    " + hubUrl);
                initialDriver = new RemoteWebDriver(new URL(hubUrl), capabilities);
            }
            catch (MalformedURLException e) {
                logger.error("Grid URL is invalid or Grid is not available");
                logger.error(String.format("Browser: %s", capabilities.getBrowserName()), e);
            }
            catch (IllegalArgumentException e) {
                logger.error(String.format("Browser %s is not valid or recognized", capabilities.getBrowserName()), e);
            }
        } else  initiateController(new DriverManager(browserSetup(browser)));
    }



    @AfterTest(alwaysRun = true)
    public void postCondition() {
        DriverManager.getWebDriverClient().quit();
    }


    //initiate controller
    void initiateController(DriverManager dr) throws Exception {
        if(!((dr) == null)){
        pageController = new Controller();
        if(pageController == null)
            out.println("Page controller empty");
        } else throw new Exception("Driver object not created..."); }



    WebDriver browserSetup(String browser) {
        //create object of Browsers Enum
        BrowsersFactory br = BrowsersFactory.valueOf(browser.toUpperCase());
        switch(br) {
            case CHROME:
            case FIREFOX:
                initialDriver = br.createDriver();
                break;
            default:
                out.println("Incorrect browser value provided");
        }
        return initialDriver;
    }


    //design patterns POC
    //java basics - interface -POC
    //alerts

    /*   private void initiateEyes() {
        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));

    }*/

    //initiateEyes();
}

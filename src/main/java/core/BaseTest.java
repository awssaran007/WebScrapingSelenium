package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ReadYaml;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static java.lang.System.out;
//behavior
//composition- coffee -> mocha , latte, cappuchino


public class BaseTest {
    protected WebDriver driver;
    protected String testName;
    protected Controller pageController;
    protected ReadYaml rx = new ReadYaml();
    public ThreadLocal threadLocal = null;

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
    protected void takeScreenShot(ITestResult result, WebDriver driver) throws IOException {

        try {
            out.println(driver.getTitle());
            FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("errorScreenshots\\" + result.getName() + "-"
                    + Arrays.toString(result.getParameters()) + ".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }




    /*@AfterMethod
    public void afterMethod(){
        pageController.testListenerReporter();
    }*/

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            out.println("==== Quiting the browser =====");
            driver.quit();
        }
    }


}

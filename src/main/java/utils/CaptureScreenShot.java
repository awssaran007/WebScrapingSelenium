package utils;

import com.relevantcodes.extentreports.ExtentReports;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.System.out;


public class CaptureScreenShot {

    private String actualImageName;
    private static ExtentReports extent;
    private static Calendar calendar;
    private static SimpleDateFormat formatter;




    protected String takeScreenShot() throws IOException {

        try {
            File image = ((TakesScreenshot) DriverManager.getWebDriverClient()).getScreenshotAs(OutputType.FILE);
            String imageLocation = System.getProperty("user.dir") + "\\src\\test\\java\\com\\errorScreenshots\\";
            out.println(imageLocation);
            actualImageName = imageLocation + "Failure-" + formatter.format(calendar.getTime()) + ".png";
            File destFile = new File(actualImageName);
            FileUtils.copyFile(image, destFile);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return actualImageName;
    }
}

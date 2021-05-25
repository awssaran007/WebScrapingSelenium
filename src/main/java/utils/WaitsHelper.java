package utils;

import com.google.common.base.Function;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitsHelper {
    WebDriver driver;

    public WaitsHelper() {
        driver = DriverManager.getWebDriverClient();
    }


    public WebElement waitExplicityly(String s) {

        WebElement e = new WebDriverWait(driver, 8).until((Function<? super WebDriver, WebElement>) driver1 -> driver.findElement(By.xpath(s)));
        new WebDriverWait(driver, 8).withTimeout(5, TimeUnit.SECONDS);

        return e;


    }
}

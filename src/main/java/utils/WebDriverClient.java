package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//This class holds the most frequently required functions for interacting with ui element
//factory pattern implementation

public class WebDriverClient {
    WebDriver myDriver;
    Wait wait;

    public WebDriverClient(WebDriver driver) {
        this.myDriver = driver;
        myDriver.manage().window().fullscreen();
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          }

    public WebDriver getWebDriverClient() {
        return myDriver;
    }

    public String title() {
        return myDriver.getTitle();
    }

    public void click(String locator) throws Exception {
        try {
            WebElement element = myDriver.findElement(By.xpath(locator));
            if (isWebElementDisplayed(element))
                myDriver.findElement(By.xpath(locator)).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchURL(String url) {
        System.out.println("Navigating to url: " + url);
        myDriver.get(url);
        myDriver.navigate().to(url);
        myDriver.switchTo().activeElement().click();
    }

    public void type(String locator, String value) throws Exception {
        try {
            WebElement element = myDriver.findElement(By.xpath(locator));
            if (isWebElementDisplayed(element)) {
                element.clear();
                element.sendKeys(value);
                Reporter.log("Entered value: " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isWebElementDisplayed(WebElement element) {
        try {
            if (element.isDisplayed())
                return true;
        } catch (Exception e) {
        }
        return false;
    }


    public String readText(String textBox) throws InterruptedException {
        String text = null;
        WebElement element = myDriver.findElement(By.xpath(textBox));
        if (isWebElementDisplayed(element))
            text = element.getAttribute("value");
        else throw new InterruptedException();
        return text;

    }
}
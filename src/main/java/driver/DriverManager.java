package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//This class holds the most frequently required functions for interacting with ui element
//factory pattern implementation

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverManager() {
    }

    public DriverManager(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static WebDriver getWebDriverClient() {
        return driver.get();
    }

    public String title() {
        return getWebDriverClient().getTitle();
    }

    public void click(String locator) throws Exception {
        try {
            WebElement element = getWebDriverClient().findElement(By.xpath(locator));
            if (isWebElementDisplayed(element))
                getWebDriverClient().findElement(By.xpath(locator)).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchURL(String url) {
        System.out.println("Navigating to url: " + url);
        getWebDriverClient().get(url);
        getWebDriverClient().navigate().to(url);
        getWebDriverClient().switchTo().activeElement().click();
    }

    public void type(String locator, String value) throws Exception {
        try {
            WebElement element = getWebDriverClient().findElement(By.xpath(locator));
            if (isWebElementDisplayed(element)) {
                element.clear();
                element.sendKeys(value);
                System.out.println("Entered value: " + value);
            }
        } catch (Exception e) {
            throw new Exception("Unable to type the text in the element ", e);
        }
    }

    public boolean isWebElementDisplayed(WebElement element) throws Exception {
        try {
            if (element.isDisplayed())
                return true;
        } catch (Exception e) {
            throw new Exception("Unable to find elements ", e);
        }
        return false;
    }

    public boolean isWebElementDisplayed(List<WebElement> elements) throws Exception {
        try {
            elements.stream().map(e -> e.isDisplayed());
        } catch (Exception e) {
            throw new Exception("Unable to find elements ", e);
        }
        return false;
    }


    public String readText(String textBox) throws Exception {
        String text = null;
        WebElement element = getWebDriverClient().findElement(By.xpath(textBox));
        if (isWebElementDisplayed(element))
            text = element.getAttribute("value");
        else throw new InterruptedException();
        return text;

    }
}
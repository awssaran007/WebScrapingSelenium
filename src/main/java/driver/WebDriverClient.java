package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class WebDriverClient {

    WebDriver driver;
    WebElement e;


    public WebDriverClient() { driver = DriverManager.getWebDriverClient(); }


    public String title() {
        return driver.getTitle();
    }


    public void launchURL(String url) throws Exception {
        try {
            System.out.println("Navigating to url: " + url);
            driver.get(url);
        }
        catch (Exception e) { throw new Exception("Unable to reach URL :" + url, e); }
    }


    public void type(String locator, String value) throws Exception {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            if (isWebElementDisplayed(element)) {
                element.clear();
                element.sendKeys(value);
                System.out.println("Entered value: " + value);
            }
        }
        catch (Exception e) { throw new Exception("Unable to type the text in the element", e);}
    }

    public boolean isWebElementDisplayed(WebElement element) throws Exception {
        try { if (element.isDisplayed()) return true;  }
        catch (Exception e) { throw new Exception("Unable to find elements ", e); }
        return false;
    }



    public boolean areWebElementsDisplayed(List<WebElement> elements) throws Exception {
        try { elements.stream().map(e -> e.isDisplayed()); }
        catch (Exception e) {throw new Exception("Unable to find elements ", e);}
        return false;
    }


    public void clickWebElementIfDisplayed(WebElement element) throws Exception {
        try {   if (e.isDisplayed())
                e.click(); }
        catch (Exception e) { throw new Exception("Unable to find element ", e); }
    }


    public void getWindowHandleIfMulti() throws Exception {
        try {
            String currentwindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();
            allWindows.forEach(childWindow -> System.out.println(childWindow));
            allWindows.remove(currentwindow);
            allWindows.forEach(childWindow -> System.out.println(driver.switchTo().window(childWindow).getTitle()));
        }
        catch (Exception e) {throw new Exception("Unable to find element ", e); }
    }


    public String readText(String textBox) throws Exception {
        String text = null;
        WebElement element = driver.findElement(By.xpath(textBox));
        if (isWebElementDisplayed(element))
            text = element.getAttribute("value");
        else throw new InterruptedException();
        return text; }


    public void quitBrowser() {
        driver.quit();
    }


    public static String getInfo() {
        Capabilities cap = ((RemoteWebDriver) DriverManager.getWebDriverClient()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platform = cap.getPlatformName().toString();
        String version = cap.getBrowserVersion();
        return String.format("browser: %s v: %s platform: %s", browserName, version, platform);
    }
}

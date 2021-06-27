package pages;


import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindows extends BasePage {

    @FindBy(xpath ="//div[@class='example']/a")
    WebElement href_windows;


    public MultipleWindows() {
        PageFactory.initElements(DriverManager.getWebDriverClient(), MultipleWindows.class);  }


    public boolean clickAndOpenNewWindow() throws Exception {
        try{
            pageWebDriver.clickWebElementIfDisplayed(href_windows);
            pageWebDriver.clickWebElementIfDisplayed(href_windows);
            pageWebDriver.clickWebElementIfDisplayed(href_windows);
            pageWebDriver.clickWebElementIfDisplayed(href_windows);
            pageWebDriver.getWindowHandleIfMulti();
        }  catch (Exception e) {e.printStackTrace();
        throw new Exception("Cannot open pages");}
        return false;
    }
}




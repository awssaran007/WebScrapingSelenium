package pages;


import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MoneyControlMainPage2 extends BasePage {

    WebDriver driver;

    @CacheLookup
    @FindBy(xpath ="//div[@class='example']/a")
    WebElement href_windows;

    public MoneyControlMainPage2(WebDriver driver) {
        this.driver = driver;
        System.out.println("hello");
        PageFactory.initElements(driver, this);  }



    public void sayHello() throws Exception {
        try {
            System.out.println("hi");
           // pageWebDriver.clickWebElementIfDisplayed(href_windows);
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}
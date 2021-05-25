package pages;


import core.Controller;
import driver.DriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class LandingPageKitchen extends Controller {

    DriverManager pageWebDriver;

    @FindBy(xpath = "//h3[contains(text(),'123')]/ancestor::div[@class='sc-jQbIHB gTZZqe']//div[@class='kcs0h5-0 diNcmV grid']")
    List<WebElement> recommendedProductsList;


    public LandingPageKitchen(WebDriver driver) {
        pageWebDriver = new DriverManager(driver);
        PageFactory.initElements(driver, this);
    }

    public String gotoLandingPage(String url) throws MalformedURLException {
        try {
            pageWebDriver.launchURL(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MalformedURLException(url + " Url seems invalid");
        }

        return pageWebDriver.title();
    }

    public boolean readRecommendedProductNames() throws Exception {
        try {//recommended
            if (pageWebDriver.isWebElementDisplayed(recommendedProductsList)) {
              /*  listOfRecommendedProducts.addAll(recommendedProductsList.stream().map(s -> s.getAttribute("title")).collect(Collectors.toSet()));
                listOfRecommendedProducts.forEach(s -> System.out.println(s));
               */
                return true;
            } //should terminate automatically
            else throw new NotFoundException("Element not found");
        } catch (Exception e) {
            //which particular element or function
            e.printStackTrace();
        }
        return false;
    }


}

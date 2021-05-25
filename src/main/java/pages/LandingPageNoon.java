package pages;


import core.Controller;
import driver.DriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LandingPageNoon extends Controller {
    Set listOfRecommendedProducts = new TreeSet();
    DriverManager pageWebDriver;

    @FindBy(xpath = "//h3[contains(text(),'123')]/ancestor::div[@class='sc-jQbIHB gTZZqe']//div[@class='kcs0h5-0 diNcmV grid']")
    List<WebElement> recommendedProductsList;


    public LandingPageNoon() {
        pageWebDriver = new DriverManager();

    }

    public String gotoLandingPage(String url) throws Exception {
        try {
            pageWebDriver.launchURL(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Url not valid");
        }
        return pageWebDriver.title();
    }

    public boolean readRecommendedProductNames() throws Exception {
        try {
            if (pageWebDriver.isWebElementDisplayed(recommendedProductsList)) {
              /*  listOfRecommendedProducts.addAll(recommendedProductsList.stream().map(s -> s.getAttribute("title")).collect(Collectors.toSet()));
                listOfRecommendedProducts.forEach(s -> System.out.println(s));
               */
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException(recommendedProductsList + "Element not found");

        }
        return false;
    }


}

package pages;



import driver.WebDriverClient;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LandingPageNoon extends BasePage {
    Set listOfRecommendedProducts = new TreeSet();
    WebDriverClient pageWebDriver;

    @FindBy(xpath = "//h3[contains(text(),'123')]/ancestor::div[@class='sc-jQbIHB gTZZqe']//div[@class='kcs0h5-0 diNcmV grid']")
    List<WebElement> recommendedProductsList;


    public LandingPageNoon() {

        pageWebDriver = new WebDriverClient();

    }



    public boolean readRecommendedProductNames() throws Exception {
        try {
            if (pageWebDriver.areWebElementsDisplayed(recommendedProductsList)) {
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

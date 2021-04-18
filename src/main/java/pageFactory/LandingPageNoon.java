package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverClient;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LandingPageNoon {
    Set listOfRecommendedProducts = new TreeSet();
    WebDriverClient pageWebDriver;

    @FindBy(xpath = "//h3[contains(text(),'Recommend')]/ancestor::div[@class='sc-jQbIHB gTZZqe']//div[@class='kcs0h5-0 diNcmV grid']")
    List<WebElement> recommendedProductsList;


    public LandingPageNoon(WebDriver driver) {
        pageWebDriver = new WebDriverClient(driver);
        PageFactory.initElements(driver, this);
    }

    public String gotoLandingPage(String url) {
        pageWebDriver.launchURL(url);
        return pageWebDriver.title();
    }

    public void readRecommendedProductNames() throws Exception {
        try {
            listOfRecommendedProducts.addAll(recommendedProductsList.stream().map(s -> s.getAttribute("title")).collect(Collectors.toSet()));
            listOfRecommendedProducts.forEach(s -> System.out.println(s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

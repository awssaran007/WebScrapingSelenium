package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utils.WebDriverClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LandingPage {
    List<String> stocks;
    List<String> values;
    Map newMap;

    @FindBy(xpath = "//div[@id='topgain_bse']/descendant::tr/td[1]")
    List<WebElement> stocksPath;

    @FindBy(xpath = "//div[@id='topgain_bse']/descendant::tr/td[2]")
    List<WebElement> valuesPath;


    WebDriverClient pageWebDriver;

    public LandingPage(WebDriver driver) {
        pageWebDriver = new WebDriverClient(driver);
        PageFactory.initElements(driver,this);
    }

    public String gotoLandingPage(String url) {
        pageWebDriver.launchURL(url);
        return pageWebDriver.title();
    }


    public void scrapStockAndValues() {
       stocks = stocksPath.stream().map(s -> s.getText()).collect(Collectors.toList());
       values = valuesPath.stream().map(s -> s.getText()).collect(Collectors.toList());

        List finalKeys = stocks;
        List finalValues = values;
        newMap = IntStream.range(0, stocks.size())
                .collect(HashMap::new,
                        (m, i) -> m.put(finalKeys.get(i), finalValues.get(i)),
                        Map::putAll);
        newMap.forEach((k, v) -> Reporter.log("stocks:" + k + " values: " + v));
    }
}
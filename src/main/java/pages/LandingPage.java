package pages;


import core.Controller;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import driver.DriverManager;

import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LandingPage extends Controller {
    List<String> stocks;
    List<String> values;
    Map newMap;
    List finalKeys = stocks;
    List finalValues = values;
    DriverManager pageWebDriver;

    public LandingPage() {
        pageWebDriver = new DriverManager();
    }

    public void setStocksPath(List<WebElement> stocksPath) {
        this.stocksPath = stocksPath;
    }

    @FindBy(xpath = "//div[@id='topgain_bse']/descendant::tr/td[1]")
    List<WebElement> stocksPath;

    @FindBy(xpath = "//div[@id='topgain_bse']/descendant::tr/td[2]")
    List<WebElement> valuesPath;

    //@CacheLookup
            //where page is not dynamic



//    public LandingPage(WebDriver driver) {
//        pageWebDriver = new DriverManager(driver);
//        PageFactory.initElements(driver, this);
//    /*/**/*/}



    public String gotoLandingPage(String url) {
        try{
            pageWebDriver.launchURL(url);
        }
        catch (Exception e){

        }

        return pageWebDriver.title();
    }


    public void scrapStockAndValues() throws Exception {
        try {//write a function for list as parameter and return hashmap
            //preferred -> linked list to be sure of the order, if order intensive
            stocks = stocksPath.stream().map(s -> s.getText()).collect(Collectors.toList());
            values = valuesPath.stream().map(s -> s.getText()).collect(Collectors.toList());
            newMap = IntStream.range(0, stocks.size())
                    .collect(HashMap::new,
                            (m, i) -> m.put(finalKeys.get(i), finalValues.get(i)),
                            Map::putAll);
            newMap.forEach((k, v) -> Reporter.log("stocks:" + k + " values: " + v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
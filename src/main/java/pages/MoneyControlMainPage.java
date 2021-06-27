package pages;



import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoneyControlMainPage extends BasePage {
    List<String> stocks, values;
    Map newMap;


    @FindBy(xpath = "//div[@id='topgain_bse']/descendant::tr/td[1]")
    List<WebElement> stocksPath;

    @FindBy(xpath = "//div[@id='topgain_bse']/descendant::tr/td[2]")
    List<WebElement> valuesPath;

    public MoneyControlMainPage() {
    PageFactory.initElements(DriverManager.getWebDriverClient(), this);  }

    //@CacheLookup
    //where page is not dynamic



    public void scrapStockAndValues() throws Exception {
        try {
            stocks = stocksPath.stream().map(s -> s.getText()).collect(Collectors.toList());
            values = valuesPath.stream().map(s -> s.getText()).collect(Collectors.toList());
            newMap = IntStream.range(0, stocks.size())
                              .collect(HashMap::new,
                                       (m, i) -> m.put(stocks.get(i), values.get(i)),
                                       Map::putAll);
            newMap.forEach((k, v) -> System.out.println("stocks:" + k + " values: " + v));
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}
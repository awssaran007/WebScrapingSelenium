package pages;

import driver.WebDriverClient;



public class BasePage {

    WebDriverClient pageWebDriver;

    public BasePage() { pageWebDriver = new  WebDriverClient();  }

    public String gotoLandingPage(String url) { try { pageWebDriver.launchURL(url); }
    catch (Exception e) { e.printStackTrace();}
        return pageWebDriver.title();
    }
}

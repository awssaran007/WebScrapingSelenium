package com.testclass;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class KitchenTools extends BaseTest {

    String url3,kitchenAppli = null;


    public KitchenTools() throws FileNotFoundException {
        url3 = rx.readConfig().get("url3");
        kitchenAppli = rx.readConfig().get("kitchenAppli");
    }

    @Test(description = "Opens my favourite sites", priority = 1)
    public void test001_OpenNoonSiteReadCarousel() throws Exception {
        pageController.landingPageNoon().gotoLandingPage(url3);
        Assert.assertTrue(pageController.landingPageNoon().readRecommendedProductNames());

    }
}






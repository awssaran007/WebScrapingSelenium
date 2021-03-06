package com.testclass;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class ReadCarousel extends BaseTest {

    String url2, noontitle = null;


    public ReadCarousel() throws FileNotFoundException {
        url2 = rx.readConfig().get("url2");
        noontitle = rx.readConfig().get("mctitile");
    }

    @Test(description = "Opens my favourite sites", priority = 1)
    public void test001_OpenNoonSiteReadCarousel() throws Exception {
        pageController.landingPageNoon().gotoLandingPage(url2);
        Assert.assertTrue(pageController.landingPageNoon().readRecommendedProductNames());

    }
}






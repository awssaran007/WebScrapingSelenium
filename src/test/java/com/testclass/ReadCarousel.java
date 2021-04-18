package com.testclass;

import core.BaseTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class ReadCarousel extends BaseTest {

    String url2, noontitle = null;



    public ReadCarousel() throws FileNotFoundException {
       url2 = rx.readConfig().get("url2");
       noontitle = rx.readConfig().get("mctitile");
    }

    @Test(description = "Opens my favourite sites", priority=1)
    public void test001_OpenMoneyControl() throws Exception {
        pageController.landingPageNoon().gotoLandingPage(url2);
        pageController.landingPageNoon().readRecommendedProductNames();

    }



/*
    @Test(description = "Opens my favourite sites", priority=2)
    public void test002_OpenBrainPickings() throws Exception
        {
            driver.switchTo().newWindow(WindowType.TAB).get(url2);
            Assert.assertEquals(driver.getTitle(), "Brain Pickings – An inventory of the meaningful life.");
        }*/





    }






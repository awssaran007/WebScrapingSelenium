package com.testclass;

import core.BaseTest;
import org.apache.commons.io.FileUtils;
import org.jsoup.select.Collector;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class FindTopGainers extends BaseTest {

    String url1, url2, url3, mctitle = null;



    public FindTopGainers() throws FileNotFoundException {
       url1 = rx.readConfig().get("url1");
       mctitle = rx.readConfig().get("mctitle");
    }

    @Test(description = "Opens my favourite sites", priority=1)
    public void test001_OpenMoneyControl() throws Exception {
        pageController.landingPage().gotoLandingPage(url1);
        pageController.landingPage().scrapStockAndValues();
        Assert.assertEquals(driver.getTitle(), mctitle);
    }

    }






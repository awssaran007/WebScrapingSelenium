package com.testclass;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MoneyControlMainPage2;

import java.io.FileNotFoundException;


public class FindTopGainers2 extends BaseTest {

    MoneyControlMainPage2 m;


    @Test(description = "Opens my favourite sites", priority = 1)
    public void test001_OpenMoneyControl() throws Exception {
       m = pageController.moneyControlLandingPage2();
       m.gotoLandingPage(rx.readConfig().
                get("herokuUrlMultiWindow"));
       m.sayHello();
    }
}






package utils;

import core.BaseTest;
import core.Controller;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;


public class TestListenerReporter extends BaseTest implements ITestListener  {


   BaseTest bt = null;


    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            //upcasting of driver object
            try {
                takeScreenShot(result, (WebDriver) bt.threadLocal.get());
            } catch (IOException e) {
                e.printStackTrace();
            }
                   }

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("---------Test suite started---------");
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Tests Failed due to time out");
    }


    public void onFinish(ITestContext testContext) {
        if (testContext.getPassedTests().size() != 0) {
            System.out.println("==== PASSED TEST CASES ====");
            testContext.getPassedTests().getAllResults()
                    .forEach(result -> {
                        System.out.println(result.getName());
                    });
        }
        if (testContext.getFailedTests().size() != 0) {
            System.out.println("==== FAILED TEST CASES ====");
            testContext.getFailedTests().getAllResults()
                    .forEach(result -> {
                                System.out.println(result.getName());
                            }
                    );
        }

        System.out.println(
                "Test completed on: " + "\n" + testContext.getEndDate().toString());


    }
}
package utils;

import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListenerReporter implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("F");
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
                "Test completed on: "+"\n" + testContext.getEndDate().toString());


    }
}
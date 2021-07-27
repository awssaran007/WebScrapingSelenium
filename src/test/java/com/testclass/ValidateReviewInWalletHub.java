package com.testclass;

import core.BaseTest;
import data.FacebookDataFactory;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;


public class ValidateLoginToFacebook extends BaseTest   {
    FacebookDataFactory fBDataFactory;

    ValidateLoginToFacebook() throws FileNotFoundException {
        fBDataFactory  = new FacebookDataFactory();
    }

    @Test(description = "Validate login to facebook", priority = 1)
    public void test001_LoginToFacebook() throws Exception {
      try{  pageController.FaceBookLoginPage().gotoLandingPage(fBDataFactory.getUrl());
        pageController.FaceBookLoginPage().loginToFaceBook(fBDataFactory.getUserEmail(), fBDataFactory.getPassWord());
      /*  pageController.FaceBookLandingPage().clickOnName(fBDataFactory.getFirstName(),fBDataFactory.getLastName());
        Assert.assertEquals(pageController.FaceBookLandingPage().isUserLoggedIn(fBDataFactory.getFirstName(),fBDataFactory.getLastName()), false, "Given user is not logged in....");
          pageController.FaceBookLandingPage().clickToAddStatus();
          pageController.FaceBookLandingPage().writeStatusMessage("hello");*/
      }
    catch(Exception e){e.printStackTrace();}
}


}




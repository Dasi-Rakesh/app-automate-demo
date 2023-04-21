package com.browserstack;

import com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  BrowserStackDemoAppTest extends AppiumTest {

    @Test
    public void test() {
        /***
         Apply Filter, Select "Samsung" & "High to low" Filter and Product to cart
         ***/
        HomePage homePage = new HomePage(driver);
        homePage.clickOnFilterButton();
        homePage.clickSamsungVendor();
        homePage.clickAddToCartAndCheckout();
        Assert.assertTrue(homePage.verifySignInButtonDisplayed(), "Element not displayed");
    }
}

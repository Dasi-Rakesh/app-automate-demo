package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private static int x_coordinate;
    private static int y_coordinate;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }
    static By filterButton = MobileBy.xpath("//android.widget.TextView[@text='Filter & Sort']");
    static By samsungVendor = MobileBy.xpath("//android.widget.TextView[@text='Samsung']");
    public static By signInButton = MobileBy.xpath("//android.widget.TextView[@text='Sign in']");
    static By checkoutButton = MobileBy.xpath("//android.view.ViewGroup[@content-desc='checkout-btn']/android.widget.TextView");
    static By cartIcon = MobileBy.xpath("//android.view.ViewGroup[@content-desc='nav-cart']/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    static By addToCart = MobileBy.xpath("//android.view.ViewGroup[@content-desc='add-to-cart-12']");
    public  void clickOnFilterButton(){
        shortSleep();
        x_coordinate = getXcord(filterButton);
        y_coordinate = getYcord(filterButton);
        shortSleep();
        VerifyElementDisplayedAndClick(filterButton);
    }
    public  void clickSamsungVendor(){
        VerifyElementDisplayedAndClick(samsungVendor);
        tapByCoordinates(x_coordinate, y_coordinate);
    }
    public  void clickAddToCartAndCheckout(){
        VerifyElementDisplayedAndClick(addToCart);
        shortSleep();
        VerifyElementDisplayedAndClick(cartIcon);
        shortSleep();
        VerifyElementDisplayedAndClick(checkoutButton);
        shortSleep();
    }

    public boolean verifySignInButtonDisplayed(){
        return IsElementDisplayed(signInButton);
    }
}
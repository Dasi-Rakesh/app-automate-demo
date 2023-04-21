package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {
    protected static AppiumDriver driver;
    protected static WebDriverWait wait;
    protected JavascriptExecutor javascriptExecutor;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected static void shortSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected static void VerifyElementDisplayedAndClick(By locator) {
        try {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()) {
                shortSleep();
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
            }
        } catch (Exception e) {
            System.out.println("Element not clicked");
        }
    }

    public static boolean IsElementDisplayed(By elementLocator) {
        boolean result;
        try {
            result = driver.findElement(elementLocator).isDisplayed();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public void tapByCoordinates(int x, int y) {
        new TouchAction((PerformsTouchActions) driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    public static int getXcord(By locator) {
        Point point = driver.findElement(locator).getLocation();

        int xcord = point.getX();

        System.out.println("X Coordinate: " + xcord);

        return xcord;
    }

    public static int getYcord(By locator) {
        Point point = driver.findElement(locator).getLocation();

        int ycord = point.getY();

        System.out.println("X Coordinate: " + ycord);

        return ycord;
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void hideKeyboard() {
        driver.navigate().back();
    }

    protected List<WebElement> waitAndFindElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitForElementClikable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendKey(By by, String text) {
        waitAndFindElement(by).sendKeys(text);
    }

    public List<WebElement> getElements(By elementLocator) {
        try {
            List<WebElement> elements = driver.findElements(elementLocator);
            return elements;
        } catch (WebDriverException exception) {
            throw new WebDriverException(
                    "Element with locator : " + elementLocator + " was not displayed and unable to get the count",
                    exception);
        }
    }
}

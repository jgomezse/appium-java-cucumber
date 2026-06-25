package com.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final Logger log = LogManager.getLogger(BasePage.class);
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);

    protected final AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElement(By locator) {
        return waitForElement(locator, DEFAULT_TIMEOUT);
    }

    protected WebElement waitForElement(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {
        waitForElementClickable(locator).click();
        log.debug("Click en: {}", locator);
    }

    public void write(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
        log.debug("Texto '{}' escrito en: {}", text, locator);
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public String getAttribute(By locator, String attribute) {
        return waitForElement(locator).getAttribute(attribute);
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public byte[] takeScreenshot() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
        log.debug("Scroll hasta texto: {}", text);
    }

    public void scrollToContentDesc(String desc) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"" + desc + "\"))"
        ));
        log.debug("Scroll hasta content-desc: {}", desc);
    }
}

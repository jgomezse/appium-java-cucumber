package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
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

    public void click(By locator) {
        waitForElement(locator).click();
        log.debug("Click en: {}", locator);
    }

    public void type(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
        log.debug("Texto '{}' escrito en: {}", text, locator);
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public byte[] takeScreenshot() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}

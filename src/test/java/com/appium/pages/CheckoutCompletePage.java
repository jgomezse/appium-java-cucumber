package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {

    private static final By screen = By.xpath("//*[@content-desc='test-CHECKOUT: COMPLETE!']");
    private static final By backHomeButton = By.xpath("//*[@content-desc='test-BACK HOME']");

    public CheckoutCompletePage(AndroidDriver driver) {
        super(driver);
    }

    public By getScreen() {
        return screen;
    }

    public By getBackHomeButton() {
        return backHomeButton;
    }
}

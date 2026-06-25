package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {

    private static final By screen = By.xpath("//*[@content-desc='test-CHECKOUT: OVERVIEW']");
    private static final By finishButton = By.xpath("//*[@content-desc='test-FINISH']");

    public CheckoutOverviewPage(AndroidDriver driver) {
        super(driver);
    }

    public By getScreen() {
        return screen;
    }

    public By getFinishButton() {
        return finishButton;
    }
}

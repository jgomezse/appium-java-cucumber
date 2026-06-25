package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private static final By screen = By.xpath("//*[@content-desc='test-Cart Content']");
    private static final By checkoutButton = By.xpath("//*[@content-desc='test-CHECKOUT']");

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    public By getScreen() {
        return screen;
    }

    public By getCheckoutButton() {
        return checkoutButton;
    }
}

package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private static final By screen = By.xpath("//*[@content-desc='test-PRODUCTS']");
    private static final By addToCartButton = By.xpath("//*[@content-desc='test-ADD TO CART']");
    private static final By removeButton = By.xpath("//*[@content-desc='test-REMOVE']");
    private static final By cartIcon = By.xpath("//*[@content-desc='test-Cart']");
    private static final By menuIcon = By.xpath("//*[@content-desc='test-Menu']");

    public ProductsPage(AndroidDriver driver) {
        super(driver);
    }

    public By getScreen() {
        return screen;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }

    public By getRemoveButton() {
        return removeButton;
    }

    public By getCartIcon() {
        return cartIcon;
    }

    public By getMenuIcon() {
        return menuIcon;
    }
}

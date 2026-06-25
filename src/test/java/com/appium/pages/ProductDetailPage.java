package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {

    private static final By screen = By.xpath("//*[@content-desc='test-Inventory item page']");
    private static final By backButton = By.xpath("//*[@content-desc='test-BACK TO PRODUCTS']");
    private static final By imageContainer = By.xpath("//*[@content-desc='test-Image Container']");
    private static final By description = By.xpath("//*[@content-desc='test-Description']");
    private static final By price = By.xpath("//*[@content-desc='test-Price']");
    private static final By addToCartButton = By.xpath("//*[@content-desc='test-ADD TO CART']");

    public ProductDetailPage(AndroidDriver driver) {
        super(driver);
    }

    public By getScreen() {
        return screen;
    }

    public By getBackButton() {
        return backButton;
    }

    public By getImageContainer() {
        return imageContainer;
    }

    public By getDescription() {
        return description;
    }

    public By getPrice() {
        return price;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }
}

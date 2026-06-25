package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutInfoPage extends BasePage {

    private static final By firstNameInput = By.xpath("//*[@content-desc='test-First Name']");
    private static final By lastNameInput = By.xpath("//*[@content-desc='test-Last Name']");
    private static final By zipInput = By.xpath("//*[@content-desc='test-Zip/Postal Code']");
    private static final By continueButton = By.xpath("//*[@content-desc='test-CONTINUE']");

    public CheckoutInfoPage(AndroidDriver driver) {
        super(driver);
    }

    public By getFirstNameInput() {
        return firstNameInput;
    }

    public By getLastNameInput() {
        return lastNameInput;
    }

    public By getZipInput() {
        return zipInput;
    }

    public By getContinueButton() {
        return continueButton;
    }
}

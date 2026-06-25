package com.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By usernameInput = By.xpath("//*[@content-desc='test-Username']");
    private static final By passwordInput = By.xpath("//*[@content-desc='test-Password']");
    private static final By loginButton = By.xpath("//*[@content-desc='test-LOGIN']");
    private static final By errorMessage = By.xpath("//*[@content-desc='test-Error message']");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public By getUsernameInput() {
        return usernameInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getErrorMessage() {
        return errorMessage;
    }
}

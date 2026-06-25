package com.appium.hooks;

import com.appium.config.AppiumConfig;
import com.appium.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        log.info("Starting scenario");
        AppiumConfig.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = new BasePage(AppiumConfig.getDriver()).takeScreenshot();
                Allure.addAttachment(
                        "Screenshot_" + scenario.getName(),
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png"
                );
                log.info("Screenshot attached for failed scenario: {}", scenario.getName());
            } catch (Exception e) {
                log.error("Failed to capture screenshot", e);
            }
        }
        AppiumConfig.quitDriver();
        log.info("Scenario finished: {}", scenario.getName());
    }
}

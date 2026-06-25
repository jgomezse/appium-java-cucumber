package com.appium.config;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {

    private static final Logger log = LogManager.getLogger(AppiumConfig.class);
    private static AndroidDriver driver;

    private AppiumConfig() {}

    public static void initDriver() {
        if (driver != null) return;

        try {
            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    CapabilitiesConfig.getCapabilities()
            );
            log.info("AndroidDriver initialized");
        } catch (MalformedURLException e) {
            log.error("Invalid Appium server URL", e);
            throw new RuntimeException(e);
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
                log.info("AndroidDriver quit");
            } catch (Exception e) {
                log.error("Error quitting driver", e);
            } finally {
                driver = null;
            }
        }
    }
}

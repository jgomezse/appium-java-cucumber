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
            log.info("AndroidDriver inicializado");
        } catch (MalformedURLException e) {
            log.error("URL del servidor Appium inválida", e);
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
                log.info("AndroidDriver finalizado");
            } catch (Exception e) {
                log.error("Error al finalizar el driver", e);
            } finally {
                driver = null;
            }
        }
    }
}

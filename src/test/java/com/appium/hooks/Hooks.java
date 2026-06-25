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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        log.info("Iniciando escenario");
        AppiumConfig.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            byte[] screenshot = new BasePage(AppiumConfig.getDriver()).takeScreenshot();
            scenario.attach(screenshot, "image/png", "Screenshot_" + scenario.getName());
            Allure.addAttachment(
                    "Screenshot_" + scenario.getName(),
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    "png");
            log.info("Screenshot adjuntado: {}", scenario.getName());
        } catch (Exception e) {
            log.error("Error al capturar screenshot", e);
        }
        if (scenario.isFailed()) {
            try {
                String source = AppiumConfig.getDriver().getPageSource();
                Path path = Paths.get("build", "page-source", scenario.getName().replaceAll("\\s+", "_") + ".xml");
                Files.createDirectories(path.getParent());
                Files.writeString(path, source, StandardCharsets.UTF_8);
                log.info("Page source guardado: {}", path.toAbsolutePath());
            } catch (Exception e) {
                log.error("Error al guardar page source", e);
            }
        }
        AppiumConfig.quitDriver();
        log.info("Escenario finalizado: {}", scenario.getName());
    }
}

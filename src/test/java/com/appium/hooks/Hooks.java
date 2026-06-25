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
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = new BasePage(AppiumConfig.getDriver()).takeScreenshot();
                Allure.addAttachment(
                        "Screenshot_" + scenario.getName(),
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png");
                log.info("Screenshot adjuntado para escenario fallido: {}", scenario.getName());
            } catch (Exception e) {
                log.error("Error al capturar screenshot", e);
            }
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

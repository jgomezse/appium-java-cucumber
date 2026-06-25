package com.appium.steps;

import com.appium.config.AppiumConfig;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;

public class ExploracionSteps {

    private static final Logger log = LogManager.getLogger(ExploracionSteps.class);
    private static final Path OUTPUT_DIR = Paths.get("build", "exploracion");

    @When("navego a la url {string}")
    public void navigateToUrl(String url) {
        try {
            AppiumConfig.getDriver().executeScript("mobile: deepLink", Map.of(
                    "url", url,
                    "package", "com.swaglabsmobileapp"));
            log.info("Deep link navegado: {}", url);
        } catch (Exception e) {
            log.warn("Deep link {} falló: {} — se capturará la pantalla actual igualmente", url, e.getMessage());
        }
    }

    @When("espero que cargue la pantalla")
    public void waitForScreen() throws InterruptedException {
        Thread.sleep(3000);
        log.info("Espera completada (3s)");
    }

    @When("capturo page source de {string}")
    public void capturePageSource(String filename) {
        try {
            Files.createDirectories(OUTPUT_DIR);
            String source = AppiumConfig.getDriver().getPageSource();
            Path filePath = OUTPUT_DIR.resolve(filename);
            Files.writeString(filePath, source);
            log.info("Page source guardado: {} ({} bytes)", filePath.toAbsolutePath(), source.length());
        } catch (IOException e) {
            log.error("Error al guardar page source", e);
            fail("No se pudo guardar page source: " + e.getMessage());
        }
    }
}

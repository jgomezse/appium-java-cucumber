package com.appium.steps;

import com.appium.config.AppiumConfig;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommonSteps {

    private static final Logger log = LogManager.getLogger(CommonSteps.class);

    @Given("la app esta abierta")
    public void laAppEstaAbierta() {
        Map<String, String> params = new HashMap<>();
        params.put("url", "swaglabs://");
        params.put("package", "com.swaglabsmobileapp");
        AppiumConfig.getDriver().executeScript("mobile: deepLink", params);
        log.info("App abierta via deep link a la pantalla de login");
    }
}

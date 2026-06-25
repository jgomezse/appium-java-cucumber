package com.appium.steps;

import com.appium.config.AppiumConfig;
import com.appium.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class EjemploSteps {

    private static final Logger log = LogManager.getLogger(EjemploSteps.class);
    private final BasePage page = new BasePage(AppiumConfig.getDriver());

    @Given("la app esta abierta")
    public void laAppEstaAbierta() {
        log.info("App is open");
    }

    @When("realizo una accion")
    public void realizoUnaAccion() {
        log.info("Performing an action");
    }

    @Then("veo el resultado esperado")
    public void veoElResultadoEsperado() {
        log.info("Verifying result");
    }
}

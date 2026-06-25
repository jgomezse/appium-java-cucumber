package com.appium.steps;

import com.appium.config.AppiumConfig;
import com.appium.pages.LoginPage;
import com.appium.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private static final Logger log = LogManager.getLogger(LoginSteps.class);
    private final LoginPage login = new LoginPage(AppiumConfig.getDriver());
    private final ProductsPage products = new ProductsPage(AppiumConfig.getDriver());

    @When("inicio sesion")
    public void login() {
        login.write(login.getUsernameInput(), "standard_user");
        login.write(login.getPasswordInput(), "secret_sauce");
        login.click(login.getLoginButton());
        log.info("Login con standard_user / secret_sauce");
    }

    @When("inicio sesion con usuario bloqueado")
    public void loginLockedOut() {
        login.write(login.getUsernameInput(), "locked_out_user");
        login.write(login.getPasswordInput(), "secret_sauce");
        login.click(login.getLoginButton());
        log.info("Login con usuario bloqueado");
    }

    @When("inicio sesion con credenciales invalidas")
    public void loginInvalid() {
        login.write(login.getUsernameInput(), "usuario_invalido");
        login.write(login.getPasswordInput(), "clave_invalida");
        login.click(login.getLoginButton());
        log.info("Login con credenciales invalidas");
    }

    @When("intento iniciar sesion sin credenciales")
    public void loginEmpty() {
        login.click(login.getLoginButton());
        log.info("Intento de login sin credenciales");
    }

    @Then("veo la pantalla de productos")
    public void seeProductsScreen() {
        assertTrue(products.isDisplayed(products.getScreen()), "No se ve la pantalla de productos");
        log.info("Pantalla de productos visible");
    }

    @Then("veo un mensaje de error")
    public void seeErrorMessage() {
        assertTrue(login.isDisplayed(login.getErrorMessage()), "No se ve el mensaje de error");
        log.info("Mensaje de error visible");
    }
}

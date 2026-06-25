package com.appium.steps;

import com.appium.config.AppiumConfig;
import com.appium.pages.CartPage;
import com.appium.pages.CheckoutCompletePage;
import com.appium.pages.CheckoutInfoPage;
import com.appium.pages.CheckoutOverviewPage;
import com.appium.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompraSteps {

    private static final Logger log = LogManager.getLogger(CompraSteps.class);
    private final ProductsPage products = new ProductsPage(AppiumConfig.getDriver());
    private final CartPage cart = new CartPage(AppiumConfig.getDriver());
    private final CheckoutInfoPage checkoutInfo = new CheckoutInfoPage(AppiumConfig.getDriver());
    private final CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(AppiumConfig.getDriver());
    private final CheckoutCompletePage checkoutComplete = new CheckoutCompletePage(AppiumConfig.getDriver());

    @When("agrego el primer producto al carrito")
    public void addFirstProduct() {
        assertTrue(products.isDisplayed(products.getScreen()), "No se ve la pantalla de productos");
        products.click(products.getAddToCartButton());
        log.info("Primer producto agregado al carrito");
    }

    @When("voy al carrito")
    public void goToCart() {
        products.click(products.getCartIcon());
        assertTrue(cart.isDisplayed(cart.getScreen()), "No se ve la pantalla del carrito");
        log.info("Navegando al carrito");
    }

    @When("procedo al checkout")
    public void checkout() {
        cart.scrollToContentDesc("test-CHECKOUT");
        cart.click(cart.getCheckoutButton());
        log.info("Procediendo al checkout");
    }

    @When("ingreso datos de envio")
    public void enterShippingInfo() {
        checkoutInfo.write(checkoutInfo.getFirstNameInput(), "Juan");
        checkoutInfo.write(checkoutInfo.getLastNameInput(), "Perez");
        checkoutInfo.write(checkoutInfo.getZipInput(), "12345");
        checkoutInfo.click(checkoutInfo.getContinueButton());
        log.info("Datos de envio ingresados: Juan Perez 12345");
    }

    @When("finalizo la compra")
    public void finishPurchase() {
        assertTrue(checkoutOverview.isDisplayed(checkoutOverview.getScreen()), "No se ve pantalla de resumen");
        checkoutOverview.scrollToContentDesc("test-FINISH");
        checkoutOverview.click(checkoutOverview.getFinishButton());
        log.info("Compra finalizada");
    }

    @Then("veo el mensaje de confirmacion")
    public void verifyConfirmation() {
        assertTrue(checkoutComplete.isDisplayed(checkoutComplete.getScreen()), "No se ve pantalla de confirmacion");
        log.info("Compra completada exitosamente");
    }
}

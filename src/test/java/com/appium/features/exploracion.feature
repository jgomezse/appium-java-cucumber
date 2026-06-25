@exploracion
Feature: Exploración de localizadores
    Inspeccionar atributos reales de cada pantalla via deep links

    Scenario: Login screen
        Given la app esta abierta
        When navego a la url "swaglabs://"
        And espero que cargue la pantalla
        And capturo page source de "00-login.xml"

    Scenario: Productos
        Given la app esta abierta
        When navego a la url "swaglabs://swag-overview"
        And espero que cargue la pantalla
        And capturo page source de "01-productos.xml"

    Scenario: Detalle de producto
        Given la app esta abierta
        When navego a la url "swaglabs://swag-item/0"
        And espero que cargue la pantalla
        And capturo page source de "02-producto-detalle.xml"

    Scenario: Carrito
        Given la app esta abierta
        When navego a la url "swaglabs://cart"
        And espero que cargue la pantalla
        And capturo page source de "03-carrito.xml"

    Scenario: Checkout info
        Given la app esta abierta
        When navego a la url "swaglabs://personal-info"
        And espero que cargue la pantalla
        And capturo page source de "04-checkout-info.xml"

    Scenario: Checkout overview
        Given la app esta abierta
        When navego a la url "swaglabs://checkout-overview"
        And espero que cargue la pantalla
        And capturo page source de "05-checkout-overview.xml"

    Scenario: Checkout complete
        Given la app esta abierta
        When navego a la url "swaglabs://complete"
        And espero que cargue la pantalla
        And capturo page source de "06-checkout-complete.xml"

    Scenario: Drawing
        Given la app esta abierta
        When navego a la url "swaglabs://drawing"
        And espero que cargue la pantalla
        And capturo page source de "07-drawing.xml"

    Scenario: Geo Location
        Given la app esta abierta
        When navego a la url "swaglabs://geo-location"
        And espero que cargue la pantalla
        And capturo page source de "08-geo-location.xml"

    Scenario: QR Code Scanner
        Given la app esta abierta
        When navego a la url "swaglabs://qr-code"
        And espero que cargue la pantalla
        And capturo page source de "09-qr-code.xml"

    Scenario: Webview Selection
        Given la app esta abierta
        When navego a la url "swaglabs://webview"
        And espero que cargue la pantalla
        And capturo page source de "10-webview.xml"

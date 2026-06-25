@smoke @compra
Feature: Flujo de compra

    Scenario: Compra exitosa
        Given la app esta abierta
        When inicio sesion
        And agrego el primer producto al carrito
        And voy al carrito
        And procedo al checkout
        And ingreso datos de envio
        And finalizo la compra
        Then veo el mensaje de confirmacion

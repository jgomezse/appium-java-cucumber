@smoke @login
Feature: Login

    Scenario: Login exitoso
        Given la app esta abierta
        When inicio sesion
        Then veo la pantalla de productos

    Scenario: Usuario bloqueado
        Given la app esta abierta
        When inicio sesion con usuario bloqueado
        Then veo un mensaje de error

    Scenario: Credenciales invalidas
        Given la app esta abierta
        When inicio sesion con credenciales invalidas
        Then veo un mensaje de error

    Scenario: Campos vacios
        Given la app esta abierta
        When intento iniciar sesion sin credenciales
        Then veo un mensaje de error
